package sample;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ClearLauncher {
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
        capabilities.setCapability("appPackage", "launcher3.android.com.hivelauncher");
        capabilities.setCapability("appActivity", "com.android.launcher3.Launcher");


        dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        dr.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }


    @SuppressWarnings("rawtypes")
    @Test
    public void clearLauncher() throws Exception {
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
            dr.findElementById("launcher3.android.com.hivelauncher:id/workspace").click();
            // To check how many screens are there before clearing the hive launcher
            String str = dr.findElementById("launcher3.android.com.hivelauncher:id/page_indicator").getAttribute("name");
            //  System.out.println(str);
            String result = str.substring(16, str.length() - 10);
            int number = Integer.parseInt(result.trim());
            System.out.println("Total screens before Clearing the launcher  " + number);


            dr.startActivity("com.android.settings", "Settings");


            ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Apps\"))");
            dr.findElementByName("Apps").click();

            Thread.sleep(3000);
            ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"HiveLauncher\"))");
            dr.findElementByName("HiveLauncher").click();

            dr.findElementByName("Data usage").click();
            Thread.sleep(2000);
            dr.findElementByXPath("//android.widget.LinearLayout[@index=1]").click();
            String DUBC = dr.findElementById("com.android.settings:id/app_summary").getText();
            String DU = DUBC.substring(0, 4);
            float DUValueBC = Float.parseFloat(DU.trim());
            System.out.println("Total data usage before clearing launcher " + DUBC);

            Thread.sleep(2000);
            dr.navigate().back();
            dr.navigate().back();
            dr.findElementByName("Storage").click();
            dr.findElementByName("Clear data").click();
            dr.findElementById("android:id/button1").click();
            Thread.sleep(3000);


            dr.sendKeyEvent(AndroidKeyCode.HOME);


            Thread.sleep(3000);
            Boolean welcomePage = dr.findElementsByName("Wallpapers, widgets, & settings").size() > 0;
            if (welcomePage) {
                System.out.println("Welcome page is displayed after clearing the Launcher: Test case Passed");
                ++countTestCasePassed;
                e1.pass(14);

            } else {
                System.out.println("Welcome page is not displayed: Test case Failed");
                e1.fail(14);
            }
            String c1 = dr.findElementById("launcher3.android.com.hivelauncher:id/cb_tos").getAttribute("checked");
            System.out.println(c1);
            if (c1.equalsIgnoreCase("true")) {
                System.out.println("By default Analytics checkbox is enabled : Test Case Passed");
                ++countTestCasePassed;
                e1.pass(15);
                //dr.findElementById("launcher3.android.com.hivelauncher:id/cling_dismiss_longpress_info").click();

            } else {
                System.out.println("By default Analytics checkbox is disabled : Test Case Failed");
                e1.fail(15);
            }

            dr.findElementByName("By using our Services, you are agreeing to these terms. Please read them carefully.").click();

            Boolean terms = dr.findElementsById("android:id/contentPanel").size() > 0;
            if (terms) {
                System.out.println("Terms & condition link is working : Test case Passed");
                ++countTestCasePassed;
                e1.pass(16);

            } else {
                System.out.println("Terms & condition link is not working : Test case Failed");
                e1.fail(16);
            }

            dr.sendKeyEvent(AndroidKeyCode.HOME);
            Thread.sleep(3000);
            dr.findElementByName("GOT IT").click();


            dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
            Boolean makeCall = dr.findElementsByName("Allow HiveLauncher to make and manage phone calls?").size() > 0;
            if (makeCall) {
                System.out.println("Permission to make a call displayed : Test case Passed");
                ++countTestCasePassed;
                e1.pass(17);
                dr.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
            } else {
                System.out.println("Permission to make a call displayed : Test case Failed");
                e1.fail(17);
            }


            Boolean contacts = dr.findElementsByName("Allow HiveLauncher to access your contacts?").size() > 0;
            if (contacts) {
                System.out.println("Permission for contacts displayed : Test case Passed");
                ++countTestCasePassed;
                e1.pass(18);
                dr.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
            } else {
                System.out.println("Permission for contacts  not displayed : Test case Failed");
                e1.fail(18);
            }

            Boolean media = dr.findElementsByName("Allow HiveLauncher to access photos, media, and files on your device?").size() > 0;
            if (media) {
                System.out.println("Permission for media & file access : Test case Passed");
                ++countTestCasePassed;
                e1.pass(19);

                dr.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
            } else {
                System.out.println("Permission for media & file access : Test case Failed");
                e1.fail(19);
            }


            Boolean location = dr.findElementsByName("Allow HiveLauncher to access this device's location?").size() > 0;
            if (location) {
                System.out.println("Permission for location displayed : Test case Passed");
                ++countTestCasePassed;
                e1.pass(20);
                dr.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
            } else {
                System.out.println("Permission for location  not displayed : Test case Failed");
                e1.fail(20);
            }

            Thread.sleep(4000);
            Boolean ramCleaner = dr.findElementsByName("Check out the new RAM cleaner widget we have added.").size() > 0;
            if (ramCleaner) {
                System.out.println("Ram Cleaner description displayed : Test case Passed");
                ++countTestCasePassed;
                e1.pass(21);
            } else {
                System.out.println("Ram Cleaner description is not displayed : Test case Failed");
                e1.fail(21);
            }
            Thread.sleep(2000);
            dr.findElementByName("GOT IT").click();

            dr.sendKeyEvent(AndroidKeyCode.HOME);
            Thread.sleep(3000);

            // To check how many screens are there after clearing the hive launcher
            String str2 = dr.findElementById("launcher3.android.com.hivelauncher:id/page_indicator").getAttribute("name");
            // System.out.println(str);
            String result2 = str2.substring(16, str2.length() - 10);
            int number2 = Integer.parseInt(result2.trim());
            System.out.println("Total screens after Clearing the launcher  " + number2);

            if (number2 == 3) {
                System.out.println("Expected homescreens after clearing the Launcher is 3 : Test Case Passed");
                ++countTestCasePassed;
                e1.pass(22);
            } else {
                System.out.println("Expected homescreens after clearing the Launcher is not 3 : Test Case Failed");
                e1.fail(23);
            }


            dr.startActivity("com.android.settings", "Settings");


            ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Apps\"))");
            dr.findElementByName("Apps").click();


            Thread.sleep(3000);
            ((AndroidDriver) dr).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"HiveLauncher\"))");
            dr.findElementByName("HiveLauncher").click();

            dr.findElementByName("Data usage").click();
            dr.findElementByXPath("//android.widget.LinearLayout[@index=1]").click();
            String DUAC = dr.findElementById("com.android.settings:id/app_summary").getText();
            String DU2 = DUAC.substring(0, 4);
            float DUValueAC = Float.parseFloat(DU2.trim());
            System.out.println("Total data usage after clearing launcher " + DUAC);

            if (DUValueAC >= DUValueBC) {
                System.out.println("Data Usage After Clearing the launcher : Test Case passed");
                ++countTestCasePassed;
                e1.pass(23);
            } else {
                System.out.println("Data Usage After Clearing the launcher : Test Case Failed");
                e1.fail(23);
            }

        } catch (Exception e) {
            count = count + 1;
            System.out.println(e);
            e.getMessage();
        }

        if (countTestCasePassed == 10) {
            System.out.println("All the TestCases are passed for Clear Launcher Functionality Total Test cases Passed -> " + countTestCasePassed + " Out of 10 Test Cases");
            countTestCasePassed = 0;
        } else {
            System.out.println("All the TestCases are not Passed for Clear Launcher Functionality Total Test cases Passed -> " + countTestCasePassed + " Out of 10 Test Cases");
            countTestCasePassed = 0;
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        long tt = totalTime / 1000;
        e1.timeTaken(14, tt);
        System.out.println("Total time taken to clear the launcher (TimeUnit: In Seconds ) " + tt);
    }

    @AfterTest
    public void quit() throws Exception {

        if (dr != null) {
            dr.quit();
        }
    }

}


