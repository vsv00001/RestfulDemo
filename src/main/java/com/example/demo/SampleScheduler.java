package com.example.demo;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableScheduling
@EnableAsync
public class SampleScheduler implements AsyncConfigurer {
	
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();
		exec.setCorePoolSize(4);
		return exec;
	} 

	@Autowired
	AsyncSample asyncSample;
	
	/*
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar)
    {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

        threadPoolTaskScheduler.setPoolSize(32);
        threadPoolTaskScheduler.setThreadNamePrefix("scheduled-task-pool-");
        threadPoolTaskScheduler.initialize();

        taskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
    }
    */
	
	
	
	@Scheduled(fixedRate = 100)
	public void methodA() {
		System.out.println("Inside Method A "+Thread.currentThread().getName());
		asyncSample.methodABC();
		System.out.println("Leaving Method A "+Thread.currentThread().getName());
		
	}
	
	

	
//	@Scheduled(fixedRate=100)
	public void anotherTask() {
		System.out.println("Inside anotherTask "+Thread.currentThread().getName());
	    try {
	    	Thread.sleep(50000);
	    }
	    catch(Exception ex) {
	    	ex.printStackTrace();
	    }
	    
	    System.out.println("exiting anotherTask"+Thread.currentThread().getName());
	}
	
	
	
}
