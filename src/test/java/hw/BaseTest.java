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

    @Parameters({"platformName", "appType", "deviceName", "browserName", "app"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName, String appType, String deviceName, @Optional("") String browserName, @Optional("") String app) throws Exception {

        System.out.println("Before: app type - " + appType);
        setAppiumDriver(platformName, deviceName, browserName, app);
        setUpPageObjects();
        setUpDataProviders();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {

        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName, String deviceName, String browserName, String app) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);

        if (app.endsWith(".apk")) {
            capabilities.setCapability("app", (new File(app)).getAbsolutePath());
        }

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");

        try {
            appiumDriver = new AppiumDriver(new URL(System.getProperty("ts.appium")), capabilities);
        } catch (MalformedURLException e) {
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
