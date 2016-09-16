package common;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTool {
	
	public static final int DEFAULT_WAIT_4_ELEMENT = 7;
	public static final int DEFAULT_WAIT_4_PAGE = 12;
	
	public static WebElement waitForElement(WebDriver driver, final By by, int timeOutInSeconds) {
		
		WebElement element;
		try{	
		
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS);
			return element;
		} 
		catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
	
	public static WebElement waitForElementPresent(WebDriver driver, final By by, int timeOutInSeconds) {
		
		WebElement element;
		try{
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

		driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); 
		return element; 
		} 
		catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
	
	public static boolean waitForAnyAjax(WebDriver driver){
		boolean result1 = waitForPrototypeProcessing(driver, 60);
		boolean result2 = waitForJQueryProcessing(driver, 60);
		return result1 && result2; 
	}
	
	// Ждет окончания загрузки страницы
	public static void waitForPageLoad(WebDriver driver) {
	    ExpectedCondition<Boolean> pageLoadCondition = new
	        ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	            }
	        };
	    Wait<WebDriver> wait = new WebDriverWait(driver, 30).withMessage("Превышено время ожидания загрузки страницы (30 секунд).");
	    wait.until(pageLoadCondition);
	}
	
	// Ждет окончания загрузки основных элементов
	public static void waitForDOMLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new
		    ExpectedCondition<Boolean>() {
		        public Boolean apply(WebDriver driver) {
		            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("interactive");
		        }
		    };
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}
	
	public static boolean waitForJQueryProcessing(WebDriver driver, int timeOutInSeconds){
		
		boolean jQcondition = false;
		try{	
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
		new WebDriverWait(driver, timeOutInSeconds) {
		}.until(new ExpectedCondition<Boolean>() {

		@Override
		public Boolean apply(WebDriver driverObject) {
		return (Boolean) ((JavascriptExecutor) driverObject).executeScript("return ((window.jQuery == undefined) || (jQuery.active == 0))");
		}
		});
		jQcondition = (Boolean) ((JavascriptExecutor) driver).executeScript("return ((window.jQuery == undefined) || (jQuery.active == 0))");
		driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); //reset implicitlyWait
		return jQcondition;
		} catch (Exception e) {
		e.printStackTrace();
		}
		return jQcondition;
	}
	
	public static boolean waitForPrototypeProcessing(WebDriver driver, int timeOutInSeconds){
		
		boolean jQcondition = false;
		try{	
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
		new WebDriverWait(driver, timeOutInSeconds) {
		}.until(new ExpectedCondition<Boolean>() {

		@Override
		public Boolean apply(WebDriver driverObject) {

			return (Boolean) ((JavascriptExecutor) driverObject).executeScript("return ((typeof(Prototype) == 'undefined') || (Ajax.activeRequestCount == 0))");
		}
		});
		jQcondition = (Boolean) ((JavascriptExecutor) driver).executeScript("return ((typeof(Prototype) == 'undefined') || (Ajax.activeRequestCount == 0))");
		driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); //reset implicitlyWait
		return jQcondition;
		} catch (Exception e) {
		e.printStackTrace();
		}
		return jQcondition;
	}

}
