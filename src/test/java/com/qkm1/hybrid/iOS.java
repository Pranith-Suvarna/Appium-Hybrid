package com.qkm1.hybrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;

public class iOS {
	
static IOSDriver driver;

String setNativeContext;
String setWebContext;

      
  public void switchView() {
   Set<String>contextNames = driver.getContextHandles();
   for (String contextName : contextNames) {
    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
   }
   
   setNativeContext = contextNames.toArray()[0].toString();
   setWebContext = contextNames.toArray()[1].toString();

  }

	@BeforeClass
	public void startDriver() throws MalformedURLException {
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("Capability_Username", "pranith.suvarna@qualitykiosk.com");
	capabilities.setCapability("Capability_ApiKey", "ychfprd36krsxc5qrt68b7j3");
	capabilities.setCapability("Capability_DurationInMinutes", 10);
	capabilities.setCapability("newCommandTimeout", 600);
	capabilities.setCapability("launchTimeout", 120000);
	capabilities.setCapability("Capability_DeviceFullName", "APPLE_iPhoneXS_iOS_12.3.0_c4af0");
	capabilities.setCapability("platformVersion", "12.3.0");
	capabilities.setCapability("platformName", "ios");
	capabilities.setCapability("acceptAlerts", true);
	capabilities.setCapability("automationName", "XCUITest");
	capabilities.setCapability("Capability_ApplicationName", "App_Resigned1640273110.ipa");
	capabilities.setCapability("bundleId", "com.telemed.nsdl");
//	capabilities.setCapability("additionalWebviewBundleIds", "process-SafariViewService");
//	capabilities.setCapability("autoWebview", "true");
	capabilities.setCapability("includeSafariInWebviews", true);
	capabilities.setCapability("webviewConnectTimeout", 90000);
//	capabilities.setCapability("webviewConnectRetries", 10);
	capabilities.setCapability("Capability_WildNet", "false");
	capabilities.setCapability("Capability_EnableVideo", true);
	capabilities.setCapability("Capability_EnablePerformanceData", true);
	capabilities.setCapability("Capability_EnableDeviceLogs", true);
	capabilities.setCapability("appiumVersion", "1.20.2");
	driver = new IOSDriver<WebElement>(new URL("https://qkmstaging.qualitykiosk.com/appiumcloud/wd/hub"), capabilities);
	
}
	
	@Test
	public void test_01() throws Exception {
		
		
	    switchView();
      
     /*   driver.context(setWebContext);
        
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='email_id']")))).sendKeys("DOCTORTEST");
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='pass']")))).sendKeys("Pass@1234");
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Telemedicine']")))).click();
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='captchaInput']")))).sendKeys("ASDFG");
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Telemedicine']")))).click();
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//ion-button[text()='Submit']")))).click();
	    
	    //*[@id='main-content']//following::ion-menu-button
	//  (//*[@slot='start'])[2]
	    
	    Thread.sleep(5000);
	    System.out.println("slept");
	    
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='main-content']//following::ion-menu-button")))).click();
	    Point e1 = driver.findElement(By.xpath("//*[@id='main-content']//following::ion-menu-button")).getLocation();
	    System.out.println("drawer=" + e1);
	    
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='logout-icon']")))).click();
	    Point e2 = driver.findElement(By.xpath("//img[@class='logout-icon']")).getLocation();
	    System.out.println("logout=" + e2);
	    Thread.sleep(5000);
*/	    
	    driver.context(setNativeContext);
	    
	    driver.findElement(By.xpath("//XCUIElementTypeButton[@name='DOCTOR REGISTRATION']")).click();    
	    driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Browse here']")).click();
//	    driver.findElement(By.xpath("//*[@type='XCUIElementTypeTable']//descendant::XCUIElementTypeStaticText[3]")).click();
//	    driver.findElement(By.xpath("(//*[@type='XCUIElementTypeCell'])[3]//child::XCUIElementTypeStaticText")).click();
	    driver.findElement(By.xpath("//XCUIElementTypeCell[2]/XCUIElementTypeStaticText")).click(); 
	    ((WebElement)(new WebDriverWait((WebDriver)driver, 60L)).until((Function)ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]")))).click();
        driver.findElement(By.xpath("(//*[@type='XCUIElementTypeCell'])[3]")).click();
        driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Full Name *']")).sendKeys("XYZ");


	    
	    Thread.sleep(2000);

	    //9623752492
	    //Prajwal@123
	    
	    //DOCTORTEST
	    //Pass@1234
     
	}  
	
	 @AfterClass
		public void quitDriver() {
			
	     driver.quit();
	     
		}
	
}
