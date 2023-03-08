package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//import java.util.Arrays;
import org.junit.Assert;
import org.openqa.selenium.By;


import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;

import pageObjects.AddcustomerPage;
//import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
public class Steps extends BaseClass{
	
	@Before
	public void setup() throws IOException  {
		logger=Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("Log4j.properties");
		configProp=new Properties();
		FileInputStream configPropfile= new FileInputStream("config.properties");
		configProp.load(configPropfile);
		String br=configProp.getProperty("browser");
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
			driver=new FirefoxDriver();
		}
		logger.info("******  Launching Browser ********");
	}
	
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser()  {
	 lp=new LoginPage(driver);
		 
	}
	@When("User opens URL {string}")
	public void user_opens_URL(String url) 
	{
		logger.info("******  Opening URL ********");
		driver.get(url);
		driver.manage().window().maximize();
		//throw new io.cucumber.java.PendingException();
	
		
		
		
	}
	@When("User enters Email as {string} and password as {string}")
	public void user_enters_Email_as_and_Password_as(String email,String password) throws Exception 
	{
		logger.info("******  Providing Login Details ********");
		lp.setUserName(email);
		
		lp.setPassword(password);
		//throw new io.cucumber.java.PendingException();
	}
	@When("Click on Login")
    public void click_on_Login() throws InterruptedException
{
		logger.info("******  Started Login ********");
		lp.clickLogin();
		Thread.sleep(3000);
		//throw new io.cucumber.java.PendingException();
}




	@Then("Page Title should be {string}")
	public void page_Title_Shouldbe(String title) throws InterruptedException 
	{
		if(driver.getPageSource().contains("Login was unsuccessful."))
		{
			driver.close();
			logger.info("******  Login passed ********");
			Assert.assertTrue(false);
		}
		else
		{
			logger.info("******  Login Failed ********");
			Assert.assertEquals(title, driver.getTitle());
		}
	Thread.sleep(3000);	
	}
	@When("User click on Logout link")
	public void user_click_on_Logout_link() throws InterruptedException
	{
		logger.info("******  Click on Logout link ********");
		lp.clickLogout();
		Thread.sleep(3000);
		
	}
	@Then("Close browser")
	public void close_browser()
	{
		logger.info("******  Closing Browser ********");
		driver.quit();
	}
	
	//Customers feature step definitions.........
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	    addCust=new AddcustomerPage(driver);
	    Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}
	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
	   Thread.sleep(3000);
	   addCust.clickOnCustomersMenu();
	}
	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenuItem();
	    
	}
	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		addCust.clickOnAddNew();
		Thread.sleep(3000);
	}
	
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	 Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	 
	}
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		logger.info("******  Adding New Customer ********");
		logger.info("******  Providing Customer Details ********");
		String email=randomString()+"@gmail.com";
		
		addCust.setEmail(email);
		addCust.setPassword("sakh234");
		addCust.unselect();
		addCust.setCustomerRoles("Guests");
		Thread.sleep(3000);
		addCust.setManagerOfVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.setFirstName("Pavan");
		addCust.setLastName("Kumar");
		addCust.setDob("7/05/1985");
		addCust.setCompanyName("QA");
		addCust.setAdminContent("This is for Testing");
		
	}
	@When("click on Save button")
	public void click_on_save_btn() throws InterruptedException
	{
		logger.info("******  Saving Customer data ********");
		addCust.clickonSave();
		Thread.sleep(2000);
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
	}
	
	@Then("close browser")
	public void close_npcom_browser() {
	    driver.quit();
	}
	
	
// Steps for searching customer by emailid
	@When("Enter customer Email")
	public void enter_customer_email() throws InterruptedException {
	  
		logger.info("******  Searching Customer by emailId ********");
		searchCust=new SearchCustomerPage(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
		Thread.sleep(2000);
	}
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
	    searchCust.clickSearch();
	    Thread.sleep(3000);
	}
	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true,status);
	}
	/*
	 * @Then("close browser") public void search_by_email_browser_close() {
	 * driver.quit(); }
	 */

	
	
	//Steps for searching customer by name
	
@When("Enter customer FirstName")
public void enter_customer_first_name() throws InterruptedException {
	logger.info("******  Searching customer by Name ********");
	searchCust=new SearchCustomerPage(driver);
    searchCust.setFirstName("Victoria");
    Thread.sleep(2000);
}
@When("Enter customer LastName")
public void enter_customer_last_name() throws InterruptedException {
	searchCust.setLastName("Terces");
	Thread.sleep(2000);
    
}
@Then("User should found Name in the search table")
public void user_should_found_name_in_the_search_table() {
   boolean status=searchCust.searchCustomerByName("Victoria Terces");
   Assert.assertEquals(true,status);
}
}
