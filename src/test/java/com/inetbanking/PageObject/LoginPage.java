package com.inetbanking.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	By userid = By.xpath("//input[@name='uid']");
	By password = By.xpath("//input[@name='password']");
	By login_button = By.xpath("//input[@name='btnLogin']");
	By logout_button = By.xpath("//a[contains(text(),'Log out')]");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void setuserid(String username)
	{
		driver.findElement(userid).sendKeys(username);
	}
	
	public void setpassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickbutton()
	{
		driver.findElement(login_button).click();
	}
	
	public void clicklogout_button()
	{
		WebElement element = driver.findElement(logout_button);
		element.click();
	}

}
