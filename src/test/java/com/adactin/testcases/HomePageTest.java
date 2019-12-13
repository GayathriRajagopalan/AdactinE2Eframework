package com.adactin.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.adactin.base.TestBase;
import com.adactin.listeners.MyListener;
import com.adactin.pages.HomePage;
import com.adactin.pages.LoginPage;
import com.adactin.pages.SelectionPage;
@Listeners(MyListener.class)

public class HomePageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	SelectionPage selectionpage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginpage=new LoginPage(driver);
		homepage=loginpage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
		homepage=new HomePage(driver);
	}
	@Test(priority=2)
	public void verifySearchData() {
		selectionpage=homepage.validateSearchBtn();
	}
	
	@Test(priority=1)
	public void verifyUsernameDisplay() {
		boolean flag2=homepage.validateUsernameDisplay();
		Assert.assertFalse(flag2, "username is not displayed");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
