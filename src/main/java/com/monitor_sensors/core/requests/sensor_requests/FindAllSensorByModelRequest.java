package com.monitor_sensors.core.requests.sensor_requests;

public class FindAllSensorByModelRequest {

    private String model;

    public FindAllSensorByModelRequest() {
    }

    public FindAllSensorByModelRequest(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
