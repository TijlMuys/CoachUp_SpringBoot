package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.RatingNotFoundException;
import be.ehb.trends3.coachupbackend.Exceptions.NotLoggedInException;
import be.ehb.trends3.coachupbackend.Models.Rating;
import be.ehb.trends3.coachupbackend.Repositories.RatingRepository;
import be.ehb.trends3.coachupbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "3000")
@CrossOrigin(origins = "*")
@RequestMapping("/Ratings")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("")
    public Iterable<Rating> findAll (@RequestHeader String authToken)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return ratingRepository.findAll();
    }

    @GetMapping("/{Id}")
    public Rating findById (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return ratingRepository.findById(Id).orElseThrow(RatingNotFoundException::new);
    }

    @PostMapping("")
    public Rating create (@RequestHeader String authToken, @RequestBody Rating rating)
    {

        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        rating.setId(null);
        return ratingRepository.save(rating);
    }

    @PutMapping("/{Id}")
    public Rating update (@RequestHeader String authToken, @PathVariable String Id, @RequestBody Rating rating)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! ratingRepository.existsById(Id))
        {
            throw new RatingNotFoundException();
        }

        return ratingRepository.save(rating);
    }

    @DeleteMapping("/{Id}")
    public void delete (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! ratingRepository.existsById(Id))
        {
            throw new RatingNotFoundException();
        }

        ratingRepository.deleteById(Id);
    }


}
