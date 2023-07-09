package testcases.payPal;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Q_PM_CheckoutSteps;
import testcases.cart.Q_PM_AddToCart;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

public class Q_PM_UnitPayPalCheckout extends Q_PM_Init {

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
    @Test(priority = 5)
    public static void PayPal()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.silver_2_2553739("16");
        Q_PM_CheckoutSteps.selectPaymentType("paypal_express");
        Q_PM_CheckoutSteps.payPal("automation.tester001@jmb.paypalsandbox.com", "Testing123!");
        Q_PM_CheckoutSteps.completeOrder("chk.finishPlaceOrder.id");

    }

}
