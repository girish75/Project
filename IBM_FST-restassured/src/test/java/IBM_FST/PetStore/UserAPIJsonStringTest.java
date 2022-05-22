package IBM_FST.PetStore;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Excel.ExcelHelper;
import IBM_FST.Restassured_Project.BaseTest;
import IBM_FST.Restassured_Project.Method;
import IBM_FST.Restassured_Project.RequestBuilder;
import IBM_FST.Restassured_Project.ResponseValidation;
import io.restassured.response.Response;

public class UserAPIJsonStringTest extends BaseTest{

	
	@DataProvider (name = "RequestData")
	public Object[][] datasource() throws IOException{
		
		return ExcelHelper.reader(TEST_DATA_FILE_NAME,"UsersAPI_String");
		
	}
	@Test(dataProvider = "RequestData")
	public void postUsers(ITestContext obj,String postRequest,String getRequest,String putRequest,String deleteRequest,
			String username,String postBody,String putBody,int expectedStatusCode) {
		
		
		postBody=postBody.replaceAll("\\\\\"", "\"").replaceAll("\\\\n", "\n");

		Response response = requestBuilder.request(postRequest, Method.POST, null, null, postBody);
		
		String id = response.jsonPath().getString("message");
	
		Reporter.log("Response :\n"+response.asPrettyString(),true);

		ResponseValidation.statusCode(expectedStatusCode,response.getStatusCode() );
		ResponseValidation.responseBody(response.getBody().jsonPath(), "code",expectedStatusCode);
		ResponseValidation.responseBody(response.getBody().jsonPath(), "type","unknown");

		obj.setAttribute("id", id);

	}
	
	@Test(dependsOnMethods = "postUsers",dataProvider = "RequestData")
	public void getUsers(ITestContext obj,String postRequest,String getRequest,String putRequest,String deleteRequest,
			String username,String postBody,String putBody,int expectedStatusCode) {
		Reporter.log("User API Get");

		Map<String,String> pathParam = new HashMap<String, String>();
		pathParam.put("username", "CreatedUser");

		Response response = requestBuilder.request("/user/{username}", Method.GET, pathParam, null, null);
		
		obj.setAttribute("username", response.jsonPath().getString("username"));
		ResponseValidation.statusCode(expectedStatusCode,response.getStatusCode() );
		
		Reporter.log("Response :\n"+response.asPrettyString(),true);

		ResponseValidation.responseBody(response.getBody().jsonPath(), "username","CreatedUser");
		ResponseValidation.responseBody(response.getBody().jsonPath(), "firstName","Prithiga");
		ResponseValidation.responseBody(response.getBody().jsonPath(), "email","prithiga@gmail.com");
		
	}
	@Test(dependsOnMethods = "getUsers",dataProvider = "RequestData")
	public void putUsers(ITestContext obj,String postRequest,String getRequest,String putRequest,String deleteRequest,
			String username,String postBody,String putBody,int expectedStatusCode) {
		
		Reporter.log("User API Put");

		Map<String,String> pathParam = new HashMap();
		pathParam.put("username", (String) obj.getAttribute("username"));
		putBody=putBody.replaceAll("\\\\\"", "\"").replaceAll("\\\\n", "\n");
		Reporter.log(putBody,true);
		
		Response response = requestBuilder.request(putRequest, Method.PUT, pathParam, null, putBody);
		String id = response.jsonPath().getString("message");
	
		obj.setAttribute("id", id);
		Reporter.log("Response :\n"+response.asPrettyString(),true);

		ResponseValidation.statusCode(expectedStatusCode,response.getStatusCode() );
		ResponseValidation.responseBody(response.getBody().jsonPath(), "code",expectedStatusCode);
		ResponseValidation.responseBody(response.getBody().jsonPath(), "type","unknown");
					
	}
	
	@Test(dependsOnMethods = "putUsers",dataProvider = "RequestData")
	public void deleteUsers(ITestContext obj,String postRequest,String getRequest,String putRequest,String deleteRequest,
			String username,String postBody,String putBody,int expectedStatusCode) {
		

		String id = (String) obj.getAttribute("id");
		
		Map<String,String> pathParam = new HashMap();
		pathParam.put("username", (String) obj.getAttribute("username"));
		Response response = requestBuilder.request(deleteRequest, Method.DELETE, pathParam, null, null);
		Reporter.log("Response :\n"+response.asPrettyString(),true);

		ResponseValidation.statusCode(expectedStatusCode,response.getStatusCode() );

					
	}
}
