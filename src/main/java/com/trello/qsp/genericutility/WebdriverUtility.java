package com.trello.qsp.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	public void implicitwait(WebDriver driver) {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void waitUntilElementToBeClickable(WebDriver driver,WebElement element,int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		WebElement elements=null;
		elements = wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitUntilElementToBeSelected(WebDriver driver,WebElement element,int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		Boolean elements=null;
		elements = wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void waitUntilUrlToBe(WebDriver driver,String url,int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		Boolean elements=null;
		elements = wait.until(ExpectedConditions.urlToBe(url));
	}
	
	public void selectByVisibleText(WebElement element,String text) {
		Select builder = new Select(element);
		builder.selectByVisibleText(text);
	}
	public void selectByIndex(WebElement element,int index) {
		Select builder = new Select(element);
		builder.selectByIndex(index);
	}
	
	public void mouseHoverAndClickElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToActiveElement(WebDriver driver,String keyys) {
		driver.switchTo().activeElement().sendKeys(keyys);
	}
	
	public void switchToFrameByIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchToframe(WebDriver driver,String idxname) {
		driver.switchTo().frame(idxname);
	}
	
	public String getCurrentWindowID(WebDriver driver) {
		return driver.getWindowHandle();
	}
}
