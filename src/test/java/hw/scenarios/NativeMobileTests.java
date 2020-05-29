package hw.scenarios;

import hw.DTO.NativeTestDTO;
import hw.DataProviders;

import hw.steps.NativeMobileTestSteps;
import org.testng.annotations.Test;
import hw.BaseTest;

public class NativeMobileTests extends BaseTest {

    NativeMobileTestSteps steps;

    @Test(groups = {"native"},
            dataProviderClass = DataProviders.class,
            dataProvider = "nativeTestDataProvider",
            description = "This test checks registration, signing in and " +
                    "checks title of final page.")
    public void registerAccountSignInAndCheckPageTitleTest(NativeTestDTO dto) {

        steps.setDto(dto);
        steps.createAccount();
        steps.signIn();
        steps.verifyBudgetActivityPageTitle();
    }

    @Override
    public void setUpPageObjects() {

        steps = new NativeMobileTestSteps(appiumDriver);
    }
}
