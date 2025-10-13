package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse {
	//https://reqres.in/api/users/2
	@Test(enabled = false)
	public void getSingleUser() {
		//specify base URI
		baseURI="https://reqres.in/api/users/2";
		
		//Get Request specification of the request
		RequestSpecification reqSpec=given();
		
		//Call get method
		Response response=reqSpec.get();
		//gets response code
		int Actualstatuscode=response.getStatusCode();
		int expectedStatusCode=200;
		
		//Validate Actual StatusCode with expected statuscode
		Assert.assertEquals(Actualstatuscode, expectedStatusCode,"correct statuscode received");
		
		String ActualStatusLine=response.getStatusLine();
		String expectedStatusLine="HTTP/1.1 200 OK";
		
		Assert.assertEquals(ActualStatusLine, expectedStatusLine,"correct statusline received");
		
	}
	@Test(enabled =false)
	public void GetSingleUserUsingValidatableResponse() {
		//specify base URI
			baseURI="https://reqres.in/api/users/2";
				
				//Get Request specification of the request
				RequestSpecification reqSpec=given();
				
				//Call get method
				Response response=reqSpec.get();
				
				ValidatableResponse validateRes=response.then();
				
				//Status code
				//validateRes.statusCode(206);
				
				System.out.println("Status code validation is running successful");
				
				
				//Status Line
				
				validateRes.statusLine("HTTP/1.1 200 OK");
				System.out.println("Status line validation is running successful ");
				
		
	}
	@Test
	public void GetSingleUserValidationUsingBddStyle() {
		//specify base URI
				given()
				.when()
				.get("https://reqres.in/api/users/2")
				.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK");
				
				
		
	}

}
