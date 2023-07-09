package testcases.buyback;


import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_RequireAttention extends Init {
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
     // * Description: Verify user can edit buyback Cart Number field
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 1, enabled = true)
    public static void editCartNo(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("require attention");
        bb.secondSearchStatus("bb.emailSearch.xp", "qa+6jmb@jmbullion.com", 1);
        bb.commitSearch();
        bb.editOrder();
        bb.editCartNumber();
    }
    
    /******************************************************************
     // * Description: Verify buybacks field Internal Status is assigned to a new buyback
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2, enabled = true)
    public static void newbbInternalStatus()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("require attention");
        bb.formXp("bb.createBuybackLink.xp");
        bb.newBuyBack("qa+1jmb@jmbullion.com" ,2);
        bb.selectAddress(2);
        bb.selectBank(2);
        bb.selectInternalStatusText("AMGL - Clarification");
        bb.selectPayment("WIRE");
        bb.selectDefaultCard(1, 6);
        bb.addBbProduct(2, "10","1 oz Canadian Palladium Maple Le");
        bb.reportable();
        bb.productValidation();
        bb.saveBb();;
    }
    
    /******************************************************************
     // * Description: Verify user can edit buyback internal status for a pending buyback
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3, enabled = true)
    public static void changeInternalStatus()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("require attention");
        bb.emailSearch("qa+1jmb@jmbullion.com");
        bb.commitSearch();
        bb.editOrder();
        bb.selectInternalStatusText("Awaiting Customer Response");
        bb.saveVerifyNotes("Buyback edited");;
    }
    
    /******************************************************************
     // * Description: Verify user can restore pending buyback default internal status
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4, enabled = true)
    public static void restorePendingInternalStatusDefault()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("require attention");
        bb.statusSearch(1);
        bb.commitSearch();
        bb.editOrder();
        bb.strTextAssertion("bb.editStatus.xp", "Awaiting Delivery");
        bb.selectInternalStatusText("-- SELECT ONE --");
        bb.saveVerifyNotes("Buyback edited");;
    }
    
    /******************************************************************
     // * Description: Verify user can restore received buyback default internal status
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5, enabled = true)
    public static void restoreReceivedInternalStatusDefault()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("require attention");
        bb.statusSearch(3);
        bb.commitSearch();
        bb.editOrder();
        bb.strTextAssertion("bb.editStatus.xp", "Accepted");
        bb.selectInternalStatusText("-- SELECT ONE --");
        bb.saveVerifyNotes("Buyback edited");;
    }
    
    /******************************************************************
     // * Description: Verify user can search buyback required action page order number and edit buyback Cart Number field
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6, enabled = true)
    public static void ticketNumberEdit()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("require attention");
        bb.emailSearch("qa+1jmb@jmbullion.com");
        bb.commitSearch();
        bb.editOrder();
        bb.editCartNumber();
        String ticketNum = Q_Buyback.ticketNumber("bb.formTicketNumber.xp");
        bb.retAttributAssertion("bb.editTicket.xp", ticketNum );
        bb.saveVerifyNotes("Buyback edited");;
    }
    
    /******************************************************************
     // * Description: Verify user can search on email buyback required action page and edit buyback Cart Number and internal status
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7, enabled = true)
    public static void emailSearchEdit()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("require attention");
        bb.emailSearch("qa+1jmb@jmbullion.com");
        bb.commitSearch();
        bb.editOrder();
        bb.selectInternalStatusText("Awaiting Customer Response");
        bb.saveVerifyNotes("Buyback edited");;
    }
    
    /******************************************************************
     // * Description: Verify user can search buyback required action page on user name edit buyback Cart Number field
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8, enabled = true)
    public static void searchNameAndEdit()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("require attention");
        bb.nameSearch("Out Look");
        bb.commitSearch();
        bb.editOrder();
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectInternalStatusText("Awaiting Customer Response");
        bb.saveVerifyNotes("Buyback edited");;
    }
    
    /******************************************************************
     // * Description: Verify user can search buyback required action page on internal status and change the status
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9, enabled = true)
    public static void SearchAndEditInternalStatusJMB()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("require attention");
        bb.searchSupplier("qa+6jmb@jmbullion.com", "Provident");
        bb.selectInternalStatusIndex(2);
        bb.commitSearch();
        bb.editOrder();
        bb.selectInternalStatusText("Requires Attention - JMB");
        bb.skipCreditCard();
        bb.saveVerifyNotes("Buyback edited");
        bb.selectInternalStatusText("Shipping Label Requested");
        bb.skipCreditCard();
        bb.saveVerifyNotes("Buyback edited");
    }
    
    /******************************************************************
     // * Description: Verify user can search buyback required action page on Cart Number field and change internal status
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 10, enabled = true)
    public static void searchCartNumberEdit()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("require attention");
//        bb.emailSearch("qa1jmb@outlook.com");
        bb.cartNumberSerach("MyC-3344");
        bb.commitSearch();
        bb.editOrder();
        bb.editCartNumber();
        bb.saveBb();
        bb.verifyNotes("Buyback edited");
    }
    
    /******************************************************************
    // * Description: Verify Search result is 0 records for Cart Number Search when internal status is not assigned
    // * Jira Ticket:
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 11, enabled = true)
    public static void searchCartNumberNoRecord()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("require attention");
        bb.cartNumberSerach("MyC-0000");
        bb.commitSearch();
        bb.strTextAssertion("bb.noRecords.xp", "There is no data to report.");
    }
    
    /******************************************************************
     // * Description: Verify buyback with internal status label requested will not show in attention page if buyback is cancelled
     // * Jira Ticket: JMB-4453
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 12, enabled = true)
    public static void cancelledLabelRequested()  {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("require attention");
        bb.statusSearch(1);
        bb.selectInternalStatusIndex(2);
        bb.statusSearch(5);
        bb.commitSearch();
//        bb.editOrder();
//        String ticketNum = Buyback.ticketNumber("formTicketNumber.xp");
//        System.out.println("Ticket Num  " + ticketNum);
//        bb.processBbCancellation();
//        bb.bbMenuItem("require attention");
//        bb.orderSearch(ticketNum);
//        bb.commitSearch();
        bb.strTextAssertion("bb.noRecords.xp", "There is no data to report.");
    }
    
    /*********************************************************************
	 * Description: Verify whether any order/BB with status Cancelled is 
	 * present in the list of 'Buybacks Requiring Attention' category
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-6864
	 ********************************************************************/
	@Test(priority = 13)
	public void cancelledBuybackAppearInRequiredAttentionSearch() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		bb.bbMenuItem("require attention");
		Assert.assertTrue(Q_WebElm.xpCountTableRows(adminProps, "bb.searchCancelledStatus.xp") == 0,"BB with Cancelled status found.");
	}
	
	/********************************************************************
	 * // * Description: Verify Adjustment to the Buybacks Requiring Attention dropdown report 
	 * // * Param: NA 
	 * // * Jira Ticket: JMB-6488 
	 * // * Status: Complete 
	 *******************************************************************/
	@Test(priority = 14, enabled = true)
	public static void adjustmentBuybacksRequiringAttentionDropdownReport() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		Controls.adminLogin();
		driver.get("https://qa.jmbullion.com/admin/api/buybacks/requiresAttentionBuybacks/");
		bb.verifyStatus();
		bb.verifyAdjustmentBBAttentionReport("Paid");
		bb.verifyAdjustmentBBAttentionReport("Cancelled");
	}
	
	/*********************************************************************
	 * Description: Verify Buyback IRA filter
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-7200
	 ********************************************************************/
	@Test(priority = 15)
	public void verifyBuybackIraFilter()	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		bb.bbMenuItem("require attention");
		bb.typeSearch(3);
		bb.commitSearch();
		bb.verifyInternalStatus_cancelledBB_DiyBB_notPresentInIraFilter();
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
