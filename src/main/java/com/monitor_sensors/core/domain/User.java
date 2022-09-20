package com.monitor_sensors.core.domain;

import java.io.Serializable;

import java.util.*;

public class User implements Serializable {

    private Long id;

    private UserRole userRole;

    private UserState userState;

    private String email;

    private char[] password;

    public User() {
    }

    public User(String email, char[] password) {
        this.email = email;
        this.password = password;
        this.userRole = UserRole.USER;
        this.userState = UserState.ACTIVE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && userRole == user.userRole && userState == user.userState && Objects.equals(email, user.email) && Arrays.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, userRole, userState, email);
        result = 31 * result + Arrays.hashCode(password);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userRole=" + userRole +
                ", userState=" + userState +
                ", email='" + email + '\'' +
                ", password=" + Arrays.toString(password) +
                '}';
    }
}
