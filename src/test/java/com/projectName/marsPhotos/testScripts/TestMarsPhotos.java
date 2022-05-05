package com.projectName.marsPhotos.testScripts;



import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.projectName.apis.MarsRoverPhotos;
import com.projectName.constants.Endpoints;
import com.projectName.model.RoversPOJO;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.CoreMatchers.*;

public class TestMarsPhotos {
	
	private MarsRoverPhotos marsRoverPhotos;
	
	@BeforeClass
	public void init(){
		marsRoverPhotos = new MarsRoverPhotos();
	}
	
	//@Test
	public void validateStatusCode() {
		int actualStatusCode = marsRoverPhotos.getStatusCode(Endpoints.GET_ALL_ROVERS_MARSPHOTOS);
		int expectedStatusCode = 200;
		
		System.out.println("Status code is " + actualStatusCode);
		Assert.assertEquals(actualStatusCode, expectedStatusCode);
	}
	
	//@Test
	public void validateJSONSchema() {
		marsRoverPhotos.getJSONSchema(Endpoints.GET_ALL_ROVERS_MARSPHOTOS);
	}
	
	//@Test
	public void printResponseAsString() {
		String stringResponse = marsRoverPhotos.printResponseAsString(Endpoints.GET_ALL_ROVERS_MARSPHOTOS).asPrettyString();
		System.out.println(stringResponse);
	}
	
	//@Test
	public void getFirstTenRoverRecords() {
		marsRoverPhotos.getFirstTenRecords(Endpoints.GET_ALL_ROVERS_MARSPHOTOS);
		
	}
	
	@Test
	public void validateResponseTime() {
		
		Response response = marsRoverPhotos.sendGetRequest(Endpoints.GET_ALL_ROVERS_MARSPHOTOS);
		System.out.println("Actual response time is: " + response.time());
		
		ValidatableResponse vr = response.then();
		vr.time(Matchers.lessThan(1500L));
		
	}
	
	@Test
	public void groovyFindAll() {
		Response response = marsRoverPhotos.sendGetRequest(Endpoints.GET_ALL_ROVERS_MARSPHOTOS);
		RoversPOJO roversPOJO = response.getBody().as(RoversPOJO.class);
		
		
		
		
		
		
	}
	
	

}
