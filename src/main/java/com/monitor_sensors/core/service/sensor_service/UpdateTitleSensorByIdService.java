package com.monitor_sensors.core.service.sensor_service;

import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.requests.sensor_requests.UpdateTitleSensorByIdRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.sensor_response.SaveSensorResponse;
import com.monitor_sensors.core.responses.sensor_response.UpdateTitleSensorByIdResponse;
import com.monitor_sensors.core.service.validators.sensor_validators.UpdateTitleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateTitleSensorByIdService {

    @Autowired private SensorRepository sensorRepository;

    @Autowired private UpdateTitleValidator validator;

    public UpdateTitleSensorByIdResponse execute(UpdateTitleSensorByIdRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new UpdateTitleSensorByIdResponse(errors);
        }

        return new UpdateTitleSensorByIdResponse(sensorRepository
                .updateTitleSensorById(request.getUpdateTitle(), request.getId()));
    }
}
