package session1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Queryparameterdemo {
	
		@Test
		public void filterData() {
			//specification of the request
			RequestSpecification requestspec = RestAssured.given();
			
			requestspec.baseUri("https://reqres.in/");
			requestspec.basePath("api/users");
			requestspec.queryParam("page", 2).queryParam("id", 10);
			
			//perform get request
			
			Response response = requestspec.get();
			
			//to get the body of the response
			
			String responsestring = response.getBody().asString();
			
			System.out.println("body of the response"+responsestring);
			
			
			
		}

}
