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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppSearch extends Excel {
    Excel e1=new Excel();
	static int countTestCasePassed=0;
	@SuppressWarnings("rawtypes")
	public AndroidDriver dr;

  @SuppressWarnings("rawtypes")
@Test()
  public void SearchAnApp() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
	  
	  long startTime= System.currentTimeMillis();
	  
	  try{
	  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
	 dr.findElementByName("Search apps...").sendKeys("play"); 
	  Thread.sleep(3000);
	  String s1= "Play Store";
	  String s2=dr.findElementById("launcher3.android.com.hivelauncher:id/application_icon").getText();
	  if(s1.equalsIgnoreCase(s2))
			  {
		         System.out.println("The Play Store Application found: Test Case Passed ");
		         ++countTestCasePassed;
		         e1.pass(1);
			  }
	  else
	  {
		  System.out.println("The Play Store app not found : Test case failed");
		  e1.fail(1);
	  }
	  }
	  catch(Exception e)
		{
			System.out.println("Exception while Executing App Found Test case" +e);
			e1.notExecuted(1);
		}
		dr.sendKeyEvent(AndroidKeyCode.HOME);

	  try{
		  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
	  dr.findElementByName("Search apps...").sendKeys("road rash");
	  String s3= "No apps found matching";
	  String s4=dr.findElementById("android:id/empty").getText();
	  
	  if(s4.contains(s3))
	  {
         System.out.println("The road rash application not found: Test Case Passed ");
         ++countTestCasePassed;
         e1.pass(2);
	  }
		else
		{
		  System.out.println("The application not found : Test case failed");
		  e1.fail(2);
		}
	  }
	  catch(Exception e)
		{
			System.out.println("Exception while Executing App Not Found Test case" +e);
			e1.notExecuted(2);
		}	
		dr.sendKeyEvent(AndroidKeyCode.HOME);
	  
	  //To Check Partial Name Test case
	  try{
		  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
	  dr.findElementByName("Search apps...").sendKeys("radi");
	  String s5= "FM Radio";
	  String s6=dr.findElementById("launcher3.android.com.hivelauncher:id/application_icon").getText();
	  System.out.println(s6);
	  if(s5.equalsIgnoreCase(s6))
			  {
		         System.out.println("The FM Radio Application found after entering Partial name: Test Case Passed ");
		         ++countTestCasePassed;
		         e1.pass(3);
			  }
	  else
	  {
		  System.out.println("The FM Radio app not found : Test case failed");
		  e1.fail(3);
	  }
	  }
	  catch(Exception e)
		{
			System.out.println("Exception while Executing Partial Name Search Test case" +e);
			e1.notExecuted(3);
		}
		dr.sendKeyEvent(AndroidKeyCode.HOME);
		
	  //To Check multiple apps after entering partial name.
	  try{
		  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
	  dr.findElementByName("Search apps...").sendKeys("ra");
	  @SuppressWarnings("unchecked")
	List<WebElement> we=dr.findElementsById("launcher3.android.com.hivelauncher:id/application_icon");
	  int elementsFound=we.size();
	  System.out.println("Total Elelments matching string 'ra' is " +elementsFound);
	  if(elementsFound>=2)
	  {
		  System.out.println("Multiple applications Found for string 'ra':Test Case Passed");
		  ++countTestCasePassed;
		  e1.pass(4);
	  }
	  else
	  {
		  System.out.println("Multiple elements not Found:Test Case Failed");
		  e1.fail(4);
	  }
	  for(int i=0;i<elementsFound;i++)
	  {
		  String s=we.get(i).getText();
		  System.out.println(s);
		  
	  }
	  }
	  catch(Exception e)
		{
			System.out.println("Exception while Executing Multiple Apps search Test case" +e);
			e1.notExecuted(4);
		}
		dr.sendKeyEvent(AndroidKeyCode.HOME);

	  try{
		  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
	  dr.findElementByName("Search apps...").sendKeys("tata d");
	  String s7= "No apps found matching";
	  String s8=dr.findElementById("android:id/empty").getText();
	  if(s8.contains(s7))
	  {
         System.out.println("The Application not found, Now checking for Get more on Google Play option");
         Thread.sleep(2000);
         dr.findElementById("launcher3.android.com.hivelauncher:id/search_elsewhere").click();
         Thread.sleep(3000);
         String checkPlaystore="com.google.android";
         String s=dr.currentActivity();
       //  System.out.println(s);
         
         if(s.contains(checkPlaystore))
         {
        	 System.out.println("Play Store launched from Get It link: Test Case Passed \n Now Check for downloading ");
        	 ++countTestCasePassed;
       	     e1.pass(5);
       	     Thread.sleep(2000);
        	 dr.findElementById("com.android.vending:id/play_card").click();
        	 
        	//Click on install button
        	 dr.findElementById("com.android.vending:id/buy_button").click();
        	 //Click on Accept Button
        	 dr.findElementById("com.android.vending:id/continue_button").click();
        	 Thread.sleep(3000);
        	 
         }
         else
         {
        	 System.out.println("The application not found : Test case failed");
        	 e1.fail(5);
         }
	  }
	  else
	  {
		  System.out.println("Please Uninstall the Docomo app to run this test case");
	  }
		
	  }
	  catch(Exception e)
		{
			System.out.println("Exception while Executing Get It Link for App Search Test case " +e);
			e1.notExecuted(5);
		}
		dr.sendKeyEvent(AndroidKeyCode.HOME);
	  
	  try{
		  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
	  dr.findElementByName("Search apps...").sendKeys("123");
	  Thread.sleep(3000);
	  String s9= "123Rigolo";
	  String s10=dr.findElementById("launcher3.android.com.hivelauncher:id/application_icon").getText();
	  if(s10.equalsIgnoreCase(s9))
			  {
		         System.out.println("The Application search using number: Test Case Passed ");
		         ++countTestCasePassed;
		         e1.pass(6);
			  }
	  else
	  {
		  System.out.println("The Application search using number: Test case failed");
		  e1.fail(6);
	  }
	  }
	  catch(Exception e)
		{
			System.out.println("Exception while Searching App which contains number " +e);
			e1.notExecuted(6);
		}
		dr.sendKeyEvent(AndroidKeyCode.HOME);
	  
	  try{
		  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
	  String c="PLAY";
	  dr.findElementByName("Search apps...").sendKeys(c);
	  Thread.sleep(3000);
	  String s13= "Play Store";
	  String s14=dr.findElementById("launcher3.android.com.hivelauncher:id/application_icon").getText();
	  if(s14.equalsIgnoreCase(s13))
			  {
		         System.out.println("The Application found using Capital Letters: Test Case Passed ");
		         ++countTestCasePassed;
		         e1.pass(7);
			  }
	  else
	  {
		  System.out.println("The app not found while using capital letters: Test case failed");
		  e1.fail(7);
	  }
	  }
	  catch(Exception e)
		{
			System.out.println("Exception while searching App using capital letters Test case" +e);
			e1.notExecuted(7);
		}
		dr.sendKeyEvent(AndroidKeyCode.HOME);
	  
	  try{
		  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
	  dr.findElementByName("Search apps...").sendKeys("@*.-");
	  String s11= "No apps found matching";
	  String s12=dr.findElementById("android:id/empty").getText();
	  if(s12.contains(s11))
	  {
         System.out.println("The Application not found for the special Character: Test Case Passed ");
         ++countTestCasePassed;
         e1.pass(8);
	  }
		else
		{
		  System.out.println("The application search for special character : Test case failed");
		  e1.fail(8);
		}
	  }
	  catch(Exception e)
		{
			System.out.println("Exception while searching app for special charaters Test case" +e);
			e1.notExecuted(8);
		}
		dr.sendKeyEvent(AndroidKeyCode.HOME);
	  
		 try{
			  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		  dr.findElementByName("Search apps...").sendKeys("sddfdfd");
		  dr.findElementById("launcher3.android.com.hivelauncher:id/ib_orientation").click();
		  
		   Boolean search= dr.findElementsByName("Search apps...").size() >0;
		  if(search)
		  {
	         System.out.println("The cancel button functionality : Test Case Passed ");
	         ++countTestCasePassed;
	         e1.pass(9);
		  }
			else
			{
			  System.out.println("The cancel button is not working : Test case failed");
			  e1.fail(9);
			}
		  }
		  catch(Exception e)
			{
				System.out.println("Exception while searching app for special charaters Test case" +e);
				e1.notExecuted(9);
			}
		 
		 
		 
		 dr.sendKeyEvent(AndroidKeyCode.HOME);
		 
		 
		 Thread.sleep(2000);
		 try{
			 
		 dr.hideKeyboard();
		 e1.fail(10);
		 }
		 catch(Exception e)
		 {
			 System.out.println("The key board should be hidden after launching homescreen : Test Case Passed");
			  ++countTestCasePassed;
			  e1.pass(10);
		 }
		 
		 try{
		 dr.openNotifications();
		 //Thread.sleep(10000);
		 WebDriverWait wait = new WebDriverWait(dr,120);
		     wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Successfully installed.")));
		     
		 Boolean install= dr.findElementsByName("Successfully installed.").size() >0;
		    if(install)
		    {
		 	   System.out.println("My Tata Docomo App Installed now check in the App Drawer");
		 	  dr.sendKeyEvent(AndroidKeyCode.HOME);
		 	 dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
		 	 dr.findElementByName("Search apps...").sendKeys("tata d");
			  Thread.sleep(3000);
			  String s13= "My Tata Docomo";
			  String s14=dr.findElementById("launcher3.android.com.hivelauncher:id/application_icon").getText();
			  if(s13.equalsIgnoreCase(s14))
					  {
				         System.out.println("My Tata Docomo Application found after install in the App Tray: Test Case Passed ");
				         ++countTestCasePassed;
				         e1.pass(11);
					  }
		 	 
		    }
		    else
		    {
		 	   System.out.println("My Tata Docomo Application not found after install in the App Tray: Test case Failed");
		 	   e1.fail(11);
		    }
		 }
		 catch(Exception e)
		 {
			 System.out.println("Exception: My Tata Docomo Application not found after installed " +e);
			 e1.notExecuted(11);
		 }
		    
		    dr.sendKeyEvent(AndroidKeyCode.HOME);
			 Thread.sleep(2000);
		
		    try{
	  dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
	  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"YouTube\"))");
	  Thread.sleep(3000);
	  Boolean youtube= dr.findElementsByName("YouTube").size() >0;
	   if(youtube)
	   {
		   System.out.println("Youtube app found on the App tray: Test case Passed");
		   ++countTestCasePassed;
		   e1.pass(12);
		   @SuppressWarnings("unchecked")
		List<WebElement> apps=dr.findElementsByXPath("//android.widget.TextView");
			  int countApps=apps.size();
			  System.out.println("The apps that are found at the last");
			  for(int i=0;i<countApps;i++)
			  {
				  String s=apps.get(i).getText();
				  
				  System.out.println(s);
			  }
	   }
	   else
	   {
		   System.out.println("Youtube app not found : Test case Failed");
		e1.fail(12);
	   }
	  
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Exception while searching youtube in the app tray " +e);
		    	e1.notExecuted(12);
		    }
	  
		    if(countTestCasePassed==12)
		    {	
		    	System.out.println("All the TestCases are passed for App Search Functionality Total Test cases Passed -> " +countTestCasePassed +" Out of 12 Test Cases");
		    	countTestCasePassed=0;
		    }
		    else
		    {
		    	System.out.println("All the TestCases are not Passed for App Search Functionality Total Test cases Passed -> " +countTestCasePassed +" Out of 12 Test Cases");
		    	countTestCasePassed=0;
		    }
		    
	  long endTime= System.currentTimeMillis();
	  long totalTime=endTime-startTime;
	  long tt=totalTime/1000;
	  e1.timeTaken(1, tt);
	  
	  System.out.println("Total time taken to run AppSearch Module (TimeUnit: In Seconds )" +tt);
	  
	  dr.sendKeyEvent(AndroidKeyCode.HOME);
		 Thread.sleep(2000);
		 
		 dr.startActivity("com.android.settings", "Settings");
		 try{
			 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Apps\"))");
			 dr.findElementByName("Apps").click();
			 
			 //To check all apps installed present or not
			 ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"My Tata Docomo\"))");
			 Boolean tata=dr.findElementsByName("My Tata Docomo").size() >0;
			   if(tata)
			   {
				   System.out.println("My Tata Docomo application is present, Now uninstalling the same app");
				   dr.findElementByName("My Tata Docomo").click();
				   dr.findElementById("com.android.settings:id/left_button").click();
				   dr.findElementById("android:id/button1").click();
				   System.out.println("My Tata Docomo app uninstalled");
			   }
			   else
			   {
				   System.out.println("My Tata Docomo App Not found to uninstall");
			   }
			}
			catch(Exception e)
			{
				System.out.println("Exception while uninstalling My Tata Docomo app" +e);
			}
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

