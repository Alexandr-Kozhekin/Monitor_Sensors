package com.monitor_sensors.core.responses.sensor_response;

public class UpdateRangeToSensorByIdResponse {

    private boolean update;

    public UpdateRangeToSensorByIdResponse(boolean update) {
        this.update = update;
    }

    public boolean isUpdate() {
        return update;
    }
}
