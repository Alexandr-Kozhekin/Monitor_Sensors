package com.monitor_sensors.service.validators.user_validators;

import com.monitor_sensors.core.database.UserRepository;
import com.monitor_sensors.core.domain.User;
import com.monitor_sensors.core.requests.user_requests.AuthorizationUserRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.service.validators.user_validators.AuthorizationUserValidator;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class AuthorizationUserValidatorTest {

    @Mock private UserRepository userRepository;

    @InjectMocks private AuthorizationUserValidator validator;

    @Test
    public void shouldNotReturnErrors() {

        String email = "testTESTtest@test.test";

        char[] password = new char[]{'t', 'e', 's', 't', '1', '2', '3', '4'};

        AuthorizationUserRequest request = new AuthorizationUserRequest(email, password);

        List<User> users = new ArrayList<>();
        users.add(new User(email, password));

        Mockito.when(userRepository.fiendAllUsers()).thenReturn(users);

        List<CoreError> errors = validator.validate(request);

        assertTrue(errors.isEmpty());

    }

    @Test
    public void emailByEmptyTest() {

        char[] password = new char[]{'t', 'e', 's', 't', '1', '2', '3', '4'};

        AuthorizationUserRequest request = new AuthorizationUserRequest("", password);

        List<User> users = new ArrayList<>();
        users.add(new User("", password));

        Mockito.when(userRepository.fiendAllUsers()).thenReturn(users);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("email", errors.get(0).getField());
        assertEquals("Must not be empty!", errors.get(0).getMessage());

    }

    @Test
    public void emailByPasswordTest() {

        String email = "testTESTtest@test.test";

        AuthorizationUserRequest request = new AuthorizationUserRequest(email, new char[]{});

        List<User> users = new ArrayList<>();
        users.add(new User(email, new char[]{}));

        Mockito.when(userRepository.fiendAllUsers()).thenReturn(users);

        List<CoreError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("password", errors.get(0).getField());
        assertEquals("Must not be empty!", errors.get(0).getMessage());

    }

}