package com.monitor_sensors.core.service.validators.sensor_validators;

import com.monitor_sensors.core.requests.sensor_requests.DeleteSensorByIdRequest;
import com.monitor_sensors.core.responses.CoreError;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DeleteSensorByIdValidator {

    public List<CoreError> validate(DeleteSensorByIdRequest request) {

        List<CoreError> errors = new ArrayList<>();

        validateIdSensor(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<CoreError> validateIdSensor(DeleteSensorByIdRequest request) {

        if (request.getId() == null || request.getId() <= 0) {
            return Optional.of(new CoreError("id", "Must not be empty!"));
        } else {
            return Optional.empty();
        }

    }
}
