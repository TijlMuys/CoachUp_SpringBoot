package be.ehb.trends3.coachupbackend.Repositories;

import be.ehb.trends3.coachupbackend.Models.Sport;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SportRepository extends CrudRepository<Sport, String> {
    public List<Sport> findAllByOrderBySportNameAsc();
}
