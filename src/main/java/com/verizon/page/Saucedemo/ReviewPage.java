package com.verizon.page.Saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage 
{
	WebDriver driver;

	public ReviewPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
@FindBy(id="finish")	
WebElement finishButton;

public ConfirmationPage reviewOrder()
{
finishButton.click();
ConfirmationPage confirmationPage=new ConfirmationPage(driver);
return confirmationPage;
}

}
