package com.dmcs.karol.dao;


import com.dmcs.karol.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<AppUser, Long> {

    AppUser findUserById(long id);

    @Modifying
    @Query("UPDATE AppUser u SET u.enabled = :intActive WHERE u.id = :id")
    void updateActivationUser(@Param("intActive")boolean active, @Param("id") long id);

    @Modifying
    @Query(value = "UPDATE appuser_appuserrole u SET u.appuserrole_id = :roleId WHERE u.appuser_id = :id", nativeQuery = true)
    void updateRoleUser(@Param("roleId") int nrRoli, @Param("id") long id);


    @Query(value = "SELECT * FROM AppUser u WHERE u.firstName LIKE %:param% OR u.lastName LIKE %:param% OR email LIKE %:param%", nativeQuery = true)
    List<AppUser> findAllSearch(@Param("param") String param);

    @Modifying
    @Query(value = "DELETE FROM appuser_appuserrole WHERE appuser_id = :id", nativeQuery = true)
    void deleteUserFromUserRole(@Param("id") int id);

    @Modifying
    @Query(value = "DELETE FROM CardPatient WHERE appuser_id = :id", nativeQuery = true)
    void deleteUserFromCardPatient(@Param("id") int id);

    @Modifying
    @Query(value = "DELETE FROM AppUser  WHERE id = :id", nativeQuery = true)
    void deleteUserFromUser(@Param("id") int id);
}
