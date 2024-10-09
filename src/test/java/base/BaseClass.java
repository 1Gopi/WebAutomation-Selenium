package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	ConfigFileReaderClass config = new ConfigFileReaderClass();
	String driverpath = config.getBrowseDriver();
	String Browser = config.getBrowser();
	String Url = config.getUrl();
	String ExcelPath = config.getExcelPath();
	
	
	public WebDriver setUpWebDriver(String browser) {
		switch(browser) {
		case "Chrome" :// WebDriverManager.chromedriver().setup();
						System.setProperty("webdriver.chrome.driver", driverpath);
						driver = new ChromeDriver();
						
						return driver;
						
		case "Edge" : WebDriverManager.edgedriver().setup();
						driver = new EdgeDriver();
						return driver;
		case "Firefox" : WebDriverManager.firefoxdriver().setup();
						driver = new FirefoxDriver();
						return driver;
		default :		//WebDriverManager.chromedriver().setup();	
						System.setProperty("webdriver.chrome.driver", driverpath);
						driver = new ChromeDriver();
						return driver;
		}
	}
	
	@BeforeSuite
	public void setUp() {
		System.out.println("Browser :" +Browser+ " /nDriver path: "+driverpath +"/nUrl : "+Url);
		System.out.println(Url);
		System.out.println(Browser);
		System.out.println(driverpath);
		//driver = setUpWebDriver(Browser);
		/*if(driver == null) {
			System.setProperty("webdriver.chrome.driver", driverpath);
			driver = new ChromeDriver();
		} */
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
	}
	
	
	
	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.quit();
		}
	}

	
	
	
}
