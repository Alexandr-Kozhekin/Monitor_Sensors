package com.monitor_sensors.core.requests.sensor_requests;

public class UpdateUnitSensorByIdRequest {

    private String updateUnit;
    private Long id;

    public UpdateUnitSensorByIdRequest() {
    }

    public UpdateUnitSensorByIdRequest(String updateUnit, Long id) {
        this.updateUnit = updateUnit;
        this.id = id;
    }

    public String getUpdateUnit() {
        return updateUnit;
    }

    public Long getId() {
        return id;
    }
}
