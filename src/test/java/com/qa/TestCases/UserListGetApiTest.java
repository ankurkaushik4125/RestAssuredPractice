package com.qa.TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.Testbase;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;


public class UserListGetApiTest {
	
	
	@Test(priority = 1)
	public void Validate_get_Users_list()
	{
		
		given()

		.get("https://reqres.in/api/users?page=2")
		
		.then()
		
		.statusCode(Testbase.RESPONCE_STATUS_CODE_200)
		// to check the email address responce
		.body("data.email[1]", equalTo("lindsay.ferguson@reqres.in"))		
		// to check the name exist in responce . it could check condition from multiple records
		.body("data.first_name", hasItems("Michael","Byron"))
		.header("Server", "cloudflare")
		.header("Content-Encoding", "gzip")
		.header("Content-Type", "application/json; charset=utf-8")
		
		.log().all();
		
		
	}
	
	

}
