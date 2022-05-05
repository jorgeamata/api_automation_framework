package com.projectName.basicTestScripts;

import static io.restassured.RestAssured.given;

public class Test014_Logger {
	
	/**
	 * Status code verification
	 
	 */
	//@Test
	public void testLogger1() {
		
		given().get("API").then()
			.log().headers();
			//.log().body();
			//.log().cookies();
			//.log().all();
	}
	
	//@Test
		public void testLogger2() {
			
			given().get("API").then()
				.log().ifError();
				
		}
		
		//@Test
				public void testLogger3() {
					
					given().get("API").then()
						.log().ifStatusCodeIsEqualTo(200);
						
				}

}
