package testcases.guest;

import org.testng.annotations.*;
import pageObjects.*;
import utils.*;
import org.testng.Assert;

import java.util.ArrayList;

public class Q_Slv_guest3ds extends Q_Slv_Init {

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
     // * Description: Verify guest user placing order with 3D secure card 5200000000001005 can complete their order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2)
    public void guestFrictionlessSuccess001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.silver1("10");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "guestFrictionlessSuccess@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(13);
        Q_Slv_CheckoutSteps.shippingAutoAddress(14);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
//        CheckoutSteps.completeOrder("sil.guest.finishAndPlace.id");
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
    
    /*******************************************************************
     // * Description: Verify guest user placing order with 3D secure card 5200000000001005 can complete their order successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3)
    public void guestFrictionlessNoAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.silver1("10");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "guestFrictionlessNoAuth@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(15);
        Q_Slv_CheckoutSteps.shippingAutoAddress(11);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
//        CheckoutSteps.completeOrder("sil.guest.finishAndPlace.id");
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("Additional authentication is required by the issuing bank");
    }
    
    /*******************************************************************
     // * Description: Verifying user with 3D Secure credit card checking out as Frictionless Checkout with rejection (no prompt) order completes successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4)
    public void guestFrictionlessUnavailableAuth001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.silver1("10");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "guestFrictionlessUnavailableAuth@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(20);
        Q_Slv_CheckoutSteps.shippingAutoAddress(11);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
//        CheckoutSteps.completeOrder("sil.guest.finishAndPlace.id");
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
    
    /*******************************************************************
     // * Description: Verify 3D Secure frictionless checkout with rejection will result in error message
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5)
    public void guestFrictionlessWithRejection001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.silver1("10");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "guestFrictionlessWithRejection@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(22);
        Q_Slv_CheckoutSteps.shippingAutoAddress(19);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
//        CheckoutSteps.completeOrder("sil.guest.finishAndPlace.id");
        Q_Slv_CheckoutSteps.attemptOrder(tcName);
        Q_Slv_CheckoutSteps.validateErrorrMsgContains("We are sorry but we are unable to process your credit card.");
    }
    
    /*******************************************************************
     // * Description: Verify 3D Secure credit card with enrollment checkout error user should be able to complete their order
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6)
    public void guestEnrollmentCheckError001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.silver1("10");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "guestEnrollmentCheckError@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(26);
        Q_Slv_CheckoutSteps.shippingAutoAddress(17);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
//        CheckoutSteps.completeOrder("sil.guest.finishAndPlace.id");
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
    
    /*******************************************************************
     // * Description: Verify 3D Secure with Step-Up Success option user prompted to enter auth code in modal with successful code order completes successfully
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7)
    public void guestSetupSucess001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.gold2("1");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "guestSetupSucess@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(29);
        Q_Slv_CheckoutSteps.shippingAutoAddress(17);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
//        CheckoutSteps.completeOrder("sil.guest.finishAndPlace.id");
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
    
    /*******************************************************************
     // * Description: Verify 3D Secure option Set-Up Authentication Unseccessful will result in mdal error message
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8)
    public void guestSetupAuthUnsuccessful001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.gold2("1");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "guestSetupAuthUnsuccessful@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(31);
        Q_Slv_CheckoutSteps.shippingAutoAddress(12);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
//        CheckoutSteps.completeOrder("sil.guest.finishAndPlace.id");
        Q_Slv_CheckoutSteps.checkoutModalError();
        Q_Slv_CheckoutSteps.modalErrorMsg(tcName);

    }
    /*******************************************************************
     // * Description: Verify the modal error message when user attemps to checkout with credit card 3d Secure Set-Up Authenticationn Unavailable
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9)
    public void guestSetupAuthUnavailable001() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.silver1("5");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "guestSetupAuthUnavailable@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(33);
        Q_Slv_CheckoutSteps.shippingAutoAddress(12);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
//        CheckoutSteps.completeOrder("sil.guest.finishAndPlace.id");
        Q_Slv_CheckoutSteps.checkoutModal(tcName);
        Q_Slv_CheckoutSteps.modalErrorMsg(tcName);
    }
    
    /*******************************************************************
    // * Description: Turns 3DS off
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 10,enabled=true)
    public void turn3DSOff() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_Controls.adminLogin();
        admin.adminMenu("settings");
        Q_Slv_WebElm.xp(SLVqProp, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("off");
        Q_Slv_WebElm.myWait(1000);
    }
    
    @AfterTest
    public void endReport(){
    }
    @AfterMethod
    public void tearDown() throws Exception {
//        CartSteps.emptyCart();
        Q_Slv_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }

}
