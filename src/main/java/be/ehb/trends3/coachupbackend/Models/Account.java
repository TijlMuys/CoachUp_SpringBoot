package be.ehb.trends3.coachupbackend.Models;

import com.fasterxml.jackson.annotation.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@JsonIgnoreProperties(value={ "password" }, allowSetters= true)
public class Account {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String id;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String userName;

    @JsonProperty("password")
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

    private String coordinates;

    @NotNull
    private Boolean agreedConditions;

    private String phone;


    @JsonBackReference(value = "sporter_account")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sporter_id")
    private Sporter sporter;


    @JsonBackReference(value = "coach_account")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id")
    private Coach coach;

    public Account() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public Boolean getAgreedConditions() {
        return agreedConditions;
    }

    public void setAgreedConditions(Boolean agreedConditions) {
        this.agreedConditions = agreedConditions;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Sporter getSporter() {
        return sporter;
    }

    public void setSporter(Sporter sporter) {
        this.sporter = sporter;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Account(@NotNull String email, @NotNull String userName, @NotNull String password, @NotNull String accountType, @NotNull String street, @NotNull String number, @NotNull String zipCode, @NotNull String city, String coordinates, @NotNull Boolean agreedConditions, String phone, Sporter sporter, Coach coach) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.accountType = accountType;
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.coordinates = coordinates;
        this.agreedConditions = agreedConditions;
        this.phone = phone;
        this.sporter = sporter;
        this.coach = coach;
    }
}
