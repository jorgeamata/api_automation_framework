package com.projectName.basicTestScripts;

import static io.restassured.RestAssured.given;


public class Test004_POSTRequest {
	
String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
	
	/**
	 * Send POST request
	 */
	//@Test
	public void sendPOSTRequest() {
		given()
			.headers("AppKey", "Key-value")
			.param("name", "test1")
			.param("lastName", "test2")
			.param("email", "test3")
		.when()
			.post("API")
		.then()
			.statusCode(200);
	}

}
