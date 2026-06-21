package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephoneNumber;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//label[text()='Yes']")
	private WebElement yesNewsLetter;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public void enterFirstName(String firstNameText) {
		elementUtils.typeTextIntoElement(firstName, firstNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterLastName(String lastNameText) {
		elementUtils.typeTextIntoElement(lastName, lastNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterEmailAddress(String emailAddressText) {
		elementUtils.typeTextIntoElement(emailAddress, emailAddressText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterTelephoneNumber(String telephoneNumberText) {
		elementUtils.typeTextIntoElement(telephoneNumber, telephoneNumberText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(password, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		elementUtils.typeTextIntoElement(confirmPassword, confirmPasswordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void clickOnPrivacyPolicy() {
		elementUtils.clickOnElement(privacyPolicy, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountSuccessPage(driver);
	}
	
	public void clickOnYesNewsLetter() {
		elementUtils.clickOnElement(yesNewsLetter, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String validateWarningMessage() {
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String validateFirstNameWarningMessage() {
		return elementUtils.getTextFromElement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String validateLastNameWarningMessage() {
		return elementUtils.getTextFromElement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String validateEmailWarningMessage() {
		return elementUtils.getTextFromElement(emailWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String validateTelephoneWarningMessage() {
		return elementUtils.getTextFromElement(telephoneWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String validatePasswordMessage() {
		return elementUtils.getTextFromElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
}
