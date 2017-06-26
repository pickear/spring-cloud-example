package com.weasel.springcloud.sleuth.zipkin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class SleuthZipkinServerBootstraps {

	public static void main(String[] args) {
		SpringApplication.run(SleuthZipkinServerBootstraps.class, args);
	}
}
