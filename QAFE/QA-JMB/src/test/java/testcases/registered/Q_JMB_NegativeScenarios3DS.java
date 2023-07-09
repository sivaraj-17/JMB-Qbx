package testcases.registered;

//import steps.AccountSteps;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;


public class Q_JMB_NegativeScenarios3DS extends Q_JMB_Init {
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
     // * Description: Verifying 3D Secure option Frictionless Checkout with Success (no prompt) fails  server authentication when  last name is "Reject"
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2)
    public void negFrictionlessCheckoutSuccess001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(48);
        chk.selectItem("2016 30 g chinese silver panda",10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        //chk.shippingAddressForm(35);
        //chk.saveShippingAddress();
        chk.creditCardForm(13);
        chk.attemptOrder(tcName);
        chk.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    
    /*******************************************************************
     // * Description: Verifying 3D Secure option Frictionless Checkout with no authentication (no prompt) user with last name Reject fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3)
    public void negFrictionlessCheckoutNoAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(48);
        chk.selectItem("2016 30 g chinese silver panda",10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
//        chk.shippingAddressForm(35);
//        chk.saveShippingAddress();
        chk.creditCardForm(17);
        chk.attemptOrder(tcName);
        chk.validateErrorrMsgContains("We are unable to complete your purchase, your card issuer replied with the following");
    }
    
    /*******************************************************************
     // * Description: Verifying Frictionless Checkout with unavailable authentication (no prompt) user with last name Reject fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4)
    public void negFrictionlessCheckoutUnAvailableAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(48);
        chk.selectItem("2016 30 g chinese silver panda",10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
//        chk.shippingAddressForm(35);
//        chk.saveShippingAddress();
        chk.creditCardForm(21);
        chk.attemptOrder(tcName);
        chk.validateErrorrMsg("Your credit card failed due to one of three reasons");
    }
    
    /*******************************************************************
     // * Description: Verifying user with last name "Reject" attempting checkout with 3D Secure card Frictionless Checkout with rejection (no prompt) fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5)
    public void negFrictionlessWithRejection001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(48);
        chk.selectItem("2016 30 g chinese silver panda",10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
//        chk.shippingAddressForm(35);
//        chk.saveShippingAddress();
        chk.creditCardForm(22);
        chk.attemptOrder(tcName);
        chk.validateErrorrMsg("We are sorry but we are unable to process your credit card.");
    }
    
    /*******************************************************************
     // * Description: Verifying user with last name Reject and Enrollment Check Error 3D Secure card fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6)
    public void negEnrolmentCheckoutError001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(48);
        chk.selectItem("2016 30 g chinese silver panda",10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
//        chk.shippingAddressForm(35);
//        chk.saveShippingAddress();
        chk.creditCardForm(26);
        chk.attemptOrder(tcName);
        chk.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    
    /*******************************************************************
     // * Description: Verifying user attempting checkout with Step-Up Success 3D Secure card and last name Reject fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7)
    public void negSetUpSuccess001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(48);
        chk.selectItem("2016 30 g chinese silver panda",10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
//        chk.shippingAddressForm(35);
//        chk.saveShippingAddress();
        chk.creditCardForm(30);
        chk.checkoutModal(tcName);
        chk.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    
    /*******************************************************************
     // * Description: Verifying user attempting checkout with Step-Up Authentication Unsuccessful 3D Secure card and last name Reject fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8)
    public void negSetupAuthUnsuccessful001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(47);
        chk.selectItem("2016 30 g chinese silver panda",10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        //chk.shippingAddressForm(35);
        //chk.saveShippingAddress();
        chk.creditCardForm(31);
        //chk.checkoutModalError();
        chk.checkoutModal(tcName);
        chk.validateErrorrMsg("We are sorry but we are unable to process your credit card.");
    }
    
    /*******************************************************************
     // * Description: Verifying user with last name Reject attempting Step-Up Authentication Unavailable 3D Secure card checkout fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9)
    public void negSetupAuthUnavailable001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(47);
        chk.selectItem("2016 30 g chinese silver panda",10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
//        chk.shippingAddressForm(35);
//        chk.saveShippingAddress();
        chk.creditCardForm(35);
        chk.checkoutModalError();
    }
    
    /*******************************************************************
     // * Description: Verifying guest user with last name Reject attempting Step-Up Authentication Unavailable 3D Secure card checkout fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 10)
    public void negGuestSetupAuthUnavailable001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("2016 30 g chinese silver panda", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("test123456789@jmbullion.com");
        chk.shippingAddressForm(35);
        chk.saveShippingAddress();
        chk.creditCardForm(34);
        chk.checkoutModalError();
    }
    
    /*******************************************************************
    // * Description: Turns 3DS off
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 11,enabled=true)
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
        Q_JMB_Controls.tearDown();
    }
    
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
