package com.dmcs.karol.controller;

import com.dmcs.karol.service.AppUserRoleService;
import com.dmcs.karol.service.AppUserService;
import com.dmcs.karol.validator.AppUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringSecurityCustomPagesController {

    private AppUserValidator appUserValidator = new AppUserValidator();

    private AppUserService appUserService;

    private AppUserRoleService appUserRoleService;

    @Autowired
    public SpringSecurityCustomPagesController(AppUserService appUserService, AppUserRoleService appUserRoleService) {
        this.appUserService = appUserService;
        this.appUserRoleService = appUserRoleService;
    }


    @RequestMapping(value = "/login")
    public String customLogin(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,
                              Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = "/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }

}