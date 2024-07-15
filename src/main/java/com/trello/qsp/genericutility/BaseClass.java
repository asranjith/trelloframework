package com.trello.qsp.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.trello.qsp.pomrepo.TrelloCreatedBoardPage;
import com.trello.qsp.pomrepo.TrelloLoginPage;
import com.trello.qsp.pomrepo.TrelloLogoutPage;
import com.trello.qsp.pomrepo.TrelloWelcomePage;

public class BaseClass {
    public static WebDriver driver;
    public WebdriverUtility webdriverutils=new WebdriverUtility();
    public JavaUtility javautils=new JavaUtility();
    public FileUtility fileutils=new FileUtility();
    public ExcelUtility excelutils=new ExcelUtility();
    
    @BeforeClass
    public void preCondition() throws IOException {
    	String browserName = fileutils.readTheDataFromPropertyFile("browser");
    	if(browserName.equals("chrome")) {
    		driver=new ChromeDriver();
    	}else if(browserName.equals("edge")) {
    		driver=new EdgeDriver();
    	}else if(browserName.equals("firefox")) {
    		driver=new FirefoxDriver();
    	}
    	driver.manage().window().maximize();
    	webdriverutils.implicitwait(driver);
    	driver.get(fileutils.readTheDataFromPropertyFile("url"));
    }
    @BeforeMethod
    public void login() throws IOException {
    	TrelloWelcomePage welcome=new TrelloWelcomePage(driver);
		TrelloLoginPage loginpage=new TrelloLoginPage(driver);
    	welcome.getLoginLink().click();
		loginpage.getEmailTextField().sendKeys(fileutils.readTheDataFromPropertyFile("username"));
		loginpage.getContinueButton().click();
		loginpage.getPasswordTextField().sendKeys(fileutils.readTheDataFromPropertyFile("password"));
		loginpage.getLoginoption().click();
    }
    
    @AfterMethod
    public void logout() {
    	TrelloCreatedBoardPage createboardpage=new TrelloCreatedBoardPage(driver);
		TrelloLogoutPage logoutpage=new TrelloLogoutPage(driver);
    	createboardpage.getAccounticon().click();
		createboardpage.getLogoutoption().click();
		logoutpage.getLogoutopt().click();
    }
    
    @AfterClass
    public void postCondition() {
    	driver.manage().window().minimize();
    	driver.quit();
    }
    public void failedTestCase(String FailedMethod) throws IOException {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File tempfile = ts.getScreenshotAs(OutputType.FILE);
    	File permfile = new File("./src/test/resource/defectshot/"+FailedMethod+"defect.png");
    	FileUtils.copyFile(tempfile, permfile);
    }
}
