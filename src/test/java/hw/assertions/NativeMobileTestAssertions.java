package hw.assertions;

import org.testng.Assert;
import pageObjects.NativePageObject;

public class NativeMobileTestAssertions {

    NativePageObject nativePageObject;

    public NativeMobileTestAssertions(NativePageObject nativePageObject) {

        this.nativePageObject = nativePageObject;
    }

    public void verifyBudgetActivityPageTitle(String expectedTitle) {

        String text = nativePageObject.getBudgetActivityPageObject().getTitle().getText();
        Assert.assertEquals(text, expectedTitle,
                "Check page title");
    }
}
