package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddCourseDescPOM;
import com.training.pom.AddCoursePOM;
import com.training.pom.LoginPOM;
import com.training.pom.UnsubscribeUserPOM;
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

public class UnsubscriberUserTests {
	
	public WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private UnsubscribeUserPOM unSubscriberUserPOM;
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
		unSubscriberUserPOM = new UnsubscribeUserPOM(driver);
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
  public void ValidUnsubscriberUser() throws InterruptedException {
	    loginPOM.sendUserName("arun");
		loginPOM.sendPassword("arun");
		loginPOM.clickLoginBtn();
		unSubscriberUserPOM.ClickSelectCourse();
		unSubscriberUserPOM.ClickUsericon();
		unSubscriberUserPOM.checkBox();
		unSubscriberUserPOM.unSubscribeBtn();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		String ExpectedText = "User is now unsubscribed";
		String ActualText = unSubscriberUserPOM.unSubscribedMessage();
		Assert.assertTrue(ActualText.contains(ExpectedText));
  }
}
