package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetMethod {
	@Test
	public void getRequest() {
		Response res=get("https://reqres.in/api/users?page=2");
		System.out.println(res.asString());
		System.out.println("Status code is:"+res.getStatusCode());
		System.out.println("Response body is:"+res.getBody().asString());
		System.out.println("Respons time is:"+res.getTime());
		System.out.println("Response Header is:"+res.getHeader("Content-Type"));
		
		//Validate Status Code
		//expected status code is 200
		int expectedStatusCode=200;
		int ActualStatuscode=res.getStatusCode();
		Assert.assertEquals(expectedStatusCode, ActualStatuscode);
	}
	@Test
	public void RequestUsingGivenWhenThen() {
		//given,when,then
	    baseURI="https://reqres.in/api/users";
	     given()
		.queryParam("page", "2")
		.when().get()
		.then().statusCode(200);
	}
	
	

}
