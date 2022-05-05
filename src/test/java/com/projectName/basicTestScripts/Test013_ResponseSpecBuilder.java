package com.projectName.basicTestScripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class Test013_ResponseSpecBuilder {
	
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void expectedValues() {
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectStatusCode(200);
		builder.expectHeader("Content-Type", "application/json; charset=UTF-8");
		builder.expectHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
		responseSpec = builder.build();
	}
	
	/*
	 * @Test public void testResponse1() { when() .get("api") .then()
	 * .spec(responseSpec) .time(lessThan(4000L)); }
	 * 
	 * @Test public void testResponse2() { when() .get("api") .then()
	 * .spec(responseSpec);
	 * 
	 * }
	 */
	

}
