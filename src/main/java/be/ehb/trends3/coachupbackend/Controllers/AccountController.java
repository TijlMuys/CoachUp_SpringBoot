package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.AccountNotFoundException;
import be.ehb.trends3.coachupbackend.Exceptions.NotLoggedInException;
import be.ehb.trends3.coachupbackend.Models.*;
import be.ehb.trends3.coachupbackend.Repositories.AccountRepository;
import be.ehb.trends3.coachupbackend.Repositories.CoachRepository;
import be.ehb.trends3.coachupbackend.Repositories.SporterRepository;
import be.ehb.trends3.coachupbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "3000")
@CrossOrigin(origins = "*")
@RequestMapping("/Accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private SporterRepository sporterRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("")
    public Iterable<Account> findAll (@RequestHeader String authToken)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return accountRepository.findAll();
    }

    @GetMapping("/{Id}")
    public Account findById (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        return accountRepository.findById(Id).orElseThrow(AccountNotFoundException::new);
    }

    @PostMapping("")
    public Account create (/*@RequestHeader String authToken,*/ @RequestBody Account account)
    {
        /*
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        */
        account.setId(null);
        //Create new empty Coach/Sport profile for account if not provided
        if(account.getAccountType().equals("regular") && account.getSporter() == null)
        {
            //Create empty sporter profile
            Sporter newSporterProfile = new Sporter();
            //save profile
            sporterRepository.save(newSporterProfile);
            //set profile to account
            account.setSporter(newSporterProfile);
        }
        if(account.getAccountType().equals("coach") && account.getCoach() == null)
        {
            //Create empty coach profile
            Coach newCoachProfile = new Coach();
            //save profile
            coachRepository.save(newCoachProfile);
            //set profile to account
            account.setCoach(newCoachProfile);
        }
        //save and return account
        return accountRepository.save(account);
    }

    @PostMapping("/create")
    public Account createNew (/*@RequestHeader String authToken,*/ @RequestBody NewAccountRequest newAccountRequest)
    {
        /*
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        */
        //Create new Account
        Account newAccount = new Account();
        //Set props of account
        newAccount.setEmail(newAccountRequest.getEmail());
        newAccount.setUserName(newAccountRequest.getUserName());
        newAccount.setPassword(newAccountRequest.getPassword());
        newAccount.setAccountType(newAccountRequest.getAccountType());
        newAccount.setStreet(newAccountRequest.getStreet());
        newAccount.setNumber(newAccountRequest.getNumber());
        newAccount.setZipCode(newAccountRequest.getZipCode());
        newAccount.setCity(newAccountRequest.getCity());
        newAccount.setAgreedConditions(newAccountRequest.getAgreedConditions());
        //Culculate coordinates -> not implemented
        newAccount.setCoordinates(null);
        //Create new empty Coach/Sport profile for account if not provided
        if(newAccountRequest.getAccountType().equals("regular"))
        {
            //Create empty sporter profile
            Sporter newSporterProfile = new Sporter();
            //save profile
            Sporter savedSporter = sporterRepository.save(newSporterProfile);
            //set profile to account
            newAccount.setSporter(savedSporter);
        }
        if(newAccountRequest.getAccountType().equals("coach"))
        {
            //Create empty coach profile
            Coach newCoachProfile = new Coach();
            //save profile
            Coach savedCoach = coachRepository.save(newCoachProfile);
            //set profile to account
            newAccount.setCoach(savedCoach);
        }
        //save and return account
        return accountRepository.save(newAccount);
    }

    @PutMapping("/{Id}")
    public Account update (@RequestHeader String authToken, @PathVariable String Id, @RequestBody Account account)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! accountRepository.existsById(Id))
        {
            throw new AccountNotFoundException();
        }
        return accountRepository.save(account);
    }

    @PostMapping("/update")
    public Account update (@RequestHeader String authToken, @RequestBody AccountUpdateRequest accountUpdateRequest)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        //Find Account
        Account foundAccount = accountRepository.findById(accountUpdateRequest.getId()).orElseThrow(AccountNotFoundException::new);
        //Update Account
        foundAccount.setPassword(accountUpdateRequest.getPassword());
        foundAccount.setUserName(accountUpdateRequest.getUserName());
        foundAccount.setEmail(accountUpdateRequest.getEmail());
        foundAccount.setPhone(accountUpdateRequest.getPhone());
        foundAccount.setStreet(accountUpdateRequest.getStreet());
        foundAccount.setNumber(accountUpdateRequest.getNumber());
        foundAccount.setZipCode(accountUpdateRequest.getZipCode());
        foundAccount.setCity(accountUpdateRequest.getCity());

        return accountRepository.save(foundAccount);
    }


    @DeleteMapping("/{Id}")
    public void delete (@RequestHeader String authToken, @PathVariable String Id)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }

        if(! accountRepository.existsById(Id))
        {
            throw new AccountNotFoundException();
        }

        accountRepository.deleteById(Id);
    }


}
