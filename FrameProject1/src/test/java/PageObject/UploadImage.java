package PageObject;

import java.io.File;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UploadImage {

	@Test 
	public void uploadImageTest() {
		RestAssured.baseURI="https://petstore.swagger.io";
		Response response=given().header("Content-Type","multipart/form-data")
		.formParam("additionalMetadata", "Test")
		.multiPart("file",new File("C:\\WIN_20200604_17_11_57_Pro.jpg"),"image/jpeg").when().post("v2/pet/9223372036854109000/uploadImage");
	
		  System.out.println(response.statusCode());
		  System.out.println(response.asPrettyString());
	
	
	
	}
	
	
	
}



