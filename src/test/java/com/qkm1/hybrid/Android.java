package com.qkm1.hybrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Android {
	
	AndroidDriver driver;
	 
	@BeforeClass  
	public void startDriver() throws MalformedURLException {
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("Capability_Username", "pranith.suvarna@qualitykiosk.com");
	capabilities.setCapability("Capability_ApiKey", "2zz9g8kp8k8jqpt9jtvkgvdb");
	capabilities.setCapability("Capability_DurationInMinutes", 10);
	capabilities.setCapability("newCommandTimeout", 600);
	capabilities.setCapability("launchTimeout", 90000);
	capabilities.setCapability("Capability_DeviceFullName", "ONEPLUS_5T_Android_9.0.0_0d49e");
	capabilities.setCapability("platformVersion", "9.0.0");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("automationName", "uiautomator2");
	capabilities.setCapability("Capability_ApplicationName", "appdebug.apk");
	capabilities.setCapability("appPackage", "com.telemed.nsdl");
	capabilities.setCapability("appActivity", "io.ionic.starter.MainActivity");
	capabilities.setCapability("Capability_WildNet", "false");
	capabilities.setCapability("Capability_EnableVideo", "true");
	capabilities.setCapability("Capability_EnablePerformanceData", "true");
	capabilities.setCapability("Capability_EnableDeviceLogs", "true");
	capabilities.setCapability("appiumVersion", "1.20.2");
	driver = new AndroidDriver<WebElement>(new URL("https://qkm1.qualitykiosk.com/appiumcloud/wd/hub"), capabilities);

	}
	
	@Test
	public void test_01() throws InterruptedException {
		

		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
		driver.context("WEBVIEW_com.telemed.nsdl"); // set context to WEBVIEW_1

		
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='email_id']")))).sendKeys("DOCTORTEST");
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='pass']")))).sendKeys("Pass@123");
	//    driver.context("NATIVE_APP");
	    try {
	        driver.hideKeyboard();
	      } catch (Exception exception) {}
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='captchaInput']")))).sendKeys("ASDFG");
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//ion-button[text()='Submit']")))).click();
	    
	    Thread.sleep(10000);

	}  
	
	 @AfterClass
		public void quitDriver() {
			
	     driver.quit();
		}

}
