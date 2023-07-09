package testcases.shipping;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;

import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.util.ArrayList;

public class Q_JMB_UnitShipping extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
    static Q_JMB_CategoryObjects cat = new Q_JMB_CategoryObjects();
    static Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();

    @BeforeClass
    public void tcSetup () throws Exception {

        Q_JMB_Init.setItUp();
    }
    @Test(priority = 14)
    public static void revertShippingOptions()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        Q_JMB_CategoryObjects.perthMintGoldBar("1");
        Q_JMB_CategoryObjects.copperUSQuarter("2");
        cart.selectPaymentType("cheque");
        cart.selectcheckoutBtn("bottom");
        chk.regShippingUpgrade("option 3");
        ArrayList<Float> reviewPrices1 = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        System.out.println("First Option 3 Day Air: " + reviewPrices1);
        chk.regShippingUpgrade("option 2");
        ArrayList<Float> reviewPrices2 = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceListSh());
        System.out.println("Second Option Priority: " + reviewPrices2);
        chk.regShippingUpgrade("default");
        ArrayList<Float> reviewPrices3 = new  ArrayList<Float>(Q_JMB_CheckoutObjects.revPriceList());
        System.out.println("Third Option Default: " + reviewPrices3);
        Q_JMB_Controls.scrolUpPixel(200);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(Q_JMB_CheckoutObjects.orderPriceList());
        System.out.println(orderPrices);
        chk.verifyOrderCharges(reviewPrices3, orderPrices);
        acc.logoutUser();
    }




}
