package testcases.newFeatures;


import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

import java.io.IOException;

public class Q_BuybackHold5901 extends Init {
	static Q_AdminForm adm = new Q_AdminForm();
	static Q_CustomerForm cust = new Q_CustomerForm();
	static Q_ProductForm prod = new Q_ProductForm();
	static Q_HoldsForm hold = new Q_HoldsForm();
	static Q_OrderForm ord = new Q_OrderForm();
	static Q_Buyback bb = new Q_Buyback();
	static Q_CheckoutForm chk = new Q_CheckoutForm();
	static Controls li = new Controls();


	@BeforeClass
	public void tcSetup (){
	}
	
	@BeforeMethod
	public void report() throws Exception {
		Init.setItUp();
	}
	
	@BeforeTest
	public void setTest() throws Exception {
	}
	
	/******************************************************************
	 // * Description: Verify functionality of Jira MB-5901 placing Buyback on hold
	 // * Param: String
	 // * Jira Ticket: JMB-5901
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 1, enabled = true)
	public static void placeBuybackOnHold() throws IOException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp", "qa+2jmb@jmbullion.com", 1);
        bb.commitSearch();
        bb.editOrder();
        bb.buybackHold(tcName);
        bb.listHoldBuyback(tcName);
		bb.verifyTextAssertion("bb.listBb1HoldStatus.xp", "On Hold");
	}
	
	/******************************************************************
	 // * Description: Verify functionality of Jira MB-5901 placing Buyback on hold
	 // * Param: String
	 // * Jira Ticket: JMB-5901
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 2, enabled = true)
	public static void removeBuybackOnHold() throws IOException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		bb.listHoldBuyback(tcName);
		bb.removeBbHold(tcName);
		bb.bbMenuItem("list");
		bb.secondSearchStatus("bb.emailSearch.xp", "qa+2jmb@jmbullion.com", 1);
		bb.commitSearch();
		Controls.captureScreen(tcName + "_removeBuybackHold");
		bb.verifyTextAssertion("bb.listBb1HoldStatus.xp", "");
	}
	
	/******************************************************************
	 // * Description: Verify functionality of Jira MB-5901 placing Provident Metals buyback on hold
	 // * Param: String
	 // * Jira Ticket: JMB-5901
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 3, enabled = true)
	public static void placeProvidenMetalsBuybackOnHold() throws IOException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		bb.bbMenuItem("list");
//		bb.emailSearch("qa2jmb@gmail.com");
		bb.secondSearchStatus("bb.emailSearch.xp", "qa+2jmb@jmbullion.com", 3);
		bb.commitSearch();
		bb.searchSupplier("Provident Metals");
		bb.buybackHold(tcName);
		String buybackNum = Q_Buyback.ticketNumber("bb.formTicketNumber.xp");
		System.out.println("Provident on hold buyback: " + buybackNum);
		bb.listHoldBuyback(tcName);
		bb.verifyTextAssertion("bb.listBb1HoldStatus.xp", "On Hold");

	}
	
	/******************************************************************
	// * Description: Verify functionality of Jira MB-5901 placing JM Bullion buyback on hold
	// * Param: String
	// * Jira Ticket: JMB-5901
	// * Status: Complete
	//*******************************************************************/
	@Test(priority = 4, enabled = true)
	public static void verifyOnHoldBbNotListedInCreateWire() throws IOException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		bb.bbMenuItem("list");
		bb.listHoldBuyback(tcName);
		bb.searchSupplier("Provident Metals");
		String buybackNum = Q_Buyback.ticketNumber("bb.formTicketNumber.xp");
		System.out.println("Provident on hold buyback: " + buybackNum);
		bb.bbMenuItem("wire");
		bb.wireBbOnHold(tcName,"Provident", buybackNum);
	}

	/******************************************************************
	 // * Description: Verify functionality of Jira MB-5901 Provident hold buybacks are not subject for payment
	 // * Param: String
	 // * Jira Ticket: JMB-5901
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 5, enabled = true)
	public static void placeJMBullionBuybackOnHold() throws IOException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		bb.bbMenuItem("list");
		bb.secondSearchStatus("bb.emailSearch.xp", "qa+2jmb@jmbullion.com", 1);
		bb.commitSearch();
		bb.searchSupplier("JM Bullion");
		bb.buybackHold(tcName);
		bb.receiveEntireOrder();
		bb.listHoldBuyback(tcName);
		bb.verifyTextAssertion("bb.listBb1HoldStatus.xp", "On Hold");
	}
	
	/******************************************************************
	 // * Description: Verify functionality of Jira MB-5901 JM Bullion hold buybacks are not subject for payment
	 // * Param: String
	 // * Jira Ticket: JMB-5901
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 6, enabled = true)
	public static void verifyOnHoldJMBullionBbNotListedInCreateWire() throws IOException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		bb.bbMenuItem("list");
		bb.listHoldBuyback(tcName);
		bb.searchSupplier("JM Bullion\n");
		String buybackNum = Q_Buyback.ticketNumber("bb.formTicketNumber.xp");
		System.out.println("Provident on hold buyback: " + buybackNum);
		bb.bbMenuItem("wire");
		bb.wireBbOnHold(tcName, "CUSTOMER External", buybackNum);
	}
	
	/******************************************************************
	 // * Description: Verify functionality of Jira MB-5901 once Provident wire edited and a buyback placed on hold the buyback no longer payable.
	 // * Param: String
	 // * Jira Ticket: JMB-5901
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 7, enabled = true)
	public static void placeProvidentBuybackWireOnHold() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		bb.bbMenuItem("wire");
		bb.validWire(tcName,"Provident");

	}
	
	/******************************************************************
	 // * Description: Verify functionality of Jira MB-5901 once JM Bullion wire edited and a buyback placed on hold the buyback no longer payable.
	 // * Param: String
	 // * Jira Ticket: JMB-5901
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 8, enabled = true)
	public static void placeJMBullionBuybackWireOnHold() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		bb.bbMenuItem("wire");
		bb.validWire(tcName,"CUSTOMER External");
	}
	
	/******************************************************************
	 // * Description: Verify error message if user attempts to save wire with on hold buyback if page not refreshed.
	 // * Param: String
	 // * Jira Ticket: JMB-5901
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 9, enabled = true)
	public static void wireError() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		bb.bbMenuItem("wire");
		bb.wireError(tcName,"CUSTOMER External");
	}

	@AfterTest
	public void endReport(){
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Controls.tearDown();
	}
	@AfterClass
	public void exitClass(){
		System.out.println("After Class");
	}

}