package com.weasel.springcloud.sleuth.stream.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dylan
 * @time 2017/6/26
 */
@RestController
public class HelloController {

    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        logger.info("[server] reponse client hello...");
        return "hello";
    }
}
