package com.monitor_sensors.core.domain;

import javax.persistence.*;

import java.io.Serializable;

import java.util.*;

@Entity
@Table(name = "SENSORS")
public class Sensor implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SENSORS")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "model")
    private String model;

    @Column(name = "range_from")
    private int rangeFrom;

    @Column(name = "range_to")
    private int rangeTo;

    @JoinColumn(name = "type")
    private String type;

    @JoinColumn(name = "unit")
    private String unit;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    public Sensor() {
    }

    public Sensor(Long id, String title, String model) {
        this.id = id;
        this.title = title;
        this.model = model;
    }
    public Sensor(String title, String model, int rangeFrom, int rangeTo, String type) {
        this.title = title;
        this.model = model;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.type = type;
    }

    public Sensor(String title, String model, int rangeFrom, int rangeTo, String type, String unit, String location, String description) {
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

@Entity
@Table(name = "TYPE")
class Type {

    @Id
    @Column(name = "type")
    private String type;

    public Type() {
    }

    public Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

@Entity
@Table(name = "UNIT")
class Unit {

    @Id
    @Column(name = "unit")
    private String unit;

    public Unit() {
    }

    public Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}