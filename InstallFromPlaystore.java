package sample;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InstallFromPlaystore {
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
        capabilities.setCapability("appPackage", "com.android.vending");
        capabilities.setCapability("appActivity", "com.google.android.finsky.activities.MainActivity");


        dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        dr.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }


    @SuppressWarnings("rawtypes")
    @Test
    public void PlaystoreTest() throws Exception {

        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
// To click on the search box
        try {
            dr.findElementById("com.android.vending:id/search_box_idle_text").click();
//enter the text in the search box
            dr.findElementById("com.android.vending:id/search_box_text_input").sendKeys("flappy bird");
            Thread.sleep(3000);
//select the first text in the list
            dr.findElementById("com.android.vending:id/suggest_text").click();
            dr.findElementByName("Floppy Bird").click();
//Click on install button
            dr.findElementById("com.android.vending:id/buy_button").click();
//Click on Accept Button
            dr.findElementById("com.android.vending:id/continue_button").click();
            WebDriverWait wait = new WebDriverWait(dr, 180);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.vending:id/launch_button")));
            dr.openNotifications();
            Thread.sleep(2000);
            Boolean install = dr.findElementsByName("Successfully installed.").size() > 0;
            if (install) {
                System.out.println("Notification Installed Successfully is displayed: Test case Passed");
                e1.pass(39);
            } else {
                System.out.println("Notification Installed Successfully is not  displayed: Test case Failed");
                e1.fail(39);
            }
        } catch (Exception e) {
            System.out.println("Exception While installing Floppy Bird App " + e);
            e1.notExecuted(39);
        }

        dr.sendKeyEvent(AndroidKeyCode.HOME);
        Thread.sleep(2000);
        dr.startActivity("com.android.vending", "com.google.android.finsky.activities.MainActivity");
        try {
            dr.findElementById("com.android.vending:id/search_box_idle_text").click();
            //enter the text in the search box
            dr.findElementById("com.android.vending:id/search_box_text_input").sendKeys("linkdin");
            Thread.sleep(3000);
//select the first text in the list
            dr.findElementById("com.android.vending:id/suggest_text").click();
//Click on install button
            dr.findElementById("com.android.vending:id/buy_button").click();
//Click on Accept Button
            Boolean contin = dr.findElementsById("com.android.vending:id/continue_button").size() > 0;
            if (contin)
                dr.findElementById("com.android.vending:id/continue_button").click();
        } catch (Exception e) {
            System.out.println("Exception While installing Linked In  App " + e);
        }
        Thread.sleep(3000);
        dr.sendKeyEvent(AndroidKeyCode.HOME);
        Thread.sleep(2000);
        dr.startActivity("com.android.vending", "com.google.android.finsky.activities.MainActivity");
        try {
            dr.findElementById("com.android.vending:id/search_box_idle_text").click();
            //enter the text in the search box
            dr.findElementById("com.android.vending:id/search_box_text_input").sendKeys("lift");
            Thread.sleep(3000);
//select the first text in the list
            dr.findElementById("com.android.vending:id/suggest_text").click();
            dr.findElementByName("Lift Simulator").click();
//Click on install button
            Thread.sleep(2000);
            dr.findElementById("com.android.vending:id/buy_button").click();
//Click on Accept Button
            Boolean contin = dr.findElementsById("com.android.vending:id/continue_button").size() > 0;
            if (contin)
                dr.findElementById("com.android.vending:id/continue_button").click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Exception While installing Lift Simulator App " + e);
        }
        Thread.sleep(3000);
        dr.sendKeyEvent(AndroidKeyCode.HOME);
        Thread.sleep(2000);
        dr.startActivity("com.android.vending", "com.google.android.finsky.activities.MainActivity");
        try {
            dr.findElementById("com.android.vending:id/search_box_idle_text").click();
            //enter the text in the search box
            dr.findElementById("com.android.vending:id/search_box_text_input").sendKeys("fitbit");
            //select the first text in the list
            Thread.sleep(3000);
            dr.findElementById("com.android.vending:id/suggest_text").click();

            //Click on install button
            Thread.sleep(2000);
            dr.findElementById("com.android.vending:id/buy_button").click();
            // Granting Permission for M device(Click on Continue Option)
            // dr.findElementById("com.android.vending:id/positive_button").click();
            //Click on Accept Button
            Boolean contin = dr.findElementsById("com.android.vending:id/continue_button").size() > 0;
            if (contin)
                dr.findElementById("com.android.vending:id/continue_button").click();
            WebDriverWait wait = new WebDriverWait(dr, 450);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.vending:id/launch_button")));
        } catch (Exception e) {
            System.out.println("Exception While installing FitBIt   App " + e);
        }
        Thread.sleep(3000);


        dr.sendKeyEvent(AndroidKeyCode.HOME);


        Thread.sleep(3000);
        try {

            String str = dr.findElementById("launcher3.android.com.hivelauncher:id/page_indicator").getAttribute("name");
            // System.out.println(str);
            String result = str.substring(16, str.length() - 10);
            int number = Integer.parseInt(result.trim());
            for (int j = 1; j <= number; j++) {
                if (j != 1)
                    dr.swipe(630, 650, 80, 650, 0);

                @SuppressWarnings("unchecked")
                List<WebElement> appsCount = dr.findElementsByXPath("//android.widget.TextView");
                int ac = appsCount.size();
                //  System.out.println(ac);
                for (int i = 0; i < ac; i++) {
                    String s = appsCount.get(i).getText();
                    // System.out.println(s);
                    if (s.contains("LinkedIn")) {
                        System.out.println("LinkedIn App Found");
                        count++;
                    } else if (s.contains("Floppy Bird")) {
                        System.out.println("Floppy Bird App Found");
                        count++;
                    } else if (s.contains("Lift Simulator")) {
                        System.out.println("Lift Simulator  App Found");
                        count++;
                    } else if (s.contains("Fitbit")) {
                        System.out.println("Fitbit  App Found");
                        count++;
                    } else {
                        // System.out.println(" ");
                    }
                }


                //	 WebDriverWait wait = new WebDriverWait(dr,60);
                //    wait.until(ExpectedConditions.visibilityOf(dr.findElementByName("Firefox")));

            }
            if (count == 4) {
                System.out.println("All the applications installed present on HomeScreen : Test Case Passed   Total-> " + count);
                ++countTestCasePassed;
                e1.pass(40);
            } else {
                System.out.println("All the applications installed  are not present on HomeScreene: Test Case Failed Total->  " + count);
                e1.fail(40);
            }
        } catch (Exception e) {
            System.out.println("Exception While validating installed apps are present on homescreen");
            e1.notExecuted(40);
        }


        dr.sendKeyEvent(AndroidKeyCode.HOME);

        try {
            dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
            dr.findElementByName("Search apps...").sendKeys("fl");
            Thread.sleep(3000);
            String s1 = "Floppy Bird";
            String s2 = dr.findElementById("launcher3.android.com.hivelauncher:id/application_icon").getText();
            if (s1.equalsIgnoreCase(s2)) {
                System.out.println("The Floppy bird Application found after install in the App tray: Test Case Passed ");
                ++countTestCasePassed;
                e1.pass(41);
            } else {
                System.out.println("The Floppy bird app not found : Test case failed");
                e1.fail(41);
            }
        } catch (Exception e) {
            System.out.println("Exception while searching floppy bird app after install Test case" + e);
            e1.notExecuted(41);
        }


        dr.sendKeyEvent(AndroidKeyCode.HOME);

        try {
            dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
            dr.findElementByName("Search apps...").sendKeys("lift");
            Thread.sleep(3000);
            String s1 = "Lift Simulator";
            String s2 = dr.findElementById("launcher3.android.com.hivelauncher:id/application_icon").getText();
            if (s1.equalsIgnoreCase(s2)) {
                System.out.println("The Lift Simulator App found after install in the App Tray: Test Case Passed ");
                ++countTestCasePassed;
                e1.pass(42);
            } else {
                System.out.println("The Lift Simulator app not found after install : Test case failed");
                e1.fail(42);
            }
        } catch (Exception e) {
            System.out.println("Exception while searching Lift Simulator app after install Test case" + e);
            e1.notExecuted(42);
        }


        dr.sendKeyEvent(AndroidKeyCode.HOME);

        try {
            dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
            dr.findElementByName("Search apps...").sendKeys("link");
            Thread.sleep(3000);
            String s1 = "LinkedIn";
            String s2 = dr.findElementById("launcher3.android.com.hivelauncher:id/application_icon").getText();
            if (s1.equalsIgnoreCase(s2)) {
                System.out.println("The LinkedIn App Found after install in the App tray: Test Case Passed ");
                ++countTestCasePassed;
                e1.pass(43);
            } else {
                System.out.println("The LinkedIn App not Found after install: Test case failed");
                e1.fail(43);
            }
        } catch (Exception e) {
            System.out.println("Exception while searching LinkedIn app after install Test case" + e);
            e1.notExecuted(43);
        }


        dr.sendKeyEvent(AndroidKeyCode.HOME);

        try {
            dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
            dr.findElementByName("Search apps...").sendKeys("fitbit");
            Thread.sleep(3000);
            String s1 = "Fitbit";
            String s2 = dr.findElementById("launcher3.android.com.hivelauncher:id/application_icon").getText();
            if (s1.equalsIgnoreCase(s2)) {
                System.out.println("The Fitbit app found after install in the app tray: Test Case Passed ");
                ++countTestCasePassed;
                e1.pass(44);
            } else {
                System.out.println("The Fitbit app not found after install : Test case failed");
                e1.fail(44);
            }
        } catch (Exception e) {
            System.out.println("Exception while searching Fitbit app after install Test case" + e);
            e1.notExecuted(44);
        }


        if (countTestCasePassed == 5) {
            System.out.println("All the TestCases are passed for Install from Playstore Functionality Total Test cases Passed -> " + countTestCasePassed + " Out of 5 Test Cases");
            countTestCasePassed = 0;
        } else {
            System.out.println("All the TestCases are not Passed for Install from Playstore Functionality Total Test cases Passed -> " + countTestCasePassed + " Out of 5 Test Cases");
            countTestCasePassed = 0;
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        long tt = totalTime / 1000;
        e1.timeTaken(39, tt);
        System.out.println("Total time taken to install from playstore & check apps present on Homescreen & AppTray (TimeUnit: In Seconds ) " + tt);

    }

    @AfterTest
    public void quit() throws Exception {

        if (dr != null) {
            dr.quit();
        }
    }

}


