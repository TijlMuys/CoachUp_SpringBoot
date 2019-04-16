package be.ehb.trends3.coachupbackend.Models;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Account {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String AccountId;

    @NotNull
    @Email
    @Column(unique = true)
    private String Email;

    @NotNull
    private String UserName;

    @NotNull
    private String Password;

    @NotNull
    private String AccountType;

    @NotNull
    private String Street;

    @NotNull
    private String Number;

    @NotNull
    private String ZipCode;

    @NotNull
    private String City;

    @NotNull
    private Boolean AgreedConditions;

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Boolean getAgreedConditions() {
        return AgreedConditions;
    }

    public void setAgreedConditions(Boolean agreedConditions) {
        AgreedConditions = agreedConditions;
    }
}
