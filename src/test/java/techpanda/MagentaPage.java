package techpanda;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import POM.ClReport;
import POM.ClWeb;
public class MagentaPage extends ClWeb {

	//locators
	By LG = By.xpath("//button[@class='button btn-cart'][1]");
	By IMG = By.xpath("//img[@id='product-collection-image-5']");
	By SAM = By.xpath("//button[@class='button btn-cart']");
	By Pay = By.xpath("//button[@class='button btn-proceed-checkout btn-checkout'][1]");
	By guest = By.xpath("//button[@id='onepage-guest-register-button']");
	By name = By.xpath("//input[@id='billing:firstname']");
	By last = By.xpath("//input[@id='billing:lastname']");
	By email = By.xpath("//input[@id='billing:email']");
	By addres = By.xpath("//input[@id='billing:street1']");
	By city = By.xpath("//input[@id='billing:city']");
	By zip = By.xpath("//input[@id='billing:postcode']");
	By phone = By.xpath("//input[@id='billing:telephone']");
	By con = By.xpath("//button[@title='Continue'][1]");
	By next = By.xpath("//button[@class='button' and @onclick='shippingMethod.save()']");
	By check = By.xpath("//input[@id='p_method_checkmo']");
	By next2 = By.xpath("//button[@class='button' and @onclick='payment.save()']");
	By order = By.xpath("//button[@class='button btn-checkout']");

	/**
	 * Methods
	 * 1- add to car
	 */
	public void addLGCar() {
		Click(LG);
	}
	
	public void samsung() {
		Click(IMG);
		WaitForLoad();
	}
	
	public void addSAMCar() {
		Click(SAM);
		WaitForLoad();
		ClReport.fnLog(Status.PASS,"Add Samsung-TV to Car", true);
		Click(Pay);
		Click(guest);
		ClReport.fnLog(Status.PASS,"Guest method", false);
	}
	
	public void payMtd() {
		userLog("Gustavo ",name);
		userLog("Mendoza",last);
		userLog("Angus90@gmail.com",email);
		userLog("Porcelana #580",addres);
		userLog("Manzanillo",city);
		selectState();
		userLog("28890",zip);
		userLog("972 875 4585",phone);
		ClReport.fnLog(Status.PASS,"Fill fields", true);
	}
	
	public void cont() throws InterruptedException {
	Click(con);	
	WaitForLoad();
	Thread.sleep(2000);
	scroll();
	ClReport.fnLog(Status.PASS,"Shipping Method", false);
	}
	
	public void shMethod() throws InterruptedException {
		Click(next);
		Click(check);
		Click(next2);
		WaitForLoad();
		Thread.sleep(2000);
		ClReport.fnLog(Status.PASS,"Pay the TV", true);
	}
	
	public void order() throws InterruptedException {
		Click(order);
		WaitForLoad();
		Thread.sleep(1000);
	}
	
}
