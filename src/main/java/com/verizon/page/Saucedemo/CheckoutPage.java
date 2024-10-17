package com.verizon.page.Saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage 
{
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
@FindBy(id="first-name")
WebElement firstname;

@FindBy(id="last-name")
WebElement lastname;

@FindBy(id="postal-code")
WebElement postalcode;

@FindBy(id="continue")
WebElement continueButton;


public ReviewPage checkountInfo()
{
	firstname.sendKeys("rama");
	lastname.sendKeys("das");
	postalcode.sendKeys("60089");
	continueButton.click();
	ReviewPage reviewPage=new ReviewPage(driver);
	return reviewPage;
}
}
