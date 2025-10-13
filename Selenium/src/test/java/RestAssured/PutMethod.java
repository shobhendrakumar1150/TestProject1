package RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutMethod {
	@Test
	public void putRequest() {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("first_name", "Shobhendra");
		jsonObj.put("last_name", "Yadav");
		jsonObj.put("email", "gopalraj#gmail.com");
		
		RestAssured.baseURI="https://reqres.in/api/users/2";
		RestAssured.given().header("Content-type","application/json").
		contentType(ContentType.JSON).
		body(jsonObj.
		toJSONString()).
		when().
		put().
		then().
		statusCode(401).
		log().all();
		
	}

}
