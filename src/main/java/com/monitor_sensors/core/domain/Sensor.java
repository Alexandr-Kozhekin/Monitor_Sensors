package com.monitor_sensors.core.domain;

import java.io.Serializable;

import java.util.*;

public class Sensor implements Serializable {

    private Long id;

    private String title;

    private String model;

    private int rangeFrom;

    private int rangeTo;

    private String type;

    private String unit;

    private String location;

    private String description;

    public Sensor() {
    }

    public Sensor(String title, String model, int rangeFrom, int rangeTo, String type) {
        this.title = title;
        this.model = model;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.type = type;
    }

    public Sensor(String title, String model, int rangeFrom, int rangeTo, String type,
                  String unit, String location, String description) {
        this.title = title;
        this.model = model;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.type = type;
        this.unit = unit;
        this.location = location;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeFrom(int rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    public int getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(int rangeTo) {
        this.rangeTo = rangeTo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return rangeFrom == sensor.rangeFrom && rangeTo == sensor.rangeTo && Objects.equals(id, sensor.id) && Objects.equals(title, sensor.title) && Objects.equals(model, sensor.model) && Objects.equals(type, sensor.type) && Objects.equals(unit, sensor.unit) && Objects.equals(location, sensor.location) && Objects.equals(description, sensor.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, model, rangeFrom, rangeTo, type, unit, location, description);
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", model='" + model + '\'' +
                ", rangeFrom=" + rangeFrom +
                ", rangeTo=" + rangeTo +
                ", type=" + type +
                ", unit=" + unit +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}