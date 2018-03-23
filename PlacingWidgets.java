package sample;



import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlacingWidgets {
	static int countTestCasePassed=0;
	 Excel e1=new Excel();
	@SuppressWarnings("rawtypes")
	public AndroidDriver dr;

  @SuppressWarnings("rawtypes")
@Test()
  public void PlacingWidgetsAndRemove() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
	
	  
	  long startTime= System.currentTimeMillis();
	  try{
	  Boolean gSearch= dr.findElementsById("com.google.android.googlequicksearchbox:id/search_edit_frame").size() >0;
	   if(gSearch)
	   {
		   System.out.println("Google Search bar is present, Hence removing that widget to place other widget");
		   new TouchAction((MobileDriver) dr).longPress(dr.findElementById("com.google.android.googlequicksearchbox:id/search_edit_frame")).moveTo(479,238).release().perform();
		   Thread.sleep(2000);
	   }
	   else
	   {
		   System.out.println("Google Search bar is not present, Hence we can place other widgets");
	   }
	  }
	  catch(Exception e)
	  {
		  System.out.println("Exception while checking for Google search bar" +e);
	  }
	  
	  
	  // Tocheck total widgets & apps on the homescreen
	  @SuppressWarnings("unchecked")
	List<WebElement> cw=dr.findElementsByXPath("//android.appwidget.AppWidgetHostView");
	  int countWidgets=cw.size();
	  System.out.println("Total Widgets present on first HomeScreen = " +countWidgets);
	  if(countWidgets==0)
	  {
		  System.out.println("There are no widgets now, we can place the other widget");
	  }
	  else
	  {
		  System.out.println("There are other widgets ont the screen, Hence remmove those widgets & run the script");
	  }
	  
	  // To count number of Apps in the homescreen
	  @SuppressWarnings("unchecked")
	List<WebElement> ca1=dr.findElementsByXPath("//android.widget.TextView");
	  int countApps=ca1.size();
	  System.out.println("Total Apps present on first HomeScreen = " +(countApps-5));
	  if(countApps<=13)
	  {
		  System.out.println("2 Apps are present in the 1st homescreen, Hence we can place the other widget");
	  }
	  else
	  {
		  System.out.println("The apps present on the 1st homescreen is more than 8 ");
	  }
	  
	  WebElement fn=dr.findElementById("launcher3.android.com.hivelauncher:id/workspace"); 
	  dr.sendKeyEvent(AndroidKeyCode.HOME);
	  try{
	  new TouchAction((MobileDriver) dr).longPress(fn).perform();
	  dr.findElementById("launcher3.android.com.hivelauncher:id/widget_button").click();	 
	  new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Analog clock")).moveTo(340,493).release().perform();
	  Boolean analog= dr.findElementsById("com.android.deskclock:id/analog_appwidget").size() >0;
	   if(analog)
	   {
		   System.out.println("Placing Analog Clock widget: Test Case Passed");
		   ++countTestCasePassed;
		   e1.pass(46);
	   }
	   else
	   {
		   System.out.println("Placing Analog Clock widget: Test Case Failed");
		   e1.fail(46);
	   }
	  new TouchAction((MobileDriver) dr).longPress(dr.findElementById("com.android.deskclock:id/analog_appwidget")).moveTo(530,295).release().perform();
	  Boolean analogRemove= dr.findElementsById("com.android.deskclock:id/analog_appwidget").size() >0;
	   if(analogRemove)
	   {
		   System.out.println("Removed Analog Clock widget: Test Case Failed");
		   e1.fail(47);
	   }
	   else
	   {
		   System.out.println("Removed Analog Clock widget: Test Case Passed");
		   e1.pass(47);
	   }
	  }
	  catch(Exception e)
	  {
		  System.out.println("Exception while placing clock widget" +e);
		  e1.notExecuted(47);
	  }
	  
	  dr.sendKeyEvent(AndroidKeyCode.HOME);
	  try{
	  Thread.sleep(3000);
	  // To place Calendar Widget 
	  new TouchAction((MobileDriver) dr).longPress(fn).perform();
	  dr.findElementById("launcher3.android.com.hivelauncher:id/widget_button").click();
	  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Calendar\"))");
	   new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Calendar")).moveTo(340,493).release().perform();
	   Thread.sleep(2000);
	   Boolean calen= dr.findElementsById("com.android.calendar:id/header").size() >0;
	   if(calen)
	   {
		   System.out.println("Placing calendar widget: Test Case Passed");
		   ++countTestCasePassed;
		   e1.pass(48);
	   }
	   else
	   {
		   System.out.println("Placing calendar widget: Test Case Failed");
		   e1.fail(48);
	   }
	   new TouchAction((MobileDriver) dr).longPress(dr.findElementById("com.google.android.calendar:id/header2")).moveTo(500,254).release().perform();
	   Boolean calenRemove= dr.findElementsById("com.google.android.calendar:id/header2").size() >0;
	   if(calenRemove)
	   {
		   System.out.println("Removed Calendar widget: Test Case Failed");
		   e1.fail(49);
	   }
	   else
	   {
		   System.out.println("Removed calendar widget: Test Case Passed");
		   e1.pass(49);
	   }
	  }
	  catch(Exception e)
	  {
		  System.out.println("Exception while placing calendar widget" +e);
		  e1.notExecuted(49);
	  }
	   
	   dr.sendKeyEvent(AndroidKeyCode.HOME);
		  try{
	   // To place the didgital clock 
	   new TouchAction((MobileDriver) dr).longPress(fn).perform();
	   dr.findElement(By.id("launcher3.android.com.hivelauncher:id/widget_button")).click();
	   ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Digital clock\"))");
	   new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Digital clock")).moveTo(340,493).release().perform();
	   Boolean digital= dr.findElementsById("com.android.deskclock:id/the_clock").size() >0;
	   if(digital)
	   {
		   System.out.println("Placing Digital Clock widget: Test Case Passed");
		   ++countTestCasePassed;
		   e1.pass(50);
	   }
	   else
	   {
		   System.out.println("Placing Digital Clock widget: Test Case Failed");
		   e1.fail(50);
	   }
	   new TouchAction((MobileDriver) dr).longPress(dr.findElementById("com.android.deskclock:id/digital_appwidget")).moveTo(496,315).release().perform();
	   Boolean digitalRemove= dr.findElementsById("com.android.deskclock:id/digital_appwidget").size() >0;
	   if(digitalRemove)
	   {
		   System.out.println("Removed Digital Clock widget: Test Case Failed");
		   e1.fail(51);
	   }
	   else
	   {
		   System.out.println("Removed Digital Clock widget: Test Case Passed");
		   e1.pass(51);
	   }
		  }
		  catch(Exception e)
		  {
			  System.out.println("Exception while placing digital clock widget" +e);
			  e1.notExecuted(51);
		  }
	   

	   dr.sendKeyEvent(AndroidKeyCode.HOME);
		  try{
	   //To place Google serach bar
	   new TouchAction((MobileDriver) dr).longPress(fn).perform();
	   dr.findElement(By.id("launcher3.android.com.hivelauncher:id/widget_button")).click();
	   ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Google App\"))");
	   new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Google App")).moveTo(551,642).release().perform();
	   Boolean gs= dr.findElementsById("com.google.android.googlequicksearchbox:id/search_edit_frame").size() >0;
	   if(gs)
	   {
		   System.out.println("Placing Google Search widget: Test Case Passed");
		   ++countTestCasePassed;
		   e1.pass(52);
	   }
	   else
	   {
		   System.out.println("Placing Google Search widget: Test Case Failed");
		   e1.fail(52);
	   }
	   new TouchAction((MobileDriver) dr).longPress(dr.findElementById("com.google.android.googlequicksearchbox:id/search_edit_frame")).moveTo(530,295).release().perform();
	   Boolean gsRemove= dr.findElementsById("com.google.android.googlequicksearchbox:id/search_edit_frame").size() >0;
	   if(gsRemove)
	   {
		   System.out.println("Removed Google Search widget: Test Case Failed");
		   e1.fail(53);
	   }
	   else
	   {
		   System.out.println("Removed Google Search widget: Test Case Passed");
		 
		   e1.pass(53);
	   }
		  }
		  catch(Exception e)
		  {
			  System.out.println("Exception while placing google search widget" +e);
			  e1.notExecuted(53);
		  }
	   
	   dr.sendKeyEvent(AndroidKeyCode.HOME);
		  try{
	 //To place Settings Shortcut
	   new TouchAction((MobileDriver) dr).longPress(fn).perform();
	   dr.findElement(By.id("launcher3.android.com.hivelauncher:id/widget_button")).click();
	   ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Settings shortcut\"))");
	   new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Settings shortcut")).moveTo(340,493).release().perform();
	   dr.findElementByName("Apps").click();
	   Boolean set= dr.findElementsByName("Apps").size() >0;
	   if(set)
	   {
		   System.out.println("Placing settings shortcut : Test Case Passed");
		   ++countTestCasePassed;
		   e1.pass(54);
	   }
	   else
	   {
		   System.out.println("Placing settings shortcut: Test Case Failed");
		   e1.fail(54);
	   }
	   new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Apps")).moveTo(582,240).release().perform();
	   Boolean setRemove= dr.findElementsByName("Apps").size() >0;
	   if(setRemove)
	   {
		   System.out.println("Removed settings shortcut: Test Case Failed");
		   e1.fail(55);
	   }
	   else
	   {
		   System.out.println("Removed settings shortcut: Test Case Passed");
		   e1.pass(55);
	   }
		  }
		  catch(Exception e)
		  {
			  System.out.println("Exception while placing settings" +e);
			  e1.notExecuted(55);
		  }
	   

		    if(countTestCasePassed==5)
		    {	
		    	System.out.println("All the TestCases are passed for Plcaing Widgets Functionality Total Test cases Passed -> " +countTestCasePassed +" Out of 5 Test Cases");
		    	countTestCasePassed=0;
		    }
		    else
		    {
		    	System.out.println("All the TestCases are not Passed for Placing Widgets Functionality Total Test cases Passed -> " +countTestCasePassed +" Out of 5 Test Cases");
		    	countTestCasePassed=0;
		    }
	 
	   
		  long endTime= System.currentTimeMillis();
		  long totalTime=endTime-startTime;
		  long tt=totalTime/1000;
		  e1.timeTaken(46, tt);
		  System.out.println("Total time taken to place & remove widgets (TimeUnit: In Seconds ) " +tt);
	  
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

