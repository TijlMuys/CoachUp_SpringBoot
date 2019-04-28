package be.ehb.trends3.coachupbackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Coach {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String id;

    @Column(columnDefinition = "TEXT")
    private String profileText;

    private String profileImg;

    @JsonManagedReference(value = "coach_account")
    @OneToOne(mappedBy = "coach", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = true)
    private Account account;

    @JsonManagedReference(value = "coach_rating")
    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
    private Set<Rating> ratings;

    @JsonManagedReference(value = "coach_lesson")
    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    @JsonManagedReference(value = "coach_trainentry")
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

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
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

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Set<TrainEntry> getTrainEntries() {
        return trainEntries;
    }

    public void setTrainEntries(Set<TrainEntry> trainEntries) {
        this.trainEntries = trainEntries;
    }

    public Coach(String profileText, Account account, Set<Rating> ratings, List<Lesson> lessons, Set<TrainEntry> trainEntries) {
        this.profileText = profileText;
        this.account = account;
        this.ratings = ratings;
        this.lessons = lessons;
        this.trainEntries = trainEntries;
    }
}
