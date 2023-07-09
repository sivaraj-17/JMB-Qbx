package testcases.registered;

import org.testng.annotations.*;
import pageObjects.Q_PM_AccountSteps;
import pageObjects.Q_PM_AdminPmSteps;
import pageObjects.Q_PM_CartSteps;
import pageObjects.Q_PM_CheckoutSteps;
import pageObjects.Q_PM_WebElm;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;


public class Q_PM_Registered3Ds extends Q_PM_Init {
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
    
    /*******************************************************************
    // * Description: Turns 3DS on
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1,enabled=true)
    public void turn3DSOn() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_Controls.adminLoginPM();
        admin.adminMenu("settings");
        Q_PM_WebElm.xp(pmQaProps, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("on");
        Q_PM_WebElm.myWait(1000);
    }

    /*******************************************************************
     // * Description: Verifying checkout via 3D Secure with Frictionless Checkout with Success visa card 4456530000001005
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2, enabled = true)
    public void FrictionlessCheckoutSuccess001() throws Exception {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(39);
        Q_PM_CheckoutSteps.selectItem("1 gram gold bar sunshine mint", 4);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.cardSelection("visa");
        //Q_PM_CheckoutSteps.cardSelection("newCard");
        //Q_PM_CheckoutSteps.creditForm(12);
        //Q_PM_CheckoutSteps.shippingForm(12);
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.completeOrder();
        Q_PM_CheckoutSteps.isOrderComplete(tcName);
    }
    /*******************************************************************
     // * Description: Verifying user can switch between Frictionless Checkout with Success to master cards 5200000000001005 on his/ her profile
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3, enabled = true)
    public void FrictionlessCheckoutSuccess002() throws Exception {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(39);
        Q_PM_CheckoutSteps.selectItem("10 gram Perth Mint Gold Bar", 1);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.cardSelection("mc");
        //Q_PM_CheckoutSteps.cardSelection("newCard");
        //Q_PM_CheckoutSteps.creditForm(13);
        Q_PM_CheckoutSteps.completeOrder();
        Q_PM_CheckoutSteps.isOrderComplete(tcName);
    }

    /*******************************************************************
     // * Description: Verifying user can switch between Frictionless Checkout with Success to amex cards 340000000001007 on his/ her profile
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4, enabled = true)
    public void FrictionlessCheckoutSuccess003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(39);
        Q_PM_CheckoutSteps.selectItem("1 gram gold bar sunshine mint", 2);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.cardSelection("Amex");
        //Q_PM_CheckoutSteps.cardSelection("newCard");
        //Q_PM_CheckoutSteps.creditForm(14);
        Q_PM_CheckoutSteps.completeOrder();
        Q_PM_CheckoutSteps.isOrderComplete(tcName);
    }
    
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with no authentication visa cards 4456530000001013
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5)
    public void FrictionlessNoAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(40);
        Q_PM_CheckoutSteps.selectItem("3 gram Chinese Gold Panda", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        //Q_PM_CheckoutSteps.shippingForm(1);
        //Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.cardSelection("newCard");
        Q_PM_CheckoutSteps.creditForm(15);
        Q_PM_CheckoutSteps.attemptOrder(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsgContains("We are unable to complete your purchase, your card issuer replied with the following");
    }
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with no authentication master cards 5200000000001013
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6)
    public void FrictionlessNoAuth002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(40);
        Q_PM_CheckoutSteps.selectItem("3 gram Chinese Gold Panda", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
//        Q_CheckoutSteps.shippingForm(1);
//        Q_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.cardSelection("newCard");
        Q_PM_CheckoutSteps.creditForm(16);
        Q_PM_CheckoutSteps.attemptOrder(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsgContains("We are unable to complete your purchase, your card issuer replied with the following");
    }

    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with no authentication American Express card
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7)
    public void FrictionlessNoAuth003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(40);
        Q_PM_CheckoutSteps.selectItem("3 gram Chinese Gold Panda", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
//        Q_CheckoutSteps.shippingForm(1);
//        Q_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.cardSelection("newCard");
        Q_PM_CheckoutSteps.creditForm(17);
        Q_PM_CheckoutSteps.attemptOrder(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsgContains("We are unable to complete your purchase, your card issuer replied with the following");
    }
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with auth unavailable Visa Express card 4456530000001039
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8)
    public void FrictionlessUnavailableAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(41);
        Q_PM_CheckoutSteps.selectItem("3 gram Chinese Gold Panda", 3);
        Q_PM_CheckoutSteps.selectItem("Maple Leaf 1 oz Copper Round", 10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        //Q_PM_CheckoutSteps.shippingForm(14);
        //Q_PM_CheckoutSteps.validateAddress();
        //Q_PM_CheckoutSteps.creditForm(18);
        Q_PM_CheckoutSteps.cardSelection("visa");
        Q_PM_CheckoutSteps.completeOrder();
        Q_PM_CheckoutSteps.isOrderComplete(tcName);
    }
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with auth unavailable mastercard card 5200000000001039
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9)
    public void FrictionlessUnavailableAuth002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(41);
        Q_PM_CheckoutSteps.selectItem("3 gram Chinese Gold Panda", 3);
        Q_PM_CheckoutSteps.selectItem("Maple Leaf 1 oz Copper Round", 10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        //Q_PM_CheckoutSteps.shippingForm(14);
        //Q_PM_CheckoutSteps.validateAddress();
        //Q_PM_CheckoutSteps.cardSelection("newCard");
        //Q_PM_CheckoutSteps.creditForm(19);
        Q_PM_CheckoutSteps.cardSelection("mc");
        Q_PM_CheckoutSteps.completeOrder();
        Q_PM_CheckoutSteps.isOrderComplete(tcName);
    }
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with auth unavailable American Express card 340000000001031
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 10)
    public void FrictionlessUnavailableAuth003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(41);
        Q_PM_CheckoutSteps.selectItem("3 gram Chinese Gold Panda", 3);
        Q_PM_CheckoutSteps.selectItem("Maple Leaf 1 oz Copper Round", 10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
//        Q_CheckoutSteps.shippingForm(14);
//        Q_CheckoutSteps.validateAddress();
        //Q_PM_CheckoutSteps.cardSelection("newCard");
        //Q_PM_CheckoutSteps.creditForm(20);
        Q_PM_CheckoutSteps.cardSelection("Amex");
        Q_PM_CheckoutSteps.completeOrder();
        Q_PM_CheckoutSteps.isOrderComplete(tcName);
    }

    /*******************************************************************
     // * Description: Verifying user attempts Frictionless with rejection checkout visa card 4456530000001047
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 11)
    public void FrictionlessWithRejectio001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(42);
        Q_PM_CheckoutSteps.selectItem("3 gram Chinese Gold Panda", 3);
        Q_PM_CheckoutSteps.selectItem("Maple Leaf 1 oz Copper Round", 10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        //Q_PM_CheckoutSteps.shippingForm(15);
        //Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.cardSelection("newCard");
        Q_PM_CheckoutSteps.creditForm(21);
        Q_PM_CheckoutSteps.attemptOrder(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsgContains("We are sorry but we are unable to process your credit card.");
    }

    /*******************************************************************
     // * Description: Verifying user attempts Frictionless with rejection checkout master card 5200000000001047
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 12)
    public void FrictionlessWithRejection002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(42);
        Q_PM_CheckoutSteps.selectItem("3 gram Chinese Gold Panda", 3);
        Q_PM_CheckoutSteps.selectItem("Maple Leaf 1 oz Copper Round", 10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
//        Q_CheckoutSteps.shippingForm(15);
//        Q_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.cardSelection("newCard");
        Q_PM_CheckoutSteps.creditForm(22);
        Q_PM_CheckoutSteps.attemptOrder(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsgContains("We are sorry but we are unable to process your credit card.");
    }

    /*******************************************************************
     // * Description: Verifying user attempts Frictionless with rejection checkout American Express card 340000000001049
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 13)
    public void FrictionlessWithRejection003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(42);
        Q_PM_CheckoutSteps.selectItem("3 gram Chinese Gold Panda", 3);
        Q_PM_CheckoutSteps.selectItem("Maple Leaf 1 oz Copper Round", 10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
//        Q_CheckoutSteps.shippingForm(15);
//        Q_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.cardSelection("newCard");
        Q_PM_CheckoutSteps.creditForm(23);
        Q_PM_CheckoutSteps.completeOrder();
        Q_PM_CheckoutSteps.validateErrorrMsgContains("We are sorry but we are unable to process your credit card.");
    }
    
    /*******************************************************************
     // * Description: Verifying user with visa card 4456530000001062 profile enrolment check error can complete order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 14)
    public void enrolmentCheckError001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(43);
        Q_PM_CheckoutSteps.selectItem("3 gram Chinese Gold Panda", 3);
        Q_PM_CheckoutSteps.selectItem("Maple Leaf 1 oz Copper Round", 10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        //Q_PM_CheckoutSteps.shippingForm(8);
        //Q_PM_CheckoutSteps.validateAddress();
//        Q_CheckoutSteps.cardSelection("newCard");
        Q_PM_CheckoutSteps.cardSelection("visa");
        Q_PM_CheckoutSteps.completeOrder();
        Q_PM_CheckoutSteps.isOrderComplete(tcName);
    }
    
    /*******************************************************************
     // * Description: Verifying user with master card 5200000000001062 profile enrolment check error can complete order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 15)
    public void enrolmentCheckError002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(43);
        Q_PM_CheckoutSteps.selectItem("3 gram Chinese Gold Panda", 3);
        Q_PM_CheckoutSteps.selectItem("Maple Leaf 1 oz Copper Round", 10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
//        Q_CheckoutSteps.shippingForm(8);
//        Q_CheckoutSteps.validateAddress();
        //Q_PM_CheckoutSteps.cardSelection("newCard");
        //Q_PM_CheckoutSteps.creditForm(25);
        Q_PM_CheckoutSteps.cardSelection("mc");
        Q_PM_CheckoutSteps.completeOrder();
        Q_PM_CheckoutSteps.isOrderComplete(tcName);
    }
    
    /*******************************************************************
     // * Description: Verifying user with American express card 340000000001064 profile enrolment check error can complete order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 16)
    public void enrolmentCheckError003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(43);
        Q_PM_CheckoutSteps.selectItem("3 gram Chinese Gold Panda", 3);
        Q_PM_CheckoutSteps.selectItem("Maple Leaf 1 oz Copper Round", 10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
//        Q_CheckoutSteps.shippingForm(8);
//        Q_CheckoutSteps.validateAddress();
        //Q_PM_CheckoutSteps.cardSelection("newCard");
        //Q_PM_CheckoutSteps.creditForm(26);
        Q_PM_CheckoutSteps.cardSelection("Amex");
        Q_PM_CheckoutSteps.completeOrder();
        Q_PM_CheckoutSteps.isOrderComplete(tcName);
    }

    /*******************************************************************
     // * Description: Verifying user with Visa card 4456530000001096 profile Setup Success
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 17)
    public void setUpSuccess001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(44);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda", 3);
        //Q_PM_CheckoutSteps.selectItem("Maple Leaf 1 oz Copper Round", 10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        //Q_PM_CheckoutSteps.shippingForm(17);
        //Q_PM_CheckoutSteps.validateAddress();
//        Q_CheckoutSteps.cardSelection("newCard");
        //Q_PM_CheckoutSteps.creditForm(27);
        Q_PM_CheckoutSteps.cardSelection("visa");
        Q_PM_CheckoutSteps.checkoutModal(tcName);
        Q_PM_CheckoutSteps.isOrderComplete(tcName);
    }
    
    /*******************************************************************
     // * Description: Verifying user with Master Card 5200000000001096 profile Setup Success
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 18)
    public void setUpSuccess002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(44);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda", 3);
        Q_PM_CheckoutSteps.selectItem("Maple Leaf 1 oz Copper Round", 10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
//        Q_CheckoutSteps.shippingForm(17);
//        Q_CheckoutSteps.validateAddress();
        //Q_PM_CheckoutSteps.cardSelection("newCard");
        //Q_PM_CheckoutSteps.creditForm(28);
        Q_PM_CheckoutSteps.cardSelection("mc");
        Q_PM_CheckoutSteps.checkoutModal(tcName);
        Q_PM_CheckoutSteps.isOrderComplete(tcName);
    }
    
    /*******************************************************************
     // * Description: Verifying user with American Express card 340000000001098 profile Setup Success
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 19)
    public void setUpSuccess003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(44);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda", 3);
        Q_PM_CheckoutSteps.selectItem("Maple Leaf 1 oz Copper Round", 10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
//        Q_CheckoutSteps.shippingForm(17);
//        Q_CheckoutSteps.validateAddress();
        //Q_PM_CheckoutSteps.cardSelection("newCard");
        //Q_PM_CheckoutSteps.creditForm(29);
        Q_PM_CheckoutSteps.cardSelection("Amex");
        Q_PM_CheckoutSteps.checkoutModal(tcName);
        Q_PM_CheckoutSteps.isOrderComplete(tcName);

    }
    
    /*******************************************************************
     // * Description: Verifying user with Visa card 4456530000001104 profile enrolment setup auth unsuccessful
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 20)
    public void setupAuthUnsuccessful001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(45);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        //Q_PM_CheckoutSteps.shippingForm(18);
        //Q_PM_CheckoutSteps.validateAddress();
//        Q_CheckoutSteps.cardSelection("newCard");
        Q_PM_CheckoutSteps.creditForm(30);
        //Q_PM_CheckoutSteps.checkoutModalError();
        Q_PM_CheckoutSteps.checkoutModal(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsgContains("We are sorry but we are unable to process your credit card.");
    }
    
    /*******************************************************************
     // * Description: Verifying user with Master Card 5200000000001104 profile enrolment setup auth unsuccessful
     // * Author:
     // * Status:
     //*******************************************************************/
    @Test(priority = 21)
    public void setupAuthUnsuccessful002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(45);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.creditForm(31);
        //Q_PM_CheckoutSteps.checkoutModalError();
        Q_PM_CheckoutSteps.checkoutModal(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsgContains("We are sorry but we are unable to process your credit card.");
    }
    
