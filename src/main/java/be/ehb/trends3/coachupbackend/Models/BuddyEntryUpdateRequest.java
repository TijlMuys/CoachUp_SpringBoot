package be.ehb.trends3.coachupbackend.Models;

public class BuddyEntryUpdateRequest {

    private String id;

    private String sporterId;

    private String buddyEntryTitle;

    private String buddyEntryDescription;

    private int difficulty;

    private String meetingDateTime;

    private String sport;

    private String locationId;

    private String street;

    private String number;

    private String zipCode;

    private String city;

    private String coordinates;

    public BuddyEntryUpdateRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSporterId() {
        return sporterId;
    }

    public void setSporterId(String sporterId) {
        this.sporterId = sporterId;
    }

    public String getBuddyEntryTitle() {
        return buddyEntryTitle;
    }

    public void setBuddyEntryTitle(String buddyEntryTitle) {
        this.buddyEntryTitle = buddyEntryTitle;
    }

    public String getBuddyEntryDescription() {
        return buddyEntryDescription;
    }

    public void setBuddyEntryDescription(String buddyEntryDescription) {
        this.buddyEntryDescription = buddyEntryDescription;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getMeetingDateTime() {
        return meetingDateTime;
    }

    public void setMeetingDateTime(String meetingDateTime) {
        this.meetingDateTime = meetingDateTime;
    }

    public String getSport() {
        return sport;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public void setSport(String sport) {
        this.sport = sport;
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
}
