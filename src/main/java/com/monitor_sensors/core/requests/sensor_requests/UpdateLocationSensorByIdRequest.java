package com.monitor_sensors.core.requests.sensor_requests;

public class UpdateLocationSensorByIdRequest {

    private String updateLocation;

    private Long id;

    public UpdateLocationSensorByIdRequest() {
    }

    public UpdateLocationSensorByIdRequest(String updateLocation, Long id) {
        this.updateLocation = updateLocation;
        this.id = id;
    }

    public String getUpdateLocation() {
        return updateLocation;
    }

    public Long getId() {
        return id;
    }
}
