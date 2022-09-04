package com.monitor_sensors.core.requests.sensor_requests;

public class RangeRequest {

    private int from;

    private int to;

    public RangeRequest() {
    }

    public RangeRequest(int rangeFrom, int rangeTo) {
        this.from = rangeFrom;
        this.to = rangeTo;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
