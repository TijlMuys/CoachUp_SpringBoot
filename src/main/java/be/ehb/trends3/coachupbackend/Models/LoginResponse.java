package be.ehb.trends3.coachupbackend.Models;

public class LoginResponse {
    String authToken;

    public LoginResponse() {

    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
