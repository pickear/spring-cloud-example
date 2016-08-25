package com.weasel.springcloud.netflix.eureka.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Dylan
 * @date 2016/8/1.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaServiceBootstraps {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceBootstraps.class,args);
    }
}
