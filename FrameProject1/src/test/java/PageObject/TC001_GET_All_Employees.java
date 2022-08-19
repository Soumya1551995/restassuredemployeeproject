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

public class TC001_GET_All_Employees extends TestBase 

         {
	         @BeforeClass
	         void getAllEmployees() throws InterruptedException{
	        	 
	        	 logger.info("********Started GET_All_Employees*******");
	        	 
	        	 RestAssured.baseURI="http://dummy.restapiexample.com/";
	        	 httpRequest=RestAssured.given();
	        	 response=httpRequest.request(Method.GET,"/employees");
	        	 
	        	 Thread.sleep(3000);
	     		
	     		
	     		
	     }
	         
	         @Test
	         void checkResponseBody() {
	        	 logger.info("********Checking Response Body*******");
	        	 String responseBody=response.getBody().asString();
	        	 logger.info("Response Body ==>"+responseBody);
	        	 Assert.assertTrue(responseBody!=null);
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
	        	 Assert.assertTrue(responseTime>2000);
	        	 
	        	 
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
	        	 Assert.assertEquals(contentType,"text/html; charset=UTF-8");
	        	 
	        	 
	         }
	         
	         @Test
	         void checkContentLength() {
	        	 logger.info("********Checking Content Length*******");
	        	 String contentLength=response.header("Caontent-Length");
	        	 logger.info("Content Length is ==>"+contentLength);
	        	 if(Integer.parseInt(contentLength)<100)
	        		 
	        	 logger.warn( "Content Length is less than 100");
	        	 Assert.assertTrue(Integer.parseInt(contentLength)>100);
	        	 
	        	 
	         }
	         
	         @Test
	         void checkServerType() {
	        	 logger.info("********Checking Server Type*******");
	        	 String serverType=response.header("Server");
	        	 logger.info("Server Type is ==>"+serverType);
	        	 Assert.assertEquals(serverType,"nginx");
	        	 
	        	 
	         }
	         @Test
	         void checkContentEncoding() {
	        	 logger.info("********Checking Content Encoding*******");
	        	 String contentEncoding=response.header("Content-Encoding");
	        	 logger.info("Content Encodinge is ==>"+contentEncoding);
	        	 Assert.assertEquals(contentEncoding,"gzip");
	        	 
	        	 
	         }
	        
	         
	         @Test
	         void checkCookies() {
	        	 logger.info("********Checking Cookies*******");
	        	 String cookie=response.getCookie("PHPSESSID");
	         }
	         
	         @AfterClass
	         void tearDown() {
	        	  logger.info("********Finished TC001_GET_All_Employees*******");
	        	
	         }
	         
}


