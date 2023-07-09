package testcases.registered;

//import steps.AccountSteps;

import org.testng.annotations.*;
import pageObjects.Q_Slv_AccountSteps;
import pageObjects.Q_Slv_AdminSlvSteps;
import pageObjects.Q_Slv_CartSteps;
import pageObjects.Q_Slv_CheckoutSteps;
import pageObjects.Q_Slv_WebElm;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.util.ArrayList;


public class Q_Slv_Registered3Ds extends Q_Slv_Init {
    @BeforeClass
    public void tcSetup (){

    }
    @BeforeMethod
    public void report() throws Exception {
        Q_Slv_Init.setItUp();
    }
    @BeforeTest
    public void setTest() throws Exception {
    }
    

    Q_Slv_AdminSlvSteps admin = new Q_Slv_AdminSlvSteps();
    
    /*******************************************************************
    // * Description: Turns 3DS on
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1, enabled = true)
    public void turn3DSOn() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_Controls.adminLogin();
        admin.adminMenu("settings");
        Q_Slv_WebElm.xp(SLVqProp, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("on");
        Q_Slv_WebElm.myWait(1000);
    }
    
    /*******************************************************************
    // * Description: Verifying checkout via 3D Secure with Frictionless Checkout with Success visa card 4456530000001005
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2, enabled = true)
    public void FrictionlessCheckoutSuccess001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 36);
        Q_Slv_CartSteps.silver1("10");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("visa", "321");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
    /*******************************************************************
    // * Description: Verifying user can switch between Frictionless Checkout with Success to master cards 5200000000001005 on his/ her profile
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3, enabled = true)
    public void FrictionlessCheckoutSuccess002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.   login("acc.login.link.xp", 36);
        Q_Slv_CartSteps.gold2("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("mc", "672");
//        CheckoutSteps.cardType(13, "sil.selected.type.xp", "sil.cvv.xp");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
    /*******************************************************************
     // * Description: Verifying user can switch between Frictionless Checkout with Success to amex cards 340000000001007 on his/ her profile
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4, enabled = true)
    public void FrictionlessCheckoutSuccess003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.   login("acc.login.link.xp", 36);
        Q_Slv_CartSteps.gold2("2");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("amex", "3113");
//        CheckoutSteps.cardType(13, "sil.selected.type.xp", "sil.cvv.xp");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with no authentication visa cards 4456530000001013
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5)
    public void FrictionlessNoAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 37);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        //Q_Slv_CheckoutSteps.shippingAutoAddress(19);
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(15);
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("We are unable to complete your purchase, your card issuer replied with the following");
    }
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with no authentication master cards 5200000000001013
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6)
    public void FrictionlessNoAuth002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 37);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(15);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("We are unable to complete your purchase, your card issuer replied with the following");
    }

    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with no authentication American Express card
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7)
    public void FrictionlessNoAuth003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 37);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(17);
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("We are unable to complete your purchase, your card issuer replied with the following");
    }
    /*******************************************************************
    // * Description: Verifying user attempts Frictionless Checkout with auth unavailable Visa Express card 4456530000001039
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 8)
    public void FrictionlessUnavailableAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 38);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("visa", "672");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with auth unavailable mastercard card 5200000000001039
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9)
    public void FrictionlessUnavailableAuth002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 38);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
//        Q_CheckoutSteps.newCreditCard();
//        Q_CheckoutSteps.creditCardInput(19);
        Q_Slv_CheckoutSteps.switchCard("mc", "672");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with auth unavailable American Express card 340000000001031
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 10)
    public void FrictionlessUnavailableAuth003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 38);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
//        Q_CheckoutSteps.newCreditCard();
//        Q_CheckoutSteps.creditCardInput(20);
        Q_Slv_CheckoutSteps.switchCard("amex", "6722");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }

    /*******************************************************************
     // * Description: Verifying user attempts Frictionless with rejection checkout visa card 4456530000001047
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 11)
    public void FrictionlessWithRejectio001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 39);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(21);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("We are sorry but we are unable to process your credit card.");
    }

    /*******************************************************************
     // * Description: Verifying user attempts Frictionless with rejection checkout master card 5200000000001047
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 12)
    public void FrictionlessWithRejection002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 39);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(22);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("We are sorry but we are unable to process your credit card.");
    }


    /*******************************************************************
     // * Description: Verifying user attempts Frictionless with rejection checkout American Express card 340000000001049
     // * Author:
     // * Status: Complete
    //*******************************************************************/
    @Test(priority = 13)
    public void FrictionlessWithRejection003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 39);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(23);
