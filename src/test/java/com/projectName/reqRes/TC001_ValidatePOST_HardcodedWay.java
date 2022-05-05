package com.projectName.reqRes;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;


public class TC001_ValidatePOST_HardcodedWay {
	
	@Test
	public void validateRegisterToken() {
		RestAssured.given().log().all()
							.contentType(ContentType.JSON)
							.body("{\n"
									+ "    \"email\": \"eve.holt@reqres.in\",\n"
									+ "    \"password\": \"pistol\"\n"
									+ "}")
							.post("https://reqres.in/api/register")
							.then().log().all()
							.statusCode(200)
							.body("token", Matchers.notNullValue());			
	}
	
	@Test
	public void getSingleUser() {
		RestAssured.given().log().all()
					.contentType(ContentType.JSON)
					.get("https://reqres.in/api/users/2")
					.then().log().all()
					.statusCode(200)
					.body("data.id", Matchers.equalTo(2));
					
					
	}

}
