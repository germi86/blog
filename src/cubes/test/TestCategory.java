package cubes.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import cubes.helper.MyWebDriver;
import cubes.pages.LoginPage;
import cubes.pages.category.CategoryAddPage;
import cubes.pages.category.CategoryEditPost;
import cubes.pages.category.CategoryListPage;

public class TestCategory {
	
	private static WebDriver  driver;
	private String newCategoryName = "taxa";
	private String updatedCategoryName = "chic";
	private String newCategoryDescription = "hihi"; 
	private String updatedCategoryDescription = "hihihihihihihihihihihihihihihihihihihihihihihihihihi";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = MyWebDriver.getDriver("chrome");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginSuccess();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//Try to Add Post Categories with empty fields
	@Test
	public void TC001() {
		CategoryListPage categoryListPage = new CategoryListPage(driver);
		
		categoryListPage.clickOnAddNewCategory();
		
		CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
		
		assertTrue("Add category problem!", categoryAddPage.isOnPage());
		
		categoryAddPage.insertName("");
		
		categoryAddPage.insertDescription("");
		
		categoryAddPage.clickOnSave();
		
		assertTrue("Insert name error problem!", categoryAddPage.isNameErrorOnPage("This field is required."));
		assertTrue("Insert description error problem!", categoryAddPage.isDescriptionErrorOnPage("This field is required."));

	}
	//Try to Add Post Categories With empty fields and click cancel
	@Test
	public void TC002() {
		CategoryListPage categoryListPage = new CategoryListPage(driver);
		
		categoryListPage.clickOnAddNewCategory();
		
		CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
		
		assertTrue("Add category problem!", categoryAddPage.isOnPage());
		
		categoryAddPage.insertName("");
		
		categoryAddPage.insertDescription("");
		
		categoryAddPage.clickOnCancel();
		
		assertTrue("Category open page problem!", categoryListPage.isOnPage());
				
		
	}
	//Try to Add Post Categories With input fields name and description and click cancel
	@Test
	public void TC003() {
		CategoryListPage categoryListPage = new CategoryListPage(driver);
		
		categoryListPage.clickOnAddNewCategory();
			
		CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
			
		assertTrue("Add category problem!", categoryAddPage.isOnPage());
			
		categoryAddPage.insertName(newCategoryName);
			
		categoryAddPage.insertDescription(newCategoryDescription);
			
		categoryAddPage.clickOnCancel();
			
		assertTrue("Category open page problem!", categoryListPage.isOnPage());
					
		}
	//Try to Add Post Categories With input name , empty description and click save
	@Test
	public void TC004() {
		CategoryListPage categoryListPage = new CategoryListPage(driver);
			
		categoryListPage.clickOnAddNewCategory();
				
		CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
				
		assertTrue("Add category problem!", categoryAddPage.isOnPage());
				
		categoryAddPage.insertName(newCategoryName);
				
		categoryAddPage.insertDescription(newCategoryDescription);
				
		categoryAddPage.clickOnSave();
						
		assertTrue("Insert description less characters error problem!", categoryAddPage.isDivErrorOnPage("The description must be at least 50 characters."));

		}
	//"Try to Add Post Categories With empty name , input description and click save"
		@Test
		public void TC005() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnAddNewCategory();
					
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
					
			assertTrue("Add category problem!", categoryAddPage.isOnPage());
					
			categoryAddPage.insertName("");
					
			categoryAddPage.insertDescription(newCategoryDescription);
					
			categoryAddPage.clickOnSave();
							
