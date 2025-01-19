package unit_update;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import dto.Category;
import dto.Product;
import groovyjarjarantlr4.v4.parse.GrammarTreeVisitor.mode_return;
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

import java.nio.file.Path;

import java.util.HashMap;

import javax.xml.crypto.Data;




		
public class Multiple_ways_to_create_post_request_body{
	

	 @Test 

		public void post_test_with_response() {
		 
		  HashMap  data = new HashMap();
		  data.put("title","Leather Jacket");
		  data.put("price","150");
		  data.put("description","Stylish leather jacket for men.");
		  data.put("images","\"https://www.voganow.com/cdn/shop/products/BBGJ-1113-01_7.jpg?v=1671019720\"");
		  data.put("creationAt","2025-01-14T02:50:51.000Z");
		  data.put("updatedAt","2025-01-14T02:54:44.000Z");
	      
		  
		  
		  
		  given()
			.contentType(ContentType.JSON) 
			.body(data)
			
			.when()
			.log().all()
			.post("https://api.escuelajs.co/api/v1/products")
		  
		  
		  
		     .then()
              .statusCode(201)
              .body("title",equalTo("Leather Jacket"))
              .body("price",equalTo("150"))
		      .body("description",equalTo("Stylish leather jacket for men.") )
		      .body("images",equalTo("[\"https://www.voganow.com/cdn/shop/products/BBGJ-1113-01_7.jpg?v=1671019720\"]"))
		      .body("creationAt",equalTo("2025-01-14T02:50:51.000Z"))
		      .body("updatedAt",equalTo("2025-01-14T02:54:44.000Z"))
		      .log().all();
		  
		 }
		
	

		
		
	
	
	
	

}
