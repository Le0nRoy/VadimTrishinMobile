package pageObjects;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import pageObjects.nativeObjects.BudgetActivityPageObject;
import pageObjects.nativeObjects.RegistrationPageObject;
import pageObjects.nativeObjects.SignInPageObject;

@Getter
public class NativePageObject {

    SignInPageObject signInPageObject;
    RegistrationPageObject registrationPageObject;
    BudgetActivityPageObject budgetActivityPageObject;

    public NativePageObject(AppiumDriver appiumDriver) {

        signInPageObject = new SignInPageObject(appiumDriver);
        registrationPageObject = new RegistrationPageObject(appiumDriver);
        budgetActivityPageObject = new BudgetActivityPageObject(appiumDriver);
    }

}
