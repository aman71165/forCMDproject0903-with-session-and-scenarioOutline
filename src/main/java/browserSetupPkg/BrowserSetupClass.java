package browserSetupPkg;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;



public class BrowserSetupClass {
	private  WebDriver driver;

	public BrowserSetupClass(){
	}

	public WebDriver browserSetup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver= new ChromeDriver(options);

		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://goinfinity.beyond360test.com/Account/Login?ReturnUrl=/Survey/Index");
		
		Thread.sleep(500);
		return driver;
	}}

	
	