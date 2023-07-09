package testcases.guest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.Q_JMB_AccountObjects;
import pageObjects.Q_JMB_CartPageObjects;
import pageObjects.Q_JMB_CheckoutObjects;

import pageObjects.Q_JMB_ProductPageObjects;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.util.ArrayList;

public class Q_JMB_UnitGuest extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();

    @BeforeClass
    public void tcSetup () throws Exception {

        Q_JMB_Init.setItUp();
    }
    @Test(priority = 10)
    public static void guestAllItemsTaxable() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        prod.selectItem("/1-oz-canadian-palladium-maple-leaf/",1);
        prod.selectItem("/5-oz-silvertowne-prospector-stackable-silver-round/",1);
        prod.selectItem("/dollar-air-tite-coin-tube/",20);
        prod.selectItem("/1-oz-quarter-copper-round/",20);
        cart.paymentType("cart.paymentType.CC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa+8jmb@jmbullion.com");
        chk.shippingAddressForm(34);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        chk.itemTax();
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
//        chk.completeOrder();
//        ArrayList<Float> orderPrices = new ArrayList<>(Q_CheckoutObjects.orderPriceList());
//        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    @AfterMethod
    public static void tearDown(){

        //CartSteps.emptyCart();

    }
    @AfterClass
    public static void kill(){
//        if (driver.toString().contains("Firefox")) {
//            driver.quit();
//        }
    }
}
