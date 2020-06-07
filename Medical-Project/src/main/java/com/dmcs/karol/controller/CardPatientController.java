package com.dmcs.karol.controller;


import com.dmcs.karol.dao.VisitRepository;
import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.domain.CardPatient;
import com.dmcs.karol.domain.Visit;
import com.dmcs.karol.service.AppUserService;
import com.dmcs.karol.service.CardPatientService;
import com.dmcs.karol.utils.AppDemoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class CardPatientController {

    private CardPatientService cardPatientService;
    private MessageSource messageSource;
    private AppUserService appUserService;
    private VisitRepository visitRepository;

    public CardPatientController(CardPatientService cardPatientService, MessageSource messageSource,
                                 AppUserService appUserService, VisitRepository visitRepository) {
        this.cardPatientService = cardPatientService;
        this.messageSource = messageSource;
        this.appUserService = appUserService;
        this.visitRepository = visitRepository;
    }

    private static final Logger LOG = LoggerFactory.getLogger(CardPatientController.class);

    @GET
    @RequestMapping(value = {"/patient/cardPatient"})
    public String showMainCard(Model model) throws IOException {
        String username = AppDemoUtils.getLoggedUser();
        AppUser user = appUserService.findByEmail(username);
        CardPatient cardPatient = user.getCardPatient();


        model.addAttribute("user", user);
        model.addAttribute("card", cardPatient);

        return "patient/cardPatient";
    }

    @GET
    @RequestMapping(value = {"/patient/inputCardPatient"})
    public String showMainInputCard(CardPatient cardPatient, Model model) {


        return "patient/inputCardPatient";
    }


    @POST
    @RequestMapping(value = "/patient/addCardPatient")
    public String cardPatientAction(CardPatient cardPatient, AppUser appUser, BindingResult result, Model model, Locale locale) {
        String returnPage = null;


        if (result.hasErrors()) {
            System.out.println("Tutaj mamy błąd bez zapisu.");
            return "patient/inputCardPatient";
        } else {
            cardPatientService.saveCardPatient(cardPatient, appUser);
            //   model.addAttribute("message", messageSource.getMessage("cardPatient.add.success", null, locale));
            model.addAttribute("cardPatient", new CardPatient());
            returnPage = "redirect:/patient/cardPatient";
        }
        return returnPage;
    }


    @GET
    @RequestMapping(value = {"/patient/visitsPatient"})
    public String showVisitPatient(CardPatient cardPatient, Visit visit, Model model) {

        List<Visit> listVisitDoctorAll = visitRepository.findAll();
        List<Visit> listVisitDoctor = new ArrayList<>();
        for (Visit x : listVisitDoctorAll) {
            if (x.getActive() == 1) {
                listVisitDoctor.add(x);
            }
        }
        model.addAttribute("listVisit", listVisitDoctor);

        return "patient/visitsPatient";
    }

    @POST
    @RequestMapping(value = {"/patient/saveMyVisit/{id}"})
    public String myVisits(@PathVariable long id, Model model) {

        String username = AppDemoUtils.getLoggedUser();
        AppUser user = appUserService.findByEmail(username);
        CardPatient cardPatient1 = user.getCardPatient();
        Visit visit = visitRepository.findOne(id);
        visitRepository.updateVisit(cardPatient1, 0, visit.getId());

        return "patient/visitsPatient";
    }

    @GET
    @RequestMapping(value = {"/patient/myVisits"})
    public String showMainInputCardPatient(CardPatient cardPatient, Visit visit, Model model) {
        String username = AppDemoUtils.getLoggedUser();
        AppUser user = appUserService.findByEmail(username);


        model.addAttribute("listVisit", visitRepository.findAllByCardPatient(user.getCardPatient()));
        model.addAttribute("user", user);

        return "patient/myVisits";
    }

}
