package sample;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class QuickSettings {
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


    @Test
    public void calc() throws Exception {
        Thread.sleep(3000);
        dr.findElement(By.id("launcher3.android.com.hivelauncher:id/hotseat")).click();
        dr.findElementByName("Search apps...").sendKeys("cehjmosvwz");
        Thread.sleep(15000);

    }

    @AfterTest
    public void quit() throws Exception {

        if (dr != null) {
            dr.quit();
        }
    }

}


        
