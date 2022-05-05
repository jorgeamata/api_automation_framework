package com.projectName.apis;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.projectName.model.RoverPOJO;
import com.projectName.model.RoversPOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class MarsRoverPhotos {
	
	private static final String BASE_URL = "https://api.nasa.gov/";
	private RoversPOJO roversPOJO;
	
	public MarsRoverPhotos() {
		RestAssured.baseURI = BASE_URL;
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	private Response getEndpoint(String endpoint) {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(endpoint).andReturn();
		
		return response;
	}
	
	//send get request
	public Response sendGetRequest(String endpoint) {
		return this.getEndpoint(endpoint);
	}
	
	//get response time
	public long getResponseTime(String endpoint) {
		long responseTime =  this.getEndpoint(endpoint).time();
		return responseTime;
	}
	
	//Get status code
	public int getStatusCode(String endpoint) {
		return this.getEndpoint(endpoint).getStatusCode();
	}
	
	//Validate json schema
	public void getJSONSchema(String endpoint) {
		this.getEndpoint(endpoint)
				.then()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemas/marsRoverPhotosSchema.json"));
	}
	
	//Print response as String
	public Response printResponseAsString(String endpoint) {
		return this.getEndpoint(endpoint);
	}
	
	//Get first ten records
	public void getFirstTenRecords(String endpoint) {
		Response response = this.getEndpoint(endpoint);
		
		roversPOJO = response.getBody().as(RoversPOJO.class);
		
		List<RoverPOJO> allRovers = roversPOJO.getRovers();
		List<RoverPOJO> topTenRecords = allRovers.stream()
													.limit(10)
													.collect(Collectors.toList());
		
		
		topTenRecords.forEach(System.out :: println);
		
	}
	
	//Group by Rover
	public void groupByRover(String endpoint) {
		Response response = this.getEndpoint(endpoint);
		
		roversPOJO = response.getBody().as(RoversPOJO.class);
		
		List<RoverPOJO> allRovers = roversPOJO.getRovers();
		
		//Map<RoverPOJO, List<RoversPOJO>> byRover = allRovers.stream().collect(groupingBy(r -> new RoverPOJO(r.getName())));
		
	}
	
	
	
	
	


	
	

}
