package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloCreatedBoardPage {
	public TrelloCreatedBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div/child::span[@title='ASR rocky (rockyasr8)']")
	private WebElement accounticon;
	
	public WebElement getAccounticon() {
		return accounticon;
	}
	@FindBy(xpath="//span[text()='Log out']")
	private WebElement logoutoption;

	public WebElement getLogoutoption() {
		return logoutoption;
	}
	@FindBy(xpath="//button[@aria-label='Show menu']")
	private WebElement showMenuButton;

	public WebElement getShowMenuButton() {
		return showMenuButton;
	}
	@FindBy(xpath="//a[contains(text(),'Close board')]")
	private WebElement closeboardlink;

	public WebElement getCloseboardlink() {
		return closeboardlink;
	}
	@FindBy(xpath="//input[@data-testid='close-board-confirm-button']")
	private WebElement closeoption;

	public WebElement getCloseoption() {
		return closeoption;
	}
	@FindBy(xpath="//div/h2[contains(text(),'BRAINSTORM')]//ancestor::div[@data-testid='list']//descendant::button[@data-testid='list-add-card-button']")
	private WebElement brainstromAddoption;

	public WebElement getBrainstromAddoption() {
		return brainstromAddoption;
	}
	
}