			assertTrue("Insert name error problem!", categoryAddPage.isNameErrorOnPage("This field is required."));

			}
		//"Try to Add Post Categories With input name , empty description and click cancel"
		@Test
		public void TC006() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnAddNewCategory();
					
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
					
			assertTrue("Add category problem!", categoryAddPage.isOnPage());
					
			categoryAddPage.insertName(newCategoryName);
					
			categoryAddPage.insertDescription("");
					
			categoryAddPage.clickOnCancel();
							
			assertTrue("Category open page problem!", categoryListPage.isOnPage());

			}
		//"Try to Add Post Categories  With empty name , input description and click cancel"
		@Test
		public void TC007() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnAddNewCategory();
					
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
					
			assertTrue("Add category problem!", categoryAddPage.isOnPage());
					
			categoryAddPage.insertName("");
					
			categoryAddPage.insertDescription(newCategoryDescription);
					
			categoryAddPage.clickOnCancel();
							
			assertTrue("Category open page problem!", categoryListPage.isOnPage());

			}
		//"Try to Add Post Categories  With input name , input description and click cancel"
		@Test
		public void TC008() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnAddNewCategory();
					
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
					
			assertTrue("Add category problem!", categoryAddPage.isOnPage());
					
			categoryAddPage.insertName(newCategoryName);
					
			categoryAddPage.insertDescription(newCategoryDescription);
					
			categoryAddPage.clickOnCancel();
							
			assertTrue("Category open page problem!", categoryListPage.isOnPage());

			}
		//"Try to Add Post Categories With input name , input description less than 50 characters and click save"
		@Test
		public void TC009() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnAddNewCategory();
					
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
					
			assertTrue("Add category problem!", categoryAddPage.isOnPage());
					
			categoryAddPage.insertName(newCategoryName);
					
			categoryAddPage.insertDescription(newCategoryDescription);
					
			categoryAddPage.clickOnSave();
			
			assertTrue("Insert description less characters error problem!", categoryAddPage.isDivErrorOnPage("The description must be at least 50 characters."));
		
			}
		//"Try to Add Post Categories With input name , input description more than 50 characters and click cancel"
		@Test
		public void TC010() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnAddNewCategory();
					
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
					
			assertTrue("Add category problem!", categoryAddPage.isOnPage());
					
			categoryAddPage.insertName(newCategoryName);
					
			categoryAddPage.insertDescription(updatedCategoryDescription);
					
			categoryAddPage.clickOnCancel();
			
			assertTrue("Category open page problem!", categoryListPage.isOnPage());
			}
		//"Try to Add Post Categories With input name , input description more than 50 characters and click save"
		@Test
		public void TC011() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnAddNewCategory();
					
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
					
			assertTrue("Add category problem!", categoryAddPage.isOnPage());
					
			categoryAddPage.insertName(newCategoryName);
					
			categoryAddPage.insertDescription(updatedCategoryDescription);
					
			categoryAddPage.clickOnSave();
			
			assertTrue("Category open page problem!", categoryListPage.isOnPage());
			
			assertTrue("New category name missing!", categoryListPage.isCategoryNameElementOnPage(newCategoryName));

			assertTrue("New description missing", categoryListPage.isCategoryDescriptionElementOnPage());
			}
		//"Try to Add Post Categories With same input name ,  same input description more than 50 characters and click save"
		@Test
		public void TC012() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnAddNewCategory();
					
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
					
			assertTrue("Add category problem!", categoryAddPage.isOnPage());
					
			categoryAddPage.insertName(newCategoryName);
					
			categoryAddPage.insertDescription(updatedCategoryDescription);
					
			categoryAddPage.clickOnSave();
			
			assertTrue("Insert same name post categories error", categoryAddPage.isSameNameErrorOnPage("The name has already been taken."));

			
			}
		//"Try to View created Post Category with eye icon button "
		@Test
		public void TC013() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnViewCategory(newCategoryName); //resiti - problem!!!!
			
			
			assertTrue("Category view page problem!", categoryListPage.isOnViewCategoryPage());
			
			driver.getWindowHandle();
			
			}
		//"Try to edit created Post Category With edit icon button "
		@Test
		public void TC014() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnUpdateCategory(newCategoryName); 
			
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
			
			categoryAddPage.clickOnCancel();
			
			assertTrue("New category missing!", categoryListPage.isCategoryNameElementOnPage(newCategoryName));
			
			}
		//"Try to edit created Post Category With edit icon button, click cancel"
		@Test
		public void TC015() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnUpdateCategory(newCategoryName); 
			
			categoryListPage.clickOnCancelEditCategory();
			
			assertTrue("Category open page problem!", categoryListPage.isOnPage());		
			
			assertTrue("New category name missing!", categoryListPage.isCategoryNameElementOnPage(newCategoryName));

			assertTrue("New description missing", categoryListPage.isCategoryDescriptionElementOnPage());
			}
		//"Try to edit created Post Category With edit icon button, leave Name empty,then save"
		@Test
		public void TC016() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnUpdateCategory(newCategoryName); 
						
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
			
			categoryAddPage.insertName("");
					
			categoryAddPage.clickOnSave();
			
			assertTrue("Insert name error problem!", categoryAddPage.isNameErrorOnPage("This field is required."));			
			}
		//"Try to edit created Post Category With edit icon button, leave Description  empty,then save"
		@Test
		public void TC017() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnUpdateCategory(newCategoryName); 
			
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
						
			categoryAddPage.insertDescription("");
			
			categoryAddPage.clickOnSave();
						
			assertTrue("Edit description error problem!", categoryAddPage.isDescriptionErrorOnPage("This field is required."));
			
			}
		//"Try to edit created Post Category With edit icon button, input Description  less than 50 characters,then save"
		@Test
		public void TC018() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnUpdateCategory(newCategoryName); 
			
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);
						
			categoryAddPage.insertDescription("hihihi");
			
			categoryAddPage.clickOnSave();
		
			assertTrue("edit description less characters error problem!", categoryAddPage.isDivErrorOnPage("The description must be at least 50 characters."));			
			}
		//"Try to edit created Post Category With edit icon button, leave Description empty,Name empty, click save"
		@Test
		public void TC019() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnUpdateCategory(newCategoryName); 
			
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);			
						
			categoryAddPage.insertName("");
			
			categoryAddPage.insertDescription("");
			
			categoryAddPage.clickOnSave();

			assertTrue("Edit name error problem!", categoryAddPage.isNameErrorOnPage("This field is required."));

			assertTrue("Edit description error problem!", categoryAddPage.isDescriptionErrorOnPage("This field is required."));			
			}
		//"Try to edit created Post Category With edit icon button, click save"
		@Test
		public void TC020() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnUpdateCategory(newCategoryName); 
			
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);						
			
			categoryAddPage.clickOnSave();
			
			assertTrue("Category open page problem!", categoryListPage.isOnPage());		
			
			assertTrue("New category name missing!", categoryListPage.isCategoryNameElementOnPage(newCategoryName));
			}
		//"Try to edit created Post Category With edit icon button, input name click save"
		@Test
		public void TC021() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnUpdateCategory(newCategoryName); 
			
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);				
			
			categoryAddPage.insertName(updatedCategoryName);
			
			categoryAddPage.clickOnSave();
			
			assertTrue("Category open page problem!", categoryListPage.isOnPage());		
			
			assertTrue("New category name missing!", categoryListPage.isCategoryNameElementOnPage(updatedCategoryName));
			}
		//	"Try to edit created Post Category With edit icon button, input description more than 50 characters click save"
		@Test
		public void TC022() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnUpdateCategory(updatedCategoryName); 
			
			CategoryAddPage categoryAddPage = new CategoryAddPage(driver);				
			
			categoryAddPage.insertDescription("hihihihihihihihihihihihihihihihihihihihihihihihihihiHAHA");
			
			categoryAddPage.clickOnSave();
			
			assertTrue("Category open page problem!", categoryListPage.isOnPage());		
			
			assertTrue("New category name missing!", categoryListPage.isCategoryNameElementOnPage(updatedCategoryName));
			
			}
		//"Try to delete created Post Category With delete icon button, click cancel"
		@Test
		public void TC023() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnDeleteIconCategory(updatedCategoryName);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			
			categoryListPage.clickOnCancelDeleteCategory();
			
			assertTrue("Category open page problem!", categoryListPage.isOnPage());		
			
			assertTrue("New category name missing!", categoryListPage.isCategoryNameElementOnPage(updatedCategoryName));
			
			}
		//"Try to delete created Post Category With delete icon button, click close"
		@Test
		public void TC024() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnDeleteIconCategory(updatedCategoryName);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			
			categoryListPage.clickOnDeleteCloseCategory();
			
			assertTrue("Category open page problem!", categoryListPage.isOnPage());		
			
			assertTrue("New category name missing!", categoryListPage.isCategoryNameElementOnPage(updatedCategoryName));
			
			}
		//	"Try to delete created Post Category With delete icon button, click delete"
		@Test
		public void TC025() {
			CategoryListPage categoryListPage = new CategoryListPage(driver);
				
			categoryListPage.clickOnDeleteIconCategory(updatedCategoryName);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			
			categoryListPage.clickOnDeleteCategory();
			
			assertTrue("Category open page problem!", categoryListPage.isOnPage());		
			
			assertTrue("New category name missing!", !categoryListPage.isCategoryNameElementOnPage(updatedCategoryName));
			
			}
		//Primetio sam da su razlicite URL adrese za add i edit post categories,napravio sam novu klasu za edit,medjutim se upetljao i odustao.
		// TC 13 nisam uspeo do kraja da uradim kako treba
		
}
