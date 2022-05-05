package com.projectName.constants;

public class Endpoints {
	
	public static final String GET_MARSPHOTOS_BY_ALL_ROVERS = "/mars-photos/api/v1/rovers?api_key=DEMO_KEY";
	public static final String GET_MARSPHOTOS_CURIOSITY_BY_MARTIANSOL = "/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
	public static final String GET_MARSPHOTOS_CURIOSITY_BY_EARTHDATE = "/mars-photos/api/v1/rovers/curiosity/photos?earth_date={date}&api_key=DEMO_KEY";
	
	
	//marsRoverPhotos API
	public static final String GET_ALL_ROVERS_MARSPHOTOS = "/mars-photos/api/v1/rovers?api_key=DEMO_KEY";
	public static final String GET_MARSPHOTOS_BY_ROVER_CAMERA_TYPE = "/mars-photos/api/v1/rovers/{roverCameras}/photos?api_key=DEMO_KEY";
	public static final String GET_MARSPHOTOS_BY_ROVER_CAMERA_TYPE_AND_NAME = "/mars-photos/api/v1/rovers/{roverCameras}/photos?&camera={cameraName}&api_key=DEMO_KEY";

	//donki API
	public static final String GET_DONKI_CME = "/DONKI/CME?api_key=DEMO_KEY";
	public static final String GET_DONKI_GST = "/DONKI/GST?api_key=DEMO_KEY";
	public static final String GET_DONKI_IPS = "/DONKI/IPS?api_key=DEMO_KEY";
	public static final String GET_DONKI_FLR = "/DONKI/FLR?api_key=DEMO_KEY";
	
	//booking API
	public static final String CREATE_BOOKING = "/booking";
	public static final String GET_BOOKING_BY_ID = "/booking/{id}";
	
	
	
}
