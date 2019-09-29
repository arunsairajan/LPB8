package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UnsubscribeUserPOM {
private WebDriver driver; 
	
	public UnsubscribeUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@href='http://elearning.upskills.in/courses/SELTST1/index.php?id_session=0'])[1]")
	private WebElement SelectCourse;
	
	@FindBy(xpath = "//a[@id='istooldesc_7768']")
	private WebElement clickUser;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement clickCheckBox;
	
	@FindBy(xpath = "//a[@class='btn btn-small btn-danger']")
	private WebElement unSubscribe;
	
	@FindBy(xpath = "//div[text()='User is now unsubscribed']")
	private WebElement unSubscribedMsg;
	
	public void ClickSelectCourse() {
		this.SelectCourse.click();
	}
	
	public void ClickUsericon() {
		this.clickUser.click();
	}
	
	public void checkBox() {
		this.clickCheckBox.click();
	}
	
	public void unSubscribeBtn() {
		this.unSubscribe.click();
	}
	
	public String unSubscribedMessage() {
		//	this.updatedText.clear(); 
			return this.unSubscribedMsg.getText();
		}
	

}
