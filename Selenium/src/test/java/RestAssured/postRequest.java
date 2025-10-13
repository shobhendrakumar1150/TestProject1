package RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class postRequest {
	@Test
	public void testPost() {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("name", "Shobhendra");
		jsonObj.put("job", "QA");
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().header("Content-type","application/json").
		contentType(ContentType.JSON).
		body(jsonObj.toJSONString()).
		when().post().
		then().statusCode(401).log().all();
	}

}
