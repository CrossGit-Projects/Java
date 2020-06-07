package com.dmcs.karol.service;

import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.domain.CardDoctor;
import com.dmcs.karol.domain.CardPatient;

public interface CardDoctorService {

    void saveCardDoctor(CardDoctor cardDoctor);

    CardDoctor findById(int id);
}
