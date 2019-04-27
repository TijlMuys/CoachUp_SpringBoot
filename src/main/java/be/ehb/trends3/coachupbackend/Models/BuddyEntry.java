package be.ehb.trends3.coachupbackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BuddyEntry {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    Date meetingDateTime;

    boolean isApproved;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn
    private Location buddyLocation;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Sporter requestingsporter;

    @JsonBackReference
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

    public BuddyEntry(Date meetingDateTime, boolean isApproved, Location buddyLocation, Sporter requestingsporter, Sporter replyingsporter) {
        this.meetingDateTime = meetingDateTime;
        this.isApproved = isApproved;
        this.buddyLocation = buddyLocation;
        this.requestingsporter = requestingsporter;
        this.replyingsporter = replyingsporter;
    }
}
