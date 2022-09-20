package com.monitor_sensors.core.service.sensor_service;

import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.domain.Sensor;
import com.monitor_sensors.core.requests.sensor_requests.SaveSensorRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.sensor_response.SaveSensorResponse;
import com.monitor_sensors.core.service.validators.sensor_validators.SaveSensorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveSensorService {

    @Autowired private SensorRepository sensorRepository;

    @Autowired private SaveSensorValidator validator;

    public SaveSensorResponse execute(SaveSensorRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new SaveSensorResponse(errors);
        }

        Sensor sensor = new Sensor(request.getTitle(), request.getModel(), request.getRange().getFrom(),
                request.getRange().getTo(), request.getType(), request.getUnit(),
                request.getLocation(), request.getDescription());

        sensorRepository.saveSensor(sensor);

        return new SaveSensorResponse(sensor);
    }
}
