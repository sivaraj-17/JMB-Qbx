package testcases.registered;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Q_PM_AccountSteps;
import pageObjects.Q_PM_AdminPmSteps;
import pageObjects.Q_PM_CartSteps;
import pageObjects.Q_PM_CheckoutSteps;
import pageObjects.Q_PM_WebElm;
import testcases.cart.Q_PM_AddToCart;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class Q_PM_RegisteredCheckout extends Q_PM_Init {
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
        admin.adjust3dsSettings("off");
        Q_PM_WebElm.myWait(1000);
    }

    /*******************************************************************
    // * Description: Persistent cart
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority =2)
    public void persistentCart(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(29);
        Q_PM_AddToCart.gold_1_2553140("1");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_AccountSteps.accountMenu("LOGOUT");

        Q_PM_AccountSteps.loginUser(29);
        Q_PM_WebElm.myWait(2000);

        Assert.assertNotEquals(Q_PM_WebElm.xpRetText(pmQaProps, "cart.quickCartCount.xp"),("0"));
        Q_PM_CartSteps.deleteItems();
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
    // * Description: Registered User Login from bridge page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 3)
    public void bridgeLogin() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_4_2569050("1");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.bridgePage("bridgeUser", "chk.bridge.checkout.xp");
        Q_PM_WebElm.myWait(3000);
        Q_PM_Controls.scrolUpPixel(500);
        Q_PM_CheckoutSteps.completeOrder();
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
    // * Description: Registered User checkout payment type credit card
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 4)
    public void regCreditCard() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(21);
        Q_PM_AddToCart.copper_1_2563821("10");
        Q_PM_AddToCart.silver_2_2553739("11");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());
        //System.out.println(prices);
        Q_PM_CheckoutSteps.cardSelection("defaultCard");
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());
        //System.out.println(orderPrices);
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
    // * Description: Verify Order Status
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 5)
    public void pendingOrder() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(29);
        Q_PM_AddToCart.silver_2_2553739("25");
        Q_PM_AddToCart.copper_1_2563821("10");
        //Q_PM_AddToCart.copper_2_2563818("10");
        Q_PM_CheckoutSteps.selectPaymentType("bacs");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        //Q_PM_CheckoutSteps.cardSelection("visa");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());
        //System.out.println(prices);
        Q_PM_CheckoutSteps.completeOrder();
        //Q_PM_CheckoutSteps.tyOrderStatus("processing payment");
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());
        //System.out.println(orderPrices);
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        //Q_PM_CheckoutSteps.completeStatus("processing payment");
        Q_PM_AccountSteps.myAccountMenu("My Orders");
        Q_PM_WebElm.myWait(4000);
        Assert.assertEquals(Q_PM_WebElm.xpRetText(pmQaProps, "acc.myOrdersStatus.xp"), ("Payment Pending"));
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
    // * Description: Verify Order Status is paid
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 6)
    public void paidOrder() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(27);
        Q_PM_AddToCart.gold_3_2553276("2");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.cardSelection("Amex");

        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        //Q_PM_CheckoutSteps.tyOrderStatus("confirmed payment");
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);

       // Q_PM_CheckoutSteps.completeStatus("confirmed payment");
        Q_PM_AccountSteps.myAccountMenu("My Orders");
        Q_PM_WebElm.myWait(2000);
//        Assert.assertEquals(WebElm.xpRetText(pmQaProps, "myOrdersStatus.xp"), ("Payment Processing"));
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
    // * Description: Verify User can swith from default card
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 7)
    public void regSwitchCard() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(21);
        Q_PM_AddToCart.gold_2_2555362("3");
        Q_PM_AddToCart.copper_1_2563821("50");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.cardSelection("switchCard");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());

        Q_PM_Controls.scrolDownPixel(600);
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());

        Q_PM_CheckoutSteps.verifyOrderCharges(prices, orderPrices);
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
    // * Description: Registered User can switch shipping address in checkout
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 8)
    public void regSwitchAddress() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(21);
        Q_PM_AddToCart.gold_1_2553140("2");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.addressSelection("switch address");
        Q_PM_Controls.scrolDownPixel(600);
        Q_PM_CheckoutSteps.completeOrder();
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
    // * Description: Registered User edit shipping address phone number during checkout verify phone number is displayed in address
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 9)
    public void editShippingAdd() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(22);
        Q_PM_AddToCart.gold_2_2555362("1");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.editPhoneCheckout("chk.shContinueWithAdd.id");
        Q_PM_Controls.scrolDownPixel(600);
        Q_PM_CheckoutSteps.completeOrder();
    }
    /*******************************************************************
    // * Description: Apply Apply $10.00 and verify charges
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 10)
    public void applyDiscount() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(21);
        Q_PM_AddToCart.gold_3_2553276("2");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CartSteps.applyCoupon();
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.cardSelection("defaultCard");
        Q_PM_CheckoutSteps.completeOrder();
        Q_PM_WebElm.myWait(2000);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        System.out.println( "Oerder Discount" + Q_PM_WebElm.xpRetText(pmQaProps, "chk.orderDiscount.xp"));
        Assert.assertEquals(String.valueOf(Q_PM_WebElm.xpRetText(pmQaProps, "chk.orderDiscount.xp").replaceAll("[^0-9?!\\.]","")),"10.00");
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
    // * Description: Minimum Shipping Charges applied
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 11)

    public void minShippingApplied() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(22);
        Q_PM_AddToCart.silver_1_2553427("1");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.cardSelection("defaultCard");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(reviewPrices, orderPrices);
        Float shippCharges = Float.valueOf(orderPrices.get(1));

        Assert.assertEquals(String.valueOf(shippCharges),"7.99");
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
    // * Description: Verify Shipping Taxes
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 12)
    public void shippingTaxes() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        DecimalFormat df = new DecimalFormat("#.00");
        Q_PM_AccountSteps.loginUser(23);
        Q_PM_AddToCart.silver_2_2553739("6");
        Q_PM_AddToCart.copper_1_2563821("10");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.cardSelection("defaultCard");
        Q_PM_CheckoutSteps.shippinOptions("usps priority");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());
        System.out.println(reviewPrices);
        Float revTax = Float.valueOf(df.format(reviewPrices.get(1)));
        Float shippinTax = Float.valueOf(Q_PM_WebElm.idRetText(pmQaProps, "chk.revShiipingTax.id").replaceAll("[^0-9?!\\.]",""));

        Float calTax = Float.valueOf(df.format(reviewPrices.get(1) + shippinTax));
        System.out.println("Review Page Tax " + revTax);
        System.out.println("Total Tax =" + calTax);
        Float totalRevTax= shippinTax + revTax;
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());
        Float shippCharges = Float.valueOf(orderPrices.get(2));
        Assert.assertEquals(Float.valueOf(df.format(orderPrices.get(1))),Float.valueOf(df.format(totalRevTax)));
        System.out.println("Shipping Charges for 3 Day Air " + shippCharges) ;
        Assert.assertEquals(String.valueOf(shippCharges),"12.99");
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
    // * Description: Shipping Upgrade to usps priority
    /// * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 13)
    public void shipUpgradePriority() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(21);
        Q_PM_AddToCart.gold_3_2553276("5");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.cardSelection("defaultCard");
        Q_PM_CheckoutSteps.shippinOptions("usps priority");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(reviewPrices, orderPrices);
        Float shippCharges = Float.valueOf(orderPrices.get(1));

        Assert.assertEquals(String.valueOf(shippCharges),"7.99");
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
    // * Description: Apply 3-Day Air shipping and verify charges
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 14)
    public void shippingUpgrade3DayAir() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(21);
        Q_PM_AddToCart.silver_1_2553427("4");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.cardSelection("defaultCard");
        Q_PM_CheckoutSteps.shippinOptions("ups 3 day");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(reviewPrices, orderPrices);
        Float shippCharges = Float.valueOf(orderPrices.get(1));
        Assert.assertEquals(String.valueOf(shippCharges),"12.99");
        //AccountSteps.accountMenu("LOGOUT", 3);
    }

    /*******************************************************************
    // * Description: Registered User checkout payment type paper check
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 15)
    public void regPaperCheck() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(29);
        Q_PM_AddToCart.gold_1_2553140("1");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_Controls.scrolUpPixel(500);
        Q_PM_CheckoutSteps.completeOrder();
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
    // * Description: Registered User checkout payment type bank wire
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 16)
    public void regBankWire() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(29);
        Q_PM_AddToCart.gold_1_2553140("4");
//        AddToCart.silver_3_2568377("2");
        Q_PM_CheckoutSteps.selectPaymentType("bacs");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_Controls.scrolUpPixel(500);
        Q_PM_CheckoutSteps.completeOrder();
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
    // * Description: Registered User checkout payment type ACH
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 17)
    public void regAch() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(28);
        Q_PM_AddToCart.gold_1_2553140("1");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim_echeck");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_WebElm.myWait(1000);
                Q_PM_WebElm.xp(pmQaProps, "chk.consent.xp");
        Q_PM_WebElm.idExecutor(pmQaProps, "chk.finishPlaceOrder.id");
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
    // * Description: Switch paper check to ACH
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 18)
    public void switchPcToAch() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(28);
        Q_PM_AddToCart.gold_3_2553276("2");
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_WebElm.myWait(1000);
        Q_PM_WebElm.xp(pmQaProps, "chk.consent.xp");
        Q_PM_WebElm.idExecutor(pmQaProps, "chk.finishPlaceOrder.id");
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        System.out.println(orderPrices.get(1));
        Q_PM_CheckoutSteps.switchACH();
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
    // * Description: Switch wire payment to ACH
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 19, enabled = false)
    public void switchWireToAch() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(28);
        Q_PM_AddToCart.gold_4_2569050("2");
        Q_PM_CheckoutSteps.selectPaymentType("bacs");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        System.out.println(orderPrices.get(1));
        Q_PM_CheckoutSteps.switchACH();
        //AccountSteps.accountMenu("LOGOUT", 3);
    }
    /*******************************************************************
     // * Description: Verify no shipping for order under $299 with coupon
     // * Author:
     // * Jira Ticket: JMB-5894, JMB-6079
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 20)
    public static void noShippingOrderOver299WithCoupon()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(21);
        Q_PM_AddToCart.gold_5_gram(6);
        Q_PM_AddToCart.copper_1_2563821("5");
        Q_PM_CheckoutSteps.selectPaymentType("paypal_express");
        Q_PM_CartSteps.applyCoupon("HSD","100.00");

        Q_PM_CheckoutSteps.payPal("test1@jmbullion.com", "2014gold");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListTax());
        System.out.println( "Order Discount" + Q_PM_WebElm.xpRetText(pmQaProps, "chk.orderDiscount.xp"));
        Assert.assertEquals(String.valueOf(Q_PM_WebElm.xpRetText(pmQaProps, "chk.orderDiscount.xp").replaceAll("[^0-9?!\\.]","")),"100.00");
        Q_PM_CheckoutSteps.verifyOrderCharges(reviewPrices, orderPrices);
        Float shippCharges = Float.valueOf(orderPrices.get(2));

        Assert.assertEquals(String.valueOf(shippCharges),"0.0");

    }
    
    /*******************************************************************
	 * Description: Verifies the correct PDP is launched when product description is
	 * clicked on Thank You page of registered user order. 
	 * Author: Asfi Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-3594
	 ********************************************************************/
	@Test(priority = 21)
	public void verifyProductTitleOnThankYouPage_registered() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_PM_Controls.testStarted(tcName);
		regBankWire();
		Q_PM_CheckoutSteps.isOrderComplete(tcName);
		chk.verifyProductDescOnThankYouPage();
	}
	
	/********************************************************************
	 * Description: Verify successful registered order with new billing address
	 * Author: Tamilselvan A
 	 * Status: Complete   
	 * Ticket: JMB-4230
	 *******************************************************************/
    @Test(priority = 22,enabled=true)
    public void registerOrderBillingAddress() throws IOException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(50);
	    Q_PM_WebElm.myWait(2000);
        Q_PM_Controls.openNewTab();
        Q_PM_Controls.switchTab(1);	    
        chk.deleteAllExistingCard();
        Q_PM_Controls.switchTab(0);	    
	    driver.navigate().refresh();
        Q_PM_AddToCart.silver_2_2553739("11");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.creditForm(2);
        chk.verifyBillingAddressField();
        chk.changeBillingAddressButton();
        chk.removeBillAddress();
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
        Q_PM_CartSteps.deleteItems();
        Q_PM_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
