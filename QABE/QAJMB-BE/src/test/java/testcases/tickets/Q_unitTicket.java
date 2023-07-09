package testcases.tickets;


import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_unitTicket extends Init {
	static Q_AdminForm adm = new Q_AdminForm();
	static Q_CustomerForm cust = new Q_CustomerForm();
	static Q_ProductForm prod = new Q_ProductForm();
	static Q_HoldsForm hold = new Q_HoldsForm();
	static Q_OrderForm ord = new Q_OrderForm();
	static Q_Buyback bb = new Q_Buyback();
	static Q_CheckoutForm chk = new Q_CheckoutForm();
	static Q_NewFeatures nfal = new Q_NewFeatures();
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

	/********************************************************************
	 // * Description:
	 // * Param: String
	 // * Jira Ticket: JMB-6722
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 1, enabled = true)
		public static void ImproperCalculationDallasInventory_JMB6722(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.adminLogin();
		adm.dallasInventoryJMB7622();
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