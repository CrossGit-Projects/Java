package com.dmcs.karol.controller;

import com.dmcs.karol.domain.CardDoctor;
import com.dmcs.karol.domain.Visit;
import com.dmcs.karol.service.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.Locale;

@Controller
public class VisitController {

    private VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GET
    @RequestMapping(value = {"/doctor/visitDoctor"})
    public String addVisitsDoctor(CardDoctor cardDoctor, Model model) {
        return "doctor/visitDoctor";
    }

    @POST
    @RequestMapping(value = "/doctor/saveVisitDoctor")
    public String addVisitDoctor(Visit visit, BindingResult result, Model model, Locale locale) {
        String returnPage = null;

        if (result.hasErrors()) {
            System.out.println("Tutaj mamy błąd bez zapisu.");
            return "doctor/visitDoctor";
        } else {


            visitService.saveVisit(visit);
            //   model.addAttribute("message", messageSource.getMessage("cardPatient.add.success", null, locale));
            model.addAttribute("visit", new Visit());
            returnPage = "redirect:/doctor/cardDoctor";
        }
        return returnPage;
    }
}
