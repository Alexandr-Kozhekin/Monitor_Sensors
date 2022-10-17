package com.monitor_sensors.core.service.validators.sensor_validators;

import com.monitor_sensors.core.requests.sensor_requests.UpdateLocationSensorByIdRequest;
import com.monitor_sensors.core.responses.CoreError;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UpdateLocationValidator {

    public List<CoreError> validate(UpdateLocationSensorByIdRequest request) {

        List<CoreError> errors = new ArrayList<>();

        validateIdSensor(request).ifPresent(errors::add);
        validateLocation(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<CoreError> validateIdSensor(UpdateLocationSensorByIdRequest request) {

        if (request.getId() == null || request.getId() <= 0) {
            return Optional.of(new CoreError("id", "Must not be empty!"));
        } else {
            return Optional.empty();
        }

    }

    private Optional<CoreError> validateLocation(UpdateLocationSensorByIdRequest request) {

        if (request.getUpdateLocation().length() > 40) {
            return Optional.of(new CoreError("location", "Must not be long!"));
        } else {
            return Optional.empty();
        }

    }

}
