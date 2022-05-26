

package com.qa.TestCases;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.beust.jcommander.Parameter;
import com.qa.Excel.ExcelUtil;
import com.qa.base.Testbase;

import org.json.simple.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AddUserDataDriven {

	
   String excel_path = System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\UserData.xlsx";
   String Sheet_name="adduser";

   ExcelUtil eu=null;
	
  
	
	
	 @Test(dataProvider = "usersData")
	     void Validate_add_user_data_driven(String Name_str, String job_str)
	    {
		
	    JSONObject ReqParam= new JSONObject();
	    ReqParam.put("name", Name_str);
	    ReqParam.put("job", job_str);
	    baseURI="https://reqres.in/api";
	    
	    given()
	    .contentType(ContentType.JSON)
	    .accept(ContentType.JSON)
		 .header("Content-Type","application/json")
		 
		 .body(ReqParam.toJSONString())
		 
		 .when()
		.post("/users")
		
		.then()
		
		.statusCode(Testbase.RESPONCE_STATUS_CODE_201)
		.assertThat()
		.body("name", equalTo(Name_str))
		.body("job", equalTo(job_str))		
		.log().all();
	
		 
		 
	    }
	 
	 
	 @DataProvider(name="usersData")
		
		
	
	 public Object[][] userFormData() throws Exception
	    {
	        Object[][] data = testData(excel_path, Sheet_name);
	        return data;
	    }
	 
	 
	 public Object[][] testData(String xlFilePath, String sheetName) throws Exception
	    {
	        Object[][] excelData = null;
	        eu = new ExcelUtil(xlFilePath);
	        int rows = eu.getRowCount(sheetName);
	        int columns = eu.getCellCount(sheetName);
	                 
	        excelData = new Object[rows-1][columns];
	         
	        for(int i=1; i<rows; i++)
	        {
	            for(int j=0; j<columns; j++)
	            {
	                excelData[i-1][j] = eu.getCellData(sheetName, j, i);
	            }
	             
	        }
	        return excelData;
	    }
	

	
	
	}
