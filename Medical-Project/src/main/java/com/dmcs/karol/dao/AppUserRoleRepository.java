package com.dmcs.karol.dao;

import com.dmcs.karol.domain.AppUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AppUserRoleRepository extends JpaRepository<AppUserRole, Long> {
    AppUserRole findByRole(String role);
}
