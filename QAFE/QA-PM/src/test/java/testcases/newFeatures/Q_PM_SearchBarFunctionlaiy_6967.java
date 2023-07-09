package testcases.newFeatures;

import java.io.IOException;

import org.testng.annotations.*;

import pageObjects.*;
//import pageObjects.Q_JMB_TicketsObjects;
//import utils.Q_JMB_Controls;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

public class Q_PM_SearchBarFunctionlaiy_6967 extends Q_PM_Init {
	static Q_PM_NewFeatures nf = new Q_PM_NewFeatures();
	@BeforeClass
	public void tcSetup() {
	}
	
	@BeforeMethod
	public void report() throws Exception {
		Q_PM_Init.setItUp();
	}	

	@BeforeTest
	public void setTest() throws Exception {
	}

	/*******************************************************************
	 * Description: Verify user can able to search any item in the search box
	 * Author: Vandana
	 * Ticket: JMB-6967
	 * Status: Complete
	 *******************************************************************/
	@Test(priority = 1, enabled = true)
	public void searchBarFunctionality() {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Q_PM_Controls.testStarted(tcName);
		Q_PM_TicketsObjects tic = new Q_PM_TicketsObjects();
		nf.topSearchBar("Gold Eagles");

	}

	@AfterTest
	public void endReport() {
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Q_PM_CartSteps.deleteItems();
		Q_PM_Controls.tearDown();
	}

	@AfterClass
	public void exitClass() {
		System.out.println("After Class");
	}

}
