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


public class Q_Slv_Registered3DsOff extends Q_Slv_Init {
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
    // * Description: Turns 3DS off
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1)
    public void turn3DSOff() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_Controls.adminLogin();
        admin.adminMenu("settings");
        Q_Slv_WebElm.xp(SLVqProp, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("off");
        Q_Slv_WebElm.myWait(1000);
    }
    
    /*******************************************************************
    // * Description: Verifying checkout via 3D Secure with Frictionless Checkout with Success visa card
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2, enabled = true)
    public void FrictionlessCheckoutSuccessVisa() throws Exception {
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
        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
    // * Description: Verifying user can switch between Frictionless Checkout with Success to master cards on his/ her profile
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3, enabled = true)
    public void FrictionlessCheckoutSuccessMc() throws Exception {
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
        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user can switch between Frictionless Checkout with Success to amex cards on his/ her profile
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4, enabled = true)
    public void FrictionlessCheckoutSuccessAmex() throws Exception {
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
        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with no authentication visa cards
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5)
    public void FrictionlessNoAuthVisa() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 37);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(15);
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsg("We are sorry but we are unable to process your credit card.");

//        Q_Slv_CheckoutSteps.switchCard("mc", "241");
       // ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());

   //     Q_Slv_CheckoutSteps.completeOrder();
    //    Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with no authentication master cards
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6, enabled = false)
    public void FrictionlessNoAuthNasterCard() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 37);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.creditCardInput(15);
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsg("We are sorry but we are unable to process your credit card.");
        Q_Slv_CheckoutSteps.validateErrorrMsg("We are sorry but we are unable to process your credit card.");
        Q_Slv_AccountSteps.logout();
    }

    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with no authentication American Express card
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7, enabled = false)
    public void FrictionlessNoAuthAmex() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 37);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.creditCardInput(15);
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsg("We are sorry but we are unable to process your credit card.");

        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
    // * Description: Verifying user attempts Frictionless Checkout with auth unavailable Visa Express card
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 8)
    public void FrictionlessUnavailableAuthVisa() throws Exception {
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
        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with auth unavailable mastercard card
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9)
    public void FrictionlessUnavailableAuthMc() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 38);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("mc", "672");

        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);

        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with auth unavailable American Express card
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 10)
    public void FrictionlessUnavailableAuthAmex() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 38);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
//        CheckoutSteps.newCreditCard();
//        CheckoutSteps.creditCardInput(20);
        Q_Slv_CheckoutSteps.switchCard("amex", "6722");


        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        Q_Slv_AccountSteps.logout();

    }

    /*******************************************************************
     // * Description: Verifying user attempts Frictionless with rejection checkout visa card
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 11)
    public void FrictionlessWithRejectioVisa() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 39);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(21);
//        Q_Slv_CheckoutSteps.switchCard("visa", "241");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
//        ArrayList<Float> prices = new  ArrayList<Float>(CheckoutSteps.revPriceListNoTax());
//        CheckoutSteps.attemptOrder();
        Q_Slv_AccountSteps.logout();
    }

    /*******************************************************************
     // * Description: Verifying user attempts Frictionless with rejection checkout master card
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 12, enabled = false)
    public void FrictionlessWithRejectioMc() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 39);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.creditCardInput(15);
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsg("We are sorry but we are unable to process your credit card.");
        Q_Slv_CheckoutSteps.creditCardInput(21);
        Q_Slv_AccountSteps.logout();
    }


    /*******************************************************************
     // * Description: Verifying user attempts Frictionless with rejection checkout American Express card
     // * Author:
     // * Status: Complete
    //*******************************************************************/
    @Test(priority = 13, enabled = false)
    public void FrictionlessWithRejectionAmex() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 39);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.creditCardInput(15);
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsg("We are sorry but we are unable to process your credit card.");

        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user with visa card profile enrolment check error can complete order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 14)
    public void enrolmentCheckErrorVisa() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 40);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("visa", "241");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user with master card profile enrolment check error can complete order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 15)
    public void enrolmentCheckErrorMc() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 40);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("mc", "242");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user with American express card profile enrolment check error can complete order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 16)
    public void enrolmentCheckErrorAmex() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 40);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("amex", "2423");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        Q_Slv_AccountSteps.logout();
    }


    /*******************************************************************
     // * Description: Verifying user with Visa card profile Setup Success
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 17)
    public void setUpSuccessVisa() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 41);
        Q_Slv_CartSteps.silver1("3");
        //Q_Slv_CartSteps.gold2("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("visa", "270");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
//        CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.completeOrder();
//        CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user with Master Card profile Setup Success
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 18)
    public void setUpSuccessMc() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 41);
        Q_Slv_CartSteps.gold2("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("mc", "280");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        //        CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user with American Express card profile Setup Success
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 19, enabled = false)
    public void setUpSuccessAmex() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 41);
        Q_Slv_CartSteps.gold2("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("amex", "2900");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user with Visa card profile enrolment setup auth unsuccessful
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 20)
    public void setupAuthUnsuccessfulVisa() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 42);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(30);
//        Q_Slv_CheckoutSteps.switchCard("visa", "542");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();

//        CheckoutSteps.checkoutModalError();
//        CheckoutSteps.modalErrorMsg(tcName);
        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user with Master Card profile enrolment setup auth unsuccessful
     // * Author:
     // * Status:
     //*******************************************************************/
    @Test(priority = 21, enabled = false)
    public void setupAuthUnsuccessfulMc() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 42);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");

        Q_Slv_CheckoutSteps.creditCardInput(31);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.checkoutModalError();
        Q_Slv_CheckoutSteps.modalErrorMsg(tcName);
        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user with American express card profile setup auth unsuccessful
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 22, enabled = false)
    public void setupAuthUnsuccessfulAmex() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 42);
        Q_Slv_CartSteps.silver1("3");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(32);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.checkoutModalError();
        Q_Slv_CheckoutSteps.modalErrorMsg(tcName);
        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user with Visa card profile setup auth unavailable
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 23)
    public void setupAuthUnavailableVisa() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 43);
        Q_Slv_CartSteps.gold3("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(33);
//        Q_Slv_CheckoutSteps.switchCard("visa", "331");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
//        CheckoutSteps.checkoutModal(tcName);
//        CheckoutSteps.modalErrorMsg(tcName);
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user with Master Card profile setup auth unavailable
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 24, enabled = false)
    public void setupAuthUnavailableMc() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 43);
        Q_Slv_CartSteps.gold3("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("mc", "340");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.modalErrorMsg(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_AccountSteps.logout();
    }
    /*******************************************************************
     // * Description: Verifying user with American Express card profile setup auth unavailable
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 25, enabled = false)
    public void setupAuthUnavailableAmex() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 43);
        Q_Slv_CartSteps.gold1("2");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("amex", "3535");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.modalErrorMsg(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_AccountSteps.logout();
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
