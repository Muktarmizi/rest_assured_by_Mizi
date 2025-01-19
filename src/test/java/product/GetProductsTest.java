package product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import base.RestStep;
import dto.Product;
import io.restassured.path.json.JsonPath;

public class GetProductsTest extends RestStep
{
	
	String endpoint = "api/v1/products"; ///api/users?page=2

	@BeforeEach
	public void testDataSetup() 
	{
		init();
	}
	
	@Test
	public void getProducts_happyPath() throws Exception 
	{
		apiGetStep(null, endpoint, null, 200, null);
		
		// DTO - Data Table Object
		Product[] products = getResponse().as(Product[].class);
		System.out.println(products[0].getDescription());
		
		
		JsonPath jPath = JsonPath.from(getResponse().asString());
		System.out.println(jPath.getString("[0].description"));
	}
}
