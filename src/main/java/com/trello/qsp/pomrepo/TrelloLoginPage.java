package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginPage {
    
	public TrelloLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private  WebElement emailTextField;
	
	public WebElement getEmailTextField() {
		return emailTextField;
	}
	@FindBy(xpath="//span[text()='Continue']")
	private WebElement continueButton;

	public WebElement getContinueButton() {
		return continueButton;
	}
	@FindBy(id="password")
	private WebElement passwordTextField;

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	@FindBy(xpath="//span[text()='Log in']")
	private WebElement loginoption;

	public WebElement getLoginoption() {
		return loginoption;
	}
}
