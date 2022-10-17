package com.monitor_sensors.core.service.validators.sensor_validators;

import com.monitor_sensors.core.requests.sensor_requests.UpdateTitleSensorByIdRequest;
import com.monitor_sensors.core.responses.CoreError;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UpdateTitleValidator {

    public List<CoreError> validate(UpdateTitleSensorByIdRequest request) {

        List<CoreError> errors = new ArrayList<>();

        validateIdSensor(request).ifPresent(errors::add);
        validateTitle(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<CoreError> validateIdSensor(UpdateTitleSensorByIdRequest request) {

        if (request.getId() == null || request.getId() <= 0) {
            return Optional.of(new CoreError("id", "Must not be empty!"));
        } else {
            return Optional.empty();
        }

    }

    private Optional<CoreError> validateTitle(UpdateTitleSensorByIdRequest request) {

        if (request.getUpdateTitle().length() > 30) {
            return Optional.of(new CoreError("title", "Must not be long!"));
        } else {
            return Optional.empty();
        }

    }

}
