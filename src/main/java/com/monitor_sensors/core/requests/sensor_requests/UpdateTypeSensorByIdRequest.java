package com.monitor_sensors.core.requests.sensor_requests;

public class UpdateTypeSensorByIdRequest {

    private String updateType;

    private Long id;

    public UpdateTypeSensorByIdRequest() {
    }

    public UpdateTypeSensorByIdRequest(String updateType, Long id) {
        this.updateType = updateType;
        this.id = id;
    }

    public String getUpdateType() {
        return updateType;
    }

    public Long getId() {
        return id;
    }
}
