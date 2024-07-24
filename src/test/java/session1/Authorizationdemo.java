package session1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorizationdemo {
	@Test
	public void GetWeatherData() {
		
		//specification of the response
		RequestSpecification reqspec = RestAssured.given();
		
		reqspec.baseUri("https://api.openweathermap.org");
		reqspec.basePath("/data/2.5/weather");
		reqspec.queryParam("q","delhi").queryParam("appid", "8aa4c4bd2e56abdbb5373734331b7c67");
		Response response = reqspec.get();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println("status of the response"+response.statusLine());
		System.out.println("body of the response"+response.getBody().asString());
		
		
		
		
	}

}
