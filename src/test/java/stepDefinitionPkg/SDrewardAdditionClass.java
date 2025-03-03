package stepDefinitionPkg;

import org.openqa.selenium.*;

import browserSetupPkg.BrowserSetupClass;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPkg.AdminPanelPageElementsClass;
import pagesPkg.PGrewardAdditionClass;


public class SDrewardAdditionClass {

	WebDriver driver;

	AdminPanelPageElementsClass loginClass;

	BrowserSetupClass browser = new BrowserSetupClass();

	PGrewardAdditionClass rewardAdd;



	@Given("user is on Admin Panel app")
	public void user_is_on_admin_panel_app() throws InterruptedException {
		driver = browser.browserSetup();

		loginClass= new AdminPanelPageElementsClass(driver);

		loginClass.enterUsername("aman71165@gmail.com");
		loginClass.enterPassword("pass@12345");

		String pageTitle = driver.getTitle();
		
		loginClass.clickLoginButton();
		
		loginClass.clickProfileImage();

		loginClass.clickAdminPanelLink();
		//Thread.sleep(500);
		
		loginClass.moveToAdminPanel();
		//Thread.sleep(500);
		
	}

	@When("user lands on Recognitions page and enable the toggle")
	public void user_lands_on_recognitions_page_and_enable_the_toggle() throws InterruptedException {

		rewardAdd = new PGrewardAdditionClass(driver); 

		rewardAdd.clickRecognitionTile();

		Assert.assertTrue(driver.getTitle().contains("R"
				+ "ecognitions"));

		rewardAdd.clickEnableEditToggle();
		Thread.sleep(500);
	}

	@When("clicks on New Recognition button")
	public void clicks_on_new_recognition_button() throws InterruptedException {

		rewardAdd.clickNewRecognitionButton();

	}

	@When("selects Rewards tile to proceed for addition process")
	public void selects_rewards_tile_to_proceed_for_addition_process() throws InterruptedException {

		rewardAdd.clickRewardsTile();
		Thread.sleep(1000);
		rewardAdd.clickRewardnameField();
		rewardAdd.clickDescriptionField();
		rewardAdd.clickIndividualDropdown();

		rewardAdd.clickEndDatePicker();
		Thread.sleep(1000);
		rewardAdd.clickStartDatePicker();


		rewardAdd.clickBudgetHeadDropdown();
		rewardAdd.clickRewardPointsField();
		rewardAdd.clickFirstNextbutton();
		Thread.sleep(5000);
		rewardAdd.clickLocationDropdown();
		rewardAdd.clickDepartmentDropdown();
		rewardAdd.clickSecondNextbutton();
		rewardAdd.clickThirdNextbutton();
		Thread.sleep(1000);
		rewardAdd.clickWorkflowDropdown();
		rewardAdd.clickPolicyDropdown();
		rewardAdd.clickReviewButton();
		Thread.sleep(1000);
	}

	@Then("reward displayed on grid page after successful addition process")
	public void reward_displayed_on_grid_page_after_successful_addition_process() throws InterruptedException {
			//rewardAdd.clickFinishButton();

		rewardAdd.clickLogoutLink();
		Thread.sleep(1000);
		rewardAdd.clickAdminPanelYesButton();
		Thread.sleep(500);
		rewardAdd.clickPopupAlert();
		
		loginClass.moveToMainApp();
		driver.navigate().refresh();
		loginClass.clickProfileImage();
		loginClass.clickLogoutLink();
		loginClass.clickYesLogoutButton();
		Thread.sleep(1000);
		driver.quit();
		
	
	}



}
