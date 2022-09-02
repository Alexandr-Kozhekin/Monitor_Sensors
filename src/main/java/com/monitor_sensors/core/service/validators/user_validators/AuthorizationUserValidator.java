package com.monitor_sensors.core.service.validators.user_validators;

import com.monitor_sensors.core.database.UserRepository;
import com.monitor_sensors.core.requests.user_requests.AuthorizationUserRequest;
import com.monitor_sensors.core.responses.CoreError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AuthorizationUserValidator {

    @Autowired UserRepository userRepository;

    public List<CoreError> validate (AuthorizationUserRequest request) {
        List<CoreError> errors = new ArrayList<>();

        validateEmail(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);
        validateInputEmailOrPassword(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<CoreError> validateEmail(AuthorizationUserRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            return Optional.of(new CoreError("email", "Must not be empty!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validatePassword(AuthorizationUserRequest request) {
        if (request.getPassword() == null || request.getPassword().length == 0){
            return Optional.of(new CoreError("password", "Must not be empty!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validateInputEmailOrPassword(AuthorizationUserRequest request) {
        if (userRepository.fiendAllUsers().stream().
                filter(user -> user.getEmail().equals(request.getEmail())
                        && Arrays.equals(user.getPassword(), request.getPassword()))
                .findFirst()
                .isEmpty()) {
            return Optional.of(new CoreError("email or password", "is incorrect!"));
        } else {
            return Optional.empty();
        }
    }
}
