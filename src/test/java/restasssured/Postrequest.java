package restasssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Postrequest {
	@Test
	void test03() {
		
		JSONObject jsondata= new JSONObject();
		jsondata.put("name", "raj");
		jsondata.put("job", "QA");
		
		RestAssured.baseURI=("https://reqres.in/api/users");
		RestAssured.given().header("Content-Type","application/json").contentType(ContentType.JSON).
		body(jsondata.toJSONString()).when().post().then().statusCode(201).log().all();
		
			
		
		
	}

}
