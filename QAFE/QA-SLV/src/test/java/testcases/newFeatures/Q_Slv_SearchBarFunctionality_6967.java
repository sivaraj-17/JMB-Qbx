package testcases.newFeatures;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

public class Q_Slv_SearchBarFunctionality_6967 extends Q_Slv_Init {
	Q_Slv_NewFeatures nf= new Q_Slv_NewFeatures();
	@BeforeClass
	public void tcSetup() {

	}

	@BeforeMethod
	public void report() throws Exception {
		Q_Slv_Init.setItUp();
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
		Q_Slv_Controls.testStarted(tcName);
		nf.topSearchBar("Gold Eagles");
		nf.innerSearchBar("Silver coins");
	}		

	@AfterMethod
	public void tearDown() throws Exception {
		Q_Slv_Controls.tearDown();
	}

	@AfterClass
	public void exitClass() {
	}
}
