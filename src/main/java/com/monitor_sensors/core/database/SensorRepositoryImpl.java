package com.monitor_sensors.core.database;

import com.monitor_sensors.core.domain.Sensor;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Component
@Transactional
public class SensorRepositoryImpl implements SensorRepository {

    @Autowired private SessionFactory sessionFactory;

    @Override
    public void saveSensor(Sensor sensor) {

        Query query = sessionFactory.getCurrentSession()
                .createSQLQuery("INSERT INTO SENSORS (title, model, range_from, range_to, type, unit, location, description) " +
                        "VALUES (:title, :model, :rangeFrom, :rangeTo, :type, :unit, :location, :description); ");

        query.setParameter("title", sensor.getTitle());
        query.setParameter("model", sensor.getModel());
        query.setParameter("rangeFrom", sensor.getRangeFrom());
        query.setParameter("rangeTo", sensor.getRangeTo());
        query.setParameter("type", sensor.getType());
        query.setParameter("unit", sensor.getUnit());
        query.setParameter("location", sensor.getLocation());
        query.setParameter("description", sensor.getDescription());

        query.executeUpdate();

    }

    @Override
    public ArrayList<Sensor> findAllSensor() {

        Query query = sessionFactory.getCurrentSession()
                .createSQLQuery("SELECT id, title, model FROM SENSORS");

        return (ArrayList<Sensor>) query.getResultList();
    }

    @Override
    public ArrayList<Sensor> findAllSensorByParam(String[] param) {

        Query query = sessionFactory.getCurrentSession()
                .createSQLQuery("SELECT * FROM SENSORS WHERE " +
                        "title = :title OR " +
                        "model = :model OR " +
                        "range_from = :range_from OR " +
                        "range_to = :range_to OR " +
                        "type = :type OR " +
                        "unit = :unit OR " +
                        "location = :location OR " +
                        "description = :description");

        query.setParameter("title", param[0]);
        query.setParameter("model", param[1]);
        query.setParameter("range_from", param[2]);
        query.setParameter("range_to", param[3]);
        query.setParameter("type", param[4]);
        query.setParameter("unit", param[5]);
        query.setParameter("location", param[6]);
        query.setParameter("description", param[7]);

        return (ArrayList<Sensor>) query.getResultList();
    }

    @Override
    public ArrayList<Sensor> findAllSensorByTitle(String title) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT s FROM Sensor s WHERE title = :title", Sensor.class);

        query.setParameter("title", title);

        return (ArrayList<Sensor>) query.getResultList();
    }

    @Override
    public ArrayList<Sensor> findAllSensorByModel(String model) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT s FROM Sensor s WHERE model = :model", Sensor.class);

        query.setParameter("model", model);

        return (ArrayList<Sensor>) query.getResultList();
    }

    @Override
    public boolean updateTitleSensorById(String updateTitle, Long idSensor) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Sensor SET title = :updateTitle WHERE id = :idSensor")
                .setParameter("updateTitle", updateTitle)
                .setParameter("idSensor", idSensor);

        return query.executeUpdate() == 1;
    }

    @Override
    public boolean updateModelSensorById(String updateModel, Long idSensor) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Sensor SET model = :updateModel WHERE id = :idSensor")
                .setParameter("updateModel", updateModel)
                .setParameter("idSensor", idSensor);

        return query.executeUpdate() == 1;
    }

    @Override
    public boolean updateRangeFromSensorById(int updateRangeFrom, Long idSensor) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Sensor SET rangeFrom = :updateRangeFrom WHERE id = :idSensor")
                .setParameter("updateRangeFrom", updateRangeFrom)
                .setParameter("idSensor", idSensor);

        return query.executeUpdate() == 1;
    }

    @Override
    public boolean updateRangeToSensorById(int updateRangeTo, Long idSensor) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Sensor SET rangeTo = :updateRangeTo WHERE id = :idSensor")
                .setParameter("updateRangeTo", updateRangeTo)
                .setParameter("idSensor", idSensor);

        return query.executeUpdate() == 1;
    }

    @Override
    public boolean updateTypeSensorById(String updateType, Long idSensor) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Sensor SET type = :updateType WHERE id = :idSensor")
                .setParameter("updateType", updateType)
                .setParameter("idSensor", idSensor);

        return query.executeUpdate() == 1;
    }

    @Override
    public boolean updateUnitSensorById(String updateUnit, Long idSensor) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Sensor SET unit = :updateUnit WHERE id = :idSensor")
                .setParameter("updateUnit", updateUnit)
                .setParameter("idSensor", idSensor);

        return query.executeUpdate() == 1;
    }

    @Override
    public boolean updateLocationSensorById(String updateLocation, Long idSensor) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Sensor SET location = :updateLocation WHERE id = :idSensor")
                .setParameter("updateLocation", updateLocation)
                .setParameter("idSensor", idSensor);

        return query.executeUpdate() == 1;
    }

    @Override
    public boolean updateDescriptionSensorById(String updateDescription, Long idSensor) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Sensor SET description = :updateDescription WHERE id = :idSensor")
                .setParameter("updateDescription", updateDescription)
                .setParameter("idSensor", idSensor);

        return query.executeUpdate() == 1;
    }

    @Override
    public boolean deleteSensorById(Long idSensor) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("DELETE Sensor WHERE id = :idSensor");
        query.setParameter("idSensor", idSensor);

        return query.executeUpdate() == 1;
    }

}
