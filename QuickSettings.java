package sample;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class QuickSettings {
@SuppressWarnings("rawtypes")
private AndroidDriver dr;
Scanner scn1;
int a=0;
static int count=0;

@SuppressWarnings("rawtypes")
@BeforeTest	
public void setUp() throws Exception{

	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
capabilities.setCapability(MobileCapabilityType.VERSION,"4.4.2");
capabilities.setCapability(MobileCapabilityType.PLATFORM, "Windows");
capabilities.setCapability("deviceName", "0123456789ABCDEF");
capabilities.setCapability("platformName", "Android");
capabilities.setCapability("appPackage","launcher3.android.com.hivelauncher");
capabilities.setCapability("appActivity","com.android.launcher3.Launcher");


dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
dr.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
}



@Test
public void calc() throws Exception
{
Thread.sleep(3000);
	 dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
	 dr.findElementByName("Search apps...").sendKeys("cehjmosvwz"); 
	Thread.sleep(15000);
////dr.findElementById("org.mozilla.firefox:id/url_edit_text").click();//.sendKeys("what is my user agent.com");
//	Thread.sleep(3000);
//dr.openNotifications();
//Thread.sleep(3000);
//
//dr.findElementById("com.android.systemui:id/header").click();
//dr.findElementById("com.android.systemui:id/slider").click();
//
//dr.findElementByName("Flashlight").click();
//Thread.sleep(3000);
//dr.findElementByName("Flashlight").click();
//
////To check Bluetooth option present or not
//Boolean Bluetooth=dr.findElementsByName("Bluetooth").size() >0;
//if(Bluetooth)
//{
//	   System.out.println("Bluetooth is present: Test case Passed");
//}
//else
//{
//	   System.out.println("Bluetooth  is not present: Test case Failed");
//}
//
//Boolean AM=dr.findElementsByName("Airplane mode").size() >0;
//if(AM)
//{
//	   System.out.println("Airplane mode is present: Test case Passed");
//}
//else
//{
//	   System.out.println("Airplane mode  is not present: Test case Failed");
//}
//
//Boolean flashlight=dr.findElementsByName("Flashlight").size() >0;
//if(flashlight)
//{
//	   System.out.println("Flashlihgt is present: Test case Passed");
//}
//else
//{
//	   System.out.println("Flashlight  is not present: Test case Failed");
//}
//
//
//Boolean Location=dr.findElementsByName("Location").size() >0;
//if(Location)
//{
//	   System.out.println("Location is present: Test case Passed");
//}
//else
//{
//	   System.out.println("Location  is not present: Test case Failed");
//}
	}
@AfterTest
public void quit() throws Exception
{
	
	if(dr!= null){
    dr.quit();
}
}

}


        