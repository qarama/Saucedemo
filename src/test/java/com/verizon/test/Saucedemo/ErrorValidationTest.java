package com.verizon.test.Saucedemo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.verizon.components.BaseTest;
import com.verizon.page.Saucedemo.LandingPage;

public class ErrorValidationTest extends BaseTest{
	
	WebDriver driver;
	
@Test(dataProvider = "getData")
public void errorValidate(String username, String password) throws IOException
{
	launchApplication(username,password);
}

@DataProvider(name = "getData")
public Object[][] getData()
{
	
	Object[][] data= {{"standard_user1","secret_sauce"},{"locked_out_user","secret_sauce"}};
	return data;		
}
}
