package com.acesse.vcashadmin.web.controller.ui;

import com.acesse.vcashadmin.constants.URLConstants;
import com.acesse.vcashadmin.service.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class RootUIController extends AbstractController {
    @RequestMapping(URLConstants.UI.LOGIN)
    public String login(Model model, @RequestParam(name = "error", required = false) Boolean invalidLogin) {
        model.addAttribute("invalidlogin", invalidLogin != null ? invalidLogin : false);
        return URLConstants.View.LOGIN;
    }

    @RequestMapping(URLConstants.UI.MAIN)
    public String main() {
        return URLConstants.View.MAIN;
    }
}
