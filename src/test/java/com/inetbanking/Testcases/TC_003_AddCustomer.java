package com.inetbanking.Testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.AddCustomer;
import com.inetbanking.PageObject.LoginPage;

import junit.framework.Assert;

public class TC_003_AddCustomer extends BaseClass {
	
	@Test
	
	public void add_customer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setuserid(UserID);
		logger.info("User ID Provided");
		lp.setpassword(PED);
		logger.info("Password is provided");
		lp.clickbutton();
		logger.info("Clicked on Login Button");
		
		Thread.sleep(3000);
		
		AddCustomer ac = new AddCustomer(driver);
		
		ac.linknew_customer();
		logger.info("Clicked on New Customer Link");
		
		
		logger.info("Filles Customer Information");
		ac.txtcustomer_name("Mukesh");
		ac.selectgender();
		ac.txtdob("29","06");
		
		 Actions act = new Actions(driver);
		   
		   act.sendKeys(Keys.TAB).build().perform();
		 //  act.sendKeys(Keys.RETURN).build().perform();
		   
		ac.txtdob("1987");   
		
		ac.txtaddress("Mumbai");
		ac.txtcity("Mumbai");
		ac.txtstate("Maharashtra");
		ac.txtpin("123456");
		ac.txtmobile("9632587410");
		
		String email = randomstring()+"@gmail.com";
		
		ac.txtemail(email);
		ac.txtpassword("Mukesh@12");
		ac.clicksumbit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test Case Success");
			
	
		}
		
		else
		{
			captureScreen(driver,"add_customer");
			Assert.assertTrue(false);
			logger.info("Test Case Failed");
		}
		
		
	/*	lp.clicklogout_button();
		logger.info("Clocked on Logout Button");
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		driver.switchTo().defaultContent();
		
		logger.info("Logout successfully");*/
	}
	
	
	
	public String randomstring()
	{
		String randomestring = RandomStringUtils.randomAlphabetic(6);
		return(randomestring);
	}

}
