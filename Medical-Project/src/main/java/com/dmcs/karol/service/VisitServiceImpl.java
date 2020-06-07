package com.dmcs.karol.service;


import com.dmcs.karol.dao.CardDoctorRepository;
import com.dmcs.karol.dao.VisitRepository;
import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.domain.CardDoctor;
import com.dmcs.karol.domain.CardPatient;
import com.dmcs.karol.domain.Visit;
import com.dmcs.karol.utils.AppDemoUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {
    private VisitRepository visitRepository;
    private AppUserService appUserService;
    private CardDoctorRepository cardDoctorRepository;

    public VisitServiceImpl(VisitRepository visitRepository, AppUserService appUserService, CardDoctorRepository cardDoctorRepository) {
        this.visitRepository = visitRepository;
        this.appUserService = appUserService;
        this.cardDoctorRepository = cardDoctorRepository;
    }

    @Transactional
    public void saveVisit(Visit visit) {


        String username = AppDemoUtils.getLoggedUser();
        AppUser user = appUserService.findByEmail(username);
        CardDoctor cardDoctor = user.getCardDoctor();
        visit.setCardDoctor(cardDoctor);
        visit.setActive(1);

        List<Visit> myVisits = listsVisit(cardDoctor);

        cardDoctor.setVisitsListCard(myVisits);

        visitRepository.save(visit);


    }

    @Override
    public List<Visit> listsVisit(CardDoctor cardDoctor) {
        return visitRepository.findByCardDoctor(cardDoctor);
    }

    @Transactional
    public void updateVisit(CardPatient cardPatient, int active, long id) {
        visitRepository.updateVisit(cardPatient, active, id);
    }

    @Transactional
    public Visit getVisitId(long id) {

        return visitRepository.findById(id);
    }


}
