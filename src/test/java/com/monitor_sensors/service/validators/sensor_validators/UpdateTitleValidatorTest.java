package com.monitor_sensors.service.validators.sensor_validators;

import com.monitor_sensors.core.requests.sensor_requests.UpdateTitleSensorByIdRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.service.validators.sensor_validators.UpdateTitleValidator;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateTitleValidatorTest {

    private UpdateTitleValidator validator = new UpdateTitleValidator();

    @Test
    public void shouldNotReturnErrors() {

        UpdateTitleSensorByIdRequest request = new UpdateTitleSensorByIdRequest("test", 1L);

        List<CoreError> errors = validator.validate(request);

        assertTrue(errors.isEmpty());

    }

    @Test
    public void idNotByEmptyTest() {

        UpdateTitleSensorByIdRequest request = new UpdateTitleSensorByIdRequest("test", 0L);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("id", errors.get(0).getField());
        assertEquals("Must not be empty!", errors.get(0).getMessage());

    }

    @Test
    public void updateTitleNotByLongTest() {

        String title = "";

        for(int i = 0; i <= 30; i++) title = title + "t";

        UpdateTitleSensorByIdRequest request = new UpdateTitleSensorByIdRequest(title, 1L);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("title", errors.get(0).getField());
        assertEquals("Must not be long!", errors.get(0).getMessage());

    }

}