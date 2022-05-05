package com.projectName.reqRes;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.path.json.JsonPath.from;

import static io.restassured.RestAssured.given;

public class TC001_Tests_NotHardcodedWay {

	@BeforeEach
	public void setup() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api";
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new ErrorLoggingFilter());
		
		RestAssured.requestSpecification = new RequestSpecBuilder()
					.setContentType(ContentType.JSON)
					.build();
	}

	@Test
	public void validateRegisterToken() {
		given()
				.body("{\n" + "    \"email\": \"eve.holt@reqres.in\",\n" + "    \"password\": \"pistol\"\n" + "}")
				.post("/register")
				.then()
				.statusCode(HttpStatus.SC_OK)
				.body("token", Matchers.notNullValue());
	}

	@Test
	public void getSingleUser() {
		given()
				.get("/users/2")
				.then()
				.statusCode(200)
				.body("data.id", Matchers.equalTo(2));

	}
	
	@Test
	public void deleteUser() {
		given()
				.delete("/users/2")
				.then()
				.statusCode(HttpStatus.SC_NO_CONTENT);
	}
	
	@Test
	public void updateUserProperty() {
		String nameUpdated = given()
			.when()
			.body("{\n"
					+ "    \"name\": \"morpheus\",\n"
					+ "    \"job\": \"zion resident\"\n"
					+ "}")
			.patch("/users/2")
			.then()
			.statusCode(HttpStatus.SC_OK)
			.extract()
			.jsonPath().getString("name");
		
		assertThat(nameUpdated, equals("morpheus"));
	}
	
	@Test
	public void updateUser() {
		String jobUpdated = given()
				.when()
				.body("{\n"
						+ "    \"name\": \"morpheus\",\n"
						+ "    \"job\": \"zion resident\"\n"
						+ "}")
				.put("/users/2")
				.then()
				.statusCode(HttpStatus.SC_OK)
				.extract()
				.jsonPath().getString("job");
			
			assertThat(jobUpdated, equals("zion resident"));
	}
	
	

}
