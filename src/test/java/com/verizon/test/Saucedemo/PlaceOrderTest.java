package com.verizon.test.Saucedemo;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.verizon.components.BaseTest;
import com.verizon.page.Saucedemo.CartPage;
import com.verizon.page.Saucedemo.CheckoutPage;
import com.verizon.page.Saucedemo.ConfirmationPage;
import com.verizon.page.Saucedemo.LandingPage;
import com.verizon.page.Saucedemo.ReviewPage;

public class PlaceOrderTest extends BaseTest{

	WebDriver driver;
	LandingPage landingpage;
	CheckoutPage checkoutPage;
	ReviewPage reviewPage;
	ConfirmationPage confirmationPage;
	@Test(dataProvider = "getData")
	public void PlaceOrder(String username,String password,String itemName) throws Exception {
		landingpage=launchApplication(username, password);
		CartPage cartPage=landingpage.addProductToCart(itemName);
		checkoutPage=landingpage.goToCart();
		cartPage.verifyCartItem(itemName);
		reviewPage=checkoutPage.checkountInfo();
		confirmationPage=reviewPage.reviewOrder();
		Assert.assertEquals(confirmationPage.getConformMessage(), "Thank you for your order!");
	}
	
	
@DataProvider(name = "getData")
public Object[][] getData()
{
	
	Object[][] data= {{"standard_user","secret_sauce","Sauce Labs Backpack"},{"standard_user","secret_sauce","Sauce Labs Bike Light"}};
	return data;		
}
}
