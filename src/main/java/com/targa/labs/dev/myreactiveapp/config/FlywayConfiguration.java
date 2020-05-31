package com.targa.labs.dev.myreactiveapp.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class FlywayConfiguration implements CommandLineRunner {

    @Value("${spring.r2dbc.url}")
    private String url;
    @Value("${spring.r2dbc.username}")
    private String username;
    @Value("${spring.r2dbc.password}")
    private String password;

    @Override
    public void run(String... args) {
        Flyway.configure()
                .dataSource(url, username, password)
                .load()
                .migrate();
    }
}
