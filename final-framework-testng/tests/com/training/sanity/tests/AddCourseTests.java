package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddCoursePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCourseTests {
	public WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddCoursePOM addCoursePOM;
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
  public void validAddCourse() throws InterruptedException {
	    loginPOM.sendUserName("arun");
		loginPOM.sendPassword("arun");
		loginPOM.clickLoginBtn();
		addCoursePOM.ClickcreateCourseLnk();
		addCoursePOM.sendCourseName("SeleniumTest10");
		addCoursePOM.clickAdvancedSettings();
		addCoursePOM.selectCategory();
		addCoursePOM.sendCourseCode("selTst10");
//		addCoursePOM.selectLanguage();
		addCoursePOM.createCourse();
		addCoursePOM.AddingIntroduction();
		Thread.sleep(4000);
		addCoursePOM.AddIntroductionText("This is an selenium course");
		addCoursePOM.saveIntroText();
		screenShot.captureScreenShot("Final");
		String ExpectedText = "Intro was updated";
		String ActualText = addCoursePOM.finalUpdatedText();
		Assert.assertTrue(ActualText.contains(ExpectedText));
  }
}
