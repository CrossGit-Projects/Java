package com.dmcs.karol.controller;

import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class AdminPageController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminPageController.class);
    private static int ELEMENTS = 15;

    private AdminService adminService;
    private MessageSource messageSource;

    public AdminPageController(AdminService adminService, MessageSource messageSource) {
        this.adminService = adminService;
        this.messageSource = messageSource;
    }

    @GET
    @RequestMapping(value = "/admin/users/{page}")
    @Secured(value = {"ROLE_ADMIN"})
    public String openAdminAllUsersPage(@PathVariable("page") int page, Model model) {

        LOG.info("**** WYWOŁANO > openAdminAllUsersPage(" + page + ", " + model + ")");
        Page<AppUser> pages = getAllUsersPageable(page - 1);
        int totalPages = pages.getTotalPages();
        int currentPage = pages.getNumber();
        List<AppUser> userList = pages.getContent();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage + 1);
        model.addAttribute("userList", userList);
        model.addAttribute("recordStartCounter", currentPage * ELEMENTS);
        return "admin/users";
    }

    @GET
    @RequestMapping(value = "/admin/users/edit/{id}")
    @Secured(value = {"ROLE_ADMIN"})
    public String getUserToEdit(@PathVariable("id") long id, Model model) {
        AppUser user = new AppUser();
        user = adminService.findUserById(id);
        Map<Integer, String> roleMap = new HashMap<Integer, String>();
        roleMap = prepareRoleMap();
        Map<Boolean, String> activityMap = new HashMap<>();
        activityMap = prepareActivityMap();
        long rola = user.getAppUserRole().iterator().next().getId();
        user.setNrRoli((int) rola);
        model.addAttribute("roleMap", roleMap);
        model.addAttribute("activityMap", activityMap);
        model.addAttribute("user", user);
        return "admin/useredit";
    }

    @POST
    @RequestMapping(value = "/admin/updateuser/{id}")
    @Secured(value = "ROLE_ADMIN")
    public String updateUser(@PathVariable("id") long id, AppUser user) {
        int nrRoli = user.getNrRoli();
        boolean czyActive = user.isEnabled();
        adminService.updateUser(id, nrRoli, czyActive);
        return "redirect:/admin/users/1";
    }

    @GET
    @RequestMapping(value = "/admin/users/search/{searchWord}")
    @Secured(value = "ROLE_ADMIN")
    public String openSearchUsersPage(@PathVariable("searchWord") String searchWord, Model model) {
        List<AppUser> userList = adminService.findAllSearch(searchWord);
        for (AppUser users : userList) {
            long numerRoli = users.getAppUserRole().iterator().next().getId();
            users.setNrRoli((int) numerRoli);
        }
        model.addAttribute("userList", userList);
        return "admin/usersearch";
    }


    @DELETE
    @RequestMapping(value = "/admin/users/delete/{id}")
    @Secured(value = "ROLE_ADMIN")
    public String deleteUser(@PathVariable("id") int id) {
        LOG.debug("[WYWOŁANIE >>> AdminPageController.deleteUserById > PARAMETR: " + id);
        adminService.deleteUserById(id);
        return "redirect:/admin/users/1";
    }


    //  Pobranie listy userów
    private Page<AppUser> getAllUsersPageable(int page) {
        Page<AppUser> pages = adminService.findAll(new PageRequest(page, ELEMENTS));
        for (AppUser users : pages) {
            long numerRoli = users.getAppUserRole().iterator().next().getId();
            users.setNrRoli((int) numerRoli);
        }
        return pages;
    }

    // przygotowanie mapy ról
    public Map<Integer, String> prepareRoleMap() {
        Locale locale = Locale.getDefault();
        Map<Integer, String> roleMap = new HashMap<Integer, String>();
        roleMap.put(1, messageSource.getMessage("word.admin", null, locale));
        roleMap.put(2, messageSource.getMessage("word.patient", null, locale));
        roleMap.put(3, messageSource.getMessage("word.doctor", null, locale));
        return roleMap;
    }

    // przygotowanie map aktywny/nieaktywny
    public Map<Boolean, String> prepareActivityMap() {
        Locale locale = Locale.getDefault();
        Map<Boolean, String> activityMap = new HashMap<>();
        activityMap.put(false, messageSource.getMessage("word.nie", null, locale));
        activityMap.put(true, messageSource.getMessage("word.tak", null, locale));
        return activityMap;
    }
}
