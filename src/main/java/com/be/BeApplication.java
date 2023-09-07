package com.be;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.be.repository")
@EntityScan("com.be.model")
public class BeApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeApplication.class, args);
    }

}
