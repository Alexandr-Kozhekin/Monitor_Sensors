package com.monitor_sensors.core.requests.sensor_requests;

public class SaveSensorRequest {

    private String title;

    private String model;

    private RangeRequest range;

    private String type;

    private String unit;

    private String location;

    private String description;

    public SaveSensorRequest() {
    }

    public SaveSensorRequest(String title, String model, RangeRequest range, String type, String unit) {
        this.title = title;
        this.model = model;
        this.range = range;
        this.type = type;
        this.unit = unit;
    }

    public SaveSensorRequest(String title, String model, RangeRequest range, String type, String unit, String location, String description) {
        this.title = title;
        this.model = model;
        this.range = range;
        this.type = type;
        this.unit = unit;
        this.location = location;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public RangeRequest getRange() {
        return range;
    }

    public void setRange(RangeRequest range) {
        this.range = range;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

