package testcases.guest;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.io.FileNotFoundException;

public class Q_JMB_Guest3ds extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
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
     // * Description: Verify guest user placing order with 3D secure card 4456530000001005 can complete their order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2)
    public static void guestFrictionlessSuccess001 () throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("2016 30 g chinese silver panda", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("test123456789@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(13);
        chk.completeOrder();
        chk.thankYouPage();

    }
    /*******************************************************************
     // * Description: Verify guest user placing order with 3D secure card 5200000000001013 can complete their order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3)
    public void guestFrictionlessNoAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("2016 30 g chinese silver panda", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("test123456789@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(17);
        chk.attemptOrder(tcName);
    }
    /*******************************************************************
     // * Description: Verifying user with 3D Secure credit card checking out as Frictionless Checkout with rejection (no prompt) order completes successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4)
    public void guestFrictionlessUnavailableAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("2016 30 g chinese silver panda", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("test123456789@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(21);
        chk.completeOrder();
        chk.isOrderComplete(tcName);

    }
    /*******************************************************************
     // * Description: Verify 3D Secure frictionless checkout with rejection will result in error message
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5)
    public void guestFrictionlessWithRejection001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("2016 30 g chinese silver panda", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("test123456789@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(23);
        chk.attemptOrder(tcName);
        chk.validateErrorrMsg("We are sorry but we are unable to process your credit card.");

    }
    /*******************************************************************
     // * Description: Verify 3D Secure credit card with enrollment checkout error user should be able to complete their order
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6)
    public void guestEnrollmentCheckError001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("2016 30 g chinese silver panda", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("test123456789@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(25);
        chk.completeOrder();
        chk.isOrderComplete(tcName);
    }
    /*******************************************************************
     // * Description: Verify 3D Secure with Step-Up Success option user prompted to enter auth code in modal with successful code order completes successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7)
    public void guestSetupSucess001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("2016 30 g chinese silver panda", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("test123456789@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(30);
        chk.checkoutModal(tcName);
        chk.isOrderComplete(tcName);
    }
    /*******************************************************************
     // * Description: Verify 3D Secure option Set-Up Authentication Unseccessful will result in mdal error message
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8)
    public void guestSetupAuthUnsuccessful001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("2016 30 g chinese silver panda", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("test123456789@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(31);
        chk.checkoutModalError();

    }
    /*******************************************************************
     // * Description: Verify the modal error message when user attemps to checkout with credit card 3d Secure Set-Up Authenticationn Unavailable
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9)
    public void guestSetupAuthUnavailable001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        chk.selectItem("2016 30 g chinese silver panda", 10);
        cart.selectPaymentType("credit card");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("test123456789@jmbullion.com");
        chk.shippingAddressForm(6);
        chk.saveShippingAddress();
        chk.creditCardForm(34);
        chk.checkoutModalError();
    }
    
    /*******************************************************************
    // * Description: Turns 3DS off
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 10,enabled=true)
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
       // Q_JMB_CartPageObjects.removeItems();
        Q_JMB_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
