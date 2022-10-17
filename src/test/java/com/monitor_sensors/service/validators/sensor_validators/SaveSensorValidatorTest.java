package com.monitor_sensors.service.validators.sensor_validators;

import com.monitor_sensors.core.requests.sensor_requests.RangeRequest;
import com.monitor_sensors.core.requests.sensor_requests.SaveSensorRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.service.validators.sensor_validators.SaveSensorValidator;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SaveSensorValidatorTest {

    private SaveSensorValidator validator = new SaveSensorValidator();

    @Test
    public void shouldNotReturnErrors() {

        SaveSensorRequest request = new SaveSensorRequest("test", "test",
                new RangeRequest(0, 0), "test");

        List<CoreError> errors = validator.validate(request);

        assertTrue(errors.isEmpty());

    }

    @Test
    public void titleByEmptyTest() {

        SaveSensorRequest request = new SaveSensorRequest(null, "test",
                new RangeRequest(0, 0), "test");

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("title", errors.get(0).getField());
        assertEquals("Must not be empty!", errors.get(0).getMessage());

    }

    @Test
    public void titleNotByLongTest() {

        String name = "";

        for(int i = 0; i <= 30; i++) name = name + "t";

        SaveSensorRequest request = new SaveSensorRequest(name, "test",
                new RangeRequest(0, 0), "test");

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("title", errors.get(0).getField());
        assertEquals("Must not be long!", errors.get(0).getMessage());

    }

    @Test
    public void modelByEmptyTest() {

        SaveSensorRequest request = new SaveSensorRequest("test", null,
                new RangeRequest(0, 0), "test");

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("model", errors.get(0).getField());
        assertEquals("Must not be empty!", errors.get(0).getMessage());

    }

    @Test
    public void modelNotByLongTest() {

        String model = "";

        for(int i = 0; i <= 15; i++) model = model + "t";

        SaveSensorRequest request = new SaveSensorRequest("test", model,
                new RangeRequest(0, 0), "test");

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("model", errors.get(0).getField());
        assertEquals("Must not be long!", errors.get(0).getMessage());

    }

    @Test
    public void rangeNotByLongTest() {

        SaveSensorRequest request = new SaveSensorRequest("test", "test",
                null, "test");

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("range", errors.get(0).getField());
        assertEquals("Must not be empty!", errors.get(0).getMessage());

    }

    @Test
    public void rangeFromMustBeLessThanToTest() {

        SaveSensorRequest request = new SaveSensorRequest("test", "test",
                new RangeRequest(1, 0), "test");

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("range", errors.get(0).getField());
        assertEquals("From must be less than to!", errors.get(0).getMessage());

    }

    @Test
    public void locationNotByLongTest() {

        String location = "";

        for(int i = 0; i <= 40; i++) location = location + "t";

        SaveSensorRequest request = new SaveSensorRequest("test", "test",
                new RangeRequest(0, 0), "test", "", location, "");

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("location", errors.get(0).getField());
        assertEquals("Must not be long!", errors.get(0).getMessage());

    }

    @Test
    public void descriptionNotByLongTest() {

        String description = "";

        for(int i = 0; i <= 200; i++) description = description + "t";

        SaveSensorRequest request = new SaveSensorRequest("test", "test",
                new RangeRequest(0, 0), "test", "", "", description);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("description", errors.get(0).getField());
        assertEquals("Must not be long!", errors.get(0).getMessage());

    }

}