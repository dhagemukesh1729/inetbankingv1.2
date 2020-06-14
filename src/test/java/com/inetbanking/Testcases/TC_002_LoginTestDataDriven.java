package com.inetbanking.Testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.LoginPage;
import com.inetbanking.Utilities.XLUtils;

import junit.framework.Assert;

public class TC_002_LoginTestDataDriven extends BaseClass {
	
	@Test(dataProvider= "LoginData")
	
	public void loginDataDriven(String unmae,String pwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setuserid(unmae);
		logger.info("User ID Provided");
		
		lp.setpassword(pwd);
		logger.info("Password is provided");
		
		lp.clickbutton();
		logger.info("Clicked on Login Button");
		
		if(isAltertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("InCorrect Credentials");
		}
		
		else
		{
			Assert.assertTrue(true);
			
			lp.clicklogout_button();
			logger.info("Clocked on Logout Button");
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept();
			
			driver.switchTo().defaultContent();
		}
		
	}
	
	/*public boolean isAltertPresent()
	{
		try {
			
			driver.switchTo().alert().accept();
			return true;
			
		} catch (Exception e) {
			return false;	
		}*/
		
	
	
	@DataProvider(name= "LoginData")
	String[][] getData() throws IOException
	{
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/TestData/LoginData.xlsx";
		int rowcount = XLUtils.getRowCount(path, "sheet1");
		int colcount = XLUtils.getCellCount(path, "sheet1", 1);
		
		String logindata[][]= new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]= XLUtils.getCellData(path,"sheet1", i, j);
			}
		}
		return logindata;
	}
	

}
