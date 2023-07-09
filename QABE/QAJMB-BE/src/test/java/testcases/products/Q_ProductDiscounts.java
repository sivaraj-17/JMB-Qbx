package testcases.products;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_ProductDiscounts extends Init {
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
    /******************************************************************
     // * Description: Verify user remove JMB discount on the product page
     // * Jira Ticket: JMB-4510
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 1)
    public static void removeJmbProductDiscounts(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        adm.adminMenu("products");
        prod.productsIdSearch("258588");
        prod.removeDiscount("prod.jmDiscount.xp", "prod.jmDiscount.rowCount.xp", "prod.jmQtyRem.beg.xp", "prod.jmRemove.end.xp");
        li.closeTabsSwitchWinMain();

    }
    /******************************************************************
     // * Description: Verify user add JMB discount on the product page
     // * Jira Ticket: JMB-4510
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2)
    public static void jmbAddDiscount(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("258588");
        prod.addDiscount("prod.jmDiscount.xp", "prod.jmQtyFrom.addbeg.xp", "prod.jmQtyFrom.end.xp", "prod.jmQtyTo.end.xp", "prod.jmAmount.end.xp", "prod.jmAddDiscount.Btn.xp");
        li.closeTabsSwitchWinMain();

    }
    /******************************************************************
     // * Description: Verify that PDP for a JMB product displays discounts as provisioned on the product page
     // * Jira Ticket: JMB-4510
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3)
    public static void verifyPdpJmbDiscounts(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("258588");
        prod.pdpDiscount("prod.jmOnSite.xp", "prod.jmPdp.checkPrice.beg.xp", "prod.jmPdp.tier.end.xp");
        li.closeTabsSwitchWinMain();

    }

    /******************************************************************
     // * Description: Verify user remove Silver discount on the product page
     // * Jira Ticket: JMB-4510
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4)
    public static void removeSilverProductDiscounts(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("258588");
        prod.removeDiscount("prod.silverDiscount.xp", "prod.silverDiscount.rowCount.xp", "prod.silverQtyFrom.beg.xp", "prod.silverRemove.end.xp");
        li.closeTabsSwitchWinMain();

    }
    /******************************************************************
     // * Description: Verify user add Silver discount on the product page
     // * Jira Ticket: JMB-4510
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5)
    public static void silverAddDiscount(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("258588");
        prod.addDiscountSilver("prod.silverDiscount.xp", "prod.silverQtyFrom.addbeg.xp", "prod.silverQtyFrom.end.xp",
                "prod.silverQtyTo.end.xp", "prod.silverAmount.end.xp", "prod.silverAddDiscount.Btn.xp");
        li.closeTabsSwitchWinMain();
        li.closeTabsSwitchWinMain();    }
    /******************************************************************
     // * Description: Verify that PDP for a Silver product displays discounts as provisioned on the product page
     // * Jira Ticket: JMB-4510
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6)
    public static void verifyPdpSilverDiscounts(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("258588");
        prod.pdpDiscount("prod.silverOnSite.xp", "prod.silverPdp.checkPrice.beg.xp", "prod.silverPdp.tier.end.xp");
        li.closeTabsSwitchWinMain();
        li.closeTabsSwitchWinMain();    }
    /******************************************************************
     // * Description: Verify user remove Provident Metals discount on the product page
     // * Jira Ticket: JMB-4510
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7)
    public static void removePMProductDiscounts(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("145");
        prod.removeDiscount("prod.pmDiscount.xp", "prod.pmDiscount.rowCount.xp", "prod.pmQtyFrom.beg.xp", "prod.pmRemove.end.xp");
        li.closeTabsSwitchWinMain();
        li.closeTabsSwitchWinMain();    }
    /******************************************************************
     // * Description: Verify user add Provident Metals discount on the product page
     // * Jira Ticket: JMB-4510
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8)
    public static void pmAddDiscount(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("145");
        prod.addDiscountSilver("prod.pmDiscount.xp", "prod.pmQtyFrom.addbeg.xp", "prod.pmQtyFrom.end.xp", "prod.pmQtyTo.end.xp", "prod.pmAmount.end.xp", "prod.pmAddDiscount.Btn.xp");//        ProductsSteps.pdpDiscount("silverOnSite.xp","silverPdp.checkPrice.beg.xp", "silverPdp.tier.end.xp");
        li.closeTabsSwitchWinMain();
    }
    /******************************************************************
     // * Description: Verify that PDP for a Provident Metals product displays discounts as provisioned on the product page
     // * Jira Ticket: JMB-4510
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9)
    public static void verifyPdpPMDiscounts(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("145");
        prod.pdpDiscount("prod.pmOnSite.xp", "prod.pmPdp.checkPrice.beg.xp", "prod.pmPdp.tier.end.xp");
        li.closeTabsSwitchWinMain();

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


