package com.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class Testbase {

	
	
	public static  int RESPONCE_STATUS_CODE_200 =200;
	
	public static  int RESPONCE_STATUS_CODE_201 =201;
	public static  int RESPONCE_STATUS_CODE_204 =204;
	
	public Properties prop;
	
	public Testbase()
	{
	
		
		try {
			prop=new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
						
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
						
		}
		
	}
}
