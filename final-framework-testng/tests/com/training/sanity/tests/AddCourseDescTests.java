package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddCourseDescPOM;
import com.training.pom.AddCoursePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class AddCourseDescTests {
	public WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddCoursePOM addCoursePOM;
	private AddCourseDescPOM addCourseDescPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
  
  @BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		addCoursePOM = new AddCoursePOM(driver);
		addCourseDescPOM = new AddCourseDescPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

  @AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
  
  @Test
  public void ValidAddCourseDesc() throws InterruptedException {
	    loginPOM.sendUserName("arun");
		loginPOM.sendPassword("arun");
		loginPOM.clickLoginBtn();
		addCourseDescPOM.ClickSelectCourse();
		screenShot.captureScreenShot("First TC2");
		addCourseDescPOM.clickCourseDescIcon();
		screenShot.captureScreenShot("Second TC2");
		addCourseDescPOM.clickDescription();
		screenShot.captureScreenShot("Third TC2");
		addCourseDescPOM.EnterTitleText("Selenium Course for beginners");
		screenShot.captureScreenShot("Fourth TC2");
		Thread.sleep(4000);
		addCourseDescPOM.AddContentText("Selenium Course for beginners");
		screenShot.captureScreenShot("Fifth TC2");
		addCourseDescPOM.ClickSave();
		screenShot.captureScreenShot("Final TC2");
		String ExpectedText = "The description has been updated";
		String ActualText = addCourseDescPOM.finalUpdatedMsg();
		Assert.assertTrue(ActualText.contains(ExpectedText));
		
  }
  
  
 

}
