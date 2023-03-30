package cubes.pages.category;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class CategoryAddPage {
	private String url;
	private WebDriver driver;
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement CategoryNameWebElement;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement DescriptionNameWebElement;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement buttonSaveWebElement;
	
	@FindBy(xpath = "//a[@class='btn btn-outline-secondary']")
	private WebElement buttonCancelWebElement;
	
	@FindBy(xpath = "//a[@name='name']")
	private WebElement editCategoryNameWebElement;
	
	public CategoryAddPage(WebDriver driver) {
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories/add";
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void openPage() {
		this.driver.get(url);
	}
	public boolean isOnPage() {
		return this.driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	public void clickOnSave() {
		buttonSaveWebElement.click();
	}
	
	public void clickOnCancel() {
		buttonCancelWebElement.click();
	}
	public void insertName(String name) {
		CategoryNameWebElement.clear();
		CategoryNameWebElement.sendKeys(name);
	}
	public String getName() {
		
		return CategoryNameWebElement.getAttribute("value");
	}
	public void insertDescription(String description) {
		DescriptionNameWebElement.clear();
		DescriptionNameWebElement.sendKeys(description);
	}

	public boolean isNameErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.id("name-error"));
		
		return errorWebElement.getText().equalsIgnoreCase(error);
	}
	public boolean isSameNameErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.xpath("//div[.='The name has already been taken.']"));
		
		return errorWebElement.getText().equalsIgnoreCase(error);
	}
	
	public boolean isDescriptionErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.id("description-error"));
		
		return errorWebElement.getText().equalsIgnoreCase(error);
	}
	
	public boolean isDivErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.xpath("//div[@class='invalid-feedback']/div[1]"));
		
		return errorWebElement.getText().equalsIgnoreCase(error);
	}
	
}