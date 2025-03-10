package stepDefinitionPkg;

import org.openqa.selenium.WebDriver;

import browserSetupPkg.BrowserSetupClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPkg.FrontEndLoginClass;
import pagesPkg.HometoAdminPanelClass;
import pagesPkg.MultipleRewardClass;
import pagesPkg.RecognitionPageClass;



public class ObSDmultiRewardClass {

	WebDriver driver;

	private FrontEndLoginClass frontEnd;

	private HometoAdminPanelClass HomeAdminPanel;

	private RecognitionPageClass recognitions ;

	private MultipleRewardClass multiReward;



	public ObSDmultiRewardClass() {

		driver = new BrowserSetupClass().getDriver();
		frontEnd=  new FrontEndLoginClass(driver);
		HomeAdminPanel = new HometoAdminPanelClass(driver);	
		recognitions = new RecognitionPageClass(driver);
		multiReward= new MultipleRewardClass(driver);
	}



	@Given("User is on frontEnd login page")
	public void user_is_on_frontEnd_login_page() throws InterruptedException{

		driver. get("https://goinfinity.beyond360test.com/Account/Login?ReturnUrl=/Survey/Index");
		Thread.sleep(500);
	}


	@When("user enters correct credentials")
	public void user_enters_correct_credentials() {

		frontEnd.clickLogin();
	}

	@Then("user lands on homepage")
	public void user_lands_on_homepage() throws InterruptedException {
		assert HomeAdminPanel.isMySummaryDisplayed();
		System.out.println("This is " + driver.getTitle() );
	}



	@When("clicks on AdminPanel link")
	public void clicks_on_admin_panel_link() throws InterruptedException {
		HomeAdminPanel.clickAdminPanelLink();
		HomeAdminPanel.moveToAdminPanel();
	}

	@Then("user lands on AdminPanel page")
	public void user_lands_on_admin_panel_page() {
		assert	HomeAdminPanel.isOrganizationStructureDisplayed();
	}


	@When("User clicks on Recognitions tile")
	public void user_clicks_on_recognitions_tile() throws InterruptedException {

		recognitions.clickRecognitionTile();
	}

	@And("clicks on EnableEdit link")
	public void clicks_on_enable_edit_link() throws InterruptedException {

		recognitions.clickEnableEditToggle();
	}

	@Then("recognition page gets enabled to proceed further")
	public void user_should_be_on_the_recognitions_page() throws InterruptedException {
		assert recognitions.isUploadCertificateButtonDisplayed();


		/*
		 * multiReward.clickLogoutLink(); Thread.sleep(500);
		 * multiReward.clickAdminPanelYesButton(); Thread.sleep(1000);
		 * multiReward.clickPopupAlert(); multiReward.moveToFrontEnd();
		 * Thread.sleep(500);
		 * 
		 * HomeAdminPanel.clickFrontEndLogoutLink(); Thread.sleep(200);
		 * 
		 * HomeAdminPanel.clickYesFrontEndLogoutButton(); Thread.sleep(500);
		 * 
		 * driver.close();
		 */

	}


	@When("User Clicks on NewRecognition button to add a new reward")
	public void user_clicks_on_new_recognition_button_to_add_a_new_reward() throws InterruptedException {
		multiReward.clickNewRecognitionButton();

		multiReward.clickRewardsTile();



	}

	@And("Enters {string} and {string} to add different rewards")
	public void enters_and_to_add_different_rewards(String rewardName, String rewardPoints) throws InterruptedException {

		multiReward.clickRewardnameField_parameterized(rewardName);

		multiReward.clickDescriptionField();
		multiReward.clickIndividualDropdown();

		multiReward.clickEndDatePicker();
		Thread.sleep(1000);
		multiReward.clickStartDatePicker();

		multiReward.clickBudgetHeadDropdown();
		multiReward.clickRewardPointsField_paramerized(rewardPoints);
		multiReward.clickFirstNextbutton();
		Thread.sleep(5000);

		multiReward.clickLocationDropdown();
		multiReward.clickDepartmentDropdown();
		multiReward.clickSecondNextbutton();
		multiReward.clickThirdNextbutton();
		Thread.sleep(1000);

		multiReward.clickWorkflowDropdown();
		multiReward.clickPolicyDropdown();
		multiReward.clickReviewButton();
		//Thread.sleep(1000);
	}

	@Then("user navigates to grid page")

	public void user_navigates_on_grid_page() throws InterruptedException {

		multiReward.clickCancelButton();
		Thread.sleep(500);
		multiReward.clickCancelOKButton();
	}

	@When("User clicks on Logout link")
	public void user_clicks_on_logout_link() throws InterruptedException {
		multiReward.clickLogoutLink(); 
		Thread.sleep(500);

	}

	@And("clicks on Yes button")
	public void clicks_on_yes_button() throws InterruptedException {
		multiReward.clickAdminPanelYesButton(); 
		Thread.sleep(1000);
		multiReward.clickPopupAlert();
	}

	@Then("user gets logged out successfully")
	public void user_gets_logged_out_successfully() throws InterruptedException {
		System.out.println("this is LAST STEP");

		multiReward.moveToFrontEnd();
		Thread.sleep(500);

		HomeAdminPanel.clickFrontEndLogoutLink();
		Thread.sleep(200);

		HomeAdminPanel.clickYesFrontEndLogoutButton();
		Thread.sleep(500);

		driver.close();
	}


}


