package com.monitor_sensors.core.service.validators.sensor_validators;

import com.monitor_sensors.core.requests.sensor_requests.SaveSensorRequest;
import com.monitor_sensors.core.responses.CoreError;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SaveSensorValidator {

    public List<CoreError> validate(SaveSensorRequest request) {

        List<CoreError> errors = new ArrayList<>();

        validateTitle(request).ifPresent(errors::add);
        validateModel(request).ifPresent(errors::add);
        validateRange(request).ifPresent(errors::add);
        validateLocation(request).ifPresent(errors::add);
        validateDescription(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<CoreError> validateTitle(SaveSensorRequest request) {

        if (request.getTitle() == null || request.getTitle().isEmpty()) {
            return Optional.of(new CoreError("title", "Must not be empty!"));
        } else if (request.getTitle().length() > 30) {
            return Optional.of(new CoreError("title", "Must not be long!"));
        } else {
            return Optional.empty();
        }

    }

    private Optional<CoreError> validateModel(SaveSensorRequest request) {

        if (request.getModel() == null || request.getModel().isEmpty()) {
            return Optional.of(new CoreError("model", "Must not be empty!"));
        } else if (request.getModel().length() > 15) {
            return Optional.of(new CoreError("model", "Must not be long!"));
        } else {
            return Optional.empty();
        }

    }

    private Optional<CoreError> validateRange(SaveSensorRequest request) {

        if(request.getRange() == null) {
            return Optional.of(new CoreError("range", "Must not be empty!"));
        } else if (request.getRange().getFrom() > request.getRange().getTo()) {
            return Optional.of(new CoreError("range", "From must be less than to!"));
        } else {
            return Optional.empty();
        }

    }

    private Optional<CoreError> validateLocation(SaveSensorRequest request) {

        if (request.getLocation() != null && request.getLocation().length() > 40) {
            return Optional.of(new CoreError("location", "Must not be long!"));
        } else {
            return Optional.empty();
        }

    }

    private Optional<CoreError> validateDescription(SaveSensorRequest request) {

         if (request.getDescription() != null && request.getDescription().length() > 200) {
            return Optional.of(new CoreError("description", "Must not be long!"));
        } else {
            return Optional.empty();
        }

    }

}
