package be.ehb.trends3.coachupbackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Location {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String id;

    @NotNull
    private String street;

    @NotNull
    private String number;

    @NotNull
    private String zipCode;

    @NotNull
    private String city;

    private String coordinates;

    @JsonBackReference
    @OneToMany(mappedBy = "lessonLocation", cascade = CascadeType.ALL)
    private Set<Lesson> lessons;

    @JsonBackReference
    @OneToMany(mappedBy = "trainLocation", cascade = CascadeType.ALL)
    private Set<TrainEntry> trainentries;

    @JsonBackReference
    @OneToMany(mappedBy = "buddyLocation", cascade = CascadeType.ALL)
    private Set<BuddyEntry> buddyentries;

    public Location() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Set<TrainEntry> getTrainentries() {
        return trainentries;
    }

    public void setTrainentries(Set<TrainEntry> trainentries) {
        this.trainentries = trainentries;
    }

    public Set<BuddyEntry> getBuddyentries() {
        return buddyentries;
    }

    public void setBuddyentries(Set<BuddyEntry> buddyentries) {
        this.buddyentries = buddyentries;
    }

    public Location(@NotNull String street, @NotNull String number, @NotNull String zipCode, @NotNull String city, String coordinates, Set<Lesson> lessons, Set<TrainEntry> trainentries, Set<BuddyEntry> buddyentries) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.coordinates = coordinates;
        this.lessons = lessons;
        this.trainentries = trainentries;
        this.buddyentries = buddyentries;
    }
}
