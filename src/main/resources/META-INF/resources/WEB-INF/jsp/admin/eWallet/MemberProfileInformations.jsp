<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="/WEB-INF/jsp/inc/header.jsp"/>

<body>
<form name="aspnetForm" method="post" action="MemberProfileInformations" id="aspnetForm" class="cssform">
    <!-- START CENTER DIV ALIGNMENT -->
    <jsp:include page="/WEB-INF/jsp/inc/menu.jsp"/>
    <!-- Main Area -->
    <div class="mainContainer">

        <div id="ctl00_mainContent_CFSValidationSummary" style="color:Red;display:none;">

        </div>

        <table class="searchtable" cellspacing="0" cellpadding="4">
            <tr>
                <th colspan="6">
                    <span style="color: #FFF; font-weight: bold; text-align: left;">Member Profile information</span>
                </th>
            </tr>
            <tr>
                <td>
                    <label for="ctl00_mainContent_txtStartDate" id="ctl00_mainContent_lblStartDate" class="label">Start
                        Date:</label>
                </td>
                <td class="left">
                    <input name="ctl00$mainContent$txtStartDate" type="text" value="2016-01-03" maxlength="12"
                           readonly="readonly" id="ctl00_mainContent_txtStartDate" class="textEntry"
                           style="width:100px;"/>

                    <span id="ctl00_mainContent_rfvCFSStartDate" style="color:Red;visibility:hidden;">*</span>
                    <span id="ctl00_mainContent_cvCFStartDate" style="color:Red;visibility:hidden;">*</span>
                </td>
                <td>
                    <label for="ctl00_mainContent_txtEndDate" id="ctl00_mainContent_lblEndDate" class="label">End
                        Date:</label>
                </td>
                <td class="left">
                    <input name="ctl00$mainContent$txtEndDate" type="text" value="2016-06-06" maxlength="12"
                           readonly="readonly" id="ctl00_mainContent_txtEndDate" class="textEntry"
                           style="width:100px;"/>

                    <span id="ctl00_mainContent_rfvCFSEndDate" style="color:Red;visibility:hidden;">*</span>
                    <span id="ctl00_mainContent_cvCFShell" style="color:Red;visibility:hidden;">*</span>
                </td>
                <td><label for="ctl00_mainContent_ddlActivityStatus" id="ctl00_mainContent_lblActivityStatus"
                           class="label">Status:</label></td>
                <td class="left">
                    <select name="ctl00$mainContent$ddlActivityStatus" id="ctl00_mainContent_ddlActivityStatus"
                            style="width:175px;">

                    </select>
                    <span id="ctl00_mainContent_reqProdCodes" title="Please select Status"
                          style="color:Red;display:none;">*</span>
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
                <td>
                    <label for="ctl00_mainContent_txtFirstName" id="ctl00_mainContent_lblFirstName" class="label">First
                        Name:</label>
                </td>
                <td class="left">
                    <input name="ctl00$mainContent$txtFirstName" type="text" id="ctl00_mainContent_txtFirstName"
                           class="textEntry" style="width:100px;"/>
                </td>
                <td>
                    <label for="ctl00_mainContent_txtLastName" id="ctl00_mainContent_lblLastName" class="label">Last
                        Name:</label>
                </td>
                <td class="left">
                    <input name="ctl00$mainContent$txtLastName" type="text" maxlength="8"
                           id="ctl00_mainContent_txtLastName" class="textEntry" style="width:165px;"/>
                </td>
            </tr>
            <tr>
                <td colspan="5"></td>
                <td class="left"><input type="submit" name="ctl00$mainContent$btnSubmit" value="Search"
                                        id="ctl00_mainContent_btnSubmit" class="button_blue" style="width:160px;"/></td>
            </tr>
        </table>
        <div id="ctl00_mainContent_pnlMemberProfileHistory" class="panel"
             style="background-color:LightGrey;height:300px;overflow:auto;">
            <c:if test="${!avail}">
                <div>
                    <table class="mGrid" cellspacing="0" cellpadding="0" rules="rows" border="1"
                           id="ctl00_mainContent_gvMemberProfiles" style="width:100%;border-collapse:collapse;">
                        <tr>
                            <td>
                                <div><span style="margin-right: 5px; font-size: 15px; font-weight: bold; color: red;">No Records Found.</span>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </c:if>
        </div>
        <c:if test="${show}">
        </c:if>

    </div>
</form>
<jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>
<!-- END CENTER DIV ALIGNMENT -->
</body>
</html>
