package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.NotLoggedInException;
import be.ehb.trends3.coachupbackend.Exceptions.ScheduleNotFoundException;
import be.ehb.trends3.coachupbackend.Models.Schedule;
import be.ehb.trends3.coachupbackend.Repositories.ScheduleRepository;
import be.ehb.trends3.coachupbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "3000")
@CrossOrigin(origins = "*")
@RequestMapping("/Schedules")
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("")
    public Iterable<Schedule> findAll (@RequestHeader String authToken)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return scheduleRepository.findAll();
    }

    @GetMapping("/{Id}")
    public Schedule findById (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return scheduleRepository.findById(Id).orElseThrow(ScheduleNotFoundException::new);
    }

    @PostMapping("")
    public Schedule create (@RequestHeader String authToken, @RequestBody Schedule schedule)
    {

        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        schedule.setId(null);
        return scheduleRepository.save(schedule);
    }

    @PutMapping("/{Id}")
    public Schedule update (@RequestHeader String authToken, @PathVariable String Id, @RequestBody Schedule schedule)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! scheduleRepository.existsById(Id))
        {
            throw new ScheduleNotFoundException();
        }

        return scheduleRepository.save(schedule);
    }

    @DeleteMapping("/{Id}")
    public void delete (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! scheduleRepository.existsById(Id))
        {
            throw new ScheduleNotFoundException();
        }

        scheduleRepository.deleteById(Id);
    }


}
