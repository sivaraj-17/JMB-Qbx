package testcases.tickets;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Q_JMB_AccountObjects;
import pageObjects.Q_JMB_AdminObjects;
import pageObjects.Q_JMB_AutoBuyObjects;
import pageObjects.Q_JMB_CartPageObjects;
import pageObjects.Q_JMB_CheckoutObjects;
import pageObjects.Q_JMB_StuObjects;
import pageObjects.Q_JMB_TicketsObjects;
import pageObjects.Q_JMB_WebElm;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

public class Q_JMB_TrackCustomerDeletedCreditCards_JMB6778 extends Q_JMB_Init {

	static Q_JMB_TicketsObjects tic = new Q_JMB_TicketsObjects();
	static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
	static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
	static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
	static Q_JMB_AutoBuyObjects autobuy = new Q_JMB_AutoBuyObjects();
	static Q_JMB_AdminObjects admin = new Q_JMB_AdminObjects();
	static Q_JMB_StuObjects stu = new Q_JMB_StuObjects();

	@BeforeClass
	public void tcSetup (){
	}

	@BeforeMethod
	public void report() throws Exception {
		Q_JMB_Init.setItUp();
	}

	@BeforeTest
	public void setTest() throws Exception {
	}

	/********************************************************************
	// * Description  : Verify Deletion of Credit Cards with order incomplete
	// * Author       : Sivaraj
	// * Jira Ticket  : JMB-6778
	// * Status       : Complete
	//*******************************************************************/
	@Test(priority = 1, enabled = true)
	public void verifyDeletionCreditCardsOrderIncomplete() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(56);
		chk.selectItem("1 oz American Gold Eagle Coin", 1);
		cart.selectPaymentType("wire");
		cart.selectcheckoutBtn("top");
		chk.completeOrder();
		Q_JMB_WebElm.myWait(2000);
		driver.navigate().to(baseUrl+"/my-account/");	
		tic.verifyMyAccountOrderStatus();
		tic.verifyDeleteLink(false);
	}

	/********************************************************************
	// * Description  : Verify Deletion of Credit Cards with order having unpaid invoice
	// * Author       : Sivaraj
	// * Jira Ticket  : JMB-6778
	// * Status       : Complete
	//********************************************************************/
	@Test(priority = 2, enabled = true)
	public void verifyDeletionCreditCardsOrderUnpaidInvoice() throws FileNotFoundException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		Q_JMB_Controls.adminLogin();
		String email = "qa+ccunpaidinvoice@jmbulllion.com";
		admin.adminCustomerSearch("email", email);
		admin.adminViewAllOrders();
		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(ticketsProp,"cust.unpaidInvoiceHeader.xp"));
		Q_JMB_Controls.adminLogout();
		acc.loginUser(57);
		tic.verifyDeleteLink(false);
	}

	/********************************************************************
	// * Description  : Verify Deletion of Credit Cards with complete orders
	// * Author       : Sivaraj
	// * Jira Ticket  : JMB-6778
	// * Status       : Complete
	//*******************************************************************/
	@Test(priority = 3, enabled = true)
	public void verifyDeletionCreditCardsOrderComplete() throws FileNotFoundException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		Q_JMB_Controls.adminLogin(); 
		String email ="qa+completeorders@jmbulllion.com"; 
		admin.adminCustomerSearch("email",email); 
		admin.adminViewAllOrders(); 
		admin.adminEditCustomerOrder(1);
		tic.changeOrderStatus("completed");
		Q_JMB_WebElm.myWait(2000);
		Q_JMB_Controls.adminLogout();
		acc.loginUser(58);
		tic.verifyDeleteLink(true);
	}

	@AfterTest
	public void endReport(){

	}

	@AfterMethod
	public void tearDown() throws Exception {	
		Q_JMB_Controls.tearDown();
	}

	@AfterClass
	public void exitClass(){
		System.out.println("After Class");
	}
}
