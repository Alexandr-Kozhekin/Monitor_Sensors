package com.monitor_sensors.core.service.sensor_service;

import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.requests.sensor_requests.UpdateTypeSensorByIdRequest;
import com.monitor_sensors.core.responses.sensor_response.UpdateTypeSensorByIdResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateTypeSensorByIdService {

    @Autowired private SensorRepository sensorRepository;

    public UpdateTypeSensorByIdResponse execute(UpdateTypeSensorByIdRequest request) {

        return new UpdateTypeSensorByIdResponse(sensorRepository
                .updateTypeSensorById(request.getUpdateType(), request.getId()));
    }

}
