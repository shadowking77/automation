package session1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CheckforvalidHeader {
	@Test
	public void Getsingleuser() {
		//get request specification
		
		RequestSpecification requestspec = RestAssured.given();
		
		requestspec.baseUri("https://reqres.in");
		requestspec.basePath("/api/users/2");
		
		//create get request
		
		Response response = requestspec.get();
		
		//validate the header
		
		String connection = response.getHeader("Connection");
		
		System.out.println("value of connection"+connection);
		
		//read all the list of headers and print all the headers 
		
		Headers headerslist = response.getHeaders();
		
		for(Header header: headerslist) {
			System.out.println(header.getName()+":" + header.getValue());
		}
		
		
		
		
	}

}
