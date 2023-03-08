package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver ldriver;
public  LoginPage(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(ldriver, this);
	
}
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	
	@CacheLookup
	WebElement btnLogin;
	@FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[3]/a")
	@CacheLookup
	WebElement lnkLogout;
	public void   setUserName(String uname) throws InterruptedException 
	{
		txtEmail.clear();
		Thread.sleep(2000);
		txtEmail.sendKeys(uname);
	}
	public void setPassword(String pwd) throws InterruptedException
	{
		txtPassword.clear();
		Thread.sleep(2000);
		txtPassword.sendKeys(pwd);
		
	}
	public void clickLogin()
	{
		btnLogin.click();
	}
	public void clickLogout()
	{
		lnkLogout.click();
		
	}
}

