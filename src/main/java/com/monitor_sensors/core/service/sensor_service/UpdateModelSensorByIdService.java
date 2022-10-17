package com.monitor_sensors.core.service.sensor_service;

import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.requests.sensor_requests.UpdateModelSensorByIdRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.sensor_response.UpdateModelSensorByIdResponse;
import com.monitor_sensors.core.service.validators.sensor_validators.UpdateModelValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateModelSensorByIdService {

    @Autowired private SensorRepository sensorRepository;

    @Autowired private UpdateModelValidator validator;

    public UpdateModelSensorByIdResponse execute(UpdateModelSensorByIdRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new UpdateModelSensorByIdResponse(errors);
        }

        return new UpdateModelSensorByIdResponse(sensorRepository
                .updateModelSensorById(request.getUpdateModel(), request.getId()));
    }

}
