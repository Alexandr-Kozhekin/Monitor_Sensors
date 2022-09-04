package com.monitor_sensors.core.responses.sensor_response;

import com.monitor_sensors.core.domain.Sensor;

import java.util.ArrayList;

public class FindAllSensorByModelResponse {

    private ArrayList<Sensor> sensors;

    public FindAllSensorByModelResponse(ArrayList<Sensor> sensors) {
        this.sensors = sensors;
    }

    public ArrayList<Sensor> getSensors() {
        return sensors;
    }
}
