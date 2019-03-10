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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WeatherWidgetFunctionality {
    Excel e1 = new Excel();
    @SuppressWarnings("rawtypes")
    public AndroidDriver dr;

    @SuppressWarnings("rawtypes")
    @Test()
    public void WeatherWidget() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
        try {
            Boolean gSearch = dr.findElementsById("com.google.android.googlequicksearchbox:id/search_edit_frame").size() > 0;
            if (gSearch) {
                System.out.println("Google Search bar is present, Hence removing that widget to place weather widget");
                new TouchAction((MobileDriver) dr).longPress(dr.findElementById("com.google.android.googlequicksearchbox:id/search_edit_frame")).waitAction().moveTo(470, 319).release().perform();
                Thread.sleep(2000);
            } else {
                System.out.println("Google Search bar is not present, Hence we can place weather widget");
            }
        } catch (Exception e) {
            System.out.println("Exception while checking for Google search bar " + e);
        }

        // Tocheck total widgets & apps on the homescreen
        @SuppressWarnings("unchecked")
        List<WebElement> cw = dr.findElementsByXPath("//android.appwidget.AppWidgetHostView");
        int countWidgets = cw.size();
        System.out.println("Total Widgets present on first HomeScreen = " + countWidgets);
        if (countWidgets == 0) {
            System.out.println("There are no widgets now, we can place the weather widget");
        } else {
            System.out.println("There are other widgets ont the screen, Hence remmove those widgets & run the script");
        }

        // To count number of Apps in the homescreen
        @SuppressWarnings("unchecked")
        List<WebElement> ca1 = dr.findElementsByXPath("//android.widget.TextView");
        int countApps = ca1.size();
        System.out.println("Total Apps present on first HomeScreen = " + (countApps - 5));
        if (countApps <= 13) {
            System.out.println("2 Apps are present in the 1st homescreen, Hence we can place the weather widget");
        } else {
            System.out.println("The apps present on the 1st homescreen is more than 8 ");
        }

        long startTime = System.currentTimeMillis();
        try {
            // 
            WebElement fn = dr.findElementById("launcher3.android.com.hivelauncher:id/workspace");
            new TouchAction((MobileDriver) dr).longPress(fn).perform();
            dr.findElementById("launcher3.android.com.hivelauncher:id/widget_button").click();
            ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Hive Weather\"))");
            new TouchAction((MobileDriver) dr).longPress(dr.findElementByName("Hive Weather")).moveTo(560, 530).release().perform();


            Thread.sleep(3000);
            dr.findElementById("launcher3.android.com.hivelauncher:id/weather_image").click();
            dr.findElementById("launcher3.android.com.hivelauncher:id/weather_image").click();
            dr.findElementById("launcher3.android.com.hivelauncher:id/weather_image").click();

            // Thread.sleep(30000);

            WebDriverWait wait = new WebDriverWait(dr, 180);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("launcher3.android.com.hivelauncher:id/weather_image")));
            boolean b1 = dr.findElementsById("launcher3.android.com.hivelauncher:id/current_temperature").size() > 0;

            if (b1) {
                System.out.println("Weather functionality is working: Test Case Passed");
                e1.pass(62);
            } else {
                System.out.println("Weather functionality is not working");
                e1.fail(62);
            }
            // new TouchAction((MobileDriver) dr).longPress(dr.findElementByXPath("//android.appwidget.AppWidgetHostView[@content-desc='Hive Weather']")).moveTo(500,220).release().perform();
            new TouchAction((MobileDriver) dr).longPress(dr.findElementById("launcher3.android.com.hivelauncher:id/accuweather_logo_image")).moveTo(511, 291).release().perform();
        } catch (Exception e) {
            System.out.println("Exception while Executing WeatherWidget functionality" + e);
            e1.notExecuted(62);
        }


        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        long tt = totalTime / 1000;
        e1.timeTaken(62, tt);
        System.out.println("Total time taken to check the weather widget functionality (TimeUnit: In Seconds ) " + tt);


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

