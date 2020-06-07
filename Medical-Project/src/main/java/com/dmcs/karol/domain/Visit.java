package com.dmcs.karol.domain;

import com.itextpdf.text.Image;

import javax.persistence.*;

@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String date;

    String hour;

    String describe;

    int active;

    double costVisit;

    @ManyToOne(cascade = CascadeType.ALL)
    private CardDoctor cardDoctor;

    @ManyToOne(fetch = FetchType.EAGER)
    private CardPatient cardPatient;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public CardDoctor getCardDoctor() {
        return cardDoctor;
    }

    public void setCardDoctor(CardDoctor cardDoctor) {
        this.cardDoctor = cardDoctor;
    }

    public CardPatient getCardPatient() {
        return cardPatient;
    }

    public void setCardPatient(CardPatient cardPatient) {
        this.cardPatient = cardPatient;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public double getCostVisit() {
        return costVisit;
    }

    public void setCostVisit(double costVisit) {
        this.costVisit = costVisit;
    }
}