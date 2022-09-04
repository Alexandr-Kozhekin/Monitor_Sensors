package com.monitor_sensors.core.service.sensor_service;

import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.requests.sensor_requests.FindAllSensorRequest;
import com.monitor_sensors.core.responses.sensor_response.FindAllSensorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAllSensorService {

    @Autowired private SensorRepository sensorRepository;

    public FindAllSensorResponse execute(FindAllSensorRequest request) {

        return new FindAllSensorResponse(sensorRepository.findAllSensor());
    }
}
