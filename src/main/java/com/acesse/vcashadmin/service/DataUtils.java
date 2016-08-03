package com.acesse.vcashadmin.service;

import com.acesse.vcashadmin.db.constants.SQLConstants;
import com.acesse.vcashadmin.service.dto.MemberSearchDto;
import com.acesse.vcashadmin.service.dto.SearchListResult;
import com.acesse.vcashadmin.service.dto.SearchSingleResult;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Component
public class DataUtils {

    public static enum SEARCH_TYPE {
        MEMBER_SEARCH;
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String USER_AGENT = "Mozilla/5.0";


    private SessionFactory hibernateFactory;

    @Autowired
    public DataUtils(EntityManagerFactory factory) {
        if (factory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }

    public <T> SearchListResult<T> executeSearchData(String url, String json, SEARCH_TYPE searchType) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(json);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            logger.info("Sending 'POST' request to URL : " + url);
            logger.info("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            String retjson = response.toString();
            logger.info(retjson);
            if (retjson.equalsIgnoreCase("null"))
                return null;
            ObjectMapper mapper = new ObjectMapper();
            JavaType listType = null;
            JavaType singleType = null;
            switch (searchType) {
                case MEMBER_SEARCH: {
                    listType = mapper.getTypeFactory().constructParametricType(SearchListResult.class, MemberSearchDto.class);
                    singleType = mapper.getTypeFactory().constructParametricType(SearchSingleResult.class, MemberSearchDto.class);
                }
            }

            try {
                return mapper.readValue(retjson, listType);
            } catch (JsonMappingException exception) {
                SearchSingleResult<T> singleResult = mapper.readValue(retjson, singleType);
                return new SearchListResult<T>(singleResult.getSearchResult());
            }

        } catch (Exception e) {
            logger.error("Error while request", e);
            return null;
        }
    }

    public List loadTable(String sql, String... args) {
        Query q = hibernateFactory.openSession().createSQLQuery(sql);
        for (int i = 0; i < args.length; i++)
            q.setParameter(i, args[i]);
        return q.list();
    }

    public int ReadCountData(String sqlStatement, boolean Repository) {
        return loadTable(sqlStatement).size();
    }

    public void LogEmptyRows(String sql) {
        //TODO
    }

