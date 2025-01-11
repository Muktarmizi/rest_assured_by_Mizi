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

public class Get_Test {

	@Test
	public void get_test_with_response() {

		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
        .then()
        .statusCode(200).
         body("page", equalTo(2))
        .log().all();
 
	}

}
