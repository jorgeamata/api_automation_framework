package com.projectName.basicTestScripts;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class Test010_SetRequestData {
	
String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
	
	//This class is to set different type of data in a request call

	/**
	 * Validate status code
	 */
	/*
	 * //@Test public void testConnectRequest() { when() .request("CONNECT",
	 * "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY)"
	 * .then() .statusCode(400); }
	 * 
	 */	/**
	 * In GET request we can set query parameter
	 */
	//@Test
	public void testQueryParameters() {
		given()
			.queryParam("A", "A Value")
			.queryParam("B", "B Value")
		.when()
			.get(url)
		.then()
			.statusCode(400);
	}
	
	/**
	 * In POST request we can set form parameter
	 */
	//@Test
	public void testFormParameters() {
		given()
			.formParam("A", "A Value")
			.formParam("B", "B Value")
		.when()
			.post(url)
		.then()
			.statusCode(400);
	}
	
	/**
	 * To set parameters - recommneded way
	 * If request is GET then param will be treated as QueryParameter
	 * If request is POST then param will be treated as FormParameter
	 */
	//@Test
	public void testSetParameters() {
		given()
			.param("A", "A Value")
			.param("B", "B Value")
		.when()
			.post(url)
		.then()
			.statusCode(400);
	}
	
	/**
	 * To set parameters - recommneded way
	 * If request is GET then param will be treated as QueryParameter
	 * If request is POST then param will be treated as FormParameter
	 */
	//@Test
	public void testSetMultipleValueParameters() {
		
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		
		given()
			.param("A", "Value1", "Value2", "Value3")
			.param("B")
			.param("C", list)
		.when()
			.get(url)
		.then()
			.statusCode(400);
	}
	
	/**
	 * Set different type of data in a request call
	 
	 */
	//@Test
	public void testSetParameters2() {
		
		
		given()
			.pathParam("type", "json")
			.pathParam("section", "Domains")
		.when()
			.post("https://api.nasa.gov/rest/{type}/{section}")
		.then()
			.statusCode(400);
	}
	
	/**
	 * Cookies can be set in request param
	 
	 */
	//@Test
	public void testSetCookiesInRequest() {
		
		
		//to set a single value
		given()
			.cookie("__utmt", 1)
		.when()
			.get("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY")
		.then()
			.statusCode(200);
	}
	
	/**
	 * Multiple cookies can be set in request param
	 * toDo: test example not runnable code
	 */
	//@Test
	public void testSetMultipleCookiesInRequest() {
		
		
		//to set multiple values
		given()
			.cookie("key", "val1", "val2"); //this will create tow cookies key = val1, key = val2
		
		
		//to set detailed cookie
		Cookie someCookie1 = new Cookie.Builder("some_cookie", "some_value").setSecured(true).setComment("some comment").build();
		Cookie someCookie2 = new Cookie.Builder("some_cookie", "some_value").setSecured(true).setComment("some comment").build();
		Cookies cookies = new Cookies(someCookie1, someCookie2);
		
		given().cookies(cookies).when().get("/cookie").then().assertThat().body(equalTo("x"));
		
		
	}
	
	
	/**
	 * We can pass a single header, headers with multiple values and multiple headers
	 
	 */
	//@Test
	public void testSetHeaders() {
		
		
		
		given()
			.header("k", "v")
			.header("k10", "val1", "val2", "val3")
			.headers("k1", "v1", "k2", "v2")
		.when()
			.get("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY")
		.then()
			.statusCode(400);
		
	}
	
	/**
	 * Content type can also be set
	 
	 */
	//@Test
	public void testSetContentType() {
		
		
		
		given()
			.contentType(ContentType.JSON)
			.contentType("application/json; charset=utf-8")
		.when()
			.get("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY")
		.then()
			.statusCode(400);
		
	}
	
	
	
	
	
	
	
	
	

}
