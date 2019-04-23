package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.SporterNotFoundException;
import be.ehb.trends3.coachupbackend.Exceptions.NotLoggedInException;
import be.ehb.trends3.coachupbackend.Models.Sporter;
import be.ehb.trends3.coachupbackend.Repositories.SporterRepository;
import be.ehb.trends3.coachupbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "3000")
@CrossOrigin(origins = "*")
@RequestMapping("/Sporters")
public class SporterController {

    @Autowired
    private SporterRepository sporterRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("")
    public Iterable<Sporter> findAll (@RequestHeader String authToken)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return sporterRepository.findAll();
    }

    @GetMapping("/{Id}")
    public Sporter findById (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return sporterRepository.findById(Id).orElseThrow(SporterNotFoundException::new);
    }

    @PostMapping("")
    public Sporter create (@RequestHeader String authToken, @RequestBody Sporter sporter)
    {

        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        sporter.setId(null);
        return sporterRepository.save(sporter);
    }

    @PutMapping("/{Id}")
    public Sporter update (@RequestHeader String authToken, @PathVariable String Id, @RequestBody Sporter sporter)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! sporterRepository.existsById(Id))
        {
            throw new SporterNotFoundException();
        }

        return sporterRepository.save(sporter);
    }

    @DeleteMapping("/{Id}")
    public void delete (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! sporterRepository.existsById(Id))
        {
            throw new SporterNotFoundException();
        }

        sporterRepository.deleteById(Id);
    }


}
