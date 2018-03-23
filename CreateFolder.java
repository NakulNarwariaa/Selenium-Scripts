package sample;



import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateFolder {
	
	public AndroidDriver dr;

  @Test()
  public void CreatFolderOnWorkspace() throws InterruptedException {
	 try{
	  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
	  dr.findElementByName("Search apps...").sendKeys("Cloc");
	   new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Clock")).moveTo(578,856).release().perform();
	   Boolean app1=dr.findElementsById("launcher3.android.com.hivelauncher:id/hotseat").size() >0;
	   if(app1)
	   {
		   System.out.println("Clock App placed on the homescreen: Test Case Passed");
	   }
	 
	   Boolean app=dr.findElementsByName("Get more on Google Play").size() >0;
		  outer:
		   for(int i=0;i<5;i++)
		   {
	   if(app)
	   {
		   
		   new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Clock")).moveTo(578,856).release().perform();
		   Boolean app2=dr.findElementsById("launcher3.android.com.hivelauncher:id/hotseat").size() >0;
		   if(app2)
		   {
			   System.out.println("Clock App placed on the homescreen: Test Case Passed");
			   break;
		   }
		   if(app)
		   {
		   continue outer;
		   }
	   }
	   }
	 }
	 catch(Exception e)
	 {
		 System.out.println("Exception while creating a shortcut for clock app " +e);
		 
	 }
	 
		dr.sendKeyEvent(AndroidKeyCode.HOME);
	  Thread.sleep(3000);
	  
	try{
	  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
	  dr.findElementByName("Search apps...").sendKeys("downloa");
	  Thread.sleep(3000);
	  new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Downloads")).moveTo(578,856).release().perform();
	  Boolean app1=dr.findElementsById("launcher3.android.com.hivelauncher:id/hotseat").size() >0;
	   if(app1)
	   {
		   System.out.println("Downloads App placed on the homescreen: Test Case Passed");
	   }
	  Boolean app=dr.findElementsByName("Get more on Google Play").size() >0;
	  outer:
	   for(int i=0;i<5;i++)
	   {
   if(app)
   {
	   
	   new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Downloads")).moveTo(578,856).release().perform();
	   Boolean app2=dr.findElementsById("launcher3.android.com.hivelauncher:id/hotseat").size() >0;
	   if(app2)
	   {
		   System.out.println("Downloads App placed on the homescreen: Test Case Passed");
		   break;
	   }
	   if(app)
	   {
	   continue outer;
	   }
   }
   }
 }
 catch(Exception e)
 {
	 System.out.println("Exception while creating a shortcut for Downloads app " +e);
	 
 }
	dr.sendKeyEvent(AndroidKeyCode.HOME);
	  Thread.sleep(3000);

	  try{
	  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
	  dr.findElementByName("Search apps...").sendKeys("Calculat");
	  Thread.sleep(3000);
	  new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Calculator")).moveTo(578,856).release().perform();
	  Boolean app1=dr.findElementsById("launcher3.android.com.hivelauncher:id/hotseat").size() >0;
	   if(app1)
	   {
		   System.out.println("Calculator App placed on the homescreen: Test Case Passed");
		  
	   }
	  Boolean app=dr.findElementsByName("Get more on Google Play").size() >0;
	  outer:
	   for(int i=0;i<5;i++)
	   {
   if(app)
   {
	  
	   new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Calculator")).moveTo(578,856).release().perform();
	   Boolean app2=dr.findElementsById("launcher3.android.com.hivelauncher:id/hotseat").size() >0;
	   if(app2)
	   {
		   System.out.println("Calculator App placed on the homescreen: Test Case Passed");
		   break;
		   
	   }
	   if(app)
	   {
	   continue outer;
	   }
   }
   }
 }
 catch(Exception e)
 {
	 System.out.println("Exception while creating a shortcut for Calculator app " +e);
	 
 }


	   try{
	 new TouchAction((MobileDriver) dr).longPress(dr.findElementByXPath("//android.widget.FrameLayout[@content-desc='Folder: ']")).moveTo(514, 237).release().perform();
	 System.out.println("Created folder on the Homescreen: Test Case Passed");
	   }
	   catch(Exception e)
	   {
		   System.out.println("Folder is not created on the homescreen : Test Case Failed");
	   }
	 
	 }
	 

  
  
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

