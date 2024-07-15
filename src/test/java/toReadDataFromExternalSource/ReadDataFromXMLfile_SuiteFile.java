package toReadDataFromExternalSource;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ReadDataFromXMLfile_SuiteFile {
	WebDriver driver;
   @Parameters({"browser","url","username","password"})	
  @Test
  public void loginToVtiger(String browser,String url,String username,String password) {
	  if(browser.equals("chrome")) {
		  driver=new ChromeDriver();
	  }else if(browser.equals("edge")){ 
		  driver=new EdgeDriver();
	  }else if(browser.equals("firefox")) {
		  driver=new FirefoxDriver();
	  }
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get(url);
	  WebElement usernameTextField = driver.findElement(By.id("username"));
	  usernameTextField.clear();
	  usernameTextField.sendKeys(username);
	  WebElement passwordTextField = driver.findElement(By.id("password"));
	  passwordTextField.clear();
	  passwordTextField.sendKeys(password);
	  driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
	  driver.manage().window().minimize();
	  driver.quit();
  }    
   @Parameters({"browser","url","username","password"})	
   @Test
   public void loginToVtiger1(String browser,String url,String username,String password) {
 	  if(browser.equals("chrome")) {
 		  driver=new ChromeDriver();
 	  }else if(browser.equals("edge")){ 
 		  driver=new EdgeDriver();
 	  }else if(browser.equals("firefox")) {
 		  driver=new FirefoxDriver();
 	  }
 	  driver.manage().window().maximize();
 	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 	  driver.get(url);
 	  WebElement usernameTextField = driver.findElement(By.id("username"));
 	  usernameTextField.clear();
 	  usernameTextField.sendKeys(username);
 	  WebElement passwordTextField = driver.findElement(By.id("password"));
 	  passwordTextField.clear();
 	  passwordTextField.sendKeys(password);
 	  driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
 	  driver.manage().window().minimize();
 	  driver.quit();
   }   
   @Parameters({"browser","url","username","password"})	
   @Test
   public void loginToVtiger2(String browser,String url,String username,String password) {
 	  if(browser.equals("chrome")) {
 		  driver=new ChromeDriver();
 	  }else if(browser.equals("edge")){ 
 		  driver=new EdgeDriver();
 	  }else if(browser.equals("firefox")) {
 		  driver=new FirefoxDriver();
 	  }
 	  driver.manage().window().maximize();
 	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 	  driver.get(url);
 	  WebElement usernameTextField = driver.findElement(By.id("username"));
 	  usernameTextField.clear();
 	  usernameTextField.sendKeys(username);
 	  WebElement passwordTextField = driver.findElement(By.id("password"));
 	  passwordTextField.clear();
 	  passwordTextField.sendKeys(password);
 	  driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
 	  driver.manage().window().minimize();
 	  driver.quit();
   }    
   @Parameters({"browser","url","username","password"})	
   @Test
   public void loginToVtiger4(String browser,String url,String username,String password) {
 	  if(browser.equals("chrome")) {
 		  driver=new ChromeDriver();
 	  }else if(browser.equals("edge")){ 
 		  driver=new EdgeDriver();
 	  }else if(browser.equals("firefox")) {
 		  driver=new FirefoxDriver();
 	  }
 	  driver.manage().window().maximize();
 	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 	  driver.get(url);
 	  WebElement usernameTextField = driver.findElement(By.id("username"));
 	  usernameTextField.clear();
 	  usernameTextField.sendKeys(username);
 	  WebElement passwordTextField = driver.findElement(By.id("password"));
 	  passwordTextField.clear();
 	  passwordTextField.sendKeys(password);
 	  driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
 	  driver.manage().window().minimize();
 	  driver.quit();
   }    
    
     
}
