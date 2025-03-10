package pagesPkg;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HometoAdminPanelClass {

	private WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	private By profileImage = By.xpath("//img[@alt='Default Profile Image']");

	private By adminPanelLink = By.xpath("//a[@class='ng-binding ng-scope ng-isolate-scope']");

	private By MySummary = By.xpath("//a[@class='cursorPointer' and @href='Home/viewProfile']");

	private By OrganizationStructure = By.xpath("//a[@href='OrganizationStructure/Index']");

	private	By frontEndlogoutLink= By.xpath("//a[@title='Logout']");

	private	By frontEndyesLogoutButton= By.xpath("//button[contains(text(), 'Yes')]");


	public HometoAdminPanelClass(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	}

	
	public boolean isMySummaryDisplayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(MySummary));

		return driver.findElement(MySummary).isDisplayed();
	}

	public void clickAdminPanelLink() throws InterruptedException {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-bar-spinner")));
		WebElement eleAdminPanelLink = wait.until(ExpectedConditions.presenceOfElementLocated(adminPanelLink));

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", eleAdminPanelLink);

	}



	
	public void moveToAdminPanel() throws InterruptedException {

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

		driver.switchTo().window(windowHandles.get(1));
	}


	public boolean isOrganizationStructureDisplayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(OrganizationStructure));
		return driver.findElement(OrganizationStructure).isDisplayed();
	}

	public void clickFrontEndLogoutLink() {
		WebElement eleLogoutLink= wait.until(ExpectedConditions.presenceOfElementLocated(frontEndlogoutLink));

		js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", eleLogoutLink);
	}

	public void clickYesFrontEndLogoutButton() {
		driver.findElement(frontEndyesLogoutButton).click();
	}
	


	
}
