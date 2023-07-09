package testcases.tickets;

import org.testng.Assert;



import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.Q_JMB_CheckoutObjects;
import pageObjects.Q_JMB_TicketsObjects;
import pageObjects.Q_JMB_WebElm;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

public class Q_JMB_BrainTreePayPal_JMB7855 extends Q_JMB_Init {
    
	static Q_JMB_TicketsObjects tic = new Q_JMB_TicketsObjects();
	static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();

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
	 // * Description : To verify placed paypal orders in customer page
	 // * Author      : Sivaraj
	 // * Param       : NA
	 // * Jira Ticket : JMB-7855
	 // * Status      : Complete
	 //*******************************************************************/
	@Test(priority = 1, enabled = true)
	public void verifyPlacedPayPalOrders() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		chk.selectItem("1 oz American Gold Eagle Coin", 1);
		String originalWindow = driver.getWindowHandle();
		tic.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.xp", originalWindow);
		chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
		chk.completeOrder();
		String orderId = tic.getOrderId();
		String orderTotal = tic.getOrderTotal();
		driver.navigate().to("https://qa.jmbullion.com/ato/smarty.php");
		tic.navigateToEditOrderInAdminPage(orderId);
		Assert.assertFalse(Q_JMB_WebElm.xpSelected(ticketsProp, "adm.addressVerification.xp"),"Address Verification is Checked");
		tic.verifyCustomerOrders(orderId, orderTotal);
	}	
	
	/********************************************************************
	 // * Description : To verify address verification in orders form page
	 // * Author      : Sivaraj
	 // * Param       : NA
	 // * Jira Ticket : JMB-7855
	 // * Status      : Complete
	 //*******************************************************************/
	@Test(priority = 2, enabled = true)
	public void verifyAddressVerificationCheckBox() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		chk.selectItem("1 oz American Gold Eagle Coin", 1);
		String originalWindow = driver.getWindowHandle();
		tic.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.xp", originalWindow);
		chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
		chk.completeOrder();
		String orderId = tic.getOrderId();
		driver.navigate().to("https://qa.jmbullion.com/ato/smarty.php");
		tic.navigateToEditOrderInAdminPage(orderId);
		Assert.assertFalse(Q_JMB_WebElm.xpSelected(ticketsProp, "adm.addressVerification.xp"),"Address Verification is Checked");
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