package com.monitor_sensors.service.validators.sensor_validators;

import com.monitor_sensors.core.requests.sensor_requests.UpdateModelSensorByIdRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.service.validators.sensor_validators.UpdateModelValidator;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateModelValidatorTest {

    private UpdateModelValidator validator = new UpdateModelValidator();

    @Test
    public void shouldNotReturnErrors() {

        UpdateModelSensorByIdRequest request = new UpdateModelSensorByIdRequest("test", 1L);

        List<CoreError> errors = validator.validate(request);

        assertTrue(errors.isEmpty());

    }

    @Test
    public void idNotByEmptyTest() {

        UpdateModelSensorByIdRequest request = new UpdateModelSensorByIdRequest("test", 0L);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("id", errors.get(0).getField());
        assertEquals("Must not be empty!", errors.get(0).getMessage());

    }

    @Test
    public void updateModelNotByLongTest() {

        String model = "";

        for(int i = 0; i <= 15; i++) model = model + "t";

        UpdateModelSensorByIdRequest request = new UpdateModelSensorByIdRequest(model, 1L);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("model", errors.get(0).getField());
        assertEquals("Must not be long!", errors.get(0).getMessage());

    }

}