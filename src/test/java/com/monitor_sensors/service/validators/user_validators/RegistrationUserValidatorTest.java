package com.monitor_sensors.service.validators.user_validators;

import com.monitor_sensors.core.requests.user_requests.RegistrationUserRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.service.validators.user_validators.RegistrationUserValidator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationUserValidatorTest {

    private RegistrationUserValidator validator = new RegistrationUserValidator();

    @Test
    public void shouldNotReturnErrors() {

        String email = "testTESTtest@test.test";

        char[] password = new char[]{'t', 'e', 's', 't', '1', '2', '3', '4'};

        RegistrationUserRequest request = new RegistrationUserRequest(email, password);

        List<CoreError> errors = validator.validate(request);

        assertTrue(errors.isEmpty());

    }

    @Test
    public void emailBeEmptyTest() {

        char[] password = new char[]{'t', 'e', 's', 't', '1', '2', '3', '4'};

        RegistrationUserRequest request = new RegistrationUserRequest(null, password);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("email", errors.get(0).getField());
        assertEquals("Must not be empty!", errors.get(0).getMessage());

    }

    @Test
    public void emailWrongFormatTest() {

        String email = "testTESTtest";

        char[] password = new char[]{'t', 'e', 's', 't', '1', '2', '3', '4'};

        RegistrationUserRequest request = new RegistrationUserRequest(email, password);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("email", errors.get(0).getField());
        assertEquals("Wrong format!", errors.get(0).getMessage());

    }

    @Test
    public void passwordBeEmptyTest() {

        String email = "testTESTtest@test.test";

        RegistrationUserRequest request = new RegistrationUserRequest(email, new char[0]);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("password", errors.get(0).getField());
        assertEquals("Must not be empty!", errors.get(0).getMessage());

    }

    @Test
    public void passwordBeShortTest() {

        String email = "testTESTtest@test.test";

        char[] password = new char[]{'t', 'e', 's', 't', '1'};

        RegistrationUserRequest request = new RegistrationUserRequest(email, password);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("password", errors.get(0).getField());
        assertEquals("Must not be short!", errors.get(0).getMessage());

    }

    @Test
    public void passwordContainOnlyNumbersTest() {

        String email = "testTESTtest@test.test";

        char[] password = new char[]{'1', '2', '3', '4', '5', '6'};

        RegistrationUserRequest request = new RegistrationUserRequest(email, password);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("password", errors.get(0).getField());
        assertEquals("Must not contain only numbers or letters!", errors.get(0).getMessage());

    }

    @Test
    public void passwordContainOnlyLettersTest() {

        String email = "testTESTtest@test.test";

        char[] password = new char[]{'t', 'e', 's', 't', 't', 'e'};

        RegistrationUserRequest request = new RegistrationUserRequest(email, password);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("password", errors.get(0).getField());
        assertEquals("Must not contain only numbers or letters!", errors.get(0).getMessage());

    }

    @Test
    public void passwordContainSpaceTest() {

//        String email = "testTESTtest@test.test";
//
//        char[] password = new char[]{' ', 'e', ' ', 't', 't', 'e', ' ', '1'};
//
//        RegistrationUserRequest request = new RegistrationUserRequest(email, password);
//
//        List<CoreError> errors = validator.validate(request);
//
//        assertEquals(1, errors.size());
//        assertEquals("password", errors.get(0).getField());
//        assertEquals("Must not contain space!", errors.get(0).getMessage());

    }

}
