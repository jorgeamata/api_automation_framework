package com.projectName.basicTestScripts;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


import java.util.List;

import static io.restassured.RestAssured.*;

public class Test007_GroovyFeatures {
	
	String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
	
	/**
	 * Validate if some expected value is present in response or not
	 */
	//@Test
	public void validatePresenceOfElements() {
		given().get(this.url)
		.then()
		.body("RestResponse.result.name", hasItems("Cayman Islands", "Cook Islands")).log().all();
	}	
	
	/**
	 * RestAssured implemented in Groovy and hence advantages can be taken
	 * Here we are adding lenght of all "{fields}" values coming in response
	 */
	//@Test
	public void validateLenghtOfResponse() {
		given().get(this.url)
		.then()
		.body("RestResponse.result.name*.lenght().sum()", greaterThan(10));
	}
	
	/**
	 * To get all attributes as List
	 
	//@Test
	public void getResponseAsList() {
		String response = get(this.url).asString();
		List<String> responseAsList = from(response).getList("RestResponse.result.name");
		
		System.out.println("ListSize: " + responseAsList.size());
		
		for(String country : responseAsList) {
			if(country.equals("Solomon islands"))
				System.out.println("Found my plance");
		}
	}
	*/

	
	/**
	 * Get response as list and apply some conditions to that list
	 * The groovy has an implicit variable called "it" which represents the current item in the list
	 
	//@Test
		public void validateConditionsInList() {
			String response = get(this.url).asString();
			List<String> responseAsList = from(response).getList("RestResponse.result.findAll {it.name.lenght() > 40}.name");
			
			System.out.println(responseAsList);
			
		
		}
	*/
}



	
