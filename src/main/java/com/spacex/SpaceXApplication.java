package com.spacex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpaceXApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpaceXApplication.class, args);
    }

}
