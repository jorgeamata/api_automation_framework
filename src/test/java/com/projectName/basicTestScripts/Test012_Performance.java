package com.projectName.basicTestScripts;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

public class Test012_Performance {
	
	/**
	 * Response time
	 * Please note time includes HTTP round trip + rest assured processing time
	 
	 */
	//@Test
	public void testResponseTime() {
		
		long t = given().get("api").time();
		System.out.println(t);
	}
	
	/**
	 * Response time with time unit
	 * 
	 
	 */
	//@Test
	public void testResponseTime2() {
		
		long t = given().get("api").timeIn(TimeUnit.MILLISECONDS);
		System.out.println(t);
	}
	
	/**
	 * Response time with assertion
	 * 
	 
	 */
	/*
	 * //@Test public void testResponseTime3() {
	 * 
	 * long t = given().get("api").then().time(lessThan(500L));
	 * System.out.println(t); }
	 */

}
