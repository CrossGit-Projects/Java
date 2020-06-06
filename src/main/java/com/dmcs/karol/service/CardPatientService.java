package com.dmcs.karol.service;

import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.domain.CardPatient;

public interface CardPatientService {


    void saveCardPatient(CardPatient cardPatient, AppUser appUser);

    CardPatient findById(int id);

}
