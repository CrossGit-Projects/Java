package com.dmcs.karol.controller;


import com.dmcs.karol.dao.VisitRepository;
import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.domain.CardDoctor;
import com.dmcs.karol.domain.Visit;
import com.dmcs.karol.service.AppUserService;
import com.dmcs.karol.service.CardDoctorService;
import com.dmcs.karol.utils.AppDemoUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class CardDoctorController {

    private CardDoctorService cardDoctorService;
    private AppUserService appUserService;
    private VisitRepository visitRepository;

    public CardDoctorController(CardDoctorService cardDoctorService, AppUserService appUserService, VisitRepository visitRepository) {
        this.cardDoctorService = cardDoctorService;
        this.appUserService = appUserService;
        this.visitRepository = visitRepository;
    }

    @GET
    @RequestMapping(value = {"/doctor/cardDoctor"})
    public String showMainInputCardDoctor(CardDoctor cardDoctor, Visit visit, Model model) {
        String username = AppDemoUtils.getLoggedUser();
        AppUser user = appUserService.findByEmail(username);


        try {
            CardDoctor cardDoctor1 = user.getCardDoctor();
            long idCard = cardDoctor1.getId();
            List<Visit> listVisitDoctorAll = visitRepository.findAll();
            List<Visit> listVisitDoctor = new ArrayList<>();
            for (Visit x : listVisitDoctorAll) {
                if (x.getCardDoctor().getId() == idCard) {
                    listVisitDoctor.add(x);
                }
            }
            model.addAttribute("listVisit", listVisitDoctor);
            model.addAttribute("card", cardDoctor1);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        model.addAttribute("user", user);
        return "doctor/cardDoctor";
    }


    @GET
    @RequestMapping(value = {"/doctor/inputCardDoctor"})
    public String showMainInputCardDoctorInput(CardDoctor cardDoctor, Model model) {
        return "doctor/inputCardDoctor";
    }

    @POST
    @RequestMapping(value = "/doctor/saveCardDoctor")
    public String cardPatientAction(CardDoctor cardDoctor, BindingResult result, Model model, Locale locale) {
        String returnPage = null;

        if (result.hasErrors()) {
            System.out.println("Tutaj mamy błąd bez zapisu.");
            return "doctor/inputCardDoctor";
        } else {
            cardDoctorService.saveCardDoctor(cardDoctor);
            //   model.addAttribute("message", messageSource.getMessage("cardPatient.add.success", null, locale));
            model.addAttribute("cardDoctor", new CardDoctor());
            returnPage = "redirect:/doctor/cardDoctor";
        }
        return returnPage;
    }


}
