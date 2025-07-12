package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.Util;

import java.io.IOException;
import java.text.ParseException;

@Epic("Regression Tests")
@Feature("User")
public class TestCase1 extends TestBasic{
    String name= "name"+ Util.generateCurrentDateAndTime();
    String email="email"+ Util.generateCurrentDateAndTime()+ "@02.pl";

    @Test(description = "Test case 1: Register user")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Register User")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Signup / Login' button
            5. Verify 'New User Signup!' is visible
            6. Enter name and email address
            7. Click 'Signup' button
            8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
            9. Fill details: Title, Name, Email, Password, Date of birth
            10. Select checkbox 'Sign up for our newsletter!'
            11. Select checkbox 'Receive special offers from our partners!'
            12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
            13. Click 'Create Account button'
            14. Verify that 'ACCOUNT CREATED!' is visible
            15. Click 'Continue' button
            16. Verify that 'Logged in as username' is visible
            17. Click 'Delete Account' button
            18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button""")

   public void registerUser() throws IOException, ParseException {
        verifyThatHomePageIsVisibleSuccessfully();
        verifyNewUserSignupIsVisible();
        verifyThatEnterAccountInformationIsVisible();
        verifyThatAccountCreatedIsVisible();
        verifyThatLoggedInAsUsernameIsVisible();
        verifyThatAccountDeletedIsVisibleAndClickContinueButton();


    }
    @Step("Verify that home page is visible successfully")
    public void verifyThatHomePageIsVisibleSuccessfully(){
        boolean homePageVisible = new HomePage(getDriver()).homePageIsVisible().isDisplayed();
        Assert.assertTrue(homePageVisible,"Verify that home page is visible successfully");

    }
    @Step("Verify 'New User Signup!' is visible")
    public void verifyNewUserSignupIsVisible(){
        String newUserSignupText = new HomePage(getDriver()).signupLoginClick().getNewUserSignup().getText();
        Assert.assertEquals(newUserSignupText,"Verify 'New User Signup!' is visible");

    }
    @Step("Verify that 'ENTER ACCOUNT INFORMATION' is visible")
    public void verifyThatEnterAccountInformationIsVisible(){
        String enterAccountInformationText  = new LoginSignupPage(getDriver()).fillCorrectSignup(name,email).getEnterAccountInformation().getText();
        Assert.assertEquals(enterAccountInformationText,"ENTER ACCOUNT INFORMATION","Verify that 'ENTER ACCOUNT INFORMATION' is visible");

    }
    @Step("Verify that 'ACCOUNT CREATED!' is visible")
    public void verifyThatAccountCreatedIsVisible() throws IOException, ParseException {
        String accountCreatedText = new EnterAccountInformationPage(getDriver()).fillAccountDetails().getAccountCreated().getText();
        Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!", "Verify that 'ACCOUNT CREATED!' is visible");
    }
    @Step("Verify that 'Logged in as username' is visible")
    public void verifyThatLoggedInAsUsernameIsVisible(){
        String username = new AccountCreatedPage(getDriver())
                .continueButtonClick()
                .getUsername()
                .getText();
        Assert.assertEquals(username, name, "Verify that 'Logged in as username' is visible");
    }
    @Step("Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button")
    public void verifyThatAccountDeletedIsVisibleAndClickContinueButton(){
        String accountDeletedText = new LoggedHomePage(getDriver())
                .deleteAccountButtonClick()
                .getAccountDeleted()
                .getText();
        Assert.assertEquals(accountDeletedText, "ACCOUNT DELETED!", "Verify that 'ACCOUNT DELETED!' is visible");
        new AccountDeletedPage(getDriver()).continueButtonClick();

    }

                    

                    
    }




