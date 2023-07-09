package testcases.customerView;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import utils.Controls;
import utils.Init;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Q_UnitCustomerPage extends Init {
    static Q_AdminForm adm = new Q_AdminForm();
    static Q_CustomerForm cust = new Q_CustomerForm();
    static Q_ProductForm prod = new Q_ProductForm();
    static Q_HoldsForm hold = new Q_HoldsForm();
    static Q_OrderForm ord = new Q_OrderForm();
    static Q_Buyback bb = new Q_Buyback();
    static Q_CheckoutForm chk = new Q_CheckoutForm();
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

    /******************************************************************
     * Description: Verify QC Status removed with MLF of at least $100 even when paid
     * Author: Paul Patterson
     * Jira Ticket: JMB-6038 Remove QC Status on invoice creation
     * Status: Complete
     //*******************************************************************/


    @Test(priority = 14)
    public static void verifyMLFInvoiceOver100RemovesQCstatus() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Boolean qcCheck;
        li.adminLogin();
        adm.adminCustomerSearch("email", "qa+1jmb@jmbullion.com");
        adm.adminViewAllOrders();
        // Check to make sure QC is "Yes" for qa1jmb@gmail.com
        qcCheck = cust.verifyQCValue("Yes");
        if (!qcCheck)
        {
            cust.setQc();
        }
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        ord.MLFadm(288, 295, 100f );
        ord.processCancellationFee();
        ord.changeOrderStatus("pending");
        adm.adminCustomerSearch("email", "qa+1jmb@jmbullion.com");
        adm.adminViewAllOrders();
//        driver.navigate().back();
//        driver.navigate().refresh();
        qcCheck = cust.verifyQCValue("No");
        // Reset QC back to "Yes" for qa1jmb@gmail.com
        if (qcCheck)
        {
            cust.setQc();
        }
        Assert.assertTrue(qcCheck, "Verify QC is removed due to MLF Invoice");
    }
}
