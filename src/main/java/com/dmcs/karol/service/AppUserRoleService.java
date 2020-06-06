package com.dmcs.karol.service;

import com.dmcs.karol.domain.AppUserRole;

import java.util.List;

public interface AppUserRoleService {

    void addAppUserRole(AppUserRole appUserRole);
    List<AppUserRole> listAppUserRole();
    AppUserRole getAppUserRole(long id);

}
