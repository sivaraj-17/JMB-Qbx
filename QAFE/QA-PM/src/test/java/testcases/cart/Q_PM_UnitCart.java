package testcases.cart;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Q_PM_AdminPmSteps;
import pageObjects.Q_PM_CartSteps;
import pageObjects.Q_PM_WebElm;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;


public class Q_PM_UnitCart extends Q_PM_Init {
    static ArrayList<String> pt1 = new ArrayList<String>(Arrays.asList("authorize_net_cim", "paypal_express", "authorize_net_cim_echeck", "cheque", "bacs", "bitpay"));
    static ArrayList<String> pt2 = new ArrayList<String>(Arrays.asList("authorize_net_cim", "paypal_express", "authorize_net_cim_echeck", "cheque", "bitpay"));
    static ArrayList<String> pt3 = new ArrayList<String>(Arrays.asList("paypal_express", "authorize_net_cim_echeck", "cheque", "bacs", "bitpay"));
    static ArrayList<String> pt4 = new ArrayList<String>(Arrays.asList("cheque", "bacs", "bitpay"));
    static ArrayList<String> pt5 = new ArrayList<String>(Arrays.asList("bacs", "bitpay"));
    static ArrayList<String> pt6 = new ArrayList<String>(Arrays.asList("bacs"));
    static ArrayList<String> pt7 = new ArrayList<String>(Arrays.asList("authorize_net_cim_echeck"));
    @BeforeClass
    public void tcSetup () throws Exception {

        Q_PM_Init.setItUp();

//        AccountSteps.loginUser(0);

    }
    @BeforeMethod
    public void setUser () throws FileNotFoundException, InterruptedException {
        }
    @Test (priority = 8)

    public static void editVerifyCart(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_1_2553140("6");
        Q_PM_AddToCart.gold_2_2555362("2");
        Q_PM_AddToCart.silver_1_2553427("1");
        Q_PM_AddToCart.silver_3_2568377("2");
        Q_PM_CartSteps.verifyEditCart();
    }
    @AfterMethod()
    public static void remove(){
//        CartSteps.verifyCartItems();
//        CartSteps.deleteItems();
    }
}
