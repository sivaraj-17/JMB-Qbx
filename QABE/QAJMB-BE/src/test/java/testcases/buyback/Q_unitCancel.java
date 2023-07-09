package testcases.buyback;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.Controls;
import utils.Init;


public class Q_unitCancel extends Init{
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
    @Test(priority = 7, enabled = true)
    public static void pmInvoiceAdminLink() {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        String supplier = "Provident Metals";
        String email ="qa+4jmb@jmbullion.com";

        bb.pageThruBuybacks(30, 40, email, supplier, 20f);
        String ticketNum = Q_Buyback.attReturn("bb.formTicketNumber.xp", "value");
        System.out.println("Form supplier is " + supplier + "\t Ticket Number " + ticketNum);
        bb.processBbCancellation();
        bb.verifyNotes(" Invoice");
        bb.whichSite(supplier);
        bb.verifyCustomerPageInvoiceLink(email);
        Assert.assertTrue(driver.getCurrentUrl().contains(ticketNum));
        bb.reinstateCancelledBb();
    }








}
