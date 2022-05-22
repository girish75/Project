package IBM_FST.PetStore;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Excel.ExcelHelper;
import groovyjarjarantlr.collections.List;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;

public class testClass {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI ="http://localhost:3000/";

	}
	
	@DataProvider (name = "RequestData")
	public Object[][] datasource() throws IOException{
		
		Object[][] data= new Object[1][5];
		data[0][0] = "Dataprovider Name1";
		data[0][1] = "First Name1";
		data[0][2] = "Last Name1";
		data[0][3] = "Password Name1";
		data[0][4] = 20;

		return ExcelHelper.reader(".\\src\\test\\java\\resources\\TestData.xlsx","Users");
		
	}
	
	@Test(dependsOnMethods = "postUsers")
	public void getUsers(ITestContext obj) {
			
		String id = (String) obj.getAttribute("id");
		given()
			.get("/users/"+id) 
			.then()
				.statusCode(200)
				.log().all();
		
					
	}
	
	@Test
	public void postUsers(ITestContext obj) {
		
		String body="{\"username\":\"RestAPINAme\",\"firstname\":\"Test\",\"lastname\":\"user\",\"password\":\"readyAPI\",\"age\":25}";
		System.out.println(body);
		Response response =	given()
			// 2 ways to define content type:
			//.contentType(ContentType.JSON)
			.header("content-type","application/json")
			.body(body)
			
		.when()
				.post("/users")
				
		.then()
				.statusCode(201)
				.log().all()
				
			.extract().response();
		
		String id = response.jsonPath().getString("id");
		
		System.out.println(response.toString());

		obj.setAttribute("id", id);
	}
	
	@Test
	public void postUsers_googlejson_request(ITestContext obj) {
		

		JSONObject jsonBody = new JSONObject();
		
		jsonBody.put("username", "RestAPINAme");
		jsonBody.put("firstname", "Test");
		jsonBody.put("lastname", "user");
		jsonBody.put("password", "readyAPI");
		jsonBody.put("age", 21);
		
		//Nested JSON Body
		/*
		 * JSONObject parent = new JSONObject();
		 * 
		 * //category object JSONObject category = new JSONObject();
		 * category.put("user", "rest"); category.put("prefix", "Ms");
		 * 
		 * //tags array JSONObject tags = new JSONObject(); tags.put("id", "1");
		 * tags.put("name","name1");
		 * 
		 * JSONArray tagsArray = new JSONArray(); tagsArray.add(tags);
		 * 
		 * //photo URLs array JSONArray photoUrls = new JSONArray();
		 * photoUrls.add("url1"); photoUrls.add("url2");
		 * 
		 * //adding array and objects to parent parent.put("username", "RestAPINAme");
		 * parent.put("category", category); parent.put("tags", tagsArray);
		 * parent.put("photoUrls", photoUrls);
		 */

		
		System.out.println(jsonBody.toJSONString());

		Response response =	given()
			// 2 ways to define content type:
			//.contentType(ContentType.JSON)
			.header("content-type","application/json")
			.body(jsonBody.toJSONString())
			
			//add Query Param
			//.when().queryParam("", "").queryParam("", "").post("/users")
		.when()
				.post("/users")
				
		.then()
				.statusCode(201)
				.log().all()
				
			.extract().response();
		
		String id = response.jsonPath().getString("id");
		
		System.out.println(id);
		
		obj.setAttribute("id", id);
	}
	
	@Test(dataProvider = "RequestData")
	public void postUsersWithDataProvider(String username,String firstname,
			String lastname,String password,int age,ITestContext obj) {
		
		
		JSONObject jsonBody = new JSONObject();
		
		jsonBody.put("username", username);
		jsonBody.put("firstname", firstname);
		jsonBody.put("lastname", lastname);
		jsonBody.put("password", password);
		jsonBody.put("age", age);
		
		Response response =	given()
			// 2 ways to define content type:
			//.contentType(ContentType.JSON)
			.header("content-type","application/json")
			.body(jsonBody.toJSONString())
			
		.when()
				.post("/users")
				
		.then()
				.statusCode(201)
				.log().all()
				
			.extract().response();
		
		String id = response.jsonPath().getString("id");
		
		System.out.println(id);
		
		obj.setAttribute("id", id);
	}
}
