package com.monitor_sensors.service.user_service;

import com.monitor_sensors.core.database.UserRepository;
import com.monitor_sensors.core.requests.user_requests.RegistrationUserRequest;
import com.monitor_sensors.core.responses.CoreError;
import com.monitor_sensors.core.responses.user_response.RegistrationUserResponse;
import com.monitor_sensors.core.service.user_service.RegistrationUserService;
import com.monitor_sensors.core.service.validators.user_validators.RegistrationUserValidator;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.*;

import org.mockito.Mockito;

import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationUserServiceTest {

    @Mock private UserRepository userRepository;

    @Mock private RegistrationUserValidator registrationUserValidator;

    @Mock private PasswordEncoder passwordEncoder;

    @InjectMocks private RegistrationUserService registrationUserService;

    @Test
    public void successfullyRegistrationUserServiceTest() {

        String email = "qwerty@qwe.com";

        char[] password = new char[]{'q', 'w', 'e', 'r', 't', 'y', '1', '2', '3'};

        RegistrationUserRequest request = new RegistrationUserRequest(email, password);

        Mockito.when(passwordEncoder.encode(String.copyValueOf(password))).thenReturn("qwerty123");

        RegistrationUserResponse response = registrationUserService.execute(request);

        Mockito.verify(userRepository).registrationUser(response.getUser());

        assertThat(response.hasErrors()).isFalse();

    }

    @Test
    public void emailEmptyServiceTest() {

        char[] password = new char[]{'q', 'w', 'e', 'r', 't', 'y', '1', '2', '3'};

        RegistrationUserRequest request = new RegistrationUserRequest(null, password);

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("email", "Must not be empty!"));
        }};

        Mockito.when(registrationUserValidator.validate(request)).thenReturn(errors);

        RegistrationUserResponse response = registrationUserService.execute(request);

        assertEquals(1, response.getErrors().size());
        assertTrue(response.getErrors().contains(new CoreError("email",
                "Must not be empty!")));

    }

    @Test
    public void emailWrongFormatServiceTest() {

        String email = "qwerty";

        char[] password = new char[]{'q', 'w', 'e', 'r', 't', 'y', '1', '2', '3'};

        RegistrationUserRequest request = new RegistrationUserRequest(email, password);

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("email", "Wrong format!"));
        }};

        Mockito.when(registrationUserValidator.validate(request)).thenReturn(errors);

        RegistrationUserResponse response = registrationUserService.execute(request);

        assertEquals(1, response.getErrors().size());
        assertTrue(response.getErrors().contains(new CoreError("email",
                "Wrong format!")));

    }

    @Test
    public void passwordEmptyServiceTest() {

        String email = "qwerty@qwe.com";

        RegistrationUserRequest request = new RegistrationUserRequest(email, null);

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("password", "Must not be empty!"));
        }};

        Mockito.when(registrationUserValidator.validate(request)).thenReturn(errors);

        RegistrationUserResponse response = registrationUserService.execute(request);

        assertEquals(1, response.getErrors().size());
        assertTrue(response.getErrors().contains(new CoreError("password",
                "Must not be empty!")));

    }

    @Test
    public void passwordBeShortServiceTest() {

        String email = "qwerty@qwe.com";

        char[] password = new char[]{'q', 'w', 'e', 'r'};

        RegistrationUserRequest request = new RegistrationUserRequest(email, password);

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("password", "Must not be short!"));
        }};

        Mockito.when(registrationUserValidator.validate(request)).thenReturn(errors);

        RegistrationUserResponse response = registrationUserService.execute(request);

        assertEquals(1, response.getErrors().size());
        assertTrue(response.getErrors().contains(new CoreError("password",
                "Must not be short!")));

    }

    @Test
    public void passwordContainOnlyLettersServiceTest() {

        String email = "qwerty@qwe.com";

        char[] password = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};

        RegistrationUserRequest request = new RegistrationUserRequest(email, password);

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("password", "Must not contain only numbers or letters!"));
        }};

        Mockito.when(registrationUserValidator.validate(request)).thenReturn(errors);

        RegistrationUserResponse response = registrationUserService.execute(request);

        assertEquals(1, response.getErrors().size());
        assertTrue(response.getErrors().contains(new CoreError("password",
                "Must not contain only numbers or letters!")));

    }

    @Test
    public void passwordContainOnlyNumbersServiceTest() {

        String email = "qwerty@qwe.com";

        char[] password = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

        RegistrationUserRequest request = new RegistrationUserRequest(email, password);

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("password", "Must not contain only numbers or letters!"));
        }};

        Mockito.when(registrationUserValidator.validate(request)).thenReturn(errors);

        RegistrationUserResponse response = registrationUserService.execute(request);

        assertEquals(1, response.getErrors().size());
        assertTrue(response.getErrors().contains(new CoreError("password",
                "Must not contain only numbers or letters!")));

    }

    @Test
    public void passwordContainSpaceServiceTest() {

        String email = "qwerty@qwe.com";

        char[] password = new char[]{'q', 'w', 'e', 'r', ' ', 'y', 'u', 'i', 'o', 'p'};

        RegistrationUserRequest request = new RegistrationUserRequest(email, password);

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("password", "Must not contain space!"));
        }};

        Mockito.when(registrationUserValidator.validate(request)).thenReturn(errors);

        RegistrationUserResponse response = registrationUserService.execute(request);

        assertEquals(1, response.getErrors().size());
        assertTrue(response.getErrors().contains(new CoreError("password",
                "Must not contain space!")));

    }

    @Test
    public void emailAndPasswordEmptyServiceTest() {

        RegistrationUserRequest request = new RegistrationUserRequest(null, null);

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("email", "Must not be empty!"));
            add(new CoreError("password", "Must not be empty!"));
        }};

        Mockito.when(registrationUserValidator.validate(request)).thenReturn(errors);

        RegistrationUserResponse response = registrationUserService.execute(request);

        assertEquals(2, response.getErrors().size());
        assertTrue(response.getErrors().contains(new CoreError("email",
                "Must not be empty!")));
        assertTrue(response.getErrors().contains(new CoreError("password",
                "Must not be empty!")));

    }

}