package be.ehb.trends3.coachupbackend.Repositories;

import be.ehb.trends3.coachupbackend.Models.Rating;
import org.springframework.data.repository.CrudRepository;


public interface RatingRepository extends CrudRepository<Rating, String> {
}
