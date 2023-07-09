package testcases.guest;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

public class Q_PM_Guest3Ds extends Q_PM_Init {

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
        Q_PM_Controls.adminLogin();
        admin.adminMenu("settings");
        Q_PM_WebElm.xp(pmQaProps, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("on");
        Q_PM_WebElm.myWait(1000);
    }

    /*******************************************************************
     // * Description: Verify guest user placing order with 3D secure card 4456530000001005 can complete their order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2)
    public static void guestFrictionlessSuccess001()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.bridgeGuest();
        Q_PM_CheckoutSteps.guestEmail("guestFrictionlessSuccess@jmbullion.com");
        Q_PM_CheckoutSteps.shippingForm(6);
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.creditForm(13);
        Q_PM_CheckoutSteps.completeOrder();
        Q_PM_CheckoutSteps.isOrderComplete(tcName);
    }

    /*******************************************************************
     // * Description: Verify guest user placing order with 3D secure card 5200000000001013 can complete their order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3)
    public void guestFrictionlessNoAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.bridgeGuest();
        Q_PM_CheckoutSteps.guestEmail("guestFrictionlessNoAuth@jmbullion.com");
        Q_PM_CheckoutSteps.shippingForm(6);
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.creditForm(17);
        Q_PM_CheckoutSteps.attemptOrder(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsgContains("Additional authentication is required by the issuing bank");
    }
    
    /*******************************************************************
     // * Description: Verifying user with 3D Secure credit card checking out as Frictionless Checkout with rejection (no prompt) order completes successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4)
    public void guestFrictionlessUnavailableAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.bridgeGuest();
        Q_PM_CheckoutSteps.guestEmail("guestFrictionlessUnavailableAuth@jmbullion.com");
        Q_PM_CheckoutSteps.shippingForm(6);
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.creditForm(20);
        Q_PM_CheckoutSteps.completeOrder();
        Q_PM_CheckoutSteps.isOrderComplete(tcName);
    }
    
    /*******************************************************************
     // * Description: Verify 3D Secure frictionless checkout with rejection will result in error message
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5)
    public void guestFrictionlessWithRejection001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.bridgeGuest();
        Q_PM_CheckoutSteps.guestEmail("guestFrictionlessWithRejection@jmbullion.com");
        Q_PM_CheckoutSteps.shippingForm(6);
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.creditForm(22);
        Q_PM_CheckoutSteps.attemptOrder(tcName);
        Q_PM_CheckoutSteps.validateErrorrMsg("We are sorry but we are unable to process your credit card.");
    }
    
    /*******************************************************************
     // * Description: Verify 3D Secure credit card with enrollment checkout error user should be able to complete their order
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6)
    public void guestEnrollmentCheckError001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.bridgeGuest();
        Q_PM_CheckoutSteps.guestEmail("guestEnrollmentCheckError@jmbullion.com");
        Q_PM_CheckoutSteps.shippingForm(6);
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.creditForm(25);
        Q_PM_CheckoutSteps.completeOrder();
    }
    
    /*******************************************************************
     // * Description: Verify 3D Secure with Step-Up Success option user prompted to enter auth code in modal with successful code order completes successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7)
     public void guestSetupSucess001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_CheckoutSteps.selectItem("1/4 oz Chinese Gold Panda", 1);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.bridgeGuest();
        Q_PM_CheckoutSteps.guestEmail("guestSetupSucess@jmbullion.com");
        Q_PM_CheckoutSteps.shippingForm(6);
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.creditForm(28);
        Q_PM_CheckoutSteps.checkoutModal(tcName);
        Q_PM_CheckoutSteps.isOrderComplete(tcName);
    }
    
    /*******************************************************************
     // * Description: Verify 3D Secure option Set-Up Authentication Unseccessful will result in mdal error message
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8)
    public void guestSetupAuthUnsuccessful001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_CheckoutSteps.selectItem("1 gram gold bar sunshine mint", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.bridgeGuest();
        Q_PM_CheckoutSteps.guestEmail("guestSetupAuthUnsuccessful@jmbullion.com");
        Q_PM_CheckoutSteps.shippingForm(6);
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.creditForm(31);
        Q_PM_CheckoutSteps.checkoutModalError();
    }
    
    /*******************************************************************
     // * Description: Verify the modal error message when user attemps to checkout with credit card 3d Secure Set-Up Authenticationn Unavailable
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9)
    public void guestSetupAuthUnavailable001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_CheckoutSteps.selectItem("30 Gram Chinese Silver Panda", 3);
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.bridgeGuest();
        Q_PM_CheckoutSteps.guestEmail("guestSetupAuthUnavailable@jmbullion.com");
        Q_PM_CheckoutSteps.shippingForm(6);
        Q_PM_CheckoutSteps.validateAddress();
        Q_PM_CheckoutSteps.creditForm(34);
        Q_PM_CheckoutSteps.checkoutModalError();
    }
    
    /*******************************************************************
    // * Description: Turns 3DS off
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 10,enabled=true)
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
        Q_PM_Controls.tearDown();
    }
    
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
