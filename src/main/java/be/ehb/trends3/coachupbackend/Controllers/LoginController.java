package be.ehb.trends3.coachupbackend.Controllers;

import be.ehb.trends3.coachupbackend.Exceptions.NotLoggedInException;
import be.ehb.trends3.coachupbackend.Exceptions.WrongCredentialsException;
import be.ehb.trends3.coachupbackend.Models.LoginRequest;
import be.ehb.trends3.coachupbackend.Models.LoginResponse;
import be.ehb.trends3.coachupbackend.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "3000")
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public LoginResponse login (@RequestBody LoginRequest loginForm) {
        String authToken = authenticationService.login(loginForm.getEmail(), loginForm.getPassword());
        if(authToken != null)
        {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setAuthtoken(authToken);
            return loginResponse;
        }
        throw new WrongCredentialsException();
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
