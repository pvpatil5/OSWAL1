package com.oswal.poc;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Login implements Sample
{
	public AndroidDriver driver ;
	
	@Test
	public void launchApp() throws Throwable 
	{

		DesiredCapabilities cap ;
		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("UDID", "emulator-5554");
		cap.setCapability("noReset", false);	
		cap.setCapability("appPackage","com.mosl.mobile.dev");
		cap.setCapability("appActivity", "com.mosl.mobile.splash.SplashActivity");

		URL url = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(url, cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MobileElement skipbtn =(MobileElement) driver.findElementById("com.mosl.mobile.dev:id/skip");
		
		skipbtn.click();
		
		MobileElement username = (MobileElement) driver.findElementById("com.mosl.mobile.dev:id/edClientCode");

		MobileElement password = (MobileElement) driver.findElementById("com.mosl.mobile.dev:id/edClientPass");

		username.sendKeys("KIH009");
		
		password.sendKeys("abc@123");
		
		MobileElement loginbtn =(MobileElement) driver.findElementById("com.mosl.mobile.dev:id/btnLogin");
		
		loginbtn.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MobileElement skipbtnbottom=(MobileElement) driver.findElementById("com.mosl.mobile.dev:id/tvSkip");
		
		skipbtnbottom.click();
		
		MobileElement homeicon=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='HOME']");
		
		String home =homeicon.getText();
		
		Assert.assertEquals(home, "HOME");
		
		MobileElement drawermenu =(MobileElement) driver.findElementsByAccessibilityId("Drawer Menu");
		
		drawermenu.click();
		
		MobileElement clientname= (MobileElement) driver.findElementById("com.mosl.mobile.dev:id/tvClientName");
		
		String consumername=clientname.getText();
		
		Assert.assertEquals(consumername, "ATUL KUMAR JAIN");
		
		
		
		
	}

	public void abc() {
		// TODO Auto-generated method stub
		
	}

	public void bbbc(String a) {
		// TODO Auto-generated method stub
		
	}

	
}
