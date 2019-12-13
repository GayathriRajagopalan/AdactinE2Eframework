package com.adactin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.adactin.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(id="location")
	WebElement locDD;
 
    @FindBy(id="hotels")
    WebElement hotelDD;
    
    @FindBy(id="room_type")
    WebElement roomTypeDD;
    
    @FindBy(id="room_nos")
    WebElement numberOfRoomsDD;
    
    @FindBy(id="datepick_in")
    WebElement dateIn;
    
    @FindBy(id="datepick_out")
    WebElement dateOut;
    
    @FindBy(id="adult_room")
    WebElement noOfAdults;
    
    @FindBy(id="child_room")
    WebElement noOfKids;
    
    @FindBy(id="Submit")
    WebElement searchBtn;
    
    @FindBy(id="username_show")
    WebElement usernameDisplay;
    
    
    public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
    public boolean validateUsernameDisplay() {
    	return usernameDisplay.isDisplayed();
    }

	public SelectionPage validateSearchBtn() {
    	Select loc=new Select(locDD);
    	loc.selectByVisibleText("London");
    	Select hot = new Select(hotelDD);
    	hot.selectByValue("Hotel Hervey");
    	Select room = new Select(roomTypeDD);
    	room.selectByIndex(1);
    	Select noofroom = new Select(numberOfRoomsDD);
    	noofroom.selectByVisibleText("3 - Three");
    	dateIn.clear();
    	dateIn.sendKeys("24/12/2019");
    	dateOut.clear();
    	dateOut.sendKeys("31/12/2019");
    	Select adultroom = new Select(noOfAdults);
    	adultroom.selectByValue("2");
    	Select childRoom = new Select(noOfKids);
    	childRoom.selectByIndex(2);
    	searchBtn.click();
    	return new SelectionPage(driver);
    	
    }
  
}
