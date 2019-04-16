package be.ehb.trends3.coachupbackend.Models;

public class LoginResponse {
    String Authtoken;

    public LoginResponse() {

    }

    public String getAuthtoken() {
        return Authtoken;
    }

    public void setAuthtoken(String authtoken) {
        Authtoken = authtoken;
    }
}
