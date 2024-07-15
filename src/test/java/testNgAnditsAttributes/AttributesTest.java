package testNgAnditsAttributes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AttributesTest {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void preCondition() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@AfterMethod
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
  @Test(priority=-1)
  public void faceBook() {
	  driver.get("https://www.facebook.com/");
	  driver.findElement(By.id("email")).sendKeys("rockyranjith27@gmail.com");
	  driver.findElement(By.id("pass")).sendKeys("#Ranjith27");
	  driver.findElement(By.name("login")).submit();
  }
  @Test(priority=1)
  public void trello() {
	  wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	  driver.get("https://trello.com/home");
	  driver.findElement(By.xpath("//a[text()='Get Trello for free']/preceding-sibling::a[text()='Log in']")).click();
	  String expectedTitle = driver.getTitle();
	  System.out.println("Login Title:"+expectedTitle);
	  Assert.assertEquals("Log in with Atlassian account", expectedTitle,"Title is not matching!");
	  wait.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
	  driver.findElement(By.id("username")).sendKeys("rockyasr8@gmail.com");
	  driver.findElement(By.xpath("//span[text()='Continue']")).click();
	  driver.findElement(By.id("password")).sendKeys("#Asrrocky@8");
	  driver.findElement(By.xpath("//span[text()='Log in']")).click();
  }
  @Test(priority=2)
  public void vtiger() {
	  driver.get("https://demo.vtiger.com/vtigercrm/");
	  WebElement userNameTextField = driver.findElement(By.id("username"));
		userNameTextField.clear();
		userNameTextField.sendKeys("AS Ranjith");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	  
	  }
}
