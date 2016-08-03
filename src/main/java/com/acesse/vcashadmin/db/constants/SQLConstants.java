package com.acesse.vcashadmin.db.constants;

public class SQLConstants {
    public static final String DUP_ACCOUNTS_DISPLAY_QUERY = "SELECT" +
            " acc.Affid," +
            "acc.AcctId AS VCashNumber," +
            "acc.AcctName," +
            " ina.FirstName," +
            " ina.LastName," +
            "ina.secureInfo," +
            "acc.AcctStatusDate," +
            " acc.groupID," +
            " (select count(*) transactionCount from tblArTransDetail where acctid=acc.acctid) TransCount," +
            "ina.email " +
            "FROM tblArAccounts acc " +
            "LEFT JOIN iNetAffiliates ina ON ina.AffID = acc.Affid  " +
            "LEFT JOIN tblArTransDetail tr ON tr.acctid = acc.AcctId  " +
            "WHERE acc.groupID = 32 AND acc.Affid IN (" +
            " SELECT affid FROM (" +
            " SELECT affid, COUNT(*) as C " +
            "FROM tblArAccounts " +
            "WHERE groupId = 32 GROUP BY affid HAVING COUNT(*)>1 ) ac_count ) " +
            "AND  AcctStatusDate between ? and ? GROUP BY acc.AcctId ORDER BY acc.Affid desc;";

    public static final String DUP_ACCOUNTS_WITHAFFID_QUERY = "SELECT " +
            "acc.Affid" +
            ",acc.AcctId AS VCashNumber," +
            "acc.AcctName," +
            " ina.FirstName," +
            " ina.LastName," +
            "ina.secureInfo," +
            "acc.AcctStatusDate," +
            " acc.groupID," +
            "(select count(*) transactionCount from tblArTransDetail where acctid=acc.acctid) TransCount," +
            "ina.email " +
            "FROM tblArAccounts acc " +
            "LEFT JOIN iNetAffiliates ina ON ina.AffID = acc.Affid  " +
            "LEFT JOIN tblArTransDetail tr ON tr.acctid = acc.AcctId  " +
            "WHERE acc.groupID = 32 " +
            "AND acc.Affid IN (" +
            " SELECT affid FROM (" +
            " SELECT affid, COUNT(*) as C FROM tblArAccounts " +
            "WHERE groupId = 32 GROUP BY affid HAVING  COUNT(*)>1 ) ac_count ) " +
            "AND  AcctStatusDate between ? and ? and acc.Affid=? GROUP BY acc.AcctId ORDER BY acc.Affid desc;";

    public static final String RESTORE_ACCOUNTS_DISPLAY_QUERY = "SELECT" +
            " acc.Affid," +
            "acc.AcctId AS VCashNumber," +
            "acc.AcctName," +
            " ina.FirstName," +
            " ina.LastName," +
            "ina.secureInfo," +
            "acc.AcctStatusDate," +
            " acc.groupID," +
            "ina.email " +
            "FROM tblArAccounts_VCSH321 acc " +
            "LEFT JOIN iNetAffiliates_VCSH321 ina ON ina.AffID = acc.Affid " +
            "where acc.AcctStatusDate between ? and ? GROUP BY acc.AcctId ORDER BY acc.Affid desc;";

    public static final String RESTORE_ACCOUNTS_WITHAFFID_QUERY = "SELECT" +
            " acc.Affid," +
            "acc.AcctId AS VCashNumber," +
            "acc.AcctName," +
            " ina.FirstName," +
            " ina.LastName," +
            "ina.secureInfo," +
            "acc.AcctStatusDate," +
            " acc.groupID," +
            "ina.email " +
            "FROM tblArAccounts_VCSH321 acc " +
            "LEFT JOIN iNetAffiliates_VCSH321 ina ON ina.AffID = acc.Affid " +
            "where acc.AcctStatusDate between ? and ? and acc.Affid = ? GROUP BY acc.AcctId ORDER BY acc.Affid desc;";

    public static final String CREATEVCASH_ACCOUNTS_DISPLAY_QUERY = "select" +
            " m.member_id," +
            "m.email," +
            " m.first_name," +
            " m.last_name," +
            " m.proc_account_id," +
            " mi.li_verify_date," +
            "m.reg_date," +
            " mi.legal_status " +
            "from members m, member_info mi " +
            "where m.member_id=mi.member_id " +
            "and mi.legal_status=2 " +
            "and (m.proc_account_id is null or m.proc_account_id = 0 ) " +
            "and (mi.li_verify_date is not null ) " +
            "and (mi.li_staff_id is not null) " +
            "and (m.reg_date between ? and ? ) order by m.member_id desc;";

