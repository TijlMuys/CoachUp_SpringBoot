package be.ehb.trends3.coachupbackend.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

public class TrainEntry {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    Date meetingDateTime;

    @ManyToOne
    @JoinColumn
    private Coach coach;

    @ManyToOne
    @JoinColumn
    private Sporter sporter;

    @ManyToOne
    @JoinColumn
    private Location trainLocation;

    public TrainEntry() {
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

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Sporter getSporter() {
        return sporter;
    }

    public void setSporter(Sporter sporter) {
        this.sporter = sporter;
    }

    public Location getTrainLocation() {
        return trainLocation;
    }

    public void setTrainLocation(Location trainLocation) {
        this.trainLocation = trainLocation;
    }
}
