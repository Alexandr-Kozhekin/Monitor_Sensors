package com.monitor_sensors.core.requests.sensor_requests;

public class UpdateRangeFromSensorByIdRequest {

    private int updateRangeFrom;

    private Long id;

    public UpdateRangeFromSensorByIdRequest() {
    }

    public UpdateRangeFromSensorByIdRequest(int updateRangeFrom, Long id) {
        this.updateRangeFrom = updateRangeFrom;
        this.id = id;
    }

    public int getUpdateRangeFrom() {
        return updateRangeFrom;
    }

    public Long getId() {
        return id;
    }
}
