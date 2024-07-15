package toReadDataFromExternalSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrelloReadDataFromExcel {
	 static WebDriver driver;
	 static WebDriverWait wait;
	 public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
			FileInputStream file = new FileInputStream("./src/test/resource/TrelloWorkbook.xlsx");
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheet("TrelloData");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(1);
			if(cell.getStringCellValue().equals("chrome")) {
				driver = new ChromeDriver();
			}else if(cell.getStringCellValue().equals("firefox")) {
				driver = new FirefoxDriver();
			}else if(cell.getStringCellValue().equals("edge")) {
				driver = new EdgeDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			driver.get(sheet.getRow(2).getCell(1).getStringCellValue());
			wait.until(ExpectedConditions.titleIs("Manage Your Team’s Projects From Anywhere | Trello"));
			
			driver.findElement(By.xpath("//div[contains(@class,'Buttonsstyles')]/a[text()='Log in']")).click();
			
			wait.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
			driver.findElement(By.id("username")).sendKeys(sheet.getRow(3).getCell(1).getStringCellValue());
			driver.findElement(By.xpath("//span[text()='Continue']")).click();
			driver.findElement(By.id("password")).sendKeys(sheet.getRow(4).getCell(1).getStringCellValue());
			driver.findElement(By.xpath("//span[text()='Log in']")).click();
			
			wait.until(ExpectedConditions.titleIs("Boards | Trello"));
			driver.findElement(By.xpath("//p[text()='Create']")).click();
			driver.findElement(By.xpath("//span[text()='Create board']")).click();
			driver.findElement(By.xpath("//input[@data-testid='create-board-title-input']")).sendKeys(sheet.getRow(5).getCell(1).getStringCellValue());
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[text()='Create']")).click();
			Thread.sleep(5000);
			driver.switchTo().activeElement().sendKeys(sheet.getRow(6).getCell(1).getStringCellValue(),Keys.ENTER);
			driver.switchTo().activeElement().sendKeys(sheet.getRow(7).getCell(1).getStringCellValue(),Keys.ENTER);
			driver.switchTo().activeElement().sendKeys(sheet.getRow(8).getCell(1).getStringCellValue(),Keys.ENTER);
			driver.switchTo().activeElement().sendKeys(sheet.getRow(9).getCell(1).getStringCellValue(),Keys.ENTER);
			driver.switchTo().activeElement().sendKeys(sheet.getRow(10).getCell(1).getStringCellValue(),Keys.ENTER);
			driver.findElement(By.xpath("//h2[text()='skills']/../../..//span[@class='nch-icon A3PtEe1rGIm_yL neoUEAwI0GETBQ gNDonYrNSA1GXJ']")).click();
			driver.switchTo().activeElement().sendKeys(sheet.getRow(11).getCell(1).getStringCellValue(),Keys.ENTER);
			driver.switchTo().activeElement().sendKeys(sheet.getRow(12).getCell(1).getStringCellValue(),Keys.ENTER);
			driver.switchTo().activeElement().sendKeys(sheet.getRow(13).getCell(1).getStringCellValue(),Keys.ENTER);
			driver.switchTo().activeElement().sendKeys(sheet.getRow(14).getCell(1).getStringCellValue(),Keys.ENTER);
			Thread.sleep(2000);
			WebElement Oops = driver.findElement(By.xpath("//a[text()='Oops']/.."));
			WebElement javaopt = driver.findElement(By.xpath("//h2[text()='Java']/../../..//button[@data-testid='list-add-card-button']"));
			WebElement xpath = driver.findElement(By.xpath("//a[text()='Xpath']"));
			WebElement autoopt = driver.findElement(By.xpath("//h2[text()='Automation']/../../..//button[@data-testid='list-add-card-button']"));
			WebElement agile = driver.findElement(By.xpath("//a[text()='Agile']"));
			WebElement manualopt = driver.findElement(By.xpath("//h2[text()='Manual']/../../..//button[@data-testid='list-add-card-button']"));
			WebElement query = driver.findElement(By.xpath("//a[text()='query']"));
			WebElement sql = driver.findElement(By.xpath("//h2[text()='SQL']/../../..//button[@data-testid='list-add-card-button']"));
			Actions act = new Actions(driver);
			act.clickAndHold(Oops).pause(Duration.ofSeconds(3)).dragAndDrop(Oops, javaopt).release().perform();
			Thread.sleep(1000);
			act.clickAndHold(xpath).pause(Duration.ofSeconds(3)).dragAndDrop(xpath, autoopt).release().perform();
			Thread.sleep(1000);
			act.clickAndHold(agile).pause(Duration.ofSeconds(3)).dragAndDrop(agile, manualopt).release().perform();
			Thread.sleep(1000);
			act.clickAndHold(query).pause(Duration.ofSeconds(3)).dragAndDrop(query, sql).release().perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@aria-label='Show menu']")).click();
			driver.findElement(By.xpath("//li/a[contains(text(), 'Close board')]")).click();
			driver.findElement(By.xpath("//input[@data-testid='close-board-confirm-button']")).click();
			driver.findElement(By.xpath("//div[@title='ASR rocky (rockyasr8)']/span[@title='ASR rocky (rockyasr8)']")).click();
			driver.findElement(By.xpath("//span[text()='Log out']")).click();
			driver.findElement(By.xpath("//span[text()='Log out']")).click();
			driver.manage().window().minimize();
			driver.quit();
			
	 }		
}
