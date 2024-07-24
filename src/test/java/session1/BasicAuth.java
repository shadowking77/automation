package session1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuth {
	@Test
	public void Basicauth() {
		
		//specification for request
		
		RequestSpecification requestspec = RestAssured.given();
		
		requestspec.baseUri("https://postman-echo.com");
		requestspec.basePath("/basic-auth");
		
		 Response response = requestspec.auth().preemptive().basic("postman", "password").get();
		
		System.out.println("response status:"+response.statusLine());
		
		System.out.println("body of the response:"+response.getBody().asString());
		
		
		
		
	}
	@Test
	public void DigestAuth() {
		//specification of the response
		RequestSpecification requestspec = RestAssured.given();
		
		//url of the respos
		
		requestspec.baseUri("https://httpbin.org");
		requestspec.basePath("/digest-auth/undefined/raj/raj");
		//digest resquest for the response
		Response response = requestspec.auth().digest("raj", "raj").get();
		//status of the response
		
	System.out.println("status of the respose"+response.statusLine());
	
	//body of the response
	
	System.out.println("body "+response.getBody().asString());
		
	}

}
