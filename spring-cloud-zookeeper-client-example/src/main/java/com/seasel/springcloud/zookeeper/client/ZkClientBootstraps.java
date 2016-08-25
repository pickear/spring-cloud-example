package com.seasel.springcloud.zookeeper.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * @author Dylan
 * @date 2016/7/21.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkClientBootstraps {

    private final static Logger log = LoggerFactory.getLogger(ZkClientBootstraps.class);

    public static void main(String[] args) throws InterruptedException {

        ConfigurableApplicationContext cac = SpringApplication.run(ZkClientBootstraps.class, args);
        while (true){
            List<String> services = cac.getBean(DiscoveryClient.class).getServices();
            ServiceInstance si = cac.getBean(LoadBalancerClient.class).choose("spring-cloud-zookeeper-service");
            if(null != si){
                log.info("services:[{}],host:[{}],port:[{}],url:[{}],id:[{}],metadata:[{}]", services,si.getHost(),si.getPort(),si.getUri(),si.getServiceId(),si.getMetadata());
            }
            Thread.sleep(2000);
        }

    }
}
