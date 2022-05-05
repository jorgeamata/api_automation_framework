package com.projectName.basicTestScripts;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;

import io.restassured.http.ContentType;


public class Test006_SchemaCheck {
	
	String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
	
	
	/**
	 * Validate response type
	 */
	//@Test
	public void validateContentType() {
		given().get(this.url)
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON);
	}
	
	/**
	 * This test will validate the response schema with predefined existing schema
	 * path: src/test/resources/geo-schema.json
	 
	//@Test
	public void validateResponseSchema() {
		given().get(this.url)
		.then()
		.assertThat().body(matchesJsonSchemaInClassPath("test3_geo_schema123.json");
	}
	*/
	

}
