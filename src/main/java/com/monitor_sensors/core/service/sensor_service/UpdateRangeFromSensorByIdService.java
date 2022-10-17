package com.monitor_sensors.core.service.sensor_service;

import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.requests.sensor_requests.UpdateRangeFromSensorByIdRequest;
import com.monitor_sensors.core.responses.sensor_response.UpdateRangeFromSensorByIdResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateRangeFromSensorByIdService {

    @Autowired private SensorRepository sensorRepository;

    public UpdateRangeFromSensorByIdResponse execute(UpdateRangeFromSensorByIdRequest request) {

        return new UpdateRangeFromSensorByIdResponse(sensorRepository
                .updateRangeFromSensorById(request.getUpdateRangeFrom(), request.getId()));
    }

}
