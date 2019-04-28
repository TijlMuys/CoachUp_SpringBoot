package be.ehb.trends3.coachupbackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Sporter {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String id;

    @Column(columnDefinition = "TEXT")
    private String profileText;

    private String profileImg;

    @JsonManagedReference(value = "sporter_account")
    @OneToOne(mappedBy = "sporter", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = true)
    private Account account;

    //@JsonManagedReference(value = "sporter_sport")
    @ManyToMany    @JoinTable(name = "sporter_sport",
            joinColumns = { @JoinColumn(name = "fk_sporter") },
            inverseJoinColumns = { @JoinColumn(name = "fk_sport") })
    private List<Sport> sports = new ArrayList<Sport>();

    //@JsonManagedReference(value = "sporter_sportstatistic")
    @ManyToMany
    @JoinTable(name = "sporter_sportstatistics",
            joinColumns = { @JoinColumn(name = "fk_sporter") },
            inverseJoinColumns = { @JoinColumn(name = "fk_sportstatistics") })
    private List<SportStatistic> sportstatistics = new ArrayList<SportStatistic>();

    @JsonManagedReference(value = "sporter_trainentry")
    @OneToMany(mappedBy = "sporter", cascade = CascadeType.ALL)
    private Set<TrainEntry> trainEntries;

    @JsonManagedReference(value = "reqsporter_buddyentry")
    @OneToMany(mappedBy = "requestingsporter", cascade = CascadeType.ALL)
    private Set<BuddyEntry> buddyrequests;

    @JsonManagedReference(value = "repsporter_buddyentry")
    @OneToMany(mappedBy = "replyingsporter", cascade = CascadeType.ALL)
    private Set<BuddyEntry> buddyreplies;

    public Sporter() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
        if (account == null) {
            if (this.account != null) {
                this.account.setSporter(null);
            }
        }
        else {
            account.setSporter(this);
        }
        this.account = account;
    }

    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    public List<SportStatistic> getSportstatistics() {
        return sportstatistics;
    }

    public void setSportstatistics(List<SportStatistic> sportstatistics) {
        this.sportstatistics = sportstatistics;
    }

    public Set<TrainEntry> getTrainEntries() {
        return trainEntries;
    }

    public void setTrainEntries(Set<TrainEntry> trainEntries) {
        this.trainEntries = trainEntries;
    }

    public Set<BuddyEntry> getBuddyrequests() {
        return buddyrequests;
    }

    public void setBuddyrequests(Set<BuddyEntry> buddyrequests) {
        this.buddyrequests = buddyrequests;
    }

    public Set<BuddyEntry> getBuddyreplies() {
        return buddyreplies;
    }

    public void setBuddyreplies(Set<BuddyEntry> buddyreplies) {
        this.buddyreplies = buddyreplies;
    }
}
