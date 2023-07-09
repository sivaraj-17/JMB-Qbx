package testcases.order;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

import java.io.FileNotFoundException;

public class Q_OrderInvoices extends Init {
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
    /******************************************************************
     // * Description: Verify user can pay invoice by clicking pay button in the invoice section of the order page.
     // * Jira Ticket: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 1, enabled = true)
    public static void createAndPayInvoice() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("list");
        ord.editOrder(10);
        ord.createOrderInvoice("25.00");
        ord.payOrderInvoicePage();
    }

    /******************************************************************
     // * Description: Verify user can pay invoice by view invoice then pay it.
     // * Jira Ticket: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2, enabled = true)
    public static void payInvoiceViewBtn(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("list");
        ord.editOrder(25);
        ord.createOrderInvoice("10.00");
        ord.payOrderInvoiceViewButton();
    }
    /******************************************************************
     // * Description: Verify user can create invoice and cancel invoice.
     // * Jira Ticket: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3, enabled = true)
    public static void cancelInvoice(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("list");
        ord.editOrder(49);
        ord.createOrderInvoice("10.00");
        ord.cancelOrderInvoice();
    }
    /******************************************************************
     // * Description: Verify user can edit invoice amount then pay it.
     // * Jira Ticket: JMB-6270
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4, enabled = true)
    public static void createEditAndPayInvoice() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        chk.selectItem("silverEagle1994", 2);
        Q_WebElm.myWait(1000);
        Q_AdminForm adm = new Q_AdminForm();
        ord.ordersMenu("list");
        ord.editOrder(1);
        ord.createOrderInvoice("25.00");
        ord.editOrderInvoice("35.00");
        ord.payOrderInvoicePage();
    }
    /******************************************************************
     // * Description: Verify that commas in the invoice amount will be stripped out
     // * Jira Ticket: JMB-3925
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5, enabled = true)
    public static void amountComma(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("list");
        ord.orderTotal(",");
        System.out.println("Order Admin total " + ord.orderTotal());
        String invoiceAmount = ord.orderTotal();
        ord.createOrderInvoice(invoiceAmount);
        ord.createdInvocieAmount(invoiceAmount);
        ord.cancelOrderInvoice();
        ord.createdInvocieAmount(invoiceAmount);
    }
    
    /********************************************************************
	 // * Description: Verify claim invoice link and order status in invoice
	 // * Param: 
	 // * Jira Ticket: JMB-6842
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 6, enabled = true)
		public static void claimsInvoiceLink(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		Controls.adminLogin();
		ord.ordersMenu("list");
		ord.editTopOrder();
		ord.verifyClaimInvoiceLink();
	}
	
	/*********************************************************************
	 * Description: Verify Invoice is marked successfully as paid in 
	 * Admin by clicking on View button
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-7250
	 * @throws FileNotFoundException 
	 ********************************************************************/
	@Test(priority = 7)
	public void verifyInvoicePayment_markPaidInAdmin() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		Q_OrderForm.frontendLogin(1);
		Q_WebElm.myWait(3000);
		chk.selectItem("2019 1 oz Canadian Silver Maple Leaf Coin (BU)", 4);
		Q_OrderForm.thankYouPage();
		Q_OrderForm.logoutUser();
		li.adminLogin();
		ord.ordersMenu("paid");
        ord.editTopOrder();
        ord.createOrderInvoice("25.00");
        ord.markInvoicePaid();
	}
	
	/************************************************************************************************
     * Description: Verify Large Invoice Threshold is checked for Invoice value > $1000
     * Author: Ilakiya
     * Status: Completed
     * Jira Ticket: JMB - 4501
	 **************************************************************************************************/
	@Test(priority = 8, enabled = true)
	public void Invoice1kHold_updateInvoiceDetails_JMB4501() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		Q_ShippingForm.menuElement("adm.menuSettings.xp");
		Q_ShippingForm.subMenuElement("adm.subSetting.configSettings.xp");		
		ord.setLargeInvoiceThreshold("1500");		
		chk.selectItem("perth10g",3);
		Q_WebElm.myWait(2000);
		Q_ShippingForm.menuElement("adm.menuOrders.xp");
		Q_ShippingForm.subMenuElement("ord.menuList.xp");
		ord.editTopOrder();
		ord.createOrderInvoice("1500");
		Q_WebElm.myWait(2000);
		Assert.assertTrue(Q_WebElm.xpSelected(adminProps, "adm.order.largeInvoiceHold.xp"));
	}

	/*****************************************************************************************************
  	 * Description: Verify Large Invoice Threshold is checked for Cancellation charges > $1000
  	 * Author: Ilakiya
  	 * Status: Completed
  	 * Jira Ticket: JMB-4501
	 ***********************************************************************************************************/
	@Test(priority = 9, enabled = true)
	public void Invoice1kHold_updateCancellationDetails_JMB4501() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		Q_ShippingForm.menuElement("adm.menuSettings.xp");
		Q_ShippingForm.subMenuElement("adm.subSetting.configSettings.xp");
		ord.setLargeInvoiceThreshold("1500");
		chk.selectItem("perth10g",3);
		Q_WebElm.myWait(2000);
		Q_ShippingForm.menuElement("adm.menuOrders.xp");
		Q_ShippingForm.subMenuElement("ord.menuList.xp");
		ord.editTopOrder();
		ord.cancelOrderWithPotentialRefund("1500");
		Q_WebElm.myWait(4000);
		Assert.assertTrue(Q_WebElm.xpSelected(adminProps, "adm.order.largeInvoiceHold.xp"));
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


