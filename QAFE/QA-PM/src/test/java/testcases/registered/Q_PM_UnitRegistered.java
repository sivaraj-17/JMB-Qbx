package testcases.registered;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Q_PM_AccountSteps;
import pageObjects.Q_PM_CheckoutSteps;

import pageObjects.Q_PM_WebElm;
import testcases.cart.Q_PM_AddToCart;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

import java.util.ArrayList;


public class Q_PM_UnitRegistered extends Q_PM_Init {
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

    @Test (priority = 10)

    public void minShippingApplied() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AccountSteps.loginUser(22);
        Q_PM_AddToCart.silver_1_2553427("1");
        Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        Q_PM_WebElm.myWait(1000);
        Q_PM_CheckoutSteps.cardSelection("defaultCard");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.revPriceListNoTax());
        Q_PM_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_PM_CheckoutSteps.orderPriceListNoTax());
        Q_PM_CheckoutSteps.verifyOrderCharges(reviewPrices, orderPrices);
        Float shippCharges = Float.valueOf(orderPrices.get(1));

        Assert.assertEquals(String.valueOf(shippCharges),"7.99");
        //AccountSteps.accountMenu("LOGOUT", 3);
    }

}
