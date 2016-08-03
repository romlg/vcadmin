<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="/WEB-INF/jsp/inc/header.jsp"/>

<body>
<form name="aspnetForm" method="post" action="InternalAccounts.aspx" id="aspnetForm" class="cssform">
    <!-- START CENTER DIV ALIGNMENT -->
    <jsp:include page="/WEB-INF/jsp/inc/menu.jsp"/>
    <!-- Main Area -->
    <div class="mainContainer">

        <table class="searchtable" cellspacing="0" cellpadding="4">
            <tr>
                <th>
                    <span style="color: #FFF; font-weight: bold; text-align: left;">Company Internal Accounts</span>

                </th>
            </tr>
        </table>
        <div id="ctl00_mainContent_pnlInternalAccounts" class="panel" style="overflow:auto;">
            <center>
                <div>
                    <table class="mGrid" cellspacing="0" cellpadding="3" rules="rows" border="1"
                           id="ctl00_mainContent_grdInternalAccounts" style="width:90%;border-collapse:collapse;">
                        <tr>
                            <th scope="col">Affiliate Id</th>
                            <th scope="col">Account Number</th>
                            <th scope="col">Description</th>
                            <th scope="col">Total Amount (US$)</th>
                        </tr>
                        <c:forEach items="${data}" var="minfo" varStatus="loopStatus">
                            <tr class="${loopStatus.index % 2 == 0 ? '' : 'alt'}">
                                <td align="left" valign="top">
                                    <c:out value="${minfo.affId}"/>
                                </td>
                                <td align="left" valign="top" style="font-weight:bold;">
                                    <c:out value="${minfo.acctId}"/>
                                </td>
                                <td align="left" valign="top">
                                    <c:out value="${minfo.acctName}"/>
                                </td>
                                <td align="left" valign="top"
                                    style="color:<c:out value="${minfo.color}"/>;font-weight:bold;">
                                    <c:out value="${minfo.amount}"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </center>
        </div>
    </div>
</form>
<jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>
<!-- END CENTER DIV ALIGNMENT -->
</body>
</html>
