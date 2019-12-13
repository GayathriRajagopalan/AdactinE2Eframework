package com.adactin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.base.TestBase;

public class LoginPage extends TestBase {
	
	/*
	 * @FindBy(xpath="//strong[contains(text(),'Go to Build 2')]") WebElement
	 * Build2;
	 */
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement Pass;
	
	@FindBy(id="login")
	WebElement LoginBtn;
	
	@FindBy(linkText="New User Register Here")
	WebElement RegistrationLink;
	
	@FindBy(linkText="Forgot Password?")
	WebElement ForgotpwdLink;
	
	@FindBy(xpath="//img[@class='logo']")
	WebElement logoimg;
	
	public LoginPage(WebDriver driver) {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String validateTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return logoimg.isDisplayed();
	}
	public HomePage validateLogin(String uname,String pwd) {
		userName.sendKeys(uname);
		Pass.sendKeys(pwd);
		LoginBtn.click();
		return new HomePage(driver);
	}
	
	public RegistrationPage validateRegistrationLink() {
		RegistrationLink.click();
		return new RegistrationPage();
	}
	public boolean validateForgotPwdLink() {
		return ForgotpwdLink.isDisplayed();
		
	}
	

}
