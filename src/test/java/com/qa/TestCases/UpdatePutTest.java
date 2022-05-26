package com.qa.TestCases;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.qa.base.Testbase;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UpdatePutTest {

	

	@Test(priority =1)
public void Validate_Update_user_put()

	{
		
		// Post request is save in hashmap with key and pair values
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("Name", "Tirath");
	map.put("job", "Assitant QA Manager");
	
	// Now convert this map value to json type
	
	JSONObject json = new JSONObject(map);
	System.out.println(json);
	
	given()
	.header("Content-Type","application/xml")
	.body(json.toJSONString())
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.when()
	.put("https://reqres.in/api/users/2")
	
	.then()
	.statusCode(Testbase.RESPONCE_STATUS_CODE_200)
	.log().all();
	
	
	}
	
	}
