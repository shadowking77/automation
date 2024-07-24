package restasssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Putrequest {
	
	@Test
	void test04() {
		
		JSONObject jsondata = new JSONObject();
		jsondata.put("name","maya");
		jsondata.put("job", "data analyst");
		
		RestAssured.baseURI="https://reqres.in/api/users/969";
		RestAssured.given().header("Content-Type","application/json").contentType(ContentType.JSON).
		body(jsondata.toJSONString()).when().put().then().statusCode(200).log().all();
		
	}

}
