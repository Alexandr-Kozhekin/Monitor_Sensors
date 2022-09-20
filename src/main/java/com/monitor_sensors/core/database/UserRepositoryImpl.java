package com.monitor_sensors.core.database;

import com.monitor_sensors.core.database.RowMapper.UserRowMapper;
import com.monitor_sensors.core.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository{

    @Autowired private JdbcTemplate jdbcTemplate;

    public void registrationUser(User user) {

        String sql = "INSERT INTO USERS (role, state, email, password) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, user.getUserRole().toString(), user.getUserState().toString(),
                user.getEmail(), String.valueOf(user.getPassword()));

    }

    public User authorizationUser(String email, char[] password) {

        String sql = "SELECT * FROM USERS WHERE email = ? AND password = ?";

        Object[] args = new Object[] {email, String.valueOf(password)};

        return jdbcTemplate.query(sql, args, new UserRowMapper()).get(0);
    }

    public List<User> fiendAllUsers() {

        String sql = "SELECT * FROM USERS";

        return jdbcTemplate.query(sql, new UserRowMapper());

    }

    public User findUserByEmail(String email){

        String sql = "SELECT * FROM USERS WHERE email = ?";

        Object[] args = new Object[] {email};

        return jdbcTemplate.query(sql, args, new UserRowMapper()).get(0);
    }

}
