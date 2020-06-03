package hw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import setup.IDriver;

public abstract class BaseTest implements IDriver {

    // singleton
    protected static AppiumDriver appiumDriver;

    private TestProperties testProperties;

    @Override
    public AppiumDriver getDriver() {

        return appiumDriver;
    }

    @Parameters({"platformName", "appType", "deviceName", "udid", "browserName", "app", "appPackage", "appActivity", "bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName,
                      String appType,
                      @Optional("") String deviceName,
                      @Optional("") String udid,
                      @Optional("") String browserName,
                      @Optional("") String app,
                      @Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String bundleId
    ) throws Exception {

        System.out.println("Before: app type - " + appType);
        setAppiumDriver(platformName, deviceName, udid, browserName, app, appPackage, appActivity, bundleId);
        setUpPageObjects();
        setUpDataProviders();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {

        System.out.println("After");
        if (appiumDriver != null) {
            appiumDriver.closeApp();
        }
    }

    private void setAppiumDriver(String platformName, String deviceName, String udid, String browserName,
                                 String app, String appPackage, String appActivity, String bundleId) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);

        if (app.endsWith(".apk")) {
            capabilities.setCapability("app", (new File(app)).getAbsolutePath());
        }

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");

        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);

        capabilities.setCapability("bundleId", bundleId);

        try {
            appiumDriver = new AppiumDriver(new URL(System.getProperty("ts.appium")), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Connection isn't established!");
            e.printStackTrace();
        }

        // FIXME change to explicit waits
        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void setUpDataProviders() {

        Properties properties = new Properties();
        String propFileName = "test.properties";
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(propFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        testProperties = new TestProperties(
                properties.getProperty("nativeTestDataJsonDataPath"),
                properties.getProperty("nativeTestDataJsonDataNamePattern"),
                properties.getProperty("webTestDataJsonDataPath"),
                properties.getProperty("webTestDataJsonDataNamePattern")
        );

        DataProviders.setNativeTestDataJsonDataPath(testProperties.getNativeTestDataJsonDataPath());
        DataProviders.setNativeTestDataJsonDataNamePattern(testProperties.getNativeTestDataJsonDataNamePattern());
        DataProviders.setWebTestDataJsonDataPath(testProperties.getWebTestDataJsonDataPath());
        DataProviders.setWebTestDataJsonDataNamePattern(testProperties.getWebTestDataJsonDataNamePattern());
    }

    public abstract void setUpPageObjects();

}
