package IBM_FST.Restassured_Project;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	protected RequestBuilder requestBuilder;
	public static String TEST_DATA_FILE_NAME;
	@BeforeSuite
	public void setupSuite() {
		setFileName();
	}
	@BeforeMethod
	public void setup() {
			requestBuilder = new RequestBuilder("https://petstore.swagger.io/v2");
	}
	
	public static void setFileName() {
		TEST_DATA_FILE_NAME=".\\\\src\\\\test\\\\java\\\\resources\\\\TestData.xlsx";
	}
	
}
