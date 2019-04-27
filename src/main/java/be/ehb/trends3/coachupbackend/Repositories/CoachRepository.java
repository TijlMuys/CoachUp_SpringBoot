package be.ehb.trends3.coachupbackend.Repositories;

import be.ehb.trends3.coachupbackend.Models.Coach;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CoachRepository extends CrudRepository<Coach, String> {
    public List<Coach> findCoachByAccountId(String id);
}
