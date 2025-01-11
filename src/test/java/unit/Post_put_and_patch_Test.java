package unit;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Post_put_and_patch_Test {

	String bodyString = "{\"name\":\"morpheus\",\"job\":\"leader\"}";
	String bodyString1 = "{\"name\":\"muktar\",\"job\":\"QA\"}";
	String bodyString2 = "{\"name\":\"Mizi\",\"job\":\"QA\"}";

	//@Test (priority=1)

	public void post_test_with_response() {

		given()
		.body(bodyString)
		.contentType(ContentType.JSON)
		.when()
		.log().all()
		.post("https://reqres.in/api/users")
		.then()
		.log().all()
		.statusCode(201)
		.body("name", Matchers.equalTo("morpheus"));
	}
	
 //	@Test (priority=2)
	
	public void put_test_with_response() {
		
		given()
		.body(bodyString1)
		.contentType(ContentType.JSON)
		.when()
		.log().all()
		.put("https://reqres.in/api/users/74")
		.then()
		.log().all()
		.statusCode(200)
		.body("name", Matchers.equalTo("muktar"));
		
	}
	
	@Test
	public void patch_test_with_response () {

		given()
		.body(bodyString2)
		.contentType(ContentType.JSON)
		.when()
		.log().all()
		.put("https://reqres.in/api/users/74")
		.then()
		.log().all()
		.statusCode(200)
		.body("name", Matchers.equalTo("Mizi"));
	}
	
	
}
