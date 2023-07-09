package testcases.payPal;

import org.testng.annotations.*;
import pageObjects.Q_Slv_AccountSteps;
import pageObjects.Q_Slv_CartSteps;
import pageObjects.Q_Slv_CheckoutSteps;
import pageObjects.Q_Slv_WebElm;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.util.ArrayList;

public class Q_Slv_PayPal extends Q_Slv_Init {

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
    /*******************************************************************
    // * Description: Verify shipping charges applied on orders less than $100
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2)
    public static void payPal98Shipping399(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.copper2("99");
        Q_Slv_CheckoutSteps.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.className");

        Q_Slv_CheckoutSteps.payPalNext("automation.tester001@jmb.paypalsandbox.com", "Testing123!");
//        ArrayList<Float> prices = new  ArrayList<Float>(CheckoutSteps.revPriceListTax());
//        CheckoutSteps.completeOrder("sil.finishAndPlace.id");
        Q_Slv_CheckoutSteps.completeOrder();
//        ArrayList<Float> orderPrices = new  ArrayList<Float>(CheckoutSteps.orderPriceListTax());
//        CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        
    }
    /*******************************************************************
    // * Description: Verify user can choose different shipping option
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3)
    public static void payPal500DefShippingTax(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);

        Q_Slv_CartSteps.copper2("50");
        Q_Slv_CheckoutSteps.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.className");
        Q_Slv_CheckoutSteps.payPalNext("test1@jmbullion.com", "2014gold");

        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListSh());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
    }
    /*******************************************************************
    // * Description: Verify user can choose different option
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 4)
    public static void payPal500PriShippingTax(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.silver1("6");
        Q_Slv_CartSteps.copper2("10");
        Q_Slv_CheckoutSteps.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.className");
        Q_Slv_CheckoutSteps.payPalNext("test1@jmbullion.com", "2014gold");
        Q_Slv_CheckoutSteps.shippingOptionValue("chk.paypal.checkout.shipping.shippingoption2.xp", "chk.paypal.checkout.shipping.option2.value.xp");
        //Controls.captureScreen(driver, tcName);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListSh());
        Q_Slv_CheckoutSteps.completeOrder();
        //Controls.captureScreen(driver, tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
    }
    /*******************************************************************
    // * Description: Verify user can choose different option
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 5)
    public static void payPal5003DayShippingTax(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.silver3("1");
        Q_Slv_CartSteps.copper2("10");
        Q_Slv_CheckoutSteps.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.className");
        Q_Slv_CheckoutSteps.payPalNext("test1@jmbullion.com", "2014gold");
        Q_Slv_CheckoutSteps.shippingOptionValue("chk.paypal.checkout.shipping.shippingoption3.xp", "chk.paypal.checkout.shipping.option3.value.xp");
        //Controls.captureScreen(driver, tcName);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListSh());
        Q_Slv_CheckoutSteps.completeOrder();
        //Controls.captureScreen(driver, tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
    }

    /*******************************************************************
    // * Description: Verify user can choose different option
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 6)
    public static void payPal1kPlusNoShippingNoTax(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.silver2("1");
        Q_Slv_CheckoutSteps.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.className");
        Q_Slv_CheckoutSteps.payPalNext("test1@jmbullion.com", "2014gold");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
    /*******************************************************************
    // * Description: Verify user can choose different option
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 7)
    public static void payPal1kPlusPriShippingTax(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.gold3("1");
        Q_Slv_CartSteps.copper2("10");
        Q_Slv_CheckoutSteps.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.className");
        Q_Slv_CheckoutSteps.payPalNext("test1@jmbullion.com", "2014gold");
        Q_Slv_CheckoutSteps.shippingOptionValue("chk.paypal.checkout.shipping.shippingoption2.xp", "chk.paypal.checkout.shipping.option2.value.xp");
        //Controls.captureScreen(driver, tcName);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListSh());
        Q_Slv_CheckoutSteps.completeOrder();
        //Controls.captureScreen(driver, tcName);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
    }
    /*******************************************************************
    // * Description: Verifying valid gift certificate can be applied to PayPal checkout
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 8)
    public void payPalWithGiftCert(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
//        AccountSteps.login("sil.login.link.xp", 0);

        Q_Slv_CartSteps.applyGiftCertificate("300");
        Q_Slv_CheckoutSteps.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.className");
        Q_Slv_WebElm.myWait(2000);

        Q_Slv_CheckoutSteps.payPalNext("test1@jmbullion.com", "2014gold");
        Q_Slv_WebElm.myWait(6000);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListSh());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
    /*******************************************************************
	 * Description: This test case verifies user can place order with coupon code.
	 * Author:
	 * Status: Complete
	 * Ticket : JMB-6079(Unable to place order with a coupon code)
	 ********************************************************************/
	 @Test(priority = 9)
	 public void payPalApplyGiftCertWith50() throws Exception {
		 String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		 Q_Slv_Controls.testStarted(tcName);
		 Q_Slv_CartSteps.applyGiftCertificate("201","JMB-6079-Automation");
		 Q_Slv_CheckoutSteps.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.className");
		 Q_Slv_WebElm.myWait(2000);

		 Q_Slv_CheckoutSteps.payPalNext("madhusudan.jayasimha@qualitestgroup.com", "test123$");
		 Q_Slv_WebElm.myWait(5000);
		 ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
		 Q_Slv_CheckoutSteps.completeOrder();
		 ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
		 Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
	}
	/*******************************************************************
	 * Description: Verify Order over $299 should not charge shipping with coupon applied
	 * Author:
	 * Status: Complete
	 * Ticket : JMB-5894
	 ********************************************************************/
	@Test(priority = 10)
	public static void payPalNoShippingOrderOver299WithCoupon()throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
		Q_Slv_CartSteps.platinum1("3");
		Q_Slv_CartSteps.silver1("7");
		Q_Slv_CartSteps.applyGiftCertificate("33","HSD-5894");
		Q_Slv_CheckoutSteps.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.className");
		Q_Slv_WebElm.myWait(2000);
		Q_Slv_CheckoutSteps.payPalNext("test1@jmbullion.com", "2014gold");
		Q_Slv_WebElm.myWait(6000);
		ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
		Q_Slv_CheckoutSteps.completeOrder();
		ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
		Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 6);
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
