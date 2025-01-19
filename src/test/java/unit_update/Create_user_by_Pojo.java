package unit_update;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dto.Product;
import dto.Users;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

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
import java.util.Map;

import javax.xml.crypto.Data;


public class Create_user_by_Pojo {
	
	String baseUrl = "https://reqres.in"; //https://reqres.in/api/users
	String basePath = "/api/users";
	String basePath1 = "/api/users/243"; //https://reqres.in/api/users/243
	
	Header header = new Header("Content-Type", "application/json; charset=utf-8");
	
	
	String bodyString = "{\"name\":\"paul rudd\",\"movies[]\":\"I Love You Man\",\"Role Models\"\"id\":\"243\",\"createdAt\":\"2014-10-18T12:09:05.255Z\"}";
	 
	int id;
	
	//Map<String, Object> userMap = new HashMap<String, Object>();
	
	@Test
	//@Disabled
	public void get_Test() {
	
    Response response = RestAssured.given().get("https://reqres.in/api/users");
			
		Header header = new Header("Content-Type", "application/json; charset=utf-8");
		String baseUrlString = "https://reqres.in";
		String endpoint = "/api/users";
			
	    RestAssured.given().baseUri(baseUrlString)
				.basePath(endpoint)
				.header(header)
				.when()
				.log().all()
				.get()
				.then()
				.log().all()
				.statusCode(200);
			
	}
	
	
	@Test
	@Disabled
	public void post_Test_pojo_Plain_old_java_object() {
	
		Users user = new Users();
		user.setname("paul rudd");
	    user.setMovies("I Love You Man,Role Models");
		user.setId(243);
		user.setCreatedAt("2014-10-18T12:09:05.255Z");
		id=user.setId(243);
		
		
		Response response = RestAssured.given()
			.baseUri(baseURI)
			.basePath(basePath)
			.body(user)
			.header(header)
			.contentType(ContentType.JSON)
			.when()
			.log().all()
			.post(baseUrl + basePath); //https://reqres.in/api/users
			//.post();
		
		response.then().log().all();
		
		Assertions.assertEquals(201, response.getStatusCode());
		
		Users actualUser = response.as(Users.class); // Object Mapping
		
		Assertions.assertEquals(user.getname(), actualUser.getname(), "Name did not match");
		Assertions.assertEquals(user.getMovies() , actualUser.getMovies());
		Assertions.assertEquals(user.getId() , actualUser.getId());
		//Assertions.assertEquals(user.getCreatedAt() , actualUser.getCreatedAt());
	}
	
	
	@Test
    @Disabled
	public void put_Test_pojo_Plain_old_java_object() {
	
		Users user = new Users();
		user.setname("steven carter");
	    user.setMovies("harry potter");
		user.setId(243);
		user.setCreatedAt("2014-10-18T12:09:05.255Z");
	 //	id=id;
		
		
		Response response = RestAssured.given()
			.baseUri(baseURI)
			.basePath(basePath1)
			.body(user)
			.header(header)
			.contentType(ContentType.JSON)
			.when()
			.log().all()
			.put(baseUrl + basePath1); //https://reqres.in/api/users/243
		
		response.then().log().all();
		
		Assertions.assertEquals(200, response.getStatusCode());
		
		Users actualUser = response.as(Users.class); // Object Mapping
		
		Assertions.assertEquals(user.getname(), actualUser.getname(), "Name did not match");
		Assertions.assertEquals(user.getMovies() , actualUser.getMovies());
		Assertions.assertEquals(user.getId() , actualUser.getId());
		//Assertions.assertEquals(user.getCreatedAt() , actualUser.getCreatedAt());
	}
	

	
}
