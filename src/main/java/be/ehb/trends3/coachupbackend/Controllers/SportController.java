package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.SportNotFoundException;
import be.ehb.trends3.coachupbackend.Exceptions.NotLoggedInException;
import be.ehb.trends3.coachupbackend.Models.Sport;
import be.ehb.trends3.coachupbackend.Repositories.SportRepository;
import be.ehb.trends3.coachupbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
//@CrossOrigin(origins = "3000")
@CrossOrigin(origins = "*")
@RequestMapping("/Sports")
public class SportController {

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("")
    public Iterable<Sport> findAll (@RequestHeader String authToken)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return sportRepository.findAllByOrderBySportNameAsc();
    }

    @GetMapping("/{Id}")
    public Sport findById (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return sportRepository.findById(Id).orElseThrow(SportNotFoundException::new);
    }

    @PostMapping("")
    public Sport create (@RequestHeader String authToken, @RequestBody Sport sport)
    {

        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return sportRepository.save(sport);
    }

    @PutMapping("/{Id}")
    public Sport update (@RequestHeader String authToken, @PathVariable String Id, @RequestBody Sport sport)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! sportRepository.existsById(Id))
        {
            throw new SportNotFoundException();
        }

        return sportRepository.save(sport);
    }

    @DeleteMapping("/{Id}")
    public void delete (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! sportRepository.existsById(Id))
        {
            throw new SportNotFoundException();
        }

        sportRepository.deleteById(Id);
    }


}
