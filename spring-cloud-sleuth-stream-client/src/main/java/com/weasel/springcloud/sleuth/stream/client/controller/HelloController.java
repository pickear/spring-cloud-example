package com.weasel.springcloud.sleuth.stream.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author dylan
 * @time 2017/6/26
 */
@RestController
public class HelloController {

    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Value("${app.url:http://localhost:${local.server.port:8094}/spring-cloud-sleuth-stream-server/hello}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        logger.info("[client] call server hello url[{}]...",url);
        String result = restTemplate.getForObject(url,String.class);
        return result;
    }
}
