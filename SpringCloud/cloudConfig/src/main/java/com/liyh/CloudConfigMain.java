package com.liyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudConfigMain {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigMain.class, args);
    }
}