    public boolean restoreOrDeleteDuplicateAccounts(String VCashNumber, String MemberId, boolean repository, String secureInfo, String sqlQuery, int option) {
        Session session = hibernateFactory.openSession();
        Transaction t = session.beginTransaction();
        String CommandText;
        t.begin();
        try {
            if (StringUtils.isEmpty(sqlQuery)) {
                //tblaraccounts
                if (ReadCountData(String.format(SQLConstants.DUP_ACCOUNTS_GENRIC_TBLARACCOUNTS_SELECT, SQLConstants.DUP_ACCOUNTS_TBLARACCOUNTS321, SQLConstants.DUP_ACCOUNTS_AFFIDCASING_COLUMN, MemberId, SQLConstants.DUP_ACCOUNTS_ACCDIDCOLUMN, VCashNumber), false) > 0) {
                    CommandText = String.format(SQLConstants.DUP_ACCOUNTS_ACCINSERT, SQLConstants.DUP_ACCOUNTS_TBLARACCOUNTS, SQLConstants.DUP_ACCOUNTS_TBLARACCOUNTS321, SQLConstants.DUP_ACCOUNTS_AFFIDCASING_COLUMN, MemberId, SQLConstants.DUP_ACCOUNTS_ACCDIDCOLUMN, VCashNumber);
                    session.createSQLQuery(CommandText).executeUpdate();
                    CommandText = String.format(SQLConstants.DUP_ACCOUNTS_ACCDELETE, SQLConstants.DUP_ACCOUNTS_TBLARACCOUNTS321, SQLConstants.DUP_ACCOUNTS_AFFIDCASING_COLUMN, MemberId, SQLConstants.DUP_ACCOUNTS_ACCDIDCOLUMN, VCashNumber);
                    session.createSQLQuery(CommandText).executeUpdate();
                } else
                    LogEmptyRows(SQLConstants.DUP_ACCOUNTS_TBLARACCOUNTS321);

                //tblArtrans
                if (ReadCountData(String.format(SQLConstants.DUP_ACCOUNTS_GENRICSELECT, SQLConstants.DUP_ACCOUNTS_TBLARTRANS321, SQLConstants.DUP_ACCOUNTS_ACCDIDCASING_COLUMN, VCashNumber), false) > 0) {
                    CommandText = String.format(SQLConstants.DUP_ACCOUNTS_GENRICINSERT, SQLConstants.DUP_ACCOUNTS_TBLARTRANS, SQLConstants.DUP_ACCOUNTS_TBLARTRANS321, SQLConstants.DUP_ACCOUNTS_ACCDIDCASING_COLUMN, VCashNumber);
                    session.createSQLQuery(CommandText).executeUpdate();
                    CommandText = String.format(SQLConstants.DUP_ACCOUNTS_GENRICDELETE, SQLConstants.DUP_ACCOUNTS_TBLARTRANS321, SQLConstants.DUP_ACCOUNTS_ACCDIDCASING_COLUMN, VCashNumber);
                    session.createSQLQuery(CommandText).executeUpdate();
                } else
                    LogEmptyRows(SQLConstants.DUP_ACCOUNTS_TBLARTRANS321);

                //tblArTranssecurity
                if (ReadCountData(String.format(SQLConstants.DUP_ACCOUNTS_GENRICSELECT, SQLConstants.DUP_ACCOUNTS_TBLTRANSSECURITY321, SQLConstants.DUP_ACCOUNTS_ACCDIDCASING_COLUMN, VCashNumber), false) > 0) {
                    CommandText = String.format(SQLConstants.DUP_ACCOUNTS_GENRICINSERT, SQLConstants.DUP_ACCOUNTS_TBLTRANSSECURITY, SQLConstants.DUP_ACCOUNTS_TBLTRANSSECURITY321, SQLConstants.DUP_ACCOUNTS_ACCDIDCASING_COLUMN, VCashNumber);
                    session.createSQLQuery(CommandText).executeUpdate();
                    CommandText = String.format(SQLConstants.DUP_ACCOUNTS_GENRICDELETE, SQLConstants.DUP_ACCOUNTS_TBLTRANSSECURITY321, SQLConstants.DUP_ACCOUNTS_ACCDIDCASING_COLUMN, VCashNumber);
                    session.createSQLQuery(CommandText).executeUpdate();
                } else
                    LogEmptyRows(SQLConstants.DUP_ACCOUNTS_TBLTRANSSECURITY321);

                //tblSecurity
                if (ReadCountData(String.format(SQLConstants.DUP_ACCOUNTS_GENRICSELECT, SQLConstants.DUP_ACCOUNTS_TBLSECURITY321, SQLConstants.DUP_ACCOUNTS_AFFIDCASING_COLUMN, MemberId), false) > 0) {
                    CommandText = String.format(SQLConstants.DUP_ACCOUNTS_GENRICINSERT, SQLConstants.DUP_ACCOUNTS_TBLSECURITY, SQLConstants.DUP_ACCOUNTS_TBLSECURITY321, SQLConstants.DUP_ACCOUNTS_AFFIDCASING_COLUMN, MemberId);
                    session.createSQLQuery(CommandText).executeUpdate();
                    CommandText = String.format(SQLConstants.DUP_ACCOUNTS_GENRICDELETE, SQLConstants.DUP_ACCOUNTS_TBLSECURITY321, SQLConstants.DUP_ACCOUNTS_AFFIDCASING_COLUMN, MemberId);
                    session.createSQLQuery(CommandText).executeUpdate();
                } else
                    LogEmptyRows(SQLConstants.DUP_ACCOUNTS_TBLSECURITY321);

                //iNetAffiliates
                if (ReadCountData(String.format(SQLConstants.DUP_ACCOUNTS_GENRIC_TBLARACCOUNTS_SELECT, SQLConstants.DUP_ACCOUNTS_TBLINETAFFILIATES321, SQLConstants.DUP_ACCOUNTS_AFFIDCOLUMN, MemberId, SQLConstants.COLUMN_SECUREINFO, secureInfo), false) > 0) {
                    CommandText = String.format(SQLConstants.DUP_ACCOUNTS_ACCINSERT, SQLConstants.DUP_ACCOUNTS_TBLINETAFFILIATES, SQLConstants.DUP_ACCOUNTS_TBLINETAFFILIATES321, SQLConstants.DUP_ACCOUNTS_AFFIDCOLUMN, MemberId, SQLConstants.COLUMN_SECUREINFO, secureInfo);
                    session.createSQLQuery(CommandText).executeUpdate();
                    CommandText = String.format(SQLConstants.DUP_ACCOUNTS_ACCDELETE, SQLConstants.DUP_ACCOUNTS_TBLINETAFFILIATES321, SQLConstants.DUP_ACCOUNTS_AFFIDCOLUMN, MemberId, SQLConstants.COLUMN_SECUREINFO, secureInfo);
                    session.createSQLQuery(CommandText).executeUpdate();
                } else
                    LogEmptyRows(SQLConstants.DUP_ACCOUNTS_TBLINETAFFILIATES321);
            }
            t.commit();
            return true;
        } catch (Exception e) {
            logger.error("Unable to process SQL query, rolling back", e);
            t.rollback();
            return false;
        }
    }

    public Boolean ReadValidBalance(Integer inVCashNumber, Double inAmount) {
        Session session = hibernateFactory.openSession();
        Query query = session.createSQLQuery("CALL GET_BASIC_ACCOUNT_INFO(:vcashnumber)").setParameter("vcashnumber", inVCashNumber);
        List<Object[]> res = query.list();
        double requestdAmount = inAmount.doubleValue();
        for (Object[] o : res) {
            logger.info("Valid balance: " + o[1]);
            double currentAmount = Double.parseDouble(o[1].toString());
            return requestdAmount <= currentAmount;
        }
        return true;
    }
}
