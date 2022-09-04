package com.monitor_sensors.web_controllers;

import com.monitor_sensors.core.requests.sensor_requests.*;
import com.monitor_sensors.core.responses.sensor_response.*;
import com.monitor_sensors.core.service.sensor_service.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private FindAllSensorService findAllSensorService;

    @Autowired private FindAllSensorByTitleService findAllSensorByTitleService;

    @Autowired private FindAllSensorByModelService findAllSensorByModelService;

    @Autowired private FindAllSensorByParamService findAllSensorByParamService;

    @GetMapping(path = "/",
            produces = "application/json")
    public FindAllSensorResponse findAllSensor() {

        return findAllSensorService.execute(new FindAllSensorRequest());
    }

    @GetMapping(path = "/title={title}",
            produces = "application/json")
    public FindAllSensorByTitleResponse findAllSensorByTitle(@PathVariable String title) {

        FindAllSensorByTitleRequest request = new FindAllSensorByTitleRequest(title);

        return findAllSensorByTitleService.execute(request);
    }

    @GetMapping(path = "/model={model}",
            produces = "application/json")
    public FindAllSensorByModelResponse findAllSensorByModel(@PathVariable String model) {

        FindAllSensorByModelRequest request = new FindAllSensorByModelRequest(model);

        return findAllSensorByModelService.execute(request);
    }

    @GetMapping(path = "/fiendByParam/title={title}&model={model}&from={from}&to={to}&type={type}" +
            "&unit={unit}&location={location}&description={description}",
            produces = "application/json")
    public FindAllSensorByParamResponse findAllSensorByParam(@PathVariable String title,
                                                             @PathVariable String model,
                                                             @PathVariable String from,
                                                             @PathVariable String to,
                                                             @PathVariable String type,
                                                             @PathVariable String unit,
                                                             @PathVariable String location,
                                                             @PathVariable String description) {

        FindAllSensorByParamRequest request = new FindAllSensorByParamRequest(title, model, from, to,
                type, unit, location, description);

        return findAllSensorByParamService.execute(request);
    }

}
