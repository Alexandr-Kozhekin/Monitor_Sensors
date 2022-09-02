package com.monitor_sensors.core.service.user_service;

import com.monitor_sensors.core.database.UserRepository;
import com.monitor_sensors.core.domain.User;
import com.monitor_sensors.core.requests.user_requests.RegistrationUserRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.user_response.RegistrationUserResponse;
import com.monitor_sensors.core.service.validators.user_validators.RegistrationUserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegistrationUserService {

    @Autowired UserRepository userRepository;

    @Autowired RegistrationUserValidator validator;

    public RegistrationUserResponse execute(RegistrationUserRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new RegistrationUserResponse(errors);
        }

        User registration = new User(request.getEmail(), request.getPassword());

        userRepository.registrationUser(registration);

        return new RegistrationUserResponse(registration);
    }

}
