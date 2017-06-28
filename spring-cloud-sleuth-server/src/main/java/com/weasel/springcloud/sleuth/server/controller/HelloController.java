package com.weasel.springcloud.sleuth.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.SpanNamer;
import org.springframework.cloud.sleuth.TraceRunnable;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.instrument.async.LazyTraceExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;
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
    @Autowired
    private Tracer tracer;
    @Autowired
    private SpanNamer spanNamer;
    @Autowired
    private BeanFactory beanFactory;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        logger.info("[server] reponse client hello...");
        executorService.submit(new TraceRunnable(tracer,spanNamer,new Runnable(){
            @Override
            public void run() {
                logger.info("[server]execut in thread pool...");
            }
        }));

        Executor executor = new LazyTraceExecutor(beanFactory, executorService);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                logger.info("[server]execut in lazyTraceExecutor...");
            }
        });
        return "hello";
    }
}
