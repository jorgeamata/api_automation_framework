package com.projectName.apis;

import static org.testng.Assert.assertEquals;
import org.apache.http.HttpStatus;

import com.projectName.base.Base;
import com.projectName.constants.Endpoints;
import com.projectName.model.BookingDatesPOJO;
import com.projectName.model.BookingPOJO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Booking extends Base{
	
	

	/*
	 * //GET Data public static <T> T getResourceData(String endpoint, Class<T>
	 * className) { return RestAssured.given() .spec(requestSpec) .when()
	 * .get(endpoint) .then() .statusCode(HttpStatus.SC_OK) .extract()
	 * .as(className); }
	 * 
	 * 
	 * //POST Data public static Response createResourceData(String endpoint, Object
	 * payload) { return RestAssured.given() .spec(requestSpec) .body(payload)
	 * .when() .post(endpoint) .then() .statusCode(HttpStatus.SC_CREATED) .extract()
	 * .response(); }
	 */
	
	
	
	
	
	
	
	
	//private BookingPOJO bookingPOJO;
	
	
	/*
	 * //Create a Book public Response createBooks(String enpoint, String name,
	 * String lastName, int totalPrice, boolean depositPaid,
	 * 
	 * BookingDatesPOJO bookingDates, String additionalNeeds) {
	 * 
	 * bookingPOJO = new BookingPOJO();
	 * 
	 * bookingPOJO.setFirstname(name); bookingPOJO.setLastname(lastName);
	 * bookingPOJO.setTotalprice(totalPrice);
	 * bookingPOJO.setDepositpaid(depositPaid);
	 * bookingPOJO.setBookingdates(bookingDates);
	 * bookingPOJO.setAdditionalneeds(additionalNeeds);
	 * 
	 * //Need to make a POST call Response response = RestAssured.given()
	 * .contentType(ContentType.JSON) .when() .body(bookingPOJO)
	 * .post(Endpoints.CREATE_BOOKING) .andReturn();
	 * 
	 * assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "OK");
	 * 
	 * 
	 * return response; }
	 */
	/*
	 * //Get a book public Response getSingleBookByID(String endpoint, int idNumber)
	 * { Response response = RestAssured.given() .contentType(ContentType.JSON)
	 * .pathParam("id", idNumber) .get(endpoint).andReturn();
	 * 
	 * assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "OK");
	 * 
	 * return response;
	 * 
	 * }
	 */
	
	

	
}


