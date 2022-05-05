package com.projectName.basicTestScripts;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.io.InputStream;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test005_ReadResponse {
	
	String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
	
	/**
	 * To get all response as String
	 */
	//@Test
	public void getResponseAsString() {
		
		String responseAsString = get(this.url).asPrettyString();
		System.out.println(responseAsString);
	}
	
	/**
	 * To get all response as InputStream
	 * @throws IOException
	 */
	//@Test
	public void getResponseAsInputStream() throws IOException {
		
		InputStream inputStream = get(this.url).asInputStream();
		System.out.println("Stream lenght:" + inputStream.toString().length());
		inputStream.close();
	}
	
	/**
	 * To get all response as ByteArray
	 */
	//@Test
	public void getResponseAsByteArray() {
		
		byte[] byteArray = get(this.url).asByteArray();
		System.out.println(byteArray.length);
	}
	
	/**
	 * To get all response as ByteArray
	 */
	//@Test
	public void testExtractDetailsUsingPath() {
		
		String href = 
			when()
				.get(url)
			.then()
				.contentType(ContentType.JSON)
				.body("id", equalTo(1))
			.extract()
				.path("url");
		
		System.out.println(href);
		
		when().get(href).then().statusCode(200);
				
		
	}
	
	/**
	 * Extract Details using path in one line
	 */
	//@Test
	public void testExtractPathInOneLine() {
		//type 1
		String href1 = get(url).path("thumbnailUrl");
		System.out.println("Fetched URL 1: " + href1);
		when().get(href1).then().statusCode(200);
		
		//type 2
		String href2 = get(url).andReturn().jsonPath().getString("thumbnailUrl");
		System.out.println("Fetched URL 2: " + href2);
		when().get(href2).then().statusCode(200);	
	}
	
	/**
	 * Extract Details as Response for further use
	 */
	//@Test
	public void testExtractDetailsUsingResponse() {
		Response response = 
		when()
			.get(url)
		.then()
		.extract()
			.response();
		
		System.out.println("Content Type: " + response.contentType());
		System.out.println("Href: " + response.path("url"));
		System.out.println("Status code: " + response.statusCode());
	}
	
	
	
	
	
	

}
