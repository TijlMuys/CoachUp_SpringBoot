package be.ehb.trends3.coachupbackend.Repositories;

import be.ehb.trends3.coachupbackend.Models.BuddyEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BuddyEntryRepository extends CrudRepository<BuddyEntry, String> {
    List<BuddyEntry> findBuddyEntriesBySport_SportNameIsLike(String sport);
}
