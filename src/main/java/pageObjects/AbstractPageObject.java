package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageObject {

    protected AppiumDriver driver;

    protected AbstractPageObject(AppiumDriver appiumDriver) {

        this.driver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
