package com.monitor_sensors.core.service.sensor_service;

import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.requests.sensor_requests.FindAllSensorByModelRequest;
import com.monitor_sensors.core.responses.sensor_response.FindAllSensorByModelResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAllSensorByModelService {

    @Autowired private SensorRepository sensorRepository;

    public FindAllSensorByModelResponse execute(FindAllSensorByModelRequest request) {

        return new FindAllSensorByModelResponse(sensorRepository.findAllSensorByModel(request.getModel()));
    }

}
