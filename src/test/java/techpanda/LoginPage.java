package techpanda;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import POM.ClReport;
import POM.ClWeb;

public class LoginPage extends ClWeb{
	
	//Locators
	By account = By.xpath("//a[@class='skip-link skip-account']");
	By newReg = By.xpath("//a[@title='Register']");
	By first = By.xpath("//input[@id='firstname']");
	By last = By.xpath("//input[@id='lastname']");
	By email = By.xpath("//input[@id='email_address']");
	By pass = By.xpath("//input[@id='password']");
	By confPass = By.xpath("//input[@id='confirmation']");
	By register = By.xpath("//button[@title='Register']");
	
	
	public void newAccount() {
		Click(account);
		Click(newReg);
	}
	
	//This methods are for the Third Test
	//Fill fields to create a new account
	public void info() {
		userLog("Angel",first);
		userLog("Estudillo",last);
		userLog("gustese90@gmail.com",email);
		userLog("1245T.",pass);
		userLog("1245T.",confPass);
		ClReport.fnLog(Status.PASS,"Fill fields", false);
	}
	
	public void reg() {
		Click(register);
	}
		
}
