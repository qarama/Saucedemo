package com.verizon.components;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.verizon.page.Saucedemo.LandingPage;
import com.verizon.page.Saucedemo.LoginPage;

public class BaseTest {

	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {
		FileInputStream fis = new FileInputStream(
				"E:\\Eclipse Work\\Saucedemo\\src\\main\\java\\com\\verizon\\Resources\\Globaldata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		if (prop.getProperty("browserName").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Java & Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("browserName").equals("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (prop.getProperty("browserName").equals("edge")) {
			driver = new EdgeDriver();
		}
		return driver;

	}

	public LandingPage launchApplication(String username, String password) throws IOException {
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goToWeb();
		LandingPage landingPage = loginPage.login(username, password);
		return landingPage;
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
