package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardsPage {
	
	public TrelloBoardsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Create']")
	private WebElement createoption;

	public WebElement getCreateoption() {
		return createoption;
	}
	@FindBy(xpath="//span[text()='Create board']")
	private WebElement createboardoption;

	public WebElement getCreateboardoption() {
		return createboardoption;
	}
	@FindBy(xpath="//input[@data-testid='create-board-title-input']")
	private WebElement boardtitletextfield;

	public WebElement getBoardtitletextfield() {
		return boardtitletextfield;
	}
	@FindBy(xpath="//button[text()='Create']")
	private WebElement createbutton;

	public WebElement getCreatebutton() {
		return createbutton;
	}
	@FindBy(xpath="//button[@title='Templates']")
	private WebElement templateButton;

	public WebElement getTemplateButton() {
		return templateButton;
	}
	@FindBy(xpath="//div[text()='Simple Project Board']")
	private WebElement simpleprojectboardoption;

	public WebElement getSimpleprojectboardoption() {
		return simpleprojectboardoption;
	}
	
}
