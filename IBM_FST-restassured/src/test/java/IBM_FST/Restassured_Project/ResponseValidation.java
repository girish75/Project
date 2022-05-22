package IBM_FST.Restassured_Project;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Reporter;

import io.restassured.path.json.JsonPath;

public class ResponseValidation {

	
	public static void statusCode(int expected,int actual) {
		
		assertEquals(actual,expected);
		Reporter.log("Expected Status code : "+expected +" Actual Status code : "+actual,true);	
		
	}
	
	
	public static void responseBody(JsonPath jsonbody,String path, int value) {
		
		 
		assertEquals(jsonbody.getInt(path), value,"Expected Response Value : "+value+
				" Actual Response value : "+jsonbody.get(path));
		Reporter.log("Expected Response Value : "+value+
				" Actual Response value : "+jsonbody.get(path),true);	

	}
	
	public static void responseBody(JsonPath jsonbody,String path, String value) {
		
		 
		assertEquals(jsonbody.getString(path), value,"Expected Response Value : "+value+
				" Actual Response value : "+jsonbody.get(path));
		Reporter.log("Expected Response Value : "+value+
				" Actual Response value : "+jsonbody.get(path),true);	

	}
}
