package testcases.buyback;


import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_BuybackSettings extends Init {
	static Q_AdminForm adm = new Q_AdminForm();
	static Q_CustomerForm cust = new Q_CustomerForm();
	static Q_ProductForm prod = new Q_ProductForm();
	static Q_HoldsForm hold = new Q_HoldsForm();
	static Q_OrderForm ord = new Q_OrderForm();
	static Q_Buyback bb = new Q_Buyback();
	static Q_CheckoutForm chk = new Q_CheckoutForm();
	static Q_NewFeatures nfal = new Q_NewFeatures();
	static Controls li = new Controls();
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
	
	/******************************************************************
	// * Description: Verify functionality of Jira JMB-6208 in configuring DIY minimum and maximum values
	// * Param: String
	// * Jira Ticket: JMB-6208
	// * Status: Complete
	//*******************************************************************/
	@Test(priority = 1, enabled = true)
	public static void changeDiySettings(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		Controls li = new Controls();
		li.adminLogin();
		driver.navigate().to(adminUrl + "/settings-config.php");
		Q_AdminForm adm = new Q_AdminForm();
		adm.creditThreshold("2000");
		adm.orderLowerLimit("1000");
		adm.orderUpperLimit("500000");

	}
	
	@Test(priority = 2, enabled = true)
	public static void minRequired(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		Controls li = new Controls();
		li.adminLogin();
		Q_Buyback bb = new Q_Buyback();
		bb.selToUs();
		bb.addBbItem("silver" , 7, "20");

		Assert.assertEquals(Q_WebElm.xpRetText(adminProps, "bb.cart.minReqText.xp"),"Our minimum sale amount is $1,000.00");
	}
	
	/*******************************************************************
	 // * Description: Verify DIY maximum of $200,000.00 is allowed otherwise customer can CSR
	 // * Author:
	 // * Jira Ticket: JMB-6208
	 // * Status: Complete
	 ********************************************************************/
	@Test(priority = 3, enabled = true)
	public static void diyMaxLimit(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		Controls li = new Controls();
		li.adminLogin();
		Q_Buyback bb = new Q_Buyback();
		bb.selToUs();
		Q_WebElm.myWait(2000);
		bb.addBbItem("gold" , 38, "500");
		Assert.assertEquals(Q_WebElm.xpRetText(adminProps, "bb.cart.maxReqText.xp"), "Our maximum sale amount is $500,000.00");

	}
	
	/*******************************************************************
	// * Description: Reset DIY config setting to previous sate
	// * Author:
	// * Jira Ticket: JMB-6208
	// * Status: Complete
	********************************************************************/
	@Test(priority = 4, enabled = true)
	public static void resetDiyConfig(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		Controls li = new Controls();
		li.adminLogin();
		driver.navigate().to(adminUrl + "/settings-config.php");
		Q_AdminForm adm = new Q_AdminForm();
		adm.creditThreshold("2000");
		adm.orderLowerLimit("1500");
		adm.orderUpperLimit("600000");
	}
	
	/********************************************************************
	 * Description: Verify product ranking & separate tape for metal type
	 * Author: Tamilselvan 
	 * Param: NA 
	 * Status: Complete
	 * Ticket: JMB-6774 
	 *******************************************************************/
	@Test(priority = 5, enabled = true)
	public void verifyProductRankingDragandDropAndEnterRank() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.adminLogin();
		driver.get("https://qa.jmbullion.com/admin/top-buyback.php");
		bb.verifyMetalTypeInTopBBPage();
        Q_WebElm.myWait(3000); 
		bb.verifyProductRankByEnterRank(2,57);
        Q_WebElm.myWait(5000); 
		bb.verifyProductRankByDragAndDrop(7);
	}
	
	@AfterTest
	public void endReport(){


	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Q_Buyback bb = new Q_Buyback();
		bb.removeCartPageContent();
        Controls.tearDown();
	}

	@AfterClass
	public void exitClass(){
		System.out.println("After Class");
	}
}