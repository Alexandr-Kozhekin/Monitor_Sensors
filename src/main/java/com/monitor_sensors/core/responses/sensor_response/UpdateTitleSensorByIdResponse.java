package com.monitor_sensors.core.responses.sensor_response;

import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.CoreResponse;

import java.util.List;

public class UpdateTitleSensorByIdResponse extends CoreResponse {

    private boolean update;

    public UpdateTitleSensorByIdResponse(List<CoreError> errors) {
        super(errors);
    }

    public UpdateTitleSensorByIdResponse(boolean update) {
        this.update = update;
    }

    public boolean isUpdate() {
        return update;
    }
}
