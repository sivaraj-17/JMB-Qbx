package testcases.cart;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;

import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

public class Q_JMB_UnitCart extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();

    @BeforeClass
    public void tcSetup () throws Exception {

        Q_JMB_Init.setItUp();
    }
    @Test(priority = 3)
    public void editCartModify (){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.goldEagle("1");
        Q_JMB_CategoryObjects.perthMintGoldBar("1");
        Q_JMB_CategoryObjects.silverPeaceSilverDollarCoi("6");
        Q_JMB_ProductPageObjects.platinumRampSuisseFortuna("2");
        Q_JMB_CategoryObjects.copperUSQuarter("10");
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        Q_JMB_WebElm.xp(jmbProps, "chk.reviewOrderNodify.xp");
        Q_JMB_CartPageObjects.editCartContent();

    }
    @AfterMethod
    public static void tearDown(){
//        CartPageObjects.removeItems();
    }


}
