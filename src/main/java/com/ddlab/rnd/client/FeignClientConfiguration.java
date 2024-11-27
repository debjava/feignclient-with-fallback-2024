package com.ddlab.rnd.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ddlab.rnd.exception.CustomErrorDecoder;

import feign.Feign;

@Configuration
public class FeignClientConfiguration {

    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder()
                .errorDecoder(new CustomErrorDecoder());
                // Other Feign configurations can be chained here if needed
    }
}