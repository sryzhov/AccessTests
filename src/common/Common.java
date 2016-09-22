package common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

import javax.imageio.ImageIO;

import org.bouncycastle.util.encoders.Hex;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
	
	public static WebDriver userDriver;
	
	public static String CaritaURL = "http://carita.oggettoweb.com";
	public static String ClarisonicURL = "https://clarisonic.oggettoweb.com";
	public static String DecleorURL = "https://decleor.oggettoweb.com";
	public static String EssieURL = "https://essie-renovation.oggettoweb.com";
	public static String IntersalesURL = "http://intersales.oggettoweb.com";
	public static String IntersalesVirginURL = "http://intersales-virgin.oggettoweb.com";
	public static String KerastaseURL = "https://kerastase.oggettoweb.com";
	public static String KiehlsURL = "https://kiehls.oggettoweb.com";
	public static String LancomeURL = "https://lancome.oggettoweb.com";
	public static String MatrixURL = "https://matrix.dev.oggettoweb.com";
	public static String NYXURL = "https://nyx.dev.oggettoweb.com";
	public static String NYXOldURL = "http://nyx-old.oggettoweb.com";
	public static String RedkenURL = "https://redken.oggettoweb.com";
	//public static String SkinceuticalsDevURL = "skinceuticals.dev.oggettoweb.com";
	public static String UrbandecayURL = "https://urbandecay.oggettoweb.com";
	public static String VichyLastVirginURL = "http://vichy-lastvirgin-vbg.oggettoweb.com";
	public static String VichyURL = "http://vichy.oggettoweb.com";
	public static String BiothermURL = "http://biotherm.dev2.oggettoweb.com";
	public static String ArmaniURL = "http://giorgio-armani.dev2.oggettoweb.com";
	public static String LorealRenovationURL = "http://loreal-renovation.dev2.oggettoweb.com";
	public static String LRPURL = "http://lrp-new.dev2.oggettoweb.com";
	public static String SkinceuticalsDev2URL = "http://www.skinceuticals.dev2.oggettoweb.com";
	public static String SkinceuticalsRenovationURL = "http://skinceuticals-renovation.dev2.oggettoweb.com";
	public static String YSLURL = "https://ysl.dev2.oggettoweb.com";
	
	public static int pageLoadTimeout = 60;
	
	public static String driverName;
	
	public static FirefoxProfile firefoxProfile;
	
	public static WaitTool waitTool;
	
	public void Init(){
		driverName = "firefox";
		
		waitTool = new WaitTool();
		
		// setup firefox specified properties
		firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("network.http.use-cache", false);
		firefoxProfile.setPreference("browser.cache.offline.enable", false);
		firefoxProfile.setPreference("browser.cache.disk.enable", false);
		firefoxProfile.setPreference("browser.cache.disk_cache_ssl", false);
		firefoxProfile.setPreference("browser.cache.memory.enable", false);
		firefoxProfile.setEnableNativeEvents(false);
		
	}
	
	public WebDriver CreateDriver(String browserName){
		WebDriver driver = null;
		
		if (browserName == "firefox")
			driver = new FirefoxDriver(firefoxProfile);
		
		if (driver == null)
			driver = new FirefoxDriver(firefoxProfile);
		
		return driver;
	}
	
	/**
	 *  Функция сохраняет скрин экрана указанного драйвера
	 */
    public static void SaveFullScreenshot(WebDriver driver, String name) throws IOException {
        File screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        String path = "./screens/failed/";
        
        if (driver.equals(Common.userDriver))
        	path = path + "/frontend/";
        
        path = path + name + ".png";
        FileUtils.copyFile(screenshot, new File(path));
    }

}