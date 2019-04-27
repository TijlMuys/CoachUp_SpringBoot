package be.ehb.trends3.coachupbackend.Repositories;


import be.ehb.trends3.coachupbackend.Models.Sporter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SporterRepository extends CrudRepository<Sporter, String> {
    public List<Sporter> findSporterByAccountId(String id);
}
