package com.monitor_sensors.core.requests.sensor_requests;

public class UpdateTitleSensorByIdRequest {

    private String updateTitle;

    private Long id;

    public UpdateTitleSensorByIdRequest() {
    }

    public UpdateTitleSensorByIdRequest(String updateTitle, Long id) {
        this.updateTitle = updateTitle;
        this.id = id;
    }

    public String getUpdateTitle() {
        return updateTitle;
    }

    public Long getId() {
        return id;
    }
}
