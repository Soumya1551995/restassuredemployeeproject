

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
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_POST_Employee_Record extends TestBase 

         {
	
	  RequestSpecification httpRequest;
	   Response response;
	   String empName=RestUtility.empName();
	   String empSalary=RestUtility.empSal();
	   String empAge=RestUtility.empAge();
	   
	         @BeforeClass
	         void createEmployee() throws InterruptedException{
	        	 
	        	 logger.info("********Started TC003_POST__employees_Record*******");
	        	 
	        	 RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	        	 httpRequest=RestAssured.given();
	        	 
	        	 
	        	 JSONObject requestparam=new JSONObject();
	     		requestparam.put("name",empName);
	     		requestparam.put("salary",empSalary);
	     		requestparam.put("age",empAge);
	     		
	             httpRequest.header("Content-Type","application/json");
	             
	             httpRequest.body(requestparam.toJSONString());
	             
	     		response =httpRequest.request(Method.POST,"/create");
	     		
	     		
	        	 
	        	 Thread.sleep(5000);
	     		
	     		
	     		
	     }
	         @Test
	         void checkResponseBody() {
	        	 logger.info("********Checking Response Body*******");
	        	 String responseBody=response.getBody().asString();
	        	 
	        	 logger.info("Response Body ==>"+responseBody);
	        	 Assert.assertEquals(responseBody.contains(empName),true);
	        	 Assert.assertEquals(responseBody.contains(empSalary),true);
	        	 Assert.assertEquals(responseBody.contains(empAge),true);


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
	        	 Assert.assertEquals(contentType,"application/json");
	        	 
	        	 
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
	        
	        
	        
	        
	         @AfterClass
	         void tearDown() {
	        	  logger.info("********Finished TC003_POST__Employees_Record*******");
	        	
	         }
	         
}





