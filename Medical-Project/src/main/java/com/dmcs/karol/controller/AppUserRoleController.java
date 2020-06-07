package com.dmcs.karol.controller;


import com.dmcs.karol.domain.AppUserRole;
import com.dmcs.karol.service.AppUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AppUserRoleController {

    private AppUserRoleService appUserRoleService;

    @Autowired
    public AppUserRoleController(AppUserRoleService appUserRoleService) {
        this.appUserRoleService = appUserRoleService;
    }

    @RequestMapping(value="/admin/appUserRole")
    public String showUserRole(Model model) {
        model.addAttribute("appUserRole", new AppUserRole());
        return "admin/appUserRole";
    }

    @RequestMapping(value = "/addAppUserRole", method = RequestMethod.POST)
    public String addAppUserRole(@ModelAttribute("appUserRole") AppUserRole appUserRole, BindingResult result) {
        appUserRoleService.addAppUserRole(appUserRole);
        return "redirect:appUsers.html";
    }
}


