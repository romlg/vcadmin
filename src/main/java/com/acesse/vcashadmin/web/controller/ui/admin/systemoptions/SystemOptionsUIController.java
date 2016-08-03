package com.acesse.vcashadmin.web.controller.ui.admin.systemoptions;

import com.acesse.vcashadmin.constants.URLConstants;
import com.acesse.vcashadmin.service.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(URLConstants.Admin.URL + URLConstants.Admin.SystemOptions.URL)
public class SystemOptionsUIController extends AbstractController {

    @RequestMapping(value = URLConstants.Admin.SystemOptions.Announcements, method = RequestMethod.GET)
    public String announcements(Model model) {
        return URLConstants.View.Admin.SystemOptions.Announcements;
    }

    @RequestMapping(value = URLConstants.Admin.SystemOptions.AccessLog, method = RequestMethod.GET)
    public String accessLog(Model model) {
        return URLConstants.View.Admin.SystemOptions.AccessLog;
    }
}
