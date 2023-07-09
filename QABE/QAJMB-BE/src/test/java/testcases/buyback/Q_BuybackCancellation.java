package testcases.buyback;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Q_AdminForm;
import pageObjects.Q_Buyback;
import utils.Controls;
import utils.Init;


public class Q_BuybackCancellation extends Init{

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
     // * Description: Verify buybacks cancellation only allowed for with permission
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 1, enabled = true)
    public static void bbCancellationNotAllowed() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls li = new Controls();
        li.adminLogin();
        Q_AdminForm admin = new Q_AdminForm();
        admin.selectAdminUser();
        admin.removePermission("Cancel Buybacks/Skip Credit Card Requirement");
        Q_Buyback bb = new Q_Buyback();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp","qa+1jmb@jmbullion.com", 1);
        bb.editOrder();
        bb.displayedAssertion("bb.cancelBuyback.xp");
    }
    
    /******************************************************************
     // * Description: Verify user can click don't cancel button
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2, enabled = true)
    public static void dontCancelBB() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls li = new Controls();
        li.adminLogin();
        Q_AdminForm admin = new Q_AdminForm();
        admin.selectAdminUser();
        admin.grantPermission("Cancel Buybacks/Skip Credit Card Requirement");
        Q_Buyback bb = new Q_Buyback();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp","qa+1jmb@jmbullion.com", 1);
        bb.editOrder();
        bb.dontCancel();
    }
    
    /******************************************************************
     // * Description: Verify user with right permission can skip cancellation fee and cancel buyback
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3, enabled = true)
    public static void skipCancelFeeAndCancel() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls li = new Controls();
        li.adminLogin();
        Q_Buyback bb = new Q_Buyback();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp","qa+1jmb@jmbullion.com", 1);
        bb.commitSearch();
        bb.skipFeeBbCancelFee();
    }
    
    /******************************************************************
     // * Description: Verify user with re-instate buyback after it's cancelled
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4, enabled = true)
    public static void reInstateBb() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls li = new Controls();
        li.adminLogin();
        Q_Buyback bb = new Q_Buyback();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp","qa+1jmb@jmbullion.com", 1);
        bb.commitSearch();
        bb.reinstateCancelled();
   }
    
    /******************************************************************
     // * Description: Verify user cancels buyback and verify JMB invoice admin link
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5, enabled = true)
    public static void jmbInvoiceAdminLink() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls li = new Controls();
        li.adminLogin();
        Q_Buyback bb = new Q_Buyback();
        bb.bbMenuItem("list");
        String supplier = "JM Bullion";
        String email ="qa+6jmb@jmbullion.com";
        bb.pageThruBuybacks(1, 20, email, supplier, 20f);
        String ticketNum = Q_Buyback.attReturn("bb.formTicketNumber.xp", "value");
        System.out.println("Form supplier is " + supplier + "\t Ticket Number " + ticketNum);
        bb.processBbCancellation();
        bb.verifyNotes(" Invoice");
        bb.whichSite(supplier);
        bb.verifyCustomerPageInvoiceLink(email);
        Assert.assertTrue(driver.getCurrentUrl().contains(ticketNum));
        bb.reinstateCancelledBb();
    }
    
    /******************************************************************
     // * Description: Verify user can pay JMB buyback invoice in admin page
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6, enabled = true)
    public static void payJmbBuybackInvoice() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls li = new Controls();
        li.adminLogin();
        Q_Buyback bb = new Q_Buyback();
        bb.bbMenuItem("list");
        String supplier = "JM Bullion";
        String email ="qa+6jmb@jmbullion.com";
        bb.pageThruBuybacks(1, 20, email, supplier, 20f);
        String ticketNum = Q_Buyback.attReturn("bb.formTicketNumber.xp", "value");
        System.out.println("Form supplier is " + supplier + "\t Ticket Number " + ticketNum);
        bb.processBbCancellation();
        bb.verifyNotes(" Invoice");
        bb.whichSite(supplier);
        bb.markBuybackCustomerInvoicePaid(email);
        org.junit.Assert.assertTrue(driver.getCurrentUrl().contains(adminUrl + "/customers.php"));
    }

    /******************************************************************
     // * Description: Verify user cancels buyback and verify provident invoice admin link
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7, enabled = true)
    public static void pmInvoiceAdminLink() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls li = new Controls();
        li.adminLogin();
        Q_Buyback bb = new Q_Buyback();
        bb.bbMenuItem("list");
        String supplier = "Provident Metals";
        String email ="qa+8jmb@jmbullion.com";
        bb.pageThruBuybacks(30, 37, email, supplier, 20f);
        String ticketNum = Q_Buyback.attReturn("bb.formTicketNumber.xp", "value");
        System.out.println("Form supplier is " + supplier + "\t Ticket Number " + ticketNum);
        bb.processBbCancellation();
        bb.verifyNotes(" Invoice");
        bb.whichSite(supplier);
        bb.verifyCustomerPageInvoiceLink(email);
        Assert.assertTrue(driver.getCurrentUrl().contains(ticketNum));
        bb.reinstateCancelledBb();
    }

    /******************************************************************
     // * Description: Verify user can pay PM buyback invoice in admin page
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8, enabled = true)
    public static void payPmBuybackInvoice() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls li = new Controls();
        li.adminLogin();
        Q_Buyback bb = new Q_Buyback();
        bb.bbMenuItem("list");
        String supplier = "JM Bullion";
        String email ="qa+8jmb@jmbullion.com";
        bb.pageThruBuybacks(1, 10, email, supplier, 20f);
        String ticketNum = Q_Buyback.attReturn("bb.formTicketNumber.xp", "value");
        System.out.println("Form supplier is " + supplier + "\t Ticket Number " + ticketNum);
        bb.processBbCancellation();
        bb.verifyNotes(" Invoice");
        bb.whichSite(supplier);
        bb.markBuybackCustomerInvoicePaid(email);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://qa.providentmetals.com/admin/customers.php"));
    }

    @AfterTest
    public void endReport(){
    }
    
    @AfterMethod
    public void tearDown() throws Exception {
//        Controls.tearDown();
    }

    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
