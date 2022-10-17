package com.monitor_sensors.core.service.sensor_service;

import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.requests.sensor_requests.UpdateRangeToSensorByIdRequest;
import com.monitor_sensors.core.responses.sensor_response.UpdateRangeToSensorByIdResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateRangeToSensorByIdService {

    @Autowired private SensorRepository sensorRepository;

    public UpdateRangeToSensorByIdResponse execute(UpdateRangeToSensorByIdRequest request) {

        return new UpdateRangeToSensorByIdResponse(sensorRepository
                .updateRangeToSensorById(request.getUpdateRangeTo(), request.getId()));
    }

}
