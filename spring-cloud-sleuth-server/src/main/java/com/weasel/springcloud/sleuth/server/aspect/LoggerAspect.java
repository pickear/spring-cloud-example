package com.weasel.springcloud.sleuth.server.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dylan
 * @time 2017/6/30
 */
@Aspect
public class LoggerAspect {

    private final static Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Before("execution(* com.weasel.springcloud.sleuth.server.controller.HelloController.hello())")
    public void before(){
        logger.info("[server] aspect before......");
    }
}
