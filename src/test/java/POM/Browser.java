package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
	
	//Elements for browser
	public static String BrowserName;
	protected static WebDriver driver;
	 public static WebDriverWait wait;
	 
	 public Browser() {
		BrowserName = "Chrome";
	}
 
    
    public WebDriver SelectBrowser()
    {
        switch (BrowserName.toUpperCase()) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/WebDrivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			System.setProperty("webdriver.geckodriver.driver", "./src/test/resources/WebDrivers/gecko.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("The browser is "+ BrowserName +" not supported.");
			break;
		}
        
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
        return driver;
    }
	
	//Find the browser that we are using
		public void browserUrl(String url) {
			driver.get(url);
		}
		
		//close browser
		public void CloseBrowser() {
			driver.close();
			driver.quit();
		}
}
