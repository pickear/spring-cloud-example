package com.weasel.springcloud.sleuth.client.zookeeper.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author Dylan
 * @date 2016/7/21.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ZkServerBootstraps {

    public static void main(String[] args) {
        SpringApplication.run(ZkServerBootstraps.class, args);
    }
}
