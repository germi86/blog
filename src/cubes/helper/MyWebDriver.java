package cubes.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyWebDriver {  //pravimo metode koje cemo pozivati

	public static WebDriver getDriver(String browser) {
		
		WebDriver webDriver = null;
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		if(browser.equalsIgnoreCase("Firefox")) {
			
			
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/milosfilipovic/Desktop/Java/Dravjeri za browsere/chromedriver");
			webDriver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("opera")) {
			
		}
		else {
			System.setProperty("webdriver.chrome.driver", "/Users/milosfilipovic/Desktop/Java/Dravjeri za browsere/chromedriver");
			webDriver = new ChromeDriver();
		}
		webDriver.manage().window().maximize(); //uvecavanje browsera
		return webDriver;
	}
	public static void scroolToWebElement(WebDriver driver,WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
		}
	
	
	

