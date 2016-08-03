package com.acesse.vcashadmin.web.controller.ui.admin.accounting;

import com.acesse.vcashadmin.constants.ModelConstants;
import com.acesse.vcashadmin.constants.URLConstants;
import com.acesse.vcashadmin.service.AbstractController;
import com.acesse.vcashadmin.web.service.AccountingDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(URLConstants.Admin.URL + URLConstants.Admin.Accounting.URL)
public class AccountingUIController extends AbstractController {
    @Autowired
    AccountingDBService accountingService;

    @RequestMapping(URLConstants.Admin.Accounting.INTERNAL_ACCOUNT)
    public String internalAccounts(Model model) {
        model.addAttribute(ModelConstants.DATA, accountingService.getAccountingInfo());
        return URLConstants.View.INTERNAL_ACCOUNT;
    }

    @RequestMapping(URLConstants.Admin.Accounting.CreateVCashAccounts)
    public String createVCashAccounts(Model model) {
        model.addAttribute(ModelConstants.SHOW_RESULT, false);
        return URLConstants.View.Admin.Accounting.CreateVCashAccounts;
    }

    @RequestMapping(URLConstants.Admin.Accounting.MemberData)
    public String memberData(Model model) {
        model.addAttribute(ModelConstants.SHOW_RESULT, false);
        return URLConstants.View.Admin.Accounting.MemberData;
    }

    @RequestMapping(URLConstants.Admin.Accounting.NegativeBalanceAccounts)
    public String negativeBalanceAccounts(Model model) {
        model.addAttribute(ModelConstants.SHOW_RESULT, false);
        return URLConstants.View.Admin.Accounting.NegativeBalanceAccounts;
    }

    @RequestMapping(URLConstants.Admin.Accounting.RestoreFacsimileAccounts)
    public String restoreFacsimileAccounts(Model model) {
        model.addAttribute(ModelConstants.SHOW_RESULT, false);
        return URLConstants.View.Admin.Accounting.RestoreFacsimileAccounts;
    }

    @RequestMapping(URLConstants.Admin.Accounting.ViewFacsimileAccounts)
    public String viewFacsimileAccounts(Model model) {
        model.addAttribute(ModelConstants.SHOW_RESULT, false);
        return URLConstants.View.Admin.Accounting.ViewFacsimileAccounts;
    }
}
