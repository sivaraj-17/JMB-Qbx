package testcases.buyback;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_BuybackWire extends Init{
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
     // * Description: Verify the listing of wires
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 1, enabled = true)
    public static void listWiresPerPage(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("wire");
        System.out.println("Number or wire " + Q_Buyback.tableRows("bb.wireRowsCount.xp"));
    }

    /******************************************************************
     // * Description: Verify user can wire by supplier name
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2, enabled = true)
    public static void searchByName(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("wire");
        bb.formInput("bb.wireSearchInput.xp", "CUSTOMER External");
        System.out.println("Number of wires " + Q_Buyback.tableRows("bb.wireRowsCount.xp"));
    }

    /******************************************************************
     // * Description: Verify user can change number of entries in listing
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3, enabled = true)
    public static void changeListEntries(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("wire");
        bb.numOfWiresEntries(1);
        System.out.println("Number of wires " + Q_Buyback.tableRows("bb.wireRowsCount.xp"));
    }
    /******************************************************************
     // * Description: Verify wire pagination works
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4, enabled = true)
    public static void wirePagination(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("wire");
        bb.numOfWiresEntries(0);
        bb.wirePagingForward();
        bb.wirePagingBack();
    }

    /******************************************************************
     // * Description: Verify user can view wire details
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5, enabled = true)
    public static void viewWireDetails(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("wire");
        bb.viewWire(1);
    }
    /******************************************************************
     // * Description: Verify user can create wire JM Bullion supplier
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6, enabled = true)
    public static void createExternalWire() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("wire");
        bb.addWire("CUSTOMER External");
    }
    
    /******************************************************************
     // * Description: Verify user can create wire for a Provident supplier
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7, enabled = true)
    public static void createProvidentWire(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("wire");
        bb.addWire("Provident");
    }
    
    /******************************************************************
     // * Description: Verify user can Initiate wire
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8, enabled = true)
    public static void initiateWire(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("wire");
        bb.numOfWiresEntries(0);
        bb.wireSearch("bb.wireSearchInput.xp", "Provident");
        bb.wireStatus("initiate", "Pending");
    }
    
    /******************************************************************
     // * Description: Verify user can complete the wire
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9, enabled = true)
    public static void completeWire(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("wire");
        bb.numOfWiresEntries(0);
        bb.wireSearch("bb.wireSearchInput.xp", "Provident");
        bb.wireStatus("complete", "Initiated");
    }
    
    /******************************************************************
     // * Description:  Verify wire can be deleted if the status is other than completed
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 10, enabled = true)
    public static void deleteWire(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("wire");
        bb.numOfWiresEntries(3);
        bb.wireSearch("bb.wireSearchInput.xp", "Pending");
        bb.wireStatus("delete", "Pending");
    }
    
    /******************************************************************
     // * Description:  Verify user can remove buyback from wire provided wire status is other than completed
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 11, enabled = true)
    public static void deleteBbFromWire(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("wire");
        bb.numOfWiresEntries(3);
        bb.wireSearch("bb.wireSearchInput.xp", "Pending");
        bb.removeBbFromWire();
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
