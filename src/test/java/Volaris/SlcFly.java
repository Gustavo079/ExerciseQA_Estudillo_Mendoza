package Volaris;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import POM.ClReport;
import POM.ClWeb;

public class SlcFly extends ClWeb {
	
	//locators-flight
	By origen = By.xpath("//div[@class='col btnSearch SearchOrigin']");
	By destino = By.xpath("//div[@class='col btnSearch SearchDestination']");
	By gdl = By.xpath("//div[text()='Guadalajara']");
	By cncn = By.xpath("//div[text()='Cancún']");	
	By cityOr = By.xpath("//ul[@class='ng-star-inserted']");
	By cityDs = By.xpath("//ul[@class='ng-star-inserted']");
	//Calendar
	By sal = By.xpath("//div[@class='mat-form-field-prefix ng-tns-c7-41 ng-star-inserted']");
	By cal = By.xpath("//div[@class='md-drppicker drops-undefined-undefined ltr shown inline double']");
	//mounth
	By mes = By.xpath("//div[@class='dropdowns ng-star-inserted' and text()=' abril ' ]");
	By oct = By.xpath("//option[@value='9']");
	By m29 = By.xpath("//td[@class='weekend datecell-20221029 customfare available']");
	By m4 = By.xpath("//td[@class='datecell-20221104 returnVisible returnCustomfare available']");
	By hecho = By.xpath("//button[@class='btn-calendar d-none d-md-block mat-flat-button mat-button-base mat-secondary']");
		
	
	public void SelFly() throws InterruptedException {
		Click(origen);
		WaitForElement(cityOr);
		scroll(gdl);
		Click(gdl);
		WaitForLoad();
		WaitForElement(cityDs);
		Thread.sleep(1000);
		scroll(cncn);
		Click(cncn);
		ClReport.fnLog(Status.PASS, "Select Fly.", false);	
	}
	//method in charge of choosing the departure and return dates
	public void calendar() throws InterruptedException {
		WaitForElement(oct);
		Click(mes);
		Click(oct);
		WaitForElement(m29);
		Thread.sleep(2000);
		Click(m29);
		WaitForElement(m4);
		Click(m4);
		WaitForElement(hecho);
		Click(hecho);
		ClReport.fnLog(Status.PASS, "Choosing Fly", true);	
	}	
}
