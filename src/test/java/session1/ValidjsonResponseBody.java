package session1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ValidjsonResponseBody {
	
	@Test
	public void userlistbody(){
		
		//specificiation of the given  request
		RequestSpecification reqspec = RestAssured.given();
		
		reqspec.baseUri("https://reqres.in");
		reqspec.basePath( "api/users?page=2");
		
		//get response
		
		Response response = reqspec.get();
		
		//read the response body
		
		ResponseBody reqbody = response.getBody();
		
		//change to string
		
		String reqstring = reqbody.toString();
		
		System.out.println("responsebody"+reqstring);
		
		//check the presense of the string in the response
	
	org.testng.Assert.assertTrue(reqstring.contains("Byron"), "Expected 'Byron' to be present in the response but it was not found.");
		
		System.out.println("x");
		JsonPath jsonbody = reqbody.jsonPath();
		
	String firsName = jsonbody.getString("x.data[3].first_name");
		
		
	
		org.testng.Assert.assertEquals(firsName, "Byron");
	}

}
