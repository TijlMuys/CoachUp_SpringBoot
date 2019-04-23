package be.ehb.trends3.coachupbackend.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Sport {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String id;

    @NotNull
    private String sportName;

    @ManyToMany(mappedBy="sports")
    private List<Lesson> lessons = new ArrayList<Lesson>();

    @ManyToMany(mappedBy="sports")
    private List<Sporter> sporters = new ArrayList<Sporter>();

    @ManyToMany(mappedBy="sports")
    private List<SportStatistic> sportStatistics = new ArrayList<SportStatistic>();

    public Sport(@NotNull String sportName) {
        this.sportName = sportName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
