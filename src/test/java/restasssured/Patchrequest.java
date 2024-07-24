package restasssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Patchrequest {
	@Test
	void test05() {
		
		JSONObject jsondata = new JSONObject();
		jsondata.put("name", "riya");
		jsondata.put("job", "CEO");
		
		RestAssured.baseURI="https://reqres.in/api/users/969";
		RestAssured.given().header("Content-Type","application/json").contentType(ContentType.JSON).
		body(jsondata.toJSONString()).when().patch().then().statusCode(200).log().all();
		
	}

}
