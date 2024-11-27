package com.ddlab.rnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ddlab.rnd.client.AnotherSampleFeignClient;
import com.ddlab.rnd.client.SampleFeignClient;

@Component
public class AutoRun {
	
	@Autowired
	private SampleFeignClient client;
	
	@Autowired
	private AnotherSampleFeignClient anotherClient;
	
	private void getEmpDetails() {
		String response = client.getEmpById(124);
		System.out.println("Feign Client Response: "+response);
	}
	
	private void getMoreEmpDetails() {
		String response = anotherClient.getMoreEmpById(124);
		System.out.println("Another Feign Client Response: "+response);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void run() {
		System.out.println("App started running ...");
//		getEmpDetails();
//		getMoreEmpDetails();
	}

}
