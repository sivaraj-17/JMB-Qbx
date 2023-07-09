package testcases.guest;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;

import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.io.FileNotFoundException;

public class Q_JMB_GuestCheckout extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();
    static Q_JMB_AdminObjects admin = new Q_JMB_AdminObjects();

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
    // * Description: Turns 3DS off
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1, enabled=false)
    public void turn3DSOff() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_Controls.adminLogin();
        admin.adminMenu("settings");
        Q_JMB_WebElm.xp(jmbProps, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("off");
        Q_JMB_WebElm.myWait(1000);
    }
    
    /*******************************************************************
    // * Description: Verify Existing email attempt prompts user to login
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2)
    public static void existingEmail () throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("1 oz American Gold Eagle Coin",1);
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa1auto@jmbullion.com");
        chk.existingEmail();

    }
    /*******************************************************************
    // * Description: Verify guest user can complete guestCheckout using credit card payment method no tax or shipping charges
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3)
    public static void guestCreditCard () throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.silverPeaceSilverDollarCoi("2");
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qaguesttest@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.completeOrder();
        chk.thankYouPage();
    }
    /*******************************************************************
    // * Description:  Verify guest user can complete guestCheckout using bank wire payment method
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 4)
    public static void guestBankwire () throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("100 oz Geiger Security", 3);
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectPaymentType("wire");
        cart.selectcheckoutBtn("top");
        chk.bridgeGuest();
        chk.guestEmail("qaguesttest@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.completeOrder();
        chk.thankYouPage();
    }
    /*******************************************************************
    // * Description:  Verify guest user can complete guestCheckout using paper check payment method
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 5)
    public static void guestPaperCheck () throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.chinesePanda("3");
        Q_JMB_CategoryObjects.copperUSQuarter("10");
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        chk.bridgeGuest();
        chk.guestEmail("qaguesttest@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /*******************************************************************
     * Description: Verifies the correct PDP is launched when product 
     * description is clicked on Thank You page for guest order.
     * Author: Asfi Khaliq
     * Status: Complete
     * Ticket: JMB-3594
     ********************************************************************/
	@Test(priority = 6)
	public void verifyProductTitleOnThankYouPage_guest() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		guestCreditCard();
		chk.verifyProductDescOnThankYouPage();
	}
    
	/*******************************************************************
     * Description: Verifies the correct PDP is launched when product 
     * image is clicked on Thank You page for guest order.
     * Author: Asfi Khaliq
     * Status: Complete
     * Ticket: JMB-3594
     ********************************************************************/
	@Test(priority = 7)
	public void verifyProductImageOnThankYouPage_guest() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		guestCreditCard();
		chk.verifyProductImageOnThankYouPage();
	}
	
	/********************************************************************
	 * Description: Verify successful guest order with new billing address
	 * Author: Tamilselvan A
 	 * Status: Complete   
	 * Ticket: JMB-4230
	 *******************************************************************/
    @Test(priority = 8,enabled=true)
    public void guestOrderBillingAddress() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectcheckoutBtn("top");
        chk.bridgeGuest();
        chk.guestEmail("jmbqabill@gmail.com");
        chk.shippingAddressForm(7);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.verifyBillingAddressField();
        chk.changeBillingAddressButton();
        chk.clickAddNewBillAddress();
        chk.billingAddressForm(6);
        chk.saveBillingAddress();
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /******************************************************************************
	 * Description:To verify if a registered customer is able to checkout as guest 
	 * Author: Ilakiya
	 * Status: Complete
	 * Ticket: JMB-7605
	 * ****************************************************************************/
	@Test(priority = 9, enabled=true)
	public void verifyRegisteredCustomerAbleToCheckoutAsGuest() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		String expectedErrorMsg="You seem to have an account with us. Please login and complete checkout or use a different email address";
		Q_JMB_Controls.testStarted(tcName);
		Q_JMB_CategoryObjects.silverPeaceSilverDollarCoi("2");
		chk.selectItem("1 oz US Quarter Copper", 10);
		cart.selectPaymentType("echeck");
		cart.selectcheckoutBtn("bottom");
		chk.bridgeGuest();
		chk.guestEmail("qa+1jmb@jmbullion.com");
		Q_JMB_WebElm.myWait(2000);	
		acc.closeLoginPopup("chk.loginPopupClose.xp");
		Q_JMB_WebElm.myWait(3000);	
		acc.closeLoginPopup("chk.loginPopupClose.xp");
		chk.shippingAddressForm(6);
		chk.saveShippingAddress();
		chk.completeOrder();
		Q_JMB_WebElm.myWait(5000);	
		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "chk.guestLoginPopup.xp"));
		Assert.assertTrue(Q_JMB_WebElm.xpRetText(jmbProps, "chk.guestLoginErrorMessage.xp").contains(expectedErrorMsg), "Guest is allowed to place order");
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
