package be.ehb.trends3.coachupbackend.Repositories;

import be.ehb.trends3.coachupbackend.Models.Lesson;
import org.springframework.data.repository.CrudRepository;


public interface LessonRepository extends CrudRepository<Lesson, String> {
}
