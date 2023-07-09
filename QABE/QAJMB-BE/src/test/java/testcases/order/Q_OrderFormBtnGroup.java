package testcases.order;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Q_OrderFormBtnGroup extends Init {
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
     // * Description: Verify user can can create claim for an order
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 1, enabled = true)
    public static void claimReturn(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.buttonFullClaim();
        Q_OrderForm.orderNotes("New claim");
    }
    /******************************************************************
     // * Description: Verify user can can remove claim from an order
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2, enabled = true)
    public static void removeClaim(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.removeClaim();
    }
    /******************************************************************
     // * Description: Verify user can create Full Return on an order
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3, enabled = true)
    public static void fullReturn() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        chk.selectItem("perth10g", 1);
        driver.navigate().to(adminUrl);
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.buttonFullReturn();
        ord.orderNotes("New return created for this order");
    }
    /******************************************************************
     // * Description: Verify user can can remove return from an order
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4, enabled = true)
    public static void removeReturn(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.removeReturn();
        ord.orderNotes("has been deleted");
    }
    /******************************************************************
     // * Description: Verify user can initiate and pay refund on an order
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5, enabled = true)
    public static void initiateRefund() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        chk.selectItem("perth10g", 1);
        driver.navigate().to(adminUrl);
        ord.ordersMenu("list");
        ord.editTopOrder();
        System.out.println("Order total: " + Q_OrderForm.strXpText("ord.paymentInfoTotal.xp"));
        ord.buttonRefund(Q_OrderForm.strXpText("ord.paymentInfoTotal.xp"));
        ord.orderNotes("New refund created for this order");
    }
    /******************************************************************
     // * Description: Verify user can mark on an order as possible fraud
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6, enabled = true)
    public static void fraudPossible() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.buttonFraud();
    }
    /******************************************************************
     // * Description: Verify user can remove possible fraud on an order
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7, enabled = true)
    public static void removePossibleFraud() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.removeFraud();
    }
    /******************************************************************
     // * Description: Verify user can create Full Reshipment on a given order
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8, enabled = true)
    public static void fullReship(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.buttonFullReship();
    }
    /******************************************************************
     // * Description: Verify user can assign different sales rep on a given order
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9, enabled = true)
    public static void assignSalesRep(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.buttonAssignSalesRep();
    }
    /******************************************************************
     // * Description: Verify the skip late payment email link works as expected
     // * Param: String
     // * Jira Ticket: JMB-6189
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 10, enabled = true)
    public static void skipLatePaymentEmailJMB_6189(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        ord.ordersMenu("list");
        System.out.println("Total order " + Q_OrderForm.rowCount("hold.orderCount.xp"));
        ord.editOrderPaymentType(4, "Paper Check");
    }
    /******************************************************************
     * Description:Verify Estimated ship date displayed correctly after complete
     * fullReship Existing methods used: customerPage(), viewOrderByParam(),
     * buttonFullReship(), changeOrderStatus() Author: Tamilselvan Status: Completed
     * Jira Ticket: JMB-6059 - ReshipShip Date 1969
     *
     * @throws FileNotFoundException
     * @throws ParseException
     *******************************************************************/
    @Test(priority = 11, enabled = true)
    public static void verifyReshipDate() throws FileNotFoundException, ParseException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        cust.customerPage("qa9auto@jmbullion.com");
        cust.viewOrderByParam("status", "Paid");
        Q_OrderForm.fullReshipShipped();
        String mainOrderNo = Q_OrderForm.verifyShipmentDateBackend();
        driver.get(baseUrl);
        Q_OrderForm.logoutUser();
        // Switching back to front end and verifying the shipment date
        Q_OrderForm.frontendLogin(8);
        driver.get(baseUrl + "/my-account/view-order/?order=" + mainOrderNo + "");
        Q_OrderForm.verifyshipDateFrontend();
    }
    
    /********************************************************************
	* Description: verify Return Entire Order button and received link are displayed with permission 97
	* Author: Tamilselvan
	* Jira Ticket: JMB-6520
	* Status: Complete
	* *******************************************************************/
	@Test(priority = 12, enabled = true)
	public void returnEntireOrderAndOrderReceivedLinkWithPermission97() throws FileNotFoundException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.adminLogin();
        adm.selectAdminUser();
		adm.grantPermission("In Hand Movements");
    	Q_WebElm.myWait(5000);
		Q_OrderForm.ordersMenu("paid");
		ord.editOrder(1);
		ord.changeOrderStatus("ship");
		ord.verifyReturnEntireOrderButtonDisplayed();
		ord.initiateFullReturn();
		ord.receiveLinkInOrderFormDisplayed();
	}
	
	/********************************************************************
	* Description: verify Return Entire Order button and received link are not displayed without permission 97
	* Author: Tamilselvan
	* Jira Ticket: JMB-6520
	* Status: Complete
	* *******************************************************************/
	@Test(priority = 13, enabled = true)
	public void returnEntireOrderAndOrderReceivedLinkWithoutPermission97() throws FileNotFoundException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.adminLogin();
        adm.selectAdminUser();
		adm.removePermission("In Hand Movements");
		Q_WebElm.myWait(5000);
		Q_OrderForm.ordersMenu("paid");
		ord.editOrder(1);
		ord.changeOrderStatus("ship");
		ord.verifyReturnEntireOrderButtonNotDisplayed();
		ord.initiateFullReturn();
		ord.receiveLinkInOrderFormNotDisplayed();
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


