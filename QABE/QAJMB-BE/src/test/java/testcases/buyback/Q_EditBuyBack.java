package testcases.buyback;


import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_EditBuyBack extends Init {
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
    // * Description: Verify user can send email Packing Slip from buyback listing
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 1, enabled = true)
    public static void sendPackingSlipFrombbListing(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");/**/
        bb.statusSearch(1);
        bb.commitSearch();
        String ticketNumber = Q_Buyback.numberReturn("bb.orderDetails.beg.xp", 1, "bb.orderDetailTicket.end.xp");
        System.out.println("Ticket number "+ ticketNumber);
        bb.formXp("bb.listRightTicket.beg.xp", 1, "bb.listPackingSlip.end.xp");
        String msg = Q_Buyback.numberReturn("bb.editAlertPackingSlip.xp");
        Assert.assertEquals(msg, ticketNumber);
    }
    
    /******************************************************************
    // * Description: VVerify user can email packing slip from buyback edit screen
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 2, enabled = true)
    public static void orderEmailPackingSlip(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.search("email", "bb.searchEmail.xp","qa+1jmb@jmbullion.com");
        bb.editOrder();
        bb.formXp("bb.emailPackingSlip.xp");
        bb.saveVerifyNotes("Packing slip emailed to customer");
    }

    /******************************************************************
    // * Description: Verify user can delete individual items from buyback edit screen.
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 3, enabled = true)
    public static void deleteProduct(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
//        bb.search("email", "searchEmail.xp","qa+12jmb@jmbullion.com");
        bb.secondSearchStatus("bb.emailSearch.xp", "qa+12jmb@jmbullion.com",1);
        bb.commitSearch();
        bb.editOrder();
        bb.deleteItems("bb.editProductsActions.beg.xp", "bb.editProductsDelete.end.xp");
    }
    
    /******************************************************************
    // * Description: Verify user can mark entire order as Arrived from buyback edit screen and the order status changed to Accepted
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 4, enabled = true)
    public static void entireOrderArrived(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
//        adm.selectAdminUser("378260");
//        adm.grantPermission(47);
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp", "qa+1jmb@jmbullion.com", 1);
        bb.commitSearch();
        bb.searchSupplier("Provident Metals");
        bb.editCartNumber();
        bb.receiveEntireOrder();
//        adm.selectAdminUser("378260");
//        adm.removePermission(47);
    }
    
    /******************************************************************
    // * Description: Verify user can mark individual items as Arrived from buyback edit screen.
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 5, enabled = true)
    public static void receiveProdIndiv(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
//        adm.selectAdminUser("378260");
//        adm.grantPermission(47);
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp", "qa+6jmb@jmbullion.com", 1);
        bb.commitSearch();
        bb.searchSupplier("Provident Metals");
        bb.editCartNumber();
        bb.skipCreditCard();
        bb.receiveProductIndividually();
//        adm.selectAdminUser("378260");
//        adm.removePermission(47);
    }
    
    /******************************************************************
    // * Description: Verify user can edit customer information
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 6, enabled = true)
    public static void editCustomerInfo() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.nameSearch("Auto Buyback");
        bb.commitSearch();
        bb.editCustomer("Automated", "QaEnv");
    }

    /******************************************************************
    // * Description: Verify user can switch payment type
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 7, enabled = true)
    public static void editPaymentType()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp", "qa+1jmb@jmbullion.com", 1);
        bb.commitSearch();
        bb.editOrder();
        bb.selectPaymentType(3);
        bb.saveBb();
    }
    
    /******************************************************************
    // * Description: Verify user can edit buyback product quantity of an existing order
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 8, enabled = true)
    public static void editFirstBbProductQuantity()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.nameSearch.xp", "Auto Testcase", 1);
        bb.commitSearch();
        bb.editOrder();
        bb.productQty(2, "15");
        bb.productQtyTab(2);
        bb.reportable();
        bb.productValidation();
        bb.premiumValidation();
    }
    
    /******************************************************************
    // * Description: Verify user can add a product to existing buyback
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 9, enabled = true)
    public static void addProduct()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.nameSearch.xp", "qa2jmb", 1);
        bb.commitSearch();
        bb.editOrder();
        bb.addProductEditMode();
//        bb.skipCreditCard();
        bb.reportable();
        bb.productValidation();
        bb.premiumValidation();
    }
    
    /******************************************************************
    // * Description: Verify user can edit buyback internal status
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 10, enabled = true)
    public static void editInternalStatus()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.statusSearch(1);
        bb.commitSearch();
        bb.editOrder();
        bb.selectInternalStatusIndex(1);
        bb.saveBb();
        bb.verifyTicketNumberUrl();
    }
    
    /******************************************************************
    // * Description: Verify user can restore buyback internal status to the default value
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 11, enabled = true)
    public static void internalStatusShippingLabelRequested()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp", "qa+12jmb@jmbullion.com", 1);
        bb.commitSearch();
        bb.editOrder();
        bb.selectInternalStatusText("-- SELECT ONE --");
    }

    /******************************************************************
    // * Description: Verify user can add line item level note to the product line
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 12, enabled = true)
    public static void lineItemLevelNote()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
//        adm.selectAdminUser("378260");
//        adm.grantPermission(47);
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.nameSearch.xp", "qa2jmb", 1);
        bb.commitSearch();
        bb.editOrder();
        bb.skipCreditCard();
        bb.lineItemNote("Automated note");
        bb.verifyTicketNumberUrl();
//        adm.selectAdminUser("378260");
//        adm.removePermission(47);
    }
    
    /******************************************************************
    // * Description: Verify user can mark entire order as Arrived from buyback edit screen and the order status changed to Accepted
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 13, enabled = true)
    public static void editCartNumberSkipCreditCard() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp", "qa+6jmb@jmbullion.com", 1);
        bb.commitSearch();
        bb.editOrder();
        bb.skipCreditCard();
        bb.editCartNumber();
    }
    
    /******************************************************************
    // * Description: Verify user can initiate claim on a buyback
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 14, enabled = true)
    public static void initiateClaim() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp","qa+6jmb@jmbullion.com", 1);
        bb.commitSearch();
        bb.initiateBbClaim();
    }
    
    /******************************************************************
    // * Description: Verify user can remove claim on a buyback
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 15, enabled = true)
    public static void removeBbClaim() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp","qa+6jmb@jmbullion.com", 1);
        bb.commitSearch();
        bb.removeBbClaim();
    }
    
    /******************************************************************
    // * Description: Verify user can view change log and return to buyback
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 16, enabled = true)
    public static void viewBuybackChangeLog() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp","qa+1jmb@jmbullion.com", 1);
        bb.viewBbChangeLog();
    }
    
    /******************************************************************
     // * Description: Verify user can edit company name
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 17, enabled = true)
    public static void editCompanyName() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.nameSearch("Auto Buyback");
        bb.commitSearch();
        bb.editCompanyName();
    }
    
    /******************************************************************
     // * Description: Verify user can check the company for payment purposes
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 18, enabled = true)
    public static void companyCheckboxSelection() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.nameSearch("Auto Buyback");
        bb.commitSearch();
        bb.companyCheckbox();
    }
    
    /******************************************************************
     // * Description: Verify user can not cancel buyback if the buyback current status is paid
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 19, enabled = true)
    public static void  cantCancelPaidBuyback() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.statusSearch(4);
        bb.commitSearch();
        bb.editOrder();
        Assert.assertNotEquals(Q_Buyback.strXpText("bb.buybackBtn.xp"), "Cancel Buyback");
    }
    
    /******************************************************************
     // * Description: Verify if buyback status is paid user can deny payment
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 20, enabled = true)
    public static void  verifyUserCanDeclinePayment() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.statusSearch(4);
        bb.commitSearch();
        bb.editOrder();
        org.junit.Assert.assertEquals(Q_Buyback.isXpDisplayed("bb.declinePayment.xp"), true);
    }
    
    /******************************************************************
     // * Description: Verify user can edit address on a specific buyback
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //******************************************************************/
    @Test (priority = 21, enabled = true)
    public static void switchAddress(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.emailSearch("qa+1jmb@jmbullion.com");
        bb.commitSearch();
        bb.editOrder();
        bb.switchAddresses();
        bb.saveVerifyNotes("Buyback edited");
        bb.retAttributAssertion("bb.newStreetAddress.xp", "4108 Honeysuckle Dr");
    }
    
    /******************************************************************
    // * Description: Verify user can edit address on a specific buyback
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //******************************************************************/
    @Test (priority = 22, enabled = true)
    public static void editBbAddress(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.emailSearch("qa+6jmb@jmbullion.com");
        bb.commitSearch();
        bb.editOrder();
        bb.editAddress();
        bb.skipCreditCard();
        bb.saveVerifyNotes("Buyback edited");
        bb.retAttributAssertion("bb.newAddressField2.xp", "Auto Edited");
    }
    
    /******************************************************************
    // * Description: Verify user is alerted when he /she attempts to add an existing product to buyback in edit mode.
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //******************************************************************/
    @Test(priority = 23, enabled = false)
    public static void editBbDuplicateProduct()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp", "qa+3jmb@jmbullion.com", 1);
        bb.commitSearch();
        bb.editOrder();
        bb.addProductEditMode();
        bb.verifyDuplicateProduct();
        bb.premiumValidation();
    }
    
    /******************************************************************
     // * Description: Verify admin user can edit tax information (SSN and EIN) input fields.
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //******************************************************************/
    @Test(priority = 24, enabled = true)
    public static void editSSNnEIN()  {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.nameSearch("Auto Buyback");
        bb.commitSearch();
        bb.editSssnAndEin();
    }
    
    /******************************************************************
     // * Description: Verify admin user can edit or delete company name from buyback address
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //******************************************************************/
    @Test(priority = 25, enabled = true)
    public static void deleteCompanyName() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.nameSearch("Auto Buyback");
        bb.commitSearch();
        bb.deleteCompanyName();
    }
    
    /******************************************************************
     // * Description: Verify tax information shows only the last 4 digits
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //******************************************************************/
    @Test(priority = 26, enabled = true)
    public static void verifyTaxInfoEncrypted(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("list");
        bb.secondSearchStatus("bb.emailSearch.xp", "qa+12jmb@jmbullion.com", 1);
        bb.commitSearch();
        bb.editOrder(1);
        bb.verifyAttributeAssertion("bb.ssnInput.xp", "value",0, 7, "*******");
        bb.verifyAttributeAssertion("bb.einInput.xp", "value", 0, 6, "******");
    }
    
    /******************************************************************
	 * Description: Verify that the Notes & Logs in BB 
	 * Author: Mobin
	 * Status:Complete
	 * Ticket: JMB-6756
	 *******************************************************************/
	@Test(priority = 27, enabled = true)
	public void verifyBBNotesAndLogs() throws InterruptedException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		bb.bbMenuItem("list");
		bb.secondSearchStatus("bb.nameSearch.xp", "qa2jmb", 1);
		bb.commitSearch();
		bb.editOrder();
		Q_Buyback.addAndVerifyNoteInBB("Automated test case : Note added on ");
		Q_Buyback.verifyLogsSectionInBB("QA Test Automation");
	} 
	
	/*********************************************************************
	// * Description: Verify Duplicate Buyback Payment Account details not added
	// * Param: None
	// * Jira Ticket: JMB-6579
	// * Status: Complete
	// *******************************************************************/
	@Test(priority = 28, enabled = true)
	public static void duplicateBuybackPaymentAccount(){
		Controls.adminLogin();
		bb.bbMenuItem("list");
		bb.secondSearchStatus("bb.emailSearch.xp", "qa+11jmb@jmbullion.com", 1);
		bb.commitSearch();
		bb.editOrder();
		Q_Buyback.addBankInfoClickSaveBuyback("026001591", "123456789");
		int value = Q_WebElm.retXpListSize(adminProps, "jm.acTableSize.xp");
		System.out.println("Total records before add duplicate value: " + value);
		Q_Buyback.verifyDuplicateBankAccount();
	}
	
	/*********************************************************************
	 * Description: Validate the Go back button on edit BB page
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-6803
	 ********************************************************************/
	@Test(priority = 29)
	public void bbGoBackButton() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Q_SearchBuyback.statusSearch();
		bb.editOrder();
		bb.verifyGoBackBtn_editBB(adminUrl+"/api/buybacks/search");
	}
	
	/*********************************************************************
	 * Description: Verify the alert on a BB over $750k
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-6458
	 ********************************************************************/
	@Test(priority = 30)
	public void verifyAlertOnBBOver$750k() {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		li.adminLogin();
		bb.bbMenuItem("new");
		bb.newBuyBack("qa@jmbullion.com", 2);
		bb.showAddresses();
		bb.selectAddress(2);
		bb.selectBank(1);
		bb.selectPayment("WIRE");
		bb.selectDefaultCard(1, 6);
		bb.addBbProduct(2, "14", "1 Kilo Gold Bar (Varied, Any Mint");
		bb.verifyBBTotal("750000");
		bb.reportable();
		bb.saveBB_alertVerification("Please advise the customer that this must ship Brinks");
	}
	
	/********************************************************************
	 * Description: Verify Buyback Claim Modification
	 * Author: Tamilselvan A
 	 * Status: Complete   
	 * Ticket: JMB-5904 
	 *******************************************************************/
	@Test(priority = 31, enabled = true)
    public void buybackClaimModification() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
	    li.adminLogin();
	    bb.bbMenuItem("new");
	    bb.newBuyBack("qa+1jmb@jmbullion.com",2);
	    bb.showAddresses();
	    bb.selectAddress(3);
	    bb.selectBank(2);
	    bb.selectPayment("WIRE");
	    bb.selectDefaultCard(1,6);
	    bb.addMultipleItems(6, "2");
	    bb.reportable();
	    bb.premiumValidation();
	    bb.productValidation();
	    Q_WebElm.myWait(3000);
	    bb.saveBb();
	    bb.editOrder();
	    bb.deleteItems("bb.editProductsActions.beg.xp", "bb.editProductsDelete.end.xp");
	    Q_WebElm.myWait(3000);
	    bb.saveBb();
	    String deletedProdId=bb.buybackClaimModification();
	    bb.clickEditClaim();
	    bb.verifyProductInClaimForm(deletedProdId);
	}
	
	/********************************************************************
	 // * Description  : Verify Move Buyback functionality in admin claim form page
	 // * Author       : Sivaraj
	 // * Param        : NA
	 // * Jira Ticket  : JMB-6409 - Move Buybacks
	 // * Status       : Completed
	 //*******************************************************************/
	@Test(priority = 32, enabled = true)
	public void verifyMoveBuybackFunctionality() {
		String customerEmail = "qa@jmbullion.com";
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		bb.bbMenuItem("list");
		bb.formXp("bb.createBuybackLink.xp");
		bb.checkNew();
		bb.newBuyBack("qa9jmb@jmbullion.com", 2);
		bb.newAddress();
		bb.addBankInfo(2, 1, "031202084");
		bb.selectPaymentType(3);
		bb.addBbProduct(2, "2", "2018 1 oz American Silver Eagle Coin (BU)");
		bb.reportable();
		bb.saveBb();
		bb.formXp("adm.editBuyBack.moveBuybackBtn.xp");
		Q_WebElm.myWait(2000);
		bb.updateCustomerEmailInMoveBuybacks(customerEmail);
		Assert.assertTrue(bb.attReturn("adm.editBuyBack.emailAddress.xp", "value").equals(customerEmail),"Actual email not equal with existing customer email");
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
