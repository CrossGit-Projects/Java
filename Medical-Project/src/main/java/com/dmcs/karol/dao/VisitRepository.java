package com.dmcs.karol.dao;

import com.dmcs.karol.domain.CardDoctor;
import com.dmcs.karol.domain.CardPatient;
import com.dmcs.karol.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
    Visit findById(long id);

    List<Visit> findAllByCardPatient(CardPatient cardPatient);

    List<Visit> findByCardDoctor(CardDoctor cardDoctor);

    @Modifying
    @Query("UPDATE Visit u SET u.cardPatient = :newCardPatient, u.active = :newActive WHERE u.id = :id")
    public void updateVisit(@Param("newCardPatient") CardPatient cardPatient, @Param("newActive") int newActive,  @Param("id") long id);
}