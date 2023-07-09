package testcases.cart;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Q_PM_CartSteps;
import pageObjects.Q_PM_WebElm;
import utils.Q_PM_Controls;
import utils.Q_PM_Init;

import java.util.ArrayList;
import java.util.Arrays;


public class Q_PM_NonQcRules extends Q_PM_Init {
    static ArrayList<String> pt1 = new ArrayList<String>(Arrays.asList("authorize_net_cim", "paypal_express", "authorize_net_cim_echeck", "cheque", "bacs", "bitpay"));
    static ArrayList<String> pt2 = new ArrayList<String>(Arrays.asList("authorize_net_cim", "paypal_express", "authorize_net_cim_echeck", "cheque", "bitpay"));
    static ArrayList<String> pt3 = new ArrayList<String>(Arrays.asList("paypal_express", "authorize_net_cim_echeck", "cheque", "bacs", "bitpay"));
    static ArrayList<String> pt4 = new ArrayList<String>(Arrays.asList("authorize_net_cim_echeck","cheque", "bacs", "bitpay"));
    static ArrayList<String> pt5 = new ArrayList<String>(Arrays.asList("bacs", "bitpay"));
    static ArrayList<String> pt6 = new ArrayList<String>(Arrays.asList("bacs"));
    static ArrayList<String> pt7 = new ArrayList<String>(Arrays.asList("authorize_net_cim_echeck"));
    
    @BeforeClass
    public void tcSetup () throws Exception {

        Q_PM_Init.setItUp();

    }
    
    @BeforeMethod
    public void setUser () {
    }

    /*******************************************************************
    // * Description: Verify All Payment Options for Orders > 2.5K and < 5k
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1)

    public static void allPaymentTypes(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_1_2553140("2");
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
        Q_PM_CartSteps.paymentType("Available Types", pt2);
    }
    
    /*******************************************************************
    // * Description: Verify Credit Card Payment Options not available for Orders > 5K and < 150 K
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 3)
    public static void ccPaymentNotAvailable(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_1_2553140("4");
        System.out.println(Q_PM_WebElm.cnReturnAllOptions(pmQaProps, "cart.paymentType.className"));
        Q_PM_CartSteps.paymentType("Available Types", pt3);        
    }
    
    /*******************************************************************
    // * Description: Verify Credit Card, PayPal and ACH not available options for orders > 10K and < 150 K
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 4)

    public static void pcBwBcAvailable(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_1_2553140("15");
        System.out.println(Q_PM_WebElm.cnReturnAllOptions(pmQaProps, "cart.paymentType.className"));
        Q_PM_CartSteps.paymentType("Available Types", pt4);        
    }
    
    /*******************************************************************
    // * Description: Verify Bank Wire and Bitcoin only available options for orders > 50K and < 150 K
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 5)
    public static void BwBcAvailable(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_1_2553140("45");
        System.out.println(Q_PM_WebElm.cnReturnAllOptions(pmQaProps, "cart.paymentType.className"));
        Q_PM_CartSteps.paymentType("Available Types", pt5);
        
    }
    
    /*******************************************************************
    // * Description: Verify Bank Wire only available options for orders >100K and <150K
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 6)
    public static void bwOnly(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_1_2553140("68");
        System.out.println(Q_PM_WebElm.cnReturnAllOptions(pmQaProps, "cart.paymentType.className"));
        Q_PM_CartSteps.paymentType("Available Types", pt6);
    }
    
    /*******************************************************************
    // * Description: Verify Orders > 150k need CSR Assistance
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 7)
    public static void callCSR(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        Q_PM_AddToCart.gold_4_2569050("12");
        System.out.println(Q_PM_WebElm.cnReturnAllOptions(pmQaProps, "cart.paymentType.className"));
        Assert.assertTrue(Q_PM_WebElm.cnDisplayed(pmQaProps, "cart.woocommerce-error.className"));
    }

    @AfterMethod
    public static void tearDown(){
        //CartSteps.verifyCartItems();
        Q_PM_CartSteps.deleteItems();
    }
    
    @AfterClass
    public static void killDriver(){
        if (driver.toString().contains("Firefox")) {
            driver.quit();
        }
    }

}
