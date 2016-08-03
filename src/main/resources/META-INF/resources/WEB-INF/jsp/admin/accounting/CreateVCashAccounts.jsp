<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="/WEB-INF/jsp/inc/header.jsp"/>

<body>

<form:form name="aspnetForm" method="post" action="CreateVCashAccounts" id="aspnetForm" class="cssform">
<!-- START CENTER DIV ALIGNMENT -->
<jsp:include page="/WEB-INF/jsp/inc/menu.jsp"/>
<!-- Main Area -->
<div class="mainContainer">

    <div id="ctl00_mainContent_CFSValidationSummary" style="color:Red;display:none;">

    </div>
    <c:if test="${!avail}">
    <textarea name="ctl00$mainContent$lblErrors" rows="2" cols="20" readonly="readonly" id="ctl00_mainContent_lblErrors"
              disabled="disabled"
              style="color:Red;border-style:None;font-weight:bold;height:86px;width:995px;resize:none">No Records found.</textarea>
    </c:if>
    <table class="searchtable" cellspacing="0" cellpadding="4">
        <tr>
            <th colspan="5">
                <span style="color: #FFF; font-weight: bold; text-align: left;">Create V-Cash Accounts</span>
            </th>
        </tr>
        <tr>
            <td colspan="5" class="left">
                <span style="color: #000; font-weight: bold; text-align: left;">This option is used for the members to create V-Cash account, those who are not having V-Cash accounts when their legal information is already verified.</span>
            </td>
        </tr>
        <tr>
            <td>
                <label for="ctl00_mainContent_txtStartDate" id="ctl00_mainContent_lblStartDate" class="label">User
                    Register Start Date:</label>
            </td>
            <td class="left">
                <input name="ctl00$mainContent$txtStartDate" type="text" value="2016-05-06" maxlength="12"
                       id="ctl00_mainContent_txtStartDate" class="textEntry" style="width:100px;"/>

                <span id="ctl00_mainContent_rfvCFSStartDate" style="color:Red;visibility:hidden;">*</span>
                <span id="ctl00_mainContent_cvCFStartDate" style="color:Red;visibility:hidden;">*</span>
            </td>
            <td>
                <label for="ctl00_mainContent_txtEndDate" id="ctl00_mainContent_lblEndDate" class="label">User
                    Register End Date:</label>
            </td>
            <td class="left">
                <input name="ctl00$mainContent$txtEndDate" type="text" value="2016-06-06" maxlength="12"
                       id="ctl00_mainContent_txtEndDate" class="textEntry" style="width:100px;"/>

                <span id="ctl00_mainContent_rfvCFSEndDate" style="color:Red;visibility:hidden;">*</span>
                <span id="ctl00_mainContent_cvCFShell" style="color:Red;visibility:hidden;">*</span>
            </td>
        </tr>
        <tr>
            <td>
                <label for="ctl00_mainContent_txtMemberId" id="ctl00_mainContent_lblMemberId" class="label">Member
                    ID:</label>
            </td>
            <td class="left">
                <input name="ctl00$mainContent$txtMemberId" type="text" maxlength="8"
                       id="ctl00_mainContent_txtMemberId" class="textEntry" style="width:100px;"/>
                    <span id="ctl00_mainContent_revCFSMemberid" title="Please enter only numbers in Member ID."
                          class="failureNotification" style="color:Red;visibility:hidden;">*</span>
            </td>
            <td colspan="2"></td>
            <td align="right">
                <input type="submit" name="ctl00$mainContent$btnSearch" value="Search"
                       id="ctl00_mainContent_btnSearch" class="button_blue"/>
            </td>
        </tr>
    </table>
    <c:if test="${show}">
    <div id="ctl00_mainContent_pnlVCashAccountsView" class="panel" style="overflow:auto;">
        <div>
            <table class="searchtable" cellspacing="0" cellpadding="4">
                <tr>
                    <td class="left">
                            <span id="ctl00_mainContent_lblTotalNoOfRecords"
                                  class="label">Total number of records = <c:out value="${count}"/> .</span>
                    </td>
                    <td class="right">
                        <input type="submit" name="ctl00$mainContent$btnExport" value="Export All Accounts"
                               id="ctl00_mainContent_btnExport" class="button_blue"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div>
                            <table class="mGrid" cellspacing="0" cellpadding="3" rules="rows" border="1"
                                   id="ctl00_mainContent_gvVCashAccountsView"
                                   style="width:100%;border-collapse:collapse;">
                                <tr>
                                    <th scope="col">
                                        <input id="ctl00_mainContent_gvVCashAccountsView_ctl01_chkParent"
                                               type="checkbox"
                                               name="ctl00$mainContent$gvVCashAccountsView$ctl01$chkParent"/>
                                    </th>
                                    <th scope="col">Member Id</th>
                                    <th scope="col">V-Cash Number</th>
                                    <th scope="col">First Name</th>
                                    <th scope="col">Last Name</th>
                                    <th scope="col">E-Mail</th>
                                    <th scope="col">legal Status Id</th>
                                </tr>
                                <c:forEach items="${data}" var="vfa" varStatus="loopStatus">
                                    <tr class="${loopStatus.index % 2 == 0 ? '' : 'alt'}">
                                        <td align="center" valign="top" style="white-space:nowrap;">
                                            <input id="ctl00_mainContent_gvVCashAccountsView_ct<c:out value="${vfa.acctId}"/>_chkAccount"
                                                   type="checkbox"
                                                   name="ctl00$mainContent$gvVCashAccountsView$ct<c:out value="${vfa.acctId}"/>$chkAccount"/>
                                        </td>
                                        <td align="left" valign="top"><c:out value="${vfa.affId}"/></td>
                                        <td align="left" valign="middle" style="white-space:nowrap;"><c:out
                                                value="${vfa.acctId}"/></td>
                                        <td align="right" valign="top"><c:out value="${vfa.firstName}"/></td>
                                        <td align="left" valign="top"><c:out value="${vfa.lastName}"/></td>
                                        >
                                        <td align="left" valign="top"><c:out value="${vfa.email}"/></td>
                                        <td align="left" valign="top"><c:out value="${vfa.statusId}"/></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="right">
                        <input type="submit" name="ctl00$mainContent$btnNewVCashAccount"
                               value="Create V-Cash Account"
                               id="ctl00_mainContent_btnNewVCashAccount" class="button_blue"/>
                    </td>
                </tr>
            </table>
        </div>
        </c:if>
    </div>
    </form:form>
    <jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>
    <!-- END CENTER DIV ALIGNMENT -->
</body>
</html>
