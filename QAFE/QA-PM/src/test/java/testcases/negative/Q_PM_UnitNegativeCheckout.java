package testcases.negative;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.Q_PM_CartSteps;
import pageObjects.Q_PM_CheckoutSteps;
import pageObjects.Q_PM_WebElm;
import testcases.cart.Q_PM_AddToCart;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

public class Q_PM_UnitNegativeCheckout extends Q_PM_Init {

    @BeforeClass
    public void tcSetup () throws Exception {

        Q_PM_Init.setItUp();
    }
    @Test(priority = 2)
    public static void payPalPuertoRico()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.silver_2_2553739("6");
        Q_PM_CheckoutSteps.selectPaymentType("paypal_express");
        Q_PM_CheckoutSteps.payPal("automation.tester001@jmb.paypalsandbox.com", "Testing123!");
        Q_PM_CheckoutSteps.completeOrder();
        System.out.println(Q_PM_WebElm.xpRetText(pmQaProps, "chk.ppPuertoError.xp"));
        Assert.assertTrue(Q_PM_WebElm.xpRetText(pmQaProps, "chk.ppPuertoError.xp").contains( "We are sorry! We do not ship to Puerto Rico or any US territory"));
        driver.navigate().to(baseUrl + "/cart");
        Q_PM_CartSteps.deleteItems();
    }

}
