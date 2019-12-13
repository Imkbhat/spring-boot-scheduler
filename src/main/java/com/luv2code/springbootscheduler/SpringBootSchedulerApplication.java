package com.luv2code.springbootscheduler;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class SpringBootSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSchedulerApplication.class, args);
	}
	
	@Scheduled(fixedRate = 2000l) //runs after every 2 seconds
	public void firstJob() throws InterruptedException {
		//System.out.println("Current Date First Job: "+ new Date());
		Thread.sleep(1000l);
	}
	
	@Scheduled(initialDelay= 1000l, fixedDelay = 2000l)
	public void secondJob() throws InterruptedException {
		//System.out.println("Current Date Second Job: "+new Date());
		Thread.sleep(1000l);
	}
	
	@Scheduled(initialDelay= 1000l, fixedDelayString = "PT1M") //PT1H -> 1Hour, PT10M -> 10 Minutes, PT10S -> 10 seconds
	public void thirdJob() throws InterruptedException {
		//System.out.println("Current Date Third Job: "+new Date());
		Thread.sleep(1000l);
	}
	
	//fixedDelayString -> we can use @SpringExpression, we can read from property file by making it as Expression
	//In fixed delay String we can use (* * * * * *)
	//Schedule Pattern : Seconds Minutes Hours Day-of-Month Month Day-of-Week Year (optional field)
	//Month can set like JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV and DEC.
	//Day-of-Week can set like SUN, MON, TUE, WED, THU, FRI and SAT
	
	@Scheduled(initialDelay= 1000l, fixedDelayString = "${delay.time}")
	public void fourthJob() throws InterruptedException {
		System.out.println("Current Date Third Job: "+new Date());
		Thread.sleep(1000l);
	}

}
