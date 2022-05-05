package com.projectName.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.taskdefs.Filter;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Base {
	
	private static final String BASE_URL = "https://restful-booker.herokuapp.com";
	
	
	@BeforeClass
	public static void setup() {
		RestAssured.requestSpecification = defaultRequestSpecification();
	}
	
	private static RequestSpecification defaultRequestSpecification() {
		
		return new RequestSpecBuilder()
				.setBaseUri(BASE_URL)
				//.setBasePath("/api")
				.setContentType(ContentType.JSON)
				.addFilter(new ResponseLoggingFilter())
				.addFilter(new RequestLoggingFilter())
				.addFilter(new ErrorLoggingFilter())
				.build();
	}

}
