package com.projectName.bookingTestScripts;

import org.testng.annotations.Test;
import com.projectName.apis.Booking;
import com.projectName.constants.Endpoints;
import com.projectName.model.BookingPOJO;

public class Test001_TestGET {

	private String getBookings = Endpoints.GET_BOOKING_BY_ID;
	
	//@Test
	public void validateGET() {
		//BookingPOJO bookingObject = Booking.getResourceData(this.getBookings, BookingPOJO.class);
		
		//System.out.println(bookingObject.toString());
	}
	
	@Test
	public void getTopTenRecords() {
		//BookingPOJO bookingObject = Booking.getResourceData(this.getBookings, BookingPOJO.class);
		
	}
	
	

}
