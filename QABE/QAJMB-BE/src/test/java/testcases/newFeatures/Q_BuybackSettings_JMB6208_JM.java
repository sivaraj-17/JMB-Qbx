package testcases.newFeatures;


import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_BuybackSettings_JMB6208_JM extends Init {
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
	// * Description: Verify functionality of Jira JMB-6208 in configuring DIY minimum and maximum values
	// * Param: String
	// * Jira Ticket: JMB-6208
	// * Status: Complete
	//*******************************************************************/
	@Test(priority = 1, enabled = true)
	public static void changeDiySettings(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/settings-config.php");
		bb.creditThreshold("2000");
		bb.orderLowerLimit("1500");
		bb.orderUpperLimit("600000");
	}
	
	@Test(priority = 2, enabled = true)
	public static void minRequired(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		li.adminLogin();
		bb.selToUs();
		bb.addBbItem("silver" , 5, "20");
		Assert.assertEquals(Q_WebElm.xpRetText(adminProps, "bb.cart.minReqText.xp"),"Our minimum sale amount is $1,500.00");
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
		li.adminLogin();
		bb.selToUs();
		Q_WebElm.myWait(2000);
		bb.addBbItem("gold" , 50, "100");
		Assert.assertEquals(Q_WebElm.xpRetText(adminProps, "bb.cart.maxReqText.xp"), "Our maximum sale amount is $600,000.00");

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
		li.adminLogin();
		driver.navigate().to(adminUrl + "/settings-config.php");
		bb.creditThreshold("1000");
		bb.orderLowerLimit("1000");
		bb.orderUpperLimit("500000");
	}
	
	@AfterTest
	public void endReport(){


	}
	@AfterMethod
	public void tearDown() throws Exception {
		bb.removeCartPageContent();
        Controls.tearDown();
	}

	@AfterClass
	public void exitClass(){
		System.out.println("After Class");
	}
}