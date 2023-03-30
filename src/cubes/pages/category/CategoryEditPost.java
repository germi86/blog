package cubes.pages.category;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class CategoryEditPost{
	private String url;
	private WebDriver driver;
		
		@FindBy(xpath = "//a[@name='name']")
		private WebElement editCategoryNameWebElement;
		
		@FindBy(xpath = "//textarea[@name='description']")
		private WebElement editDescriptionNameWebElement;
		
		@FindBy(xpath = "//button[@type='submit']")
		private WebElement editButtonSaveWebElement;
		
		@FindBy(xpath = "//a[@class='btn btn-outline-secondary']")
		private WebElement editButtonCancelWebElement;
		
		public CategoryEditPost(WebDriver driver) {
			this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories/edit/";
			this.driver = driver;
			
			PageFactory.initElements(driver, this);
		}

		public void editName(String name) {
			editCategoryNameWebElement.clear();
			editCategoryNameWebElement.sendKeys(name);
		}
		public void openPage() {
			this.driver.get(url);
		}
		public boolean isOnPage() {
			return this.driver.getCurrentUrl().equalsIgnoreCase(url);
		}
		public void clickOnSave() {
			editButtonSaveWebElement.click();
		}
		
		public void clickOnCancel() {
			editButtonCancelWebElement.click();
		}
		public void insertName(String name) {
			editCategoryNameWebElement.clear();
			editCategoryNameWebElement.sendKeys(name);
		}
		public String getName() {
			
			return editCategoryNameWebElement.getAttribute("value");
		}
		public void insertDescription(String description) {
			editDescriptionNameWebElement.clear();
			editDescriptionNameWebElement.sendKeys(description);
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
		
	


