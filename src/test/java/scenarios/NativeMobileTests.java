package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NativePageObject;
import setup.BaseTest;

public class NativeMobileTests extends BaseTest {

    NativePageObject nativePageObject;

    @Test(groups = {"native"},
            description = "This simple test just click on the Sign In button")
    public void simpleNativeTest() {

        String email = "example@email.com";
        String userName = "example";
        String password = "justPass";

        nativePageObject.getSignInPageObject().openRegistrationWindow();
        nativePageObject.getRegistrationPageObject().registerAccount(email, userName, password);

        nativePageObject.getSignInPageObject().signIn(email, password);

        String text = nativePageObject.getBudgetActivityPageObject().getTitle().getText();
        String expected = "BudgetActivity";
        Assert.assertEquals(text, expected,
                "Check page title");
    }

    @Override
    public void setUpPageObjects() {

        nativePageObject = new NativePageObject(appiumDriver);
    }
}
