package com.industrial.healthmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthManagerApplication.class, args);
        System.out.println("🚀 Industrial Health Manager iniciado com sucesso!");
    }
}