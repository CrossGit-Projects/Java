package com.dmcs.karol.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pesel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String PESEL;

//    @JsonBackReference
//    @OneToOne(mappedBy="pesel")
//    private AppUser appUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

//    public AppUser getAppUser() {
//        return appUser;
//    }
//
//    public void setAppUser(AppUser appUser) {
//        this.appUser = appUser;
//    }
}

