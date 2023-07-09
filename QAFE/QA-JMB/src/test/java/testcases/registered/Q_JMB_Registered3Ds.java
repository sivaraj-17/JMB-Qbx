package testcases.registered;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.util.ArrayList;


public class Q_JMB_Registered3Ds extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
    static Q_JMB_CategoryObjects cat = new Q_JMB_CategoryObjects();
    static Q_JMB_AdminObjects admin = new Q_JMB_AdminObjects();
    static Q_JMB_Controls cont = new Q_JMB_Controls();

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
    // * Description: Turns 3DS on
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1,enabled=true)
    public void turn3DSOn() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_Controls.adminLogin();
        admin.adminMenu("settings");
        Q_JMB_WebElm.xp(jmbProps, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("on");
        Q_JMB_WebElm.myWait(1000);
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
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(39);
        chk.selectItem("2016 30 g chinese silver panda",1);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        //chk.shippingAddressForm(23);
        //chk.saveShippingAddress();
        //chk.creditCardForm(13);
        chk.selectCard("visa", "961");
        chk.completeOrder();
        chk.thankYouPage();
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
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(39);
        chk.selectItem("2-5-gram-valcambi-gold-bar",4);
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        //chk.newCardClick();
        //chk.creditCardForm(14);
        chk.selectCard("mc", "961");
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /*******************************************************************
     // * Description: Verifying user can switch between Frictionless Checkout with Success to amex cards 340000000001007 on his/ her profile
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4, enabled = true)
    public void FrictionlessCheckoutSuccess003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(39);
        chk.selectItem("2-5-gram-valcambi-gold-bar",1);
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.selectCard("amex", "9061");
//        chk.regShippingUpgrade("option 2");
//        chk.shippingAddressForm(23);
        //chk.newCardClick();
        //chk.creditCardForm(15);
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with no authentication visa cards 4456530000001013
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5)
    public void FrictionlessNoAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(40);
        chk.selectItem("2016 30 g chinese silver panda",3);
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        //chk.shippingAddressForm(1);
        //chk.saveShippingAddress();
//        chk.newCardClick();
        chk.creditCardForm(16);
        //chk.selectCard("visa", "901");
        chk.attemptOrder(tcName);
        chk.validateErrorrMsg("We are unable to complete your purchase, your card issuer replied with the following");
    }
    
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with no authentication master cards 5200000000001013
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6)
    public void FrictionlessNoAuth002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(40);
        chk.selectItem("2016 30 g chinese silver panda",3);
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
//        chk.shippingAddressForm(1);
//        chk.saveShippingAddress();
//        chk.newCardClick();
        chk.creditCardForm(17);
        chk.attemptOrder(tcName);
        chk.validateErrorrMsg("We are unable to complete your purchase, your card issuer replied with the following");
    }

    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with no authentication American Express card
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7)
    public void FrictionlessNoAuth003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(40);
        chk.selectItem("2016 30 g chinese silver panda",3);
        chk.selectItem("1 oz US Quarter Copper", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
//        chk.shippingAddressForm(1);
//        chk.saveShippingAddress();
//        chk.newCardClick();
        chk.creditCardForm(18);
        chk.attemptOrder(tcName);
        chk.validateErrorrMsg("We are unable to complete your purchase, your card issuer replied with the following");
    }
    
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with auth unavailable Visa Express card 4456530000001039
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8)
    public void FrictionlessUnavailableAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(41);
        chk.selectItem("2016 30 g chinese silver panda",3);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.selectCard("visa", "961");

        //chk.shippingAddressForm(14);
        //chk.saveShippingAddress();
//        chk.newCardClick();
        //chk.creditCardForm(19);
        chk.completeOrder();
        chk.isOrderComplete(tcName);
    }
    
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with auth unavailable mastercard card 5200000000001039
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9)
    public void FrictionlessUnavailableAuth002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(41);
        chk.selectItem("2016 30 g chinese silver panda",1);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.selectCard("mc", "961");

//        chk.shippingAddressForm(14);
//        chk.saveShippingAddress();
        //chk.newCardClick();
        //chk.creditCardForm(20);
        chk.completeOrder();
        chk.isOrderComplete(tcName);
    }
    
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless Checkout with auth unavailable American Express card 340000000001031
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 10)
    public void FrictionlessUnavailableAuth003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(41);
        chk.selectItem("2016 30 g chinese silver panda",3);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.selectCard("amex", "9061");

//        chk.shippingAddressForm(14);
//        chk.saveShippingAddress();
        //chk.newCardClick();
        //chk.creditCardForm(21);
        chk.completeOrder();
        chk.isOrderComplete(tcName);
    }
    
    /*******************************************************************
     // * Description: Verifying user attempts Frictionless with rejection checkout visa card 4456530000001047
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 11)
    public void FrictionlessWithRejectio001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(42);
        chk.selectItem("2016 30 g chinese silver panda",3);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        //chk.shippingAddressForm(15);
        //chk.saveShippingAddress();
//        chk.newCardClick();
        chk.creditCardForm(22);
        chk.attemptOrder(tcName);
        chk.validateErrorrMsg("We are sorry but we are unable to process your credit card.");
    }

    /*******************************************************************
     // * Description: Verifying user attempts Frictionless with rejection checkout master card 5200000000001047
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 12)
    public void FrictionlessWithRejection002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(42);
        chk.selectItem("2016 30 g chinese silver panda",3);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
//        chk.shippingAddressForm(15);
//        chk.saveShippingAddress();
//        chk.newCardClick();
        chk.creditCardForm(23);
        chk.attemptOrder(tcName);
        chk.validateErrorrMsg("We are sorry but we are unable to process your credit card.");
    }

    /*******************************************************************
     // * Description: Verifying user attempts Frictionless with rejection checkout American Express card 340000000001049
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 13)
    public void FrictionlessWithRejection003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(42);
        chk.selectItem("2016 30 g chinese silver panda",3);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
//        chk.shippingAddressForm(15);
//        chk.saveShippingAddress();
//        chk.newCardClick();
        chk.creditCardForm(24);
        chk.attemptOrder(tcName);
        chk.validateErrorrMsg("We are sorry but we are unable to process your credit card.");
    }
    
    /*******************************************************************
     // * Description: Verifying user with visa card 4456530000001062 profile enrolment check error can complete order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 14)
    public void enrolmentCheckError001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(43);
        chk.selectItem("2.5 Gram Valcambi Gold Bar",1);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        //chk.shippingAddressForm(2);
        //chk.saveShippingAddress();
        //chk.creditCardForm(25);
        chk.selectCard("visa", "714");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        chk.completeOrder();
        chk.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     // * Description: Verifying user with master card 5200000000001062 profile enrolment check error can complete order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 15)
    public void enrolmentCheckError002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(43);
        chk.selectItem("2.5 Gram Valcambi Gold Bar",3);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
//        chk.shippingAddressForm(2);
//        chk.saveShippingAddress();
        //chk.newCardClick();
        //chk.creditCardForm(26);
        chk.selectCard("mc", "714");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        chk.completeOrder();
        chk.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     // * Description: Verifying user with American express card 340000000001064 profile enrolment check error can complete order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 16)
    public void enrolmentCheckError003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(43);
        chk.selectItem("2.5 Gram Valcambi Gold Bar",3);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
//        chk.shippingAddressForm(2);
//        chk.saveShippingAddress();
        //chk.newCardClick();
        //chk.creditCardForm(27);
        chk.selectCard("amex", "7014");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        chk.completeOrder();
        chk.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        chk.verifyOrderCharges(reviewPrices, orderPrices);
    }

    /*******************************************************************
     // * Description: Verifying user with Visa card 4456530000001096 profile Setup Success
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 17)
    public void setUpSuccess001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(44);
        chk.selectItem("2.5 Gram Valcambi Gold Bar",2);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        //chk.shippingAddressForm(17);
        //chk.saveShippingAddress();
        //chk.newCardClick();
        //chk.creditCardForm(28);
        chk.selectCard("visa", "096");
        chk.checkoutModal(tcName);
        chk.isOrderComplete(tcName);
    }
    
    /*******************************************************************
     // * Description: Verifying user with Master Card 5200000000001096 profile Setup Success
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 18)
    public void setUpSuccess002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(44);
        chk.selectItem("2.5 Gram Valcambi Gold Bar",2);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
//        chk.shippingAddressForm(18);
//        chk.saveShippingAddress();
        //chk.newCardClick();
        //chk.creditCardForm(29);
        chk.selectCard("mc", "096");
        chk.checkoutModal(tcName);
        chk.isOrderComplete(tcName);
    }
    
    /*******************************************************************
     // * Description: Verifying user with American Express card 340000000001098 profile Setup Success
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 19)
    public void setUpSuccess003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(44);
        chk.selectItem("2.5 Gram Valcambi Gold Bar",2);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.newCardClick();
        chk.creditCardForm(30);
        //chk.selectCard("amex", "1098");
        chk.checkoutModal(tcName);
        chk.isOrderComplete(tcName);
    }
    
    /*******************************************************************
     // * Description: Verifying user with Visa card 4456530000001104 profile enrolment setup auth unsuccessful
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 20)
    public void setupAuthUnsuccessful001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(45);
        chk.selectItem("2016 30 g chinese silver panda",3);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        //chk.shippingAddressForm(18);
        //chk.saveShippingAddress();
        chk.creditCardForm(31);
        //chk.checkoutModalError();
        chk.checkoutModal(tcName);
        chk.validateErrorrMsg("We are sorry but we are unable to process your credit card.");
    }
    
    /*******************************************************************
     // * Description: Verifying user with Master Card 5200000000001104 profile enrolment setup auth unsuccessful
     // * Author:
     // * Status:
     //*******************************************************************/
    @Test(priority = 21)
    public void setupAuthUnsuccessful002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(45);
        chk.selectItem("2016 30 g chinese silver panda",3);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
//        chk.shippingAddressForm(18);
//        chk.saveShippingAddress();
        chk.creditCardForm(32);
        //chk.checkoutModalError();
        chk.checkoutModal(tcName);
        chk.validateErrorrMsg("We are sorry but we are unable to process your credit card.");
    }
    
    /*******************************************************************
     // * Description: Verifying user with American express 340000000001106 card profile setup auth unsuccessful
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 22)
    public void setupAuthUnsuccessful003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(45);
        chk.selectItem("2016 30 g chinese silver panda",3);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.creditCardForm(33);
        //chk.checkoutModalError();
        chk.checkoutModal(tcName);
        chk.validateErrorrMsg("We are sorry but we are unable to process your credit card.");
    }
    
    /*******************************************************************
     // * Description: Verifying user with Visa card 4456530000001112 in their profile auth unavailable and user is presented with modal error message
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 23)
    public void setupAuthUnavailable001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(46);
        chk.selectItem("2016 30 g chinese silver panda",3);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        //hk.shippingAddressForm(19);
        //chk.saveShippingAddress();
        chk.creditCardForm(34);
        //chk.checkoutModalError();
        chk.checkoutModal(tcName);
        chk.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    
    /*******************************************************************
     // * Description: Verifying user with Master Card 5200000000001112  in their profile auth unavailable and user is presented with modal error message
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 24)
    public void setupAuthUnavailable002() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(46);
        chk.selectItem("2016 30 g chinese silver panda",3);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.creditCardForm(35);
        //chk.checkoutModalError();
        chk.checkoutModal(tcName);
        chk.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    
    /*******************************************************************
     // * Description: Verifying user with American Express card 340000000001114 in their profile auth unavailable and user is presented with modal error message
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 25)
    public void setupAuthUnavailable003() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(46);
        chk.selectItem("2016 30 g chinese silver panda",3);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.creditCardForm(36);
        //chk.checkoutModalError();
        chk.checkoutModal(tcName);
        chk.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    
    /*******************************************************************
    // * Description: Turns 3DS off
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 26,enabled=true)
    public void turn3DSOff() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_Controls.adminLogin();
        admin.adminMenu("settings");
        Q_JMB_WebElm.xp(jmbProps, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("off");
        Q_JMB_WebElm.myWait(1000);
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
