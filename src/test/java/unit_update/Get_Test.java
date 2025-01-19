package unit_update;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.apache.http.entity.mime.content.StringBody;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
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
		
		String bString= "{\"title\": \"New Product\",\"price\": 10,\"description\": "
				+ "\"A description\",\"categoryId\": 1,\"images\": [\"https://placeimg.com/640/480/any\"]}";
		
		String bString1= "{\"title\": \"shoes\",\"price\": 15,\"description\": "
				+ "\"A description\",\"categoryId\": 1,\"images\": [\"https://placeimg.com/640/480/any\"]}";
		
		Header header = new Header("Content-Type", "application/json; charset=utf-8");
		Header header2 = new Header("Server", "Cowboy");
		 int id;
		 
	
		
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

		
	//	@Test (priority=2)
		public void get_test_with_response_2 () {

			given()
			.header(header)
			.when()
			.get("https://api.escuelajs.co/api/v1/products")
	        .then()
	        .statusCode(200)
	        .log().all();
	        
		}
		
		
	@Test
    //(priority =3)
	
	public void post_test_with_response() {
			 
			 
		//id=
				given()
				.contentType(ContentType.JSON) 
				.body(bString)
				.header(header2)
			.when()
				.log().all()
				.post("https://api.escuelajs.co/api/v1/products/") //https://api.escuelajs.co/api/v1/products/
			.then()
	              .statusCode(201)
	              .log().all();
	           // .body("title",equalTo("New Product"))
	           //  .body("price",equalTo("10"))
			   //  .body("description",equalTo("A description") )
			   //   .body("categoryId",equalTo("1"))
			   //   .body("images",equalTo("[\"https://placeimg.com/640/480/any\"]"))
			   //   .log().all();
				//.jsonPath().getInt("id");
			  
			 }
	
	@Test
    //(priority =3)
	
	public void post_test_with_response_2() {
			 
		id=given()
				.contentType(ContentType.JSON) 
				.body(bString)
				.header(header2)
			.when()
				.log().all()
				.post("https://api.escuelajs.co/api/v1/products/") //https://api.escuelajs.co/api/v1/products/
			    .jsonPath().getInt("id");
	
			 }
	

 	@Test 
	
	public void put_test_with_response() {
		
    given()
		.body(bString)
		.contentType(ContentType.JSON)
	.when()
		.log().all()
		.put("https://api.escuelajs.co/api/v1/products/136")
	.then()
		.log().all()
		.statusCode(200)
	    .body("title", Matchers.equalTo("New Product"));
	
		
	}
	
		



}
