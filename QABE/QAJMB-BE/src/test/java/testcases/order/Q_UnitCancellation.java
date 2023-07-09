package testcases.order;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;
//import steps.AdminSteps;
import utils.Controls;
import utils.Init;

public class Q_UnitCancellation extends Init {
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
    public void setEnv() throws Exception {

    }

    @BeforeMethod
    public void tcSetup(){
        setItUp();
        Controls.adminLogin();
    }


    @Test(priority = 7, enabled = true)
    public static void over1KInvoice(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminCustomerSearch("email", "qa+2jmb@jmbullion.com");
        adm.adminViewAllOrders();
        ord.MLFadm(80, 93, 1000f,"Pending");
        ord.over1k();
    }

    @AfterMethod
    public void tearDown(){

    }

}


