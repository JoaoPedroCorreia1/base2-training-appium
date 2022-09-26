package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class AppTest
{

    @Test
    public void conectarAppiumEmulador() throws MalformedURLException, InterruptedException {
        //Parâmetros
        String platformName = "Android";
        String platformVersion = "8.1";
        String deviceName = "emulator-5554";
        String appPackage = "com.android.calculator2";
        String appActivity = "com.android.calculator2.Calculator";

        String context = "NATIVE_APP";

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", platformName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);

        AppiumDriver driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(3000);

        //Fluxo

        //Asserções
        Assert.assertEquals(driver.getCapabilities().getCapability("appPackage"), appPackage);
        Assert.assertEquals(driver.getCapabilities().getCapability("appActivity"), appActivity);

        Assert.assertEquals(driver.getContext(), context);

        driver.quit();
    }
}
