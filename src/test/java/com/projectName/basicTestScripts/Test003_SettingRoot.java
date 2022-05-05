package com.projectName.basicTestScripts;


import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Test003_SettingRoot {
	
String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
	
	/**
	 * Basic way to test all parameters
	 */
	@Test
	public void testWithoutRoot() {
		given().get(this.url)
		.then()
		.body("photos.id", is("102693"))
		.body("photos.sol", is("1000"))
		.body("photos.camera.id", is(20));
	}
	
	/**
	 * Recommended way to test all parameters using Root feature
	 */
	@Test
	public void testWithRoot() {
		given().get(this.url)
		.then()
		.root("photos")
		.body("id", is("102693"))
		.body("sol", is("1000"))
		.body("camera.id", is(20));
	}
	
	/**
	 * We can detach root path in between
	 */
	@Test
	public void testDetachRoot() {
		given().get(this.url)
		.then()
		.root("photos")
		.body("id", is("102693"))
		.body("sol", is("1000"))
		.body("camera.id", is(20))
		.detachRoot("photos")
		.body("photos.id", is("102693"));
	}
	


}
