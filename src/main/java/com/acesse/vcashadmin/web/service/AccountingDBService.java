package com.acesse.vcashadmin.web.service;

import com.acesse.vcashadmin.web.dto.AccountingInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Date: 29.05.16
 * Time: 14:43
 */
@Service
public class AccountingDBService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<AccountingInfoDto> getAccountingInfo() {
        StringBuilder theSql = new StringBuilder();
        theSql.append("SELECT Affid");
        theSql.append(",AcctId");
        theSql.append(",AcctName");
        theSql.append(",(SELECT SUM(Amt)");
        theSql.append(" FROM tblArTransDetail");
        theSql.append(" WHERE tblArTransDetail.acctid = tblArAccounts.AcctId) as Total_Amount");
        theSql.append(" FROM tblArAccounts");
        theSql.append(" WHERE AcctId LIKE '9%'");
        theSql.append(" ORDER BY AcctId");

        String sql = theSql.toString();
        Locale locale = new Locale("en", "US");
        DecimalFormat currencyFormatter = (DecimalFormat) NumberFormat.getCurrencyInstance(locale);
        String symbol = currencyFormatter.getCurrency().getSymbol();
        currencyFormatter.setNegativePrefix("$-"); // or "-"+symbol if that's what you need
        currencyFormatter.setNegativeSuffix("");
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Double amount = resultSet.getDouble(4);
            String color = amount <= 0 ? "Red" : "Green";

            return new AccountingInfoDto(
                    resultSet.getInt("Affid"),
                    resultSet.getInt("AcctId"),
                    currencyFormatter.format(amount),
                    resultSet.getString("AcctName"),
                    color
            );
        });
    }
}
