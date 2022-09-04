package com.monitor_sensors.core.responses.sensor_response;

import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.CoreResponse;

import java.util.List;

public class UpdateLocationSensorByIdResponse extends CoreResponse {

    private boolean update;

    public UpdateLocationSensorByIdResponse(List<CoreError> errors) {
        super(errors);
    }

    public UpdateLocationSensorByIdResponse(boolean update) {
        this.update = update;
    }

    public boolean isUpdate() {
        return update;
    }
}
