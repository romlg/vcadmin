<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="/WEB-INF/jsp/inc/header.jsp"/>

</head>
<body>
<!-- START CENTER DIV ALIGNMENT -->
<div class="container">
    <!--START HEADER -->
    <table border="0" cellpadding="0" cellspacing="0" width="1000">
        <tr bgcolor="#EEEEEE">
            <td align="left" width="200">
                <img id="ctl00_imgLogo" src="images/logo.png" style="border-width:0px;"/>
            </td>
            <td align="center">
                <span style="font-size: 18px; font-weight: bold;">V-Cash Administration Account</span>
            </td>
            <td align="right" width="200">
                <div id="clockbox" style="margin-right: 5px; font-size: 18px; font-weight: bold;">
                </div>
                <span style="margin-right: 5px; font-size: 18px; font-weight: bold; color: Red">Production</span>
            </td>
        </tr>
    </table>
    <form:form name="aspnetForm" method="post" action="/login" onsubmit="javascript:return WebForm_OnSubmit();"
               id="aspnetForm" class="cssform">
        <!-- Main Area -->
        <div class="mainContainer" style="background-color: #EEEEEE">

            <table class="searchtable" cellspacing="0" cellpadding="4">
                <tr>
                    <th bgcolor="#666666" colspan="5">
                        <span style="color: #FFF; font-weight: bold; text-align: left;">Login</span>
                        <c:if test="${invalidlogin}">
                            <span id="ctl00_ContentPlaceHolder1_lblError" class="ErrorMessage">Invalid username or password.</span>
                        </c:if>
                    </th>
                </tr>
                <tr>
                    <td>
                        <label for="UserName" id="lblUserName">Username:</label>
                    </td>
                    <td class="left">
                        <input name="UserName" type="text"
                               id="UserName" style="width:100px;"/>
                        <span id="UserNameRequired" title="User Name is required."
                              class="failureNotification" style="color:Red;visibility:hidden;">*</span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="Password" id="lblPassword">Password:</label>
                    </td>
                    <td class="left">
                        <input name="Password" type="password" maxlength="14"
                               id="Password" style="width:100px;"/>
                        <span id="PasswordRequired" title="Password is required."
                              class="failureNotification" style="color:Red;visibility:hidden;">*</span>
                    </td>
                </tr>
                <tr>
                    <td colspan="5">
                        <a id="ctl00_ContentPlaceHolder1_hlnkForgotPassword" href="ForgotPassword.aspx">Forgot
                            Password</a>
                        <input type="submit" name="ctl00$ContentPlaceHolder1$LoginButton" value="Log In"
                               id="ctl00_ContentPlaceHolder1_LoginButton" class="button_blue"/>
                    </td>
                </tr>
            </table>
        </div>

    </form:form>
</div>
<jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>
<!-- END CENTER DIV ALIGNMENT -->
</body>
</html>


