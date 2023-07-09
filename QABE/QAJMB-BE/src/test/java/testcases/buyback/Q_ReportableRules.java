package testcases.buyback;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_ReportableRules extends Init {
    static Q_AdminForm adm = new Q_AdminForm();
    static Q_CustomerForm cust = new Q_CustomerForm();
    static Q_ProductForm prod = new Q_ProductForm();
    static Q_HoldsForm hold = new Q_HoldsForm();
    static Q_OrderForm ord = new Q_OrderForm();
    static Q_Buyback bb = new Q_Buyback();
    static Q_CheckoutForm chk = new Q_CheckoutForm();
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
    
    /******************************************************************
    // * Description: Verify Gold coins and Silver coins are not reportable regardless of quantity
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 1, enabled = true)
    public static void goldSilverCoinsNotReportable(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+2jmb@jmbullion.com" ,1);
        bb.selectAddress(2);
        bb.selectBank(1);
        bb.selectPayment("WIRE");
        bb.selectCreditCard(1);
        bb.addBbProduct(2, "2000","20 Francs Gold Coin (");
        bb.addNonBbProduct(3, "2000","2019 5 oz ATB American Memorial Park Silver C", "99.98");
        bb.reportable();
        bb.productValidation();
        bb.saveBb();
        bb.premiumValidation();
        bb.validateReportable("checked");
    }
    
    /******************************************************************
    // * Description: Verify gold bars less than 32oz and silver bars less than 1000 oz are not reportable within 24 hours
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority =2, enabled = true)
    public static void silverGoldBarBelowThreshhold(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.addCustomer(2);
        bb.newAddress();
        bb.addBankInfo(2, 2,"011401533");
        bb.selectPayment("ACH");
        bb.addNewCreditCard(1);
        bb.addBbProduct(2, "2","10 oz Credit Suisse Gold Bar (New w/");
        bb.addNonBbProduct(3, "3","100 oz Geiger Security Line Silver B","1905.08");
        bb.reportable();
        bb.productValidation();
        bb.saveBb();
        bb.premiumValidation();
        bb.validateReportable("checked");
    }
    
    /******************************************************************
    // * Description: Verify Platinum bars less than 25oz and Palladium  bars less than 100 oz are not reportable within 24 hours
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority =3, enabled = true)
    public static void platinumPallidiumBarsBelowThreshhold(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.addCustomer(1);
        bb.newAddress();
        bb.addBankInfo(2, 2,"111000614");
        bb.selectPayment("CHECK");
        bb.addNewCreditCard(1);
        bb.addBbProduct(2, "2","1 oz Canadian Palladium Maple Le");
        bb.addNonBbProduct(3, "2","10 oz PAMP Suisse Fortuna Platinum Bar (New w/ Assay)", "7511.08");
        bb.reportable();
        bb.productValidation();
        bb.saveBb();
        bb.premiumValidation();
        bb.validateReportable("checked");
    }
    
    /******************************************************************
    // * Description: Verify Gold Maple Leaf Coin .9999 quantity less than 25 and 1 oz South African Gold Krugerrand Coin with
    // * Less than 25 are not reportable within 24 hours
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority =4, enabled = true)
    public static void goldCoinsLt25NotReportable(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.addCustomer(2);
        bb.newAddress();
        bb.addBankInfo(1, 2,"111000614");
        bb.selectPayment("WIRE");
        bb.addNewCreditCard(1);
        bb.addBbProduct(2, "24","1 oz Canadian Gold Maple Leaf Coin .9999 Pure (");
        bb.addBbProduct(3, "24","1 oz South African Gold Krugerrand Coin (");
        bb.reportable();
        bb.productValidation();
        bb.saveBb();
        bb.premiumValidation();
        bb.validateReportable("checked");
    }
    
    /******************************************************************
    // * Description: Verify Gold Mexican Onza quantity less than 25 and 90% Silver US coins
    // * Less than $1000 face value are not reportable
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority =5, enabled = true)
    public static void mexicanSilver90NotReportableItem(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.addCustomer(2);
        bb.newAddress();
        bb.addBankInfo(2, 2,"111000614");
        bb.selectPayment("ACH");
        bb.addNewCreditCard(1);
        bb.addNonBbProduct(2, "1", "90% Silver Coins ($500 FV, Ha","2583.81");
        bb.addNonBbProduct(3, "10","2017 1 oz Mexican Gold Libertad Co","1967.01");
        bb.addBbProduct(4, "24","1 oz South African Gold Krugerrand Coin (");
        bb.reportable();
        bb.productValidation();
        bb.saveBb();
        bb.premiumValidation();
        bb.validateReportable("checked");
    }
    
    /******************************************************************
    // * Description: Verify Gold bars over 40oz and silver bar over 1000oz are reportable items
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority =6, enabled = true)
    public static void goldBar40ozSilverBar1000ozReportable(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.addCustomer(2);
        bb.newAddress();
        bb.addBankInfo(2, 2,"111000614");
        bb.selectPayment("CHECK");
        bb.addNewCreditCard(1);
        bb.addBbProduct(2, "40","1 oz Gold Bar (Va");
        bb.addNonBbProduct(3, "10","100 oz Geiger Security Line Silver B", "1905.08");
        bb.reportable();
        bb.productValidation();
        bb.saveBb();
        bb.premiumValidation();
        bb.validateReportable("checked");
    }
    
    /******************************************************************
    // * Description: Verify Platinum bars over 25oz and Palladium  bars over 100 oz are reportable
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority =7, enabled = true)
    public static void reportablePlatinumPallidiumBars(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.addCustomer(2);
        bb.newAddress();
        bb.addBankInfo(2, 2,"111000614");
        bb.selectPayment("WIRE");
        bb.addNewCreditCard(1);
        bb.addBbProduct(2, "100","1 oz PAMP Suisse Palladium Bar (Va");
        bb.addNonBbProduct(3, "2","10 oz PAMP Suisse Fortuna Platinum Ba","9011.08");
        bb.addBbProduct(4, "6","1 oz Valcambi Platinum Ba");
        bb.reportable();
        bb.productValidation();
        bb.saveBb();
        bb.premiumValidation();
        bb.validateReportable("checked");
    }
    
    /******************************************************************
    // * Description: Verify Gold Maple Leaf Coin .9999 quantity over 25 and 1 oz South African Gold Krugerrand Coin with
    // * over 25 are not reportable within 24 hours
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority =8, enabled = true)
    public static void reportableGoldCoins25Plus(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.addCustomer(2);
        bb.newAddress();
        bb.addBankInfo(2, 2,"111000614");
        bb.selectPayment("ACH");
        bb.addNewCreditCard(1);
        bb.addBbProduct(2, "25","1 oz Canadian Gold Maple Leaf Coin .9999 Pure (");
        bb.addBbProduct(3, "25","1 oz South African Gold Krugerrand Coin (");
        bb.reportable();
        bb.productValidation();
        bb.saveBb();
        bb.premiumValidation();
        bb.validateReportable("checked");
    }
    
    /******************************************************************
    // * Description: Verify Gold Mexican Onza quantity over 25 and 90% Silver US coins over $1000 face value are reportable
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority =9, enabled = true)
    public static void mexicanSilver90ReportableItem(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.addCustomer(2);
        bb.newAddress();
        bb.addBankInfo(2, 2,"111000614");
        bb.selectPayment("WIRE");
        bb.addNewCreditCard(1);
        bb.addBbProduct(2, "3","90% Silver Coins ($500 FV, Dimes and/");
        bb.addNonBbProduct(3, "26","2017 1 oz Mexican Gold Libertad C","1967.01");
        bb.reportable();
        bb.productValidation();
        bb.saveBb();
        bb.premiumValidation();
        bb.validateReportable("checked");
    }

    @AfterTest
    public void endReport(){
    }
    
    @AfterMethod
    public void tearDown() throws Exception {
        Controls.tearDown();
    }
    
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
