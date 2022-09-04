package com.monitor_sensors.core.requests.sensor_requests;

public class UpdateDescriptionSensorByIdRequest {

    private String updateDescription;

    private Long id;

    public UpdateDescriptionSensorByIdRequest() {
    }

    public UpdateDescriptionSensorByIdRequest(String updateDescription, Long id) {
        this.updateDescription = updateDescription;
        this.id = id;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public Long getId() {
        return id;
    }
}
