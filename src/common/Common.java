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
	
	public static String YSLURL = "https://ysl.dev2.oggettoweb.com";
	
	public static int pageLoadTimeout = 120;
	
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