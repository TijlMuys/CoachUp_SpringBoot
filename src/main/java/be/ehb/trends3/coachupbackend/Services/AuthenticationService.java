package be.ehb.trends3.coachupbackend.Services;

import be.ehb.trends3.coachupbackend.Exceptions.AccountNotFoundException;
import be.ehb.trends3.coachupbackend.Models.Account;
import be.ehb.trends3.coachupbackend.Repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;

@Service
@CrossOrigin(origins = "*")
public class AuthenticationService {

    private static HashMap<String, String> loginSessions = new HashMap<String, String>();

    @Autowired
    private AccountRepository accountRepository;

    public String login (String email, String password) {
        //Check if email exists
        List<Account> foundAccounts = (accountRepository.findAccountByEmail(email));
        if(foundAccounts.size() != 1){throw new AccountNotFoundException();}
        Account foundAccount = foundAccounts.get(0);
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

    public void logout(String authToken) {
        loginSessions.remove(authToken);
    }

    public boolean isLoggedIn (String Authtoken) {
        if(Authtoken != null)
        {
            String email = loginSessions.get(Authtoken);
            if (email != null) {
                List<Account> foundAccounts = (accountRepository.findAccountByEmail(email));
                if(foundAccounts.size() != 1){throw new AccountNotFoundException();}
                Account foundAccount = foundAccounts.get(0);
                if(foundAccount != null) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public Account loggedInAccount (String Authtoken) {
        if(Authtoken != null)
        {
            String email = loginSessions.get(Authtoken);
            if (email != null) {
                List<Account> foundAccounts = (accountRepository.findAccountByEmail(email));
                if(foundAccounts.size() != 1){throw new AccountNotFoundException();}
                Account foundAccount = foundAccounts.get(0);
                if(foundAccount != null) {
                    return foundAccount;
                }
                return null;
            }
            return null;
        }
        return null;
    }

}
