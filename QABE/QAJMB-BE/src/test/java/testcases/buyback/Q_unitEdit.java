package testcases.buyback;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.Controls;
import utils.Init;

import java.io.IOException;


public class Q_unitEdit extends Init{
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
     // * Description: Verify buybacks with ACH payment type require bank account
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test (priority = 12, enabled = true)
    public static void paymentTypeACHRequireBankInfo() throws IOException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+3jmb@jmbullion.com", 1);
        bb.showAddresses();
        bb.selectAddress(2);
//        bb.selectBank(1);
        bb.selectPaymentType(1);
        bb.selectDefaultCard(1, 6);
        bb.addBbProduct(2, "10","10 oz Sunshine Silver Bar (New, MintMar");
        bb.reportable();
        bb.productValidation();
        bb.verifyBankAccountRequired();
//        bb.paymentFee("25.00");
    }




}
