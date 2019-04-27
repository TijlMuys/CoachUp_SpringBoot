package be.ehb.trends3.coachupbackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Sport {
    @Id
    @NotNull
    private String sportName;

    //Images provided by unsplash
    private String imageUrl;

    @JsonBackReference
    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL)
    private List<Lesson> lessons = new ArrayList<Lesson>();

    @JsonBackReference
    @ManyToMany(mappedBy="sports")
    private List<Sporter> sporters = new ArrayList<Sporter>();

    @JsonBackReference
    @ManyToMany(mappedBy="sports")
    private List<SportStatistic> sportStatistics = new ArrayList<SportStatistic>();




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
}
