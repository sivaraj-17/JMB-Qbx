package testcases.newFeatures;


import org.junit.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

import java.io.IOException;

public class Q_FFCInformation_JMB6424_JM extends Init {
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
	 // * Description: Verify functionality of Jira JMB-6424 new buyback no bank information FFC section hidden
	 // * Param: String
	 // * Jira Ticket: JMB-6424
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 1, enabled = true)
	public static void newCustomerFFCNotVisible(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls li = new Controls();
		Q_AdminForm adm = new Q_AdminForm();
		li.adminLogin();
		Q_Buyback bb = new Q_Buyback();
		bb.bbMenuItem("new");
		bb.addCustomer(2);
//		bb.selectBank();
//		bb.addBankInfo(2,2, "011401533");
		bb.selectPayment("ACH");
		bb.skipCreditCard();
		Assert.assertFalse(Q_WebElm.xpDisplayed(adminProps, "bb.ffcSection.xp").equals(true));
		bb.addBbProduct(2,"10","1 oz Valcambi Gold Bar (New w/ Assa");
		bb.reportable();
		bb.productValidation();

		Assert.assertFalse(Q_WebElm.xpDisplayed(adminProps, "bb.ffcSection.xp").equals(true));
	}
	/******************************************************************
	 // * Description: Verify functionality of Jira JMB-6424 list buyback no bank information FFC section hidden
	 // * Param: String
	 // * Jira Ticket: JMB-6424
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 2, enabled = true)
	public static void listBbNoFfcSection() throws IOException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls li = new Controls();
		Q_AdminForm adm = new Q_AdminForm();
		li.adminLogin();
		Q_Buyback bb = new Q_Buyback();
		bb.bbMenuItem("list");
		bb.emailSearch("qa+11jmb@jmbullion.com");
		bb.commitSearch();
		bb.editOrder(1);
		bb.selectBank(2);
		Assert.assertFalse(Q_WebElm.xpDisplayed(adminProps, "bb.ffcSection.xp").equals(true));

	}
	/******************************************************************
	 // * Description: Verify functionality of Jira JMB-6424 when user saves buyback the FFC info is saved
	 // * Param: String
	 // * Jira Ticket: JMB-6424
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 3, enabled = true)
	public static void noBankSelected() throws IOException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls li = new Controls();
		Q_AdminForm adm = new Q_AdminForm();
		li.adminLogin();
		Q_Buyback bb = new Q_Buyback();
		bb.bbMenuItem("list");
		bb.search("email", "bb.searchEmail.xp","qa+10jmb@jmbullion.com");
		bb.editOrder();
		bb.selectBank(2);
		Assert.assertFalse(Q_WebElm.xpDisplayed(adminProps, "bb.ffcSection.xp").equals(true));
	}
	/******************************************************************
	 // * Description: Verify functionality of Jira JMB-6424 new customer buyback with FFC
	 // * Param: String
	 // * Jira Ticket: JMB-6424
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 4, enabled = true)
	public static void newCustomerFFC(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls li = new Controls();
		Q_AdminForm adm = new Q_AdminForm();
		li.adminLogin();
		Q_Buyback bb = new Q_Buyback();
		bb.bbMenuItem("new");
		bb.addCustomer(2);
		bb.selectBank(1);
		bb.addBankInfo(1,2, "011401533");
		bb.addBankButton();
		bb.selectPayment("ACH");
		bb.selectDefaultCard(1, 6);
		bb.addBbProduct(2,"10","1 oz Valcambi Gold Bar (New w/ Assa");
		bb.skipCreditCard();
		bb.reportable();

		bb.productValidation();
//		bb.saveVerifyNotes("Buyback created");
		Q_WebElm.myWait(5000);
		bb.selectBank(1);
		bb.Ffc("987987123", "Zakit", "CareOf");

	}
	/******************************************************************
	 // * Description: Verify functionality of Jira JMB-6424 existing customer add FFC to buyback
	 // * Param: String
	 // * Jira Ticket: JMB-6424
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 5, enabled = true)
	public static void addFFCToExistingBB() throws IOException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls li = new Controls();
		Q_AdminForm adm = new Q_AdminForm();
		li.adminLogin();
		Q_Buyback bb = new Q_Buyback();
		bb.bbMenuItem("list");
		bb.search("email", "bb.searchEmail.xp","qa+10jmb@jmbullion.com");
		bb.editOrder();
		bb.selectBank(2);
		bb.selectPayment("ACH");
		bb.skipCreditCard();
		bb.saveVerifyNotes("Buyback created");
		Q_WebElm.myWait(2000);
		Controls.captureScreen(tcName);
		bb.selectBank(1);
		bb.Ffc("987987123", "Zakit", "CareOf");
		Controls.captureScreen(tcName);
		bb.clearFfc();
	}
	/******************************************************************
	 // * Description: Verify functionality of Jira JMB-6424 existing customer add multiple bank accounts and multiple FFC to buyback
	 // * Param: String
	 // * Jira Ticket: JMB-6424
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 6, enabled = true)
	public static void multipleFFCAccounts() throws IOException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls li = new Controls();
		Q_AdminForm adm = new Q_AdminForm();
		li.adminLogin();
		Q_Buyback bb = new Q_Buyback();
		bb.bbMenuItem("list");
		bb.search("email", "bb.searchEmail.xp","qa+10jmb@jmbullion.com");
		bb.editOrder();
		bb.verifyFFCBank(2, tcName);
		bb.verifyFFCBank(3, tcName);
	}

	/******************************************************************
	 // * Description: Verify functionality of Jira JMB-6424 when user saves buyback the FFC info is saved
	 // * Param: String
	 // * Jira Ticket: JMB-6424
	 // * Status: Complete
	 //*******************************************************************/
	@Test (priority = 7, enabled = true)
	public static void saveBbSavesFFCInfo() throws IOException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls li = new Controls();
		Q_AdminForm adm = new Q_AdminForm();
		li.adminLogin();
		Q_Buyback bb = new Q_Buyback();
		bb.bbMenuItem("new");
		bb.addCustomer(2);
		bb.selectBank(1);
		bb.addBankInfo(1,2, "011401533");
		bb.addBankButton();
		bb.selectPayment("ACH");
		bb.addBbProduct(2,"10","1 oz Valcambi Gold Bar (New w/ Assa");
		Q_WebElm.myWait(1000);
		bb.selectBank(1);
		bb.skipCreditCard();
		bb.reportable();
		bb.productValidation();
		Q_WebElm.myWait(5000);
		bb.FfcNoSave("987987123", "SaveBB", "CareOf");
		Q_WebElm.myWait(2000);
		bb.saveVerifyNotes("Buyback created");
		bb.verifySavedFFC(tcName);
	}
	@AfterTest
	public void endReport(){

	}
	@AfterMethod
	public void tearDown() throws Exception {
//		Controls.tearDown();
	}
	@AfterClass
	public void exitClass(){
		System.out.println("After Class");
	}

}