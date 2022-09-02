package com.monitor_sensors.web_controllers;

import com.monitor_sensors.core.requests.user_requests.*;
import com.monitor_sensors.core.responses.user_response.*;
import com.monitor_sensors.core.service.user_service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired RegistrationUserService registrationUserService;

    @Autowired AuthorizationUserService authorizationUserService;

    @PostMapping(path = "/registration",
            consumes = "application/json",
            produces = "application/json")
    public RegistrationUserResponse registration(@RequestBody RegistrationUserRequest request) {
        return registrationUserService.execute(request);
    }

    @PostMapping(path = "/authorization",
            consumes = "application/json",
            produces = "application/json")
    public AuthorizationUserResponse authorization(@RequestBody AuthorizationUserRequest request) {
        return authorizationUserService.execute(request);
    }
}
