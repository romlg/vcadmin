<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="/WEB-INF/jsp/inc/header.jsp"/>

<body>
<form name="aspnetForm" method="post" action="Announcements" id="aspnetForm" class="cssform">
    <!-- START CENTER DIV ALIGNMENT -->
    <jsp:include page="/WEB-INF/jsp/inc/menu.jsp"/>
    <!-- Main Area -->
    <div class="mainContainer">

        <table class="searchtable" cellspacing="0" cellpadding="4">
            <tr>
                <th colspan="5">
                    <span style="color: #FFF; font-weight: bold; text-align: left;">Current Announcements</span>
                </th>
            </tr>
        </table>
        <input type="submit" name="ctl00$mainContent$btnAddNew" value="Add New Announcement"
               id="ctl00_mainContent_btnAddNew" class="button_blue"/>
        <hr/>
        <center>
            <div id="ctl00_mainContent_pnlAnnouncements" style="width:95%;overflow:auto;">

                <div id="ctl00_mainContent_uPnlSearchResults">

                    <div>

                    </div>

                </div>

                <div id="ctl00_mainContent_pnlPopup" class="ModalWindow" style="width:700px;display: none">

                    <div id="ctl00_mainContent_updPnlAddNewAnnouncement">

                        <center>
                            <table>
                                <tr>
                                    <td colspan="2">

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span id="ctl00_mainContent_lblStartDate" class="label">Start Date:</span>
                                        <input name="ctl00$mainContent$txtStartDate" type="text" maxlength="12"
                                               id="ctl00_mainContent_txtStartDate" class="textEntry"
                                               style="width:100px;"/>


                                    </td>
                                    <td>
                                        <span id="ctl00_mainContent_lblEndDate" class="label">End Date:</span>
                                        <input name="ctl00$mainContent$txtEndDate" type="text" maxlength="12"
                                               id="ctl00_mainContent_txtEndDate" class="textEntry"
                                               style="width:100px;"/>


                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span id="ctl00_mainContent_lblEnglish" class="label">English:</span>
                                        <textarea name="ctl00$mainContent$txtEnglish" rows="2" cols="200"
                                                  id="ctl00_mainContent_txtEnglish" style="width:200px;"></textarea>

                                    </td>
                                    <td>
                                        <span id="ctl00_mainContent_lblChinese" class="label">Chinese</span>
                                        <textarea name="ctl00$mainContent$txtChinese" rows="2" cols="200"
                                                  id="ctl00_mainContent_txtChinese" style="width:300px;"></textarea>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span id="ctl00_mainContent_lblRussian" class="label">Russian</span>
                                        <textarea name="ctl00$mainContent$txtRussian" rows="2" cols="200"
                                                  id="ctl00_mainContent_txtRussian" style="width:300px;"></textarea>

                                    </td>
                                    <td>
                                        <span id="ctl00_mainContent_lblJappanes" class="label">Japanese</span>
                                        <textarea name="ctl00$mainContent$txtJappanese" rows="2" cols="100"
                                                  id="ctl00_mainContent_txtJappanese" style="width:300px;"></textarea>

                                    </td>
                                </tr>
                            </table>
                        </center>

                    </div>
                    <br/>
                    <div align="center">
                        <input type="submit" name="ctl00$mainContent$btnSave" value="Save"
                               id="ctl00_mainContent_btnSave" class="button_blue"/>
                        <input type="submit" name="ctl00$mainContent$btnClose" value="Close"
                               id="ctl00_mainContent_btnClose" class="button_blue" style="width:50px;"/>
                    </div>
                    <br/>

                </div>

            </div>
        </center>

    </div>
</form>
<jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>
<!-- END CENTER DIV ALIGNMENT -->
</body>
</html>
