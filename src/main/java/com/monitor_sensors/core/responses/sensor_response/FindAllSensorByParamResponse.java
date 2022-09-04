package com.monitor_sensors.core.responses.sensor_response;

import com.monitor_sensors.core.domain.Sensor;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.CoreResponse;

import java.util.ArrayList;
import java.util.List;

public class FindAllSensorByParamResponse extends CoreResponse {

    private ArrayList<Sensor> sensors;

    public FindAllSensorByParamResponse(List<CoreError> errors) {
        super(errors);
    }

    public FindAllSensorByParamResponse(ArrayList<Sensor> sensors) {
        this.sensors = sensors;
    }

    public ArrayList<Sensor> getSensors() {
        return sensors;
    }

}
