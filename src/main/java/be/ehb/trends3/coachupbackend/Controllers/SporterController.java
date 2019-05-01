package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.CoachNotFoundException;
import be.ehb.trends3.coachupbackend.Exceptions.SporterNotFoundException;
import be.ehb.trends3.coachupbackend.Exceptions.NotLoggedInException;
import be.ehb.trends3.coachupbackend.Models.Coach;
import be.ehb.trends3.coachupbackend.Models.Sporter;
import be.ehb.trends3.coachupbackend.Models.SporterUpdateRequest;
import be.ehb.trends3.coachupbackend.Repositories.SporterRepository;
import be.ehb.trends3.coachupbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/search/{accountId}")
    public Sporter findByAccountId (@RequestHeader String authToken, @PathVariable String accountId)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        List<Sporter> sporterList = sporterRepository.findSporterByAccountId(accountId);
        if(sporterList.size() != 1) {
            throw new SporterNotFoundException();
        }
        Sporter foundsporter = sporterList.get(0);
        return foundsporter;
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

    @PostMapping("/update")
    public Sporter updateProfile (@RequestHeader String authToken, @RequestBody SporterUpdateRequest sporterUpdateRequest)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        //Find Sporter
        Sporter foundsporter = sporterRepository.findById(sporterUpdateRequest.getId()).orElseThrow(SporterNotFoundException::new);
        //update Sporter
        foundsporter.setProfileText(sporterUpdateRequest.getProfileText());
        foundsporter.setProfileImg(sporterUpdateRequest.getProfileImg());

        return sporterRepository.save(foundsporter);
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
