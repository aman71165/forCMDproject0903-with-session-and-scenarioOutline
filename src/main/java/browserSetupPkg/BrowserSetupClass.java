package browserSetupPkg;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilPkg.ConfigReaderClass;


public class BrowserSetupClass {
	private  WebDriver driver;

	ConfigReaderClass configRead= new ConfigReaderClass();
	
	public BrowserSetupClass(){
	}

	public WebDriver browserSetup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//options.addArguments("--headless");  
		//options.addArguments("--disable-gpu"); 
		
		driver= new ChromeDriver(options);

		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url= configRead.getConfigProperty("urlAddress_fromProperties");
		driver.get(url);
		
		Thread.sleep(500);
		return driver;
	}}

	
	