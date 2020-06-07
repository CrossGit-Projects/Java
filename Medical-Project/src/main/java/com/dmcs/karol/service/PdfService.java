package com.dmcs.karol.service;

import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.domain.Visit;

import javax.servlet.http.HttpServletResponse;

public interface PdfService {
    public void generatePdf(AppUser appUser, Visit visit, HttpServletResponse response);
}