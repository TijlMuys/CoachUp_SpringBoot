package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.NotLoggedInException;
import be.ehb.trends3.coachupbackend.Exceptions.LocationNotFoundException;
import be.ehb.trends3.coachupbackend.Models.Location;
import be.ehb.trends3.coachupbackend.Repositories.LocationRepository;
import be.ehb.trends3.coachupbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "3000")
@CrossOrigin(origins = "*")
@RequestMapping("/Locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("")
    public Iterable<Location> findAll (@RequestHeader String authToken)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return locationRepository.findAll();
    }

    @GetMapping("/{Id}")
    public Location findById (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return locationRepository.findById(Id).orElseThrow(LocationNotFoundException::new);
    }

    @PostMapping("")
    public Location create (@RequestHeader String authToken, @RequestBody Location location)
    {

        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        location.setId(null);
        return locationRepository.save(location);
    }

    @PutMapping("/{Id}")
    public Location update (@RequestHeader String authToken, @PathVariable String Id, @RequestBody Location location)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! locationRepository.existsById(Id))
        {
            throw new LocationNotFoundException();
        }

        return locationRepository.save(location);
    }

    @DeleteMapping("/{Id}")
    public void delete (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! locationRepository.existsById(Id))
        {
            throw new LocationNotFoundException();
        }

        locationRepository.deleteById(Id);
    }


}
