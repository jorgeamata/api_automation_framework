package com.projectName.basicTestScripts;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.projectName.pojos.PhotoPOJO;
import com.projectName.pojos.PhotosPOJO;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test000_SimpleTest {
	
	
	//https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY
	String baseUrl = "https://api.nasa.gov/";
	String resource = "mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
	
	
	
	
	
	
	@Test
	//Retrieve the first 10 Mars photos made by "Curiosity" on 1000 Martian sol.
	public void test01() {
		RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(resource);
		
		
		//Deserialize the response body into Photos class
		//photosPOJO returns a List of Photos, each entry of the list is a photoPOJO
		PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);
		
		//Getting the first index of List photosPOJO
		//photoPOJO = photosPOJO.getPhotos().get(0);
		
		//Getting the size of the list photosPOJO and print it
		int numberOfPhotos = photosPOJO.getPhotos().size();
		System.out.println("Total number of photos: " + numberOfPhotos);
		
		
		//Getting the first 10 photos
		for(int i = 0; i<10; i++) {
			System.out.println("photo number " + (i + 1)  + " : " + photosPOJO.getPhotos().get(i).getId());
		}
		
		
		//Retrieve and compare the first 10 Mars photos made by "Curiosity" on 1000 sol and on Earth date equal to 1000 Martian sol.
		//Validate that the amounts of pictures that each "Curiosity" camera took on 1000 Mars sol is not greater than 10 times the amount taken by other cameras on the same date
		
	}
	
	//@Test
	//Retrieve the first 10 Mars photos made by "Curiosity" on Earth date equal to 1000 Martian sol.
	public void test02() {
		RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(resource);
		
		//Deserialize the response body into Photos class
		//photosPOJO returns a List of Photos, each entry of the list is a photoPOJO
		PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);
		
		//Deserialize the response body into Photo class
		//photoPOJO returns all the properties of a Photo
		PhotoPOJO photoPOJO = response.getBody().as(PhotoPOJO.class);
				
		//Define variables for earthDate and martialSol
		String earthDate = photoPOJO.getEarthDate();
		int martialSol = photoPOJO.getSol();
		
		
		//Iterate trough the list of photos - photosPOJO
		List<PhotoPOJO> list = photosPOJO.getPhotos();
		
		for(PhotoPOJO tempList : list) {
			if( (earthDate == "2015-05-30") && (martialSol == 1000)) {
			System.out.println(tempList.getId() + ":" + tempList.getEarthDate() + ":" + tempList.getSol());
			}
		}

	}
	

}
