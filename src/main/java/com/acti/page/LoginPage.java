package com.acti.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

public class LoginPage extends DriverScript {
	@FindBy(id = "username")WebElement enterUserName;
	@FindBy(name = "pwd")WebElement enterPassWord;
	@FindBy(xpath = "//div[text()='Login ']")WebElement loginButton;
	@FindBy(xpath="//a[@id='toPasswordRecoveryPageLink']")WebElement passwordRecoverylink;
	@FindBy(xpath="//div[@class='atLogoImg']")WebElement loginImage;
    @FindBy(xpath="//a[text()='actiTIME Inc.']")WebElement actitimeLink;
	//@FindBy("")WebElement
	//@FindBy("")WebElement

    
    public boolean testactiTimeLink() {
    return actitimeLink.isDisplayed();
    }
	
	 public String getPageTitle() {
		 return driver.getTitle();
		 
	 }
	 
	 public boolean testLoginImage() {
		return loginImage.isDisplayed();
	 }
	 
	 
	public boolean passwordRecoverylink() {
	 return passwordRecoverylink.isDisplayed();
	}
  
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	public void enterUserName(String username) {
	
		enterUserName.sendKeys(username);
	}

	public void enterPassWord(String password) {
		enterPassWord.sendKeys(password);
	}

	public void loginButton() {
		loginButton.click();
	}
}
