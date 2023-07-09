package testcases.newFeatures;

import org.testng.Assert;

import org.testng.annotations.*;

import pageObjects.Q_JMB_CartPageObjects;
import pageObjects.Q_JMB_NavigationObjects;
import pageObjects.Q_JMB_NewFeatures;
import pageObjects.Q_JMB_TicketsObjects;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

public class Q_JMB_SearchBarFunctionality_6967 extends Q_JMB_Init {
	Q_JMB_NewFeatures nf = new Q_JMB_NewFeatures();
	@BeforeMethod
	public void report() throws Exception {
		Q_JMB_Init.setItUp();
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
		Q_JMB_Controls.testStarted(tcName);
		Q_JMB_TicketsObjects tic = new Q_JMB_TicketsObjects();
		nf.topSearchBar("proof Gold Eagles");
		nf.innerSearchBar("silver Coins");
	}	

	@AfterMethod

	public void tearDown() throws Exception {
		Q_JMB_CartPageObjects.removeItems();

		Q_JMB_Controls.tearDown();
	}
}
