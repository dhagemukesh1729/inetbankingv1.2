package com.inetbanking.Testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.EditCustomer;
import com.inetbanking.PageObject.LoginPage;

public class TC_004_EditCustomer extends BaseClass {
	
	@Test
	
	public void edit_customer() throws InterruptedException, IOException
	{
		
		LoginPage lp = new LoginPage(driver);
		EditCustomer ec = new EditCustomer(driver);
		
		lp.setuserid(UserID);
		logger.info("User ID provided");
		lp.setpassword(PED);
		logger.info("Password provided");
		lp.clickbutton();
		logger.info("Click on login button");
		
		ec.link_editcustomer();
		logger.info("Edit customer link clicked");
		
		ec.txtcust_id("30622");
		logger.info("Cutomer ID provided");
		
		ec.submit_button1();
		logger.info("Clicked on Submit button");
		
		String edit_mail = randomstring() + "gmail.com";
		
		
		ec.editemail(edit_mail);
		logger.info("Edit email ID");
		
		ec.editsubmit_button();
		logger.info("Clicked on Submit button");
		
		//Thread.sleep(3000);
		
		boolean result = driver.getPageSource().contains("Customer details updated Successfully!!!");
		
		if(isAltertPresent()== true)
		{
			captureScreen(driver, "edit_customer");
			logger.info("Test Case failed");
		}
		
		else 
		{
			logger.info("Customer edited successfully");
			
			WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//lp.clicklogout_button();
			element.click();
			js.executeScript("arguments[0].scrollIntoView();",element);
			
			
			
			/*if(result==true)
			{
				ec.logout();
				logger.info("Clicked on Logout");
				if(isAltertPresent()==true)
				{
					driver.switchTo().alert().accept();
					driver.switchTo().defaultContent();
					logger.info("Logout successfully");
				}
			}*/
			
			
			//Thread.sleep(5000);
		}
			
		
	
		
		
	}
	
	public String randomstring()
	{
		String randomestring = RandomStringUtils.randomAlphabetic(8);
		return(randomestring);
	}

}
