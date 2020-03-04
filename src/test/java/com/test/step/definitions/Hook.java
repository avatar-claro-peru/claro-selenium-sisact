package com.test.step.definitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Hook {
	
	public static WebDriver driver;
	
	@Before("@web")
	public void inicioWeb(){
		
		// Codigo para trabajar con firefox
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\desarrollo\\git\\devops\\Cucum\\Driver\\geckodriver.exe");		
		//driver = new FirefoxDriver();
		
		// Chrome
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\desarrollo\\git\\devops\\Cucum\\src\\test\\resources\\files\\software\\windows\\chromedriver.exe");	
		System.setProperty("webdriver.chrome.driver","X:\\Unidad_X\\workspace_avatar\\rest\\claro-selenium\\claro-selenium-sisact\\src\\test\\resources\\files\\software\\windows\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Before("@Mobile")
	public void iniciMobile() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "A4N4C19816006731");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("autoGrantPermissions", "true");
		cap.setCapability("noReset", true);
		cap.setCapability("fullReset", false);
		cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		
		
		AndroidDriver<MobileElement> driverAndroid = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		
		driver = driverAndroid;
	}
	
//	@After
//	public void browserClose() {
//		driver.close();
//	}

	public static WebDriver getDriver() {
		return driver;
	}
	
}
