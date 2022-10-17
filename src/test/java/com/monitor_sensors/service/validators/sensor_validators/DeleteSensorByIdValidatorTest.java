package com.monitor_sensors.service.validators.sensor_validators;

import com.monitor_sensors.core.requests.sensor_requests.DeleteSensorByIdRequest;
import com.monitor_sensors.core.requests.sensor_requests.UpdateTitleSensorByIdRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.service.validators.sensor_validators.DeleteSensorByIdValidator;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteSensorByIdValidatorTest {

    private DeleteSensorByIdValidator validator = new DeleteSensorByIdValidator();

    @Test
    public void shouldNotReturnError() {

        DeleteSensorByIdRequest request = new DeleteSensorByIdRequest(1L);

        List<CoreError> errors = validator.validate(request);

        assertTrue(errors.isEmpty());

    }

    @Test
    public void idNotByEmptyTest() {

        DeleteSensorByIdRequest request = new DeleteSensorByIdRequest(0L);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("id", errors.get(0).getField());
        assertEquals("Must not be empty!", errors.get(0).getMessage());

    }

}
