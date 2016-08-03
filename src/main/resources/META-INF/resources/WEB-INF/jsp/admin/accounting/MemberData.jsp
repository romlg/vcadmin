<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="/WEB-INF/jsp/inc/header.jsp"/>

</head>
<body>
<script type="text/javascript">
    function isNumberKey(evt) {
        var charCode = (evt.which) ? evt.which : event.keyCode;
        if (document.getElementById('ctl00_mainContent_ddlMemberMismatchedData').selectedIndex == 5) {
            if (charCode > 31 && (charCode < 48 || charCode > 57)) {
                alert("Please enter only numeric values.");
                return false;
            }
        }
        return true;
    }
    function Validate() {
        if (document.getElementById('ctl00_mainContent_ddlMemberMismatchedData').selectedIndex == 5) {
            var Search_len = StringTrim(document.getElementById('ctl00_mainContent_txtSearchData').value).length;
            if (Search_len == 0) {
                alert("Requested search value should not be empty.");
                document.getElementById('ctl00_mainContent_txtSearchData').focus();
                return false;
            }
        }
        if (document.getElementById('ctl00_mainContent_ddlMemberMismatchedData').selectedIndex == 6) {
            var Searchdate_len = StringTrim(document.getElementById('ctl00_mainContent_txtSearchDate').value).length;
            if (Searchdate_len == 0) {
                alert("Requested start date value should not be empty.");
                document.getElementById('ctl00_mainContent_txtSearchDate').focus();
                return false;
            }
            var SearchEnddate_len = StringTrim(document.getElementById('ctl00_mainContent_txtEndDate').value).length;
            if (SearchEnddate_len == 0) {
                alert("Requested end date value should not be empty.");
                document.getElementById('ctl00_mainContent_txtEndDate').focus();
                return false;
            }
        }
        return true;
    }

    function onSearchOptionsChanged(sel) {
        var val = sel.value;
        var div = $("#searchCriteria");
        div.empty();
        if (val == "All") {
        } else if (val == "adpacs_first_name") {
            div.append('<input name="ctl00$mainContent$txtSearchData" type="text" maxlength="50" class="textEntry" onkeypress="return isNumberKey(event)" style="width:100px;">');
        } else if (val == "adpacs_last_name") {
            div.append('<input name="ctl00$mainContent$txtSearchData" type="text" maxlength="50" class="textEntry" onkeypress="return isNumberKey(event)" style="width:100px;">');
        } else if (val == "FANDL") {
            div.append('');
        } else if (val == "adpacs_email") {
            div.append('<input name="ctl00$mainContent$txtSearchData" type="text" maxlength="50" class="textEntry" onkeypress="return isNumberKey(event)" style="width:100px;">');
        } else if (val == "adpacs_member_id") {
            div.append('<input name="ctl00$mainContent$txtSearchData" type="text" maxlength="50" class="textEntry" onkeypress="return isNumberKey(event)" style="width:100px;">');
        } else if (val == "legal_verified_date") {
            div.append('<label for="ctl00_mainContent_txtSearchDate" id="ctl00_mainContent_lblStartDate" class="label">Start Date:</label>');
            div.append('<input name="ctl00$mainContent$txtSearchDate" type="text" maxlength="12" readonly="readonly" id="ctl00_mainContent_txtSearchDate" class="textEntry" style="width:100px;">');
            div.append('<span id="ctl00_mainContent_cvCFStartDate" style="color:Red;visibility:hidden;">*</span>');
            div.append('<label for="ctl00_mainContent_txtEndDate" id="ctl00_mainContent_lblEndDate" class="label">End Date:</label>');
            div.append('<input name="ctl00$mainContent$txtEndDate" type="text" maxlength="12" readonly="readonly" id="ctl00_mainContent_txtEndDate" class="textEntry" style="width:100px;">');
            div.append('<span id="ctl00_mainContent_cvCFShell" style="color:Red;visibility:hidden;">*</span>');
        }
    }
</script>
<form:form name="aspnetForm" method="post" action="MemberData" id="aspnetForm" class="cssform">
    <!-- START CENTER DIV ALIGNMENT -->
    <jsp:include page="/WEB-INF/jsp/inc/menu.jsp"/>
    <!-- Main Area -->
    <div class="mainContainer">

        <div id="ctl00_mainContent_upMembersData">

            <div id="ctl00_mainContent_CFSValidationSummary" style="color:Red;display:none;">

            </div>

            <table class="searchtable" cellspacing="0" cellpadding="4">
                <tr>
                    <th colspan="3">
                        <span style="color: #FFF; font-weight: bold; text-align: left;">Members Mismatched Data</span>
                    </th>
                </tr>
                <tr>
                    <td colspan="3" class="left">
                        <span style="color: #000; font-weight: bold; text-align: left;">This option is used to display the mismatched member information(first name,last name,email) from AM,vcash and ewallet repositories.</span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span id="ctl00_mainContent_lblSearchCriteria" class="label">Search Criteria:</span>
                    </td>
                    <td class="left">
                        <div>
                            <select name="ctl00$mainContent$ddlMemberMismatchedData"
                                    onchange="onSearchOptionsChanged(this);"
                                    id="ctl00_mainContent_ddlMemberMismatchedData" style="width:180px;">
                                <option selected="selected" value="All">All</option>
                                <option value="adpacs_first_name">First name</option>
                                <option value="adpacs_last_name">Last name</option>
                                <option value="FANDL">First name and Last name</option>
                                <option value="adpacs_email">Email</option>
                                <option value="adpacs_member_id">Member id</option>
                                <option value="legal_verified_date">Legal verification date</option>

                            </select>&nbsp;&nbsp;

                            <div id="searchCriteria">

                            </div>
                        </div>
                        <span id="ctl00_mainContent_cvCFStartDate" style="color:Red;visibility:hidden;">*</span>


                        <span id="ctl00_mainContent_cvCFShell" style="color:Red;visibility:hidden;">*</span>
                    </td>
                    <td align="right">
                        <input type="submit" name="ctl00$mainContent$btnSearch" value="Search"
                               id="ctl00_mainContent_btnSearch" class="button_blue"/>
                    </td>
                </tr>

            </table>


            <div>
                <table class="searchtable" cellspacing="0" cellpadding="4">
                    <tr>
                        <td class="right">

                        </td>
                    </tr>
                </table>
            </div>

        </div>

        <div id="updateProgressDiv" style="display:none">
            <div align="center" class="Modal">
                <img src="../../images/ajax-loader.gif" alt=""/>
            </div>
        </div>

    </div>
</form:form>
<jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>
<!-- END CENTER DIV ALIGNMENT -->
</body>
</html>
