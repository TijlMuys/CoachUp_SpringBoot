package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.AccountNotFoundException;
import be.ehb.trends3.coachupbackend.Exceptions.NotLoggedInException;
import be.ehb.trends3.coachupbackend.Exceptions.WrongCredentialsException;
import be.ehb.trends3.coachupbackend.Models.Account;
import be.ehb.trends3.coachupbackend.Models.AccountResponse;
import be.ehb.trends3.coachupbackend.Models.LoginRequest;
import be.ehb.trends3.coachupbackend.Models.LoginResponse;
import be.ehb.trends3.coachupbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {



    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public LoginResponse login (@RequestBody LoginRequest loginForm) {
        String authToken = authenticationService.login(loginForm.getEmail(), loginForm.getPassword());
        if(authToken != null)
        {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setAuthToken(authToken);
            return loginResponse;
        }
        throw new WrongCredentialsException();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/loggedinaccount")
    public Account loggedInAccount (@RequestHeader String authToken)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        Account loggedInAccount = authenticationService.loggedInAccount(authToken);
        if(loggedInAccount == null)
        {
            throw new AccountNotFoundException();
        }
        loggedInAccount.setPassword(null);
        return loggedInAccount;
    }

    @PostMapping("/logout")
    public void logout (@RequestHeader String authToken)
    {
        if(! authenticationService.isLoggedIn(authToken))
        {
            throw new NotLoggedInException();
        }
        authenticationService.logout(authToken);
    }
}
