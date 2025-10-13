package RestAssured;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteRequest {
	public void deleteRequest() {
	RestAssured.baseURI="https://reqres.in/api/users/2";
	RestAssured.given().when().delete().then().statusCode(204);
	}

}
