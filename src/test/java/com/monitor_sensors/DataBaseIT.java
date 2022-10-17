package com.monitor_sensors;

import com.monitor_sensors.config.SpringCoreConfiguration;

import org.springframework.beans.factory.annotation.*;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;

import java.io.*;

import java.util.*;

@Component
@SpringBootTest(classes = SpringCoreConfiguration.class)
public abstract class DataBaseIT {

    @Value("${sql.script.file.path}")
    private String filePath;

    @Autowired private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void cleanTables() {

        for(String tableName : getTableNames()) jdbcTemplate.execute("TRUNCATE TABLE " + tableName + " RESTART IDENTITY");

    }

    private List<String> getTableNames() {

        List<String> tableNames = new ArrayList<>();

        tableNames.add("SENSORS");
        tableNames.add("USERS");

        return tableNames;
    }

    public void fillTables() {

        List<String> sqlQueries = getSqlQueries(filePath);

        for(String sql : setSqlQueries(sqlQueries)) jdbcTemplate.update(sql);

    }


    private List<String> getSqlQueries(String filePath) {

        List<String> sqlQueries = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String script;

            while ((script = br.readLine()) != null) {

                sqlQueries.add(script);

            }


        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

        return sqlQueries;
    }

    private List<String> setSqlQueries(List<String> sqlQueries) {

        List<String> adaptedSqlQueries = new ArrayList<>();

        StringBuilder adaptedSqlString = new StringBuilder();

        for(String sqlString : sqlQueries) {

            if(sqlString.length() > 0) {

                adaptedSqlString.append(" ").append(sqlString);

            } else {

                adaptedSqlQueries.add(adaptedSqlString.toString());
                adaptedSqlString = new StringBuilder();

            }
        }

        adaptedSqlQueries.add(adaptedSqlString.toString());

        return adaptedSqlQueries;
    }

}