    public static final String CREATEVCASH_ACCOUNTS_WITHMEMBERID_QUERY = "select" +
            " m.member_id," +
            "m.email," +
            " m.first_name," +
            " m.last_name," +
            " m.proc_account_id," +
            " mi.li_verify_date," +
            "m.reg_date," +
            " mi.legal_status " +
            "from members m, member_info mi " +
            "where m.member_id=mi.member_id " +
            "and mi.legal_status=2 " +
            "and (m.proc_account_id is null or m.proc_account_id = 0 ) " +
            "and (mi.li_verify_date is not null ) " +
            "and (mi.li_staff_id is not null) " +
            "and (m.reg_date between ? and ?)" +
            " and (m.member_id = ?) order bym.member_id desc;";

    public static final String NEGATIVE_ACCOUNTS_QUERY = "select" +
            " ac.acctid vcashnumber," +
            " ac.affid memberid," +
            " sum(Amt) balance " +
            "from tblArAccounts ac, tblArTransDetail trans " +
            "where ac.acctid in (" +
            "select acctid from (" +
            "select sum(Amt) balance, acctid from tblArTransDetail " +
            "where acctid in (" +
            "select acctid  from tblArTransDetail " +
            "where tDate > ? and tDate <= ? " +
            "and acctid not in (95000, 472156,472157,91000)) group by acctid) balance_table " +
            "where balance < -1 ) " +
            "and trans.acctid = ac.acctid  group by trans.acctid;";

    public static final String NEGATIVE_ACCOUNTS_WITHAFFID_QUERY = "select" +
            " ac.acctid vcashnumber," +
            " ac.affid memberid," +
            " sum(Amt) balance " +
            "from tblArAccounts ac, tblArTransDetail trans " +
            "where ac.acctid in (" +
            "select acctid from (" +
            "select sum(Amt) balance,acctid " +
            "from tblArTransDetail " +
            "where acctid in (" +
            "select acctid  " +
            "from tblArTransDetail " +
            "where tDate > ? and tDate <= ? " +
            "and acctid not in (95000, 472156,472157,91000)) group by acctid) " +
            "balance_table where balance < -1 ) " +
            "and trans.acctid = ac.acctid and ac.Affid  = ? group by trans.acctid;";

    public static final String DUP_ACCOUNTS_GENRIC_TBLARACCOUNTS_SELECT = "select count(*) from %1$s where %2$s = '%3$s' and %4$s = '%5$s';";
    public static final String DUP_ACCOUNTS_AFFIDCASING_COLUMN = "Affid";
    public static final String DUP_ACCOUNTS_ACCDIDCOLUMN = "AcctId";
    public static final String DUP_ACCOUNTS_ACCINSERT = "Insert into %1$s select * from %2$s where %3$s = '%4$s' and %5$s = '%6$s' ;";
    public static final String DUP_ACCOUNTS_GENRICINSERT = "Insert into %1$s select * from %2$s where %3$s = '%4$s' ;";
    public static final String DUP_ACCOUNTS_ACCDELETE = "delete from %1$s where %2$s = '%3$s' and %4$s = '%5$s' ;";
    public static final String DUP_ACCOUNTS_GENRICDELETE = "delete from %1$s where %2$s = '%3$s' ;";
    public static final String DUP_ACCOUNTS_GENRICSELECT = "select count(*) from %1$s where %2$s = '%3$s' ;";
    public static final String DUP_ACCOUNTS_TBLARACCOUNTS = "tblArAccounts";
    public static final String DUP_ACCOUNTS_TBLARACCOUNTS321 = "tblArAccounts_VCSH321";
    public static final String DUP_ACCOUNTS_TBLARTRANS = "tblArTrans";
    public static final String DUP_ACCOUNTS_TBLARTRANS321 = "tblArTrans_VCSH321";
    public static final String DUP_ACCOUNTS_TBLINETAFFILIATES = "iNetAffiliates";
    public static final String DUP_ACCOUNTS_TBLINETAFFILIATES321 = "iNetAffiliates_VCSH321";
    public static final String DUP_ACCOUNTS_TBLTRANSSECURITY = "tblTransSecurity";
    public static final String DUP_ACCOUNTS_TBLTRANSSECURITY321 = "tblTransSecurity_VCSH321";
    public static final String DUP_ACCOUNTS_TBLSECURITY = "tblSecurity";
    public static final String DUP_ACCOUNTS_TBLSECURITY321 = "tblSecurity_VCSH321";
    public static final String DUP_ACCOUNTS_ACCDIDCASING_COLUMN = "acctid";
    public static final String DUP_ACCOUNTS_AFFIDCOLUMN = "AffID";
    public static final String COLUMN_SECUREINFO = "secureInfo";
    public static final String VCASH_ACCOUNTS_ISVALID_QUERY = "SELECT tblArAccounts.AcctStatus acctStatus,tblArAccounts.Affid memberId,tblArAccounts.groupid groupId, tblArAccounts.AcctId vcashaccount FROM tblArAccounts WHERE tblArAccounts.AcctId in (?,?); ";
}
