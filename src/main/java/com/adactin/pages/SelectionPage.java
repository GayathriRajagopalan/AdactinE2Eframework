package com.adactin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.base.TestBase;

public class SelectionPage extends TestBase {
	
	@FindBy(id="radiobutton_0")
	WebElement radioBtn;
	
	@FindBy(id="continue")
	WebElement ContinueBtn;
	
	@FindBy(xpath="//td[@class='login_title']")
	WebElement searchHotelText;
	
	
	public SelectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	

	public boolean validateSearchHotelText() {
		return searchHotelText.isDisplayed();
	}
	
	public BookHotelPage validateSearchHotel() {
		 radioBtn.click();
		 ContinueBtn.click();
		 return new BookHotelPage(driver);
	}
	
	
	

}
