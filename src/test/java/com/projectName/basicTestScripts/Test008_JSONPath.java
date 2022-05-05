package com.projectName.basicTestScripts;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import java.util.List;

import static io.restassured.RestAssured.*;

public class Test008_JSONPath {
	
String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
	
	/**
	 * Extract details as String and fetching details without using json path
	 
	//@Test
	public void withNoJsonPath() {
		String responseAsString = 
				when()
					.get(this.url)
				.then()
				.extract().asString();
		
		List<Integer> list = from(responseAsString).get("id");
		System.out.println(list.size());
	}
	*/

	/**
	 * Extract details as String and fetching details using json path

	//@Test
	public void withJsonPath() {
		String json = 
				when()
					.get(this.url)
				.then()
				.extract().asString();
		
		JsonPath jsonPath = new JsonPath(json).setRoot("RestResponse.result");
		
		List<String> list = jsonPath.get("name"));
		System.out.println(list.size());
		
	}
	 */	
	
	

}
