package com.acesse.vcashadmin.web.controller.service.admin.accounting;

import com.acesse.vcashadmin.constants.URLConstants;
import com.acesse.vcashadmin.db.constants.SQLConstants;
import com.acesse.vcashadmin.service.AbstractAccountingService;
import com.acesse.vcashadmin.service.AccountingService;
import com.acesse.vcashadmin.service.dto.NegativeBalanceAccountDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(URLConstants.Admin.URL + URLConstants.Admin.Accounting.URL)
@AccountingService(sqlDisplay = SQLConstants.NEGATIVE_ACCOUNTS_QUERY, sqlDisplayWithMemberId = SQLConstants.NEGATIVE_ACCOUNTS_WITHAFFID_QUERY)
public class NegativeBalanceAccounts extends AbstractAccountingService<NegativeBalanceAccountDto> {

    @RequestMapping(value = URLConstants.Admin.Accounting.NegativeBalanceAccounts, method = RequestMethod.POST)
    public String restoreFacsimileAccounts(
            HttpServletResponse response,
            Model model,
            @RequestParam(name = "ctl00$mainContent$txtStartDate") String startDate,
            @RequestParam(name = "ctl00$mainContent$txtEndDate") String endDate,
            @RequestParam(name = "ctl00$mainContent$txtMemberId", required = false) Integer memberId,
            @RequestParam(name = "ctl00$mainContent$btnSearchNegativeAccounts", required = false) String search) {
        Locale locale = new Locale("en", "US");
        DecimalFormat currencyFormatter = (DecimalFormat) NumberFormat.getCurrencyInstance(locale);
        currencyFormatter.setNegativePrefix("$-"); // or "-"+symbol if that's what you need
        currencyFormatter.setNegativeSuffix("");
        List ret = processQuery(model, startDate, endDate, memberId, sqlObject -> new NegativeBalanceAccountDto(
                (Integer) sqlObject[0],
                (Integer) sqlObject[1],
                currencyFormatter.format(sqlObject[2])
        ));

        if (search != null)
            return URLConstants.View.Admin.Accounting.NegativeBalanceAccounts;
        else
            excelExportUtil.export(response, ret, "NegativeBalanceAccounts.xls",
                    new String[]{"Member Id", "V-CASH Number", "Amount Balance"});
        return null;
    }
}
