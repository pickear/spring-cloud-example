package com.weasel.springcloud.sleuth.stream.zipkin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@SpringBootApplication
@EnableZipkinStreamServer
public class SleuthStreamZipkinServerBootstraps {

	public static void main(String[] args) {
		SpringApplication.run(SleuthStreamZipkinServerBootstraps.class, args);
	}
}
