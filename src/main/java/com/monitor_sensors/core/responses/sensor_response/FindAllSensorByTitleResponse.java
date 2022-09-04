package com.monitor_sensors.core.responses.sensor_response;

import com.monitor_sensors.core.domain.Sensor;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.CoreResponse;

import java.util.ArrayList;
import java.util.List;

public class FindAllSensorByTitleResponse extends CoreResponse {

    private ArrayList<Sensor> sensors;

    public FindAllSensorByTitleResponse(List<CoreError> errors) {
        super(errors);
    }

    public FindAllSensorByTitleResponse(ArrayList<Sensor> sensors) {
        this.sensors = sensors;
    }

    public ArrayList<Sensor> getSensors() {
        return sensors;
    }
}
