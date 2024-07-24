package session1;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerToken {
	@Test
	public void BearerToken() {
		//request specification
		
		RequestSpecification reqspec = RestAssured.given();
		
		reqspec.baseUri("https://gorest.co.in");
		reqspec.basePath("/public/v2/users");
		
		JSONObject payload=new JSONObject();
		payload.put("name", "rajkumar");
	payload.put("gender", "male");
		payload.put("email", "rajkumar78@gmail.com");
		payload.put("status", "active");
		
		String token = " Bearer 71b0b76364b056611cca80644765bd61777844198429c9e45b52909e0da33acb";
		
		reqspec.header("Authorization",token).contentType(ContentType.JSON).body(payload.toJSONString());
		
		
		
		Response response = reqspec.post();
		
		Assert.assertEquals(response.statusCode(), 201);
		
		System.out.println("status of response"+response.statusLine());
		
		System.out.println("body of the response"+response.getBody().asString());
		
		
	}

	

}
