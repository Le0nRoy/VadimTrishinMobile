package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageObject {

    protected AppiumDriver driver;
    protected WebDriverWait wait;

    protected AbstractPageObject(AppiumDriver appiumDriver) {

        this.driver = appiumDriver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
