package be.ehb.trends3.coachupbackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


public class NewAccountRequest {


    @NotNull
    private String email;

    @NotNull
    private String userName;

    @NotNull
    private String password;

    @NotNull
    private String accountType;

    @NotNull
    private String street;

    @NotNull
    private String number;

    @NotNull
    private String zipCode;

    @NotNull
    private String city;

    @NotNull
    private Boolean agreedConditions;

    public NewAccountRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getAgreedConditions() {
        return agreedConditions;
    }

    public void setAgreedConditions(Boolean agreedConditions) {
        this.agreedConditions = agreedConditions;
    }
}
