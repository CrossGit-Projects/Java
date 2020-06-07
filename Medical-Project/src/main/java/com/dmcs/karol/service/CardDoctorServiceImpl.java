package com.dmcs.karol.service;

import com.dmcs.karol.dao.CardDoctorRepository;
import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.domain.CardDoctor;
import com.dmcs.karol.utils.AppDemoUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CardDoctorServiceImpl implements CardDoctorService {

    private CardDoctorRepository cardDoctorRepository;
    private AppUserService appUserService;

    public CardDoctorServiceImpl(CardDoctorRepository cardDoctorRepository, AppUserService appUserService) {
        this.cardDoctorRepository = cardDoctorRepository;
        this.appUserService = appUserService;
    }

    @Transactional
    public void saveCardDoctor(CardDoctor cardDoctor) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        cardDoctor.setRegistrationDate(dateFormat.format(date));
        String username = AppDemoUtils.getLoggedUser();
        AppUser user = appUserService.findByEmail(username);
        cardDoctor.setAppUser(user);

        user.setCardDoctor(cardDoctor);
        cardDoctorRepository.save(cardDoctor);
    }

    @Transactional
    public CardDoctor findById(int id) {
        return cardDoctorRepository.findById(id);
    }


}
