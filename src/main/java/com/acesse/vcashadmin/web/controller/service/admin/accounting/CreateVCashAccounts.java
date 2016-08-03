package com.acesse.vcashadmin.web.controller.service.admin.accounting;

import com.acesse.vcashadmin.constants.URLConstants;
import com.acesse.vcashadmin.db.constants.SQLConstants;
import com.acesse.vcashadmin.service.AbstractAccountingService;
import com.acesse.vcashadmin.service.AccountingService;
import com.acesse.vcashadmin.service.dto.CreateVcashSearchDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(URLConstants.Admin.URL + URLConstants.Admin.Accounting.URL)
@AccountingService(sqlDisplay = SQLConstants.CREATEVCASH_ACCOUNTS_DISPLAY_QUERY, sqlDisplayWithMemberId = SQLConstants.CREATEVCASH_ACCOUNTS_WITHMEMBERID_QUERY)
public class CreateVCashAccounts extends AbstractAccountingService<CreateVcashSearchDto> {

    @RequestMapping(value = URLConstants.Admin.Accounting.CreateVCashAccounts, method = RequestMethod.POST)
    public String restoreFacsimileAccounts(
            HttpServletResponse response,
            Model model,
            @RequestParam(name = "ctl00$mainContent$txtStartDate") String startDate,
            @RequestParam(name = "ctl00$mainContent$txtEndDate") String endDate,
            @RequestParam(name = "ctl00$mainContent$txtMemberId", required = false) Integer memberId,
            @RequestParam(name = "ctl00$mainContent$btnSearch", required = false) String search) {

        List ret = processQuery(model, startDate, endDate, memberId, sqlObject -> new CreateVcashSearchDto(
                (Integer) sqlObject[0],//affId
                (Integer) sqlObject[4],//acctId
                (String) sqlObject[2],//firstName
                (String) sqlObject[3],//lastName
                (String) sqlObject[1],//email
                (Integer) sqlObject[7]//statusId
        ));

        if (search != null)
            return URLConstants.View.Admin.Accounting.CreateVCashAccounts;
        else
            excelExportUtil.export(response, ret, "CreateVCashAccounts.xls",
                    new String[]{"Member Id", "V-Cash Number", "First Name", "Last Name", "E-Mail", "legal Status Id"});
        return null;
    }
}
