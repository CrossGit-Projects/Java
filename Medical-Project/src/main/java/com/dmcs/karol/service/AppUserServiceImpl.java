package com.dmcs.karol.service;

import com.dmcs.karol.dao.AppUserRepository;
import com.dmcs.karol.dao.AppUserRoleRepository;
import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.domain.AppUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    private AppUserRepository appUserRepository;
    private AppUserRoleRepository appUserRoleRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository, AppUserRoleRepository appUserRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appUserRoleRepository = appUserRoleRepository;
    }

    @Transactional
    public void saveUser(AppUser appUser) {
        Integer actualRole = appUser.getNrRoli();
        System.out.println("Moja aktualna rola: " + actualRole);
        String nowRola = null;
        if (actualRole == 2) {
            nowRola = "ROLE_PATIENT";
        } else if (actualRole == 3) {
            nowRola = "ROLE_DOCTOR";
        } else if (actualRole == 1) {
            nowRola = "ROLE_ADMIN";
        }
        AppUserRole role = appUserRoleRepository.findByRole(nowRola);
        appUser.setAppUserRole(new HashSet<AppUserRole>(Arrays.asList(role)));
        appUser.setPassword(hashPassword(appUser.getPassword()));
        appUser.setEnabled(false);
        appUserRepository.save(appUser);

    }

    @Transactional
    public void editAppUser(AppUser appUser) {
        appUser.getAppUserRole().add(appUserRoleRepository.findByRole("ROLE_USER"));
        appUser.setPassword(hashPassword(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

    private String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    @Transactional
    public List<AppUser> listAppUser() {
        return appUserRepository.findAll();
    }

    @Transactional
    public void removeAppUser(long id) {
        appUserRepository.delete(id);
    }

    @Transactional
    public AppUser getAppUser(long id) {
        return appUserRepository.findById(id);
    }

    @Transactional
    public AppUser findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    @Transactional
    public void updateUserActivation(boolean activeCode, String activationCode) {
        appUserRepository.updateActivation(activeCode, activationCode);
    }

}


