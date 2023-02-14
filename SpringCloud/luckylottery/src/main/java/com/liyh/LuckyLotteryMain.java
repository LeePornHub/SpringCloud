package com.liyh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.liyh.dao")
@SpringBootApplication
@EnableEurekaClient
public class LuckyLotteryMain {
    public static void main(String[] args) {
        SpringApplication.run(LuckyLotteryMain.class, args);
    }
}