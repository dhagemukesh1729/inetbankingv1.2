package com.inetbanking.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditCustomer {
	
	WebDriver driver;
	
	By link_editcustomer = By.xpath("//a[contains(text(),'Edit Customer')]");
	By txtcus_id = By.xpath("//input[@name='cusid']");
	By button_submit = By.xpath("//input[@name='AccSubmit']");
	By txtemail = By.xpath("//input[@name='emailid']");
	By buttonSubmit_edit = By.xpath("//input[@name='sub']");
	By logout_button = By.xpath("//a[contains(text(),'Log out')]");
	
	public EditCustomer(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void link_editcustomer()
	{
		driver.findElement(link_editcustomer).click();
	}
	
	public void txtcust_id(String txtcust_id)
	{
		driver.findElement(txtcus_id).sendKeys(txtcust_id);;
	}
	
	public void submit_button1()
	{
		driver.findElement(button_submit).click();
	}
	
	public void editemail(String mail)
	{
		driver.findElement(txtemail).clear();
		driver.findElement(txtemail).sendKeys(mail);
	}
	
	public void editsubmit_button()
	{
		driver.findElement(buttonSubmit_edit).click();
	}
	
	public void logout()
	{
		driver.findElement(logout_button).click();
	}

}
