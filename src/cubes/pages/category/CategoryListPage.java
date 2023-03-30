package cubes.pages.category;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
	
public class CategoryListPage {

	private String url;
	private WebDriver driver;
	
	private WebElement addNewCategoryWebElement;
	
	public CategoryListPage(WebDriver driver) {
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories";
		this.driver = driver;
		
		this.driver.get(url);
		this.driver.manage().window().maximize();
		
		this.addNewCategoryWebElement = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
	}
	public void openPage() {
		driver.get(url);
	}
	
	public boolean isOnPage() {
		return driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	public void clickOnAddNewCategory() {
		addNewCategoryWebElement.click();
	}
	public boolean isCategoryNameElementOnPage(String categoryName) {
		List<WebElement> webElements = driver.findElements(By.xpath("//strong[text()='"+categoryName+"']"));
		return webElements.size()>0;
	}
	public boolean isCategoryDescriptionElementOnPage() {
		List<WebElement> webElements = driver.findElements(By.xpath("//td[contains(.,'hihihihihihihihihihihihihihihihihihihihihihihihihi...')]"));
		return webElements.size()>0;
	}
	public void clickOnViewCategory(String categoryName) {
		WebElement viewCategoryWebElement = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']//ancestor::tr/td[6]/div[1]/a[1]"));
		viewCategoryWebElement.click();
	}
	public boolean isOnViewCategoryPage() {
		String url ="https://testblog.kurs-qa.cubes.edu.rs/posts/category-posts"; 
		return driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	public void clickOnUpdateCategory(String categoryName) {
		WebElement updateCategoryWebElement = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']//ancestor::tr/td[6]/div[1]/a[2]"));
		updateCategoryWebElement.click();                                
	}
	public void clickOnCancelEditCategory() {
		WebElement cancelCategoryWebElement = driver.findElement(By.xpath("// a[@class='btn btn-outline-secondary']"));
		cancelCategoryWebElement.click();
	}
	public boolean isCategoryDescriptionOnPage(String categoryDescription, String categoryName) {
		WebElement descriptionWebElement = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']//ancestor::tr/td[3]"));
		String descriptionString = descriptionWebElement.getText().replace("...", "");
		return categoryDescription.contains(descriptionString);
	}
	public void clickOnDeleteIconCategory(String categoryName) {
		WebElement updateIconCategoryWebElement = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']//ancestor::tr/td[6]/div[1]/button[1]"));
		updateIconCategoryWebElement.click();     
	}
	public void clickOnCancelDeleteCategory() {
		WebElement cancelDeleteCategoryWebElement = driver.findElement(By.xpath("//button[text() = 'Cancel']"));
		cancelDeleteCategoryWebElement.click();
	}
	public void clickOnDeleteCategory() {
		WebElement deleteCategoryWebElement = driver.findElement(By.xpath("//button[text()='Delete']"));
		deleteCategoryWebElement.click();
	}
	public void clickOnDeleteCloseCategory() {
		WebElement closeCategoryWebElement = driver.findElement(By.xpath("//button[@class = 'close']"));
		closeCategoryWebElement.click();

	}
}
