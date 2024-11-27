package com.ddlab.rnd.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AnotherFeignClientName", url = "http://localhost:8080", configuration = MyFeignClientConfiguration.class)
public interface AnotherSampleFeignClient {

	// This method is used when external service is throwing exception
	@GetMapping("/v1/emp/{id}")
	String getMoreEmpById(@PathVariable("id") int id);
}
