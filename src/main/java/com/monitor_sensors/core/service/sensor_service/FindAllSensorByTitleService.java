package com.monitor_sensors.core.service.sensor_service;

import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.requests.sensor_requests.FindAllSensorByTitleRequest;
import com.monitor_sensors.core.responses.sensor_response.FindAllSensorByTitleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAllSensorByTitleService {

    @Autowired SensorRepository sensorRepository;

    public FindAllSensorByTitleResponse execute(FindAllSensorByTitleRequest request) {

        return new FindAllSensorByTitleResponse(sensorRepository.findAllSensorByTitle(request.getTitle()));
    }
}
