package com.inetbanking.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomer {
	
	WebDriver driver;
	
	By linknew_customer = By.xpath("//a[contains(text(),'New Customer')]");
	By txtcustomer_name = By.xpath("//input[@name='name']");
	By selectgender = By.xpath("//tr[5]//td[2]//input[1]");
	By txtdob = By.xpath("//input[@id='dob']");
	By txtaddress = By.xpath("//textarea[@name='addr']");
	By txtcity = By.xpath("//input[@name='city']");
	By txtstate = By.xpath("//input[@name='state']");
	By txtpin = By.xpath("//input[@name='pinno']");
	By txtmobilno = By.xpath("//input[@name='telephoneno']");
	By txtemail = By.xpath("//input[@name='emailid']");
	By txtpassword = By.xpath("//input[@name='password']");
	By clicksubmit = By.xpath("//input[@name='sub']");
	By clickreset = By.xpath("//input[@name='res']");
	
	public AddCustomer(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void linknew_customer()
	{
		driver.findElement(linknew_customer).click();
	}
	
	public void txtcustomer_name(String txtcustname)
	{
		driver.findElement(txtcustomer_name).sendKeys(txtcustname);
	}
	
	public void txtdob(String dd,String mm)
	{
		driver.findElement(txtdob).sendKeys(dd);
		driver.findElement(txtdob).sendKeys(mm);
		//driver.findElement(txtdob).sendKeys(yyyy);
	}
	
	public void txtdob(String yyyy)
	{
		//driver.findElement(txtdob).sendKeys(dd);
		//driver.findElement(txtdob).sendKeys(mmm);
		driver.findElement(txtdob).sendKeys(yyyy);
	}
	
	public void txtaddress(String address)
	{
		driver.findElement(txtaddress).sendKeys(address);
	}
	
	public void txtcity(String city)
	{
		driver.findElement(txtcity).sendKeys(city);
	}
	
	public void txtstate(String state)
	{
		driver.findElement(txtstate).sendKeys(state);
	}
	
	public void txtpin(String pin)
	{
		driver.findElement(txtpin).sendKeys(pin);
	}
	
	public void txtmobile(String mobile)
	{
		driver.findElement(txtmobilno).sendKeys(mobile);
	}
	
	public void txtemail(String mail)
	{
		driver.findElement(txtemail).sendKeys(mail);
	}
	
	public void txtpassword(String pwd)
	{
		driver.findElement(txtpassword).sendKeys(pwd);
	}
	
	public void clicksumbit()
	{
		driver.findElement(clicksubmit).click();
	}
	
	public void clickreset()
	{
		driver.findElement(clickreset).click();
		
	}
	
	public void selectgender()
	{
		driver.findElement(selectgender).click();
	}
	
	
}
