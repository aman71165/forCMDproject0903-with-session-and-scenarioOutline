package utilPkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utilClass {
	
	WebDriver driver;
	  WebDriverWait wait; 
	
	public utilClass(WebDriver driver){
		this.driver=driver;
		//this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	
	
}
