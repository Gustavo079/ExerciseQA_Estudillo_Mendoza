package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class ClWeb extends Browser{
	
	public static WebDriverWait objExplicitWait;
	WebElement Element;
	//total
	String total = ("//div[@class='content']");
	
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
		public void scroll(By locator) {
			WebElement nombre = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", nombre);
		}
			
		
		 public void WaitForElement(By pstrLocator) 
			    {
			    	objExplicitWait = new WebDriverWait(Browser.driver, 30);
			    	objExplicitWait.until(ExpectedConditions.presenceOfElementLocated(pstrLocator));
			    }
		 
		//select the state to my delivery
		 public void selectState() {
			 Select dropState = new Select(Browser.driver.findElement(By.id("mat-input-10")));
			 dropState.selectByValue("PriceLowToHigh");
		 }
		 
		 
		 //method in charge of converting the value to integer and eliminating characters
		 public void convert(By locator) {
			 String prs = driver.findElement(locator).getText();
			 char[] prs2 = prs.toCharArray();
			 String n = "";
			 for(int i = 0; i < prs2.length; i++) {
				 if(Character.isDigit(prs2[i])){
					 n+=prs2[i];
				 }
			 }
			 int x = Integer.parseInt(n);
			 if(x <= 1500) {
				 ClReport.fnLog(Status.PASS, "price ", false);
			 }
			 else {
				 ClReport.fnLog(Status.FAIL, "price ", false);
			 }
			 System.out.print(n);
		 }
		 
}
