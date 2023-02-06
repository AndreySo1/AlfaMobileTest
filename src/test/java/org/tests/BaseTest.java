package org.tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.pages.BasePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;
    private DesiredCapabilities buildCapabilities(String deviceName, String platformName, String platformVersion, String udid, String app){
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("app", app);

        return capabilities;
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        Assert.assertTrue(file.exists(), filePath + " not found!");//проверяем что файл существует

        return file.getAbsolutePath();
    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capNexus = buildCapabilities("Galaxy Nexus API 23", "Android", "6.0", "emulator-5554", getAbsolutePath("src/test/resources/appAlfa.apk"));
//        DesiredCapabilities capRedmi = buildCapabilities("Redmi 3S", "Android", "6.0.1", "7551a1907d33", getAbsolutePath("src/test/resources/appAlfa.apk"));

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capNexus);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        BasePage.setDriver(driver);
    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        driver.quit();
    }

}
