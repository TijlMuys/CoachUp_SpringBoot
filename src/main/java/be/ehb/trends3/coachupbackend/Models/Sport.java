package be.ehb.trends3.coachupbackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Sport {
    @Id
    @NotNull
    private String sportName;

    //Images provided by unsplash
    private String imageUrl;

    @JsonBackReference(value = "lesson_sport")
    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL)
    private List<Lesson> lessons = new ArrayList<Lesson>();

    @JsonBackReference(value = "sporter_sport")
    @ManyToMany(mappedBy="sports")
    private List<Sporter> sporters = new ArrayList<Sporter>();

    //@JsonBackReference(value = "sportstatistic_sport")
    @ManyToMany(mappedBy="sports")
    private List<SportStatistic> sportStatistics = new ArrayList<SportStatistic>();


    @JsonBackReference(value = "buddyentry_sport")
    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL)
    private List<BuddyEntry> buddyEntries = new ArrayList<BuddyEntry>();


    public Sport() {
    }

    public Sport(@NotNull String sportName) {
        this.sportName = sportName;
    }

    public Sport(@NotNull String sportName, String imageUrl) {
        this.sportName = sportName;
        this.imageUrl = imageUrl;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Sporter> getSporters() {
        return sporters;
    }

    public void setSporters(List<Sporter> sporters) {
        this.sporters = sporters;
    }

    public List<SportStatistic> getSportStatistics() {
        return sportStatistics;
    }

    public void setSportStatistics(List<SportStatistic> sportStatistics) {
        this.sportStatistics = sportStatistics;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Sport(@NotNull String sportName, List<Lesson> lessons, List<Sporter> sporters, List<SportStatistic> sportStatistics, String imageUrl) {
        this.sportName = sportName;
        this.lessons = lessons;
        this.sporters = sporters;
        this.sportStatistics = sportStatistics;
        this.imageUrl = imageUrl;
    }

    public List<BuddyEntry> getBuddyEntries() {
        return buddyEntries;
    }

    public void setBuddyEntries(List<BuddyEntry> buddyEntries) {
        this.buddyEntries = buddyEntries;
    }
}
