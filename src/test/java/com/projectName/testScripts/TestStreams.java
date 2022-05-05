package com.projectName.testScripts;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.projectName.apis.MarsPhotos;
import com.projectName.constants.Endpoints;
import com.projectName.pojos.CameraPOJO;
import com.projectName.pojos.PhotoPOJO;
import com.projectName.pojos.PhotosPOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestStreams {
	
	private MarsPhotos marsPhotos;
	
	/*
	 * {
	 * "photos": [
	 * 
	 * 		{
            	"id": 514806,
            	"sol": 1000,
            	"camera": {
                	"id": 22,
                	"name": "MAST",
                	"rover_id": 5,
                	"full_name": "Mast Camera"
            },
            	"img_src": "http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044630650503625C00_DXXX.jpg",
            	"earth_date": "2015-05-30",
            	"rover": {
                	"id": 5,
                	"name": "Curiosity",
                	"landing_date": "2012-08-06",
                	"launch_date": "2011-11-26",
                	"status": "active"
            }
            
        		 ]
        }
	 */
	
	@BeforeClass
	public void init() {
		marsPhotos = new MarsPhotos();
	}
	
	
	
	@Test
	public void streamsGetTopTenPhotos() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
		PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);
		
		List<PhotoPOJO> allPhotos = photosPOJO.getPhotos();
		
		List<PhotoPOJO> topTenList = allPhotos.stream()
									.limit(10)
									.collect(Collectors.toList());							
		
	    topTenList.forEach(System.out :: println);
		
	}
		
	
	//@Test
	public void streamsFilterBySol() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
		PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);
		
		List<PhotoPOJO> allPhotos = photosPOJO.getPhotos();
		
		List<PhotoPOJO> filteredList = allPhotos.stream()
										.filter(p -> p.getSol() == 1000)
										.collect(Collectors.toList());
		
		filteredList.forEach(System.out :: println);
	}
	
	//@Test
	public void streamsFilterByCameraFullName() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
		PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);
		
		List<PhotoPOJO> allPhotos = photosPOJO.getPhotos();
		
		List<PhotoPOJO> filteredList = allPhotos.stream()
										.filter(p -> p.getCamera().getFullName() == "Front Hazard Avoidance Camera")
										.collect(Collectors.toList());
		
		filteredList.forEach(System.out :: println);
	}
	
	//@Test
	public void streamsFilterByRoverName() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
		PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);
		
		List<PhotoPOJO> allPhotos = photosPOJO.getPhotos();
		
		List<PhotoPOJO> filteredList = allPhotos.stream()
										.filter(p -> p.getRover().getName().equalsIgnoreCase("Curiosity"))
										.collect(Collectors.toList());
		
		filteredList.forEach(System.out :: println);
	}
	
	//@Test
	public void streamsSortByPhotosID() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
		PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);
		
		List<PhotoPOJO> allPhotos = photosPOJO.getPhotos();
		
		List<PhotoPOJO> sortedList = allPhotos.stream()
									.sorted(Comparator.comparing(PhotoPOJO :: getId))
									.collect(Collectors.toList());
		
		sortedList.forEach(System.out :: println);
	
	}
	
	//@Test
	public void streamsReverseSortByPhotosID() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
		PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);
		
		List<PhotoPOJO> allPhotos = photosPOJO.getPhotos();
		
		List<PhotoPOJO> sortedList = allPhotos.stream()
									.sorted(Comparator.comparing(PhotoPOJO :: getId).reversed())
									.collect(Collectors.toList());
		
		sortedList.forEach(System.out :: println);
	
	}
	
	//@Test
	public void streamsSortByIdAndCamera() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
		PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);
		
		List<PhotoPOJO> allPhotos = photosPOJO.getPhotos();
		
		List<PhotoPOJO> sortedList = allPhotos.stream()
									.sorted(Comparator.comparing(PhotoPOJO :: getId))
									//.thenComparing(PhotoPOJO :: getCamera))
									.collect(Collectors.toList());
		
		sortedList.forEach(System.out :: println);
	}
	
	//@Test
	public void streamsAllDataMatch() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
		PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);
		
		List<PhotoPOJO> allPhotos = photosPOJO.getPhotos();
	
		boolean allMatch = allPhotos.stream()
							.allMatch(p -> p.getRover().getName().equalsIgnoreCase("Curiosity"));
		
		System.out.println("Does it match?: " + allMatch);
	}
	
	//@Test
	public void streamsAnyDataMatch() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
		PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);
		
		List<PhotoPOJO> allPhotos = photosPOJO.getPhotos();
	
		boolean allMatch = allPhotos.stream()
							.anyMatch(p -> p.getRover().getName().equalsIgnoreCase("Curiosity"));
		
		System.out.println("any match?: " + allMatch);
	}
	
	//@Test
	public void streamsNoneDataMatch() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
		PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);
		
		List<PhotoPOJO> allPhotos = photosPOJO.getPhotos();
	
		boolean noneMatch = allPhotos.stream()
				.noneMatch(p -> p.getRover().getName().equalsIgnoreCase("Spirit"));
		
		System.out.println("none match?: " + noneMatch);
	}
	

	//@Test
		public void streamsGetMaxValue() {
			Response response = RestAssured.given().contentType(ContentType.JSON)
					.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
			PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);
			
			List<PhotoPOJO> allPhotos = photosPOJO.getPhotos();
		
			allPhotos.stream()
					.max(Comparator.comparing(PhotoPOJO :: getId))
					.ifPresent(System.out :: println);
		}
	
	//@Test
	public void streamsGetMinValue() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
		PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class);
		
		List<PhotoPOJO> allPhotos = photosPOJO.getPhotos();
	
		allPhotos.stream()
				.min(Comparator.comparing(PhotoPOJO :: getId))
				.ifPresent(System.out :: println);
	}
	
	/*
	 * @Test public void streamsGroupByCamera() { Response response =
	 * RestAssured.given().contentType(ContentType.JSON)
	 * .get(Endpoints.GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL).andReturn();
	 * PhotosPOJO photosPOJO = response.getBody().as(PhotosPOJO.class); PhotoPOJO
	 * photoPOJO = response.getBody().as(PhotoPOJO.class);
	 * 
	 * List<PhotoPOJO> allPhotos = photosPOJO.getPhotos(); CameraPOJO cameraName =
	 * photoPOJO.getCamera();
	 * 
	 * Map<CameraPOJO, List<PhotoPOJO>> groupByCamera = allPhotos.stream()
	 * .collect(Collectors.groupingBy(PhotoPOJO :: getCameraName));
	 * 
	 * 
	 * groupByCamera.forEach((getCameraName, photo1) -> {
	 * System.out.println(getCameraName); photo1.forEach(System.out.println);
	 * System.out.println(); });
	 * 
	 * }
	 */
	
	
	
	

	
	
	
	
	
	
	

}
