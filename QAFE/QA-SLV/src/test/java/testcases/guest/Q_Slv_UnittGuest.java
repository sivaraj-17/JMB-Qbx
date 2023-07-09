package testcases.guest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Q_Slv_CartSteps;
import pageObjects.Q_Slv_CheckoutSteps;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.util.ArrayList;

public class Q_Slv_UnittGuest extends Q_Slv_Init {

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


    @Test(priority = 14)
    public static void guestFloridaTaxMixedItemPalladiumOver500() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.gold2("3");
        Q_Slv_CartSteps.addPdpProduct("/2018-w-1-oz-proof-palladium-american-eagle-coins-ngc-ms70-er/", "2");
        Q_Slv_CartSteps.silver1("1");
//        Q_CartSteps.addPdpProduct("/33-mm-air-tite-coin-tubes/", "10");
        Q_Slv_CartSteps.addPdpProduct("/41-mm-air-tite-coin-tubes/", "10");
        Q_Slv_CartSteps.addPdpProduct("/1-oz-us-quarter-copper-rounds/", "10");
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        Q_Slv_CheckoutSteps.guestEmail("chk.guest.email.name", "qa+8jmb@jmbullion.com");
        Q_Slv_CheckoutSteps.creditCardInput(3);
        Q_Slv_CheckoutSteps.shippingAutoAddress(34);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 8);

    }
}
