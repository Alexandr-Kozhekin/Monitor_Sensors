package com.monitor_sensors.web_controllers;

import com.monitor_sensors.core.requests.sensor_requests.*;
import com.monitor_sensors.core.responses.sensor_response.*;
import com.monitor_sensors.core.service.sensor_service.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired private SaveSensorService saveSensorService;

    @Autowired private FindAllSensorService findAllSensorService;

    @Autowired private FindAllSensorByTitleService findAllSensorByTitleService;

    @Autowired private FindAllSensorByModelService findAllSensorByModelService;

    @Autowired private FindAllSensorByParamService findAllSensorByParamService;

    @Autowired private UpdateTitleSensorByIdService updateTitleSensorByIdService;

    @Autowired private UpdateModelSensorByIdService updateModelSensorByIdService;

    @Autowired private UpdateRangeFromSensorByIdService updateRangeFromSensorByIdService;

    @Autowired private UpdateRangeToSensorByIdService updateRangeToSensorByIdService;

    @Autowired private UpdateTypeSensorByIdService updateTypeSensorByIdService;

    @Autowired private UpdateUnitSensorByIdService updateUnitSensorByIdService;

    @Autowired private UpdateLocationSensorByIdService updateLocationSensorByIdService;

    @Autowired private UpdateDescriptionSensorByIdService updateDescriptionSensorByIdService;

    @Autowired private DeleteSensorByIdService deleteSensorByIdService;


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

    @GetMapping(path = "/fiendByParam/{title}&{model}&{from}&{to}&{type}&{unit}&{location}&{description}",
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

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public SaveSensorResponse addEmployeeWithTitle(@RequestBody SaveSensorRequest request) {

        return saveSensorService.execute(request);
    }

    @PutMapping(path = "/title",
            consumes = "application/json",
            produces = "application/json")
    public UpdateTitleSensorByIdResponse updateTitleSensorById(@RequestBody UpdateTitleSensorByIdRequest request) {

        return updateTitleSensorByIdService.execute(request);
    }

    @PutMapping(path = "/model",
            consumes = "application/json",
            produces = "application/json")
    public UpdateModelSensorByIdResponse updateModelSensorById(@RequestBody UpdateModelSensorByIdRequest request) {

        return updateModelSensorByIdService.execute(request);
    }

    @PutMapping(path = "/rangeFrom",
            consumes = "application/json",
            produces = "application/json")
    public UpdateRangeFromSensorByIdResponse updateRangeFromSensorById(@RequestBody
                                                                        UpdateRangeFromSensorByIdRequest request) {

        return updateRangeFromSensorByIdService.execute(request);
    }

    @PutMapping(path = "/rangeTo",
            consumes = "application/json",
            produces = "application/json")
    public UpdateRangeToSensorByIdResponse updateRangeToSensorById(@RequestBody
                                                                        UpdateRangeToSensorByIdRequest request) {

        return updateRangeToSensorByIdService.execute(request);
    }

    @PutMapping(path = "/type",
            consumes = "application/json",
            produces = "application/json")
    public UpdateTypeSensorByIdResponse updateTypeSensorById(@RequestBody UpdateTypeSensorByIdRequest request) {

        return updateTypeSensorByIdService.execute(request);
    }

    @PutMapping(path = "/unit",
            consumes = "application/json",
            produces = "application/json")
    public UpdateUnitSensorByIdResponse updateUnitSensorById(@RequestBody UpdateUnitSensorByIdRequest request) {

        return updateUnitSensorByIdService.execute(request);
    }

    @PutMapping(path = "/location",
            consumes = "application/json",
            produces = "application/json")
    public UpdateLocationSensorByIdResponse updateLocationSensorById(@RequestBody
                                                                     UpdateLocationSensorByIdRequest request) {

        return updateLocationSensorByIdService.execute(request);
    }

    @PutMapping(path = "/description",
            consumes = "application/json",
            produces = "application/json")
    public UpdateDescriptionSensorByIdResponse updateDescriptionSensorById(@RequestBody
                                                                           UpdateDescriptionSensorByIdRequest request) {

        return updateDescriptionSensorByIdService.execute(request);
    }

    @DeleteMapping(path = "/deleteId={id}",
            produces = "application/json")
    public DeleteSensorByIdResponse deleteSensorById(@PathVariable Long id) {

        DeleteSensorByIdRequest request = new DeleteSensorByIdRequest(id);

        return deleteSensorByIdService.execute(request);
    }

}
