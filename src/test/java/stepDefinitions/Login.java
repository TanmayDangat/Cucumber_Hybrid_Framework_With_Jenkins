package stepDefinitions;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;


public class Login {
	
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	private HomePage homePage;

	@Given("User navigates to login page")
	public void User_navigates_to_login_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();
	}
	
	@When("^User has entered valid email address (.+) into email field$")
	public void user_has_entered_valid_email_address_into_email_field(String validEmailAddress) {
		loginPage.enterEmailAddress(validEmailAddress);
	}

	@When("^User has entered valid password (.+) into password field$")
	public void user_has_entered_valid_passport_into_password_field(String validPassword) {
	    loginPage.enterPassword(validPassword);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		accountPage = loginPage.clickOnLoginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	}

	@When("User has entered invalid email address into email field")
	public void user_has_entered_invalid_email_address_into_email_field() {
		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
	}

	@When("^User has entered invalid password (.+) into password field$")
	public void user_has_entered_invalid_passport_into_password_field(String invalidPassword) {
		loginPage.enterPassword(invalidPassword);
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {	
	    Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@Given("User do not enter email address into email field")
	public void user_do_not_enter_email_address_into_email_field() {
		loginPage.enterEmailAddress("");
	}

	@Given("User do not enter password into password field")
	public void user_do_not_enter_password_into_password_field() {
		loginPage.enterPassword("");
	}

	
}
