package com.oswal.poc;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class LaunchApp 
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
		cap.setCapability("noReset", true);	
		cap.setCapability("appPackage","com.mosl.mobile.dev");
		cap.setCapability("appActivity", "com.mosl.mobile.splash.SplashActivity");

		URL url = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(url, cap);

		
		

	}

}
