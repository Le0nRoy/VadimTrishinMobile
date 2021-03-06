package hw.scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import hw.BaseTest;

public class webMobileTests extends BaseTest {

    @Override
    public void setUpPageObjects() {

    }

    @Test(groups = {"web"},
            description = "Make sure that we've opened IANA homepage")
    public void simpleWebTest() throws InterruptedException {
        // open IANA homepage
        getDriver().get("http://iana.org");

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        // Check IANA homepage title
        assert ((WebDriver) getDriver()).getTitle().equals("Internet Assigned Numbers Authority") : "This is not IANA homepage";

        // Log that test finished
        System.out.println("Site opening done");
    }

}
