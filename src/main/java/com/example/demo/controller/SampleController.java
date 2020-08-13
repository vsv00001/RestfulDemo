package com.example.demo.controller;

import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	/*
	 * @Autowired JobItemRepository repo;
	 */
	
	
	@GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
	
	@GetMapping("/hi")
    public String sayHi() {
        return "Hi World!";
    }
	
	@GetMapping("/threads") 
	public String spawnThreads() {
		Runnable task = () -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		};
		
		for(int i=0;i<1000;i++) {
			Thread thread = new Thread(task);
			thread.start();
		}
		return "thread spawning completed";
	}
	
	@GetMapping("/memory") 
	public String allocateMemory() {
		Vector v = new Vector();
	    for(int i=0;i<100;i++) {
	      byte b[] = new byte[1048576];
	      v.add(b);
	      Runtime rt = Runtime.getRuntime();
	      System.out.println( "free memory: " + rt.freeMemory() );
	    }
	    return "allocated 100MB memory";
	}
/*	
	@GetMapping("/getpaginginfo")
	public List<JobItem> getPageList() {
		List<JobItem> jobItemList =  repo.findActiveJobItemList("job1");
		if(jobItemList != null && !jobItemList.isEmpty()) {
			for(JobItem jItem : jobItemList) {
				System.out.println(jItem.getMac()+ "  "+jItem.getDeviceType()+ "  " + jItem.getLastUpdate()); 
			}
		}
		
		return jobItemList;
	}
	
	@GetMapping("/updateJobItem")
	public List<JobItem> updateJobItem() {
		Random rand = new Random();
		
		String mac = "mac"+rand.nextInt(7);
		List<JobItem> jobItemList = repo.findBy_id("5e0665fa8245a9362c6ec763");
		
		jobItemList.stream().forEach(item -> {
			item.setLastUpdate(new Date());
			repo.save(item);
		});
		return jobItemList; 
	} */
}
