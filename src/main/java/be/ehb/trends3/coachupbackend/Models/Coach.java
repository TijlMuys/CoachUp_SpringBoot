package be.ehb.trends3.coachupbackend.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

public class Coach {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String id;

    private String profileText;

    @OneToOne(mappedBy = "coach", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = true)
    private Account account;

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
    private Set<Rating> ratings;

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
    private Set<Lesson> lessons;

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
    private Set<TrainEntry> trainEntries;

    public Coach() {
    }

    public String getId() {
        return id;
    }

    public String getProfileText() {
        return profileText;
    }

    public void setProfileText(String profileText) {
        this.profileText = profileText;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
        if (account == null) {
            if (this.account != null) {
                this.account.setCoach(null);
            }
        }
        else {
            account.setCoach(this);
        }
        this.account = account;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Set<TrainEntry> getTrainEntries() {
        return trainEntries;
    }

    public void setTrainEntries(Set<TrainEntry> trainEntries) {
        this.trainEntries = trainEntries;
    }
}
