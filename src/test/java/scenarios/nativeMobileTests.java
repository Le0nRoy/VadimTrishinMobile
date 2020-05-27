package scenarios;

import org.testng.annotations.Test;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"},
            description = "This simple test just click on the Sign In button")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        getPo().getWelement("signInBtn").click();

        registerAccount("example@email.com", "example", "justPass");
        System.out.println("Simplest Android native test done");
    }

    private void registerAccount(String email, String userName, String password) throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        getPo().getWelement("registerBtn").click();
        getPo().getWelement("emailField").sendKeys(email);
        getPo().getWelement("userNameField").sendKeys(userName);
        getPo().getWelement("passwordField").sendKeys(password);
        getPo().getWelement("passwordConfirmationField").sendKeys(password);
        // FIXME not gets clicked
        getPo().getWelement("agreamentsCheckbox").click();
        getPo().getWelement("registerNewAccountBtn").click();
    }
}
