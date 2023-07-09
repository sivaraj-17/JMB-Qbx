package testcases.registered;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;

import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Q_JMB_RegisteredUser extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
    static Q_JMB_CategoryObjects cat = new Q_JMB_CategoryObjects();
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
    @Test(priority = 1,enabled=false)
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
    // * Description: Persistent cart add item to cart then log out. Log back in and verify the cart retains the
    // * content from previous step.
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2)
    public static void persistantCart(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(21);;
        Q_JMB_ProductPageObjects.platinumAmericanEagle("2");
        acc.logoutUser();
        acc.loginUser(21);;
        chk.quickCart();
        Q_JMB_CartPageObjects.removeItems();
    }
    
    /*******************************************************************
    // * Description: User starts as a guest customer when checking out user decides to login and complete the order.
    // * Verify bridge page is available to the customer to complete his/her transactions.
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3)
    public void bridgeRegisteredCheckout() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("10 Gram Perth Mint Gold Bar", 4);
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("top");
        cart.selectPaymentType("cheque");
        chk.bridgeLogin(22);
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /*******************************************************************
    // * Description: Registered User checkout payment type credit card taxable and no shipping charges
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 4)
    public static void masterCardTaxNoShipping() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(21);
        chk.selectItem("10 Gram Perth Mint Gold Bar", 4);
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        chk.selectCard("visa", "321");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());

        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
    }

    /*******************************************************************
    // * Description: Registered User checkout payment type credit card non taxable minimum shipping charges applied
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 5)
    public void ccNoTaxMinShipping() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(21);;
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 1);
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        chk.selectCard("visa", "961");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
    // * Description: Registered User checkout payment type credit card non taxable free shipping
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 6)
    public void ccNoTaxNoShipping() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(21);
        chk.selectItem("100 oz Geiger Security", 1);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        chk.selectCard("visa", "321");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
    // * Description: Registered User checkout payment type credit card taxable and minimum shipping
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 7)
    public static void ccTaxShipping() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(23);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 10);
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        chk.selectCard("visa", "321");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
        chk.thankYouPage();
    }
    
    /*******************************************************************
    // * Description: Registered User checkout payment type credit card taxable,
    // * shipping Tax applied and shipping upgrade
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 8)
    public void ccTaxShippingUpgrade() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(23);;
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 2);
        chk.selectItem("1 oz US Quarter Copper", 5);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        chk.selectCard("visa", "202");
        chk.regShippingUpgrade("option 2");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        System.out.println(reviewPrices);
        Q_JMB_Controls.scrolDownPixel(500);
        Q_JMB_WebElm.myWait(1000);
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
    // * Description: Registered User verify applying $10.00 coupon
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 9)
    public void ccGiftCertifcate() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(23);;
        chk.selectItem("10 Gram Perth Mint Gold Bar", 1);
        cart.selectPaymentType("cheque");
        cart.applyGiftCertificate();
        cart.selectcheckoutBtn("bottom");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListNoTax());
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceListNoTax());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
    // * Description: Registered User verify Order is in pending status
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 10)
    public void pendingOrder() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(29);
        chk.selectItem("1 oz American Gold Eagle Coin",3);
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        //cart.selectcheckoutBtn("top");
        //chk.selectCard("amex", "9641");
        chk.regShippingUpgrade("option 2");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        Q_JMB_WebElm.myWait(1000);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
        chk.orderStatus("Pending");
    }
    
    /*******************************************************************
    // * Description: Registered User verify Order is in paid status
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 11)
    public void paidOrder() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(27);
        chk.selectItem("1 oz American Gold Eagle Coin",3);
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        chk.selectCard("amex", "7202");
        //ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        Q_JMB_WebElm.myWait(1000);
        chk.completeOrder();
        //ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        //chk.verifyOrderCharges(reviewPrices, orderPrices);
        chk.orderStatus("Paid & Preparing Shipment");
    }
    
    /*******************************************************************
    // * Description: Verify user can switch between credit cards on his/her account during checkout
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 12)
    public void switchPayment() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        chk.selectItem("Peace Silver Dollar",23);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        chk.selectCard("mc", "712");
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /*******************************************************************
    // * Description: verify user can switch to a different address during checkout
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 13)
    public static void switchShippingAddress() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(21);
        chk.selectItem("3 Gram Chinese Gold Panda",1);
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        chk.switchAddress();
        chk.selectCard("visa", "712");
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /*******************************************************************
    // * Description: verify user can edit shipping address during checkout
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 14)
    public void editShippingAddress() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(22);
        chk.selectItem("3 Gram Chinese Gold Panda",3);
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        chk.editShipping("chk.shipping.validate.id");
        chk.selectCard("visa", "712");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
    // * Description: verify credit card is required for bank wire orders
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 15)
    public void bankwireNoDefaults() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(2);
        chk.selectItem("1 oz American Gold Eagle Coin",3);
        cart.selectPaymentType("wire");
        cart.selectcheckoutBtn("top");
        chk.creditCardRequired();
    }

    /*******************************************************************
    // * Description: verify user can checkout order with payment method bank wire
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 16)
    public void bankwirePayment() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(22);
        chk.selectItem("1 oz American Gold Eagle Coin",10);
        cart.selectPaymentType("wire");
        cart.selectcheckoutBtn("top");
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /*******************************************************************
    // * Description: verify credit card is required for paper check orders
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 17)
    public void paperCheckNoDefaults() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(2);
        chk.selectItem("3 Gram Chinese Gold Panda",10);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        chk.creditCardRequired();
    }

    /*******************************************************************
    // * Description: verify user can checkout order with payment method paper check
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 18)
    public void paperCheckPayment() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(22);
        chk.selectItem("3 Gram Chinese Gold Panda",10);
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("top");
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /*******************************************************************
    // * Description: verify user can checkout order with payment echeck
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 19)
    public void eCheckCheckout() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(21);
        chk.selectItem("3 Gram Chinese Gold Panda",10);
        cart.selectPaymentType("echeck");
        cart.selectcheckoutBtn("top");
        chk.echeckForm("echeck");
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /*******************************************************************
    // * Description: verify user can checkout order with payment echeck using ACH
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 20)
    public void achCheckout() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(28);
        chk.selectItem("3 Gram Chinese Gold Panda",10);
        cart.selectPaymentType("echeck");
        cart.selectcheckoutBtn("top");
        chk.echeckForm("plaid");
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /*******************************************************************
    // * Description: verify military users are eligible for military discount
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 21)
    public void militaryCustomer(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(10);
        cart.militaryCart();
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /*******************************************************************
    // * Description: Verify when user last name can include apostrophe can complete checkout
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 22)
    public void lNameSpecialCharApostrophe() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(19);
        chk.selectItem("3 Gram Chinese Gold Panda",3);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.cvvCardType(3);
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /*******************************************************************
    // * Description: verify order with pre sale item require acknowledgment of pre-sale item
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 23)
    public void presale() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(19);
        chk.selectItem("2.5 Gram Valcambi Gold Bar", 2);
        cart.selectcheckoutBtn("bottom");
        chk.cvvCardType(3);
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /*******************************************************************
     * Description: Verifies user can plase order with more than 15 items
     * Author: Hisham Aridi
     * Status: Complete
     * Ticket: NA
     ********************************************************************/
    @Test (priority = 24)
    public void largeOrder() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(22);
        chk.selectItem("3 Gram Chinese Gold Panda",3);
        chk.selectItem("1 oz US Quarter Copper", 10);
        chk.selectItem("10 Gram Perth Mint Gold Bar", 5);
        chk.selectItem("1 oz American Gold Eagle Coin", 2);
        chk.selectItem("2.5 Gram Valcambi Gold Bar", 3);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 4);
        chk.selectItem("100 oz Geiger Security",2);
        chk.selectItem("Peace Silver Dollar",2);
        chk.selectItem("1 oz American Platinum Eagle Coin",2);
        chk.selectItem("walking-liberty",10);
        chk.selectItem("1 oz Canadian Silver Maple Leaf Coin",2);
        chk.selectItem("2019 Canadian Silver Maple Leaf Tube (25 Coins, BU)",1);
        chk.selectItem("2019 Canadian Silver Maple Leaf Monster Box (500 Coins, BU)",1);
        chk.selectItem("10 oz gold bar",2);
        chk.selectItem("1 oz pamp suisse platinum bar",2);
        chk.selectItem("10 oz pamp suisse platinum bar", 2);
        cart.selectPaymentType("wire");
        cart.selectcheckoutBtn("top");
        chk.editShipping("chk.shipping.validate.id");
    }
    
    /*******************************************************************
     // * Description: This test case verifies Sales tax should not be negative for accessories products.
     // * Author:
     // * Status: Complete
     *  Ticket : JMB-5446(Sales Tax Calculation with a coupon)
     * @throws Exception
     */
    @Test(priority = 25)
    public static void salesTaxCalculationForAccesoriesWithCoupon() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(21);
        chk.selectItem("33mm CoinSafe Coin Tube", 500);
        cart.selectPaymentType("credit card");
        cart.giftCertificateInput("HSD");
        cart.giftCertificateApply();
        cart.selectcheckoutBtn("bottom");
        chk.selectCard("visa", "712");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        chk.completeOrder();
        chk.thankYouPage();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println("Order totals: " + orderPrices);//        Controls.scrolDownPixel(500);
    }
    
    /*******************************************************************
     * Description: Verifies that on selecting shipping address with a pickup location
     * able to select Pick Up location and complete order.
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6413(Checkout - Pickup Option)
     ********************************************************************/
    @Test(priority = 26)
    public static void registerOrderPickUpShippingOption()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        chk.selectItem("1994 1 oz American Silver Eagle Coin", 9);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("top");
        //chk.selectShippingAddressByZipCode(jmbProps, "chk.reg.shippingAddressOptionByText.beg.xp" ,"75070" ,"chk.reg.shippingAddressOptionByText.end.xp");
        chk.selectCard("mc", "712");
        chk.regShippingUpgrade("local pickup");
        chk.completeOrder();
    }
    
    /*******************************************************************
     * Description: Verifies the correct PDP is launched when product 
     * description is clicked on Thank You page for registered user order.
     * Author: Asfi Khaliq
     * Status: Complete
     * Ticket: JMB-3594
     ********************************************************************/
	@Test(priority = 27)
	public void verifyProductTitleOnThankYouPage_registered() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		bankwirePayment();
		chk.verifyProductDescOnThankYouPage();
	}
    
	/*******************************************************************
     * Description: Verifies the correct PDP is launched when product 
     * image is clicked on Thank You page for registered user order.
     * Author: Asfi Khaliq
     * Status: Complete
     * Ticket: JMB-3594
     ********************************************************************/
	@Test(priority = 28)
	public void verifyProductImageOnThankYouPage_registered() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		bankwirePayment();
		chk.verifyProductImageOnThankYouPage();
	}
	
	/********************************************************************
	 * Description: Verify successful registered order with new billing address
	 * Author: Tamilselvan A
 	 * Status: Complete   
	 * Ticket: JMB-4230
	 *******************************************************************/
    @Test(priority = 29,enabled=true)
    public void registerOrderBillingAddress() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
    	acc.loginUser(53);
	    Q_JMB_WebElm.myWait(2000);
        Q_JMB_Controls.openNewTab();
        Q_JMB_Controls.switchTab(1);	    
        chk.deleteAllExistingCard();
        Q_JMB_Controls.switchTab(0);	    
	    driver.navigate().refresh();
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectcheckoutBtn("top");
        chk.creditCardForm(2);
        chk.selectCard("visa", "202");
        chk.verifyBillingAddressField();
        chk.changeBillingAddressButton();
        chk.removeBillAddress();
        chk.clickAddNewBillAddress();
        chk.billingAddressForm(6);
        chk.saveBillingAddress();
        chk.completeOrder();
        chk.thankYouPage();
    }

    @AfterTest
    public void endReport(){
    }
    @AfterMethod
    public void tearDown() throws Exception {
        Q_JMB_CartPageObjects.removeItems();
        acc.logoutUser();
        Q_JMB_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
