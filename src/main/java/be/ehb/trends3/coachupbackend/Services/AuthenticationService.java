package be.ehb.trends3.coachupbackend.Services;

import be.ehb.trends3.coachupbackend.Models.Account;
import be.ehb.trends3.coachupbackend.Repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class AuthenticationService {

    private static Map<String, String> loginSessions;

    @Autowired
    private AccountRepository accountRepository;

    public String login (String email, String password) {
        //Check if email exists
        Account foundAccount = accountRepository.findByEmail(email);
        if(foundAccount != null)
        {
            if(email.equals(foundAccount.getEmail()) && password.equals(foundAccount.getPassword()))
            {
                //Generate Authtoken
                String currentAuthtoken = UUID.randomUUID().toString();
                loginSessions.put(currentAuthtoken, foundAccount.getEmail());
                return currentAuthtoken;
            }
        }
        return null;
    }

    public void logout(String Authtoken) {
        loginSessions.remove(Authtoken);
    }

    public boolean isLoggedIn (String Authtoken) {
        if(Authtoken != null)
        {
            String Email = loginSessions.get(Authtoken);
            if (Email != null) {
                Account foundAccount = accountRepository.findByEmail(Email);
                if(foundAccount != null) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

}
