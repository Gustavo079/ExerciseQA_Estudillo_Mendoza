package TestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.aventstack.extentreports.Status;
import POM.AtLoginPage;
import selenium.ClsBrowser;
import selenium.ClsReport;

public class TestCase_Exec_1 extends ClsBrowser
{
	@Rule public TestName TC_Name = new TestName();
	public String URL;
	
	@BeforeClass
	public static void beforeClass() 
	{
		ClsReport.fnSetupReport();
	}
	
	@Before
	public void setup() 
	{
		ClsBrowser.BrowserName = "Chrome";
		OpenBrowser();
	} 
	
	
	@Test
	public void FirstTC()
	{
		try 
		{
			ClsReport.objTest = ClsReport.objExtent.createTest("First Test");
			URL = "https://positionsapp-uat.azurewebsites.net/#";
			NavigateToUrl(URL);
			WaitForLoad();
			ClsReport.fnLog(Status.PASS, "First Log Comment.", false);
			AtLoginPage objLogin = new AtLoginPage();
			objLogin.enterCredential();
			objLogin.startSession();
			objLogin.keepSessionDialog();
			objLogin.verifyActiveSession();
			ClsReport.fnLog(Status.PASS, "Second Log Comment.", true);
		}
		catch(Exception e) 
		{
			ClsReport.fnLog(Status.FAIL, "The: " + TC_Name.getMethodName() + " was not executed successfully. \n Exception: " + e.getMessage() , false);
		}
	}
		
		
	@Test
	public void SecondTC()
	{
		try 
		{		//modifique la url, ya que no podia acceder al sitio
			ClsReport.objTest = ClsReport.objExtent.createTest("Second Test");
			URL = "https://positionsapp-uat.azurewebsites.net/#";  
			NavigateToUrl(URL);
			WaitForLoad();
			ClsReport.fnLog(Status.PASS, "First Log Comment.", false);
			AtLoginPage objLogin = new AtLoginPage();
			objLogin.enterCredential();
			objLogin.startSession();
			objLogin.keepSessionDialog();
			objLogin.verifyActiveSession();
			ClsReport.fnLog(Status.PASS, "Second Log Comment.", true);
		}
		catch (Exception e) 
		{
			ClsReport.fnLog(Status.FAIL, "The: " + TC_Name.getMethodName() + " was not executed successfully. \n Exception: " + e.getMessage() , false);
		}
	}
	
	@Test
	public void NewTest()
	{
		try 
		{ 				//corregi el nombre del test 
				//modifique la url, ya que no podia acceder al sitio
			ClsReport.objTest = ClsReport.objExtent.createTest("New Test");
			URL = "https://positionsapp-uat.azurewebsites.net/#";
			NavigateToUrl(URL);
			WaitForLoad();
			ClsReport.fnLog(Status.PASS, "First Log Comment.", false);
			AtLoginPage objLogin = new AtLoginPage();
			objLogin.enterCredential();
			objLogin.startSession();
			objLogin.keepSessionDialog();
			objLogin.verifyActiveSession();
			ClsReport.fnLog(Status.PASS, "Second Log Comment.", true);
		}
		catch (Exception e) 
		{
			ClsReport.fnLog(Status.FAIL, "The: " + TC_Name.getMethodName() + " was not executed successfully. \n Exception: " + e.getMessage() , false);
		}
	}
	
	
	
	

	@After
	public void tearDown() 
	{
		CloseBrowser();
		ClsReport.fnCloseReport();
	}

}