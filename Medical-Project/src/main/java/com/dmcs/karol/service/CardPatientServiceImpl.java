package com.dmcs.karol.service;

import com.dmcs.karol.dao.CardPatientRepository;
import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.domain.CardPatient;
import com.dmcs.karol.utils.AppDemoUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class CardPatientServiceImpl implements CardPatientService {

    private CardPatientRepository cardPatientRepository;
    private AppUserService appUserService;

    public CardPatientServiceImpl(CardPatientRepository cardPatientRepository, AppUserService appUserService) {
        this.cardPatientRepository = cardPatientRepository;
        this.appUserService = appUserService;
    }

    @Transactional
    public void saveCardPatient(CardPatient cardPatient, AppUser appUser) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
//        try {
//            cardPatient.setData(cardPatient.getPhoto().getBytes());
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        cardPatient.setRegistrationDate(dateFormat.format(date));
        String username = AppDemoUtils.getLoggedUser();
        AppUser user = appUserService.findByEmail(username);
        cardPatient.setAppUser(user);

        user.setCardPatient(cardPatient);


        cardPatientRepository.save(cardPatient);
    }

    @Transactional
    public CardPatient findById(int id) {
        return cardPatientRepository.findById(id);
    }

}
