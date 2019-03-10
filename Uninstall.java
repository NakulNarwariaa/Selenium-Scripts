package sample;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Uninstall {
    Excel e1 = new Excel();
    static int countTestCasePassed = 0;
    @SuppressWarnings("rawtypes")
    private AndroidDriver dr;
    Scanner scn1;
    int a = 0;
    static int count = 0;

    @SuppressWarnings("rawtypes")
    @BeforeTest
    public void setUp() throws Exception {

        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.VERSION, "4.4.2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM, "Windows");
        capabilities.setCapability("deviceName", "0123456789ABCDEF");
        capabilities.setCapability("platformName", "Android");


        capabilities.setCapability("appPackage", "com.android.settings");
        capabilities.setCapability("appActivity", "Settings");


        dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        dr.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }


    @SuppressWarnings("rawtypes")
    @Test
    public void Uninstall() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {

        long startTime = System.currentTimeMillis();

        try {
            ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Apps\"))");
            dr.findElementByName("Apps").click();

            //To check all apps installed present or not
            ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Lift Simulator\"))");
            Boolean lift = dr.findElementsByName("Lift Simulator").size() > 0;
            if (lift) {
                System.out.println("Lift Simulator application is present, Now uninstalling the same app");
                dr.findElementByName("Lift Simulator").click();
                dr.findElementById("com.android.settings:id/left_button").click();
                dr.findElementById("android:id/button1").click();
                System.out.println("Lift Simulator App uninstalled, Now check App Drawer & Homescreen");
            } else {
                System.out.println("Lift Simulator application is not present to uninstall: Test case Failed");
            }
        } catch (Exception e) {
            System.out.println("Exception while uninstalling Lift Simulator app" + e);
        }

        dr.sendKeyEvent(AndroidKeyCode.HOME);
        Thread.sleep(2000);

        dr.startActivity("com.android.settings", "Settings");

        try {
            ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Apps\"))");
            dr.findElementByName("Apps").click();

            //To check all apps installed present or not
            ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Floppy Bird\"))");
            Boolean floppy = dr.findElementsByName("Floppy Bird").size() > 0;
            if (floppy) {
                System.out.println("Floppy Bird application is present, Now uninstalling the same app");
                dr.findElementByName("Floppy Bird").click();
                dr.findElementById("com.android.settings:id/left_button").click();
                dr.findElementById("android:id/button1").click();
                System.out.println("Floppy Bird app uninstalled, Now check App Drawer & Homescreen");
            } else {
                System.out.println("Floppy Bird application is not present to uninstall: Test case Failed");
            }
        } catch (Exception e) {
            System.out.println("Exception while uninstalling Floppy Bird app" + e);
        }

        dr.sendKeyEvent(AndroidKeyCode.HOME);
        Thread.sleep(2000);
        dr.startActivity("com.android.settings", "Settings");
        try {
            ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Apps\"))");
            dr.findElementByName("Apps").click();

            //To check all apps installed present or not
            ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Fitbit\"))");
            Boolean fit = dr.findElementsByName("Fitbit").size() > 0;
            if (fit) {
                System.out.println("Fitbit application is present, Now uninstalling the same app");
                dr.findElementByName("Fitbit").click();
                dr.findElementById("com.android.settings:id/left_button").click();
                dr.findElementById("android:id/button1").click();
                System.out.println("Fitbit app uninstalled, Now check App Drawer & Homescreen");
            } else {
                System.out.println("Fitbit application is not present to uninstall: Test case Failed");
            }
        } catch (Exception e) {
            System.out.println("Exception while uninstalling Fitbit app" + e);
        }

        dr.sendKeyEvent(AndroidKeyCode.HOME);
        Thread.sleep(2000);

        dr.startActivity("com.android.settings", "Settings");
        try {
            ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Apps\"))");
            dr.findElementByName("Apps").click();

            //To check all apps installed present or not
            ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"LinkedIn\"))");
            Boolean wall = dr.findElementsByName("LinkedIn").size() > 0;
            if (wall) {
                System.out.println("LinkedIn application is present, Now uninstalling the same app");
                dr.findElementByName("LinkedIn").click();
                dr.findElementById("com.android.settings:id/left_button").click();
                dr.findElementById("android:id/button1").click();
                System.out.println("LinkedIn app uninstalled, Now check App Drawer & Homescreen");
            } else {
                System.out.println("LinkedIn application is not present to uninstall: Test case Failed");
            }
        } catch (Exception e) {
            System.out.println("Exception while uninstalling LinkedIn app" + e);
        }

        dr.sendKeyEvent(AndroidKeyCode.HOME);
        Thread.sleep(2000);


        try {
            dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
            dr.findElementByName("Search apps...").sendKeys("fl");
            String s3 = "No apps found matching";
            String s4 = dr.findElementById("android:id/empty").getText();
            if (s4.contains(s3)) {
                System.out.println("The Floppy bird application not found after uninstall: Test Case Passed ");
                ++countTestCasePassed;
                e1.pass(57);
            } else {
                System.out.println("The application not found : Test case failed");
                e1.fail(57);
            }
        } catch (Exception e) {
            System.out.println("Exception while searching floppy bird App after uninstall" + e);
            e1.notExecuted(57);
        }


        dr.sendKeyEvent(AndroidKeyCode.HOME);

        try {
            dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
            dr.findElementByName("Search apps...").sendKeys("fitbit");
            String s3 = "No apps found matching";
            String s4 = dr.findElementById("android:id/empty").getText();
            if (s4.contains(s3)) {
                System.out.println("The FitBit application not found after uninstall: Test Case Passed ");
                ++countTestCasePassed;
                e1.pass(58);
            } else {
                System.out.println("The application not found : Test case failed");
                e1.fail(58);
            }
        } catch (Exception e) {
            System.out.println("Exception while searching Fitbit App after uninstall: Test Case Failed" + e);
            e1.notExecuted(58);
        }


        dr.sendKeyEvent(AndroidKeyCode.HOME);

        try {
            dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
            dr.findElementByName("Search apps...").sendKeys("link");
            String s3 = "No apps found matching";
            String s4 = dr.findElementById("android:id/empty").getText();
            if (s4.contains(s3)) {
                System.out.println("The Linked In application not found after uninstall: Test Case Passed ");
                ++countTestCasePassed;
                e1.pass(59);
            } else {
                System.out.println("The application not found : Test case failed");
                e1.fail(59);
            }
        } catch (Exception e) {
            System.out.println("Exception while searching  Linked In App after uninstall: Test Case Failed" + e);
            e1.notExecuted(59);
        }


        dr.sendKeyEvent(AndroidKeyCode.HOME);

        try {
            dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
            dr.findElementByName("Search apps...").sendKeys("Lift");
            String s3 = "No apps found matching";
            String s4 = dr.findElementById("android:id/empty").getText();
            if (s4.contains(s3)) {
                System.out.println("The Lift Simulator application not found after uninstall: Test Case Passed ");
                ++countTestCasePassed;
                e1.pass(60);
            } else {
                System.out.println("The application not found : Test case failed");
                e1.fail(60);
            }
        } catch (Exception e) {
            System.out.println("Exception while searching  Lift Simulator App after uninstall: Test Case Failed" + e);
            e1.notExecuted(60);
        }


        dr.sendKeyEvent(AndroidKeyCode.HOME);


        Thread.sleep(3000);
        try {

            String str = dr.findElementById("launcher3.android.com.hivelauncher:id/page_indicator").getAttribute("name");
            // System.out.println(str);
            String result = str.substring(16, str.length() - 10);
            int number = Integer.parseInt(result.trim());
            for (int j = 1; j <= number; j++) {
                if (j != 1)
                    dr.swipe(977, 1000, 90, 1000, 0);

                @SuppressWarnings("unchecked")
                List<WebElement> appsCount = dr.findElementsByXPath("//android.widget.TextView");
                int ac = appsCount.size();
                //  System.out.println(ac);
                for (int i = 0; i < ac; i++) {
                    String s = appsCount.get(i).getText();
                    // System.out.println(s);
                    if (s.contains("Lift Simulator")) {
                        System.out.println("Lift Simulator App Found: Test Case Failed");
                        count++;
                    } else if (s.contains("Fitbit")) {
                        System.out.println("Fitbit App Found: Test Case Failed");
                        count++;
                    } else if (s.contains("LinkedIn")) {
                        System.out.println("LinkedIn Boy  App Found: Test Case Failed");
                        count++;
                    } else if (s.contains("Floppy Bird")) {
                        System.out.println("Floppy Bird  App Found: Test Case Failed");
                        count++;
                    } else {
                        // System.out.println(" ");
                    }
                }


                //	 WebDriverWait wait = new WebDriverWait(dr,60);
                //    wait.until(ExpectedConditions.visibilityOf(dr.findElementByName("Firefox")));

            }
            if (count == 0) {
                System.out.println("All the applications Uninstalled are not on the Homescreen: Test Case Passed");
                ++countTestCasePassed;
                e1.pass(61);

            } else {
                System.out.println("All the applications not Uninstalled: Test Case Failed");
                e1.fail(61);
            }
        } catch (Exception e) {
            System.out.println("Exception While validating UnInstalled apps are present on homescreen");
            e1.notExecuted(61);
        }


        dr.sendKeyEvent(AndroidKeyCode.HOME);

        if (countTestCasePassed == 5) {
            System.out.println("All the TestCases are passed for Uninstall Functionality Total Test cases Passed -> " + countTestCasePassed + " Out of 5 Test Cases");
            countTestCasePassed = 0;
        } else {
            System.out.println("All the TestCases are not Passed for Uninstall Functionality Total Test cases Passed -> " + countTestCasePassed + " Out of 5 Test Cases");
            countTestCasePassed = 0;
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        long tt = totalTime / 1000;
        e1.timeTaken(57, tt);
        System.out.println("Total time taken to uninstall Apps (TimeUnit: In Seconds ) " + tt);
    }


    @AfterTest
    public void quit() throws Exception {

        if (dr != null) {
            dr.quit();
        }
    }

}


