package TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.aventstack.extentreports.Status;

import POM.ClReport;
import POM.ClWeb;
import Volaris.ChsFlight;
import Volaris.SlcFly;
public class TestCase_Exerc4 extends ClWeb{
	
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
	public void firstTest(){
		try {
			ClReport.objTest = ClReport.objExtent.createTest(" First Test");
			URL ="https://www.volaris.com/";
			browserUrl(URL);
			WaitForLoad();
			Thread.sleep(2000);
			ClReport.fnLog(Status.PASS, "Volaris Page.", true);	
			SlcFly slfly = new SlcFly();
			slfly.SelFly();
			slfly.calendar();
			ChsFlight chfly = new ChsFlight();
			chfly.travel();
			chfly.fly1();
			chfly.fly2();
			chfly.total();
			}
		catch(Exception e){
			System.out.print("Test Fail");
			ClReport.fnLog(Status.FAIL, "The: " + TC_Name.getMethodName() + " fail. \n Exception: " + e.getMessage() , false);	
			}
	}
	
	@After
	public void tearDown(){
		CloseBrowser();
		ClReport.fnCloseReport();
	} 


}
