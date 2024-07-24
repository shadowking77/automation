package restasssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Deleterequest {
	@Test
	void test05() {
		RestAssured.baseURI="https://reqres.in/api/users/969";
		RestAssured.given().when().delete().then().log().all();
	}

}
