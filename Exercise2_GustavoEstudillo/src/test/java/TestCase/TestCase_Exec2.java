package TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.aventstack.extentreports.Status;

import POM.AmzPage;
import POM.ClReport;
import Login.LoginPage;
public class TestCase_Exec2 extends AmzPage{
	
	
	@Rule public TestName TC_Name = new TestName();
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
	public void AmzTest(){
		try {
			ClReport.objTest = ClReport.objExtent.createTest("First Test");
			URL ="https://www.amazon.com.mx/";
			browserUrl(URL);
			WaitForLoad();
			ClReport.fnLog(Status.PASS, "Amazon Products.", true);	
			LoginPage logPage = new LoginPage();
			logPage.identifyClick();
			logPage.Prom();	
			ClReport.fnLog(Status.PASS, "Amazon Promotions", false);
			logPage.elmList();
			ClReport.fnLog(Status.PASS, "Lightning Deals products.", true);
			}
		catch(Exception e){
				System.out.print("test fail");
			}
	}
	
	

	@After
	public void tearDown(){
		CloseBrowser();
		ClReport.fnCloseReport();
	}


}
