package com.dmcs.karol.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @NotNull
    @Column(nullable = false)
    @Size(min = 2, max = 30, message = "{error.size.firstName}")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    @NotNull
    @Column(unique = true)
    private String email;

    private String telephone;

    @JsonIgnore
    @NotNull
    private String password;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUserRole> appUserRole = new HashSet<AppUserRole>(0);

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Pesel pesel;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private CardPatient cardPatient;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private CardDoctor cardDoctor;

    private String activationCode;

    @Transient
    private int nrRoli;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<AppUserRole> getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(Set<AppUserRole> appUserRole) {
        this.appUserRole = appUserRole;
    }

    public Pesel getPesel() {
        return pesel;
    }

    public void setPesel(Pesel pesel) {
        this.pesel = pesel;
    }

    public int getNrRoli() {
        return nrRoli;
    }

    public void setNrRoli(int nrRoli) {
        this.nrRoli = nrRoli;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public CardPatient getCardPatient() {
        return cardPatient;
    }

    public void setCardPatient(CardPatient cardPatient) {
        this.cardPatient = cardPatient;
    }

    public CardDoctor getCardDoctor() {
        return cardDoctor;
    }

    public void setCardDoctor(CardDoctor cardDoctor) {
        this.cardDoctor = cardDoctor;
    }

}