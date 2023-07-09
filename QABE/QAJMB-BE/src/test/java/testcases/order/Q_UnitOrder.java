package testcases.order;

import org.testng.annotations.*;
import pageObjects.*;

import utils.Controls;
import utils.Init;

import java.io.FileNotFoundException;

public class Q_UnitOrder extends Init {
    static Q_AdminForm adm = new Q_AdminForm();
    static Q_CustomerForm cust = new Q_CustomerForm();
    static Q_ProductForm prod = new Q_ProductForm();
    static Q_HoldsForm hold = new Q_HoldsForm();
    static Q_OrderForm ord = new Q_OrderForm();
    static Q_Buyback bb = new Q_Buyback();
    static Q_CheckoutForm chk = new Q_CheckoutForm();
    static Q_NewFeatures nfal = new Q_NewFeatures();
    static Controls li = new Controls();

    @BeforeClass
    public void tcSetup (){

    }
    @BeforeMethod
    public void report() throws Exception {
        Init.setItUp();
    }
    @BeforeTest
    public void setTest() throws Exception {
    }


    @Test (priority = 4, enabled = true)
    public static void verifyPaidOrderAbleToChangeShippingOption() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        chk.selectItem("silverEagle1994", 2);
        driver.navigate().to(adminUrl);
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.changeOrderStatus("paid");
        ord.changeShippingMethod("USPS Priority");
        ord.changeShippingMethod("UPS 3-Day Air");
        ord.changeShippingMethod("UPS 2-Day Air");
        ord.changeShippingMethod("UPS Legacy");
        ord.changeShippingMethod("USPS Legacy");
        ord.changeShippingMethod("USPS Registered");
        ord.changeShippingMethod("IRA");
        ord.changeShippingMethod("TDS");
        ord.changeShippingMethod("Internal Transfer");
        /* Note ticket verifies API through a published PHP which is excluded
         * as it is OOS for automation*/
    }
    @AfterMethod
    public void tearDown() throws Exception {
//        Controls.tearDown();
    }

}


