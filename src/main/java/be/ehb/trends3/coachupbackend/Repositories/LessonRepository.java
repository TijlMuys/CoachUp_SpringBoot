package be.ehb.trends3.coachupbackend.Repositories;

import be.ehb.trends3.coachupbackend.Models.Lesson;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface LessonRepository extends CrudRepository<Lesson, String> {
    public List<Lesson> findLessonsBySport_SportNameIsLike(String sport);
}
