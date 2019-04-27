package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.NotLoggedInException;
import be.ehb.trends3.coachupbackend.Exceptions.CoachNotFoundException;
import be.ehb.trends3.coachupbackend.Models.Coach;
import be.ehb.trends3.coachupbackend.Repositories.CoachRepository;
import be.ehb.trends3.coachupbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "3000")
@CrossOrigin(origins = "*")
@RequestMapping("/Coaches")
public class CoachController {

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("")
    public Iterable<Coach> findAll (@RequestHeader String authToken)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return coachRepository.findAll();
    }

    @GetMapping("/{Id}")
    public Coach findById (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return coachRepository.findById(Id).orElseThrow(CoachNotFoundException::new);
    }

    @GetMapping("/search/{accountId}")
    public Coach findByAccountId (@RequestHeader String authToken, @PathVariable String accountId)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        List<Coach> coachList = coachRepository.findCoachByAccountId(accountId);
        if(coachList.size() != 1) {
            throw new CoachNotFoundException();
        }
        Coach foundcoach = coachList.get(0);
        return foundcoach;
    }

    @PostMapping("")
    public Coach create (@RequestHeader String authToken, @RequestBody Coach coach)
    {

        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        coach.setId(null);
        return coachRepository.save(coach);
    }

    @PutMapping("/{Id}")
    public Coach update (@RequestHeader String authToken, @PathVariable String Id, @RequestBody Coach coach)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! coachRepository.existsById(Id))
        {
            throw new CoachNotFoundException();
        }

        return coachRepository.save(coach);
    }

    @DeleteMapping("/{Id}")
    public void delete (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! coachRepository.existsById(Id))
        {
            throw new CoachNotFoundException();
        }

        coachRepository.deleteById(Id);
    }


}
