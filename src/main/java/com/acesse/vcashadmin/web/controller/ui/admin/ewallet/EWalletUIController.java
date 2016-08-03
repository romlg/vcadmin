package com.acesse.vcashadmin.web.controller.ui.admin.ewallet;

import com.acesse.vcashadmin.constants.URLConstants;
import com.acesse.vcashadmin.service.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(URLConstants.Admin.URL + URLConstants.Admin.EWallet.URL)
public class EWalletUIController extends AbstractController {

    @RequestMapping(value = URLConstants.Admin.EWallet.MemberProfileInformations, method = RequestMethod.GET)
    public String memberProfileInformations(Model model) {
        return URLConstants.View.Admin.EWallet.MemberProfileInformations;
    }
}
