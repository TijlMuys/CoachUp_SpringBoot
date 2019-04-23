package be.ehb.trends3.coachupbackend.Repositories;

import be.ehb.trends3.coachupbackend.Models.TrainEntry;
import org.springframework.data.repository.CrudRepository;


public interface TrainEntryRepository extends CrudRepository<TrainEntry, String> {
}
