package com.acti.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

public class EnterPage extends DriverScript {
	

	@FindBy(xpath="//a[@class='userProfileLink username ']")WebElement userLoggedIn; 
	@FindBy(id="logoutLink")WebElement logoutButton;
	
	//@FindBy("")WebElement
	public EnterPage() {
		PageFactory.initElements(driver,this);
	}
	public String getuserLoggedInfo() {
		return userLoggedIn.getText();
		
		
	}
	public void clicklogoutlink() {
		logoutButton.click();;	
	}
	
}
