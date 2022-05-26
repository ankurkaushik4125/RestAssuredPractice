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

public class PartialUpdatePatchTest {

	

	@Test(priority =1)
public void Validate_Patch_update_Request ()

	{
		String name_str="Vikram";
		String 	job_str="QA Manager";	
		// Post request is save in hashmap with key and pair values
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("Name", name_str);
	map.put("job", job_str);
	
	// Now convert this map value to json type
	
	JSONObject json = new JSONObject(map);
	System.out.println(json);
	
	given()
	.header("Content-Type","application/xml")
	.body(json.toJSONString())
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.when()
	.patch("https://reqres.in/api/users/2")
	
	.then()
	.statusCode(Testbase.RESPONCE_STATUS_CODE_200)
	.log().all();
	
	
	}
	
	}
