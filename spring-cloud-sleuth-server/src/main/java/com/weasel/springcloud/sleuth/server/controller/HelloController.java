package com.weasel.springcloud.sleuth.server.controller;

import com.weasel.springcloud.sleuth.server.SleuthServerBootstraps;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.SpanNamer;
import org.springframework.cloud.sleuth.TraceRunnable;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.instrument.async.LazyTraceExecutor;
import org.springframework.scheduling.annotation.Async;
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

    @Autowired
    private SleuthServerBootstraps.AsyncClass asyncClass;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)

    public String hello(){
        logger.info("[server] reponse client hello...");
        asyncClass.asyncWarn();

        new Thread(new TraceRunnable(tracer,spanNamer,()->{
            logger.info("[server]execut in thread pool...");
        })).start();

        Executor executor = new LazyTraceExecutor(beanFactory, executorService);
        executor.execute(() -> {
            logger.info("[server]execut in lazyTraceExecutor...");
        });
        return "hello";
    }




}
