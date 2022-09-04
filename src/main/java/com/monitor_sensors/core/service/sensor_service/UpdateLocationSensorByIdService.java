package com.monitor_sensors.core.service.sensor_service;

import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.requests.sensor_requests.UpdateLocationSensorByIdRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.sensor_response.UpdateLocationSensorByIdResponse;
import com.monitor_sensors.core.responses.sensor_response.UpdateTitleSensorByIdResponse;
import com.monitor_sensors.core.service.validators.sensor_validators.UpdateLocationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateLocationSensorByIdService {

    @Autowired private SensorRepository sensorRepository;

    @Autowired private UpdateLocationValidator validator;

    public UpdateLocationSensorByIdResponse execute(UpdateLocationSensorByIdRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new UpdateLocationSensorByIdResponse(errors);
        }

        return new UpdateLocationSensorByIdResponse(sensorRepository
                .updateLocationSensorById(request.getUpdateLocation(), request.getId()));
    }
}
