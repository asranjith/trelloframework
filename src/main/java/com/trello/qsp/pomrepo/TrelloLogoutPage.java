package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLogoutPage {
    
	public TrelloLogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Log out']")
	private WebElement logoutopt;
	
	public WebElement getLogoutopt() {
		return logoutopt;
	}
}
