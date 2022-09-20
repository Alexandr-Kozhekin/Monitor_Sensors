package com.monitor_sensors.core.database.RowMapper;

import com.monitor_sensors.core.domain.Sensor;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SensorRowMapper implements RowMapper<Sensor> {

    @Override
    public Sensor mapRow(ResultSet rs, int rowNum) throws SQLException {

        Sensor sensor = new Sensor();

        sensor.setId(rs.getLong("id"));
        sensor.setTitle(rs.getString("title"));
        sensor.setModel(rs.getString("model"));
        sensor.setRangeFrom(rs.getInt("range_from"));
        sensor.setRangeTo(rs.getInt("range_to"));
        sensor.setType(rs.getString("type"));
        sensor.setUnit(rs.getString("unit"));
        sensor.setLocation(rs.getString("location"));
        sensor.setDescription(rs.getString("description"));

        return sensor;
    }

}
