package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.NotLoggedInException;
import be.ehb.trends3.coachupbackend.Exceptions.TrainEntryNotFoundException;
import be.ehb.trends3.coachupbackend.Models.TrainEntry;
import be.ehb.trends3.coachupbackend.Repositories.TrainEntryRepository;
import be.ehb.trends3.coachupbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "3000")
@CrossOrigin(origins = "*")
@RequestMapping("/TrainEntries")
public class TrainEntryController {

    @Autowired
    private TrainEntryRepository trainEntryRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("")
    public Iterable<TrainEntry> findAll (@RequestHeader String authToken)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return trainEntryRepository.findAll();
    }

    @GetMapping("/{Id}")
    public TrainEntry findById (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return trainEntryRepository.findById(Id).orElseThrow(TrainEntryNotFoundException::new);
    }

    @PostMapping("")
    public TrainEntry create (@RequestHeader String authToken, @RequestBody TrainEntry trainEntry)
    {

        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        trainEntry.setId(null);
        return trainEntryRepository.save(trainEntry);
    }

    @PutMapping("/{Id}")
    public TrainEntry update (@RequestHeader String authToken, @PathVariable String Id, @RequestBody TrainEntry trainEntry)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! trainEntryRepository.existsById(Id))
        {
            throw new TrainEntryNotFoundException();
        }

        return trainEntryRepository.save(trainEntry);
    }

    @DeleteMapping("/{Id}")
    public void delete (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! trainEntryRepository.existsById(Id))
        {
            throw new TrainEntryNotFoundException();
        }

        trainEntryRepository.deleteById(Id);
    }


}
