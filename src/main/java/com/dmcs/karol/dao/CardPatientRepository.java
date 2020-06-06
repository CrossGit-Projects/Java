package com.dmcs.karol.dao;

import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.domain.CardPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CardPatientRepository extends JpaRepository<CardPatient, Long> {

    CardPatient findById(long id);

}