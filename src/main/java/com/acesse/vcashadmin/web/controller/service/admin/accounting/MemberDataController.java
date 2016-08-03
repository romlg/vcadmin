package com.acesse.vcashadmin.web.controller.service.admin.accounting;

import com.acesse.vcashadmin.constants.URLConstants;
import com.acesse.vcashadmin.service.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(URLConstants.Admin.URL + URLConstants.Admin.Accounting.URL)
public class MemberDataController extends AbstractController {
    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping(value = URLConstants.Admin.Accounting.MemberData, method = RequestMethod.POST)
    public
    @ResponseBody
    String vcashTransfer(
            @RequestParam(name = "ctl00$mainContent$ddlMemberMismatchedData", required = false) String data
    ) {
        return "";
    }

}
