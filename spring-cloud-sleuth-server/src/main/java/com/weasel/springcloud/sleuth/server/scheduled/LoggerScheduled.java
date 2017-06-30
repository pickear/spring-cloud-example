package com.weasel.springcloud.sleuth.server.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author dylan
 * @time 2017/6/30
 */
public class LoggerScheduled {

    private final static Logger logger = LoggerFactory.getLogger(LoggerScheduled.class);

    @Scheduled(fixedRate = 1000*60)
    public void log(){
        try {
            Thread.sleep(4000);
            logger.info("[service] scheduled log......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
