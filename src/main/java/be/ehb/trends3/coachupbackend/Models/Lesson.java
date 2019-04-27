package be.ehb.trends3.coachupbackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String id;

    @NotNull
    private String lessonName;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String lessonDescription;

    @NotNull
    private int difficulty;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn
    private Location lessonLocation;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "coach_key")
    private Coach coach;

    @Column(name = "coach_key", insertable = false, updatable = false)
    private String coach_key;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn
    private Sport sport;

    public Lesson() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Location getLessonLocation() {
        return lessonLocation;
    }

    public void setLessonLocation(Location lessonLocation) {
        this.lessonLocation = lessonLocation;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public String getCoach_key() {
        return coach_key;
    }

    public void setCoach_key(String coach_key) {
        this.coach_key = coach_key;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }
}
