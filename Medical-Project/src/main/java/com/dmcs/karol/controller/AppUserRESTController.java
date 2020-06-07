package com.dmcs.karol.controller;

import com.dmcs.karol.dao.AppUserRepository;
import com.dmcs.karol.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("appUserRest")
public class AppUserRESTController {

    private AppUserRepository appUserRepository;

    @Autowired
    public AppUserRESTController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @RequestMapping(value = "/{email}.json", method = RequestMethod.GET, produces = "application/json")
    public AppUser getAppUserInJSON(@PathVariable String email) {

        return appUserRepository.findByEmail(email);
    }

    @RequestMapping(value = "/{email}.xml", method = RequestMethod.GET, produces = "application/xml")
    public AppUser getAppUserInXML(@PathVariable String email) {

        return appUserRepository.findByEmail(email);
    }

}