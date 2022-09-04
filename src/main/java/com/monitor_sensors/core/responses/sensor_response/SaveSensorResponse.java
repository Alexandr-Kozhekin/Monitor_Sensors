package com.monitor_sensors.core.responses.sensor_response;

import com.monitor_sensors.core.domain.Sensor;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.CoreResponse;

import java.util.List;

public class SaveSensorResponse extends CoreResponse {

    private Sensor sensor;

    public SaveSensorResponse(List<CoreError> errors) {
        super(errors);
    }

    public SaveSensorResponse(Sensor sensor) {
        this.sensor = sensor;
    }

    public Sensor getSensor() {
        return sensor;
    }

}
