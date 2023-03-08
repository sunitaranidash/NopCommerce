package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
//import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	//object for customerpage class
	public AddcustomerPage addCust;
	public SearchCustomerPage searchCust;
	public static Logger logger;
	public Properties configProp;
	//generate random string
	public static String randomString()
	{
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return(generatedString1);
	}
}
