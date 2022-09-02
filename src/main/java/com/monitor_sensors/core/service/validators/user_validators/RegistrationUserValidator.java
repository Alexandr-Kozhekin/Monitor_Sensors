package com.monitor_sensors.core.service.validators.user_validators;

import com.monitor_sensors.core.requests.user_requests.RegistrationUserRequest;
import com.monitor_sensors.core.responses.CoreError;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RegistrationUserValidator {

    public List<CoreError> validate (RegistrationUserRequest request){
        List<CoreError> errors = new ArrayList<>();
        validateEmail(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateEmail(RegistrationUserRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {

            return Optional.of(new CoreError("email", "Must not be empty!"));

        } else if (request.getEmail().matches("^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$")) {

            return Optional.of(new CoreError("email", "Wrong format!"));

        } else {

            return Optional.empty();

        }
    }

    private Optional<CoreError> validatePassword(RegistrationUserRequest request) {

        String password = String.copyValueOf(request.getPassword());

        if (request.getPassword() == null || request.getPassword().length == 0){

            return Optional.of(new CoreError("password", "Must not be empty!"));

        } else if (request.getPassword().length < 6){

            return Optional.of(new CoreError("password", "Must not be short!"));

        } else if (password.matches("^[0-9]*$") ||
                password.matches("^[a-zA-Z]*$")) {

            return Optional.of(new CoreError("password", "Must not contain only numbers or letters!"));

        } else if (password.matches("(?=\\S+$)")) {

            return Optional.of(new CoreError("password", "Must not contain space!"));

        } else

            return Optional.empty();

    }

}
