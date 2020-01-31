package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;


@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.error(dataSource.toString());
        //HikariDataSource (null)
        Connection connection = dataSource.getConnection();
        log.error(connection.toString());
        //HikariProxyConnection@1007402143 wrapping conn0: url=jdbc:h2:mem:testdb user=SA
        connection.close();
    }

}
