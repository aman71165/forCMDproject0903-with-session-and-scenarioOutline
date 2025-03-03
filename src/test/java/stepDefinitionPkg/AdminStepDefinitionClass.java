package stepDefinitionPkg;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pagesPkg.AdminPanelPageElementsClass;

public class AdminStepDefinitionClass {

	WebDriver driver;

	AdminPanelPageElementsClass eleClass;


	@Given("user is on the login page")
	public void user_is_on_the_login_page() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options =new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		driver= new ChromeDriver(options);

		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://goinfinity.beyond360test.com/Account/Login?ReturnUrl=/Survey/Index");

		Thread.sleep(500);


	}

	@When("user enters the username {string} and password {string}")
	public void user_enters_the_username_and_password(String uName, String pwd) {

		eleClass = new AdminPanelPageElementsClass(driver);

		eleClass.enterUsername(uName);
		eleClass.enterPassword(pwd);

	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		eleClass.clickLoginButton();

	}

	@Then("user clicks on AdminPanel link")
	public void user_clicks_on_admin_panel_link() throws InterruptedException {


		Thread.sleep(1500);
		eleClass.clickProfileImage();

		Thread.sleep(500);
		eleClass.clickAdminPanelLink();


		Thread.sleep(500);

		String originalWindow= driver.getWindowHandle();

		for(String windowHandle : driver.getWindowHandles()) {
			if(!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(originalWindow);
				break;
			}
		}


		driver.navigate().refresh();
		Thread.sleep(1500);

		eleClass.clickProfileImage();
		Thread.sleep(500);

		eleClass.clickLogoutLink();
		Thread.sleep(1000);

		eleClass.clickYesLogoutButton();
		Thread.sleep(500);
		String pageTitle1= driver.getTitle();
		System.out.println("user is now on the " + pageTitle1 + " after successful logout");
		driver.quit();


	}                                     



}
