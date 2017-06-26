package com.weasel.springcloud.sleuth.server.controller;

import com.weasel.springcloud.sleuth.server.helper.ExecutorServiceHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dylan
 * @time 2017/6/26
 */
@RestController
public class HelloController {

    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);
    private final static ExecutorService executorService = Executors.newCachedThreadPool();
    private final static ExecutorService wrapExecutorService = ExecutorServiceHelper.wrapExecutorService(Executors.newCachedThreadPool());

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        logger.info("[server] reponse client hello...");
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                logger.info("[server]execut in thread pool...");
            }
        });

        wrapExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                logger.info("[server]wrap execut in thread pool...");
            }
        });
        return "hello";
    }
}
