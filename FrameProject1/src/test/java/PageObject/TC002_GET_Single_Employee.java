package PageObject;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_GET_Single_Employee extends TestBase 

         {
	         @BeforeClass
	         void getAllEmployees() throws InterruptedException{
	        	 
	        	 logger.info("********Started TC002_GET_Single_employees_Data*******");
	        	 
	        	 RestAssured.baseURI="https://reqres.in/api/";
	        	 httpRequest=RestAssured.given();
	        	 response=httpRequest.request(Method.GET,"/users/"+empID);
	        	 
	        	 Thread.sleep(3000);
	     		
	     		
	     		
	     }
	         
	         @Test
	         void checkResponseBody() {
	        	 logger.info("********Checking Response Body*******");
	        	 String responseBody=response.getBody().asString();
	        	 logger.info("Response Body ==>"+responseBody);
	        	 Assert.assertEquals(responseBody.contains(empID),true);
	         }
	         
	         
	         
	         @Test
	         void checkStatusCode() {
	        	 logger.info("********Checking Status Code*******");
	        	 int statusCode=response.getStatusCode();
	        	 logger.info("Satus Code ==>"+statusCode);
	        	 Assert.assertEquals(statusCode,200);
	        	 
	        	 
	         }
	         
	         @Test
	         void checkResponseTime() {
	        	 logger.info("********Checking Response Time*******");
	        	 long responseTime=response.getTime();
	        	 logger.info("Response Time is ==>"+responseTime);
	        	 Assert.assertTrue(responseTime<6000);
	        	 
	        	 
	         }
	         
	         @Test
	         void checkStatusLine() {
	        	 logger.info("********Checking Status Line*******");
	        	 String statusLine=response.getStatusLine();
	        	 logger.info("Satus Line is ==>"+statusLine);
	        	 Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
	        	 
	        	 
	         }
	         
	         @Test
	         void checkContentType() {
	        	 logger.info("********Checking Content Type*******");
	        	 String contentType=response.getContentType();
	        	 logger.info("Content Type is ==>"+contentType);
	        	 Assert.assertEquals(contentType,"application/json; charset=utf-8");
	        	 
	        	 
	         }
	         
	         @Test
	         void checkContentLength() {
	        	 logger.info("********Checking Content Length*******");
	        	 String contentLength=response.header("Caontent-Length");
	        	 logger.info("Content Length is ==>"+contentLength);
	        	 if(Integer.parseInt(contentLength)<100)
	        		 
	        	 logger.warn( "Content Length is less than 100");
	        	 Assert.assertTrue(Integer.parseInt(contentLength)<1500);
	        	 
	        	 
	         }
	         
	         @Test
	         void checkServerType() {
	        	 logger.info("********Checking Server Type*******");
	        	 String serverType=response.header("Server");
	        	 logger.info("Server Type is ==>"+serverType);
	        	 Assert.assertEquals(serverType,"cloudflare");
	        	 
	        	 
	         }
	         @Test
	         void checkContentEncoding() {
	        	 logger.info("********Checking Content Encoding*******");
	        	 String contentEncoding=response.header("Content-Encoding");
	        	 logger.info("Content Encodinge is ==>"+contentEncoding);
	        	 Assert.assertEquals(contentEncoding,"gzip");
	        	 
	        	 
	         }
	        
	         
	        
	         @AfterClass
	         void tearDown() {
	        	  logger.info("********Finished TC002_GET_Single_Employees_Data*******");
	        	
	         }
	         
}


