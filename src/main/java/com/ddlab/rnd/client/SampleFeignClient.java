package com.ddlab.rnd.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SomeFeignClientName", url = "http://localhost:8080", fallback = FeignClientFallBack.class /*fallbackFactory =  SampleFallbackFactory.class*/)
public interface SampleFeignClient {

	@GetMapping("/v1/emp/{id}")
	String getEmpById(@PathVariable("id") int id);
}
