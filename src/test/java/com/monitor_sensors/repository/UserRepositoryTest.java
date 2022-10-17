package com.monitor_sensors.repository;

import com.monitor_sensors.DataBaseIT;
import com.monitor_sensors.core.database.UserRepository;
import com.monitor_sensors.core.database.UserRepositoryImpl;
import com.monitor_sensors.core.domain.User;

import org.junit.Before;
import org.junit.runner.RunWith;

import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Component
@RunWith(SpringRunner.class)
class UserRepositoryTest extends DataBaseIT {

    @Autowired private UserRepository userRepository;

    @Before
    void setUserRepository() {

        userRepository = new UserRepositoryImpl();

    }

    @BeforeEach
    void setUp() {

        fillTables();

    }

    @AfterEach
    void tearDown() {

        cleanTables();

    }

    @Test
    void registrationUserTest() {

        String password = "test_Password_123";

        User expected = new User("test@tset.test", password.toCharArray());
        expected.setId(1L);

        userRepository.registrationUser(expected);

        User actual = userRepository.findUserByEmail("test@tset.test");

        assertEquals(expected, actual);

    }

    @Test
    void authorizationUserTest() {

        String password = "$2a$12$yeeYr1D.f9coenLrXaFn.OGmEzAn/Xaw3rD1NsEFQi.8UrfYVl95W";

        User actual = userRepository.authorizationUser("test@test.test", password.toCharArray());

        assertEquals("ADMIN", actual.getUserRole().toString());
        assertEquals("ACTIVE", actual.getUserState().toString());
        assertEquals("test@test.test", actual.getEmail());

    }

    @Test
    void fiendAllUsersTest() {

        List<User> actual = userRepository.fiendAllUsers();

        assertFalse(actual.isEmpty());

        assertEquals(1, actual.size());

    }

    @Test
    void findUserByEmailTest() {

        User actual = userRepository.findUserByEmail("test@test.test");

        assertEquals("test@test.test", actual.getEmail());

    }

}