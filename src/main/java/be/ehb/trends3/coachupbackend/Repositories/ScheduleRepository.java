package be.ehb.trends3.coachupbackend.Repositories;

import be.ehb.trends3.coachupbackend.Models.Schedule;
import org.springframework.data.repository.CrudRepository;


public interface ScheduleRepository extends CrudRepository<Schedule, String> {
}
