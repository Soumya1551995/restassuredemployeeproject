package PageObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DownloadAPI {
     
	public static void main(String[] args) throws IOException{
		
	Response response=	RestAssured.given().when().get("https://reqres.in/api/users").andReturn();
		
		byte[] bytes=response.getBody().asByteArray();
		File file= new File( "/users/promode/Downloadsd/promode.json");
	     Files.write(file.toPath(), bytes);
	}
	
}
