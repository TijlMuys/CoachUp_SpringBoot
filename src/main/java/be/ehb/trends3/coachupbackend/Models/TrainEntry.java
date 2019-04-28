package be.ehb.trends3.coachupbackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TrainEntry {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    Date meetingDateTime;

    @JsonBackReference(value = "coach_trainentry")
    @ManyToOne
    @JoinColumn
    private Coach coach;

    @JsonBackReference(value = "sporter_trainentry")
    @ManyToOne
    @JoinColumn
    private Sporter sporter;

    @JsonManagedReference(value = "trainentry_location")
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

    public TrainEntry(Date meetingDateTime, Coach coach, Sporter sporter, Location trainLocation) {
        this.meetingDateTime = meetingDateTime;
        this.coach = coach;
        this.sporter = sporter;
        this.trainLocation = trainLocation;
    }
}
