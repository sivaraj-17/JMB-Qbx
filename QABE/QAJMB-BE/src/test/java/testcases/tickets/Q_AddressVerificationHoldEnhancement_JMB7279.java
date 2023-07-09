package testcases.tickets;

import org.junit.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Q_OrderForm;
import pageObjects.Q_Tickets;
import pageObjects.Q_WebElm;
import utils.Controls;
import utils.Init;

public class Q_AddressVerificationHoldEnhancement_JMB7279 extends Init {
	
    static Q_OrderForm ord = new Q_OrderForm();
	static Q_Tickets tic = new Q_Tickets();

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

	/********************************************************************
	 // * Description: Verify the Address and Verification Hold Enhancement
	 // * Author: Sivaraj
	 // * Param : NA
	 // * Jira Ticket: JMB-7279
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 1, enabled = true)
	public void verifyHoldEnhancement() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		String orderId = tic.placeAnOrder("/2016-3-oz-30th-anniversary-silver-eagle-coin-bar/","credit card");
		Q_WebElm.myWait(1000);
		driver.navigate().to(baseUrl + "admin/");
		Q_OrderForm.ordersMenu("list");
		tic.searchOrderAndNavigateToCustomerPage(orderId);
		tic.payAllUnpaidInvoicesForCustomer();
		tic.uncheckAllOperationHold();
		ord.changeOrderStatus("paid");
		String url = driver.getCurrentUrl();
		String productID = url.substring(50, 57);
		Controls.newTabLaunch("admin/shipping-test-file.php?site=jmbullion&id=" + productID);
		tic.verifyShippingMsgStatus("Ready to ship");
		driver.close();
		Controls.switchTab(1);
		ord.orderOnHolFlag("addressVerification");
		Q_WebElm.myWait(2000);
		driver.navigate().refresh();
		Assert.assertTrue(Q_WebElm.xpRetText(ticketsProps,"adm.editOrder.allLegacyStatus").equals("Contains word Gold"));
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
