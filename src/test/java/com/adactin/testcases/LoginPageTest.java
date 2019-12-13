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

@Listeners(MyListener.class)

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		 loginpage=new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void verifyTitleTest() {
		String actualTitle=loginpage.validateTitle();
		Assert.assertEquals(actualTitle, "AdactIn.com - Hotel Reservation System");
	}
	
	@Test(priority=2)
	public void verifyLogoTest() {
		boolean flag=loginpage.validateLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=4)
	public void verifyLoginTest() {
		homepage=loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority=3)
	public void verifyForgotPwdLink() {
		boolean flag1=loginpage.validateForgotPwdLink();
		Assert.assertTrue(flag1);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
