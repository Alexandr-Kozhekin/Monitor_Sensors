package com.monitor_sensors.core.service.sensor_service;

import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.requests.sensor_requests.DeleteSensorByIdRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.sensor_response.DeleteSensorByIdResponse;
import com.monitor_sensors.core.service.validators.sensor_validators.DeleteSensorByIdValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteSensorByIdService {

    @Autowired private SensorRepository sensorRepository;

    @Autowired private DeleteSensorByIdValidator validator;

    public DeleteSensorByIdResponse execute(DeleteSensorByIdRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new DeleteSensorByIdResponse(errors);
        }

        return new DeleteSensorByIdResponse(sensorRepository.deleteSensorById(request.getId()));
    }
}
