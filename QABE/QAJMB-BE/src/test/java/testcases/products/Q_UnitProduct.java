package testcases.products;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;
//import steps.AdminSteps;
//import steps.ElemSteps;
//import steps.ProductsSteps;
import utils.Controls;
import utils.Init;

public class Q_UnitProduct extends Init {
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
    @Test(priority =1)
    public static void productSearch(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        adm.adminMenu("products");
        prod.ProductsSKUSearch("GRTENTHVARIED");
        prod.assertProdDescription("1/10 oz Gold Round (Varied)");
        li.closeTabsSwitchWinMain();
        prod.productsIdSearch("46");
        prod.assertProdDescription("1 oz American Gold Eagle Coin (Random Year, BU)");
        li.closeTabsSwitchWinMain();
    }



}


