package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncSample {

	
	@Async
	public void methodABC()
	{
	    System.out.println("Inside Mehtod ABC " +Thread.currentThread().getName());
	    try {
	    	Thread.sleep(50000);
	    }
	    catch(Exception ex) {
	    	ex.printStackTrace();
	    }
	    System.out.println("Inside Mehtod ABC "+Thread.currentThread().getName());
	}
}
