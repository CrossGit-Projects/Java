package com.dmcs.karol.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class CardDoctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private AppUser appUser;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "cardDoctor")
    private List<Visit> visitsListCard;

    String specialization;

    String city;

    String street;

    String localNumber;

    String registrationDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Visit> getVisitsListCard() {
        return visitsListCard;
    }

    public void setVisitsListCard(List<Visit> visitsListCard) {
        this.visitsListCard = visitsListCard;
    }
}
