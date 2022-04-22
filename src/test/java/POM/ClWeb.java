package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class ClWeb extends Browser{
	
	By state = By.xpath("//input[@id='billing:region_id']");
	
	public static WebDriverWait objExplicitWait;
	WebElement Element;
	
	//Setup the browser
	public void setup() {
		Browser.BrowserName = "Chrome";
		SelectBrowser();
	}
	
	//this function help us to wait for the page load
	 public void WaitForLoad() {
	        ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };
	        WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	        wait.until(pageLoadCondition);
	    }
	 
	 //do click in the locator
	 public void Click(By Locator) 
		{
			driver.findElement(Locator).click();
		}
	 
	 
	 public void userLog(String inputText, By locator) {
			driver.findElement(locator).sendKeys(inputText);
		}
	 
	 
	 	//Scroll down the page
		public void scroll() {
			((JavascriptExecutor) driver).executeScript("scroll(0,200)");
			
		}		
		
		 public void WaitForElement(By pstrLocator) 
			    {
			    	objExplicitWait = new WebDriverWait(Browser.driver, 30);
			    	objExplicitWait.until(ExpectedConditions.presenceOfElementLocated(pstrLocator));
			    }
		 
		 //select the state to my delivery
		 public void selectState() {
			 Select dropState = new Select(Browser.driver.findElement(By.id("billing:region_id")));
			 dropState.selectByValue("12");
		 }
}
