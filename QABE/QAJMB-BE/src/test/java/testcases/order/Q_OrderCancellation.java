package testcases.order;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;

import utils.Controls;
import utils.Init;

public class Q_OrderCancellation extends Init {
    static Q_AdminForm adm = new Q_AdminForm();
    static Q_CustomerForm cust = new Q_CustomerForm();
    static Q_ProductForm prod = new Q_ProductForm();
    static Q_HoldsForm hold = new Q_HoldsForm();
    static Q_OrderForm ord = new Q_OrderForm();
    static Q_Buyback bb = new Q_Buyback();
    static Q_CheckoutForm chk = new Q_CheckoutForm();
    static Q_NewFeatures nfal = new Q_NewFeatures();
    static Controls li = new Controls();
    static String orderId;

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
     // * Description: Verify cancellation email message OR_XXXX has been cancelled due to non-payment. We have elected to skip the
     // * market loss fees for this order as a one-time courtesy.  Modified for ticket JMB-6481
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 1, enabled = true)
    public static void skipCancellationFee(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminCustomerSearch("email", "qa+1jmb@jmbullion.com");
        adm.adminViewAllOrders();
        ord.MLFadm(271, 275, 19f);
        ord.skipCacelFee("has been cancelled due to non-payment. We have elected to skip the market loss fees for this order as a one-time courtesy");
        ord.processCancellationskipFee();
        ord.changeOrderStatus("pending");
    }
    /******************************************************************
     // * Description: Verify the alert box will appear if the skip cancellation email cbody is empty.
     // * Param: String
     // * Returns: NA
     // * Jira Ticket: JMB-6481
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2, enabled = true)
    public static void skipCancellationFeeEmptyEmail(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminCustomerSearch("email", "qa+1jmb@jmbullion.com");
        adm.adminViewAllOrders();
        ord.MLFadm(271, 275, 19f);
        ord.skipFeeEmptyEmail();
    }
    /******************************************************************
     // * Description: Verify Email Preview Text Correspond to reason for cancellation
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3, enabled = true)
    public static void orderCancellationEmailBlank(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminCustomerSearch("email", "qa+2jmb@jmbullion.com");
        adm.adminViewAllOrders();
        ord.MLFadm(112, 120, 20f, "Pending");
        ord.cancellationEmail();
    }


    /******************************************************************
     // * Description: Verify user can cancel order by changing the status then save order email will not be sent to customer.
     // * They will be charged for this cancellation. " if user had previously had the fee waived.
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4, enabled = true)
    public static void cancelAndSave(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminCustomerSearch("email", "qa+2jmb@jmbullion.com");
        adm.adminViewAllOrders();
        ord.MLFadm(10, 50, 0f, "Pending");
        ord.saveOrderForm();
    }
    /******************************************************************
     // * Description: Verify verify payment option based on cancellation fee amount user had fee waived in the past.
     // * They will be charged for this cancellation. " if user had previously had the fee waived.
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5, enabled = true)
    public static void verifPymentSelectionFeePrevWaived(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminCustomerSearch("email", "qa+1jmb@jmbullion.com");
        adm.adminViewAllOrders();
        ord.MLFadm(10, 50, 0f, "Pending");
        ord.isPaymentVisible(Q_OrderForm.orderEstCancelFee());
    }
    /******************************************************************
     // * Description: Verify verify payment option based on cancellation fee amount user never had fee waived in the past.
     // * They will be charged for this cancellation. " if user had previously had the fee waived.
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6, enabled = true)
    public static void verifPymentSelectionFeeNeverWaived(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminCustomerSearch("email", "qa+9jmb@jmbullion.com");
        adm.adminViewAllOrders();
        ord.MLFadm(10, 50, 0f, "Pending");
        ord.isPaymentVisible(Q_OrderForm.orderEstCancelFee());
    }
    /******************************************************************
     // * Description: Verify verify cancellation fee amount is stated in the order notes section
     // * They will be charged for this cancellation. " if user had previously had the fee waived.
     // * Param: String
     // * Jira Ticket: JMB-4637
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7, enabled = true)
    public static void mlfNotes(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminCustomerSearch("email", "qa+1jmb@jmbullion.com");
        adm.adminViewAllOrders();
        ord.obtainMLFadm(50, 60, "Pending");
        ord.processCancellationFee();
        ord.changeOrderStatus("pending");
        ord.orderNotes("Cancellation fee for this order is");
    }
    /******************************************************************
     // * Description: Verify verify cancellation fee amount is stated in the order notes section
     // * They will be charged for this cancellation. " if user had previously had the fee waived.
     // * Param: String
     // * Jira Ticket: JMB-6070
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8, enabled = false)
    public static void verifyAutoInvoiceFailedCC(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        li.testStarted(tcName);
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminCustomerSearch("email", "qa+2jmb@jmbullion.com");
        adm.adminViewAllOrders();
        ord.MLFadm(55, 60, 1000f,"Pending");
        ord.processCancellationFailedPayment();
    }

    @Test(priority = 9, enabled = false)
    public static void over1KInvoice(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        li.testStarted(tcName);
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminCustomerSearch("email", "qa+2jmb@jmbullion.com");
        adm.adminViewAllOrders();
        ord.MLFadm(80, 93, 1000f,"Pending");
        ord.over1k();
    }
    
    
    /********************************************************************
	 // * Description: Verify cancel invoice from order form page
	 // * Param: NA
	 // * Jira Ticket: JMB-7020
	 // * Status: Complete
	 //
	 * @throws FileNotFoundException *******************************************************************/
	@Test(priority = 10, enabled = true)
	public static void addNoteFeatureForCancellingInvoices() throws FileNotFoundException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		ord.frontendLogin(6);
		ord.regularOrderToCheckout("platinumEagle1oz", 5, "84092-4033");
		ord.completeOrder();
		ord.logoutUser();
		li.adminLogin();
		ord.ordersMenu("pending");
		ord.editOrder(1);
		ord.createOrderInvoice("50");
		ord.cancelOrderInvoiceNew();	
	}
	/********************************************************************
	 // * Description: Verify Cancel invoicing and cancel note in admin reports menu by clicking cancel
	 // * Param: NA
	 // * Jira Ticket: JMB-7020
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 11, enabled = true)
	public static void cancelInvoiceReports(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		li.adminLogin();
		adm.adminMenu("reports");
		ord.cancelInvoicing();		
	}
	/********************************************************************
	 // * Description: Verify Cancel invoicing and cancel note in admin reports menu by clicking edit & cancel
	 // * Param: NA
	 // * Jira Ticket: JMB-7020
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 12, enabled = true)
	public static void editCancelInvoiceReports(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		li.adminLogin();
		adm.adminMenu("reports");
		ord.cancelInvoicingEdit();		
	}
	
	/*********************************************************************
	 * Description: Verify unable to cancel a shipped order without permission 86 - Edit Order in Shipped Status
	 * but can with permission 86 - Edit Order in Shipped Status
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-7249
	 ********************************************************************/
	@Test(priority = 13, enabled = true)
	public void verifyUnableToCancelShippedOrderWithoutPermission86() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		li.testStarted(tcName);
		li.adminLogin();
		adm.selectAdminUser( );
        adm.removePermission("Edit Order in Shipped Status");
        ord.ordersMenu("paid");
        ord.editTopOrder();
        ord.openCurrentPageInNewTab();
        li.switchTab(0);
        ord.changeOrderStatus("ship");
        li.switchTab(1);
        ord.changeOrderStatus("cancelled");
        ord.verifyOrderCannotBeCanceled();
        li.switchTab(0);
        adm.selectAdminUser();
		adm.grantPermission("Edit Order in Shipped Status");
		li.switchTab(1);
		driver.navigate().refresh();
		ord.changeOrderStatus("cancelled");
		ord.verifyOrderCanBeCanceled();
	}
	
	/********************************************************************
	 // * Description  : Verify the order status 
	 // * Param        : NA
	 // * Jira Ticket  : JMB-7570 - Check the order status
	 // * Status       : Completed
	 //*******************************************************************/
	@Test(priority = 14, enabled = true) 
	public void verifyOrderStatus() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		ord.navigateToQaTestGroupManagePermission();
		adm.removePermission("Edit Order in Shipped Status");
		driver.navigate().to(baseUrl + "/american-silver-eagle-cull/");
		chk.addItemToCart(1);
		chk.selectPaymentType("cheque");
		Q_WebElm.myWait(2000);
		chk.selectcheckoutBtn("top");
		chk.completeOrder();
		orderId = Q_WebElm.xpRetText(adminProps, "adm.thankyou.getOrderId.xp").replaceAll("Order Number: ORD-", "").trim();
		driver.navigate().to(baseUrl + "/admin/");
		Q_OrderForm.ordersMenu("list");
		ord.searchOrderInAdminPage(orderId,1);
		ord.changeOrderStatus("cancelled");
		ord.verifyOrderCanBeCanceled();
		driver.navigate().to(baseUrl + "admin/orders.php?ordertype=cancelled");
		ord.searchOrderInAdminPage(orderId,2);
		Q_WebElm.myWait(1000);
		Controls.switchTab(2);
		Assert.assertTrue(Q_WebElm.xpRetText(adminProps, "ord.orderStatus.xp").equals("Cancelled"),"Order status is Mis-Match ");
	}
	
	/********************************************************************
	 // * Description  : Verify the order item list 
	 // * Param        : NA
	 // * Jira Ticket  : JMB-7570 - Check the order item list
	 // * Status       : Completed
	 //*******************************************************************/
	@Test(priority = 15, enabled = true)
	public void verifyOrderItemList() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		driver.navigate().to(baseUrl + "admin/orders.php?ordertype=cancelled");
		ord.searchOrderInAdminPage(orderId,1);
		ord.verifyEditButtonInCancelledOrders("without permission 86");
	}
	
	/********************************************************************
	 // * Description  : Verify to change the order status
	 // * Param        : NA
	 // * Jira Ticket  : JMB-7570 - Change the order status 
	 // * Status       : Completed
	 //*******************************************************************/
	@Test(priority = 16, enabled = true) 
	public void verifyChangeOrderStatus() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		ord.navigateToQaTestGroupManagePermission();
		adm.grantPermission("Edit Order in Shipped Status");
		Q_WebElm.myWait(2000);
		driver.navigate().to(baseUrl + "admin/orders.php?ordertype=cancelled");
		ord.searchOrderInAdminPage(orderId,1);
		ord.changeOrderStatus("pending");
		Q_WebElm.myWait(1000);
		driver.navigate().refresh();
		Assert.assertTrue(Q_WebElm.xpRetText(adminProps,"ord.orderStatus.xp").equals("Pending"), "Order was cancelled");
	}
	
	/********************************************************************
	 // * Description  : Verify to change the qunatity 
	 // * Param        : NA
	 // * Jira Ticket  : JMB-7570 - Change the quantity of item list
	 // * Status       : Completed
	 //*******************************************************************/
	@Test(priority = 17, enabled = true) 
	public void verifyChangeQuantity() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		Q_WebElm.myWait(1000);
		driver.navigate().to(baseUrl + "admin/orders.php?ordertype=cancelled");
		ord.searchOrderInAdminPage(orderId,1);
		ord.changeItem1Quantity();
		String quantity=Q_WebElm.xpRetText(adminProps,"ord.quantity.xp"); 
		Assert.assertTrue(Q_WebElm.xpRetText(adminProps,"ord.quantity.xp").equals(quantity),"Quantity value is not equal");
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
