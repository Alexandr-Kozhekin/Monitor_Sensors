package com.monitor_sensors.core.requests.sensor_requests;

public class UpdateRangeToSensorByIdRequest {

    private int updateRangeTo;

    private Long id;

    public UpdateRangeToSensorByIdRequest() {
    }

    public UpdateRangeToSensorByIdRequest(int updateRangeTo, Long id) {
        this.updateRangeTo = updateRangeTo;
        this.id = id;
    }

    public int getUpdateRangeTo() {
        return updateRangeTo;
    }

    public Long getId() {
        return id;
    }
}
