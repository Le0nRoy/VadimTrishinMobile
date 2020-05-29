package pageObjects.nativeObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.AbstractPageObject;

public class SignInPageObject extends AbstractPageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    WebElement emailField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    WebElement passwordField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    WebElement signInBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    WebElement registerBtn;

    public SignInPageObject(AppiumDriver appiumDriver) {

        super(appiumDriver);
    }

    public void openRegistrationWindow() {

        registerBtn.click();
    }

    public void signIn(String email, String password) {

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInBtn.click();
    }
}
