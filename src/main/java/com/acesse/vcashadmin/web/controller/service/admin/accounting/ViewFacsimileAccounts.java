package com.acesse.vcashadmin.web.controller.service.admin.accounting;

import com.acesse.vcashadmin.constants.URLConstants;
import com.acesse.vcashadmin.db.constants.SQLConstants;
import com.acesse.vcashadmin.service.AbstractAccountingService;
import com.acesse.vcashadmin.service.AccountingService;
import com.acesse.vcashadmin.service.dto.FacsimileAccountSearchDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(URLConstants.Admin.URL + URLConstants.Admin.Accounting.URL)
@AccountingService(sqlDisplay = SQLConstants.DUP_ACCOUNTS_DISPLAY_QUERY, sqlDisplayWithMemberId = SQLConstants.DUP_ACCOUNTS_WITHAFFID_QUERY)
public class ViewFacsimileAccounts extends AbstractAccountingService<FacsimileAccountSearchDto> {

    @RequestMapping(value = URLConstants.Admin.Accounting.ViewFacsimileAccounts, method = RequestMethod.POST)
    public String viewFacsimileAccounts(
            HttpServletResponse response,
            Model model,
            @RequestParam(name = "ctl00$mainContent$txtStartDate") String startDate,
            @RequestParam(name = "ctl00$mainContent$txtEndDate") String endDate,
            @RequestParam(name = "ctl00$mainContent$txtMemberId", required = false) Integer memberId,
            @RequestParam(name = "ctl00$mainContent$btnSearch", required = false) String search,
            @RequestParam(name = "ctl00$mainContent$btnExport", required = false) String export) {
        List ret = processQuery(model, startDate, endDate, memberId, sqlObject -> new FacsimileAccountSearchDto(
                (Integer) sqlObject[0],
                (Integer) sqlObject[1],
                (String) sqlObject[2],
                (String) sqlObject[3],
                (String) sqlObject[4],
                (String) sqlObject[5],
                new Date(((Timestamp) sqlObject[6]).getTime()).toString(),
                (Integer) sqlObject[7],
                (BigInteger) sqlObject[8],
                (String) sqlObject[9]
        ));
        if (search != null)
            return URLConstants.View.Admin.Accounting.ViewFacsimileAccounts;
        else
            excelExportUtil.export(response, ret, "ViewFacsimileAccounts.xls",
                    new String[]{"Member Id", "V-Cash Number", "First Name", "Last Name", "SecureInfo", "Created Date", "Transaction Count", "Email"});
        return null;
    }
}
