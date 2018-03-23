package sample;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DefaultShortcutsOnHomescreen {
	  Excel e1=new Excel();
	static int countTestCasePassed=0;
	@SuppressWarnings("rawtypes")
	public AndroidDriver dr;

  @Test()
  public void DefaultAppsAndWidgets() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
	  long startTime= System.currentTimeMillis();
	 try{ 
	//  dr.findElementById("launcher3.android.com.hivelauncher:id/workspace").click();
	  
	  String str=dr.findElementById("launcher3.android.com.hivelauncher:id/page_indicator").getAttribute("name");
	 // System.out.println(str);
	  String result = str.substring(16,str.length()-10);
	  int number = Integer.parseInt(result.trim());
	  if(number==3)
	  {
		  System.out.println("Total homescreen present are equal to 3 : Test case passed");
	         ++countTestCasePassed;
	         e1.pass(24);
	         
	  }
	  else
	  {
		  System.out.println("Total homescreen present is not equal to 3 : Test case Failed");
		  e1.fail(24);
	  }
	  

	  Boolean googleSearchBar=dr.findElementsById("com.google.android.googlequicksearchbox:id/search_widget_google_logo").size() >0;
	   if(googleSearchBar)
	   {
		   System.out.println("By default the google search bar is present: Test case Passed");
	         ++countTestCasePassed;
	         e1.pass(25);
	   }
	   else
	   {
		   System.out.println("By default the google search bar is not present: Test case Failed");
		   e1.fail(25);
	   }
	   
	   
	   Boolean Gfolder= dr.findElementsByXPath("//android.widget.FrameLayout[@content-desc='Folder: Google']").size() >0;
	   if(Gfolder)
	   {
		   System.out.println("By default the google folder is present: Test case Passed");
	         ++countTestCasePassed;
	         e1.pass(26);
	   }
	   else
	   {
		   System.out.println("By default the google folder is not present: Test case Failed");
		   e1.fail(26);
	   }
	   
	   Boolean playStore= dr.findElementsByName("Play Store").size() >0;
	   if(playStore)
	   {
		   System.out.println("By default the playstore is present: Test case Passed");
	         ++countTestCasePassed;
	         e1.pass(27);
	   }
	   else
	   {
		   System.out.println("By default the playStore is not present: Test case Failed");
		   e1.fail(27);
	   }
	   
	   // To count number of widgets in the homescreen
		  @SuppressWarnings("unchecked")
		List<WebElement> cw1=dr.findElementsByXPath("//android.appwidget.AppWidgetHostView");
		  int countWidgets=cw1.size();
		  System.out.println("Total Widgets present on first HomeScreen = " +countWidgets);
		  if(countWidgets==1)
		  {
			  System.out.println("Only one widget is present on First Homescreen: Test case Passed");
		         ++countTestCasePassed;
		         e1.pass(28);
		  }
		  else
		  {
			  System.out.println("Only onw widget should be present on the 1st Homescreen: Test case Failed");
			  e1.fail(28);
		  }
		  
		  // To count number of Apps in the homescreen
		  @SuppressWarnings("unchecked")
		List<WebElement> ca1=dr.findElementsByXPath("//android.widget.TextView");
		  int countApps=ca1.size();
		  System.out.println("Total Apps present on first HomeScreen = " +(countApps-5));
		  if(countApps==7)
		  {
			  System.out.println("2 Apps are present in the 1st homescreen: Test case Passed");
		         ++countTestCasePassed;
		         e1.pass(29);
		  }
		  else
		  {
			  System.out.println("The apps present on the 1st homescreen is not equal to 2: Test case Failed");
			  e1.fail(29);
		  }
	   
	   dr.swipe(630, 650, 80, 650, 0);
	   
	   Boolean xoloStore= dr.findElementsById("com.cube26.lavanextapp:id/tvStoreName").size() >0;
	   if(xoloStore)
	   {
		   System.out.println("By default the Cube26 Widget is present: Test case Passed");
	         ++countTestCasePassed;
	         e1.pass(30);
	   }
	   else
	   {
		   System.out.println("By default the Cube26 Widget is not present: Test case Failed");
		   e1.fail(30);
	   }
	   
	   
	   Boolean powerControl= dr.findElementsByXPath("//android.appwidget.AppWidgetHostView[@content-desc='Power control']").size() >0;
	   if(powerControl)
	   {
		   System.out.println("By default the PowerControl Widget is present: Test case Passed");
	         ++countTestCasePassed;
	         e1.pass(31);
	   }
	   else
	   {
		   System.out.println("By default the PowerControl Widget is not present: Test case Failed");
		   e1.fail(31);
	   }
	   // To count number of widgets in the homescreen
		  @SuppressWarnings("unchecked")
		List<WebElement> cw2=dr.findElementsByXPath("//android.appwidget.AppWidgetHostView");
		  int countWidgets2=cw2.size();
		  System.out.println("Total Widgets present on second HomeScreen =" +countWidgets2);
		  if(countWidgets2==2)
		  {
			  System.out.println("Only 2 widgets are present on the second Homescreen: Test case Passed");
		         ++countTestCasePassed;
			  e1.pass(32);
		  }
		  else
		  {
			  System.out.println("Widgets present on 2nd homescreen is not equal to 2 : Test case Failed");
			  e1.fail(32);
		  }
		  
		  // To count number of Apps in the homescreen
		  @SuppressWarnings("unchecked")
		List<WebElement> ca2=dr.findElementsByXPath("//android.widget.TextView");
		  int countApps2=ca2.size();
		  System.out.println("Total Apps present on second HomeScreen =" +(countApps2-10));
		  if(countApps2==10)
		  {
			  System.out.println("No Apps are present on second screen: Test case Passed");
		         ++countTestCasePassed;
		         e1.pass(33);
		  }
		  else
		  {
			  System.out.println("Apps should not be present in the 2nd homescreen: Test case Failed");
			  e1.fail(33);
		  }
	   
		  
	   
		  dr.swipe(630, 650, 80, 650, 0);
	   
	   Boolean clock= dr.findElementsById("com.android.deskclock:id/analog_appwidget").size() >0;
	   if(clock)
	   {
		   System.out.println("By default the clock widget is present: Test case Passed");
	         ++countTestCasePassed;
	         e1.pass(34);
	   }
	   else
	   {
		   System.out.println("By default the clock widget is not present: Test case Failed");
		   e1.fail(34);
	   }
	   
	   Boolean Gallery= dr.findElementsByName("Gallery").size() >0;
	   if(Gallery)
	   {
		   System.out.println("By default the Gallery app is present: Test case Passed");
	         ++countTestCasePassed;
	         e1.pass(35);
	   }
	   else
	   {
		   System.out.println("By default the Gallery app is not present: Test case Failed");
		   e1.fail(35);
	   }
	   
	   Boolean Settings= dr.findElementsByName("Settings").size() >0;
	   if(Settings)
	   {
		   System.out.println("By default the Settings app is present: Test case Passed");
	         ++countTestCasePassed;
	         e1.pass(36);
	   }
	   else
	   {
		   System.out.println("By default the Settings app is not present: Test case Failed");
		   e1.fail(36);
	   }
	   
	   // To count number of widgets in the homescreen
		  @SuppressWarnings("unchecked")
		List<WebElement> cw3=dr.findElementsByXPath("//android.appwidget.AppWidgetHostView");
		  int countWidgets3=cw3.size();
		  System.out.println("Total Widgets present on third HomeScreen =" +countWidgets3);
		  if(countWidgets3==1)
		  {
			  System.out.println("Only 1 widget is present on the third Homescreen: Test case Passed");
		         ++countTestCasePassed;
		         e1.pass(37);
		         
		  }
		  else
		  {
			  System.out.println("only 1 widget should be present: Test case Failed");
			  e1.fail(37);
		  }
		  
		  // To count number of Apps in the homescreen
		  @SuppressWarnings("unchecked")
		List<WebElement> ca3=dr.findElementsByXPath("//android.widget.TextView");
		  int countApps3=ca3.size();
		  System.out.println("Total Apps present on third HomeScreen =" +(countApps3-5));
		  if(countApps3==7)
		  {
			  System.out.println("2 Apps are present on third screen: Test case Passed");
		         ++countTestCasePassed;
		         e1.pass(38);
		  }
		  else
		  {
			  System.out.println("2 Apps should be present on third screen: Test case Failed");
			  e1.fail(38);
		  }
	
	 
	 }
	 
	 catch(Exception e)
		{
			System.out.println("Some Error while SwipeHomescreen Class" + e);
		}
	    
	 
	 if(countTestCasePassed==15)
	    {
	    	System.out.println("All the TestCases are passed for Default Shortcuts Functionality Total Test cases Passed -> " +countTestCasePassed +" Out of 15 Test Cases");
	    	countTestCasePassed=0;
	    }
	    else
	    {
	    	System.out.println("All the TestCases are not Passed for Default Shortcuts Functionality Total Test cases Passed -> " +countTestCasePassed +" Out of 15 Test Cases");
	    	countTestCasePassed=0;
	    }
	 long endTime= System.currentTimeMillis();
	  long totalTime=endTime-startTime;
	  long tt=totalTime/1000;
	  e1.timeTaken(24, tt);
	  System.out.println("Total time taken to check the default Apps & widgets placed on the homescreen (TimeUnit: In Seconds ) " +tt);
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

