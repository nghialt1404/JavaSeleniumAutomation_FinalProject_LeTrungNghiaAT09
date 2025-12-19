package FinalProject_AT09.pages;

import constants.DataConfig;
import helpers.PropertiesHelper;
import helpers.SystemHelper;
import keyword.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Properties;

public class LoginPage extends BasePage {

    // Element LoginPage
    private By headerLoginPage = By.xpath("//div[@class='card-header text-center']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Sign in']");
    private By linkForgotPassword = By.xpath(" //a[normalize-space()='Forgot password?']");

    private By errorMessage_EmailInvalid = By.xpath("//span[@id='email-error']");
    private By errorMessage_EmailNull = By.xpath("//span[@id='email-error']");
    private By errorMessage_PasswordNull = By.xpath("//span[@id='password-error']");
    private By errorMessage_WrongEmailOrPassword = By.xpath("//div[@role='alert']");

    // Method

    public void navigateToLoginPage() {
        WebUI.openURL(PropertiesHelper.getValue("url"));
        WebUI.waitForPageLoaded();
    }


    private void enterEmail(String email) {
        WebUI.setText(inputEmail, email);
    }

    private void enterPassword(String password) {
        WebUI.setText(inputPassword, password);
    }

    private void clickLoginButton() {
        WebUI.clickElement(buttonLogin);
    }


    public void loginSusscess(String email, String password) {
        navigateToLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        WebUI.waitForPageLoaded();
    }


    public void loginFailureWithEmailInvalid(String email, String password) {
        navigateToLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        WebUI.waitForPageLoaded();
    }

    public void loginFailureWithPasswordInvalid(String email, String password) {
        navigateToLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        WebUI.waitForPageLoaded();
    }

    public void loginFailureWithEmailNull(String email, String password) {
        navigateToLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        WebUI.waitForPageLoaded();
    }

    public void loginFailureWithPasswordNull(String email, String password) {
        navigateToLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        WebUI.waitForPageLoaded();
    }

    public void verifyLoginSuccess() {
        boolean check = WebUI.checkElementExist(By.xpath("//span[normalize-space()='Dashboard']"), 5, 1000);
        Assert.assertTrue(check, "Login failed or Dashboard not displayed.");
    }

    public void verifyLoginFailureWithInvalidEmailOrPassword() {
        boolean check = WebUI.checkElementExist(errorMessage_WrongEmailOrPassword, 5, 1000);
        Assert.assertTrue(check, "Error message not displayed.");
    }

    public void verifyLoginFailureWithEmailNull() {
        boolean check = WebUI.checkElementExist(errorMessage_EmailNull, 5, 1000);
        Assert.assertTrue(check, "Error message for required email not displayed.");
    }

    public void verifyLoginFailureWithPasswordNull() {
        boolean check = WebUI.checkElementExist(errorMessage_PasswordNull, 5, 1000);
        Assert.assertTrue(check, "Error message for required password not displayed.");
    }


}
