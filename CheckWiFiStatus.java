package sample;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;	
import org.testng.annotations.Test;

public class CheckWiFiStatus {
	
	@SuppressWarnings("rawtypes")
	public AndroidDriver dr;

  @Test()
  public void f() throws InterruptedException {
	  
  // dr.findElementByXPath("//android.widget.FrameLayout[@index=1]").click();
   try{
	String s=dr.findElementById("com.android.settings:id/switch_widget").getText();
	if(s.equalsIgnoreCase("on"))
	{
		
		System.out.println("It Is on");
	}
	else
	{
		System.out.println("It Is off");	
		
	}
	
   }
   catch(Exception e)
	{
		System.out.println("Some Error while Executing TocheckWifiFuctionality Class" + e);
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

			capabilities.setCapability("appPackage","com.android.settings");
			capabilities.setCapability("appActivity","com.android.settings.wifi.WifiPickerActivity");
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