//        Q_CheckoutSteps.shippingAutoAddress(15);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("We are sorry but we are unable to process your credit card.");
        Q_Slv_Controls.captureScreen(driver, tcName);
    }
    /*******************************************************************
     // * Description: Verifying user with visa card 4456530000001062 profile enrolment check error can complete order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 14)
    public void enrolmentCheckError001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 40);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        //Q_Slv_CheckoutSteps.creditCardInput(24);
        Q_Slv_CheckoutSteps.switchCard("visa", "241");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
    /*******************************************************************
     // * Description: Verifying user with master card 5200000000001062 profile enrolment check error can complete order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 15)
    public void enrolmentCheckError002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 40);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
//        CheckoutSteps.newCreditCard();
//        CheckoutSteps.creditCardInput(25);
        Q_Slv_CheckoutSteps.switchCard("mc", "242");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
    /*******************************************************************
     // * Description: Verifying user with American express card 340000000001064 profile enrolment check error can complete order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 16)
    public void enrolmentCheckError003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 40);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
//        CheckoutSteps.newCreditCard();
//        CheckoutSteps.creditCardInput(26);
        Q_Slv_CheckoutSteps.switchCard("amex", "2423");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }


    /*******************************************************************
     // * Description: Verifying user with Visa card 4456530000001096 profile Setup Success
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 17)
    public void setUpSuccess001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 41);
        Q_Slv_CartSteps.gold2("2");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
//        Q_CheckoutSteps.shippingAutoAddress(17);
//        CheckoutSteps.newCreditCard();
//        Q_CheckoutSteps.creditCardInput(27);
        Q_Slv_CheckoutSteps.switchCard("visa", "270");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
    }
    /*******************************************************************
     // * Description: Verifying user with Master Card 5200000000001096 profile Setup Success
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 18)
    public void setUpSuccess002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 41);
        Q_Slv_CartSteps.gold2("2");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
//        CheckoutSteps.newCreditCard();
//        CheckoutSteps.creditCardInput(28);
        Q_Slv_CheckoutSteps.switchCard("mc", "280");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
    }
    /*******************************************************************
     // * Description: Verifying user with American Express card 340000000001098 profile Setup Success
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 19)
    public void setUpSuccess003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 41);
        Q_Slv_CartSteps.gold2("2");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
//        CheckoutSteps.newCreditCard();
//        CheckoutSteps.creditCardInput(29);
        Q_Slv_CheckoutSteps.switchCard("amex", "2900");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
    }
    /*******************************************************************
     // * Description: Verifying user with Visa card 4456530000001104 profile enrolment setup auth unsuccessful
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 20)
    public void setupAuthUnsuccessful001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 42);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(30);
//        Q_CheckoutSteps.shippingAutoAddress(18);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        //Q_Slv_CheckoutSteps.checkoutModalError();
        //Q_Slv_CheckoutSteps.modalErrorMsg(tcName);
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("We are sorry but we are unable to process your credit card.");
    }
    /*******************************************************************
     // * Description: Verifying user with Master Card 5200000000001104 profile enrolment setup auth unsuccessful
     // * Author:
     // * Status:
     //*******************************************************************/
    @Test(priority = 21)
    public void setupAuthUnsuccessful002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 42);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(31);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        //Q_Slv_CheckoutSteps.checkoutModalError();
        //Q_Slv_CheckoutSteps.modalErrorMsg(tcName);
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("We are sorry but we are unable to process your credit card.");
    }
    /*******************************************************************
     // * Description: Verifying user with American express 340000000001106 card profile setup auth unsuccessful
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 22)
    public void setupAuthUnsuccessful003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 42);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(32);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        //Q_Slv_CheckoutSteps.checkoutModalError();
        //Q_Slv_CheckoutSteps.modalErrorMsg(tcName);
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("We are sorry but we are unable to process your credit card.");
    }
    /*******************************************************************
     // * Description: Verifying user with Visa card 4456530000001112 in their profile auth unavailable and user is presented with modal error message
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 23)
    public void setupAuthUnavailable001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 43);
        Q_Slv_CartSteps.gold3("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
//        Q_Slv_CheckoutSteps.shippingAutoAddress(19);
        //Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(33);
        //Q_Slv_CheckoutSteps.switchCard("visa", "331");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        //Q_Slv_CheckoutSteps.checkoutModalError();
        //Q_Slv_CheckoutSteps.modalErrorMsg(tcName);
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    /*******************************************************************
     // * Description: Verifying user with Master Card 5200000000001112  in their profile auth unavailable and user is presented with modal error message
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 24)
    public void setupAuthUnavailable002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 43);
        Q_Slv_CartSteps.gold3("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(34);
        //Q_Slv_CheckoutSteps.switchCard("mc", "340");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        //Q_Slv_CheckoutSteps.checkoutModalError();
        //Q_Slv_CheckoutSteps.modalErrorMsg(tcName);
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    /*******************************************************************
     // * Description: Verifying user with American Express card 340000000001114 in their profile auth unavailable and user is presented with modal error message
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 25)
    public void setupAuthUnavailable003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 43);
        Q_Slv_CartSteps.gold1("2");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(35);
//        Q_Slv_CheckoutSteps.switchCard("amex", "3535");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        //Q_Slv_CheckoutSteps.checkoutModalError();
        //Q_Slv_CheckoutSteps.modalErrorMsg(tcName);
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    
    /*******************************************************************
    // * Description: Turns 3DS off
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 26, enabled = true)
    public void turn3DSOff() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_Controls.adminLogin();
        admin.adminMenu("settings");
        Q_Slv_WebElm.xp(SLVqProp, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("off");
        Q_Slv_WebElm.myWait(1000);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Q_Slv_CartSteps.emptyCart();
        Q_Slv_AccountSteps.logout();
        Q_Slv_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
