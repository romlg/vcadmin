<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="/WEB-INF/jsp/inc/header.jsp"/>

<body>

<form:form name="aspnetForm" method="post" action="Default.aspx" onsubmit="javascript:return WebForm_OnSubmit();"
           id="aspnetForm" class="cssform">
    <script type="text/javascript">
        //<![CDATA[
        Sys.WebForms.PageRequestManager._initialize('ctl00$ajaxScriptManager', 'aspnetForm', ['tctl00$mainContent$pnlUpdate', ''], [], [], 90, 'ctl00');
        //]]>
    </script>

    <!-- START CENTER DIV ALIGNMENT -->
    <jsp:include page="/WEB-INF/jsp/inc/menu.jsp"/>
    <!-- Main Area -->
    <div class="mainContainer">

        <span id="ctl00_mainContent_RequiredFieldValidator1" title="Member ID is required."
              style="color:Red;display:none;">Member ID is required.</span>
        <span id="ctl00_mainContent_rexNumber"
              style="color:Red;display:none;">Please enter numeric value for member id.</span>
        <table class="searchtable" cellspacing="0" cellpadding="4">
            <tr>
                <th colspan="5">
                    <span style="color: #FFF; font-weight: bold; text-align: left;">Quick Links</span>
                </th>
            </tr>
            <tr>
                <td>
                    <label for="ctl00_mainContent_txtMemberID" id="ctl00_mainContent_lblMemberId">Quick Search By Member
                        ID:</label>
                </td>
                <td class="left">
                    <input name="ctl00$mainContent$txtMemberID" type="text" maxlength="10"
                           id="ctl00_mainContent_txtMemberID" style="width:150px;"/>
                    <span id="ctl00_mainContent_reqNPwd" title="Member ID is required."
                          style="color:Red;visibility:hidden;">*</span>
                    <input type="image" name="ctl00$mainContent$btnSearchMember" id="ctl00_mainContent_btnSearchMember"
                           src="/images/search.gif" align="middle"
                           style="border-width:0px;height: 30px; width: 34px"/>
                </td>
            </tr>
        </table>
        <div id="ctl00_mainContent_pnlUpdate">
            <div>
                <div id="ctl00_mainContent_Panel1" style="display: none; background-color: #C0C0C0;">
                    <img src="/images/ajax-loader.gif" alt=""/>
                </div>
                <input type="hidden" name="ctl00$mainContent$hiddenField" id="ctl00_mainContent_hiddenField"/>
            </div>
        </div>
    </div>
</form:form>
<jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>
<!-- END CENTER DIV ALIGNMENT -->
</body>
</html>
