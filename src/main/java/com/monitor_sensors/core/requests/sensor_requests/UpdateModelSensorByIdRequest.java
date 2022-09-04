package com.monitor_sensors.core.requests.sensor_requests;

public class UpdateModelSensorByIdRequest {

    private String updateModel;

    private Long id;

    public UpdateModelSensorByIdRequest() {
    }

    public UpdateModelSensorByIdRequest(String updateModel, Long id) {
        this.updateModel = updateModel;
        this.id = id;
    }

    public String getUpdateModel() {
        return updateModel;
    }

    public Long getId() {
        return id;
    }
}
