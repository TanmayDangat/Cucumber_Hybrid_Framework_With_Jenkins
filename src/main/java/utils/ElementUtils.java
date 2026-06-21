package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
	}
	
	public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void selectOptionInDropdown(WebElement element, String dropdownOption, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		Select select = new Select(element);
		select.selectByVisibleText(dropdownOption);
	}
	
	public void acceptAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
	}
	
	public void dismissAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	public Alert waitForAlert(long durationInSeconds) {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public void mouseHoverAndClickElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisibilityOElement(element, durationInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}
	
	public WebElement waitForVisibilityOElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void javaScriptClick(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisibilityOElement(element, durationInSeconds);
		JavascriptExecutor javaScriptExecutor = ((JavascriptExecutor)driver);
		javaScriptExecutor.executeScript("arguments[0].click();",webElement);
	}
	
	public void javaScriptType(WebElement element, long durationInSeconds, String textToBeTyped) {
		WebElement webElement = waitForVisibilityOElement(element, durationInSeconds);
		JavascriptExecutor javaScriptExecutor = ((JavascriptExecutor)driver);
		javaScriptExecutor.executeScript("arguments[0].value='"+textToBeTyped+"';",webElement);
	}
	
	public String getTextFromElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisibilityOElement(element, durationInSeconds);
		return webElement.getText();
	}
	
	public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {
		try {
			WebElement webElement = waitForVisibilityOElement(element, durationInSeconds);
			return webElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
