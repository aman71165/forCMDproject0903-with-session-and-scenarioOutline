package pagesPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageElementsClass {

	WebDriver driver;

	By recognizeLink = By.xpath("//a[@class='cursorPointer' and .//span[contains(text(), 'Recognize')]]");


	public	HomePageElementsClass(WebDriver driver){
		this.driver= driver;
	}

	public void clickRecognizeLink() {
		driver.findElement(recognizeLink).click();

	}
}
