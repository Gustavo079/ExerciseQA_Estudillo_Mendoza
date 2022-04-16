package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import POM.AmzPage;
public class LoginPage extends AmzPage{
	
		//locator
		By identify = By.xpath("//a[@id='nav-link-accountList']");
		By Email = By.xpath("//input[@id='ap_email']");
		By next = By.xpath("//input[@id='continue']");
		By pass = By.xpath("//input[@id='ap_password']");
		By next2 = By.xpath("//input[@id='signInSubmit']");
		
		By prom = By.xpath("//a[@href='/deals?ref_=nav_cs_gb']");
		By ofr = By.xpath("/html/body/div[1]/div[18]/div/div/div/div[2]/div[2]/span[4]/span/div[4]/a/span");
		By product = By.xpath("//div[@class='a-row a-spacing-small']");
		By tittle = By.xpath("//div[@class='DealContent-module__truncate_sWbxETx42ZPStTc9jwySW']");
		
		String p = "";
		
		WebElement Element;
		/**
		 * Methods
		 * 1. Function to login the user
		 */
		
		public void identifyClick() {
			Click(identify);
			userLog("foxafi5773@hhmel.com",Email);
			Click(next);
			userLog("987456Angelg",pass);
			Click(next2);
			WaitForLoad();
		}
		/**
		 * click on promotions and Lightning Deals
		 */
		public void Prom() {
			Click(prom);
			WaitForLoad();
			scroll();
			Click(ofr);
			WaitForLoad();
		}
		
		/**
		 * verify the Lightning Deals and obteins the products
		 */
		public void elmList() {
			//WaitForLoad();
			scrollOF();
			WaitForElement(product);
			WaitForLoad();
			getList(tittle);
		}
		
}
