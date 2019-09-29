package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCourseDescPOM {
	private WebDriver driver; 
	
	public AddCourseDescPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[contains(@href,'index.php?id_session=0')])[1]")
	private WebElement SelectCourse;
	
	@FindBy(xpath = "(//a[contains(@href,'course_description/index.php?')])[1]")
	private WebElement clickCourseDesc;
	
	@FindBy(xpath = "//a[@href='index.php?action=edit&cidReq=SELTST&id_session=0&gidReq=0&gradebook=0&origin=&description_type=1']")
	private WebElement clickDesc;
	
	@FindBy(id = "course_description_title")
	private WebElement enterTitle;
	
	@FindBy(xpath="//body[@class = 'cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement AddContent;
	
	@FindBy(id="course_description_submit")
	private WebElement save;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement updatedMessage;
	
	
	public void ClickSelectCourse() {
		this.SelectCourse.click();
	}
	
	public void clickCourseDescIcon() {
		this.clickCourseDesc.click();
	}
	
	public void clickDescription() {
		this.clickDesc.click();
	}
	
	public void EnterTitleText(String enterTitle) {
		this.enterTitle.clear(); 
		this.enterTitle.sendKeys(enterTitle); 
	}
	
	public void AddContentText(String AddContent) {
		driver.switchTo().frame(0);
		this.AddContent.clear(); 
		this.AddContent.sendKeys(AddContent); 
	}
	
	public void ClickSave() {
		driver.switchTo().defaultContent();
		this.save.click(); 
	}
	
	public String finalUpdatedMsg() {
		//	this.updatedText.clear(); 
			return this.updatedMessage.getText();
		}
	

}
