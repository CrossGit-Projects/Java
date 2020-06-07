package com.dmcs.karol.dao;

import java.util.List;
import javax.transaction.Transactional;

import com.dmcs.karol.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


//@Transactional
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    List<AppUser> findByLastName(String lastName);
    AppUser findById(long id);
    AppUser findByEmail(String email);

    @Modifying
    @Query("UPDATE AppUser u SET u.enabled = :activeParam WHERE u.activationCode = :activationCode")
    public void updateActivation(@Param("activeParam") boolean activeParam, @Param("activationCode") String activationCode);

}


