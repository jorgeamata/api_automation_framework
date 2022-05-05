package com.projectName.apis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.projectName.constants.Endpoints;
import com.projectName.pojos.PhotoPOJO;
import com.projectName.pojos.PhotosPOJO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class MarsPhotos {

	/*
	 * Need to read the config variables Constructor to initialize baseURL, Port,
	 * etc. Get the data for different operations performed against the API and send
	 * data to the tests
	 */

	private static final String BASE_URL = "https://api.nasa.gov/";
	private static final int PORT = 8080;

	public MarsPhotos() {
		RestAssured.baseURI = BASE_URL;
		RestAssured.useRelaxedHTTPSValidation();
	}

	// Get Mars photos by rover = curiosity and martial sol = 1000;
	public List<PhotoPOJO> getPhotosByCuriosityAndMartialSol() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();

		
		PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);

		List<PhotoPOJO> allPhotosList = photosPOJO.getPhotos();

		return allPhotosList;
	}
	
	
	
	//Using generics
	public <T> Response getAllMarsPhotos() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
		
		return response;
	}

	// Get response as String
	public String getResponseAsString() {
		String response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).asPrettyString();

		
		return response;
	}

	// Get the first 10 records of photos by curiosity and martial sol = 1000;
	/*
	 * public List<PhotoPOJO> getFirstTenPhotos() { Response response =
	 * RestAssured.given().contentType(ContentType.JSON)
	 * .get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
	 * 
	 * 
	 * PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);
	 * 
	 * int size = photosPOJO.getPhotos().size(); List<PhotoPOJO> photo =
	 * photosPOJO.getPhotos();
	 * 
	 * for(int i=0; i<=9; i++) { photosPOJO.getPhotos().get(i);
	 * photo.forEach(System.out::println); }
	 * 
	 * 
	 * return photo;
	 */
		
		
	

	// Get status code
	public int getStatusCode() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();

		
		return response.getStatusCode();

	}
	
	public Response getResponse() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
	
		
		return response;
	}
	
	

}
