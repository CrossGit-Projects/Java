package com.dmcs.karol.controller;

import com.dmcs.karol.dao.VisitRepository;
import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.domain.CardPatient;
import com.dmcs.karol.domain.Visit;
import com.dmcs.karol.service.AppUserService;
import com.dmcs.karol.service.PdfService;
import com.dmcs.karol.service.VisitService;
import com.dmcs.karol.utils.AppDemoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
public class PdfController {

    private PdfService pdfService;
    private AppUserService appUserService;
    private VisitService visitService;
    private VisitRepository visitRepository;

    @Autowired
    public PdfController(PdfService pdfService, AppUserService appUserService, VisitService visitService, VisitRepository visitRepository) {
        this.pdfService = pdfService;
        this.appUserService = appUserService;
        this.visitService = visitService;
        this.visitRepository = visitRepository;
    }


    @RequestMapping(value = "/patient/generatePdf/{appUserId}/{visitId}", method = RequestMethod.GET)
    public String generatePdf(@PathVariable Integer appUserId, @PathVariable long visitId, HttpServletResponse response) {
        String username = AppDemoUtils.getLoggedUser();
        AppUser user = appUserService.findByEmail(username);
        CardPatient cardPatient1 = user.getCardPatient();
        Visit visit = visitRepository.findOne(visitId);

        System.out.println("AAAAAAAA: " + visit.getCardPatient().getId());
        System.out.println("BBBBBBB: " + cardPatient1.getId());


        if (visit.getCardPatient().getId() == cardPatient1.getId()) {
            pdfService.generatePdf(appUserService.getAppUser(appUserId), visitService.getVisitId(visitId), response);
            return "redirect:/patient/myVisits";
        } else {
            return "redirect:/accessDenied";
        }
    }
}


