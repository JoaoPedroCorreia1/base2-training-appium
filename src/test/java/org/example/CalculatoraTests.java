package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatoraTests {
    String platformName = "Android";
    String platformVersion = "8.1";
    String deviceName = "emulator-5554";
    String appPackage = "com.android.calculator2";
    String appActivity = "com.android.calculator2.Calculator";

    @Test
    public void praticaDivisaoDoisNumeros() throws MalformedURLException, InterruptedException {
        //Parâmetros
        String numero1 = "4";
        String numero2 = "2";
        String resultadoDivisao = "2";

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", platformName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);

        AppiumDriver driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(3000);

        //Fluxo
        driver.findElementById("com.android.calculator2:id/digit_4").click();
        driver.findElementById("com.android.calculator2:id/op_div").click();
        driver.findElementById("com.android.calculator2:id/digit_2").click();
        driver.findElementById("com.android.calculator2:id/eq").click();

        //Asserções
        Assert.assertEquals(driver.findElementById("com.android.calculator2:id/result").getText(), resultadoDivisao);

        driver.quit();
    }

    @Test
    public void praticaSomarDoisNumeros() throws MalformedURLException, InterruptedException {
        //Parâmetros
        String numero1 = "4";
        String numero2 = "2";
        String resultadoSoma = "6";

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", platformName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);

        AppiumDriver driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(3000);

        //Fluxo
        driver.findElementByXPath("//android.widget.LinearLayout[@content-desc='Numbers and basic operations']/android.view.ViewGroup[1]/android.widget.Button[4]").click();
        driver.findElementByXPath("//android.widget.Button[@content-desc='plus']").click();
        driver.findElementByXPath("//android.widget.LinearLayout[@content-desc='Numbers and basic operations']/android.view.ViewGroup[1]/android.widget.Button[8]").click();
        driver.findElementByXPath("//android.widget.Button[@content-desc='equals']").click();

        //Asserções
        Assert.assertEquals(driver.findElementByXPath("/hierarchy/android.widge" +
                "t.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
                "android.view.ViewGroup/android.widget.LinearLayout/android.widget.Li" +
                "nearLayout/android.widget.TextView").getText(), resultadoSoma);

        driver.quit();
    }
}
