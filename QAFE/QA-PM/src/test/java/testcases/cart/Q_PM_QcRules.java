package testcases.cart;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Q_PM_AccountSteps;
import pageObjects.Q_PM_CartSteps;
import pageObjects.Q_PM_WebElm;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

import java.util.ArrayList;
import java.util.Arrays;


public class Q_PM_QcRules extends Q_PM_Init {
    static ArrayList<String> pt1 = new ArrayList<String>(Arrays.asList("authorize_net_cim", "paypal_express", "authorize_net_cim_echeck", "cheque", "bacs", "bitpay"));
    static ArrayList<String> pt2 = new ArrayList<String>(Arrays.asList("authorize_net_cim", "paypal_express", "authorize_net_cim_echeck", "cheque", "bitpay"));
    static ArrayList<String> pt3 = new ArrayList<String>(Arrays.asList("paypal_express", "authorize_net_cim_echeck", "cheque", "bacs", "bitpay"));
    static ArrayList<String> pt4 = new ArrayList<String>(Arrays.asList("authorize_net_cim_echeck", "cheque", "bacs", "bitpay"));
    static ArrayList<String> pt5 = new ArrayList<String>(Arrays.asList("paypal_express", "bacs", "bitpay"));
    static ArrayList<String> pt6 = new ArrayList<String>(Arrays.asList("bacs", "bitpay"));
    static ArrayList<String> pt7 = new ArrayList<String>(Arrays.asList("bacs"));
    
    @BeforeClass
    public void tcSetup () throws Exception {

        Q_PM_Init.setItUp();
        Q_PM_AccountSteps.loginUser(29);
    }
    
    @BeforeMethod
    public void setUser (){

    }

    /*******************************************************************
    // * Description: Verify All Payment Options for Orders > 2.5K and < 10k
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1)
    public static void allPaymentTypes(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_1_2553140("3");
        Q_PM_CartSteps.paymentType("Available Types", pt1);
    }
    
    /*******************************************************************
    // * Description: Verify Bank Wire not a available options for orders < 2.5K K
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 2)
    public static void bwUnavailable(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_3_2553276("2");
        System.out.println(Q_PM_WebElm.cnReturnAllOptions(pmQaProps, "cart.paymentType.className"));
        Q_PM_WebElm.cnReturnAllOptions(pmQaProps, "cart.paymentType.className");
        Q_PM_CartSteps.paymentType("Available Types", pt2);
    }
    
    /*******************************************************************
    // * Description: Verify Credit Card Payment Options not available for Orders > 10K and < 250 K
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 3)
    public static void ccPaymentNotAvailable(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_1_2553140("8");
        Q_PM_AddToCart.gold_4_2569050("1");
        System.out.println(Q_PM_WebElm.cnReturnAllOptions(pmQaProps, "cart.paymentType.className"));
        Q_PM_CartSteps.paymentType("Available Types", pt3);
    }
    
    /*******************************************************************
    // * Description: Verify Credit Card and ACH not available options for orders > 25K and < 250 K
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 4)
    public static void echeckPcBwBcAvailable(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_4_2569050("4");
        System.out.println(Q_PM_WebElm.cnReturnAllOptions(pmQaProps, "cart.paymentType.className"));
        Q_PM_CartSteps.paymentType("Available Types", pt4);
    }
    
    /*******************************************************************
    // * Description: Verify PayPal, Bank Wire and Bitcoin only available options for orders > 50K and < 250 K
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 5, enabled = false)
    public static void ppBwBcAvailable(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_1_2553140("28");
        System.out.println(Q_PM_WebElm.cnReturnAllOptions(pmQaProps, "cart.paymentType.className"));
        Q_PM_CartSteps.paymentType("Available Types", pt5);
    }
    
    /*******************************************************************
    // * Description: Verify Bank Wire and Bitpay only available options for orders >60K and < 250K
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 6)
    public static void bwBcOnly(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_4_2569050("8");
        System.out.println(Q_PM_WebElm.cnReturnAllOptions(pmQaProps, "cart.paymentType.className"));
        Q_PM_CartSteps.paymentType("Available Types", pt6);
    }
    
    /*******************************************************************
    // * Description: Verify Orders > 250k need CSR Assistance
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 7)
    public static void callCSR(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_4_2569050("30");
        System.out.println(Q_PM_WebElm.cnReturnAllOptions(pmQaProps, "cart.paymentType.className"));
        Assert.assertTrue(Q_PM_WebElm.cnDisplayed(pmQaProps, "cart.woocommerce-error.className"));
    }

    @AfterMethod
    public static void tearDown(){
        //CartSteps.verifyCartItems();
        Q_PM_CartSteps.deleteItems();
    }
    
    @AfterClass
    public void killDriver(){
        Q_PM_AccountSteps.accountMenu("LOGOUT");

    }
}
