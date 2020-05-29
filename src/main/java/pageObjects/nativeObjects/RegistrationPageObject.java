package pageObjects.nativeObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.AbstractPageObject;

public class RegistrationPageObject extends AbstractPageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    WebElement emailField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    WebElement userNameField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    WebElement passwordField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    WebElement passwordConfirmationField;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView")
    WebElement agreementsCheckbox;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    WebElement registerNewAccountBtn;

    public RegistrationPageObject(AppiumDriver appiumDriver) {

        super(appiumDriver);
    }

    public void registerAccount(String email, String userName, String password) {

        emailField.sendKeys(email);
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        passwordConfirmationField.sendKeys(password);
        agreementsCheckbox.click();
        registerNewAccountBtn.click();
    }
}
