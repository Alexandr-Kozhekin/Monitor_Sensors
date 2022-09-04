package com.monitor_sensors.core.service.sensor_service;

import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.requests.sensor_requests.DeleteSensorByIdRequest;
import com.monitor_sensors.core.responses.sensor_response.DeleteSensorByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteSensorByIdService {

    @Autowired private SensorRepository sensorRepository;

    public DeleteSensorByIdResponse execute(DeleteSensorByIdRequest request) {

        return new DeleteSensorByIdResponse(sensorRepository.deleteSensorById(request.getId()));
    }
}
