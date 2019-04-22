package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.AccountNotFoundException;
import be.ehb.trends3.coachupbackend.Exceptions.NotLoggedInException;
import be.ehb.trends3.coachupbackend.Models.Account;
import be.ehb.trends3.coachupbackend.Repositories.AccountRepository;
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
        return accountRepository.save(account);
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
