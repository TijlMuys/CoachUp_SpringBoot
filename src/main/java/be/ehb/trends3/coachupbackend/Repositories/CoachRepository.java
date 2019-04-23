package be.ehb.trends3.coachupbackend.Repositories;

import be.ehb.trends3.coachupbackend.Models.Coach;
import org.springframework.data.repository.CrudRepository;


public interface CoachRepository extends CrudRepository<Coach, String> {
}
