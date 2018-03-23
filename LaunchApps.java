package sample;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchApps {
	 Excel e1=new Excel();
	static int CountAppsLaunched=0;
	static int AppsPresent=0;
	@SuppressWarnings("rawtypes")
	public AndroidDriver dr;

  @Test()
  public void LaunchAppsFromAppTray() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
	  
	  long startTime= System.currentTimeMillis();
	  try{
		  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		  @SuppressWarnings("unchecked")
		List<WebElement> ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/application_icon");
		  int ca2=ca.size();
		  AppsPresent=ca2;
		  System.out.println("Apps Present in first set =" +ca2); 
		  for(int i=0;i<ca2;i++)
		  {
			  String s=ca.get(i).getText();
			  dr.findElementByName(s).click();
			  System.out.println("App  " +(i+1) +"   "  +s   +"  Launched");
			//  Thread.sleep(5000);
			    dr.sendKeyEvent(AndroidKeyCode.HOME);
			    dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			    
			   ++CountAppsLaunched;
		  }
		 
		    dr.sendKeyEvent(AndroidKeyCode.HOME);
	  }
	  catch(Exception e)
		{
			System.out.println("Exception While launching the apps (1st Set) " + e);
		}
	  
	  try{
		  
		  
		  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		  System.out.println("********------- Launching Second set of apps -----------******");
		  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"YouTube\"))");
		  @SuppressWarnings("unchecked")
		List<WebElement> ca=dr.findElementsById("launcher3.android.com.hivelauncher:id/application_icon");
		  int ca2=ca.size();
		  AppsPresent=AppsPresent+ca2;
		  System.out.println("Apps Present =" +ca2); 
		  for(int i=0;i<ca2;i++)
		  {
			  String s=ca.get(i).getText();
			  dr.findElementByName(s).click();
			  System.out.println("App  " +(i+1) +"   "  +s   +"  Launched");
			//  Thread.sleep(5000);
			    dr.sendKeyEvent(AndroidKeyCode.HOME);
			    dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
			    ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"YouTube\"))");
			    ++CountAppsLaunched;
		  }
		 
       
	  }
	  catch(Exception e)
		{
			System.out.println("Exception While launching the apps (2nd Set) " + e);
			e1.notExecuted(45);
		}
	  
	  if(CountAppsLaunched==AppsPresent)
	  {
		  System.out.println("All the apps launched Successfully: Test Case Passed");
		  e1.pass(45);
		  
	  }
	  else
	  {
		  System.out.println("All the apps launched not launched Successfully: Test Case Failed");
		  e1.fail(45);
	  }
	  System.out.println("Total Apps Launched =" +CountAppsLaunched);
	  
	  long endTime= System.currentTimeMillis();
	  long totalTime=endTime-startTime;
	  long tt=totalTime/1000;
	  e1.timeTaken(45, tt);
	  System.out.println("Total time taken to launch all apps present on app tray (TimeUnit: In Seconds ) " +tt);
  }
  
  @SuppressWarnings("rawtypes")
@BeforeMethod
  public void beforeMethod() throws MalformedURLException  {
	  
	  DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.VERSION, "4.4.2");
			capabilities.setCapability(MobileCapabilityType.PLATFORM, "Windows");
			capabilities.setCapability("deviceName", "0123456789ABCDEF");
			capabilities.setCapability("platformName", "Android");

			capabilities.setCapability("appPackage","launcher3.android.com.hivelauncher");
			capabilities.setCapability("appActivity","com.android.launcher3.Launcher");
			dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  
		if (dr != null) {
			dr.quit();
		}
	
  }

}

