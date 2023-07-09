package testcases.admin;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_Repos extends Init {
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
	 // * Description: Verify Today's Shipping page header listings
	 // * Jira Ticket:
	 // * Author:
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 1) // Verify count listed on button matches the count of listed orders
	public void addRepo() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		adm.adminMenu("receipts");
		adm.repoMenu("add repo");
		adm.addRepo("1 oz Silver Bar (Varied Condition, An", 100);
		adm.repoMenu("list repo");
		adm.repoForceValueDate();
	}

	/******************************************************************
	 // * Description: Verify functionality of Jira JMB-6182 Make ETA Mandatory Field On Receipts
	 // * Param: String
	 // * Jira Ticket: JMB-6182
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 2, enabled = true)
	public void eta_JMB6182(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls li = new Controls();
		li.adminLogin();
		Q_AdminForm adm = new Q_AdminForm();
		adm.adminMenu("receipts");
		adm.formXp("adm.recpSub.listReceipts.xp");
		adm.receiptsEta(11822);
	}
	/******************************************************************
	 // * Description:Verify 3 columns added to the product status page report
	 // * Param: String
	 // * Jira Ticket: JMB-6183
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 3, enabled = true)
	public static void productStatusPage(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls li = new Controls();
		li.adminLogin();
		driver.navigate().to(adminUrl +"/products_status_list.php");
		System.out.println("Carry inventory value " + Q_WebElm.xpRetText(adminProps, "adm.productStatusCarry.xp"));
		System.out.println("Date Added " + Q_WebElm.xpRetText(adminProps, "adm.productStatusDateAdded.xp"));
		System.out.println("Note and Date " + Q_WebElm.xpRetText(adminProps, "adm.productStatusNote.xp"));
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
