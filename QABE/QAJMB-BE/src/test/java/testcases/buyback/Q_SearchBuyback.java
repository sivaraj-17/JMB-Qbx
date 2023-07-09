package testcases.buyback;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_SearchBuyback extends Init{
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
    // * Description: Verify user can search buybacks based on order id
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1, enabled = true)
    public static void orderNumberSearch() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.orderSearch("2391");
        bb.commitSearch();
    }
    /******************************************************************
    // * Description: Verify buybacks are searchable based on user email
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2, enabled = true)
    public static void emailOrderSearch() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.emailSearch("qa+1jmb@jmbullion.com");
        bb.commitSearch();
    }
    /******************************************************************
    // * Description: Verify user can search based on customer name
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3, enabled = true)
    public static void nameOrderSearch() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.nameSearch("System Created");
        bb.commitSearch();
    }
    /******************************************************************
    // * Description: Verify whether buyback was created bu customer or buyback rep
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 4, enabled = true)
    public static void defaultSearch() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.typeSearch(2);
        bb.commitSearch();
    }
    /******************************************************************
    // * Description: Verify user can search buybacks based on specific status
    // * 1 Awaiting Delivery, 2 Pending Inspection, 3 Accepted,4 Paid, 5 Cancelled, 6 Payment Declined
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 5, enabled = true)
    public static void statusSearch() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.statusSearch(1);
        bb.commitSearch();
    }
    /******************************************************************
     // * Description: Verify user can search buybacks with search field combination second being status field
     // * 1 Awaiting Delivery, 2 Pending Inspection, 3 Accepted,4 Paid, 5 Cancelled, 6 Payment Declined
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6, enabled = true)
    public static void secondSearchStatus() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp", "qa+6jmb@jmbullion.com", 6);
        bb.commitSearch();
    }
    /******************************************************************
     // * Description: Verify user can search buybacks with multiple search field combination second being status field
     // * 1 Awaiting Delivery, 2 Pending Inspection, 3 Accepted,4 Paid, 5 Cancelled, 6 Payment Declined
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7, enabled = true)
    public static void multipleSearch() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.emailSearch("qa1jmb@outlook.com");
        bb.typeSearch(1);
        bb.statusSearch(1);
        bb.commitSearch();
    }
    /******************************************************************
     // * Description: Verify 0 record for non existing email address
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8, enabled = true)
    public static void noRecordsSearch() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.noRecordFound();
    }
    /******************************************************************
    // * Description: Verify user can navigate across the list buyback results
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 9, enabled = false)
    public static void listPagination() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.paging("last");
        bb.paging("previous");
        bb.paging("next");
        bb.paging("first");
    }
    /******************************************************************
     // * Description: Verify user can navigate to the uploaded file link
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 10, enabled = true)
    public static void uploadedFileImg() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.orderSearch("4209");
        bb.commitSearch();
        bb.editOrder();
        bb.uploadedFileLink("qaBbImge1631913454.png");
    }
    /******************************************************************
     // * Description: Verify user can search on supplier
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 11, enabled = true)
    public static void supplierSearch() {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        li.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.searchSupplier("Provident Metals");
    }
    /******************************************************************
     // * Description: Verify buyback total amount is updated
     // * Param: String
     // * Jira Ticket: JMB-6319, JMB-5866 and JMB-6161
     // * Status: Complete
     //*******************************************************************/
    @Test (priority = 12, enabled = true)
    public static void bbTotal_JM6319(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.emailSearch("1631565376250Auto@jmbullion.com");
//        bb.statusSearch(1);
        bb.commitSearch();
        bb.editOrder();
//        bb.bbCalculatedTotal();
        bb.verifyBbTotal();
    }

    /******************************************************************
     // * Description: Verify user can search on supplier
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
//    @Test(priority = 10, enabled = true)
//    public static void supplierSearch() {
//        String tcName = (new Object() {
//        }.getClass().getEnclosingMethod().getName());
//        Controls li = new Controls();
//        li.adminLogin();
//        Buyback bb = new Buyback();
//        bb.bbMenuItem("list");
//        bb.searchSupplier("Provident Metals");
//
//    }

    /*************************************************************************************
 	// * Description: Verify the IRA information in Edit buyback page 
 	// * Param: NA
 	// * Jira Ticket: JMB-7364
 	// * Status:Completed
 	//**************************************************************************************/
	@Test(priority = 13, enabled = true)
	public void verifyIraInformationInEditBuyBackPage() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		bb.bbMenuItem("list");
		bb.formSelectText("bb.searchCreatedBy.xp", "IRA");
		Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps, "bb.searchCreatedBy.IRAOption.xp"));
		bb.commitSearch();
		bb.editOrder(1);
		bb.verifyIraAccountInformationDetails();
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
