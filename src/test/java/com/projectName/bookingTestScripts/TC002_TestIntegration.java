package com.projectName.bookingTestScripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.projectName.apis.Booking;
import com.projectName.model.BookingDatesPOJO;

public class TC002_TestIntegration {
	
	
	//Create a new book
	//Validate the book by making a GET call
	//Update the name of the book
	//Validate new book name
	//Delete a book
	//Validate book has been deleted
	
	
	
	private Booking booking;
	private BookingDatesPOJO bookingDates;
	
	@BeforeClass
	public void init() {
		booking = new Booking();
	}
	
	@Test
	public void validateIntegration() {
		
	}

}
