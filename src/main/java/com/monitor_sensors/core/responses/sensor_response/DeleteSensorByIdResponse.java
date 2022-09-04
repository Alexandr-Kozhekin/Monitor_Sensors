package com.monitor_sensors.core.responses.sensor_response;

public class DeleteSensorByIdResponse {

    private boolean delete;

    public DeleteSensorByIdResponse(boolean delete) {
        this.delete = delete;
    }

    public boolean isDelete() {
        return delete;
    }
}
