package com.weasel.springcloud.sleuth.server;

import com.weasel.springcloud.sleuth.server.aspect.LoggerAspect;
import com.weasel.springcloud.sleuth.server.scheduled.LoggerScheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.NeverSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableAspectJAutoProxy
@EnableScheduling
@SpringBootApplication
public class SleuthServerBootstraps {

	private final static Logger logger = LoggerFactory.getLogger(SleuthServerBootstraps.class);

	public static void main(String[] args) {
		SpringApplication.run(SleuthServerBootstraps.class, args);
	}

	@Bean
	public AsyncClass asyncClass(){
		return new AsyncClass();
	}

	@Bean
	public LoggerAspect loggerAspect(){
		return new LoggerAspect();
	}

	@Bean
	public LoggerScheduled loggerScheduled(){
		return new LoggerScheduled();
	}

	public static class AsyncClass{
		@Async
		public void asyncWarn(){
			try {
				Thread.sleep(5000);
				logger.warn("[server] warn log...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
