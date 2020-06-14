package com.inetbanking.Testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.inetbanking.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	public String URL = readconfig.getApplicationURL();
	public String UserID= readconfig.getUserID();
	public String PED=readconfig.getpassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	
	public void setup(String br)
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
		
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getIEdriverpath());
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		
		
		driver.get(URL);
	}
	
	@AfterClass
	
	public void teardown()
	{
		driver.close();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
	public boolean isAltertPresent()
	{
		try {
			
			driver.switchTo().alert().accept();
			return true;
			
		} catch (Exception e) {
			return false;	
		}
}
}
