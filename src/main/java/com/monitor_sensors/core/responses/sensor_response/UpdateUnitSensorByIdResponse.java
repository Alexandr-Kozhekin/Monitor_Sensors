package com.monitor_sensors.core.responses.sensor_response;

public class UpdateUnitSensorByIdResponse {

    private boolean update;

    public UpdateUnitSensorByIdResponse(boolean update) {
        this.update = update;
    }

    public boolean isUpdate() {
        return update;
    }
}
