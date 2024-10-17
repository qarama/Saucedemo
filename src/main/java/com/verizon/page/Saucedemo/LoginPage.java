package com.verizon.page.Saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);	
		
	}
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;	
	
	@FindBy(css="#login-button")
	WebElement login;
	
	
	
public LandingPage login(String Username,String Password)
{
	username.sendKeys(Username);
	password.sendKeys(Password);
	login.click();
LandingPage landingPage=new LandingPage(driver);
return landingPage;
}

public void goToWeb()
{
	driver.get("https://www.saucedemo.com/");	
}
}
