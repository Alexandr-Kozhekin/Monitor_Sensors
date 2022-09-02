package com.monitor_sensors.core.responses.user_response;


import com.monitor_sensors.core.domain.User;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.CoreResponse;

import java.util.List;

public class RegistrationUserResponse extends CoreResponse {

    private User user;

    public RegistrationUserResponse(List<CoreError> errors) {
        super(errors);
    }

    public RegistrationUserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
