package hw.scenarios;

import hw.DTO.NativeTestDTO;
import hw.DataProviders;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NativePageObject;
import hw.BaseTest;

public class NativeMobileTests extends BaseTest {

    NativePageObject nativePageObject;

    @Test(groups = {"native"},
            dataProviderClass = DataProviders.class,
            dataProvider = "nativeTestDataProvider",
            description = "This simple test just click on the Sign In button")
    public void simpleNativeTest(NativeTestDTO dto) {

        String email = dto.getEmail();
        String userName = dto.getUserName();
        String password = dto.getPassword();

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
