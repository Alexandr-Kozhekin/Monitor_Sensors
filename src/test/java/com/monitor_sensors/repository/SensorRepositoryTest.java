package com.monitor_sensors.repository;

import com.monitor_sensors.DataBaseIT;

import com.monitor_sensors.core.domain.Sensor;
import com.monitor_sensors.core.database.SensorRepository;
import com.monitor_sensors.core.database.SensorRepositoryImpl;

import org.junit.Before;

import org.junit.runner.RunWith;

import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@Component
@RunWith(SpringRunner.class)
class SensorRepositoryTest extends DataBaseIT {

    @Autowired private SensorRepository sensorRepository;

    @Before
    void setSensorRepository() {

        sensorRepository = new SensorRepositoryImpl();

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
    void saveSensorTest() {

        Sensor expected = new Sensor("test", "test_model_test", 0, 40, "Temperature");
        expected.setId(6L);

        sensorRepository.saveSensor(expected);

        ArrayList<Sensor> actual = sensorRepository.findAllSensor();

        assertFalse(actual.isEmpty());

        assertEquals(6, actual.size());
        assertEquals(expected, actual.get(5));

    }

    @Test
    void findAllSensorTest() {

        ArrayList<Sensor> actual = sensorRepository.findAllSensor();

        assertFalse(actual.isEmpty());

        assertEquals(5, actual.size());

    }

    @Test
    void findAllSensorByParamTest() {

        String[] paramOne = new String[] {"test1", "" , "", "", "", "", "", ""};
        String[] paramTwo = new String[] {"", "test_model1" , "", "", "", "", "", ""};
        String[] paramThree = new String[] {"", "" , "10", "", "", "", "", ""};
        String[] paramFour = new String[] {"", "" , "2", "30", "", "°С", "", ""};
        String[] paramFive = new String[] {"", "test_model2" , "2", "30", "Voltage", "", "", ""};


        ArrayList<Sensor> actualOne = sensorRepository.findAllSensorByParam(paramOne);
        ArrayList<Sensor> actualTwo = sensorRepository.findAllSensorByParam(paramTwo);
        ArrayList<Sensor> actualThree = sensorRepository.findAllSensorByParam(paramThree);
        ArrayList<Sensor> actualFour = sensorRepository.findAllSensorByParam(paramFour);
        ArrayList<Sensor> actualFive = sensorRepository.findAllSensorByParam(paramFive);

        assertEquals(1, actualOne.size());
        assertEquals("test1", actualOne.get(0).getTitle());

        assertEquals(2, actualTwo.size());
        assertEquals("test1", actualTwo.get(0).getTitle());
        assertEquals("test2", actualTwo.get(1).getTitle());

        assertEquals(1, actualThree.size());
        assertEquals("test5", actualThree.get(0).getTitle());

        assertEquals(4, actualFour.size());
        assertEquals("test1", actualFour.get(0).getTitle());
        assertEquals("test2", actualFour.get(1).getTitle());
        assertEquals("test3", actualFour.get(2).getTitle());
        assertEquals("test5", actualFour.get(3).getTitle());

        assertEquals(4, actualFive.size());
        assertEquals("test1", actualFive.get(0).getTitle());
        assertEquals("test2", actualFive.get(1).getTitle());
        assertEquals("test3", actualFive.get(2).getTitle());
        assertEquals("test4", actualFive.get(3).getTitle());

    }

    @Test
    void findAllSensorByTitleTest() {

        ArrayList<Sensor> actual = sensorRepository.findAllSensorByTitle("test1");

        assertFalse(actual.isEmpty());

        assertEquals(1, actual.size());
        assertEquals("test1", actual.get(0).getTitle());

    }

    @Test
    void findAllSensorByModelTest() {

        ArrayList<Sensor> actual = sensorRepository.findAllSensorByModel("test_model1");

        assertFalse(actual.isEmpty());

        assertEquals(2, actual.size());
        assertEquals("test_model1", actual.get(0).getModel());
        assertEquals("test_model1", actual.get(1).getModel());

    }

    @Test
    void updateTitleSensorByIdTest() {

        boolean actual = sensorRepository.updateTitleSensorById("update_title", 1L);

        assertTrue(actual);

    }

    @Test
    void updateModelSensorByIdTest() {

        boolean actual = sensorRepository.updateModelSensorById("update_model", 1L);

        assertTrue(actual);

    }

    @Test
    void updateRangeFromSensorByIdTest() {

        boolean actual = sensorRepository.updateRangeFromSensorById(1, 1L);

        assertTrue(actual);

    }

    @Test
    void updateRangeToSensorByIdTest() {

        boolean actual = sensorRepository.updateRangeToSensorById(20, 1L);

        assertTrue(actual);

    }

    @Test
    void updateTypeSensorByIdTest() {

        boolean actual = sensorRepository.updateTypeSensorById("Voltage", 1L);

        assertTrue(actual);

    }

    @Test
    void updateUnitSensorByIdTest() {

        boolean actual = sensorRepository.updateUnitSensorById("voltage", 1L);

        assertTrue(actual);

    }

    @Test
    void updateLocationSensorByIdTest() {

        boolean actual = sensorRepository.updateLocationSensorById("update_loc", 1L);

        assertTrue(actual);

    }

    @Test
    void updateDescriptionSensorByIdTest() {

        boolean actual = sensorRepository.updateDescriptionSensorById("update_description", 1L);

        assertTrue(actual);

    }

    @Test
    void deleteSensorByIdTest() {

        int expectedSize = sensorRepository.findAllSensor().size();

        boolean actualOne = sensorRepository.deleteSensorById(1L);
        boolean actualTwo = sensorRepository.deleteSensorById(3L);
        boolean actualThree = sensorRepository.deleteSensorById(5L);

        boolean actualSize = sensorRepository.findAllSensor().size() < expectedSize;

        boolean[] actualTrue = new boolean[2];

        List<Sensor> actual = sensorRepository.findAllSensor();

        for (int i = 0; i < actual.size(); i++) {
            if (!actual.get(i).getTitle().equals("test1")
                    || !actual.get(i).getTitle().equals("test3")
                    || !actual.get(i).getTitle().equals("test5")) {

                actualTrue[i] = true;
            }
        }

        assertTrue(actualOne);
        assertTrue(actualTwo);
        assertTrue(actualThree);
        assertTrue(actualSize);
        assertTrue(actualTrue[0]);
        assertTrue(actualTrue[1]);

    }

}