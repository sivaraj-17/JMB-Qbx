package testcases.guest;

import java.io.FileNotFoundException;

import org.testng.annotations.*;

import pageObjects.Q_PM_AdminPmSteps;
import pageObjects.Q_PM_CheckoutSteps;
import pageObjects.Q_PM_WebElm;
import testcases.cart.Q_PM_AddToCart;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

public class Q_PM_GuestCheckout extends Q_PM_Init {

    @BeforeClass
    public void tcSetup (){

    }
    
    @BeforeMethod
    public void report() throws Exception {
        Q_PM_Init.setItUp();
    }
    
    @BeforeTest
    public void setTest() throws Exception {
    }
    
    Q_PM_AdminPmSteps admin = new Q_PM_AdminPmSteps();
    Q_PM_CheckoutSteps chk = new Q_PM_CheckoutSteps();
    
    /*******************************************************************
    // * Description: Turns 3DS off
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1, enabled=false)
    public void turn3DSOff() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_Controls.adminLoginPM();
        admin.adminMenu("settings");
        Q_PM_WebElm.xp(pmQaProps, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("on");
        Q_PM_WebElm.myWait(1000);
    }

    /*******************************************************************
    // * Description: Verify guest user can not use already registered email as guest
     // * Author:
     // * Status: Complete
    /*******************************************************************/
    @Test(priority = 2)
    public static void existingEmail()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.silver_2_2553739("16");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.bridgePage("existing email", "chk.checkoutNowGuest.xp");
    }
    
    /*******************************************************************
    // * Description: Verify guest user can complete checkout using credit card payment method
     // * Author:
     // * Status: Complete
    /*******************************************************************/
    @Test(priority = 3)
    public static void guestCc()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.silver_2_2553739("16");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.bridgePage("guest", "chk.checkoutNowGuest.xp");
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.completeOrder("chk.finishPlaceOrder.id");
    }
    
     /*******************************************************************
     // * Description: Verify guest user can complete checkout using bank wire payment method
     // * Author:
     // * Status: Complete
     /*******************************************************************/
    @Test(priority = 4)
    public static void guestBw()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_3_2553276("8");
        Q_PM_CheckoutSteps.selectPaymentType("bacs");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.bridgePage("guest", "chk.checkoutNowGuest.xp");
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.completeOrder("chk.finishPlaceOrder.id");
    }
    
     /*******************************************************************
     // * Description: Verify guest user can complete checkout using personal check payment method
     // * Author:
     // * Status: Complete
     /*******************************************************************/
    @Test(priority = 5)
    public static void guestPc()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.platinum_3_2566983("4");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.bridgePage("guest", "chk.checkoutNowGuest.xp");
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.completeOrder("chk.finishPlaceOrder.id");
    }
    
     /*******************************************************************
     // * Description: PayPal Login and Checkout
     // * Author:
     // * Status: Complete
     /*******************************************************************/
    @Test(priority = 6)
    public static void PayPal()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.silver_2_2553739("16");
        Q_PM_CheckoutSteps.selectPaymentType("paypal_express");
        Q_PM_CheckoutSteps.payPal("test1@jmbullion.com", "2014gold");
        Q_PM_CheckoutSteps.completeOrder("chk.finishPlaceOrder.id");
    }
    
    /*******************************************************************
	 * Description: Verifies the correct PDP is launched when product description is
	 * clicked on Thank You page of guest order. 
	 * Author: Asfi Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-3594
	 ********************************************************************/
	@Test(priority = 7)
	public void verifyProductTitleOnThankYouPage_guest() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_PM_Controls.testStarted(tcName);
		guestBw();
		Q_PM_CheckoutSteps.isOrderComplete(tcName);
		chk.verifyProductDescOnThankYouPage();
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
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.silver_2_2553739("16");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.bridgePage("guest", "chk.checkoutNowGuest.xp");
        Q_PM_CheckoutSteps.validateAddress();
        chk.verifyBillingAddressField();
        chk.changeBillingAddressButton();
        chk.clickAddNewBillAddress();
        chk.billingAddressForm(6);
        chk.saveBillingAddress();
        Q_PM_CheckoutSteps.completeOrder();
    }  
    
    @AfterTest
    public void endReport(){
    }
    
    @AfterMethod
    public void tearDown() throws Exception {
        Q_PM_Controls.tearDown();
    }
    
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
