package utilPkg;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class TakesScreenshotClass {

	WebDriver driver;
	
	public TakesScreenshotClass(WebDriver driver1){
		this.driver= driver1;		
	}
	
	public void takeSS(Scenario scenario)  {
		  if (scenario.isFailed()) {
		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());



		File fileSource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotName = "screenshot_" + timestamp + ".png";

		File fileDesti= new File ("E:/Satish Jaiswal/BDD 2025/dAdminPanel/target/Manualscreenshot/" + screenshotName);


		try {
			FileUtils.copyFile(fileSource,fileDesti);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	}
}
