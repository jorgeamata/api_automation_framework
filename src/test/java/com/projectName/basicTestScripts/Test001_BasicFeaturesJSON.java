package com.projectName.basicTestScripts;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;




public class Test001_BasicFeaturesJSON {
	
	String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
	
	/**
	 * Validate status code
	 */
	//@Test
	public void validateStatusCode() {
		given().get(this.url)
		.then()
		.statusCode(200);
	}
	
	/**
	 * Validate status code and print complete response in console
	 */
	//@Test
	public void printResponse() {
		given().get(this.url)
		.then()
		.statusCode(200)
		.log().all();
	}
	
	/**
	 * Validate some property of the response is equal to some value
	 */
	@Test
	public void validatePropertyValue() {
		given().get(this.url)
		.then()
		.body("photos.id", equalTo("102693"));
	}
	
	/**
	 * Validate multiple content using org.hamcrest.Matchers library
	 */
	//@Test
	public void validateIfResponseHasSomeItems(String property) {
		given().get(this.url)
		.then()
		.body(property, hasItems("Test1", "Test2", "Test3"));
	}
	
	/**
	 * Validate parameters and Headers
	 */
	//@Test
	public void validateParametersAndHeaders() {
		given()
			.param("key1", "value1")
			.header("headA", "valueA")
		.when()
			.get(this.url)
		.then()
			.statusCode(200)
			.log().all();
	}
	
	/**
	 * using 'and' to increase readsibility
	 * generraly used when writing in one line xpath style
	 */
	//@Test
	public void validateAndAnnotation() {
		given().param("key1", "value1").and().header("key2", "value2").when().get(this.url).then().statusCode(200);
	}
	
	

	
	
}
