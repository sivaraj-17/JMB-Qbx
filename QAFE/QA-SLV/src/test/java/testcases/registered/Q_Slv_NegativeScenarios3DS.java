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


public class Q_Slv_NegativeScenarios3DS extends Q_Slv_Init {
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
    @Test(priority = 1,enabled=true)
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
     // * Description: Verifying 3D Secure option Frictionless Checkout with Success (no prompt) fails  server authentication when  last name is "Reject"
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2)
    public void negFrictionlessCheckoutSuccess001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 45);
        Q_Slv_CartSteps.gold2("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
//        Q_CheckoutSteps.shippingAutoAddress(35);
//        Q_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(12);
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    /*******************************************************************
     // * Description: Verifying 3D Secure option Frictionless Checkout with no authentication (no prompt) user with last name Reject fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3)
    public void negFrictionlessCheckoutNoAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 45);
        Q_Slv_CartSteps.gold2("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(16);

        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("We are unable to complete your purchase, your card issuer replied with the following");
    }
    /*******************************************************************
     // * Description: Verifying Frictionless Checkout with unavailable authentication (no prompt) user with last name Reject fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4)
    public void negFrictionlessCheckoutUnAvailableAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 45);
        Q_Slv_CartSteps.gold2("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(20);
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    /*******************************************************************
     // * Description: Verifying user with last name "Reject" attempting checkout with 3D Secure card Frictionless Checkout with rejection (no prompt) fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5)
    public void negFrictionlessWithRejection001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 45);
        Q_Slv_CartSteps.gold2("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(21);
//        CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
    }
    /*******************************************************************
     // * Description: Verifying user with last name Reject and Enrollment Check Error 3D Secure card fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6)
    public void negEnrolmentCheckoutError001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 45);
        Q_Slv_CartSteps.gold2("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(25);
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    /*******************************************************************
     // * Description: Verifying user attempting checkout with Step-Up Success 3D Secure card and last name Reject fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7)
    public void negSetUpSuccess001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 45);
        Q_Slv_CartSteps.gold2("1");

        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(29);
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    /*******************************************************************
     // * Description: Verifying user attempting checkout with Step-Up Authentication Unsuccessful 3D Secure card and last name Reject fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8)
    public void negSetupAuthUnsuccessful001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 44);
        Q_Slv_CartSteps.gold2("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
//        Q_CheckoutSteps.shippingAutoAddress(35);
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(30);

        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("We are sorry but we are unable to process your credit card.");
    }
    /*******************************************************************
     // * Description: Verifying user with last name Reject attempting Step-Up Authentication Unavailable 3D Secure card checkout fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9)
    public void negSetupAuthUnavailable001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 45);
        Q_Slv_CartSteps.gold2("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(34);
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        //Q_Slv_CheckoutSteps.modalErrorMsg(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    /*******************************************************************
     // * Description: Verifying guest user with last name Reject attempting Step-Up Authentication Unavailable 3D Secure card checkout fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 10)
    public void negGuestSetupAuthUnavailable001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.gold2("1");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "test123@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(35);
        Q_Slv_CheckoutSteps.shippingAutoAddress(35);
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        //Q_Slv_CheckoutSteps.modalErrorMsg(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    
    /*******************************************************************
    // * Description: Turns 3DS off
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 11,enabled=true)
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
