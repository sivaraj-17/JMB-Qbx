package testcases.Review;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_ReviewPlate extends Init {
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
    public void tcSetup(){
    }
    @BeforeMethod
    public void report() throws Exception {
        Init.setItUp();
    }
    @BeforeTest
    public void setTest() throws Exception {
    }





}
