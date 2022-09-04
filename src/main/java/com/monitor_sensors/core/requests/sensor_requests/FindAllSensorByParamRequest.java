package com.monitor_sensors.core.requests.sensor_requests;

public class FindAllSensorByParamRequest {

    private String title;

    private String model;

    private String from;

    private String to;

    private String type;

    private String unit;

    private String location;

    private String description;

    public FindAllSensorByParamRequest() {
    }

    public FindAllSensorByParamRequest(String title, String model, String from, String to, String type) {
        this.title = title;
        this.model = model;
        this.from = from;
        this.to = to;
        this.type = type;
    }

    public FindAllSensorByParamRequest(String title, String model, String from, String to, String type, String unit, String location, String description) {
        this.title = title;
        this.model = model;
        this.from = from;
        this.to = to;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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
