package com.monitor_sensors.core.responses.sensor_response;

public class UpdateTypeSensorByIdResponse {

    private boolean update;

    public UpdateTypeSensorByIdResponse(boolean update) {
        this.update = update;
    }

    public boolean isUpdate() {
        return update;
    }
}
