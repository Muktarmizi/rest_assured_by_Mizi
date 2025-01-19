package base;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author Enthrall2025
 */
public abstract class RestStep 
{
	RequestSpecification request;
	Response response;
	
	/**
	 * Initializing Rest-Assured RequestSpecification {@link #request}
	 */
	public void init() 
	{
		request = RestAssured.given();
	}
	
	/**
	 * Get Response object {@link #response}
	 * @return
	 */
	public Response getResponse() 
	{
		return response;
	}
	
	public void setBaseUrl() 
	{
		request.baseUri("https://api.escuelajs.co/"); //https://reqres.in/
	}
	
	/**
	 * Set Headers object
	 * @param headers {@link Headers}
	 */
	public void setHeaders(Headers headers) 
	{
		if (headers != null) 
		{
			request.headers(headers);
		}
	}
	
	/**
	 * Set Header[] to the {@link #request}
	 * @param headerArr Array of {@link Header}
	 */
	public void setHeaders(Header... headerArr) 
	{
		for(Header header : headerArr) 
		{
			setHeader(header);
		}
	}
	
	/**
	 * Set a Header
	 * @param header {@link Header}
	 */
	public void setHeader(Header header) 
	{
		request.header(header);
	}
	
	/**
	 * Set end-point
	 * @param endpoint API End-point
	 */
	public void setEndpoint(String endpoint) 
	{
		request.basePath(endpoint);
	}
	
	/**
	 * Set path parameters
	 * @param endpoint API End-point
	 * @param params path params array
	 * @throws Exception if path params do not have same size at end-point
	 */
	public void setParams(String endpoint, Object[] params) throws Exception 
	{
		if (params != null) 
		{
			// api/users/{id}/accounts/{accountId}

			// .pathParam("id", 300)
			// .pathParam("accountId", "38829020")

			List<String> paramNames = new ArrayList<String>();

			String[] arr = endpoint.split("/");

			// Find out the expected params from the end-point
			for (String s : arr) 
			{
				if (s.startsWith("{") && s.endsWith("}")) {
					paramNames.add(s.replaceAll("[^A-Za-z0-9]", s));
				}
			}

			// Validate if the expected params are equals to actual params
			if (params.length != paramNames.size()) 
			{
				throw new Exception("Given params are not mtching with endpint expected params");
			}

			int index = 0;
			// Assign params
			for (Object param : params) 
			{
				request.pathParam(paramNames.get(index), param);
				index++;
			}
		}
	}
	
	/**
	 * Build a GET API Request
	 * @param headers {@link Headers}
	 * @param endpoint API End-point
	 * @param params Path Params
	 * @param stausCode expected status code
	 * @param statusMessage expected status message
	 * @return {@link #response}
	 * @throws Exception if path params do not have same size at end-point
	 */
	public Response apiGetStep(Headers headers, String endpoint, Object[] params, 
			int stausCode, String statusMessage) throws Exception 
	{
		
		/*
		 * Headers - DONE
		 * End-point - DONE
		 * Params - DONE
		 * statusCode - DONE
		 * statusMessage - 
		 */
		
		setBaseUrl();
		setHeaders(headers);
		setEndpoint(endpoint);
		setParams(endpoint, params);
		
		response = request.log().all().get();
		response.then().log().all();
		
		validateStatusCode(stausCode);
		validateStatusLine(statusMessage);
		
		return response;
	}
	
	/**
	 * Validate Status Code
	 * @param expectedStatusCode Integer
	 */
	public void validateStatusCode(int expectedStatusCode) 
	{
		response.then().statusCode(expectedStatusCode);
	}
	
	/**
	 * Validate Status Line
	 * @param expectedLine String
	 */
	public void validateStatusLine(String expectedLine) 
	{
		if (expectedLine != null) 
		{
			response.then().statusLine(expectedLine);
		}
	}
	
}
