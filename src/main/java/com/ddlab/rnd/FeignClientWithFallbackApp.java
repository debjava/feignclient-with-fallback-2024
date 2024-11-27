package com.ddlab.rnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignClientWithFallbackApp {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientWithFallbackApp.class, args);

	}

}
