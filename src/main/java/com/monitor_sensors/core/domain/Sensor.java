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
    private Long rangeFrom;

    @Column(name = "range_to")
    private Long rangeTo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type")
    private Type type;

    @JoinColumn(name = "unit")
    @OneToOne(fetch = FetchType.EAGER)
    private Unit unit;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    public Sensor() {
    }

    public Sensor(String title, String model, Long rangeFrom, Long rangeTo, Type type) {
        this.title = title;
        this.model = model;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.type = type;
    }

    public Sensor(String title, String model, Long rangeFrom, Long rangeTo, Type type, Unit unit, String location, String description) {
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

    public Long getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeFrom(Long rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    public Long getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(Long rangeTo) {
        this.rangeTo = rangeTo;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
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
final class Type {

    @Id
    @Column(name = "type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

@Entity
@Table(name = "UNIT")
final class Unit {

    @Id
    @Column(name = "unit")
    private String unit;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}

//final class Range {
//
//    @Column(name = "range_from")
//    private int from;
//
//    @Column(name = "range_to")
//    private int to;
//
//    public Range(int from, int to) {
//        this.from = from;
//        this.to = to;
//    }
//
//    public int getFrom() {
//        return from;
//    }
//
//    public void setFrom(int from) {
//        this.from = from;
//    }
//
//    public int getTo() {
//        return to;
//    }
//
//    public void setTo(int to) {
//        this.to = to;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Range range = (Range) o;
//        return from == range.from && to == range.to;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(from, to);
//    }
//
//    @Override
//    public String toString() {
//        return "Range{" +
//                "from=" + from +
//                ", to=" + to +
//                '}';
//    }
//}