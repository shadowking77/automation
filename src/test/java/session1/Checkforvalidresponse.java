package session1;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.opentelemetry.api.trace.StatusCode;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Checkforvalidresponse {
	@Test(enabled = false)
	void singleuser() {
		//specify base url
		baseURI="https://reqres.in/api/users/2";
		//get reqest specification of the request
		
		RequestSpecification requestspec = given();
		
		//call get method
		
		 Response response = requestspec.get();
		
		// get status code
		 int StatusCode = response.getStatusCode();
		 
		 //validate actualstatuscode with expected
		 
		 Assert.assertEquals(StatusCode/*actual status code*/, 200/*expected status code*/);//actual status code vs expected status code to check the acceration in 
		 
		 //getstatusline
		 
		String statusline = response.getStatusLine();
		
		System.out.println(statusline);
		
	Assert.assertEquals(statusline ,"HTTP/1.1 200 OK");
			
		
	}
	@Test(enabled = false)
	public void GetSingleusingvalidateresponse() {
		
		//specific base url
		
		baseURI="https://reqres.in/api/users/2";
		
		//get reuest specification of the request
		
		RequestSpecification requestspec = given();
		
		//get request call
		
		Response response = requestspec.get();
		
		//validate response
		
		ValidatableResponse validate = response.then();
		System.out.println(validate);
		
		validate.statusCode(200);
		
		//get statuscode
		
		int statuscode = response.getStatusCode();
		
		Assert.assertEquals(statuscode, 200);
		
		//status line
		validate.statusLine("HTTP/1.1 200 OK") ;
		
		
		
		
		
	}
	
	@Test(enabled = true)
	public void Getsingleuser_BDDstyle() {
		
		given().when().get("https://reqres.in/api/users/2").then().statusCode(200).statusLine("HTTP/1.1 200 OK");
		
		
		System.out.println("200");
		
		
	}
	

}
