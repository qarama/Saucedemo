package com.verizon.page.Saucedemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage 
{

WebDriver driver;

public CartPage(WebDriver driver) {
this.driver=driver;
PageFactory.initElements(driver, this);
}

@FindBy(css=".cart_item a div")
List<WebElement> cartItems;

@FindBy(id="checkout")
WebElement checkout;

public List<WebElement> getCartItemList() 
{
	
	return cartItems;
}


public CheckoutPage verifyCartItem(String itemName) {
	Boolean match =cartItems.stream().anyMatch(CartItem -> CartItem.getText().contains(itemName));
	System.out.println(match);
	checkout.click();
	
CheckoutPage checkoutPage=new CheckoutPage(driver);
return checkoutPage;
}
	
}
