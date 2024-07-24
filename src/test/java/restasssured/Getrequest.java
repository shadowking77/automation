package restasssured;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Getrequest {
	@Test
	void testcase01() {
		
		Response rpn = RestAssured.get("https://reqres.in/api/users/2");
		
		System.out.println(rpn.asString());
		System.out.println("status code:"+  rpn.getStatusCode());//to get status code of url
		System.out.println("Response body:"+ rpn.getBody().asString());// to get body of the url
		System.out.println("response time:"+rpn.getTime());//it will give the response ime for the api
		System.out.println("response header:"+rpn.getHeader("content-Type"));

		int expectedstatuscode=200;//if status code is other than 200 than it will fail 
		int actualstatuscode = rpn.getStatusCode();
		
		Assert.assertEquals(expectedstatuscode, actualstatuscode);
		
		
	}
	@Test
	 public void testcase02(){
		//given ,when , then 
		RestAssured.baseURI="https://reqres.in/api/users/2";
		 RestAssured.given().queryParam("page", "2").when().get().then().statusCode(200);
		 
		 
		
		
	}

}
