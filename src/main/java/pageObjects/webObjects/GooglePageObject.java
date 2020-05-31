package pageObjects.webObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import pageObjects.AbstractPageObject;

import java.util.ArrayList;
import java.util.List;

public class GooglePageObject extends AbstractPageObject {

    public GooglePageObject(AppiumDriver appiumDriver) {

        super(appiumDriver);
    }

    public void openGooglePage() {

        driver.get("https://www.google.com/");
        wait.until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
    }

    public void searchByKeyword(String keyword) {

    }

    public List<String> getSearchResults() {

        List<String> results = new ArrayList<>();
        return results;
    }
}
