package com.inetbanking.Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
//import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.LoginPage;

public class TC_001_Logintest extends BaseClass {
	
	
	@Test
	
	public void logintest() throws IOException
	{
		
		
        logger.info("Enter URL");
		
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setuserid(UserID);
		logger.info("Enter Username");
		
		lp.setpassword(PED);
		logger.info("Enter PW");
		lp.clickbutton();
		
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}
		else
		{

			captureScreen( driver,"logintest");
			Assert.assertTrue(false);
			logger.info("Test Case Failed");
			
		}
	}

}
