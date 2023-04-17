package com.example.mobitech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MobitechApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobitechApplication.class, args);
    }

}
