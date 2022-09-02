package com.monitor_sensors.core.domain;

import java.io.Serializable;

public enum UserRole implements Serializable {

    ADMIN("Administrator"),
    USER("Viewer");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

}
