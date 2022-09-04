package com.monitor_sensors.core.requests.sensor_requests;

public class DeleteSensorByIdRequest {

    private Long id;

    public DeleteSensorByIdRequest() {
    }

    public DeleteSensorByIdRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
