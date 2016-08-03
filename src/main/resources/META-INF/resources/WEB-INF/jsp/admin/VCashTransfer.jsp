<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="/WEB-INF/jsp/inc/header.jsp"/>

<script>
    function onTransCodesSelect(sel) {
        $.ajax({
            url: '/admin/VCashTransfer/product_codes.get.json',
            async: false,
            type: 'get',
            data: {
                transcode: sel.value
            },
            success: function (data) {
                var pcselect = $("#ctl00_mainContent_ddlProdCodes");
                pcselect.empty();
                $.each(data, function (i, pc) {
                    var option = $('<option></option>');
                    option.attr("value", pc.second).text(pc.first);
                    pcselect.append(option);
                });

            }
        });
    }
</script>

<body>
<form:form name="aspnetForm" method="post" action="VCashTransfer" id="aspnetForm" class="cssform">
    <!-- START CENTER DIV ALIGNMENT -->
    <jsp:include page="/WEB-INF/jsp/inc/menu.jsp"/>
    <!-- Main Area -->
    <div class="mainContainer">

        <div id="ctl00_mainContent_uPnlSearchResults">
            <h2 style="margin: 10px;"> Admin - V-CASH</h2>
            <span class="failureNotification"
                  style='color:red; font-weight: bold; text-align: center;'>            </span>
            <div id="ctl00_mainContent_ValidationSummary" style="color:Red;display:none;">

            </div>
            <table class="searchtable" cellspacing="0" cellpadding="2">

                <tr>
                    <th colspan="5">
                        <span style="color: #FFF; font-weight: bold; text-align: left;">V-CASH Fund Transfer</span>
                    </th>
                </tr>
                <tr>
                    <td>
                        <label for="ctl00_mainContent_txtVCashFrom" id="ctl00_mainContent_lblTransactions"
                               class="label">Trans codes:</label>
                    </td>
                    <td class="left">
                        <select name="ctl00$mainContent$ddlTransCodes" id="ctl00_mainContent_ddlTransCodes"
                                class="textEntry" MaxLength="30" style="width:250px;"
                                onchange="onTransCodesSelect(this);">
                            <option selected="selected" value="-1" title="---Select---">---Select---</option>
                            <option value="5" title="5-V-Cash Internal Transfer">5-V-Cash Internal Transfer</option>
                            <option value="16" title="16-VC Fees">16-VC Fees</option>
                            <option value="45" title="45-V-Cash to eWallet ">45-V-Cash to eWallet</option>
                            <option value="302" title="302-V-Cash Product Purchase">302-V-Cash Product Purchase</option>
                            <option value="303" title="303-I Cash to V-Cash">303-I Cash to V-Cash</option>

                        </select>
                        <span id="ctl00_mainContent_reqTransCodes" title="Please select Trans code"
                              style="color:Red;display:none;">*</span>
                    </td>
                    <td class="tdgap">
                        &nbsp;
                    </td>
                    <td>
                        <label for="ctl00_mainContent_txtVCashFrom" id="ctl00_mainContent_lblProducts" class="label">Product
                            codes:</label>
                    </td>
                    <td class="left">
                        <select name="ctl00$mainContent$ddlProdCodes"
                                id="ctl00_mainContent_ddlProdCodes" class="textEntry" MaxLength="30"
                                style="width:250px;">
                            <option selected="selected" value="-1">Not Found</option>

                        </select>
                        <span id="ctl00_mainContent_reqProdCodes" title="Please select Product code"
                              style="color:Red;display:none;">*</span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="ctl00_mainContent_txtVCashFrom" id="ctl00_mainContent_lblVCashNumberFrom"
                               class="label">V-CASH Number From:</label>
                    </td>
                    <td class="left">
                        <input name="ctl00$mainContent$txtVCashFrom" type="text" maxlength="8"
                               id="ctl00_mainContent_txtVCashFrom" class="textEntry" style="width:100px;"/>

                        <span id="ctl00_mainContent_txtVCashFromRqrd"
                              title="Transfer From V-Cash Account Number Required." class="failureNotification"
                              style="color:Red;display:none;">*</span>
                        <span id="ctl00_mainContent_revVcashFrom"
                              title="Please enter only numbers in V-Cash Number From." class="failureNotification"
                              style="color:Red;display:none;">*</span>
                    </td>
                    <td class="tdgap">
                        &nbsp;
                    </td>
                    <td>
                        <label for="ctl00_mainContent_txtVCashNumberTo" id="ctl00_mainContent_lblVCashNumberTo"
                               class="label">V-CASH Number To:</label>
                    </td>
                    <td class="left">
                        <input name="ctl00$mainContent$txtVCashNumberTo" type="text" maxlength="8"
                               id="ctl00_mainContent_txtVCashNumberTo" class="textEntry" style="width:100px;"/>

                        <span id="ctl00_mainContent_txtVCashNumberTorqrd"
                              title="Transfer To V-Cash Account Number Required." class="failureNotification"
                              style="color:Red;display:none;">*</span>
                        <span id="ctl00_mainContent_revVcashto" title="Please enter only numbers in V-Cash Number To."
                              class="failureNotification" style="color:Red;visibility:hidden;">*</span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="ctl00_mainContent_txtTransferAmount" id="ctl00_mainContent_lblTransferAmount"
                               class="bold">Transfer Amount (US$):</label>
                    </td>
                    <td class="left">
                        <input name="ctl00$mainContent$txtTransferAmount" type="text" maxlength="10"
                               id="ctl00_mainContent_txtTransferAmount" class="textEntry" style="width:100px;"/>
                        <span id="ctl00_mainContent_txtTransferAmountRqrd" title="Transfer Amount is required."
                              class="failureNotification" style="color:Red;display:none;">*</span>
                        <span id="ctl00_mainContent_txtTranferAmountValidator" class="redLabel"
                              style="color:Red;display:none;">*</span>
                    </td>
                    <td class="tdgap">
                        &nbsp;
                    </td>
                    <td>
                        <label for="ctl00_mainContent_txtTransferFee" id="ctl00_mainContent_lblTransferFee"
                               class="bold">Transfer Fee (US$):</label>
                    </td>
                    <td class="left">
                        <input name="ctl00$mainContent$txtTransferFee" type="text" maxlength="6"
                               id="ctl00_mainContent_txtTransferFee" disabled="disabled" class="textEntry"
                               style="width:100px;"/>
                        <span id="ctl00_mainContent_txtTransferFeeRqrd" title="Transfer Fee is required."
                              class="failureNotification" style="color:Red;display:none;">*</span>
                        <span id="ctl00_mainContent_RegularExpressionValidator1" class="redLabel"
                              style="color:Red;display:none;">Invalid currency format.</span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="ctl00_mainContent_txtTransferAmount" id="ctl00_mainContent_lblTransferMemo"
                               class="bold">Transfer Memo:</label>
                    </td>
                    <td class="left" colspan="4" valign="middle">
                        <textarea name="ctl00$mainContent$txtTransferMemo" rows="3" cols="20"
                                  id="ctl00_mainContent_txtTransferMemo" class="textEntry"
                                  style="height:76px;width:300px;">
                        </textarea>
                    </td>
                </tr>
            </table>

        </div>
        <table class="searchtable" cellspacing="0" cellpadding="2">
            <tr>
                <td colspan="5" class="right">
                    <input type="submit" name="ctl00$mainContent$btnSubmit" value="Next >>"
                           id="ctl00_mainContent_btnSubmit" class="button_blue"/>
                </td>
            </tr>
        </table>

    </div>
</form:form>
<jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>
<!-- END CENTER DIV ALIGNMENT -->
</body>
</html>
