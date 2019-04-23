package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.NotLoggedInException;
import be.ehb.trends3.coachupbackend.Exceptions.SportStatisticNotFoundException;
import be.ehb.trends3.coachupbackend.Models.SportStatistic;
import be.ehb.trends3.coachupbackend.Repositories.SportStatisticRepository;
import be.ehb.trends3.coachupbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "3000")
@CrossOrigin(origins = "*")
@RequestMapping("/SportStatistics")
public class SportStatisticController {

    @Autowired
    private SportStatisticRepository sportStatisticRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("")
    public Iterable<SportStatistic> findAll (@RequestHeader String authToken)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return sportStatisticRepository.findAll();
    }

    @GetMapping("/{Id}")
    public SportStatistic findById (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return sportStatisticRepository.findById(Id).orElseThrow(SportStatisticNotFoundException::new);
    }

    @PostMapping("")
    public SportStatistic create (@RequestHeader String authToken, @RequestBody SportStatistic sportStatistic)
    {

        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        sportStatistic.setId(null);
        return sportStatisticRepository.save(sportStatistic);
    }

    @PutMapping("/{Id}")
    public SportStatistic update (@RequestHeader String authToken, @PathVariable String Id, @RequestBody SportStatistic sportStatistic)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! sportStatisticRepository.existsById(Id))
        {
            throw new SportStatisticNotFoundException();
        }

        return sportStatisticRepository.save(sportStatistic);
    }

    @DeleteMapping("/{Id}")
    public void delete (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! sportStatisticRepository.existsById(Id))
        {
            throw new SportStatisticNotFoundException();
        }

        sportStatisticRepository.deleteById(Id);
    }


}
