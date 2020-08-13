package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class RestfulDemoApplication implements CommandLineRunner {

	/*
	 * @Autowired JobItemRepository repo;
	 */
	
	
	public static void main(String[] args) {
		SpringApplication.run(RestfulDemoApplication.class, args);
	}
	
	@Override
    public void run(String...args) throws Exception {
		System.out.println("abcdefg".substring("abc".length()).toLowerCase());
		/*
		 * JobItem jItem1 = new JobItem("job1","mac1","EST","type1");
		 * jItem1.setLastUpdate(new Date());
		 * 
		 * repo.save(jItem1);
		 * 
		 * JobItem jItem2 = new JobItem("job2","mac2","EST","type2");
		 * jItem2.setLastUpdate(new Date());
		 * 
		 * repo.save(jItem2);
		 * 
		 * JobItem jItem3 = new JobItem("job3","mac1","EST","type3");
		 * jItem3.setLastUpdate(new Date());
		 * 
		 * repo.save(jItem3);
		 * 
		 * JobItem jItem4 = new JobItem("job4","mac1","EST","type4");
		 * jItem4.setLastUpdate(new Date());
		 * 
		 * repo.save(jItem4);
		 * 
		 * JobItem jItem5 = new JobItem("job5","mac1","EST","type5");
		 * jItem5.setLastUpdate(new Date());
		 * 
		 * repo.save(jItem5);
		 * 
		 * JobItem jItem6 = new JobItem("job6","mac1","EST","type6");
		 * jItem6.setLastUpdate(new Date());
		 * 
		 * repo.save(jItem6);
		 * 
		 * JobItem jItem7 = new JobItem("job7","mac1","EST","type7");
		 * jItem7.setLastUpdate(new Date());
		 * 
		 * repo.save(jItem7);
		 */		 
		
    }
	
	

}
