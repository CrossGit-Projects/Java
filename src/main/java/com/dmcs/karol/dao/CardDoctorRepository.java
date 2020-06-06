package com.dmcs.karol.dao;


import com.dmcs.karol.domain.CardDoctor;
import com.dmcs.karol.domain.CardPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CardDoctorRepository extends JpaRepository<CardDoctor, Long> {
    CardDoctor findById(long id);
}
