package pageObjects;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import pageObjects.webObjects.GooglePageObject;

@Getter
public class WebPageObject {

    GooglePageObject googlePage;

    public WebPageObject(AppiumDriver appiumDriver) {

        googlePage = new GooglePageObject(appiumDriver);
    }

}
