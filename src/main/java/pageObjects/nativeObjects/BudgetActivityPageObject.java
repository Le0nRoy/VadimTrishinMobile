package pageObjects.nativeObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.AbstractPageObject;

public class BudgetActivityPageObject extends AbstractPageObject {

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView")
    WebElement title;

    public BudgetActivityPageObject(AppiumDriver appiumDriver) {

        super(appiumDriver);
    }

    public WebElement getTitle() {

        return title;
    }

}
