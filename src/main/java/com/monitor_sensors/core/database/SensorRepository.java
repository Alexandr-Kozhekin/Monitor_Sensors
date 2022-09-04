package com.monitor_sensors.core.database;

import com.monitor_sensors.core.domain.Sensor;

import java.util.ArrayList;

public interface SensorRepository {

    void saveSensor(Sensor sensor);

    ArrayList<Sensor> findAllSensor();

    ArrayList<Sensor> findAllSensorByParam(String[] param);

    ArrayList<Sensor> findAllSensorByTitle(String title);

    ArrayList<Sensor> findAllSensorByModel(String model);

    boolean updateTitleSensorById(String updateTitle, Long idSensor);

    boolean updateModelSensorById(String updateModel, Long idSensor);

    boolean updateRangeFromSensorById(int updateRangeFrom, Long idSensor);

    boolean updateRangeToSensorById(int updateRangeTo, Long idSensor);

    boolean updateTypeSensorById(String updateType, Long idSensor);

    boolean updateUnitSensorById(String updateUnit, Long idSensor);

    boolean updateLocationSensorById(String updateLocation, Long idSensor);

    boolean updateDescriptionSensorById(String updateDescription, Long idSensor);

    boolean deleteSensorById(Long idSensor);

}
