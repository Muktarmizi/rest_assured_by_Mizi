package unit;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
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

public class Get_Test {
	
	
//@Test (priority=1)
	
	public void get_test_with_response() {

		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
        .then()
        .statusCode(200).
         body("page", equalTo(2))
        .log().all();
 
	}

	Header header = new Header("Content-Type", "application/json; charset=utf-8");
	@Test
	public void get_test_with_response_2 () {

		given()
		.header(header)
		.when()
		.get("https://api.escuelajs.co/api/v1/products")
        .then()
        .statusCode(200)
        .log().all();
        
	}

	/*
	 {
  "title": "New Product",
  "price": 10,
  "description": "A description",
  "categoryId": 1,
  "images": ["https://placeimg.com/640/480/any"]
}
	 */
	
	
	
	
	
	
	
	
}
