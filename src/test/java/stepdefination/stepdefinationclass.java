package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.hooksclass;
import junit.framework.Assert;

public class stepdefinationclass {
	
	WebDriver driver = hooksclass.driver;
	
	@Given("User navigated to the Login page")
	public void user_navigated_to_the_Login_page() {
	    // Login to portal
		driver.get("http://retailm1.upskills.in/admin/index.php?route=common/dashboard&token=fOtazgcSDn3hST8dy4F1RPyPR15xQsnO");
		driver.manage().window().maximize();
		    
	}

	@Given("Enter Username {string} and password {string}")
	public void enter_Username_and_password(String username, String password) {
	    // Enter username and password for login
		System.out.println(password);
	    driver.findElement(By.id("input-username")).sendKeys(username);
	    driver.findElement(By.id("input-password")).sendKeys(password);
	}

	@Then("User should be able to login")
	public void user_should_be_able_to_login() {
	    // Click on Login Button
		driver.findElement(By.xpath("//button[text()=' Login']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Dashboard']")));
		}



	

}
