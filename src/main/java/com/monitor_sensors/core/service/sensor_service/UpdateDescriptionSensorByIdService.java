package com.monitor_sensors.core.service.sensor_service;

import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.requests.sensor_requests.UpdateDescriptionSensorByIdRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.sensor_response.UpdateDescriptionSensorByIdResponse;
import com.monitor_sensors.core.service.validators.sensor_validators.UpdateDescriptionValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateDescriptionSensorByIdService {

    @Autowired private SensorRepository sensorRepository;

    @Autowired private UpdateDescriptionValidator validator;

    public UpdateDescriptionSensorByIdResponse execute(UpdateDescriptionSensorByIdRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new UpdateDescriptionSensorByIdResponse(errors);
        }

        return new UpdateDescriptionSensorByIdResponse(sensorRepository
                .updateDescriptionSensorById(request.getUpdateDescription(), request.getId()));
    }

}
