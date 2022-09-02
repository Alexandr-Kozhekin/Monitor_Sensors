package com.monitor_sensors.core.responses.user_response;

import com.monitor_sensors.core.domain.User;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.CoreResponse;

import java.util.List;

public class AuthorizationUserResponse extends CoreResponse {

    private User authorization;

    public AuthorizationUserResponse(List<CoreError> errors) {
        super(errors);
    }

    public AuthorizationUserResponse(User authorization) {
        this.authorization = authorization;
    }

    public User getAuthorization() {
        return authorization;
    }

}
