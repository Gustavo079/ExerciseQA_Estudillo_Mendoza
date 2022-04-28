package Volaris;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import POM.ClReport;
import POM.ClWeb;

public class ChsFlight extends ClWeb {

	//outbound flight
	By fly = By.xpath("//span[@class='mat-button-wrapper' and text()=' Buscar vuelos ']");
	By tittle = By.xpath("//h1[@class='ng-star-inserted']");
	By vuelos = By.xpath("//div[@class='row no-gutters flightItemDetails']");
	By fil = By.xpath("//select[@id='mat-input-10']");
	By chS = By.xpath("/html/body/mbs-root/div/section/mbs-flight/div/div[1]/section/div[6]/mbs-flight-lists/div[2]/div[1]/div/div[2]/div/div[1]/a/span[2]");
	By basic = By.xpath("/html/body/mbs-root/div/section/mbs-flight/div/div[1]/section/div[6]/mbs-flight-lists/div[2]/div[1]/mbs-flight-fares/div[1]/div/div[1]/mat-card/h3");	
	//return flight
	By expc = By.xpath("//select[@id='mat-input-11']");
	By chR = By.xpath("/html/body/mbs-root/div/section/mbs-flight/div/div[1]/section/div[6]/mbs-flight-lists/div[2]/div[1]/div/div[2]/div/div/a");
	By basic2 = By.xpath("/html/body/mbs-root/div/section/mbs-flight/div/div[1]/section/div[6]/mbs-flight-lists/div[2]/div[1]/mbs-flight-fares/div[1]/div/div[1]/mat-card/h3");
	By confirm = By.xpath("//span[@class='mat-button-wrapper' and text()='Confirmar selección']");
	By total = By.xpath("//div[text()=' $2,379 ']");
	By tua = By.xpath("//div[@class='mat-checkbox-inner-container']");
	
	
		public void travel() {
			WaitForLoad();
			Click(fly);
			WaitForLoad();
			WaitForElement(tittle);
			ClReport.fnLog(Status.PASS, "Choose flight", false);
		}
	
		//method in charge of choosing the outbound flight
		 public void fly1() throws InterruptedException {
			 WaitForLoad();
			 selectState();
			 Click(chS);
			 Click(basic);
			 WaitForLoad();
			 Thread.sleep(2000);
			 ClReport.fnLog(Status.PASS, "outbound flight", false);
		 }
		 
		 public void fly2() throws InterruptedException {
			 WaitForElement(chR);
			 Click(chR);
			 WaitForElement(basic2);
			 Click(basic2);
			 Click(confirm);
			 scroll(tua);
			 Click(tua);
			 Thread.sleep(1000);
			 ClReport.fnLog(Status.PASS, "Return flight", true);
		 }
		 //Method to get total price of flight
		 public void total() throws InterruptedException {
			 WaitForElement(total);
			 convert(total);
			 Thread.sleep(2000);
			 ClReport.fnLog(Status.PASS, "total price of flight", true);
		 }
		
}
