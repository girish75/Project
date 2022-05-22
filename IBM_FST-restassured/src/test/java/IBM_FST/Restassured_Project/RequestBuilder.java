package IBM_FST.Restassured_Project;

import java.util.Map;

import org.testng.annotations.Optional;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

	RequestSpecBuilder reqBuilder =null;
	public RequestBuilder(String url){
		reqBuilder = new RequestSpecBuilder();
		reqBuilder.setBaseUri(url);
		
	}
	
	public Response request(String path, Method method,@Optional Map<String,String> pathParam, 
			@Optional Map<String,String> queryParam, @Optional String body) {
		
		Response response = null;
		reqBuilder.setBasePath(path);
		RequestSpecification reqSpec;
		
		if(pathParam!=null)
		pathParam.forEach((k,v) -> reqBuilder.addPathParam(k, v));
		
		if(queryParam!=null)
		queryParam.forEach((k,v) -> reqBuilder.addQueryParam(k, v));
		
		switch(method) {
		
		case GET:
			reqSpec= reqBuilder.build();
			response = RestAssured.given().spec(reqSpec).get();
			break;
			
		case POST:
			reqBuilder.setContentType(ContentType.JSON).setBody(body);
			reqSpec = reqBuilder.build();
			response =RestAssured.given().spec(reqSpec).post();
			break;
			
		case PUT:
			reqBuilder.setContentType(ContentType.JSON).setBody(body);
			reqSpec = reqBuilder.build();
			response = RestAssured.given().spec(reqSpec).put();
			break;
			
		case DELETE:
			reqSpec= reqBuilder.build();
			response =RestAssured.given().spec(reqSpec).delete();
			break;
			
		case PATCH:
			reqBuilder.setContentType(ContentType.JSON).setBody(body);
			reqSpec = reqBuilder.build();
			response = RestAssured.given().spec(reqSpec).patch();
			break;
			
		 default:
			 System.out.println("Method " +method+ " implementation not found");
		
		
		}
		
		
		
		return response;
		
	}
	
	
}
