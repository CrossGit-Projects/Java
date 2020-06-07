package com.dmcs.karol.service;

import com.dmcs.karol.domain.CardDoctor;

public interface CardDoctorService {

    void saveCardDoctor(CardDoctor cardDoctor);

    CardDoctor findById(int id);
}
