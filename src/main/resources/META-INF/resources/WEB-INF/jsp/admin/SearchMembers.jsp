<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="/WEB-INF/jsp/inc/header.jsp"/>

<body>

<form:form name="aspnetForm" method="post" action="SearchMembers" id="aspnetForm" class="cssform">

    <script type="text/javascript">
        var theForm = document.forms['aspnetForm'];
        if (!theForm) {
            theForm = document.aspnetForm;
        }
        function doPost() {
            theForm.submit();
        }
        function checkFields() {
            var Reg_NumberFormat = new RegExp('^\\d+$');
            var Reg_EmailFormat = new RegExp(/^[_\.0-9a-zA-Z-]+@([0-9a-zA-Z][0-9a-zA-Z-]+\.)+[a-zA-Z]{2,6}$/i);
            var Reg_DateFormat = new RegExp(/^\d{4}\-\d{2}\-\d{2}$/);
            var MID_Len = FnTrim(document.getElementById('ctl00_mainContent_txtMemberID').value).length;
            var FNAME_Len = FnTrim(document.getElementById('ctl00_mainContent_txtFirstName').value).length;
            var LNAME_Len = FnTrim(document.getElementById('ctl00_mainContent_txtLastName').value).length;
            var VCN_Len = FnTrim(document.getElementById('ctl00_mainContent_txtVCashNumber').value).length;
            var EMAIL_Len = FnTrim(document.getElementById('ctl00_mainContent_txtEmail').value).length;
            var SGNDATE_Len = FnTrim(document.getElementById('ctl00_mainContent_txtSignUpDate').value).length;
            var TRANSNUM_Len = FnTrim(document.getElementById('ctl00_mainContent_txtTransNumber').value).length;
            var GROUP_Value = document.getElementById("ctl00_mainContent_ddlGroup");
            var DDLGRP = FnTrim(GROUP_Value.options[GROUP_Value.selectedIndex].value);
            var STATUS_Value = document.getElementById("ctl00_mainContent_ddlMemberStatus");
            var DDLSTATUS = FnTrim(STATUS_Value.options[STATUS_Value.selectedIndex].value);

            if (MID_Len == 0 && FNAME_Len == 0 && LNAME_Len == 0 && LNAME_Len == 0 && VCN_Len == 0
                    && EMAIL_Len == 0 && SGNDATE_Len == 0 && TRANSNUM_Len == 0 && ((DDLGRP == '32' && DDLSTATUS == '1') || (DDLGRP == '-1' && DDLSTATUS == '-1')
                    || (DDLGRP == '-1' && DDLSTATUS == '5') || (DDLGRP == '-1' && DDLSTATUS == '1') || (DDLGRP == '32' && DDLSTATUS == '-1'))) {
                alert('Selected search criteria has lakhs of records it will take more time.please change the search criteria.');
                return false;
            }

            if (MID_Len > 0 || VCN_Len > 0 || TRANSNUM_Len > 0) {
                if (!FnTrim(document.getElementById('ctl00_mainContent_txtMemberID').value).match(/^[-]?\d*\.?\d*$/)) {
                    alert('Please enter only numbers in Member ID');
                    document.getElementById('ctl00_mainContent_txtMemberID').focus();
                    return false;
                }

                if (!FnTrim(document.getElementById('ctl00_mainContent_txtVCashNumber').value).match(/^[-]?\d*\.?\d*$/)) {
                    alert('Please enter only numbers in V-CASH Number');
                    document.getElementById('ctl00_mainContent_txtVCashNumber').focus();
                    return false;
                }

                if (!FnTrim(document.getElementById('ctl00_mainContent_txtTransNumber').value).match(/^[-]?\d*\.?\d*$/)) {
                    alert('Please enter only numbers in Transaction Number');
                    document.getElementById('ctl00_mainContent_txtTransNumber').focus();
                    return false;
                }
            }
            if (SGNDATE_Len > 0) {
                if (!Reg_DateFormat.test(FnTrim(document.getElementById('ctl00_mainContent_txtSignUpDate').value))) {
                    alert('Please select a valid Sign-Up Date.');
                    return false;
                }
            }
            doPost();
            return true;
        }
        function FnTrim(x) {
            return x.replace(/^\s+|\s+$/gm, '');
        }
    </script>
    <!-- START CENTER DIV ALIGNMENT -->
    <jsp:include page="/WEB-INF/jsp/inc/menu.jsp"/>
    <!-- Main Area -->
    <div class="mainContainer">

        <h2 style="margin: 10px;">
            Admin - NAME CHECK</h2>
        <div id="ctl00_mainContent_pnlSearch">

            <table class="searchtable" cellspacing="0" cellpadding="4">
                <tr>
                    <th colspan="5">
                        <span style="color: #FFF; font-weight: bold; text-align: left;">Member Search</span>
                    </th>
                </tr>
                <tr>
                    <td>
                        <label for="ctl00_mainContent_txtMemberID" id="ctl00_mainContent_lblMemberID" class="label">Member
                            ID:</label>
                    </td>
                    <td class="left">
                        <input name="ctl00$mainContent$txtMemberID" type="text" maxlength="8"
                               id="ctl00_mainContent_txtMemberID" class="textEntry" style="width:100px;"/>
                    </td>
                    <td class="tdgap">
                        &nbsp;
                    </td>
                    <td>
                        <label for="ctl00_mainContent_txtVCashNumber" id="ctl00_mainContent_lblVCashNumber"
                               class="label">V-CASH Number:</label>
                    </td>
                    <td class="left">
                        <input name="ctl00$mainContent$txtVCashNumber" type="text" maxlength="8"
                               id="ctl00_mainContent_txtVCashNumber" class="textEntry" style="width:100px;"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="ctl00_mainContent_txtFirstName" id="ctl00_mainContent_lblFirstName" class="label">First
                            Name:</label>
                    </td>
                    <td class="left">
                        <input name="ctl00$mainContent$txtFirstName" type="text" maxlength="25"
                               id="ctl00_mainContent_txtFirstName" class="textEntry" style="width:150px;"/>
                    </td>
                    <td class="tdgap">
                        &nbsp;
                    </td>
                    <td>
                        <label for="ctl00_mainContent_txtLastName" id="ctl00_mainContent_lblLastName" class="label">Last
                            Name:</label>
                    </td>
                    <td class="left">
                        <input name="ctl00$mainContent$txtLastName" type="text" maxlength="25"
                               id="ctl00_mainContent_txtLastName" class="textEntry" style="width:150px;"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="ctl00_mainContent_txtEmail" id="ctl00_mainContent_lblEmail" class="label">Email
                            Address:</label>
                    </td>
                    <td class="left">
                        <input name="ctl00$mainContent$txtEmail" type="text" maxlength="35"
                               id="ctl00_mainContent_txtEmail" class="textEntry" style="width:150px;"/>
                    </td>
                    <td class="tdgap">
                        &nbsp;
                    </td>
                    <td>
                        <label for="ctl00_mainContent_txtSignUpDate" id="ctl00_mainContent_lblSignUpDate" class="label">Sign-Up
                            Date:</label>
                    </td>
                    <td class="left">
                        <input name="ctl00$mainContent$txtSignUpDate" type="text" maxlength="12"
                               id="ctl00_mainContent_txtSignUpDate" class="textEntry" style="width:100px;"/>

                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="ctl00_mainContent_txtTransNumber" id="ctl00_mainContent_lblTransactionNumber"
                               class="label">Transaction Number:</label>
                    </td>
                    <td class="left">
                        <input name="ctl00$mainContent$txtTransNumber" type="text" maxlength="10"
                               id="ctl00_mainContent_txtTransNumber" class="textEntry" style="width:100px;"/>
                    </td>
                    <td class="tdgap">
                        &nbsp;
                    </td>
                    <td>
                        <label for="ctl00_mainContent_ddlMemberStatus" id="ctl00_mainContent_lblStatus" class="label">Member
                            Status:</label>
                    </td>
                    <td class="left">
                        <select name="ctl00$mainContent$ddlMemberStatus" id="ctl00_mainContent_ddlMemberStatus">
                            <option value="-1">All</option>
                            <option selected="selected" value="1">Active</option>
                            <option value="0">In-Active</option>
                            <option value="5">Suspended</option>

                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="ctl00_mainContent_ddlGroup" id="ctl00_mainContent_lblGroup" class="label">Member
                            Group:</label>
                    </td>
                    <td class="left">
                        <select name="ctl00$mainContent$ddlGroup" id="ctl00_mainContent_ddlGroup">
                            <option value="-1">All</option>
                            <option value="1">CashCard International Member</option>
                            <option value="2">Global Pay System Member</option>
                            <option value="6">Synergy Member</option>
                            <option value="7">Speedy Money Member</option>
                            <option value="8">CashCard Hawaii Member</option>
                            <option value="10">Dolphin Member</option>
                            <option value="11">First Global Foundation</option>
                            <option value="14">Shawkey Member</option>
                            <option value="15">WCS Member</option>
                            <option value="19">Universal Bank Member</option>
                            <option value="23">Indocash Member</option>
                            <option value="25">GAS Member</option>
                            <option value="27">MexBank Member</option>
                            <option value="28">MoneyCard Member</option>
                            <option value="29">Techs4Success Member</option>
                            <option value="30">Japan Member</option>
                            <option value="31">TAC Member</option>
                            <option selected="selected" value="32">iNetGlobal Member</option>

                        </select>
                    </td>
                    <td class="tdgap">
                        &nbsp;
                    </td>
                    <td>
                        <label for="ctl00_mainContent_ddlGroup" id="ctl00_mainContent_lblExactSearch" class="label">Exact
                            Search:</label>
                    </td>
                    <td class="left">
                        <input id="ctl00_mainContent_chkExactSearch" type="checkbox"
                               name="ctl00$mainContent$chkExactSearch" checked="checked"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="5" align="right">
                        <input type="submit" name="ctl00$mainContent$btnSubmit" value="Search"
                               onclick="return checkFields();" id="ctl00_mainContent_btnSubmit"
                               class="button_blue"/>
                    </td>
                </tr>
            </table>
        </div>
        <div id="ctl00_mainContent_pnlUpdate">
            <c:if test="${show}">
                <div>
                    <table class="mGrid" cellspacing="0" cellpadding="0" rules="rows" border="1"
                           id="ctl00_mainContent_grdSearchResult" style="width:100%;border-collapse:collapse;">
                        <tbody>
                        <c:choose>
                            <c:when test="${avail}">
                                <tr align="left" valign="middle">
                                    <th scope="col">Member ID</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">First Name</th>
                                    <th scope="col">Last Name</th>
                                    <th scope="col">V-CASH Account</th>
                                    <th scope="col">Email</th>
                                </tr>
                                <c:forEach items="${data}" var="minfo" varStatus="loopStatus">
                                    <tr class="${loopStatus.index % 2 == 0 ? '' : 'alt'}">
                                        <td align="center" valign="middle" style="width:7%;"><a
                                                href="MemberDetail?id=<c:out value="${minfo.affiliateId}"/>&amp;vcid=<c:out value="${minfo.vcashNumber}"/>"><c:out
                                                value="${minfo.affiliateId}"/></a></td>
                                        <td align="center" valign="middle" style="width:7%;white-space:nowrap;"><c:out
                                                value="${minfo.status}"/></td>
                                        <td align="center" valign="middle" style="width:25%;"><c:out
                                                value="${minfo.firstName}"/></td>
                                        <td align="center" valign="middle" style="width:25%;"><c:out
                                                value="${minfo.lastNAme}"/></td>
                                        <td align="center" valign="middle" style="width:7%;"><c:out
                                                value="${minfo.vcashNumber}"/></td>
                                        <td align="center" valign="middle" style="width:30%;"><c:out
                                                value="${minfo.email}"/></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td>
                                        <span style="margin-right: 5px; font-size: 15px; font-weight: bold; color: red;">No Records Found.</span>
                                    </td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                </div>
            </c:if>

        </div>
    </div>
</form:form>
<jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>
<!-- END CENTER DIV ALIGNMENT -->
</body>
</html>
