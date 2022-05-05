package com.projectName.reqRes;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.projectName.pojos.UsersPOJO;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class TC002_TestWithPOJO {

	@BeforeMethod
	public void setup() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api";
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new ErrorLoggingFilter());
		
		RestAssured.requestSpecification = new RequestSpecBuilder()
					.setContentType(ContentType.JSON)
					.build();
	}
				
					
	@Test
	public void getAllUsersTest() {
		String response = given()
				.when()
				.get("users?page=2")
				.then()
				.extract()
				.body()
				.asString();
				
		
		UsersPOJO users = from(response).getObject("", UsersPOJO.class);
		
		
		
		//get all users where id is greater than 10
		List<Map> users1 = from(response).get("data.findAll { user -> user.id > 10} ");
		String email = users1.get(0).get("email").toString();
		
		//get all users where id is greather than 10 and lastname = Howell
		List<Map> users2 = from(response).get("data.findAll { user -> user.id > 10 && user.lastName == 'Howell'} ");
		int id = Integer.valueOf(users2.get(0).get("id").toString());
		
		//besides this, we can convert the response to a POJO object, this is the better way
	}
}
