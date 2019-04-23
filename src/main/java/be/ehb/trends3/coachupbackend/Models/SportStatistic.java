package be.ehb.trends3.coachupbackend.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class SportStatistic {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String id;

    @ManyToMany
    @JoinTable(name = "sportstatistic_sport",
            joinColumns = { @JoinColumn(name = "fk_sportstatistic") },
            inverseJoinColumns = { @JoinColumn(name = "fk_sport") })
    private List<Sport> sports = new ArrayList<Sport>();

    @ManyToMany(mappedBy="sportstatistics")
    private List<Sporter> sporters = new ArrayList<Sporter>();

    private int proficiency;

    public SportStatistic() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    public List<Sporter> getSporters() {
        return sporters;
    }

    public void setSporters(List<Sporter> sporters) {
        this.sporters = sporters;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }
}
