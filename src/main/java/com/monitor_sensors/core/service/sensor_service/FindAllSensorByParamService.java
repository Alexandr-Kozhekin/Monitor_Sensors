package com.monitor_sensors.core.service.sensor_service;

import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.domain.Sensor;
import com.monitor_sensors.core.requests.sensor_requests.FindAllSensorByParamRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.sensor_response.FindAllSensorByParamResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FindAllSensorByParamService {

    @Autowired private SensorRepository sensorRepository;

    public FindAllSensorByParamResponse execute(FindAllSensorByParamRequest request) {

//        List<CoreError> errors = validator.validate(request);
//
//        if (!errors.isEmpty()) {
//            return new FindAllSensorByParamResponse(errors);
//        }

        String[] p = new String[] {
                request.getTitle(), request.getModel(), request.getFrom(),
                request.getTo(), request.getType(), request.getUnit(),
                request.getLocation(), request.getDescription()
        };

        ArrayList<Sensor> sensors = sensorRepository.findAllSensorByParam(p);

        return new FindAllSensorByParamResponse(sensors);

    }

}
