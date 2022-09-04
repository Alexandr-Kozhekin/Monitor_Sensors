package com.monitor_sensors.core.requests.sensor_requests;

public class FindAllSensorByTitleRequest {

    private String title;

    public FindAllSensorByTitleRequest() {
    }

    public FindAllSensorByTitleRequest(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
