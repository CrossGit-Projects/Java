package com.dmcs.karol.service;

import com.dmcs.karol.domain.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface AdminService {

    Page<AppUser> findAll(PageRequest pageable);

    AppUser findUserById(long id);

    void updateUser(long id, int nrRoli, boolean activity);

    List<AppUser> findAllSearch(String param);

    void saveAll(List<AppUser> userList);

    void deleteUserById(int id);
}
