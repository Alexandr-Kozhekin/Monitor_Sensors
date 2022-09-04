package com.monitor_sensors.core.service.validators.sensor_validators;

import com.monitor_sensors.core.requests.sensor_requests.UpdateDescriptionSensorByIdRequest;
import com.monitor_sensors.core.responses.CoreError;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UpdateDescriptionValidator {

    public List<CoreError> validate(UpdateDescriptionSensorByIdRequest request) {

        List<CoreError> errors = new ArrayList<>();

        validateDescription(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<CoreError> validateDescription(UpdateDescriptionSensorByIdRequest request) {

        if (request.getUpdateDescription().length() > 200) {
            return Optional.of(new CoreError("description", "Must not be long!"));
        } else {
            return Optional.empty();
        }

    }
}
