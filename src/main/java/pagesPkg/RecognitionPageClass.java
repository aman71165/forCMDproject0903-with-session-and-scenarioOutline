package pagesPkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecognitionPageClass {

	private WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions action;

	private By recognitionTile = By.xpath("//a[@href='awardconfiguration']");

	private By enableEditToggle = By.xpath("//label[@class='switch']");

	private By newRecognitionButton = By.xpath("//span[contains(text(), 'New Recognition')]");  

	private By uploadCertificateButton = By.xpath("//button[@title='Upload Recognition Certificate Watermark Image']");

	private By OrganizationStructure = By.xpath("//a[@href='OrganizationStructure/Index']");


	public RecognitionPageClass(WebDriver driver) {
		this.driver= driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));  
		this.action= new Actions(driver);
	}


	public void clickRecognitionTile(){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-bar-spinner")));
		
	wait.until(ExpectedConditions.presenceOfElementLocated(OrganizationStructure));

		js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,50);");
		
		driver.findElement(recognitionTile).click();
	}


	public void clickEnableEditToggle(){
		WebElement eleEnableEditToggle =driver.findElement(enableEditToggle);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-bar-spinner")));
		eleEnableEditToggle.click();
	}

	public boolean isUploadCertificateButtonDisplayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(uploadCertificateButton));
		return driver.findElement(uploadCertificateButton).isDisplayed();
	}

	
}
