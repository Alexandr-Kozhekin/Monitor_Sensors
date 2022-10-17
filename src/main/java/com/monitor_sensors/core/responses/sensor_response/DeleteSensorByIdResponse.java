package com.monitor_sensors.core.responses.sensor_response;

import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.CoreResponse;

import java.util.List;

public class DeleteSensorByIdResponse extends CoreResponse {

    private boolean delete;

    public DeleteSensorByIdResponse(List<CoreError> errors) {
        super(errors);
    }

    public DeleteSensorByIdResponse(boolean delete) {
        this.delete = delete;
    }

    public boolean isDelete() {
        return delete;
    }
}
