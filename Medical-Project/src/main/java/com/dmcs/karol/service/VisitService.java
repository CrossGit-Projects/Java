package com.dmcs.karol.service;

import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.domain.CardDoctor;
import com.dmcs.karol.domain.CardPatient;
import com.dmcs.karol.domain.Visit;

import java.util.List;

public interface VisitService {

    void saveVisit(Visit visit);

    List<Visit> listsVisit(CardDoctor cardDoctor);
    Visit getVisitId(long id);


    public void updateVisit(CardPatient cardPatient, int active, long id);


}
