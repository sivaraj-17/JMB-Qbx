package testcases.payPal;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Q_Slv_CartSteps;
import pageObjects.Q_Slv_CheckoutSteps;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

public class Q_Slv_UnitPayPalCheckout extends Q_Slv_Init {

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
}
