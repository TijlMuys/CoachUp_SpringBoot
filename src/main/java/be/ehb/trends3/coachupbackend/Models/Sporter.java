package be.ehb.trends3.coachupbackend.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Sporter {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String id;

    private String profileText;

    @OneToOne(mappedBy = "sporter", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = true)
    private Account account;

    @ManyToMany
    @JoinTable(name = "sporter_sport",
            joinColumns = { @JoinColumn(name = "fk_sporter") },
            inverseJoinColumns = { @JoinColumn(name = "fk_sport") })
    private List<Sport> sports = new ArrayList<Sport>();

    @ManyToMany
    @JoinTable(name = "sporter_sportstatistics",
            joinColumns = { @JoinColumn(name = "fk_sporter") },
            inverseJoinColumns = { @JoinColumn(name = "fk_sportstatistics") })
    private List<SportStatistic> sportstatistics = new ArrayList<SportStatistic>();

    @OneToMany(mappedBy = "sporter", cascade = CascadeType.ALL)
    private Set<TrainEntry> trainEntries;

    @OneToMany(mappedBy = "requestingsporter", cascade = CascadeType.ALL)
    private Set<BuddyEntry> buddyrequests;

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
}
