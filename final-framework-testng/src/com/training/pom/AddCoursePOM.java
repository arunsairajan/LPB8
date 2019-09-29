package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCoursePOM {
private WebDriver driver; 
	
	public AddCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'add_course.php')]")
	private WebElement createCourseLnk;
		
	
	@FindBy(id="title")
	private WebElement CourseName;
	
	@FindBy(id="advanced_params")
	private WebElement AdvancedSettingBtn;
	
	@FindBy(xpath="(//div[@class='filter-option-inner-inner'])[1]")
	private WebElement Category;
	
	@FindBy(xpath="//span[text()='Projects (PROJ)']")
	private WebElement CategorySelect;
	
		
	@FindBy(id="add_course_wanted_code")
	private WebElement CourseCode;
	
//	@FindBy(xpath="//*[@id=\"advanced_params_options\"]/div[3]/div[1]/div/button/div/div/div")
//	private WebElement Language;
	
	@FindBy(xpath="//div[text()='English']")
	private WebElement LanguageSelect; 
	
	@FindBy(id="add_course_submit")
	private WebElement CreateCourseBtn;
	
	@FindBy(xpath="(//em[@class='fa fa-file-text'])[1]")
	private WebElement AddIntroBtn;
	
	@FindBy(xpath="/html/body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement AddIntroText;
	
	@FindBy(xpath="//button[@class=' btn btn-primary ']")
	private WebElement saveIntro;
	
	@FindBy(xpath="(//div[@class='alert alert-success'])[1]")
	private WebElement updatedText;
	
	
	
	public void ClickcreateCourseLnk() {
		this.createCourseLnk.click();
	}
	
	public void sendCourseName(String CourseName) {
		this.CourseName.clear(); 
		this.CourseName.sendKeys(CourseName); 
	}
	
	public void clickAdvancedSettings() {
		this.AdvancedSettingBtn.click(); 
	}
	
	public void selectCategory() {
		Actions act = new Actions(driver);
		act.moveToElement(Category).click().build().perform();
		act.moveToElement(CategorySelect).click().build().perform();
	}
	
	public void sendCourseCode(String CourseCode) {
		this.CourseCode.clear(); 
		this.CourseCode.sendKeys(CourseCode); 
	}
	
//	public void selectLanguage() {
//		Actions act = new Actions(driver);
//		act.moveToElement(Language).click().build().perform();
//		act.moveToElement(LanguageSelect).click().build().perform();
//	}
	
	public void createCourse() {
		this.CreateCourseBtn.click(); 
	}
	
	public void AddingIntroduction() {
		this.AddIntroBtn.click(); 
	}
	
	public void AddIntroductionText(String AddIntroText) {
		driver.switchTo().frame(0);
		this.AddIntroText.clear(); 
		this.AddIntroText.sendKeys(AddIntroText); 
	}
	
	public void saveIntroText() {
		driver.switchTo().defaultContent();
		this.saveIntro.click(); 
	}
	
	public String finalUpdatedText() {
	//	this.updatedText.clear(); 
		return this.updatedText.getText();
	}
	
}
