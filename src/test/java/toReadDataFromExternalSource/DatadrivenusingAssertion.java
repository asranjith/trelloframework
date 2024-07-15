package toReadDataFromExternalSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatadrivenusingAssertion {
	WebDriver driver=new ChromeDriver();
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
  @Test
  public void login() throws IOException, InterruptedException {
	      FileInputStream file = new FileInputStream("./src/test/resource/trellodata.properties");
	      Properties pobj = new Properties();
	      pobj.load(file);
	      
	      FileInputStream xl = new FileInputStream("./src/test/resource/title.xlsx");
	      Workbook workbook = WorkbookFactory.create(xl);
	      Sheet sheet = workbook.getSheet("Title");
	      
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get(pobj.getProperty("url"));
		  
		  
		  driver.findElement(By.xpath("//a[text()='Get Trello for free']/preceding-sibling::a[text()='Log in']")).click();
		  Thread.sleep(2000);
		  String expectedTitle = driver.getTitle();
		  System.out.println("Login Title:"+expectedTitle);
		  String logintitle = sheet.getRow(1).getCell(1).getStringCellValue();
		  Thread.sleep(2000);
		  Assert.assertEquals(logintitle, expectedTitle,"Title is not matching!");
		  
		  
		  wait.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
		  Thread.sleep(2000);
		  driver.findElement(By.id("username")).sendKeys(pobj.getProperty("username"));
		  driver.findElement(By.xpath("//span[text()='Continue']")).click();
		  driver.findElement(By.id("password")).sendKeys(pobj.getProperty("password"));
		  driver.findElement(By.xpath("//span[text()='Log in']")).click();
  }
}
