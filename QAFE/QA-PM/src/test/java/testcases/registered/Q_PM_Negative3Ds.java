package testcases.registered;

import org.testng.annotations.*;
import pageObjects.Q_PM_AccountSteps;
import pageObjects.Q_PM_AdminPmSteps;
import pageObjects.Q_PM_CartSteps;
import pageObjects.Q_PM_CheckoutSteps;
import pageObjects.Q_PM_WebElm;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;


public class Q_PM_Negative3Ds extends Q_PM_Init {
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
    @Test(priority = 1)
    public void turn3DSOn() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_Controls.adminLogin();
        admin.adminMenu("settings");
        Q_PM_WebElm.xp(pmQaProps, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("on");
        Q_PM_WebElm.myWait(1000);
    }

    /*******************************************************************
     // * Description: Verifying 3D Secure option Frictionless Checkout with Success (no prompt) fails  server authentication when  last name is "Reject"
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2)
    public void negFrictionlessCheckoutSuccess001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(48);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda",10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        //Q_PM_CheckoutSteps.shippingForm(35);
        //Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.creditForm(14);
        Q_PM_CheckoutSteps.attemptOrder(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsgContains("Your credit card failed due to one of three reasons");

    }
    /*******************************************************************
     // * Description: Verifying 3D Secure option Frictionless Checkout with no authentication (no prompt) user with last name Reject fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3)
    public void negFrictionlessCheckoutNoAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(48);
        Q_PM_CheckoutSteps.selectItem("Peace Silver Dollars | PCGS MS64)",10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");

        Q_PM_CheckoutSteps.creditForm(17);
        Q_PM_CheckoutSteps.attemptOrder(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsgContains("We are unable to complete your purchase, your card issuer replied with the following");
    }
    /*******************************************************************
     // * Description: Verifying Frictionless Checkout with unavailable authentication (no prompt) user with last name Reject fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4)
    public void negFrictionlessCheckoutUnAvailableAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(48);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda",10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
//        Q_CheckoutSteps.shippingForm(35);
//        Q_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.creditForm(14);
        Q_PM_CheckoutSteps.creditForm(21);
        Q_PM_CheckoutSteps.attemptOrder(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsg("We are sorry but we are unable to process your credit card.");

    }
    /*******************************************************************
     // * Description: Verifying user with last name "Reject" attempting checkout with 3D Secure card Frictionless Checkout with rejection (no prompt) fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5)
    public void negFrictionlessWithRejection001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(48);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda",10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
//        Q_CheckoutSteps.shippingForm(35);
//        Q_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.creditForm(21);
        Q_PM_CheckoutSteps.attemptOrder(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsg("We are sorry but we are unable to process your credit card.");

    }
    /*******************************************************************
     // * Description: Verifying user with last name Reject and Enrollment Check Error 3D Secure card fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6)
    public void negEnrolmentCheckoutError001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(48);
        Q_PM_CheckoutSteps.selectItem("10 gram Perth Mint Gold Bar",1);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_CheckoutSteps.creditForm(26);
        Q_PM_CheckoutSteps.attemptOrder(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsgContains("Your credit card failed due to one of three reasons");
    }
    /*******************************************************************
     // * Description: Verifying user attempting checkout with Step-Up Success 3D Secure card and last name Reject fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7)
    public void negSetUpSuccess001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(48);
        Q_PM_CheckoutSteps.selectItem("10 gram Perth Mint Gold Bar",1);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
//        Q_CheckoutSteps.shippingForm(35);
//        Q_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.creditForm(29);
        Q_PM_CheckoutSteps.checkoutModal(tcName);

    }
    /*******************************************************************
     // * Description: Verifying user attempting checkout with Step-Up Authentication Unsuccessful 3D Secure card and last name Reject fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8)
    public void negSetupAuthUnsuccessful001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(47);
        Q_PM_CheckoutSteps.selectItem("10 gram Perth Mint Gold Bar",1);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        //Q_PM_CheckoutSteps.shippingForm(35);
        //Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.creditForm(28);
        Q_PM_CheckoutSteps.checkoutModalError();
    }
    /*******************************************************************
     // * Description: Verifying user with last name Reject attempting Step-Up Authentication Unavailable 3D Secure card checkout fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9)
    public void negSetupAuthUnavailable001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(47);
        Q_PM_CheckoutSteps.selectItem("10 gram Perth Mint Gold Bar",1);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
//        Q_CheckoutSteps.shippingAddressForm(35);
//        Q_CheckoutSteps.saveShippingAddress();
        Q_PM_CheckoutSteps.creditForm(35);
        Q_PM_CheckoutSteps.checkoutModalError();
    }
    /*******************************************************************
     // * Description: Verifying guest user with last name Reject attempting Step-Up Authentication Unavailable 3D Secure card checkout fails server authentication
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 10)
    public void negGuestSetupAuthUnavailable001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_CheckoutSteps.selectItem("1 gram gold bar sunshine mint", 10);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.bridgeGuest();
        Q_PM_CheckoutSteps.guestEmail("testing123@jmbullion.com");
        Q_PM_CheckoutSteps.shippingForm(35);
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.creditForm(33);
        Q_PM_CheckoutSteps.checkoutModalError();
    }
    
    /*******************************************************************
    // * Description: Turns 3DS off
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 11)
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
