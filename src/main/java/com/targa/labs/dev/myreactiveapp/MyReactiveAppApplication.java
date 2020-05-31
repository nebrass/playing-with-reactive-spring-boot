package com.targa.labs.dev.myreactiveapp;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyReactiveAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyReactiveAppApplication.class, args);
    }
}
