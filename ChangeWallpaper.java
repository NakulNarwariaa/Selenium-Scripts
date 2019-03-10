package sample;


import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
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

public class ChangeWallpaper extends Excel {
    Excel e1 = new Excel();
    static int countTestCasePassed = 0;
    @SuppressWarnings("rawtypes")
    public AndroidDriver dr;

    @Test()
    public void ChangeWallpapers() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {

        long startTime = System.currentTimeMillis();

        WebElement fn = dr.findElementById("launcher3.android.com.hivelauncher:id/workspace");
        try {
            // TO apply system wallpaper 1

            new TouchAction((MobileDriver) dr).longPress(fn).perform();
            dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
            dr.findElementByXPath("//android.widget.FrameLayout[@content-desc='Wallpaper 1 of 8']").click();
            dr.findElementById("launcher3.android.com.hivelauncher:id/set_wallpaper_button").click();
            System.out.println("First wallpaper applied Succesfully");
            Thread.sleep(3000);
            ++countTestCasePassed;
        } catch (Exception e) {
            System.out.println("Some Error while applying First wallpaper " + e);
            dr.sendKeyEvent(AndroidKeyCode.HOME);
            Thread.sleep(3000);
        }

        try {
            new TouchAction((MobileDriver) dr).longPress(fn).perform();
            dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
            dr.findElementByXPath("//android.widget.FrameLayout[@content-desc='Wallpaper 2 of 8']").click();
            dr.findElementById("launcher3.android.com.hivelauncher:id/set_wallpaper_button").click();
            System.out.println("Second wallpaper applied Succesfully");
            Thread.sleep(3000);
            ++countTestCasePassed;
        } catch (Exception e) {
            System.out.println("Some Error while applying second wallpaper " + e);
            dr.sendKeyEvent(AndroidKeyCode.HOME);
            Thread.sleep(3000);
        }

        try {
            new TouchAction((MobileDriver) dr).longPress(fn).perform();
            dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
            dr.findElementByXPath("//android.widget.FrameLayout[@content-desc='Wallpaper 3 of 8']").click();
            dr.findElementById("launcher3.android.com.hivelauncher:id/set_wallpaper_button").click();
            System.out.println("Third wallpaper applied Succesfully");
            Thread.sleep(3000);
            ++countTestCasePassed;
        } catch (Exception e) {
            System.out.println("Some Error while applying third wallpaper " + e);
            dr.sendKeyEvent(AndroidKeyCode.HOME);
            Thread.sleep(3000);
        }

        try {
            new TouchAction((MobileDriver) dr).longPress(fn).perform();
            dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
            dr.swipe(970, 1700, 100, 1700, 0);
            Thread.sleep(2000);
            dr.findElementByXPath("//android.widget.FrameLayout[@content-desc='Wallpaper 4 of 8']").click();
            dr.findElementById("launcher3.android.com.hivelauncher:id/set_wallpaper_button").click();
            System.out.println("Fourth wallpaper applied Succesfully");
            Thread.sleep(3000);
            ++countTestCasePassed;
        } catch (Exception e) {
            System.out.println("Some Error while applying Fourth wallpaper " + e);
            dr.sendKeyEvent(AndroidKeyCode.HOME);
            Thread.sleep(3000);
        }

        try {
            new TouchAction((MobileDriver) dr).longPress(fn).perform();
            dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
            dr.swipe(970, 1700, 100, 1700, 0);
            Thread.sleep(2000);
            dr.findElementByXPath("//android.widget.FrameLayout[@content-desc='Wallpaper 5 of 8']").click();
            dr.findElementById("launcher3.android.com.hivelauncher:id/set_wallpaper_button").click();
            System.out.println("Fifth wallpaper applied Succesfully");
            Thread.sleep(3000);
            ++countTestCasePassed;
        } catch (Exception e) {
            System.out.println("Some Error while Applying fifth wallpaper " + e);
            dr.sendKeyEvent(AndroidKeyCode.HOME);
            Thread.sleep(3000);
        }

        try {
            new TouchAction((MobileDriver) dr).longPress(fn).perform();
            dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
            dr.swipe(970, 1700, 100, 1700, 0);
            Thread.sleep(2000);
            dr.findElementByXPath("//android.widget.FrameLayout[@content-desc='Wallpaper 6 of 8']").click();
            dr.findElementById("launcher3.android.com.hivelauncher:id/set_wallpaper_button").click();
            System.out.println("Sixth wallpaper applied Succesfully");
            Thread.sleep(3000);
            ++countTestCasePassed;
        } catch (Exception e) {
            System.out.println("Some Error while Applying sixth wallpaper " + e);
            dr.sendKeyEvent(AndroidKeyCode.HOME);
            Thread.sleep(3000);
        }


        try {
            new TouchAction((MobileDriver) dr).longPress(fn).perform();
            dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
            dr.swipe(970, 1700, 100, 1700, 0);
            dr.swipe(970, 1700, 100, 1700, 0);
            Thread.sleep(2000);
            dr.findElementByXPath("//android.widget.FrameLayout[@content-desc='Wallpaper 7 of 8']").click();
            dr.findElementById("launcher3.android.com.hivelauncher:id/set_wallpaper_button").click();
            System.out.println("Seventh wallpaper applied Succesfully");
            Thread.sleep(3000);
            ++countTestCasePassed;
        } catch (Exception e) {
            System.out.println("Some Error while applying Seventh wallpaper " + e);
            dr.sendKeyEvent(AndroidKeyCode.HOME);
            Thread.sleep(3000);
        }

        try {
            new TouchAction((MobileDriver) dr).longPress(fn).perform();
            dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
            dr.swipe(970, 1700, 100, 1700, 0);
            dr.swipe(970, 1700, 100, 1700, 0);
            Thread.sleep(2000);
            dr.findElementByXPath("//android.widget.FrameLayout[@content-desc='Wallpaper 8 of 8']").click();
            dr.findElementById("launcher3.android.com.hivelauncher:id/set_wallpaper_button").click();
            System.out.println("8th wallpaper applied Succesfully");
            Thread.sleep(3000);
            ++countTestCasePassed;
        } catch (Exception e) {
            System.out.println("Some Error while applying 8th wallpaper " + e);
            dr.sendKeyEvent(AndroidKeyCode.HOME);
            Thread.sleep(3000);
        }


        try {
            new TouchAction((MobileDriver) dr).longPress(fn).perform();
            dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
            dr.swipe(970, 1700, 100, 1700, 0);
            dr.swipe(970, 1700, 100, 1700, 0);
            Thread.sleep(2000);
            dr.findElementByName("Black Hole").click();
            dr.findElementByName("Set wallpaper").click();
            System.out.println("9th wallpaper applied Succesfully");
            Thread.sleep(3000);
            ++countTestCasePassed;
        } catch (Exception e) {
            System.out.println("Some Error while applying 9th wallpaper " + e);
            dr.sendKeyEvent(AndroidKeyCode.HOME);
            Thread.sleep(3000);
        }

        try {
            new TouchAction((MobileDriver) dr).longPress(fn).perform();
            dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
            dr.swipe(970, 1700, 100, 1700, 0);
            dr.swipe(970, 1700, 100, 1700, 0);
            dr.swipe(970, 1700, 100, 1700, 0);
            Thread.sleep(2000);
            dr.findElementByName("Bubbles").click();
            dr.findElementByName("Set wallpaper").click();
            System.out.println("10th wallpaper applied Succesfully");
            Thread.sleep(3000);
            ++countTestCasePassed;
        } catch (Exception e) {
            System.out.println("Some Error while applying 9th wallpaper " + e);
            dr.sendKeyEvent(AndroidKeyCode.HOME);
            Thread.sleep(3000);
        }


        try {
            new TouchAction((MobileDriver) dr).longPress(fn).perform();
            dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
            dr.swipe(970, 1700, 100, 1700, 0);
            dr.swipe(970, 1700, 100, 1700, 0);
            dr.swipe(970, 1700, 100, 1700, 0);
            Thread.sleep(2000);
            dr.findElementByName("Holo Spiral").click();
            dr.findElementByName("Set wallpaper").click();
            System.out.println("11th wallpaper applied Succesfully");
            Thread.sleep(3000);
            ++countTestCasePassed;
        } catch (Exception e) {
            System.out.println("Some Error while applying 11th wallpaper " + e);
            dr.sendKeyEvent(AndroidKeyCode.HOME);
            Thread.sleep(3000);
        }

        try {
            new TouchAction((MobileDriver) dr).longPress(fn).perform();
            dr.findElementById("launcher3.android.com.hivelauncher:id/wallpaper_button").click();
            dr.swipe(970, 1700, 100, 1700, 0);
            dr.swipe(970, 1700, 100, 1700, 0);
            dr.swipe(970, 1700, 100, 1700, 0);
            Thread.sleep(2000);
            dr.findElementByName("Phase Beam").click();
            dr.findElementByName("Set wallpaper").click();
            System.out.println("12th wallpaper applied Succesfully");
            Thread.sleep(3000);
            ++countTestCasePassed;
        } catch (Exception e) {
            System.out.println("Some Error while applying 12th wallpaper " + e);
            dr.sendKeyEvent(AndroidKeyCode.HOME);
            Thread.sleep(3000);
        }


        if (countTestCasePassed == 12) {
            System.out.println("All the TestCases are passed for Change Wallpaper Functionality Total Test cases Passed -> " + countTestCasePassed + " Out of 12 Test Cases");
            e1.pass(13);
            countTestCasePassed = 0;

        } else {
            System.out.println("All the TestCases are not Passed for Change Wallpaper Functionality Total Test cases Passed -> " + countTestCasePassed + " Out of 12 Test Cases");
            e1.fail(13);
            countTestCasePassed = 0;
        }


        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        long tt = totalTime / 1000;
        e1.timeTaken(13, tt);
        System.out.println("Total time taken to change wallpapers (TimeUnit: In Seconds ) " + tt);


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

