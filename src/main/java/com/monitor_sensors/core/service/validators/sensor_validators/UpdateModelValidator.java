package com.monitor_sensors.core.service.validators.sensor_validators;

import com.monitor_sensors.core.requests.sensor_requests.UpdateModelSensorByIdRequest;
import com.monitor_sensors.core.responses.CoreError;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UpdateModelValidator {

    public List<CoreError> validate(UpdateModelSensorByIdRequest request) {

        List<CoreError> errors = new ArrayList<>();

        validateIdSensor(request).ifPresent(errors::add);
        validateModel(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<CoreError> validateIdSensor(UpdateModelSensorByIdRequest request) {

        if (request.getId() == null || request.getId() <= 0) {
            return Optional.of(new CoreError("id", "Must not be empty!"));
        } else {
            return Optional.empty();
        }

    }

    private Optional<CoreError> validateModel(UpdateModelSensorByIdRequest request) {

        if (request.getUpdateModel().length() > 15) {
            return Optional.of(new CoreError("model", "Must not be long!"));
        } else {
            return Optional.empty();
        }

    }

}
