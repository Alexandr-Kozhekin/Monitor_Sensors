package com.monitor_sensors.application;


import com.monitor_sensors.config.SpringCoreConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class MonitorSensorsApplication {

    public static void main (String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringCoreConfiguration.class);

    }
}
