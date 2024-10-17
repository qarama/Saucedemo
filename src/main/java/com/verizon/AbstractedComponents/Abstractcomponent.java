package com.verizon.AbstractedComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.verizon.page.Saucedemo.CheckoutPage;

public class Abstractcomponent {
	
WebDriver driver;

public Abstractcomponent(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
@FindBy(css=".shopping_cart_link")
WebElement carticon;

public CheckoutPage goToCart()
{
	carticon.click();
	CheckoutPage checkoutPage=new CheckoutPage(driver);
	return checkoutPage;
}

}
