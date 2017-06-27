package com.weasel.springcloud.sleuth.stream.client.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author dylan
 * @time 2017/6/26
 */
@Configuration
public class ClientConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
