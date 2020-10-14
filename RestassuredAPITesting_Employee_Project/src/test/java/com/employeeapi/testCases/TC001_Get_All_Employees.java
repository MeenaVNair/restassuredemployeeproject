package com.employeeapi.testCases;



import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Employees extends TestBase {
	 @BeforeClass
 void getAllEmployees() throws Exception {
		 
		 logger.info("*************Started TC001_Get_All_Employee*************");
		 RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		 httpRequest = RestAssured.given();
		 response= httpRequest.request(Method.GET,"/employees");
		 
		 Thread.sleep(4);
		 
	 }

	 @Test
	 void checkResponse() {
		 
		 logger.info("*********Checking Response Body****************");
		  String responseBody = response.getBody().asString();
		  logger.info("*************Checking Response Body***************");
		  Assert.assertTrue(responseBody !=null);
		  
	 }
	 
	 @Test
	 void checkStatusCode()
	 {
		logger.info("**********Checking Status Code*************"); 
		int statusCode =response.getStatusCode(); // Getting status code
		logger.info("Status Code is:" + statusCode);
		Assert.assertEquals(statusCode,200);
		
	 }
		
		@Test
		void checkContentType()
		{
			logger.info("******Checking Content Type");
			String contentType = response.header("Content-Type");
			logger.info("Content type is:" + contentType);
			Assert.assertEquals(contentType,"application/json;charset=utf-8");
			}
			
			@AfterClass
			void tearDown()
			{
				logger.info("********* Finished Started TC001_Get_All_Employee*************");
				
			}
			
			
			
			
			
			
			
		
		
		
		 
	 

		
	}

