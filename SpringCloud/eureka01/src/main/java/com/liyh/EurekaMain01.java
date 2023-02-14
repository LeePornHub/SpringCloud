package com.liyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaMain01 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain01.class, args);
    }
}