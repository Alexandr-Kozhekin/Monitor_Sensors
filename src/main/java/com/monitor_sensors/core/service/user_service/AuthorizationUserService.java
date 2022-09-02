package com.monitor_sensors.core.service.user_service;

import com.monitor_sensors.core.database.UserRepository;
import com.monitor_sensors.core.domain.User;
import com.monitor_sensors.core.requests.user_requests.AuthorizationUserRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.user_response.AuthorizationUserResponse;
import com.monitor_sensors.core.service.validators.user_validators.AuthorizationUserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorizationUserService {

    @Autowired UserRepository userRepository;

    @Autowired AuthorizationUserValidator validator;

    public AuthorizationUserResponse execute(AuthorizationUserRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new AuthorizationUserResponse(errors);
        }

        User user = userRepository.authorizationUser(request.getEmail(), request.getPassword());

        return new AuthorizationUserResponse(user);

    }
}
