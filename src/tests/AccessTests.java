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
import common.WaitTool;

public class AccessTests {
	
	private static Common common;
	
	@Rule
	public TestWatcher screenshotRule = new TestWatcher() {

		@Override
		protected void starting(Description description) {
			common = new Common();
			Common.userDriver = common.CreateDriver(Common.driverName);
			Common.userDriver.manage().timeouts().pageLoadTimeout(Common.pageLoadTimeout, TimeUnit.SECONDS);
			Common.userDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			Common.userDriver.manage().window().maximize();
			Common.userDriver.manage().window().setSize(new Dimension(1600, 1200));
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
	public void CaritaAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.CaritaURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.CaritaURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void ClarisonicAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.ClarisonicURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.ClarisonicURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void DecleorAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.DecleorURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.DecleorURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void EssieAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.EssieURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.EssieURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void IntersalesAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.IntersalesURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.IntersalesURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void IntersalesVirginAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.IntersalesVirginURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.IntersalesVirginURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void KerastaseAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.KerastaseURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.KerastaseURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void LancomeAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.LancomeURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.LancomeURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void MatrixAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.MatrixURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.MatrixURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void NYXAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.NYXURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.NYXURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void NYXOldAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.NYXOldURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.NYXOldURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void KiehlsAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.KiehlsURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.KiehlsURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void UrbandecayAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.UrbandecayURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.UrbandecayURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void VichyLastVirginAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.VichyLastVirginURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.VichyLastVirginURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void VichyAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.VichyURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.VichyURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void RedkenAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.RedkenURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.RedkenURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void BiothermAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.BiothermURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.BiothermURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void ArmaniAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.ArmaniURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.ArmaniURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void LorealRenovationAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.LorealRenovationURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.LorealRenovationURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void LRPAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.LRPURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.LRPURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void SkinceuticalsDev2AccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.SkinceuticalsDev2URL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.SkinceuticalsDev2URL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void SkinceuticalsRenovationAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.SkinceuticalsRenovationURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.SkinceuticalsRenovationURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void YSLAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get(Common.YSLURL);
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт " + Common.YSLURL + " открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}
	
	@Test
	public void TestAccessTestCase() throws Exception{
		
		try {
			Common.userDriver.get("http://st.edutainme.ru/");
		}
			catch (TimeoutException t) {
				Common.userDriver.switchTo().alert().dismiss();
				WaitTool.waitForPageLoad(Common.userDriver);
			}
		
		assertTrue("Сайт открыт для внешнего доступа.", Common.userDriver.findElement(By.xpath("//body")).getText().contains("401 Authorization Required"));
		
	}

}
