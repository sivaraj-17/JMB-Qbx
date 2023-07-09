package testcases.hold;

import java.io.FileNotFoundException;
import java.text.ParseException;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_OrderVerification extends Init {
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
    /*********************************************************
    // * Description: Order form clearing and setting order with Payment Review hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority =1)
    public static void paymentReview() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Link Count : " + hold.onHoldMenuItems(tcName));
        System.out.println("Review page Countt : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=payment" );
    }
    /*********************************************************
    // * Description: Order form clearing and setting order with Decision Manager hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 2)
    public static void decisionManager() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Link Count : " + hold.onHoldMenuItems(tcName));
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl  + "/holds.php?ordertype=dm");
    }
    /*********************************************************
    // * Description: Order form clearing and setting order with Price Check hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 3)
    public static void priceCheck() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=price" );
    }
    /*********************************************************
    // * Description: Order form clearing and setting order with Unpaid Invoice hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 4)
    public static void unpaidInvoice() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=invoice" );
        
    }
    /*********************************************************
    // * Description: Order form clearing and setting order with Final Review hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 5)
    public static void finalReview() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=final" );
    }
    /*********************************************************
    // * Description: Order form clearing and setting order with Reshipment hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 6)
    public static void reshipmentHold() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=reship" );
    }
    /*********************************************************
    // * Description: Order form clearing and setting order with Sales Tax hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 7)
    public static void salesTaxIssue() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println(hold.onHoldMenuItems(tcName));
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=sales_tax" );
    }
    /*********************************************************
    // * Description: Order form clearing and setting order with Billing Unpaid hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 8)
    public static void billingUnpaid() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println(hold.onHoldMenuItems(tcName));
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=fraud&status=unpaid" );
    }
    /*********************************************************
    // * Description: Order form clearing and setting order with PayPal hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 9)
    public static void payPalReview() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println(hold.onHoldMenuItems(tcName));
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=paypal" );
    }
    /*********************************************************
    // * Description: Order form clearing and setting order with PayPal hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 10)
    public static void basicHold() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println(hold.onHoldMenuItems(tcName));
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=hold" );
    }
    /*********************************************************
    // * Description: Order form clearing and setting order with Shipping Issues hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 11)
    public static void shippingIssue() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println(hold.onHoldMenuItems(tcName));
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=shipping" );
    }
    /*********************************************************
    // * Description: Order form clearing and setting order with Check Issues hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 12)
    public static void checkIssue() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println(hold.onHoldMenuItems(tcName));
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=checks" );
    }
    /*********************************************************
    // * Description: Order form clearing and setting order with Address Verification hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 13)
    public static void addressVerification() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println(hold.onHoldMenuItems(tcName));
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=address");
    }
    // *********************************************************
    // * Description: Order form clearing and setting order with Starter Pack hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 14)
    public static void starter() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println(hold.onHoldMenuItems(tcName));
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=starter");
    }
    /*********************************************************
    // * Description: Order form clearing and setting order with Security hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 15)
    public static void security() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println(hold.onHoldMenuItems(tcName));
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=security");
    }
    /*********************************************************
    // * Description: Order form clearing and setting order with post shipment hold
    // * Author: Hisham Aridi
    // * status: Complete
    // ********************************************************/
    @Test(priority = 16)
    public static void postShipment() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println(hold.onHoldMenuItems(tcName));
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=post_shipment");
    }
    /*********************************************************
     // * Description: Order form clearing and setting order with oversold hold
     // * Author: Hisham Aridi
     // * status: Complete
     // ********************************************************/
    @Test(priority = 17)
    public static void oversold() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        hold.holdSystem(tcName);
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=oversold" );
    }
    /*********************************************************
     // * Description: Order form clearing and setting order with ACH error hold
     // * Author: Hisham Aridi
     // * status: Complete
     // ********************************************************/
    @Test(priority = 18)
    public static void achError() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        System.out.println("TcName is " + tcName);
        hold.holdSystem(tcName);
        System.out.println(hold.onHoldMenuItems(tcName));
        System.out.println("Review page Count : " + hold.revPageCount());
        if(hold.onHoldMenuItems(tcName) >0){
            hold.dashboardTopOrderEdit();
            ord.orderOnHolFlag(tcName);

            ord.changeHistoryPage();
            ord.orderOnHolFlag(tcName);
            ord.resetHistoryPage();
        }
        else{
            System.out.println("Currently there are no order on hold  for: " + tcName);
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), adminUrl + "/holds.php?ordertype=echeck");
    }
    
    /*********************************************************************
	 * Description: Verify the ability to manually flag registered customers via a Yes/No 
	 * dropdown in the admin customer page. Checks if the placed order after the hold
	 * is applied, has the message displayed & hold enabled.
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-4521
	 * 
	 * @throws FileNotFoundException
	 ********************************************************************/

	@Test(priority = 19)
	public void abilityToFlagCustomerOrder_registered() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		String holdReason = "Automated testing";
		String registeredID = "qa@jmbullion.com";
		li.testStarted(tcName);
		li.adminLogin();
		cust.customerPage(registeredID);
		hold.setOperationsHold(holdReason);
		driver.navigate().to(adminUrl + "/holds-dashboard.php");
		Assert.assertTrue(Q_WebElm.idDisplayed(adminProps, "holds.dashboard.operationHold.id"));
		chk.selectItem("perth10g", 1);
		li.newTabLaunch("/ato/smarty.php");
		driver.navigate().to(adminUrl);
		cust.customerPage(registeredID);
		hold.editTopOrder_custPage();
		Assert.assertTrue(ord.verifyHold("Operations Hold"), "The hold is disabled");
		cust.customerPage(registeredID);
		hold.removeOperationsHold();
	}
	
	/*********************************************************************
	 * Description: Verify the ability to manually flag registered customers via a Yes/No 
	 * dropdown in the admin customer page. Check if the initiated buyback has the 
	 * message displayed.
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-4521
	 ********************************************************************/
	@Test(priority = 20)
	public void abilityToFlagCustomerBuyback_registered() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		String holdReason = "Automated testing";
		String registeredID = "qa@jmbullion.com";
		li.testStarted(tcName);
		li.adminLogin();
		cust.customerPage(registeredID);
		hold.setOperationsHold(holdReason);
		bb.bbMenuItem("new");
		bb.newBuyBack(registeredID, 2);
		bb.showAddresses();
		bb.selectAddress(2);
		bb.selectBank(1);
		bb.selectPayment("WIRE");
		bb.selectDefaultCard(1, 6);
		bb.addBbProduct(2, "10", "1 oz Canadian Palladium Maple Le");
		bb.reportable();
		bb.premiumValidation();
		bb.saveBb();
		hold.buybackEmailSearchAndEdit(registeredID);
		hold.verifyOperationHoldMsg_isDisplayed_buyback(holdReason);
		cust.customerPage(registeredID);
		hold.removeOperationsHold();
	}

	/*********************************************************************
	 * Description: Verify the ability to manually flag guest customers via a Yes/No 
	 * dropdown in the admin customer page. And check if the placed order before the hold
	 * was applied, has the message displayed.
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-4521
	 * 
	 * @throws FileNotFoundException
	 ********************************************************************/
	@Test(priority = 21)
	public void abilityToFlagCustomerOrder_guest() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		String holdReason = "Automated testing";
		String guestID = "jmbqa6@jmbullion.com";
		li.testStarted(tcName);
		driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf/");
		chk.addItemToCart(6);
		chk.selectPaymentType("credit card");
		chk.selectcheckoutBtn("top");
		hold.bridgeGuest();
		hold.guestCheckout(guestID);
		chk.completeOrder();
		li.adminLogin();
		ord.ordersMenu("list");
		ord.editTopOrder();
		hold.guestPage(1);
		hold.setOperationsHold(holdReason);
		ord.ordersMenu("list");
		ord.editTopOrder();
		hold.verifyOperationHoldMsg_isDisplayed_order(holdReason);
	}

	/*********************************************************************
	 * Description: Verify the ability to manually flag guest customers via a Yes/No 
	 * dropdown in the admin customer page. Checks if the placed order after the hold
	 * is applied, has the message displayed. Again checks if the order placed after the
	 * hold was applied has hold enabled in order form.
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-4521
	 * 
	 * @throws FileNotFoundException
	 ********************************************************************/
	@Test(dependsOnMethods = "abilityToFlagCustomerOrder_guest")
	public void verifyFlagMsg_guest() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		String holdReason = "Automated testing";
		String guestID = "jmbqa6@jmbullion.com";
        Controls.testStarted(tcName);
		driver.navigate().to(baseUrl + "/2019-canadian-silver-maple-leaf/");
		chk.addItemToCart(6);
		chk.selectPaymentType("credit card");
		chk.selectcheckoutBtn("top");
		hold.bridgeGuest();
		hold.guestCheckout(guestID);
		chk.completeOrder();
		li.newTabLaunch("/ato/smarty.php");
		li.adminLogin();
		ord.ordersMenu("list");
		ord.editTopOrder();
		hold.verifyOperationHoldMsg_isDisplayed_order(holdReason);
		Assert.assertTrue(ord.verifyHold("Operations Hold"), "The hold is disabled");
		hold.guestPage(2);
		hold.removeOperationsHold();
	}
	
	/********************************************************************
	 * Description: verify Mail Forwarder Hold is working properly
	 * Author: Tamilselvan A
	 * Jira Ticket: JMB-6927
	 * Status: Complete
	 * @throws FileNotFoundException 
	 * *******************************************************************/
	@Test(priority = 23, enabled = true)
	public void addCapabilityToDetectIfShipAddressMailBoxStore() throws FileNotFoundException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		ord.frontendLogin(5);
		Q_WebElm.myWait(5000);
		ord.regularOrderToCheckout("silverEagle1994 & perth10g", 5, "97520");
		ord.completeOrder();
		ord.logoutUser();
		Q_WebElm.myWait(3000);
		li.adminLogin();
		ord.ordersMenu("list");
		String ordNo = ord.editTopOrder();
		String url=driver.getCurrentUrl();
		Controls.newTab();
		Controls.switchTab(1);
		driver.navigate().to(baseUrl + "/ato/smarty.php");
		driver.close();
		Controls.switchTab(0);
		driver.navigate().refresh();
		hold.verifyMailForwarderHoldChecked();
		hold.verifyMailForwarderAddDisplayed();
        Q_OrderForm.ordersMenu("holdSystem");
        hold.clickMailForwarderHold();
        hold.verifyCheckedOrdIdInHoldSystem(ordNo, "Mail Forwarder Address");
        driver.get(url);
        Q_WebElm.myWait(2000);
        hold.uncheckMailForwarder();
        driver.navigate().refresh();
        hold.verifyMailForwarderUnchecked();
        hold.verifyMailForwarderAddNotDisplayed();
        Q_OrderForm.ordersMenu("holdSystem");
        hold.clickMailForwarderHold();
        hold.verifyUncheckedOrdIdInHoldSystem(ordNo, "Mail Forwarder Address");
	}
	
	/********************************************************************
	 * Description: verify Address Change Hold is working fine after change the ship add in order form
	 * Author: Tamilselvan A
	 * Jira Ticket: JMB-3692
	 * Status: Complete
	 * @throws FileNotFoundException 
	 * *******************************************************************/
	@Test(priority = 24, enabled = true)
	public void addressChangeStandaloneHold() throws FileNotFoundException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.adminLogin();
		Q_OrderForm.ordersMenu("pending");
		String ordNo=ord.editOrder(1);
		String url=driver.getCurrentUrl();
		ord.changeOrderStatus("paid");
		hold.addressChangeHoldDisplayed();
        ord.newShipping();
        hold.verifyAddressChangeHoldChecked();
        hold.clickChangeHistory();
		Controls.switchTab(1);
        Q_WebElm.myWait(2000);
        hold.shippingAddressChangedDisplayedInHistory();
        Q_OrderForm.ordersMenu("holdSystem");
        hold.clickAddressChangeHold();
        hold.verifyCheckedOrdIdInHoldSystem(ordNo, "Address Change Hold");
        driver.get(url);
        Q_WebElm.myWait(2000);
        hold.uncheckAddressChangeHold();
        driver.navigate().refresh();
        hold.verifyAddressChangeHoldUnchecked();
        Q_OrderForm.ordersMenu("holdSystem");
        hold.clickAddressChangeHold();
        hold.verifyUncheckedOrdIdInHoldSystem(ordNo, "Address Change Hold");
	}
	
	/************************************************************************************************
     * Description: Verify guest order has Ops hold enabled when set No in Cust page
     * Author: Ilakiya
     * Status: Completed
     * Jira Ticket: JMB - 7106
     **************************************************************************************************/
	
	@Test(priority = 25, enabled = true)
	public void guestCustomerOpsHoldEnabled() throws FileNotFoundException  {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		String holdReason = "Automated testing";
		String guestID = "jmbqaguestautomation@jmbullion.com";
		String product = baseUrl + "/2019-canadian-silver-maple-leaf/";
		hold.placeAnOrderAsGuest(guestID, product, 6, "credit card");		
		Controls.adminLogin();
		adm.adminCustomerSearch("email", guestID);	
		adm.formXp("adm.adminActiveBtn.xp");
		hold.guestPage(1);
		hold.setOperationsHold(holdReason);
		driver.navigate().to(baseUrl);	
		Q_OrderForm.logoutUser();
		hold.placeAnOrderAsGuest(guestID, product, 6, "credit card");
		driver.get(adminUrl);
		Q_OrderForm.ordersMenu("list");
		ord.editTopOrder();
		hold.verifyOperationsHoldIsChecked(true, 4);
		Assert.assertTrue(Q_WebElm.xpSelected(adminProps, "guest.operationsHold.xp"));
		hold.guestPage(2);
		hold.removeOperationsHold();
		driver.navigate().to(adminUrl);
		adm.adminCustomerSearch("email", guestID);	
		adm.formXp("adm.adminActiveBtn.xp");
		hold.verifyOperationsHoldIsChecked(false, 4);
		Assert.assertFalse(Q_WebElm.xpSelected(adminProps, "guest.operationsHold.xp"));
	}
	
	/************************************************************************************************
     * Description: Guest Customer Ops Hold
     * Author: Vignesh
     * Status: Completed
     * Jira Ticket: JMB - 7554
     **************************************************************************************************/
	@Test(priority = 26, enabled = true)
	public void verifyTimestampforGuestCustomerOpsHold_JMB7554() throws FileNotFoundException, ParseException  {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName); 
		String holdReason = "Automated testing";
		String guestID = "jmbqaguest@jmbullion.com";
		Controls.adminLogin();
		adm.adminCustomerSearch("email", guestID);	
		adm.formXp("adm.adminActiveBtn.xp");
		hold.guestPage(1);
		hold.setOperationsHold(holdReason);
		Controls.switchTab(0);
		driver.navigate().refresh();
		hold.verifyOperationHoldMsgAndTimestamp_isDisplayed_order(holdReason, hold.getCurrentESTDateAndTime());;
	}
	
	/********************************************************************
	 // * Description: Verify the Address and Verification Hold Enhancement
	 // * Author: Sivaraj
	 // * Param : NA
	 // * Jira Ticket: JMB-7279
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 27, enabled = true)
	public void verifyHoldEnhancement() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		String orderId = chk.placeAnOrder("/2016-3-oz-30th-anniversary-silver-eagle-coin-bar/","credit card");
		Q_WebElm.myWait(1000);
		driver.navigate().to(baseUrl + "admin/");
		Q_OrderForm.ordersMenu("list");
		ord.searchOrderAndNavigateToCustomerPage(orderId);
		ord.payAllUnpaidInvoicesForCustomer();
		ord.uncheckAllOperationHold();
		ord.changeOrderStatus("paid");
		String url = driver.getCurrentUrl();
		String productID = url.substring(50, 57);
		Controls.newTabLaunch("admin/shipping-test-file.php?site=jmbullion&id=" + productID);
		ord.verifyShippingMsgStatus("Ready to ship");
		driver.close();
		Controls.switchTab(1);
		ord.orderOnHolFlag("addressVerification");
		Q_WebElm.myWait(2000);
		driver.navigate().refresh();
		Assert.assertTrue(Q_WebElm.xpRetText(adminProps,"adm.editOrder.allLegacyStatus").equals("Contains word Gold"));
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
