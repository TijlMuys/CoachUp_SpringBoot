package be.ehb.trends3.coachupbackend.Repositories;

import be.ehb.trends3.coachupbackend.Models.Sport;
import org.springframework.data.repository.CrudRepository;


public interface SportRepository extends CrudRepository<Sport, String> {
}
