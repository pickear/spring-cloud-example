package com.weasel.springcloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Dylan
 * @date 2016/7/27.
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigServerBootstraps {


    public static void main(String[] args) {
        SpringApplication.run(ConfigServerBootstraps.class,args);
    }
}
