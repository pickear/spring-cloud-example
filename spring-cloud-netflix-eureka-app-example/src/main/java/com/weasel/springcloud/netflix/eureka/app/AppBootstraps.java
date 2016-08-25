package com.weasel.springcloud.netflix.eureka.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author Dylan
 * @date 2016/8/1.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
public class AppBootstraps {

    public static void main(String[] args) {
        SpringApplication.run(AppBootstraps.class,args);
    }
}
