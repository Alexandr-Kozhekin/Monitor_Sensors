package com.monitor_sensors.core.service.sensor_service;

import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.requests.sensor_requests.UpdateUnitSensorByIdRequest;
import com.monitor_sensors.core.responses.sensor_response.UpdateUnitSensorByIdResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUnitSensorByIdService {

    @Autowired private SensorRepository sensorRepository;

    public UpdateUnitSensorByIdResponse execute(UpdateUnitSensorByIdRequest request) {

        return new UpdateUnitSensorByIdResponse(sensorRepository
                .updateUnitSensorById(request.getUpdateUnit(), request.getId()));
    }

}
