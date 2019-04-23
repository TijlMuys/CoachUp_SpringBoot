package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.LessonNotFoundException;
import be.ehb.trends3.coachupbackend.Exceptions.NotLoggedInException;
import be.ehb.trends3.coachupbackend.Models.Lesson;
import be.ehb.trends3.coachupbackend.Repositories.LessonRepository;
import be.ehb.trends3.coachupbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "3000")
@CrossOrigin(origins = "*")
@RequestMapping("/Lessons")
public class LessonController {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("")
    public Iterable<Lesson> findAll (@RequestHeader String authToken)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return lessonRepository.findAll();
    }

    @GetMapping("/{Id}")
    public Lesson findById (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return lessonRepository.findById(Id).orElseThrow(LessonNotFoundException::new);
    }

    @PostMapping("")
    public Lesson create (@RequestHeader String authToken, @RequestBody Lesson lesson)
    {

        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        lesson.setId(null);
        return lessonRepository.save(lesson);
    }

    @PutMapping("/{Id}")
    public Lesson update (@RequestHeader String authToken, @PathVariable String Id, @RequestBody Lesson lesson)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! lessonRepository.existsById(Id))
        {
            throw new LessonNotFoundException();
        }

        return lessonRepository.save(lesson);
    }

    @DeleteMapping("/{Id}")
    public void delete (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! lessonRepository.existsById(Id))
        {
            throw new LessonNotFoundException();
        }

        lessonRepository.deleteById(Id);
    }


}
