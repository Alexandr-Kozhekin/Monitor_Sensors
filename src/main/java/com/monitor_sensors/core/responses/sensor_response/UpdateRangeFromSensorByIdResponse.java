package com.monitor_sensors.core.responses.sensor_response;

public class UpdateRangeFromSensorByIdResponse {

    private boolean update;

    public UpdateRangeFromSensorByIdResponse(boolean update) {
        this.update = update;
    }

    public boolean isUpdate() {
        return update;
    }
}
