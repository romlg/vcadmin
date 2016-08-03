<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
    <!--START HEADER -->
    <table border="0" cellpadding="0" cellspacing="0" width="1000">
        <tr bgcolor="#EEEEEE">
            <td align="left" width="200">
                <img id="ctl00_imgLogo" src="/images/logo.png" style="border-width:0px;"/>
            </td>
            <td align="center">
                <span style="font-size: 18px; font-weight: bold;">V-Cash Administration Account</span>
            </td>
            <td align="right" width="500">
                <div id="clockbox" style="margin-right: 5px; font-size: 18px; font-weight: bold;">
                </div>
                    <span style="margin-right: 5px; font-size: 14px; font-weight: bold; color: Green"><span
                            id="ctl00_lblLoggedinUser">Welcome <%=SecurityContextHolder.getContext().getAuthentication().getName()%></span></span>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <!-- START MENU -->
                <div id="sample1" class="sampleTabContent">
                    <ul id="sample-menu-1" class="sf-menu">

                        <li class="current"><a href="#">Site Management</a>
                            <ul>

                                <li>
                                    <a id="ctl00_hlinkCreateNewUser" href="/admin/accounts/AddNewUser">Add New
                                        User</a></li>
                                <li>
                                    <a id="ctl00_hlnkUsers" href="/admin/accounts/ListUsers">Manage Users</a></li>

                                <li>
                                    <a id="ctl00_hlnkInternalAccounts" href="/admin/accounting/InternalAccounts">Internal
                                        Accounting Accounts</a></li>
                            </ul>
                        </li>

                        <li class="current"><a href="#">Customer Service</a>
                            <ul>
                                <li>
                                    <a id="ctl00_hlinkSearch" href="/admin/SearchMembers">Name Check</a></li>

                                <li>
                                    <a id="ctl00_hlinkCashTransfer" href="/admin/VCashTransfer">V-Cash Transfer</a>
                                </li>

                                <li>
                                    <a id="ctl00_hlinkDupVcashAccounts"
                                       href="/admin/accounting/ViewFacsimileAccounts">View
                                        Duplicate V-Cash Accounts</a>
                                </li>

                                <li>
                                    <a id="ctl00_hlinkRestoreAccounts"
                                       href="/admin/accounting/RestoreFacsimileAccounts">Restore
                                        V-Cash Accounts</a>
                                </li>
                                <li>
                                    <a id="ctl00_hlinkCreateVcashAccounts"
                                       href="/admin/accounting/CreateVCashAccounts">Create
                                        V-Cash Accounts</a>
                                </li>
                                <li>
                                    <a id="ctl00_hlinkNegativeBalances"
                                       href="/admin/accounting/NegativeBalanceAccounts">Negative
                                        Balance V-Cash Accounts</a>
                                </li>
                                <li>
                                    <a id="ctl00_hlinkAccessLog" href="/admin/systemOptions/AccessLog">Access
                                        Log</a>
                                </li>

                                <li>
                                    <a id="ctl00_hlinkMemberProfiles"
                                       href="/admin/eWallet/MemberProfileInformations">Member Profile
                                        Information</a>
                                </li>
                                <li>
                                    <a id="ctl00_hlinkMemberMismatchData" href="/admin/accounting/MemberData">Members
                                        Mismatched
                                        Data</a>
                                </li>

                                <li>
                                    <a id="ctl00_hlinkAnnouncements" href="/admin/systemOptions/Announcements">Manage
                                        Announcements</a></li>

                            </ul>
                        </li>

                        <li><a href="#">Accounting</a>
                            <ul>
                                <li>
                                    <a id="ctl00_hlinkVCredit" href="VCreditSummary">V-Credit Summary IM</a>
                                </li>
                                <li>
                                    <a id="ctl00_hlinkByAccount" href="/admin/reports/shells/TransactionListShell">Transactions
                                        By Member
                                        Id</a>
                                </li>
                                <li>
                                    <a id="ctl00_hlinkByGroup" href="/admin/reports/shells/SummaryByGroupShell">V-Credit
                                        Summary By Group</a>
                                </li>
                                <li>
                                    <a id="ctl00_hlinkSummary"
                                       href="/admin/reports/shells/VCashPurchaseSummaryShell">V-Cash Purchase
                                        Summary(old)</a>
                                </li>
                                <li>
                                    <a id="ctl00_hlinkNewSummary"
                                       href="/admin/reports/shells/VCashPurchaseSummaryNewShell">V-Cash Purchase
                                        Summary</a>
                                </li>
                                <li>
                                    <a id="ctl00_hlinkEWallet" href="/admin/reports/shells/EWalletFundsInfoShell">E-Wallet
                                        Funds Report By Request Date</a>
                                </li>
                                <li>
                                    <a id="ctl00_hlinkEWalletFundDate"
                                       href="/admin/reports/shells/EWalletFundsInfoByFundedDateShell">E-Wallet
                                        Funds Report By Fund Date</a>
                                </li>
                                <li>
                                    <a id="ctl00_hlinkMonthEnd" href="/admin/reports/shells/MonthEndBalanceShell">Month
                                        End Balance Report</a>
                                </li>
                            </ul>
                        </li>

                        <li><a href="#">eWallet</a>
                            <ul>

                                <li>
                                    <a id="ctl00_hlinkDailyLoad" href="/admin/eWallet/DailyLoad">Daily Load</a>
                                </li>

                                <li>
                                    <a id="ctl00_hlinkEWalletLoadBatches" href="/admin/eWallet/EWaletBatches">eWallet
                                        Load Batches</a>
                                </li>
                                <li>
                                    <a id="ctl00_hlinkPurchaase" href="/admin/eWallet/Purchase">eWallet
                                        Purchase</a></li>
                                <li>
                                    <a id="ctl00_hlinkFund" href="/admin/eWallet/FundReport">eWallet Fund
                                        Report</a></li>
                                <li>
                                    <a id="ctl00_hlinkCardCredit" href="/admin/eWallet/CardCreditResponse">Card
                                        Credit</a></li>
                                <li>
                                    <a id="ctl00_hlinkDailyLoadReport"
                                       href="/admin/reports/shells/EWalletDailyLoadShell">eWallet DailyLoad and
                                        Pending Account Summary Report</a>
                                </li>

                                <li>
                                    <a id="ctl00_hlinkDailyLoadRpt" href="/admin/eWallet/DailyLoadReport">Daily
                                        Load Changes</a>
                                </li>

                                <li>
                                    <a id="ctl00_hlinkCreateAccount" href="/admin/eWallet/CreateAccountView">Create
                                        Accounts</a></li>

                                <li>
                                    <a id="ctl00_hlinkCardProcessing" href="/admin/eWallet/CreateAccountResponse">Card
                                        Processing</a></li>

                            </ul>
                        </li>

                        <li><a href="#">Prepaid Card</a>
                            <ul>
                                <li>
                                    <a id="ctl00_hlinkImportCard" href="/admin/eWallet/CardProcess">Import Card
                                        Data</a></li>
                                <li>
                                    <a id="ctl00_hlinkCardTracking" href="/admin/eWallet/CardTracking">Card
                                        Tracking</a></li>
                                <li>
                                    <a id="ctl00_hlinkCardProcess" href="/admin/eWallet/CardProcessing">Card
                                        Process Lookup</a></li>

                            </ul>
                        </li>

                        <li><a href="#">Reports</a>
                            <ul>

                                <li>
                                    <a id="ctl00_hlinkCollectedFee" href="/admin/reports/shells/CollectedFeeShell">Collected
                                        Fee Report</a></li>

                                <li>
                                    <a id="ctl00_hlinkVCashPurchase"
                                       href="/admin/reports/shells/VCashPurchaseShell">V-Cash Purchase Report</a>
                                </li>
                                <li>
                                    <a id="ctl00_hlinkIMCVCash" href="/admin/reports/shells/IMCVCashShell">IMC
                                        VCash Cash-Out Report</a></li>
                                <li>
                                    <a id="ctl00_hlinkMemberInfo" href="/admin/members/LegalInfoVerification">Verify
                                        Member Info</a></li>
                            </ul>
                        </li>

                        <li>
                            <a id="ctl00_hLinkChangePassword" href="/admin/accounts/ChangePassword">Change
                                Password</a></li>
                        <li><a id="ctl00_hLinkLogout" href="/logout">Logout</a></li>
                    </ul>
                </div>
            </td>
        </tr>
    </table>
</div>