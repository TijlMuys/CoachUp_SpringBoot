package be.ehb.trends3.coachupbackend.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Lesson {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String id;

    @NotNull
    private String lessonName;

    private int difficulty;

    @ManyToOne
    @JoinColumn
    private Location lessonLocation;

    @ManyToOne
    @JoinColumn
    private Coach coach;

    @ManyToMany
    @JoinTable(name = "lesson_sport",
            joinColumns = { @JoinColumn(name = "fk_lesson") },
            inverseJoinColumns = { @JoinColumn(name = "fk_sport") })
    private List<Sport> sports = new ArrayList<Sport>();

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

    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }
}
