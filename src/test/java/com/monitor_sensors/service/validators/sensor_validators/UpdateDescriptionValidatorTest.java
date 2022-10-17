package com.monitor_sensors.service.validators.sensor_validators;

import com.monitor_sensors.core.requests.sensor_requests.UpdateDescriptionSensorByIdRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.service.validators.sensor_validators.UpdateDescriptionValidator;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateDescriptionValidatorTest {

    private UpdateDescriptionValidator validator = new UpdateDescriptionValidator();

    @Test
    public void shouldNotReturnErrors() {

        UpdateDescriptionSensorByIdRequest request = new UpdateDescriptionSensorByIdRequest("test", 1L);

        List<CoreError> errors = validator.validate(request);

        assertTrue(errors.isEmpty());

    }

    @Test
    public void idNotByEmptyTest() {

        UpdateDescriptionSensorByIdRequest request = new UpdateDescriptionSensorByIdRequest("test", 0L);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("id", errors.get(0).getField());
        assertEquals("Must not be empty!", errors.get(0).getMessage());

    }

    @Test
    public void updateDescriptionNotByLongTest() {

        String description = "";

        for(int i = 0; i <= 200; i++) description = description + "t";

        UpdateDescriptionSensorByIdRequest request = new UpdateDescriptionSensorByIdRequest(description, 1L);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("description", errors.get(0).getField());
        assertEquals("Must not be long!", errors.get(0).getMessage());

    }

}