package hw.steps;

import hw.DTO.NativeTestDTO;
import hw.assertions.NativeMobileTestAssertions;
import io.appium.java_client.AppiumDriver;
import pageObjects.NativePageObject;

public class NativeMobileTestSteps {

    NativeTestDTO dto;
    NativePageObject nativePageObject;
    NativeMobileTestAssertions assertions;

    public NativeMobileTestSteps(AppiumDriver driver) {

        nativePageObject = new NativePageObject(driver);
        assertions = new NativeMobileTestAssertions(nativePageObject);
    }

    public void setDto(NativeTestDTO dto) {

        this.dto = dto;
    }

    public void createAccount() {

        nativePageObject.getSignInPageObject().openRegistrationWindow();
        nativePageObject.getRegistrationPageObject().registerAccount(
                dto.getEmail(),
                dto.getUserName(),
                dto.getPassword()
        );
    }

    public void signIn() {

        nativePageObject.getSignInPageObject().signIn(
                dto.getEmail(),
                dto.getPassword()
        );
    }

    public void verifyBudgetActivityPageTitle() {

        String expectedTitle = "BudgetActivity";
        assertions.verifyBudgetActivityPageTitle(expectedTitle);
    }
}
