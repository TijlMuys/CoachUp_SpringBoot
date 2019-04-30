package be.ehb.trends3.coachupbackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class BuddyEntry {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String id;

    Date meetingDateTime;

    boolean isApproved;

    @NotNull
    private String buddyEntryTitle;

    @Column(columnDefinition = "TEXT")
    private String buddyEntryDescription;

    @JsonManagedReference(value = "buddyentry_location")
    @ManyToOne
    @JoinColumn
    private Location buddyLocation;

    @NotNull
    private int difficulty;

    @JsonManagedReference(value = "buddyentry_sport")
    @ManyToOne
    @JoinColumn
    private Sport sport;

    @JsonBackReference(value = "reqsporter_buddyentry")
    @ManyToOne
    @JoinColumn(name = "req_sporter_key")
    private Sporter requestingsporter;

    @Column(name = "req_sporter_key", insertable = false, updatable = false)
    private String req_sporter_key;

    @JsonBackReference(value = "repsporter_buddyentry")
    @ManyToOne
    @JoinColumn
    private Sporter replyingsporter;

    public BuddyEntry() {
        this.isApproved = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getMeetingDateTime() {
        return meetingDateTime;
    }

    public void setMeetingDateTime(Date meetingDateTime) {
        this.meetingDateTime = meetingDateTime;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public Location getBuddyLocation() {
        return buddyLocation;
    }

    public void setBuddyLocation(Location buddyLocation) {
        this.buddyLocation = buddyLocation;
    }

    public Sporter getRequestingsporter() {
        return requestingsporter;
    }

    public void setRequestingsporter(Sporter requestingsporter) {
        this.requestingsporter = requestingsporter;
    }

    public Sporter getReplyingsporter() {
        return replyingsporter;
    }

    public void setReplyingsporter(Sporter replyingsporter) {
        this.replyingsporter = replyingsporter;
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

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getReq_sporter_key() {
        return req_sporter_key;
    }

    public void setReq_sporter_key(String req_sporter_key) {
        this.req_sporter_key = req_sporter_key;
    }


}
