package cubes.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cubes.helper.MyWebDriver;
import cubes.pages.LoginPage;

public class LoginTest {
	
	private static WebDriver  driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		driver = MyWebDriver.getDriver("chrome");
		
		
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

	@Test //Login with empty fields
	public void tc01() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("");
		loginPage.insertPassword("");
		loginPage.clickOnLogin();
		
		
		assertTrue("Email error missing!",loginPage.checkEmailError("Email * is required field"));
		assertTrue("Password error missing!",loginPage.checkPasswrodError("password * is required field"));
		
	}
	@Test //Login with incorrect Email format
	public void tc02() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("abc123");
		loginPage.insertPassword("");
		loginPage.clickOnLogin();
		
		
		
		WebElement emailErrorElement = driver.findElement(By.id("email-error"));
		WebElement passErrorElement = driver.findElement(By.id("password-error"));
		
		assertTrue("Email error missing!",emailErrorElement.getText().equalsIgnoreCase("Please, enter the valid Email address"));
		assertTrue("Password error missing!",passErrorElement.getText().equalsIgnoreCase("Password* is required field"));
		
	}

	@Test//Login with invalid Email 
	public void tc03() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("example@mail123.com");
		loginPage.insertPassword("");
		loginPage.clickOnLogin();
		
		WebElement passErrorElement = driver.findElement(By.id("password-error"));

		
		assertTrue("Password error missing!",passErrorElement.getText().equalsIgnoreCase("Password* is required field"));
		

		
	}

//	@Test //Login with valid Email 
	public void tc04() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("kursqa@cubes.edu.rs");
		loginPage.insertPassword("");
		loginPage.clickOnLogin();
		
		WebElement passErrorElement = driver.findElement(By.id("password-error"));
		assertTrue("Password error missing!",passErrorElement.getText().equalsIgnoreCase("Password* is required field"));
		
		
	}

	@Test //Login with empty Email field and incorrect password
	public void tc05() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("");
		loginPage.insertPassword("abcabc");
		loginPage.clickOnLogin();
		
		
	
		WebElement emailErrorElement = driver.findElement(By.id("email-error"));
		
		assertTrue("Email error missing!",emailErrorElement.getText().equalsIgnoreCase("Please, enter the valid Email address"));
		}

	@Test //Login with empty Email field and valid password
	public void tc06() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("");
		loginPage.insertPassword("ValidPassword");
		loginPage.clickOnLogin();
		
	
		
		WebElement emailErrorElement = driver.findElement(By.id("email-error"));
		assertTrue("Email error missing!",emailErrorElement.getText().equalsIgnoreCase("Email * is required field"));
	}
		
	@Test //Login with incorrect Email format and invalid Password
	public void tc07() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("abc123");
		loginPage.insertPassword("abcabc");
		loginPage.clickOnLogin();
		
	
		
		assertTrue("Email error missing!",loginPage.checkEmailError("Email * is required field"));
		
	}

	@Test //Login with invalid Email address and invalid Password
	public void tc08() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("example@mail123.com");
		loginPage.insertPassword("abcabc");
		loginPage.clickOnLogin();
		
		
		
		WebElement emailErrorElement = driver.findElement(By.xpath("//[@class='invalid-feedback']/strong[1]"));
		assertTrue("Email error missing!",emailErrorElement.getText().equalsIgnoreCase("These credentials do not match our records."));
		

		
	}

	@Test //Login with valid Email address and invalid Password
	public void tc09() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("kursqa@cubes.edu.rs");
		loginPage.insertPassword("abcabc");
		loginPage.clickOnLogin();
		
		
		
		WebElement emailErrorElement = driver.findElement(By.className("invalid-feedback"));
		assertTrue("Email error missing!",emailErrorElement.getText().equalsIgnoreCase("These credentials do not match our records."));
		WebElement passErrorElement = driver.findElement(By.id("password-error"));
		assertTrue("Password error missing!",passErrorElement.getText().equalsIgnoreCase("Password* is required field"));


		
		
	}

	@Test //Login with incorrect Email address and valid Password
	public void tc10() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("abc123");
		loginPage.insertPassword("Valid Password");
		loginPage.clickOnLogin();
		
		
		
		WebElement emailErrorElement = driver.findElement(By.id("email-error"));
		assertTrue("Email error missing!",emailErrorElement.getText().equalsIgnoreCase("Please, enter the valid Email address"));
	
	}

	@Test //Login with invalid Email address and valid Password
	public void tc11() {
LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("example@mail123.com");
		loginPage.insertPassword("Valid Password");
		loginPage.clickOnLogin();
		
		
		WebElement emailErrorElement = driver.findElement(By.className("invalid-feedback"));
		assertTrue("Email error missing!",emailErrorElement.getText().equalsIgnoreCase("These credentials do not match our records."));

	}

	@Test //Login with valid Email address and valid Password
	public void tc12() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("kursqa@cubes.edu.rs", "cubesqa");
	}


}
