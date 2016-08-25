package com.weasel.springcloud.neflix.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Dylan
 * @date 2016/7/29.
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerBootstraps {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerBootstraps.class,args);
    }
}
