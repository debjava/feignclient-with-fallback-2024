package com.ddlab.rnd.client;

import org.springframework.context.annotation.Bean;

import com.ddlab.rnd.exception.CustomErrorDecoder;

import feign.codec.ErrorDecoder;

public class MyFeignClientConfiguration {

	@Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}
