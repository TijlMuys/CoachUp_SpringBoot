package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.BuddyEntryNotFoundException;
import be.ehb.trends3.coachupbackend.Exceptions.NotLoggedInException;
import be.ehb.trends3.coachupbackend.Models.BuddyEntry;
import be.ehb.trends3.coachupbackend.Repositories.BuddyEntryRepository;
import be.ehb.trends3.coachupbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "3000")
@CrossOrigin(origins = "*")
@RequestMapping("/BuddyEntries")
public class BuddyEntryController {

    @Autowired
    private BuddyEntryRepository buddyEntryRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("")
    public Iterable<BuddyEntry> findAll (@RequestHeader String authToken)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return buddyEntryRepository.findAll();
    }

    @GetMapping("/{Id}")
    public BuddyEntry findById (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return buddyEntryRepository.findById(Id).orElseThrow(BuddyEntryNotFoundException::new);
    }

    @PostMapping("")
    public BuddyEntry create (@RequestHeader String authToken, @RequestBody BuddyEntry buddyEntry)
    {

        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        buddyEntry.setId(null);
        return buddyEntryRepository.save(buddyEntry);
    }

    @PutMapping("/{Id}")
    public BuddyEntry update (@RequestHeader String authToken, @PathVariable String Id, @RequestBody BuddyEntry buddyEntry)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! buddyEntryRepository.existsById(Id))
        {
            throw new BuddyEntryNotFoundException();
        }

        return buddyEntryRepository.save(buddyEntry);
    }

    @DeleteMapping("/{Id}")
    public void delete (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! buddyEntryRepository.existsById(Id))
        {
            throw new BuddyEntryNotFoundException();
        }

        buddyEntryRepository.deleteById(Id);
    }


}
