package com.verizon.page.Saucedemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.verizon.AbstractedComponents.Abstractcomponent;

public class LandingPage extends Abstractcomponent 
{
WebDriver driver;

public LandingPage(WebDriver driver) {
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}


 @FindBy(css="div[class*='description'] a div") 
  List<WebElement> productItemList;
 
 @FindBy(css="div[class*='description'] button") 
 WebElement addCart;
 
By itemName=By.cssSelector("div[class*='description'] a div");
By addToCart=By.cssSelector("div[class*='description'] button");

public List<WebElement> getProductList()
{
	System.out.println(productItemList.getFirst());
    
	return productItemList;
}

public CartPage addProductToCart(String productName)
{
	  for (int i = 0; i < productItemList.size(); i++) {
	  if(productItemList.get(i).getText().equals(productName)) {
	  addCart.click();
	  break; 
	  }
}
	  CartPage cartPage=new CartPage(driver);
	  return cartPage;
}

}


