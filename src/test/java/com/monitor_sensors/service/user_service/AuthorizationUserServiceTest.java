package com.monitor_sensors.service.user_service;

import com.monitor_sensors.core.database.UserRepository;
import com.monitor_sensors.core.domain.User;
import com.monitor_sensors.core.requests.user_requests.AuthorizationUserRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.user_response.AuthorizationUserResponse;
import com.monitor_sensors.core.service.user_service.AuthorizationUserService;
import com.monitor_sensors.core.service.validators.user_validators.AuthorizationUserValidator;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.*;

import org.mockito.Mockito;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class AuthorizationUserServiceTest {

    @Mock private UserRepository userRepository;

    @Mock private AuthorizationUserValidator authorizationUserValidator;

    @InjectMocks private AuthorizationUserService authorizationUserService;

    @Test
    public void successfullyAuthorizationUserServiceTest() {

        String email = "qwerty@qwe.com";

        char[] password = new char[]{'q', 'w', 'e', 'r', 't', 'y', '1', '2', '3'};

        User user = new User(email, password);

        AuthorizationUserRequest request = new AuthorizationUserRequest(email, password);

        Mockito.when(userRepository.authorizationUser(Mockito.any(), Mockito.any()))
                .thenReturn(user);

        AuthorizationUserResponse response = authorizationUserService.execute(request);

        assertThat(response.hasErrors()).isFalse();
        assertEquals(response.getAuthorization(), user);

    }

    @Test
    public void emailEmptyServiceTest() {

        char[] password = new char[]{'q', 'w', 'e', 'r', 't', 'y', '1', '2', '3'};

        AuthorizationUserRequest request = new AuthorizationUserRequest(null, password);

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("email", "Must not be empty!"));
        }};

        Mockito.when(authorizationUserValidator.validate(request)).thenReturn(errors);

        AuthorizationUserResponse response = authorizationUserService.execute(request);

        assertEquals(1, response.getErrors().size());
        assertTrue(response.getErrors().contains(new CoreError("email",
                "Must not be empty!")));

    }

    @Test
    public void passwordEmptyServiceTest() {

        String email = "qwerty@qwe.com";

        AuthorizationUserRequest request = new AuthorizationUserRequest(email, null);

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("password", "Must not be empty!"));
        }};

        Mockito.when(authorizationUserValidator.validate(request)).thenReturn(errors);

        AuthorizationUserResponse response = authorizationUserService.execute(request);

        assertEquals(1, response.getErrors().size());
        assertTrue(response.getErrors().contains(new CoreError("password",
                "Must not be empty!")));

    }

    @Test
    public void emailAndPasswordEmptyServiceTest() {

        AuthorizationUserRequest request = new AuthorizationUserRequest(null,null);

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("email", "Must not be empty!"));
            add(new CoreError("password", "Must not be empty!"));
        }};

        Mockito.when(authorizationUserValidator.validate(request)).thenReturn(errors);

        AuthorizationUserResponse response = authorizationUserService.execute(request);

        assertEquals(2, response.getErrors().size());
        assertTrue(response.getErrors().contains(new CoreError("email",
                "Must not be empty!")));
        assertTrue(response.getErrors().contains(new CoreError("password",
                "Must not be empty!")));

    }

}