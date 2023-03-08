package pageObjects;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import junit.framework.Assert;

public class AddcustomerPage {
public WebDriver ldriver;
public AddcustomerPage(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(ldriver, this);
	
}
By lnkCustomers_menu=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
By lnkCustomers_menuitem=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
By btnAddNew=By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
By txtEmail=By.xpath("//*[@id=\"Email\"]");
By txtPassword=By.xpath("//*[@id=\"Password\"]");
By txtcustomerRoles=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
By lstitemAdminstrators=By.xpath("//li[contains(text(),'Administrators')]");
By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
By drpmgrOfVendor=By.xpath("//*[@id=\"VendorId\"]");
By rdMaleGender=By.id("Gender_Male");
By rdFemaleGender=By.id("Gender_Female");
By txtFirstName=By.xpath("//*[@id=\"FirstName\"]");
By txtLastName=By.xpath("//*[@id=\"LastName\"]");
By txtDob=By.xpath("//*[@id=\"DateOfBirth\"]");
By txtCompanyName=By.xpath("//*[@id=\"Company\"]");
By txtAdminContent=By.xpath("//*[@id=\"AdminComment\"]");
By btnSave=By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");


//Actions Method


public String getPageTitle()
{
	return ldriver.getTitle();
}


public void clickOnCustomersMenu() {
	ldriver.findElement(lnkCustomers_menu).click();
}

public void clickOnCustomersMenuItem() {
	ldriver.findElement(lnkCustomers_menuitem).click();
}
public void clickOnAddNew()
{
	ldriver.findElement(btnAddNew).click();

}
public void setEmail(String email)
{
	ldriver.findElement(txtEmail).sendKeys(email);
	
}
public void setPassword(String password)
{
	ldriver.findElement(txtPassword).sendKeys(password);
}

public void unselect() throws InterruptedException
{
	ldriver.findElement(By.xpath("//span[@title='delete']")).click();
	Thread.sleep(2000);
}
  
 

public void setCustomerRoles(String role) throws InterruptedException
{
	
	
	
	
	  if(!role.equals("Vendors")) {
	  
	  
	  ldriver.findElement(By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div"));
	  
	  
	  }
	 
	 
	
	
	ldriver.findElement(txtcustomerRoles).click();
	 WebElement listitem;
	  
	
	Thread.sleep(3000);
	if(role.equals("Administrators"))
	{
		listitem=ldriver.findElement(lstitemAdminstrators);
		}
	else if(role.equals("Guests"))
	{
		listitem=ldriver.findElement(lstitemGuests);
		
	}
	else if(role.equals("Registered"))
	{
		listitem=ldriver.findElement(lstitemRegistered);
		
	}
	else if(role.equals("Vendors"))
	{
		listitem=ldriver.findElement(lstitemVendors);
		
	}
	else
	{
		listitem=ldriver.findElement(lstitemGuests);
	
	}
	
	listitem.click();
	
	//JavascriptExecutor js=(JavascriptExecutor)ldriver;
	//js.executeScript("arguments[0].click();", listitem);
	

}

public void setManagerOfVendor(String value)
{
	Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
	drp.selectByVisibleText(value);
}
public void setGender(String gender)
{
	if(gender.equals("Male")) {
		ldriver.findElement(rdMaleGender);
		
	}
	else if(gender.equals("Female"))
	{
		ldriver.findElement(rdFemaleGender);
	}
	else
	{
		ldriver.findElement(rdMaleGender).click();//default
	}
}

public void setFirstName(String fname)
{
	ldriver.findElement(txtFirstName).sendKeys(fname);;
}

public void setLastName(String lname)
{
	ldriver.findElement(txtLastName).sendKeys(lname);;
}
public void setDob(String dob)
{
	ldriver.findElement(txtDob).sendKeys(dob);
}
public void setCompanyName(String comname)
{
	ldriver.findElement(txtCompanyName).sendKeys(comname);
	
}
public void setAdminContent(String content)
{
	ldriver.findElement(txtAdminContent).sendKeys(content);
}
public void clickonSave()
{
	ldriver.findElement(btnSave).click();
}















}
