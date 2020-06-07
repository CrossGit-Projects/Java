package com.dmcs.karol.controller;

import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.service.AppUserRoleService;
import com.dmcs.karol.service.AppUserService;
import com.dmcs.karol.service.ReCaptchaService;
import com.dmcs.karol.utils.AppDemoUtils;
import com.dmcs.karol.utils.EmailSender.EmailService;
import com.dmcs.karol.validator.AppUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.POST;
import java.util.Locale;


@Controller
public class AppUserController {

    private AppUserValidator appUserValidator = new AppUserValidator();

    private AppUserService appUserService;
    private AppUserRoleService appUserRoleService;
    private EmailService emailService;
    private final MessageSource messageSource;
    private ReCaptchaService reCaptchaService;


    @Autowired
    public AppUserController(AppUserService appUserService, AppUserRoleService appUserRoleService,
                             EmailService emailService, MessageSource messageSource, ReCaptchaService reCaptchaService) {
        this.appUserService = appUserService;
        this.appUserRoleService = appUserRoleService;
        this.emailService = emailService;
        this.messageSource = messageSource;
        this.reCaptchaService = reCaptchaService;
    }

    @RequestMapping(value = "/register")
    public String showAppUsers(Model model, HttpServletRequest request) {

        int appUserId = ServletRequestUtils.getIntParameter(request, "appUserId", -1);

        if (appUserId > 0) {
            AppUser appUser = appUserService.getAppUser(appUserId);
            appUser.setPassword("");
            model.addAttribute("appUser", appUser);
        } else
            model.addAttribute("appUser", new AppUser());

        model.addAttribute("appUserList", appUserService.listAppUser());
        model.addAttribute("appUserRoleList", appUserRoleService.listAppUserRole());

        return "register";
    }

    @POST
    @RequestMapping(value = "/addAppUser", method = RequestMethod.POST)
    public String addAppUser(@Valid AppUser appUser, BindingResult result, Model model, Locale locale, HttpServletRequest request) {

        System.out.println("First Name: " + appUser.getFirstName() +
                " Last Name: " + appUser.getLastName() + " Tel.: " +
                appUser.getTelephone() + " Email: " + appUser.getEmail());

        appUserValidator.validate(appUser, result);

        if (result.getErrorCount() == 0 && reCaptchaService.verify(request.getParameter("g-recaptcha-response"))) {
            if (appUser.getId() == 0) {

                appUser.setActivationCode(AppDemoUtils.randomStringGenerator());
                String content = "Wymagane potwierdzenie rejestracji. Kliknij w poniższy link aby aktywować konto: " +
                        "http://localhost:8080/activatelink/" + appUser.getActivationCode();

                appUserService.saveUser(appUser);
                System.out.println(appUser.getEmail());
                emailService.sendEmail(appUser.getEmail(), "Potwierdzenie rejestracji", content);
                model.addAttribute("message", messageSource.getMessage("user.register.success.email", null, locale));
                model.addAttribute("appUser", new AppUser());

            } else {
                appUserService.editAppUser(appUser);
            }
            return "redirect:register";
        }

        appUser.getAppUserRole().clear();
        model.addAttribute("appUserList", appUserService.listAppUser());
        model.addAttribute("appUserRoleList", appUserRoleService.listAppUserRole());
        return "register";
    }

    @POST
    @RequestMapping(value = "/activatelink/{activationCode}")
    public String activateAccount(@PathVariable("activationCode") String activationCode, Model model, Locale locale) {

        appUserService.updateUserActivation(true, activationCode);

        model.addAttribute("message", messageSource.getMessage("user.register.success", null, locale));

        return "index";
    }

    @RequestMapping("/delete/{appUserId}")
    public String deleteUser(@PathVariable("appUserId") Long appUserId) {
        appUserService.removeAppUser(appUserId);
        return "redirect:appUsers.html";
    }
}


