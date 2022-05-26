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

public class DeleteTest {

	

	@Test(priority =1)
public void Validate_Delete_User()

	{
	
	

	when()
	.delete("https://reqres.in/api/users/2")
	
	.then()
	.statusCode(Testbase.RESPONCE_STATUS_CODE_204)
	.header("Content-Length", "0")
	.log().all();
	
	
	}
	
	}
