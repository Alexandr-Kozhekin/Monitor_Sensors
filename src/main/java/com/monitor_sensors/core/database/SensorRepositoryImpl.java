package com.monitor_sensors.core.database;

import com.monitor_sensors.core.database.RowMapper.SensorRowMapper;
import com.monitor_sensors.core.domain.Sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SensorRepositoryImpl implements SensorRepository {

    @Autowired private JdbcTemplate jdbcTemplate;

    @Override
    public void saveSensor(Sensor sensor) {

        String sql = "INSERT INTO SENSORS (title, model, range_from, range_to, type, unit, location, description) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, sensor.getTitle(), sensor.getModel(), sensor.getRangeFrom(),
                sensor.getRangeTo(), sensor.getType(), sensor.getUnit(), sensor.getLocation(),
                sensor.getDescription());

    }

    @Override
    public ArrayList<Sensor> findAllSensor() {

        String sql = "SELECT * FROM SENSORS";

        return (ArrayList<Sensor>) jdbcTemplate.query(sql, new SensorRowMapper());
    }

    @Override
    public ArrayList<Sensor> findAllSensorByParam(String[] param) {

        String sql = generatorSelectQueries(param);

        return (ArrayList<Sensor>) jdbcTemplate.query(sql, new SensorRowMapper());
    }

    @Override
    public ArrayList<Sensor> findAllSensorByTitle(String title) {

        String sql = "SELECT * FROM SENSORS WHERE title = ?";

        Object[] args = new Object[] {title};

        return (ArrayList<Sensor>) jdbcTemplate.query(sql, args, new SensorRowMapper());
    }

    @Override
    public ArrayList<Sensor> findAllSensorByModel(String model) {

        String sql = "SELECT * FROM SENSORS WHERE model = ?";

        Object[] args = new Object[] {model};

        return (ArrayList<Sensor>) jdbcTemplate.query(sql, args, new SensorRowMapper());
    }

    @Override
    public boolean updateTitleSensorById(String updateTitle, Long idSensor) {

        String sql = "UPDATE SENSORS SET title = ? WHERE id = ?";

        Object[] args = new Object[] {updateTitle, idSensor};

        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public boolean updateModelSensorById(String updateModel, Long idSensor) {

        String sql = "UPDATE SENSORS SET model = ? WHERE id = ?";

        Object[] args = new Object[] {updateModel, idSensor};

        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public boolean updateRangeFromSensorById(int updateRangeFrom, Long idSensor) {

        String sql = "UPDATE SENSORS SET range_from = ? WHERE id = ?";

        Object[] args = new Object[] {updateRangeFrom, idSensor};

        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public boolean updateRangeToSensorById(int updateRangeTo, Long idSensor) {

        String sql = "UPDATE SENSORS SET range_to = ? WHERE id = ?";

        Object[] args = new Object[] {updateRangeTo, idSensor};

        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public boolean updateTypeSensorById(String updateType, Long idSensor) {

        String sql = "UPDATE SENSORS SET type = ? WHERE id = ?";

        Object[] args = new Object[] {updateType, idSensor};

        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public boolean updateUnitSensorById(String updateUnit, Long idSensor) {

        String sql = "UPDATE SENSORS SET unit = ? WHERE id = ?";

        Object[] args = new Object[] {updateUnit, idSensor};

        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public boolean updateLocationSensorById(String updateLocation, Long idSensor) {

        String sql = "UPDATE SENSORS SET location = ? WHERE id = ?";

        Object[] args = new Object[] {updateLocation, idSensor};

        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public boolean updateDescriptionSensorById(String updateDescription, Long idSensor) {

        String sql = "UPDATE SENSORS SET description = ? WHERE id = ?";

        Object[] args = new Object[] {updateDescription, idSensor};

        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public boolean deleteSensorById(Long idSensor) {

        String sql = "DELETE FROM SENSORS WHERE id = ?";

        Object[] args = new Object[] {idSensor};

        return jdbcTemplate.update(sql, args) == 1;
    }

    private String generatorSelectQueries(String[] param) {

        String[] allParams = new String[]{
                "title", "model", "range_from", "range_to",
                "type", "unit", "location", "description"
        };

        StringBuilder sql = new StringBuilder("SELECT * FROM SENSORS WHERE");

        int counterParam = 0;

        for (int i = 0; i < allParams.length; i++) {

            if (!param[i].equals("")) {
                if(!param[i].matches("\\d+")) {
                    sql.append(" " + allParams[i] + " = " + "'" + param[i] + "'" + " OR ");
                } else {
                    sql.append(" " + allParams[i] + " = " + param[i] + " OR ");
                }
                counterParam += 1;
            }

        }

        if (counterParam == 0) {
            return sql.append(" id = 0").toString();
        } else {
            return sql.substring(0, sql.length() - 4);
        }

    }

}
