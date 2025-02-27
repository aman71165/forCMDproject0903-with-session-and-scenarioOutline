package pagesPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MySummaryElementsClass {

	WebDriver driver;


	By mySummaryLink = By.xpath("//a[@class='cursorPointer' and .//span[contains(text(), 'My Summary')]]");


	public	MySummaryElementsClass(WebDriver driver){
		this.driver= driver;
	}

	public void clickMySummaryLink() {
		driver.findElement(mySummaryLink).click();
	}



}
