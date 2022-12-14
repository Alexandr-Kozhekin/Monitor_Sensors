package com.monitor_sensors.core.responses;

import java.util.List;

public abstract class CoreResponse {

    private List<CoreError> errors;

    public CoreResponse() {
    }

    public List<CoreError> getErrors() {
        return errors;
    }

    public CoreResponse(List<CoreError> errors) {
        this.errors = errors;
    }

    public boolean hasErrors(){
        return errors != null && !errors.isEmpty();
    }

}
