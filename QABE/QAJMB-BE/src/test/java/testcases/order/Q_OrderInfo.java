package testcases.order;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;
import java.text.ParseException;

import java.io.FileNotFoundException;

public class Q_OrderInfo extends Init {
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
     // * Description: Verify shipping address on Invoice form for PayPal order is not blank
     // * Jira Ticket: JMB-4062
     // * Status: Complete
     //*******************************************************************/
    @Test(priority =1)
    public static void invoiceShippingAddress() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("list");
        ord.orderListParam(4, "Paypal Express");
        ord.orderInvoice();
    }
    /******************************************************************
     // * Description: Verify the alert box "This customer has already had their cancellation fees waived automatically on a previous order.
     // * They will be charged for this cancellation. " if user had previously had the fee waived.
     // * Jira Ticket: JMB-3981
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2)
    public static void preSaleESD() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        chk.selectItem("preSale", 2);
        Q_WebElm.myWait(1000);
        driver.navigate().to(adminUrl);
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.changeOrderStatus("paid");
        Assert.assertEquals(Q_WebElm.idRetText(adminProps, "ord."), "2025-08-20");
        System.out.println("Verified ED date matches the pre sale date of 2022-01-24");
    }
    /******************************************************************
     // * Description: Verify user can change order status from pending to paid and the correct status is published
     // * Jira Ticket: JMB-4016
     // * Status: Complete
     //*******************************************************************/
    @Test(priority =3)
    public static void publishStatus(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("list");
        ord.orderListParam(4,"Paper Check");
        ord.changeOrderStatus("paid");
    }
    /******************************************************************
     // * Description: Verify reinstated order margin of a cancelled order
     // * Jira Ticket: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority =4)
    public static void reinstatedOrderMargin(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminCustomerSearch("email", "qa+2jmb@jmbullion.com");
        adm.adminViewAllOrders();
        ord.MLFadm(255, 260, 20f,"Pending");
        ord.processCancellationFee();
        ord.orderMarginCalculation();
    }
    /******************************************************************
     // * Description: Verify user can edit line item order quantity on a given order
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5)
    public static void addOrderQuantity(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.changeItem1Quantity();
        ord.recalculateTax();
    }
    /******************************************************************
     // * Description: Verify user can add line item on a given order
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6)
    public static void addOrderLineItem(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("pending");
        ord.editTopOrder();
        ord.addProduct();
        ord.recalculateTax();
    }
    /******************************************************************
     // * Description: Verify user can remove line item from an order in order form
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7)
    public static void removeOrderLineItem(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("pending");
        ord.editTopOrder();
        ord.removeProduct();
        ord.recalculateTax();
    }
    /******************************************************************
     * Description: Verify we're not allowed to return more than that is on the order,verify details in return form,ability to return individually and group.
     * Author: Mobin
     * Status:Complete
     * Ticket: JMB-6523 & JMB-6633
     *******************************************************************/
    @Test (priority = 8, enabled = true)
    public void verifyReturnVerifications() throws FileNotFoundException
    {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        li.testStarted(tcName);
        li.adminLogin();
        chk.addItem("/1994-american-silver-eagle/", 4);
        chk.selectItem("perth10g", 1);
        Q_WebElm.myWait(3000);
        ord.ordersMenu("list");
        ord.editOrder(1);
        ord.checkBoxesHandling(adminProps,"uncheck", "ord.adminForm.ord.holdsCheckBoxes.xp");
        ord.changeOrderStatus("paid");
        ord.changeOrderStatus("ship");
        ord.verifyPrdDetailsAndCheckRestrictions();
        ord.returnAllProductsIndividually();
        ord.undoReturnAllProductsIndividually();
        ord.initiateFullReturn();
    }
	
	/*********************************************************************
	 * Description: Verify the delete link for the credit card is not displayed when the
	 * order is not complete and displayed when complete without invoice
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-6778
	 * @throws FileNotFoundException 
	 ********************************************************************/
	@Test(priority = 9, enabled = true)
	public static void verifyDeletion_whenOrderIsIncomplete() throws FileNotFoundException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Q_OrderForm.frontendLogin(16);
		Q_OrderForm.navigateFrontEnd_myAccount("payments");
		Q_OrderForm.addCreditCard(2);
		chk.selectItem("2019 1 oz Canadian Silver Maple Leaf Coin (BU)", 4);
		Q_OrderForm.thankYouPage();
		Q_OrderForm.navigateFrontEnd_myAccount("orders");
		Q_OrderForm.verifyDeleteLink_isDisplayed_forCC(Q_OrderForm.orderStatus_frontEnd());
		Q_OrderForm.logoutUser();
		Q_OrderForm.launchAdminURL_newTab();
		Q_OrderForm.changeOrderStatus_PaidToCompleted("qa17auto@jmbullion.com");
		Q_OrderForm.closeCurrentTab_switchPreviousWin();
	    driver.navigate().refresh();
	    Q_OrderForm.frontendLogin(16);
	    Q_OrderForm.navigateFrontEnd_myAccount("orders");
	    Q_OrderForm.verifyDeleteLink_isDisplayed_forCC(Q_OrderForm.orderStatus_frontEnd());
	    Q_OrderForm.myAccount("payments");
	    Q_OrderForm.deleteCreditcard();	
	}
	
	/*********************************************************************
	 * Description: Verify the delete link for the credit card is not displayed when the 
	 * invoice in the complete order is unpaid and displayed when paid
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-6778
	 * @throws FileNotFoundException 
	 ********************************************************************/
	@Test(priority = 10, enabled = true)
	public static void verifyDeletion_whenInvoiceIsIncomplete() throws FileNotFoundException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Q_OrderForm.frontendLogin(16);
		Q_OrderForm.navigateFrontEnd_myAccount("payments");
		Q_OrderForm.addCreditCard(2);
		chk.selectItem("2019 1 oz Canadian Silver Maple Leaf Coin (BU)", 4);
		Q_OrderForm.thankYouPage();
		Q_OrderForm.navigateFrontEnd_myAccount("orders");
		Q_OrderForm.logoutUser();
		Q_OrderForm.launchAdminURL_newTab();
		Q_OrderForm.changeOrderStatus_PaidToCompleted("qa17auto@jmbullion.com");
        Q_WebElm.myWait(6000);
        ord.createOrderInvoice("10.00");
        Q_OrderForm.closeCurrentTab_switchPreviousWin();
        driver.navigate().refresh();
        Q_OrderForm.frontendLogin(16);
        Q_OrderForm.navigateFrontEnd_myAccount("orders");
        Q_OrderForm.verifyDeleteLink_isDisplayed_forCC(Q_OrderForm.orderStatus_frontEnd());
        Q_OrderForm.payInvoice();
        Q_OrderForm.navigateFrontEnd_myAccount("orders");
        Q_OrderForm.verifyDeleteLink_isDisplayed_forCC(Q_OrderForm.orderStatus_frontEnd());
        Q_OrderForm.myAccount("payments");
        Q_OrderForm.deleteCreditcard();	
	}
	
	/********************************************************************
	 // * Description: Verify Order Margins don't have negative values
	 // * Author: Tamil
	 // * Jira Ticket: JMB-7003
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 11, enabled = true)
	public static void orderMarginCalculation(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		Controls.adminLogin();
		Q_OrderForm.ordersMenu("pending");
		ord.editOrder(1);
		int[] value=ord.getOrderMargin();
		ord.verifyNegativeMargin(value[0]);
		ord.verifyNegativeMargin(value[1]);
		ord.verifyNegativeMargin(value[0]+100);
		ord.verifyNegativeMargin(value[1]);		
	}
	
	/********************************************************************
	 // * Description: Verify Limit orders displayed in JMB Admin page
	 // * Param: NA
	 // * Jira Ticket: JMB-7121
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 12, enabled = true)
	public static void limitOrderDisplayedAdmin(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		Controls.adminLogin();
		Q_OrderForm.ordersMenu("list");
		ord.verifyLimitOrderAndLimitPage();
	}
	
	/*********************************************************************
	 * Description: Verify Frauded Customer Accounts - Billing Review Flag on Orders - Registered user 
	 * Param: NA 
	 * Jira Ticket: JMB-6482 
	 * Author: Tamilselvan A
	 * Status: Complete  
	 *******************************************************************/
	@Test(priority = 13, enabled = true)
	public static void fraudedCustomerBillingReviewFlagRegisteredUser() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		ord.frontendLogin(5);
		Q_WebElm.myWait(5000);
		ord.regularOrderToCheckout("silverEagle1994 & perth10g", 5, "75070");
		ord.completeOrder();
		ord.logoutUser();
		Q_WebElm.myWait(3000);
		li.adminLogin();
		ord.ordersMenu("list");
		String orderno = ord.editTopOrder();
		ord.verifyFraudStatus();
		driver.get(baseUrl);
		ord.logoutUser();
		// Switching back to front end and create new order
		ord.frontendLogin(5);
		Q_WebElm.myWait(5000);
		ord.regularOrderToCheckout("silverEagle1994 & perth10g", 5, "TX 75070");
		ord.completeOrder();
		ord.logoutUser();
		driver.navigate().to(baseUrl + "/ato/smarty.php");
		Q_WebElm.myWait(5000);
		driver.navigate().to(baseUrl + "/ato/smarty.php");
		driver.navigate().refresh();
		Q_WebElm.myWait(1000);
		driver.close();
		li.switchTab(0);
		// Switch into Admin to verify the order status & customer status
		li.adminLogin();
		ord.verifyNewOrderFraudStatus();
	}
	
	/*********************************************************************
	 * Description: Verify Frauded Customer Accounts - Billing Review Flag on Orders - Guest user 
	 * Param: NA // 
	 * Jira Ticket: JMB-6482 
	 * Author: Tamilselvan A
	 * Status: Complete 
	 *******************************************************************/

	@Test(priority = 14, enabled = true)
	public void fraudedCustomerBillingReviewFlagGuestUser() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		ord.guestOrderBankwire(5);
		ord.completeOrder();
		Q_WebElm.myWait(5000);
		li.adminLogin();
		ord.ordersMenu("list");
		ord.editTopOrder();
		ord.enableFraud();
		ord.verifyCustFraudStatusYes();
		Q_WebElm.myWait(2000);
		ord.verifyAllPendingOrderFraudStatus();
		driver.get(baseUrl);
		ord.logoutUser();
		// Switching back to front end and create new order
		ord.guestOrderBankwire(5);
		ord.completeOrder();
		driver.navigate().to(baseUrl + "/ato/smarty.php");
		Q_WebElm.myWait(5000);
		driver.navigate().to(baseUrl + "/ato/smarty.php");
		Q_WebElm.myWait(5000);
		driver.navigate().refresh();
		Q_WebElm.myWait(1000);
		driver.close();
		li.switchTab(0);
		// Switch into Admin to verify the order status & customer status
		li.adminLogin();
		ord.verifyNewOrderFraudStatus();
	}
	
	/*********************************************************************
	 * Description: Verify Child SKU can be added to existing Paid Order
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-7072
	 * @throws FileNotFoundException 
	 ********************************************************************/

	@Test(priority = 15)
	public void verifyChildSku_additionToPaidOrder() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		Q_OrderForm.frontendLogin(10);
		Q_WebElm.myWait(3000);
		chk.selectItem("2019 1 oz Canadian Silver Maple Leaf Coin (BU)", 4);
		Q_OrderForm.thankYouPage();
		Q_OrderForm.logoutUser();
		li.adminLogin();
		Q_WebElm.myWait(4000);
		driver.navigate().to(adminUrl);	//added because admin does not load on first time login; needs refresh everytime
		ord.ordersMenu("paid");
        ord.editTopOrder();
        ord.addSKU("2018 American Silver Eagle Monster Box (500 Coins,");
        ord.recalculateTax();
	}
	
	/********************************************************************
	 * Description: verify return button disabled after return order item to Prevent return order
	 * Author: Tamil
	 * Status: Complete 
	 * Ticket: JMB-6541
	 * Status: Complete
	 ********************************************************************/
	@Test(priority = 16, enabled = true)
		public static void preventReturningOrder() throws FileNotFoundException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		Controls.adminLogin();
		Q_OrderForm.ordersMenu("paid");
		ord.editOrder(1);
		ord.changeOrderStatus("ship");
		ord.returnOrderItem();
		ord.receiveReturnOrderItem();
		ord.verifyReturnLog();
	}
	
	/********************************************************************
	 * Description: Verify the State Amount/Tax and API breakdown values are match with state value (To enable amount we have active session in frontend)
	 * Param: NA 
	 * Jira Ticket: JMB-7277 
	 * Status: Complete 
	 * @throws FileNotFoundException 
	 *******************************************************************/
	@Test(priority = 17, enabled = true)
	public void verifyStateValueAndAPIValueMatch() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		ord.guestOrderBankwire(6);
		Controls.newTab();
		Controls.adminLogin();
		driver.get("https://qa.jmbullion.com/admin/tax-tests.php");
		ord.verifyProductAmtAndApiAmount();
		driver.get(baseUrl);
		ord.logoutUser();
		ord.frontendLogin(0);
		Q_WebElm.myWait(5000);
		ord.regularOrderToCheckout("multiple products", 5, "(312) 331-2312");
		ord.completeOrder();
		ord.logoutUser();
		Q_WebElm.myWait(3000);
		li.adminLogin();
		ord.ordersMenu("list");
		String orderno = ord.editTopOrder();
		String idValue = ord.selectOrderWithSalesTax(1, 100, "Pending").replaceAll("[a-zA-Z]", "").replaceAll("&", "");
		int id = Integer.parseInt(idValue);
		System.out.println("ID Int: "+id);
		ord.verifyTaxMsgAndApiBreakdown(id);
	}
	
	/********************************************************************
	 * Description: Verify the Sales Tax and API breakdown values are match with state value
	 * Param: NA 
	 * Jira Ticket: JMB-7278 
	 * Status: Complete 
	 * @throws FileNotFoundException 
	 *******************************************************************/
	@Test(priority = 18, enabled = true)
	public void verifySalesTaxBreakdown() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		ord.frontendLogin(0);
		Q_WebElm.myWait(5000);
		ord.regularOrderToCheckout("multiple products", 5, "(312) 331-2312");
		ord.completeOrder();
		ord.logoutUser();
		Q_WebElm.myWait(3000);
		Controls.adminLogin();
		ord.ordersMenu("list");
		String orderno = ord.editTopOrder();
		String idValue = ord.selectOrderWithSalesTax(1, 100, "Pending").replaceAll("[a-zA-Z]", "").replaceAll("&", "");
		int id=Integer.parseInt(idValue);
		ord.verifyTaxMsgAndApiBreakdown(id);
	}
	
	/********************************************************************
 	// * Description: Verify Payment Information on Completed Orders
 	// * Param: NA
 	// * Jira Ticket: JMB-8022
 	// * Status:Completed
 	//*******************************************************************/
	@Test(priority = 19, enabled = true)
	public void paymentInformationCompletedOrders(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		adm.adminMenu("orders");
		Q_OrderForm.ordersMenu("completed");
		ord.editTopOrder();
		ord.verifyPaymentInformationButtonIsDisplayed();
	}
	
	/********************************************************************
	 * Description: Verify and select the New Claim Status: 90% Amark Denied/In House Review in admin Claim form page
	 * Param		 : NA
	 * Jira Ticket: JMB-7253 - New Claim Status: 90% Amark Denied / In House Review
	 * Status	 : Complete
	 *******************************************************************/
	@Test(priority = 20, enabled = true)
	public void verifyNewClaimStatus_JMB7253(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();		
		Q_ShippingForm.menuElement("adm.menuOrders.xp");
		Q_ShippingForm.subMenuElement("ord.menuList.xp");
		ord.editOrder(1);
		Q_WebElm.xp(adminProps, "adm.adminEditOrders.initiateFullClaimBtn.xp");
		ord.adminClaimFormEditOrderClaimStatus("AMDEINHR");
		Q_WebElm.xpSelectValue(adminProps, "adm.adminClaimForm.finalResolutionDropdown.btn.xp", "CLM2RETRN"); //*Mandatory field
		Q_WebElm.xp(adminProps, "adm.adminClaimForm.submitBtn.xp");
		Assert.assertTrue(ord.strXpText("adm.adminOrderClaimStatus.xp").equals("(90%) Amark Denied / In house Review"),"Order status not updated as:(90%) Amark Denied / In house Review");
	}
	
	/********************************************************************
	 * Description: verify CC pending orders locked without permission 86
	 * Author: Tamilselvan A
	 * Jira Ticket: JMB-8134
	 * Status: Complete
	 * @throws FileNotFoundException 
	 * *******************************************************************/
	@Test(priority = 21, enabled = true)
	public void lockdownPendingCcOrders() throws FileNotFoundException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		ord.frontendLogin(5);
		Q_WebElm.myWait(5000);
		ord.regularOrderToCheckout("2019 Canadian Silver Maple Leaf Tube (25 Coins, BU)", 1, "2842");
		ord.completeOrder();
		ord.logoutUser();
		Q_WebElm.myWait(3000);
		li.adminLogin();
		ord.selectCsSupervisorUser();
        adm.removePermission("Edit Order in Shipped Status");
		Q_WebElm.myWait(2000);
		ord.ordersMenu("list");
		Q_WebElm.myWait(2000);
		String ordNo = ord.editTopOrder();
		String url=driver.getCurrentUrl();
		ord.changeOrderStatus("pending");
		Q_WebElm.myWait(3000);
		ord.verifyOrderStatusEditDisabled();
		ord.selectCsSupervisorUser();
        adm.grantPermission("Edit Order in Shipped Status");
		Q_WebElm.myWait(3000);
        driver.get(url);
        ord.verifyOrderStatusEditEnabled();
	}
	
	/*****************************************************************
    // * Description: Verify update ESD on line item update
    // * Author: Ilakiya
    // * Status: Completed
    // * Jira Ticket: JMB - 5763 
	 ********************************************************************/	
	@Test(priority = 22, enabled = true)
	public void verifyUpdateEsdOnLineItemUpdate() throws ParseException   {		
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		String orderId = chk.placeAnOrder("/american-silver-eagle-cull/","credit card");
		Q_WebElm.myWait(1000);
		ord.navigateToEditOrderInAdminPage(orderId);
		Controls.switchTab(1);
		ord.changeOrderStatus("paid");
		String admEsdBeforeAddingPreSaleItem = ord.getAdminEsd();
		String myAccountEsdBeforeAddingPreSaleItem=ord.getMyAccountEsd();
		ord.navigateToEditOrderInAdminPage(orderId);
		Controls.switchTab(2);
		ord.addProductInEditOrderPage("1","2.5 Gram Valcambi Gold Bar (New w/ Assay)");
		driver.navigate().refresh();
		String admEsdafterAddingPreSaleItem= ord.getAdminEsd();
		Assert.assertNotEquals(admEsdBeforeAddingPreSaleItem, admEsdafterAddingPreSaleItem);	
		String myAccountEsdAfterAddingPreSaleItem=ord.getMyAccountEsd();
		Assert.assertNotEquals(myAccountEsdBeforeAddingPreSaleItem, myAccountEsdAfterAddingPreSaleItem);
		ord.navigateToEditOrderInAdminPage(orderId);
		Controls.switchTab(3);
		ord.removeProductInEditOrderPage("2.5 Gram Valcambi Gold Bar (New w/ Assay)");
		Q_WebElm.myWait(2000);
		String admEsdAfterRemovingPreSaleItem= ord.getAdminEsd();
		Assert.assertNotEquals(admEsdafterAddingPreSaleItem, admEsdAfterRemovingPreSaleItem);	
		String myAccountEsdAfterRemovingPreSaleItem=ord.getMyAccountEsd();
		Assert.assertNotEquals(myAccountEsdAfterAddingPreSaleItem, myAccountEsdAfterRemovingPreSaleItem);	
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


