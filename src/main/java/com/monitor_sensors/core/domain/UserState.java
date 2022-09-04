package com.monitor_sensors.core.domain;

import java.io.Serializable;

public enum UserState implements Serializable {

    ACTIVE("Active"), BANNED("Baned"), DELETED("Deleted");

    private String state;

    UserState(String state) {
        this.state = state;
    }

}
