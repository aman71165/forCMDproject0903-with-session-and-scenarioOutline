package pagesPkg;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AdminPanelPageElementsClass {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;




	private	By usernameField= By.name("username");

	private	By passwordField= By.name("password");

	private	By loginButton= By.id("cred_sign_in_button");

	private	By profileImage= By.xpath("//img[@alt='Default Profile Image']");

	private	By adminPanelLink= By.xpath("//a[@class='ng-binding ng-scope ng-isolate-scope']");

	private	By logoutLink= By.xpath("//a[@title='Logout']");

	private	By yesLogoutButton= By.xpath("//button[contains(text(), 'Yes')]");
	

	
	private By recognitionTile = By.xpath("//a[@href='awardconfiguration']");



	public AdminPanelPageElementsClass(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));  // Initialize WebDriverWait
	}


	public void enterUsername(String uName) {
		WebElement enterUsername= wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
		enterUsername.sendKeys(uName);
	}

	public void enterPassword(String pwd) {
		driver.findElement(passwordField).sendKeys(pwd);
	}

	public void clickLoginButton() {

		wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
		driver.findElement(loginButton).click();
	}

	public void clickProfileImage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(profileImage)).click();
		//driver.findElement(profileImage).click();
	}


	public void clickAdminPanelLink() throws InterruptedException {

		WebElement eleAdminPanelLink= wait.until(ExpectedConditions.presenceOfElementLocated(adminPanelLink));
	//	WebElement eleAdminPanelLink= wait.until(ExpectedConditions.visibilityOfElementLocated(adminPanelLink));

		js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", eleAdminPanelLink);
		}
		
	

	public void clickLogoutLink() {
		WebElement eleLogoutLink= wait.until(ExpectedConditions.presenceOfElementLocated(logoutLink));

		js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", eleLogoutLink);
	}


	public void moveToAdminPanel() throws InterruptedException{	

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		
		driver.switchTo().window(windowHandles.get(1));
	}
	

	public void moveToMainApp() throws InterruptedException{	
		wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

		driver.switchTo().window(windowHandles.get(0));
	}
	
	/*
	 * public void clickYesLogoutButton() {
	 * driver.findElement(yesLogoutButton).click(); }
	 */
	 public PGrewardAdditionClass clickYesLogoutButton() {
	        driver.findElement(yesLogoutButton).click();
	        return new PGrewardAdditionClass(driver);
	}
}


