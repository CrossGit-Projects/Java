package com.dmcs.karol.service;


import com.dmcs.karol.dao.AdminRepository;
import com.dmcs.karol.dao.AppUserRoleRepository;
import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.domain.AppUserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    private static final Logger LOG = LoggerFactory.getLogger(AdminServiceImpl.class);

    private JpaContext jpaContext;
    private AdminRepository adminRepository;
    private AppUserRoleRepository appUserRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminServiceImpl(JpaContext jpaContext, AdminRepository adminRepository,
                            AppUserRoleRepository appUserRoleRepository) {
        this.jpaContext = jpaContext;
        this.adminRepository = adminRepository;
        this.appUserRoleRepository = appUserRoleRepository;
    }

    @Transactional
    public Page<AppUser> findAll(PageRequest pageable) {
        Page<AppUser> userList = adminRepository.findAll(pageable);
        return userList;
    }


    @Transactional
    public AppUser findUserById(long id) {
        AppUser user = adminRepository.findUserById(id);
        return user;
    }

    @Transactional
    public void updateUser(long id, int nrRoli, boolean activity) {
        adminRepository.updateActivationUser(activity, id);
        adminRepository.updateRoleUser(nrRoli, id);
    }

    @Transactional
    public List<AppUser> findAllSearch(String param) {
        List<AppUser> userList = adminRepository.findAllSearch(param);
        return userList;
    }


    public void saveAll(List<AppUser> userList) {
        for (int i = 0; i < userList.size(); i++) {
            AppUserRole role = appUserRoleRepository.findByRole("ROLE_ADMIN");
            userList.get(i).setAppUserRole(new HashSet<AppUserRole>(Arrays.asList(role)));
            userList.get(i).setPassword(bCryptPasswordEncoder.encode(userList.get(i).getPassword()));
        }
        adminRepository.save(userList);
    }

    @Override
    public void deleteUserById(int id) {
        LOG.debug("[WYWOŁANIE >>> AdminServiceImp.deleteUserById > PARAMETR: " + id);
        LOG.debug("[WYWOŁANIE >>> AdmiinRepository.deleteUserFromUserRole > PARAMETR: " + id);
        adminRepository.deleteUserFromUserRole(id);
        adminRepository.deleteUserFromCardPatient(id);
        LOG.debug("[WYWOŁANIE >>> AdminServiceImp.deleteUserFromUser > PARAMETR: " + id);
        adminRepository.deleteUserFromUser(id);
    }
}
