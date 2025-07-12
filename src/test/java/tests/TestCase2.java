package tests;


import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginSignupPage;
import utils.JSONReader;

import java.io.IOException;
import java.text.ParseException;

@Epic("Regression Tests")
@Feature("User")
public class TestCase2 extends TestBasic{
    @Test(description = "Test Case 2: Login User with correct email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login User with correct email and password")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Signup / Login' button
            5. Verify 'Login to your account' is visible
            6. Enter correct email address and password
            7. Click 'login' button
            8. Verify that 'Logged in as username' is visible""")
    public static void loginUserWithCorrectEmailAndPassword() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyThatLoggedInAsUsernameIsVisible();
        verifyLoginToYourAccountIsVisible();

    }

    @Step("Verify 'Login to your account' is visible")
    private static void verifyThatLoggedInAsUsernameIsVisible() {
        String loginToYourAccount = new HomePage(getDriver()).signupLoginClick().getLoginToYourAccount().getText();
        Assert.assertEquals(loginToYourAccount,"Login to your account","Verify 'Login to your account' is visible");

    }

    @Step("Verify that 'Logged in as username' is visible")
    static void verifyLoginToYourAccountIsVisible() throws IOException, java.text.ParseException {

        String username = new LoginSignupPage(getDriver()).fillCorrectLogin(JSONReader.existingUser("email"),JSONReader.existingUser("password")).getUsername().getText();
        Assert.assertEquals(username,"Verify that 'Logged in as username' is visible");

    }

}
