package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.*;
import be.ehb.trends3.coachupbackend.Models.*;
import be.ehb.trends3.coachupbackend.Repositories.BuddyEntryRepository;
import be.ehb.trends3.coachupbackend.Repositories.LocationRepository;
import be.ehb.trends3.coachupbackend.Repositories.SportRepository;
import be.ehb.trends3.coachupbackend.Repositories.SporterRepository;
import be.ehb.trends3.coachupbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@RestController
//@CrossOrigin(origins = "3000")
@CrossOrigin(origins = "*")
@RequestMapping("/BuddyEntries")
public class BuddyEntryController {

    @Autowired
    private BuddyEntryRepository buddyEntryRepository;

    @Autowired
    private SporterRepository sporterRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private SportRepository sportRepository;

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

    @GetMapping("search/{sport}")
    public Iterable<BuddyEntry> findBySport (@RequestHeader String authToken, @PathVariable String sport)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return buddyEntryRepository.findBuddyEntriesBySport_SportNameIsLike(sport);
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

    @PostMapping("/create")
    public BuddyEntry createNew (@RequestHeader String authToken, @RequestBody BuddyEntryNewRequest buddyEntryNewRequest)
    {

        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        try {
        //Find Sporter
        Sporter foundSporter = sporterRepository.findById(buddyEntryNewRequest.getSporterId()).orElseThrow(SporterNotFoundException::new);
        //create New Location
        Location newLocation = new Location();
        //modify location
        newLocation.setStreet(buddyEntryNewRequest.getStreet());
        newLocation.setNumber(buddyEntryNewRequest.getNumber());
        newLocation.setZipCode(buddyEntryNewRequest.getZipCode());
        newLocation.setCity(buddyEntryNewRequest.getCity());
        newLocation.setCoordinates(buddyEntryNewRequest.getCoordinates());
        //save Location
        locationRepository.save(newLocation);
        //Get Sport
        Sport foundSport = sportRepository.findById(buddyEntryNewRequest.getSport()).orElseThrow(SportNotFoundException::new);
        //Create Buddy Entry
        BuddyEntry newBuddyEntry = new BuddyEntry();
        //modify lesson
        newBuddyEntry.setBuddyEntryTitle(buddyEntryNewRequest.getBuddyEntryTitle());
        newBuddyEntry.setBuddyEntryDescription(buddyEntryNewRequest.getBuddyEntryDescription());
        newBuddyEntry.setDifficulty(buddyEntryNewRequest.getDifficulty());
        newBuddyEntry.setSport(foundSport);
        newBuddyEntry.setRequestingsporter(foundSporter);
        newBuddyEntry.setBuddyLocation(newLocation);
        //Set date format
        //TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        //format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date myDate = format.parse(buddyEntryNewRequest.getMeetingDateTime());
        newBuddyEntry.setMeetingDateTime(myDate);
        return buddyEntryRepository.save(newBuddyEntry);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new InvalidDateException();
        }

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

    @PostMapping("/update")
    public BuddyEntry update (@RequestHeader String authToken, @RequestBody BuddyEntryUpdateRequest buddyEntryUpdateRequest)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        try {
        //Get sporter
        //Sporter foundSporter = sporterRepository.findById(buddyEntryUpdateRequest.getSporterId()).orElseThrow(SporterNotFoundException::new);
        //Get location
        Location foundLocation = locationRepository.findById(buddyEntryUpdateRequest.getLocationId()).orElseThrow(LocationNotFoundException::new);
        //modify location
        foundLocation.setStreet(buddyEntryUpdateRequest.getStreet());
        foundLocation.setNumber(buddyEntryUpdateRequest.getNumber());
        foundLocation.setZipCode(buddyEntryUpdateRequest.getZipCode());
        foundLocation.setCity(buddyEntryUpdateRequest.getCity());
        //use get Coordinates service -> not implemented
        foundLocation.setCoordinates(buddyEntryUpdateRequest.getCoordinates());
        //save Location
        locationRepository.save(foundLocation);
        //Get Sport
        Sport foundSport = sportRepository.findById(buddyEntryUpdateRequest.getSport()).orElseThrow(SportNotFoundException::new);
        //Get Buddy Entry
        BuddyEntry foundBuddyEntry = buddyEntryRepository.findById(buddyEntryUpdateRequest.getId()).orElseThrow(BuddyEntryNotFoundException::new);
        //modify Buddy Entry
        foundBuddyEntry.setBuddyEntryTitle(buddyEntryUpdateRequest.getBuddyEntryTitle());
        foundBuddyEntry.setBuddyEntryDescription(buddyEntryUpdateRequest.getBuddyEntryDescription());
        foundBuddyEntry.setDifficulty(buddyEntryUpdateRequest.getDifficulty());
        foundBuddyEntry.setSport(foundSport);
        foundBuddyEntry.setBuddyLocation(foundLocation);
        //foundBuddyEntry.setReq_sporter_key(buddyEntryUpdateRequest.getSporterId());
        //foundBuddyEntry.setRequestingsporter(foundSporter);
        //Set date format
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date myDate = format.parse(buddyEntryUpdateRequest.getMeetingDateTime());
        foundBuddyEntry.setMeetingDateTime(myDate);
        return buddyEntryRepository.save(foundBuddyEntry);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new InvalidDateException();
        }
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
