package PageObject;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.utilities.RestUtility;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_Delete_Record extends TestBase 

         {
	
	  RequestSpecification httpRequest;
	   Response response;
	   
	         @BeforeClass
	         void deleteEmployee() throws InterruptedException{
	        	 
	        	 logger.info("********Started TC005_DELETE__Record*******");
	        	 
	        	 RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	        	 httpRequest=RestAssured.given();
	        	 
	        	 response =httpRequest.request(Method.GET,"/employees");
	        	 
	        	 JsonPath jsonPathEvaluator=response.jsonPath();
	        	 
	        	 //capture id
	        	 String empID=jsonPathEvaluator.get("[0].id");
	            response =httpRequest.request(Method.DELETE,"/delete/"+empID);
	     		
	     		
	        	 
	        	 Thread.sleep(5000);
	     		
	     		
	     		
	     }
	         @Test
	         void checkResponseBody() {
	        	 
	        	 String responseBody=response.getBody().asString();
	        	 
	        	 Assert.assertEquals(responseBody.contains("successfully! deleted Records"),true);

	         }
	         
	         
	         
	         @Test
	         void checkStatusCode() {
	        	
	        	 int statusCode=response.getStatusCode();
	        	
	        	 Assert.assertEquals(statusCode,200);
	        	 
	        	 
	         }
	         
	         @Test
	         void checkResponseTime() {
	        	 
	        	 long responseTime=response.getTime();
	        	
	        	 Assert.assertTrue(responseTime<6000);
	        	 
	        	 
	         }
	         
	         @Test
	         void checkStatusLine() {
	        	
	        	 String statusLine=response.getStatusLine();
	        	 logger.info("Satus Line is ==>"+statusLine);
	        	 
	        	 
	        	 
	         }
	         
	         @Test
	         void checkContentType() {
	        	
	        	 String contentType=response.getContentType();
	        	 logger.info("Content Type is ==>"+contentType);
	        	
	        	 
	        	 
	         }
	         
	        
	         
	         @Test
	         void checkServerType() {
	        	
	        	 String serverType=response.header("Server");
	        	
	        	 Assert.assertEquals(serverType,"nginx");
	        	 
	        	 
	         }
	         @Test
	         void checkContentEncoding() {
	        	
	        	 String contentEncoding=response.header("Content-Encoding");
	        	 
	        	 Assert.assertEquals(contentEncoding,"gzip");
	        	 
	        	 
	         }
	        
	         
	        
	         @AfterClass
	         void tearDown() {
	        	  logger.info("********Finished TC005_DELETE__Record_Data*******");
	        	
	         }
	         
	         
	         
	         
	         
	         
	         
	         
	         
	         
	         
	         
	         
         }

