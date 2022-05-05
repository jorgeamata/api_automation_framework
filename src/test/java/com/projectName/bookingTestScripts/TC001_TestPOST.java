package com.projectName.bookingTestScripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.projectName.apis.Booking;
import com.projectName.constants.Endpoints;
import com.projectName.model.BookingDatesPOJO;

public class TC001_TestPOST {
	
	private Booking booking;
	private BookingDatesPOJO bookingDates;
	
	@BeforeClass
	public void init() {
		booking = new Booking();
		bookingDates = new BookingDatesPOJO();
	}
	
	@Test
	public void createNewBook() {
		bookingDates.setCheckin("2018-01-01");
		bookingDates.setCheckout("2019-01-01");
		//booking.createBooks(Endpoints.CREATE_BOOKING, "Jorge", "Mata", 12, true, bookingDates, "Test");
			
		
	}

}
