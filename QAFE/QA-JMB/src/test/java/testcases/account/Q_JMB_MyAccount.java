package testcases.account;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.io.FileNotFoundException;

public class Q_JMB_MyAccount extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_AdminObjects adm = new Q_JMB_AdminObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
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

    /*******************************************************************
    // * Description: Verify user registration via the registration modal
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =1)
    public static void registerNewUser() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.accountRegistration(4);
        acc.deleteUser();
        
    }
    /*******************************************************************
    // * Description: Verify user registration after user completes guest checkout.
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =2)
    public static void registerGuestUser() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.silverPeaceSilverDollarCoi("2");
        Q_JMB_CategoryObjects.copperUSQuarter("10");
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
        chk.bridgeGuest();
        chk.guestEmail("qa5auto@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.completeOrder();
        acc.checkoutRegistration(4, "jm.createRegBtn.id");
    }
    /*******************************************************************
    // * Description: Verify current users have no orders
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =3)
    public static void ordersNoOrders(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(2);
        acc.accountTabs("orders");
        acc.orderActions("noOrders");
    }
    /*******************************************************************
    // * Description: Verify that My account page will display orders and pagination is active when the maximum per page is reached
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 4)
    public static void ordersPaging() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(6);
        acc.accountTabs("orders");
        acc.orderActions("pagination");

    }

    /*******************************************************************
    // * Description: Verify that credit cards in the customer profile are listed on My Account / payments page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 5)
    public static void savedCreditCardList() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        acc.myAccount("payments");
        acc.paymentMethods("saved cards");

    }
    /*******************************************************************
    // * Description: This is to verify can set their default payment type in the account page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 6)
    public static void setCreditCardDefault() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        acc.myAccount("payments");
        acc.paymentMethods("change default");

    }
    /*******************************************************************
    // * Description: This test case verifies user can add credit cards from their customer profile
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 7)
    public static void addCard() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(5);
        acc.myAccount("payments");
        acc.paymentMethods("add card");
    }
    /*******************************************************************
    // * Description: This test case verifies user can delete credit cards from their customer profile
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 8)
    public static void deleteCard() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(5);
        acc.myAccount("payments");
        acc.paymentMethods("delete card");
    }

    /*******************************************************************
    // * Description: This test case verifies user can edit shipping address in their customer profile
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 9)
    public static void editAccAddress() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(5);
        acc.myAccount("addresses");
        acc.addressTab("edit address");
    }
    /*******************************************************************
    // * Description: This test case verifies user can add new shipping address their customer profile
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 10)
    public static void addValidAddress() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(5);
        acc.myAccount("addresses");
        acc.addressTab("add new address");
    }
    /*******************************************************************
    // * Description: This test case verifies user can delete shipping address in their customer profile
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 11)
    public static void deleteAccAddress() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(5);
        acc.myAccount("addresses");
        acc.addressTab("delete address");
    }
    /*******************************************************************
    // * Description: Verify that credit cards in the customer profile are listed on My Account / payments page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 12)
    public static void paymentAch() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(28);
        acc.myAccount("payments");
        acc.paymentMethods("ach payment");

    }
    /*******************************************************************
    // * Description: Verify link and pop up to indicate payment is sent.
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 13)
    public static void switchPcToAch() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(3);
        Q_JMB_CategoryObjects.goldEagle("1");
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        chk.completeOrder();
        acc.myAccount("orders");
        acc.orderActions("switch to ach");
    }
    /*******************************************************************
    // * Description: Verify user can switch Paper check order to ACH payment method in the user My Account page.
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 14)
    public static void mailCheck() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
        acc.loginUser(3);
        Q_JMB_CategoryObjects.goldEagle("1");
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        chk.completeOrder();
        acc.myAccount("orders");
        acc.orderActions("mail check");
    }
    /*******************************************************************
     // * Description: This test case verifies user can delete 3rd product from alerts tab
     // * Author:
     // * Status: Complete
     *  Ticket : JMB-6054(Improvement to alert's tab formatting)
     */
    @Test (priority = 15,enabled = true)
    public static void alertTabFormatting() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(21);
        acc.addProductsToAlert();
        acc.removeProductsFromAlert();
    }
    /*******************************************************************
     // * Description: Verifies Buy Again Feature
     // * Author:
     // * Status: Complete
     *  Ticket : JMB-6056(Buy Again from my account view orders)
     * @throws Exception
     */

    @Test (priority = 16,enabled = true)
    public static void verifyBuyAgain()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(29);
        acc.myAccount("orders");
        acc.buyAgain();
        chk.selectCard("amex", "4321");
//        chk.cvvCardType(4);
        Q_JMB_WebElm.myWait(1000);
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /********************************************************************
	// * Description  : Verify Deletion of Credit Cards with order incomplete
	// * Author       : Sivaraj
	// * Jira Ticket  : JMB-6778
	// * Status       : Complete
	//*******************************************************************/
	@Test(priority = 17, enabled = true)
	public void verifyDeletionCreditCardsOrderIncomplete() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(56);
		chk.selectItem("1 oz American Gold Eagle Coin", 1);
		cart.selectPaymentType("wire");
		cart.selectcheckoutBtn("top");
		chk.completeOrder();
		Q_JMB_WebElm.myWait(2000);
		driver.navigate().to(baseUrl+"/my-account/");	
		acc.verifyMyAccountOrderStatus();
		acc.verifyDeleteLink(false);
	}

	/********************************************************************
	// * Description  : Verify Deletion of Credit Cards with order having unpaid invoice
	// * Author       : Sivaraj
	// * Jira Ticket  : JMB-6778
	// * Status       : Complete
	//********************************************************************/
	@Test(priority = 18, enabled = true)
	public void verifyDeletionCreditCardsOrderUnpaidInvoice() throws FileNotFoundException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		Q_JMB_Controls.adminLogin();
		String email = "qa+ccunpaidinvoice@jmbulllion.com";
		adm.adminCustomerSearch("email", email);
		adm.adminViewAllOrders();
		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(ticketsProp,"cust.unpaidInvoiceHeader.xp"));
		Q_JMB_Controls.adminLogout();
		acc.loginUser(57);
		acc.verifyDeleteLink(false);
	}

	/********************************************************************
	// * Description  : Verify Deletion of Credit Cards with complete orders
	// * Author       : Sivaraj
	// * Jira Ticket  : JMB-6778
	// * Status       : Complete
	//*******************************************************************/
	@Test(priority = 19, enabled = true)
	public void verifyDeletionCreditCardsOrderComplete() throws FileNotFoundException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		Q_JMB_Controls.adminLogin(); 
		String email ="qa+completeorders@jmbulllion.com"; 
		adm.adminCustomerSearch("email",email); 
		adm.adminViewAllOrders(); 
		adm.adminEditCustomerOrder(1);
		acc.changeOrderStatus("completed");
		Q_JMB_WebElm.myWait(2000);
		Q_JMB_Controls.adminLogout();
		acc.loginUser(58);
		acc.verifyDeleteLink(true);
	}
    @AfterTest
    public void endReport(){
    }
    @AfterMethod
    public void tearDown() throws Exception {
        Q_JMB_CartPageObjects.removeItems();
        Q_JMB_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}


