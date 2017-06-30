package com.weasel.springcloud.sleuth.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.NeverSampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SleuthClientBootstraps {

	public static void main(String[] args) {
		SpringApplication.run(SleuthClientBootstraps.class, args);
	}

	/*@Bean
	public Sampler sampler(){
		return  new NeverSampler();
	}*/
}
