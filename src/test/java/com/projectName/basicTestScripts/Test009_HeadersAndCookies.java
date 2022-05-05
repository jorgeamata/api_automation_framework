package com.projectName.basicTestScripts;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Test009_HeadersAndCookies {
	
String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
	
	/**
	 * Get response with headers
	 */
	//@Test
	public void getResponseWithHeaders() {
		Response response = get(this.url);
		
		//get a single header
		String headerCFRAY = response.getHeader("CF-RAY");
		System.out.println(">>>> Header: " + headerCFRAY);
		
		System.out.println("");
		
		//to get all headers
		Headers headers = response.getHeaders();
		for(Header header : headers) {
			System.out.println(header.getName() + " : " + header.getValue());
		}
		
	}
	
	/**
	 * Get cookies
	 */
	//@Test
	public void getCookies() {
		Response response = get(this.url);
		Map<String, String> cookies = response.getCookies();
		
		for(Map.Entry<String, String> entry: cookies.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
	}
	
	/**
	 * Get detailed cookies
	 */
	public void getDetailedCookies() {
		Response response = get(this.url);
		
		Cookie cookie = response.getDetailedCookie("__cfduid");
		cookie.hasExpiryDate();
		cookie.getExpiryDate();
		cookie.hasValue();
		
	}

}
