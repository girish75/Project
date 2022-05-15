package stepdefination;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import java.util.UUID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.hooksclass;
import junit.framework.Assert;


public class stepdefinationclass {
	
	WebDriver driver = hooksclass.driver;
	String uuid = "gir" + RandomStringUtils.randomAlphabetic(3); 
	//String var = UUID.randomUUID().toString();
	String changedname, changedcode;
	
			
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

	@When("Click on side menu button")
	public void click_on_side_menu_button() throws InterruptedException {
	    // Click on Side menu button
		//WebDriverWait wait1 = new WebDriverWait(driver,100);
		driver.findElement(By.cssSelector("i.fa.fa-share-alt.fw")).click();
		//WebDriverWait wait2 = new WebDriverWait(driver,100);
		Thread.sleep(3000);
	}

	@When("click on the coupons button")
	public void click_on_the_coupons_button() throws InterruptedException {
	    // Click on the coupons button on the side menu
		//driver.findElement(By.xpath("//li[@id='menu-marketing']//a[text()='Coupons']")).click();
		driver.findElement(By.xpath("//li[@id='menu-marketing']")).click();
	    driver.findElement(By.linkText("Coupons")).click();
	    Thread.sleep(3000);
	}

	@Then("User should be able to navigate to Coupons page")
	public void user_should_be_able_to_navigate_to_Coupons_page() {
	    // Verify that page appear
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Coupons']")));	 
	}

	@Given("User is in the Coupons page and click on Add Coupon button")
	public void user_is_in_the_Coupons_page() {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.xpath("//a[@data-original-title='Add New']")).click();
	}
	
	@When("Add Coupon details and click save")
	public void add_Coupon_details_and_click_save() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
						
		driver.findElement(By.xpath("//input[@id='input-name']")).sendKeys(uuid);
	    driver.findElement(By.xpath("//input[@id='input-code']")).sendKeys(uuid);
	    driver.findElement(By.xpath("//select[@id='input-type']")).sendKeys("Percentage");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(3000);
	}

	@When("Verify the added Coupon")
	public void verify_the_added_Coupon() throws InterruptedException {
	    // Verify the added Coupon
		
		WebElement Couponname = driver.findElement(By.xpath("//td[text()='"+uuid+"']"));
		Assert.assertTrue(Couponname.isDisplayed());
		System.out.println(Couponname);
		 Thread.sleep(3000);
	}

	@When("Click Edit the added Coupon")
	public void click_Edit_the_added_Coupon() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		changedname = uuid + "Changed1";
		changedcode = uuid +"1";
		driver.findElement(By.xpath("//div/table/tbody/tr//td[contains(text(),uuid)]//following-sibling::td[6]/a/i")).click();
		driver.findElement(By.xpath("//input[@id='input-name']")).clear();
		driver.findElement(By.xpath("//input[@id='input-name']")).sendKeys(changedname);
		driver.findElement(By.xpath("//input[@id='input-code']")).clear();
		driver.findElement(By.xpath("//input[@id='input-code']")).sendKeys(changedcode);
		driver.findElement(By.xpath("//select[@id='input-type']")).sendKeys("Percentage");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(5000);
	}

	@When("Verify the Edited coupon in coupon list")
	public void verify_the_Edited_coupon_in_coupon_list() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Couponname = driver.findElement(By.xpath("//td[text()='"+uuid+"']"));
		Assert.assertTrue(Couponname.isDisplayed());
		System.out.println(Couponname + "Edited coupon exist");
		Thread.sleep(3000);
	}

	@When("Delete the coupon")
	public void delete_the_coupon() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(10000);
		driver.findElement(By.xpath("//td[contains(text(),changedname)]//preceding-sibling::td[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@data-original-title='Delete']")).click();
		Thread.sleep(10000);
		driver.switchTo().alert().accept();
	    Thread.sleep(10000);
	}

	@Then("Couple should get deleted")
	public void couple_should_get_deleted() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//div[text()=' Success: You have modified coupons!      ']"));
	        
	}

}

