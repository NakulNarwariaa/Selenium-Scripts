package sample;


import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollWidgets {
    Excel e1 = new Excel();
    @SuppressWarnings("rawtypes")
    public AndroidDriver dr;

    @SuppressWarnings("rawtypes")
    @Test()
    public void WidgetsScrollTime() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {

        long startTime = System.currentTimeMillis();
        try {

            // 
            WebElement fn = dr.findElementById("launcher3.android.com.hivelauncher:id/workspace");
            new TouchAction((MobileDriver) dr).longPress(fn).perform();
            dr.findElementById("launcher3.android.com.hivelauncher:id/widget_button").click();

            for (int i = 0; i < 10; i++) {

                ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Translate\"))");
                ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Analog clock\"))");
                System.out.println("Scrolling " + (i + 1));
            }
            System.out.println("Scrolling Widgets for 10 times:   Test Case Passed ");
            e1.pass(56);
        } catch (Exception e) {
            System.out.println("Some Error while Executing ScrollWidgets Class" + e);
            e1.fail(56);
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        long tt = totalTime / 1000;
        e1.timeTaken(56, tt);
        System.out.println("Total time taken to scroll widgets for 10 iterations (TimeUnit: In Seconds ) " + tt);
    }

    @SuppressWarnings("rawtypes")
    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.VERSION, "4.4.2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM, "Windows");
        capabilities.setCapability("deviceName", "0123456789ABCDEF");
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("appPackage", "launcher3.android.com.hivelauncher");
        capabilities.setCapability("appActivity", "com.android.launcher3.Launcher");
        dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {

        if (dr != null) {
            dr.quit();
        }

    }

}

