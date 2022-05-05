package com.projectName.basicTestScripts;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matcher;

import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class Test011_VerifyResponse {

	/**
	 * Status code verification
	 * 
	 */
	/*
	 * //@Test public void testStatusInResponse() {
	 * 
	 * given().get("API").then().assertThat().statusCode(200).log().all();
	 * given().get("API").then().assertThat().statusLine("HTTP/1.1 200 OK");
	 * given().get("API").then().assertThat().statusLine(containsString("OK")); }
	 * 
	 *//**
		 * Headers verification
		 * 
		 *//*
			 * //@Test public void testHeadersInResponse() {
			 * 
			 * given().get("API").then().assertThat().header("X-Powered-By", "Express");
			 * given().get("API").then().assertThat().headers("Vary", "Accept-Encoding",
			 * "Content-Type", containsString("json"));; }
			 */
	/**
	 * Content type verification
	 * 
	 */
	// @Test
	public void testContentTypeInResponse() {

		given().get("API").then().assertThat().contentType(ContentType.JSON);

	}

	/**
	 * Body text verification
	 * 
	 */
	/*
	 * // @Test public void testBodyInResponse() {
	 * 
	 * String responseString = get("api").asString();
	 * given().get("api").then().assertThat().body(equalTo(responseString));
	 * 
	 * }
	 */

	/**
	 * Body attribute verification using java 8 lambda expression
	 * 
	 */
	// @Test
	/*
	 * public void testBodyParametersInResponse() {
	 * 
	 * given().get("api").then().body("thumbnailUrl", new
	 * ResponseAwareMatcher<Response>() { public Matcher<?> matcher(Response
	 * response) { return equalTo("http://placehold.it/150/92c952"); } }
	 * 
	 * );
	 * 
	 * // With Java 8 lambda expression
	 * given().get("api").then().body("thumbnailUrl", response -> equalTo("api"));
	 * 
	 * given().get("api").then().body("thumbnailUrl", endsWith("92c952"));
	 * 
	 * }
	 */

}
