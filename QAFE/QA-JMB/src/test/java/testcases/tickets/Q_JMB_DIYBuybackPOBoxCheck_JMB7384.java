package testcases.tickets;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Q_JMB_AccountObjects;
import pageObjects.Q_JMB_AutoBuyObjects;
import pageObjects.Q_JMB_CartPageObjects;
import pageObjects.Q_JMB_CheckoutObjects;
import pageObjects.Q_JMB_StuObjects;
import pageObjects.Q_JMB_TicketsObjects;
import pageObjects.Q_JMB_WebElm;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

public class Q_JMB_DIYBuybackPOBoxCheck_JMB7384 extends Q_JMB_Init {

	static Q_JMB_TicketsObjects tic = new Q_JMB_TicketsObjects();
	static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
	static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
	static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
	static Q_JMB_AutoBuyObjects autobuy = new Q_JMB_AutoBuyObjects();
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
	 // * Description : To verify PO Box address and Make Me a Label.
	 // * Author      : Sivaraj
	 // * Param       : NA
	 // * Jira Ticket : JMB-7384
	 // * Status      : Complete
	 //*******************************************************************/
	@Test(priority = 1, enabled = true)
	public void verifyPoBoxAddressMakeMeLabel() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(2);
		driver.navigate().to(baseUrl +"/my-account/buyback-products/");
		tic.searchBuyBackProduct("1 oz American Gold Eagle Coin (Random Year)");
		cart.addItemToCart(1);
		cart.selectcheckoutBtn("bottom");
		tic.isSelectNewShippingAddress();
		acc.acctShippingAddress(37);
		tic.continueWithAddress();
		tic.shippingMethod("Make Me a Label");
		chk.completeOrder();
		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(ticketsProp, "chk.stu.errorMesssage.xp"), "Error Message is not display!");
		autobuy.deleteUserAddresses();
	}

	/********************************************************************
	 // * Description : To verify Military address and Make Me a Label.
	 // * Author      : Sivaraj
	 // * Param       : NA
	 // * Jira Ticket : JMB-7384
	 // * Status      : Complete
	 //*******************************************************************/
	@Test(priority = 2, enabled = true)
	public void verifyMilitaryAddressMakeMeLabel() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(2);
		driver.navigate().to(baseUrl +"/my-account/buyback-products/");
		tic.searchBuyBackProduct("1 oz American Gold Eagle Coin (Random Year)");
		cart.addItemToCart(1);
		cart.selectcheckoutBtn("bottom");
		tic.isSelectNewShippingAddress();
		acc.acctShippingAddress(38);
		tic.continueWithAddress();
		tic.shippingMethod("Make Me a Label");
		chk.completeOrder();
		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(ticketsProp, "chk.stu.errorMesssage.xp"), "Error Message is not display!");
		autobuy.deleteUserAddresses();
	}

	/********************************************************************
	 // * Description : To Verify PO Box address and Use My Own Label.
	 // * Author      : Sivaraj
	 // * Param       : NA
	 // * Jira Ticket : JMB-7384
	 // * Status      : Complete
	 //*******************************************************************/
	@Test(priority = 3, enabled = true)
	public void verifyPoBoxAddressUseMyOwnLabel() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(2);
		driver.navigate().to(baseUrl + "/my-account/buyback-products/");
		tic.searchBuyBackProduct("1 oz American Gold Eagle Coin (Random Year)");
		cart.addItemToCart(1);
		cart.selectcheckoutBtn("bottom");
		stu.selectBbPayment("check");
		tic.isSelectNewShippingAddress();
		acc.acctShippingAddress(37);
		tic.continueWithAddress();
		tic.shippingMethod("Use My Own Label");
		chk.completeOrder();
		Q_JMB_WebElm.myWait(2000);
		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "chk.ThankYouPage.xp"), "Order number is not display!");
		autobuy.deleteUserAddresses();

	}

	/********************************************************************
	 // * Description : To Verify Military address and Use My Own Label.
	 // * Author      : Sivaraj
	 // * Param       : NA
	 // * Jira Ticket : JMB-7384
	 // * Status      : Complete
	 //*******************************************************************/
	@Test(priority = 4, enabled = true)
	public void verifyMilitaryAddressUseMyOwnLabel() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(2);
		driver.navigate().to(baseUrl +"/my-account/buyback-products/");
		tic.searchBuyBackProduct("1 oz American Gold Eagle Coin (Random Year)");
		cart.addItemToCart(1);
		cart.selectcheckoutBtn("bottom");
		stu.selectBbPayment("check");
		tic.isSelectNewShippingAddress();
		acc.acctShippingAddress(38);
		tic.continueWithAddress();
		tic.shippingMethod("Use My Own Label");
		chk.completeOrder();
		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "chk.ThankYouPage.xp"), "Order number is not display!");
		autobuy.deleteUserAddresses();
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
