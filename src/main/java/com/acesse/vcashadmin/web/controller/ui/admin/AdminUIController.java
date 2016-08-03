package com.acesse.vcashadmin.web.controller.ui.admin;

import com.acesse.vcashadmin.constants.ModelConstants;
import com.acesse.vcashadmin.constants.URLConstants;
import com.acesse.vcashadmin.service.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(URLConstants.Admin.URL)
public class AdminUIController extends AbstractController {

    @RequestMapping(value = URLConstants.Admin.SearchMembers, method = RequestMethod.GET)
    public String searchMemebers(Model model) {
        model.addAttribute(ModelConstants.SHOW_RESULT, false);
        return URLConstants.View.Admin.SearchMembers;
    }

    @RequestMapping(URLConstants.Admin.VCashTransfer)
    public String vCashTransfer(Model model) {
        model.addAttribute(ModelConstants.SHOW_RESULT, false);
        return URLConstants.View.Admin.VCashTransfer;
    }
}
