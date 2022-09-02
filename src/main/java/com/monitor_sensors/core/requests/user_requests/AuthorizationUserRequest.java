package com.monitor_sensors.core.requests.user_requests;

public class AuthorizationUserRequest {

    private String email;
    private char[] password;

    public AuthorizationUserRequest(String email, char[] password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

}
