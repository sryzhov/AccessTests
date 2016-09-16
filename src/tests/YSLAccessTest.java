package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import common.Common;

public class YSLAccessTest {
	
private static Common common;
	
	@Rule
	public TestWatcher screenshotRule = new TestWatcher() {

		@Override
		protected void starting(Description description) {
			try {
				common = new Common();
				Common.userDriver = common.CreateDriver(Common.driverName);
				Common.userDriver.manage().timeouts().pageLoadTimeout(Common.pageLoadTimeout, TimeUnit.SECONDS);
				Common.userDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				Common.userDriver.manage().window().maximize();
				Common.userDriver.manage().window().setSize(new Dimension(1600, 1200));
				Common.userDriver.get(Common.YSLURL);
			}
			catch (TimeoutException e) {
				
				JavascriptExecutor js =(JavascriptExecutor)Common.userDriver;
				String message = (String) js.executeScript("return document.readyState;"); 
				System.out.println("Состояние загрузки страницы - " + message);
				
			}
		}

		@Override
		protected void finished(Description description) {
			Common.userDriver.quit();
		}

		@Override
		protected void failed(Throwable e, Description description) {
			try {
				Common.SaveFullScreenshot(Common.userDriver, description.getClassName()+"_"+ description.getMethodName());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	};
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// код вызывается в TestWatcher.starting()
	}
	
	@After
	public void tearDown() throws Exception {
		// код вызывается в TestWatcher.finished()
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	
	@Test
	public void YSLAccessTestCase() throws Exception{
		
		try {
		
			assertFalse("Сайт " + Common.YSLURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).isDisplayed());

		}
			catch (NoSuchElementException e) {
				
			}
		
	}

}
