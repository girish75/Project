package IBM_FST.PetStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
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

public class UserApiNegativeTest extends BaseTest {
	@DataProvider (name = "RequestData")
	public Object[][] datasource() throws IOException{
		
		return ExcelHelper.reader(TEST_DATA_FILE_NAME,"UsersAPI_404");
		
	}
	
	@Test(dataProvider = "RequestData")
	public void postUsers(ITestContext obj,String postPath,String getPath,String putPath,String deletePath,
			String username,String postBodyFileName,String putBodyFileName,int expectedStatusCode) throws IOException {
		
		FileInputStream postRequest=new FileInputStream(new File(postBodyFileName));
		String body =IOUtils.toString(postRequest,"UTF-8");
		
		
		Response response = requestBuilder.request(postPath, Method.POST, null, null, body);
		
		Reporter.log("Response :\n"+response.asPrettyString(),true);


		ResponseValidation.statusCode(expectedStatusCode,response.getStatusCode() );

		
	}
	
	@Test(dependsOnMethods = "postUsers",dataProvider = "RequestData")
	public void getUsers(ITestContext obj,String postPath,String getPath,String putPath,String deletePath,
			String username,String postBodyFileName,String putBodyFileName,int expectedStatusCode) throws IOException {
		
		String id = (String) obj.getAttribute("id");
		
		Map<String,String> pathParam = new HashMap();
		//pathParam.put("username", (String) obj.getAttribute("id"));
		pathParam.put("username", username);

		Response response = requestBuilder.request(getPath, Method.GET, pathParam, null, null);
		Reporter.log("Response :\n"+response.asPrettyString(),true);

		ResponseValidation.statusCode(expectedStatusCode,response.getStatusCode() );
		
	}
	@Test(dependsOnMethods = "getUsers",dataProvider = "RequestData")
	public void putUsers(ITestContext obj,String postPath,String getPath,String putPath,String deletePath,
			String username,String postBodyFileName,String putBodyFileName,int expectedStatusCode) throws IOException {
		
		Map<String,String> pathParam = new HashMap();
		pathParam.put("username", username);
		
		FileInputStream putRequest=new FileInputStream(new File(putBodyFileName));
		String body =IOUtils.toString(putRequest,"UTF-8");
		
		Response response = requestBuilder.request(putPath, Method.PUT, pathParam, null, body);
		Reporter.log("Response :\n"+response.asPrettyString(),true);

		ResponseValidation.statusCode(expectedStatusCode,response.getStatusCode() );
	}
	
	@Test(dependsOnMethods = "putUsers",dataProvider = "RequestData")
	public void deleteUsers(ITestContext obj,String postPath,String getPath,String putPath,String deletePath,
			String username,String postBodyFileName,String putBodyFileName,int expectedStatusCode) throws IOException {
		
		
		Map<String,String> pathParam = new HashMap();
		pathParam.put("username", username);
		Response response = requestBuilder.request(deletePath, Method.DELETE, pathParam, null, null);
		Reporter.log("Response :\n"+response.asPrettyString(),true);

		ResponseValidation.statusCode(expectedStatusCode,response.getStatusCode() );

					
	}

}
