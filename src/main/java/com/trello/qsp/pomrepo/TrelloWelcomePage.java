package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloWelcomePage {

	public TrelloWelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[contains(@class,'Big')]/descendant::a[text()='Log in']")
	private WebElement loginLink;

	public WebElement getLoginLink() {
		return loginLink;
	}
}
