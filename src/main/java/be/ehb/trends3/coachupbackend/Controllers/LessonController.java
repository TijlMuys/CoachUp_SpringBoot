package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.*;
import be.ehb.trends3.coachupbackend.Models.*;
import be.ehb.trends3.coachupbackend.Repositories.CoachRepository;
import be.ehb.trends3.coachupbackend.Repositories.LessonRepository;
import be.ehb.trends3.coachupbackend.Repositories.LocationRepository;
import be.ehb.trends3.coachupbackend.Repositories.SportRepository;
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
    private LocationRepository locationRepository;

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private CoachRepository coachRepository;

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

    @PostMapping("/create")
    public Lesson createNew (@RequestHeader String authToken, @RequestBody LessonNewRequest lessonNewRequest)
    {

        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        //Find Coach
        Coach foundCoach = coachRepository.findById(lessonNewRequest.getCoachId()).orElseThrow(CoachNotFoundException::new);
        //create New Location
        Location newLocation = new Location();
        //modify location
        newLocation.setStreet(lessonNewRequest.getStreet());
        newLocation.setNumber(lessonNewRequest.getNumber());
        newLocation.setZipCode(lessonNewRequest.getZipCode());
        newLocation.setCity(lessonNewRequest.getCity());
        newLocation.setCoordinates(lessonNewRequest.getCoordinates());
        //save Location
        locationRepository.save(newLocation);
        //Get Sport
        Sport foundSport = sportRepository.findById(lessonNewRequest.getSport()).orElseThrow(SportNotFoundException::new);
        //Create New lesson
        Lesson newLesson = new Lesson();
        //modify lesson
        newLesson.setLessonName(lessonNewRequest.getLessonName());
        newLesson.setLessonDescription(lessonNewRequest.getLessonDescription());
        newLesson.setDifficulty(lessonNewRequest.getDifficulty());
        newLesson.setSport(foundSport);
        newLesson.setCoach(foundCoach);
        newLesson.setLessonLocation(newLocation);
        return lessonRepository.save(newLesson);
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

    @PostMapping("/update")
    public Lesson update (@RequestHeader String authToken, @RequestBody LessonUpdateRequest lessonUpdateRequest)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        //Get location
        Location foundLocation = locationRepository.findById(lessonUpdateRequest.getLocationId()).orElseThrow(LocationNotFoundException::new);
        //modify location
        foundLocation.setStreet(lessonUpdateRequest.getStreet());
        foundLocation.setNumber(lessonUpdateRequest.getNumber());
        foundLocation.setZipCode(lessonUpdateRequest.getZipCode());
        foundLocation.setCity(lessonUpdateRequest.getCity());
        foundLocation.setCoordinates(lessonUpdateRequest.getCoordinates());
        //save Location
        locationRepository.save(foundLocation);
        //Get Sport
        Sport foundSport = sportRepository.findById(lessonUpdateRequest.getSport()).orElseThrow(SportNotFoundException::new);
        //Get Lesson
        Lesson foundLesson = lessonRepository.findById(lessonUpdateRequest.getId()).orElseThrow(LessonNotFoundException::new);
        //modify lesson
        foundLesson.setLessonName(lessonUpdateRequest.getLessonName());
        foundLesson.setLessonDescription(lessonUpdateRequest.getLessonDescription());
        foundLesson.setDifficulty(lessonUpdateRequest.getDifficulty());
        foundLesson.setSport(foundSport);

        return lessonRepository.save(foundLesson);
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
