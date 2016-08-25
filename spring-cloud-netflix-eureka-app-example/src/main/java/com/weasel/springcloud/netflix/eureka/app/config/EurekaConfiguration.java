package com.weasel.springcloud.netflix.eureka.app.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dylan
 * @date 2016/8/1.
 */
@Configuration
public class EurekaConfiguration {


    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
