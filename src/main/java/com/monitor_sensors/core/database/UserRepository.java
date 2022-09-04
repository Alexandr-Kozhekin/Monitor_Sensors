package com.monitor_sensors.core.database;

import com.monitor_sensors.core.domain.User;

import java.util.List;

public interface UserRepository {

    void registrationUser(User user);

    User authorizationUser(String email, char[] password);

    List<User> fiendAllUsers();

    User findUserByEmail(String email);

}