    /*******************************************************************
     // * Description: Verifying user with American express 340000000001106 card profile setup auth unsuccessful
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 22)
    public void setupAuthUnsuccessful003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(45);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.creditForm(32);
        //Q_PM_CheckoutSteps.checkoutModalError();
        Q_PM_CheckoutSteps.checkoutModal(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsgContains("We are sorry but we are unable to process your credit card.");
    }
    
    /*******************************************************************
     // * Description: Verifying user with Visa card 4456530000001112 in their profile auth unavailable and user is presented with modal error message
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 23)
    public void setupAuthUnavailable001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(46);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        //Q_PM_CheckoutSteps.shippingForm(19);
        //Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.cardSelection("newCard");
        Q_PM_CheckoutSteps.creditForm(33);
        //Q_PM_CheckoutSteps.checkoutModalError();
        Q_PM_CheckoutSteps.checkoutModal(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    /*******************************************************************
     // * Description: Verifying user with Master Card 5200000000001112  in their profile auth unavailable and user is presented with modal error message
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 24)
    public void setupAuthUnavailable002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(46);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.cardSelection("newCard");
        Q_PM_CheckoutSteps.creditForm(34);
        //Q_PM_CheckoutSteps.checkoutModalError();
        Q_PM_CheckoutSteps.checkoutModal(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    /*******************************************************************
     // * Description: Verifying user with American Express card 340000000001114 in their profile auth unavailable and user is presented with modal error message
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 25)
    public void setupAuthUnavailable003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(46);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.cardSelection("newCard");
        Q_PM_CheckoutSteps.creditForm(35);
        //Q_PM_CheckoutSteps.checkoutModalError();
        Q_PM_CheckoutSteps.checkoutModal(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    
    /*******************************************************************
    // * Description: Turns 3DS off
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 26,enabled=true)
    public void turn3DSOff() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_Controls.adminLoginPM();
        admin.adminMenu("settings");
        Q_PM_WebElm.xp(pmQaProps, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("off");
        Q_PM_WebElm.myWait(1000);
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
