package com.monitor_sensors.service.validators.sensor_validators;

import com.monitor_sensors.core.requests.sensor_requests.UpdateLocationSensorByIdRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.service.validators.sensor_validators.UpdateLocationValidator;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateLocationValidatorTest {

    private UpdateLocationValidator validator = new UpdateLocationValidator();

    @Test
    public void shouldNotReturnErrors() {

        UpdateLocationSensorByIdRequest request = new UpdateLocationSensorByIdRequest("test", 1L);

        List<CoreError> errors = validator.validate(request);

        assertTrue(errors.isEmpty());

    }

    @Test
    public void idNotByEmptyTest() {

        UpdateLocationSensorByIdRequest request = new UpdateLocationSensorByIdRequest("test", 0L);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("id", errors.get(0).getField());
        assertEquals("Must not be empty!", errors.get(0).getMessage());

    }

    @Test
    public void updateLocationNotByLongTest() {

        String location = "";

        for(int i = 0; i <= 40; i++) location = location + "t";

        UpdateLocationSensorByIdRequest request = new UpdateLocationSensorByIdRequest(location, 1L);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("location", errors.get(0).getField());
        assertEquals("Must not be long!", errors.get(0).getMessage());

    }

}