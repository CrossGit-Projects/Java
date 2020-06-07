package com.dmcs.karol.service;

import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.domain.Visit;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class PdfServiceImpl implements PdfService {

    public void generatePdf(AppUser appUser, Visit visit, HttpServletResponse response) {
        try {
            OutputStream o = response.getOutputStream();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=" + appUser.getEmail() + ".pdf");
            Document pdf = new Document();
            PdfWriter.getInstance(pdf, o);
            pdf.open();
            pdf.add(new Paragraph("Faktura do zaplaty"));
            pdf.add(new Paragraph(Chunk.NEWLINE));
            PdfPTable table = new PdfPTable(2);
            table.addCell("FirsName");
            table.addCell(appUser.getFirstName());
            table.addCell("LastName");
            table.addCell(appUser.getLastName());
            table.addCell("Email");
            table.addCell(appUser.getEmail());
            table.addCell("Pesel");
            table.addCell(appUser.getPesel().getPESEL());
            table.addCell("City");
            table.addCell(appUser.getCardPatient().getCity());
            table.addCell("Date of Birth");
            table.addCell(appUser.getCardPatient().getDateOfBirth());
            table.addCell("Gender");
            table.addCell(appUser.getCardPatient().getGender());
            table.addCell("Local Number");
            table.addCell(appUser.getCardPatient().getLocalNumber());
            table.addCell("Post Code");
            table.addCell(appUser.getCardPatient().getPostCode());
            table.addCell("Registion Date");
            table.addCell(appUser.getCardPatient().getRegistrationDate());
            table.addCell("Street");
            table.addCell(appUser.getCardPatient().getStreet());
            table.addCell("Date Visit");
            table.addCell(visit.getDate());
            table.addCell("Hour");
            table.addCell(visit.getHour());
            table.addCell("Describe");
            table.addCell(visit.getDescribe());
            table.addCell("Cost Visit");
            table.addCell(String.valueOf(visit.getCostVisit()));
            pdf.add(table);
            pdf.close();
            o.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
