package stepDefinitionPkg;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import browserSetupPkg.BrowserSetupClass;
import configlPkg.ConfigReaderClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPkg.AdminPanelPageElementsClass;
import pagesPkg.PGrewardAdditionClass;
import utilPkg.HooksClass;

public class SDMultiRewardClass {
	/*
	WebDriver driver;

	AdminPanelPageElementsClass loginClass;

	BrowserSetupClass browser = new BrowserSetupClass();

	ConfigReaderClass configRead= new ConfigReaderClass();

	PGrewardAdditionClass rewardAdd;
	
	

	@Given("User is on frontEnd login page")
	public void user_is_on_front_end_login_page() throws InterruptedException {

		driver = browser.browserSetup();

		loginClass= new AdminPanelPageElementsClass(driver);

		String loginUsername= configRead.getConfigProperty("username_fromProperties");
		String loginPassword= configRead.getConfigProperty("password_fromProperties");

		loginClass.enterUsername(loginUsername);
		loginClass.enterPassword(loginPassword);

		loginClass.clickLoginButton();
		loginClass.clickProfileImage();
	



		loginClass.clickAdminPanelLink();
		//Thread.sleep(500);

		loginClass.moveToAdminPanel();
		//Thread.sleep(500);

	}

	@When("clicks on Recognitions tile")
	public void user_clicks_on_recognitions_tile() throws InterruptedException {
		rewardAdd = new PGrewardAdditionClass(driver); 

		rewardAdd.clickRecognitionTile();

	}

	@And("clicks on EnableEdit link")
	public void clicks_on_enable_edit_link() throws InterruptedException {
		rewardAdd.clickEnableEditToggle();
		Thread.sleep(500);
	}


	@Then("User should be on the Recognitions page")
	public void user_should_be_on_the_recognitions_page() {
		//rewardAdd = loginClass.clickYesLogoutButton();
		rewardAdd.waitForUploadCertificateButton();
		Assert.assertTrue(driver.getTitle().contains("Recognitions"));
	}



	@Given("User is Recognitions page")
	public void user_is_recognitions_page() throws InterruptedException {
		
		loginClass= new AdminPanelPageElementsClass(driver);
		rewardAdd = new PGrewardAdditionClass(driver); 
	
		rewardAdd.waitForUploadCertificateButton();
		//Thread.sleep(100);
	
	}

	@When("User Clicks on NewRecognition button to add a new reward")
	public void user_clicks_on_new_recognition_button_to_add_a_new_reward() {
		rewardAdd.clickNewRecognitionButton();

		rewardAdd.clickRewardsTile();
	}

	@And("Enters {string} and {string} to add different rewards")
	public void enters_and_to_add_different_rewards(String rewardName, String rewardPoints) throws InterruptedException {

		rewardAdd.clickRewardnameField_parameterized(rewardName);

		rewardAdd.clickDescriptionField();
		rewardAdd.clickIndividualDropdown();

		rewardAdd.clickEndDatePicker();
		Thread.sleep(1000);
		rewardAdd.clickStartDatePicker();

		rewardAdd.clickBudgetHeadDropdown();
		rewardAdd.clickRewardPointsField_paramerized(rewardPoints);
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

	@Then("user navigates on grid page")
	public void user_navigates_on_grid_page() throws InterruptedException {

		rewardAdd.clickCancelButton();
		Thread.sleep(100);
		rewardAdd.clickCancelOKButton();

	}

*/

}
