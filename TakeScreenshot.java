package sample;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.Assertion;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TakeScreenshot extends Excel{
	static boolean toast=false;
	  Excel e1=new Excel();
	@SuppressWarnings("rawtypes")
	public AndroidDriver dr;
  @SuppressWarnings("static-access")
  @Test
  public void ToCheckToast() throws InterruptedException, IOException, TesseractException, EncryptedDocumentException, InvalidFormatException {
	  
	  long startTime= System.currentTimeMillis();
	  try{
		  Boolean gSearch= dr.findElementsById("com.google.android.googlequicksearchbox:id/search_edit_frame").size() >0;
		   if(gSearch)
		   {
			   System.out.println("Google Search bar is present, Hence we can place Photo Gallery widget");
			   
		   }
		   else
		   {
			   System.out.println("Google Search bar is not present, Hence we need to place search bar");
			   WebElement fn=dr.findElementById("launcher3.android.com.hivelauncher:id/workspace");
			   new TouchAction((MobileDriver) dr).longPress(fn).perform();
			   dr.findElement(By.id("launcher3.android.com.hivelauncher:id/widget_button")).click();
			   ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Google App\"))");
			   new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Google App")).moveTo(551,642).release().perform();
		   }
		  }
		  catch(Exception e)
		  {
			  System.out.println("Exception while checking for Google search bar" +e);
		  }
		  
		try{ 
			Thread.sleep(3000);
			  WebElement fn=dr.findElementById("launcher3.android.com.hivelauncher:id/workspace");
			  new TouchAction((MobileDriver) dr).longPress(fn).perform();
			  dr.findElementById("launcher3.android.com.hivelauncher:id/widget_button").click();
	  ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Photo Gallery\"))");
	   new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Photo Gallery")).moveTo(500,850).release().perform();
	   Thread.sleep(2000);
		   this.takeSnapShot(dr,"E:/AppAutomation/cal/homeScreen.png");

		   if(toast)
		   {
			   e1.pass(63);
		   }
		   else
		   {
			   e1.fail(63);
		   }
		}
		catch(Exception e)
		{
			System.out.println("Exception while testing Toast Message " +e);
			e1.notExecuted(63);
		}
		
		  long endTime= System.currentTimeMillis();
		  long totalTime=endTime-startTime;
		  long tt=totalTime/1000;
		  e1.timeTaken(63, tt);
		  
		  System.out.println("Total time taken to run AppSearch Module (TimeUnit: In Seconds )" +tt);
  }


	
  
  		 	
  /////To take screen shot while execution
  public static void takeSnapShot(MobileDriver mobiledriver, String fileWithPath) throws IOException, TesseractException {
  	//To convert mobile driver object to TakeScreenshot
  	TakesScreenshot scrShot = ((TakesScreenshot)mobiledriver);
  	//call getScreenshotAs method to create image file
  	File ScrFile = scrShot.getScreenshotAs(OutputType.FILE);
  	//Move image file to new destination
  	File DestFile = new File(fileWithPath);
  	//copy file at destination
  	FileUtils.copyFile(ScrFile, DestFile);
  //E:/AppAutomation/cal/homeScreen.png
  
  	 File imageFile = new File("E:/AppAutomation/cal/homeScreen.png");
	  // C://Users/Dinesh B M/workspace/GameStore/Screenshot_20160718-144448.png
	  ITesseract instance = new Tesseract();
	  String result = instance.doOCR(imageFile);
	  System.out.println(result);
	  String expected="No more room on this Home screen";
	  if(result.contains(expected))
	  {
         System.out.println("The toast Message disaplyed : Test Case Passed ");
        toast=true;
	  }
		else	
		{	
		  System.out.println("The Toast message not displayed : Test case failed");
		}
	  

  }
@SuppressWarnings("rawtypes")
@BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities capabilities= new DesiredCapabilities();
	  capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Android");
	  capabilities.setCapability(MobileCapabilityType.VERSION,"5.0.2");
	  capabilities.setCapability(MobileCapabilityType.PLATFORM,"Windows");
	  capabilities.setCapability("deviceName","0123456789ABCDEF");
	  capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage","launcher3.android.com.hivelauncher");
		capabilities.setCapability("appActivity","com.android.launcher3.Launcher");
	  
	  //Create RemoteWebDriver instance and connect to the Appium server.
	  dr= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	 // dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  if ( dr!=null);
	  {
	  dr.quit();
	  }
  }

}
