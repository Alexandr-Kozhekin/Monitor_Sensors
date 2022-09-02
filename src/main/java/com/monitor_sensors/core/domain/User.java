package com.monitor_sensors.core.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "USERS")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole userRole;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private char[] password;

    public User() {
    }

    public User(String email, char[] password) {
        this.email = email;
        this.password = password;
        this.userRole = UserRole.USER;
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
        return Objects.equals(id, user.id) && userRole == user.userRole && Objects.equals(email, user.email) && Arrays.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, userRole, email);
        result = 31 * result + Arrays.hashCode(password);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userRole=" + userRole +
                ", email='" + email + '\'' +
                ", password=" + Arrays.toString(password) +
                '}';
    }
}
