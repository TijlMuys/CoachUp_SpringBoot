package be.ehb.trends3.coachupbackend.Repositories;

import be.ehb.trends3.coachupbackend.Models.Location;
import org.springframework.data.repository.CrudRepository;


public interface LocationRepository extends CrudRepository<Location, String> {
}
