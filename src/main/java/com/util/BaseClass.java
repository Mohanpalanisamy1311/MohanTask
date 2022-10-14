package com.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

public static WebDriver driver;
	
	public static void browserLaunch(String url) {
	WebDriverManager.chromedriver().setup();
	
		ChromeOptions options = new ChromeOptions(); 
		Map<String, Object> prefs = new HashMap<String, Object>(); 
		prefs.put("intl.accept_languages", "en"); 
		options.setExperimentalOption("prefs", prefs); 
		driver = new ChromeDriver(options);		
		 
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	
	public static void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	
	public static  void clickElement(WebElement element) {
		try{	element.click();
		
		}
		catch (Exception e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].click();", element);
			
			
		}
		}
	
	public static  String readDataFromProperties(String propertyType) throws IOException {
		FileReader fileReader = new FileReader("C:\\Users\\user\\eclipse-workspace\\ManikandanSampleProject\\src\\test\\resources\\config.properties");
		Properties p = new Properties();
		p.load(fileReader);
		return p.getProperty(propertyType);
	}
	public static  void selectDropDown(WebElement element, String text) {
		
		Select s=new Select(element);
		s.selectByVisibleText(text);

	}
	 public static  void MousehoverClick(WebElement element) {
		
		 Actions a=new Actions(driver);
		 a.moveToElement(element).click().build().perform();

	}
	 public static String getElementValue(WebElement element) {
		
		return element.getText();

	}
	 
	 public static void uploadFile(String dirpath) throws InterruptedException, Throwable {
Thread.sleep(8000);
StringSelection ss=new StringSelection(System.getProperty("user.dir")+"\\uploadfile\\sampletoaster.txt");
 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
Thread.sleep(4000);
 
Robot r=new Robot();
r.keyPress(KeyEvent.VK_CONTROL);
r.keyPress(KeyEvent.VK_V);;

r.keyRelease(KeyEvent.VK_CONTROL);
r.keyRelease(KeyEvent.VK_V);;

Thread.sleep(4000);
r.keyPress(KeyEvent.VK_ENTER);
r.keyRelease(KeyEvent.VK_ENTER);

	}
	

}
