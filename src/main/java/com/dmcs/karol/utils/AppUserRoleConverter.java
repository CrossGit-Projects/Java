package com.dmcs.karol.utils;

import java.util.HashSet;
import java.util.Set;

import com.dmcs.karol.domain.AppUserRole;
import com.dmcs.karol.service.AppUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class AppUserRoleConverter implements Converter<String, Set<AppUserRole>> {

    private AppUserRoleService appUserRoleService;

    @Autowired
    public AppUserRoleConverter(AppUserRoleService appUserRoleService) {
        this.appUserRoleService = appUserRoleService;
    }

    @Override
    public Set<AppUserRole> convert(String source) {

        Set<AppUserRole> userAppUserRoleList = new HashSet<AppUserRole>(0);

        userAppUserRoleList.add(appUserRoleService.getAppUserRole(Integer.parseInt(source)));

        return userAppUserRoleList;
    }
}

