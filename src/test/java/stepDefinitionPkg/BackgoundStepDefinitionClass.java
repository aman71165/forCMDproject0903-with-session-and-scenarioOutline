package stepDefinitionPkg;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import browserSetupPkg.BrowserSetupClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPkg.AdminPanelPageElementsClass;
import pagesPkg.HomePageElementsClass;
import pagesPkg.MySummaryElementsClass;

public class BackgoundStepDefinitionClass {
	WebDriver driver;

	AdminPanelPageElementsClass loginClass;

	BrowserSetupClass browser = new BrowserSetupClass();

/*
	@Before
	public void beforeScenario() throws InterruptedException {
		Thread.sleep(500);
	}

	@After
	public void afterScenario() throws InterruptedException {
	//	driver = browser.browserSetup();

		loginClass= new AdminPanelPageElementsClass(driver);
		
		loginClass.clickProfileImage();
		loginClass.clickLogoutLink();
		Thread.sleep(200);
		loginClass.clickYesLogoutButton();
		Thread.sleep(500);
		driver.quit();
	}

*/

	public void takeSS()  {

		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

		File fileSource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotName = "screenshot_" + timestamp + ".png";

		File fileDesti= new File ("E:/Satish Jaiswal/BDD 2025/dAdminPanel/target/Manualscreenshot/" +screenshotName);


		try {
			FileUtils.copyFile(fileSource,fileDesti);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Given("user gets logged in with correct credentials")
	public void user_gets_logged_in_with_correct_credentials() throws InterruptedException {

		driver = browser.browserSetup();

		loginClass= new AdminPanelPageElementsClass(driver);


		loginClass.enterUsername("toshu@yopmail.com");
		loginClass.enterPassword("pass@1234");

			takeSS();
		loginClass.clickLoginButton();
		Thread.sleep(500);

	}

	@And("user is on the homepage")
	public void user_is_on_the_homepage() throws InterruptedException {

		String homePageTitle= driver.getTitle();
		System.out.println("user is now on the BACKGROUND  " + homePageTitle);



	}

	@When("user clicks on Recognize link")
	public void user_clicks_on_recognize_link() {
		HomePageElementsClass homeClass= new HomePageElementsClass(driver);
		homeClass.clickRecognizeLink();

	}

	@Then("user navaigates to the Recognize page")
	public void user_navaigates_to_the_recognize_page() throws InterruptedException {
		String recognizePageTitle= driver.getTitle();
		System.out.println("user is now on the " + recognizePageTitle);
		Assert.assertTrue(driver.getCurrentUrl().contains("Recognize"));

	}

	@When("user clicks on MySummary link")
	public void user_clicks_on_my_summary_link() {
		MySummaryElementsClass mySummaryClass= new MySummaryElementsClass(driver);
		mySummaryClass.clickMySummaryLink();



	}

	@Then("user navaigates to the MySummary page")
	public void user_navaigates_to_the_my_summary_page() {
		String mySummaryPageTitle= driver.getTitle();
		System.out.println("user is now on the " + mySummaryPageTitle);
		Assert.assertTrue(driver.getCurrentUrl().contains("Home"));




	}


}
