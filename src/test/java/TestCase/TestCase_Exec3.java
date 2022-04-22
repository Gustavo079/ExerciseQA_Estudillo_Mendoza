package TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.aventstack.extentreports.Status;

import POM.ClReport;
import POM.ClWeb;
import techpanda.LoginPage;
import techpanda.MagentaPage;
public class TestCase_Exec3 extends ClWeb{
	
	public String URL;
	
	// Inicialite the funcion report
	@BeforeClass
	public static void beforeClass() 
	{
		ClReport.fnSetupReport();
	}
	
	@Before
	public void amazon(){
		setup();
	} 
	
	
	@Test
	public void firstTest(){
		try {
			ClReport.objTest = ClReport.objExtent.createTest("First Test");
			URL ="http://live.guru99.com/index.php/tv.html";
			browserUrl(URL);
			WaitForLoad();
			ClReport.fnLog(Status.PASS, "Magento Page.", true);	
			MagentaPage MaPage = new MagentaPage();
			MaPage.addLGCar();
			ClReport.fnLog(Status.PASS,"Add LG-LCD TV to Car", true);
			}
		catch(Exception e){
				System.out.print("test fail");
			}
	}
	
	@Test
	public void secondTest(){
		try {
			ClReport.objTest = ClReport.objExtent.createTest("Second Test");
			URL ="http://live.guru99.com/index.php/tv.html";
			browserUrl(URL);
			WaitForLoad();
			ClReport.fnLog(Status.PASS, "Magento Page.", true);	
			MagentaPage MaPage = new MagentaPage();
			MaPage.samsung();
			ClReport.fnLog(Status.PASS,"Click on Samsung-TV", false);
			MaPage.addSAMCar();
			ClReport.fnLog(Status.PASS,"select pay method", false);
			MaPage.payMtd();
			MaPage.cont();
			MaPage.shMethod();
			MaPage.order();
			ClReport.fnLog(Status.PASS,"The order was succes", true);
			}
		catch(Exception e){
				System.out.print("Second Test Fail");
			}
	}
	
	@Test
	public void ThirdTest(){
		try {
			ClReport.objTest = ClReport.objExtent.createTest("Third Test");
			URL ="http://live.guru99.com/index.php/tv.html";
			browserUrl(URL);
			WaitForLoad();
			ClReport.fnLog(Status.PASS, "Magento Page.", true);	
			LoginPage logPage = new LoginPage();
			logPage.newAccount();
			logPage.info();
			logPage.reg();
			ClReport.fnLog(Status.PASS, "Magento Page.", true);	
			}
		catch(Exception e){
				System.out.print("third test fail");
			}
	}
	
	

	@After
	public void tearDown(){
		CloseBrowser();
		ClReport.fnCloseReport();
	}


}
