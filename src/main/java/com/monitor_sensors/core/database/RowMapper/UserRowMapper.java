package com.monitor_sensors.core.database.RowMapper;

import com.monitor_sensors.core.domain.User;

import com.monitor_sensors.core.domain.UserRole;
import com.monitor_sensors.core.domain.UserState;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();

        user.setId(rs.getLong("id"));
        user.setUserRole(UserRole.valueOf(rs.getString("role")));
        user.setUserState(UserState.valueOf(rs.getString("state")));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password").toCharArray());

        return user;
    }

}
