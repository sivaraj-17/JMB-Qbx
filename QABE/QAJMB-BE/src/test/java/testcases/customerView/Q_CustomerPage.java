package testcases.customerView;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;

import utils.Controls;
import utils.Init;

import java.io.FileNotFoundException;
import java.text.ParseException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Q_CustomerPage extends Init {
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
     // * Description: Verify user can edit customer order by column header in the customer view page.
     // * Available parameters for order are orderNum, date, total, status and datePaid.
     // * Status: Complete
     // * Jira Ticket: NA
     //*******************************************************************/
    @Test(priority = 1)
    public static void viewCustomerOrderByParam() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        cust.customerPage("qa+1jmb@jmbullion.com");
        cust.viewOrderByParam("status", "Paid");
    }
    /******************************************************************
     // * Description: Verify admin user with proper permissions can set or remove qc status
     // * Status: Complete
     // * Jira Ticket: NA
     //*******************************************************************/
    @Test(priority = 2)
    public static void setAndRemoveQcStatus() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        cust.customerPage("qa+1jmb@jmbullion.com");
        cust.setQc();
        cust.removeQc();
    }
    /******************************************************************
     // * Description: Verify admin user with proper permissions can set or remove with Military status
     // * Status: Complete
     // * Jira Ticket: NA
     //*******************************************************************/
    @Test(priority = 3)
    public static void setAndRemoveMilitaryMember() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        cust.customerPage("qa2auto@jmbullion.com");
        cust.setMilitaryMember();
        cust.removeMilitaryMember();
    }
    /******************************************************************
     // * Description: Verify admin user with proper permissions can set or remove Customer's Shipment Delay for NSF
     // * Status: Complete
     // * Jira Ticket: NA
     //*******************************************************************/
    @Test(priority = 4)
    public static void setAndRemoveShipmentDelay() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        cust.customerPage("qa2auto@jmbullion.com");
        cust.setExtSHipmentDelay();
        cust.removeExtSHipmentDelay();
    }
    /******************************************************************
     // * Description: Verify admin user with proper permissions can set customer's Ship Method
     // * Status: Complete
     // * Jira Ticket: NA
     //*******************************************************************/
    @Test(priority = 5)
    public static void setAndRemoveShipMethod () {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        cust.customerPage("qa2auto@jmbullion.com");
        cust.setShipMethod("UPS");
        cust.removeShipMethod();
    }
    /******************************************************************
     // * Description: Verify admin user with proper permissions can set or reset Force Signature flag
     // * Status: Complete
     // * Jira Ticket: NA
     //*******************************************************************/
    @Test(priority = 6)
    public static void setAndRemoveForceSignatureFlag () {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        cust.customerPage("qa2auto@jmbullion.com");
        cust.setForceSignature();
        cust.removeForceSignature();
    }
    /******************************************************************
     // * Description: Verify admin user with proper permissions can set or reset DIY Buyback flag
     // * Status: Complete
     // * Jira Ticket: NA
     //*******************************************************************/
    @Test(priority = 7)
    public static void setAndRemoveDIYBuybackCapability () {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        cust.customerPage("qa2auto@jmbullion.com");
        cust.setDIYBuyback();
        cust.removeDIYBuyback();
    }
    /******************************************************************
     // * Description: Verify user can view customer page and edit billing information
     // * Status: Complete
     // * Jira Ticket: NA
     //*******************************************************************/
    public static void editCustomerBillingInfo () {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        cust.customerPage("qa2auto@jmbullion.com");
        cust.editCustomerBilling();
    }
    /******************************************************************
     // * Description: Verify user can force shipping information to be the same as billing information
     // * Status: Complete
     // * Jira Ticket: NA
     //*******************************************************************/
    @Test(priority = 9)
    public static void copyBiilingInfoToShipInfo () {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        cust.customerPage("qa2auto@jmbullion.com");
        cust.shipAddSameAsBillingAdd();
    }
    /******************************************************************
     // * Description: Verify user can view customer page and edit shipping information
     // * Status: Complete
     // * Jira Ticket: NA
     //*******************************************************************/
    @Test(priority = 10)
    public static void editCustomerShippingInfo () {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        cust.customerPage("qa4auto@jmbullion.com");
        cust.editCustomerShipping();
    }
    /******************************************************************
     // * Description: Verify user can trigger reset password email to be sent to customer
     // * Status: Complete
     // * Jira Ticket: NA
     //*******************************************************************/
    @Test(priority = 11)
    public static void sendPassResret () {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        cust.customerPage("qa@jmbullion.com");
        cust.sendResetPassEmail();
    }
    /******************************************************************
     // * Description: Verify user can toggle customer fraud status
     // * Status: Complete
     // * Jira Ticket: NA
     //*******************************************************************/
    @Test(priority = 12, enabled = false)
    public static void setAndRestFraudFlag () {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        cust.customerPage("qa3auto@jmbullion.com");
        cust.labelCustomerFraud();
    }
    /******************************************************************
     * Description: Verify QC Status when Force Shipping is set to USPS Registered
     * Mail that UPS mailing options do not appear when creating a new order.
     * Author: Paul Patterson
     * Jira Ticket: JMB-6254, JMB-6584, JMB-6991
     * Status: Complete
     //*******************************************************************/
    @Test(priority = 13)
    public static void verifyForceShippingToUSPSRegMail() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.findCustomerByEmail("qa@jmbullion.com");
        cust.setShipMethod("USPS Registered Mail");
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar/");
        Q_WebElm.myWait(1000);
        chk.addItemToCart(6);
        chk.selectPaymentType("cheque");
        chk.selectcheckoutBtn("top");
        chk.verifyAvailableShippingMethods("Free Shipping;"
        		+ "Secure Storage - TDS;"
        		+ "Local Pickup");
        chk.completeOrder();
        driver.navigate().to(adminUrl);
        cust.customerPage("qa@jmbullion.com");
        cust.removeShipMethod();
    }
    
    /******************************************************************
     * Description: Verify QC Status when Force Shipping is set to USPS Registered
     * and create and order and verifying shipping options.
     * Author: Paul Patterson
     * Jira Ticket: JMB-6584, JMB-6991
     * Status: Complete
     //*******************************************************************/
    @Test(priority = 14)
    public static void verifyForceShippingToUSPSMail() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.findCustomerByEmail("qa@jmbullion.com");
        cust.setShipMethod("USPS");
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar/");
        Q_WebElm.myWait(1000);
        chk.addItemToCart(3);
        chk.selectPaymentType("cheque");
        chk.selectcheckoutBtn("top");
        chk.verifyAvailableShippingMethods("Free Shipping;"
        		+ "USPS Priority;"
        		+ "Secure Storage - TDS;Local Pickup");
        chk.completeOrder();
        driver.navigate().to(adminUrl);
        cust.customerPage("qa@jmbullion.com");
        cust.removeShipMethod();
    }
    
    /******************************************************************
     * Description: Verify QC Status when Force Shipping is set to UPS Registered
     * and create and order and verifying shipping options.
     * Author: Paul Patterson
     * Jira Ticket: JMB-6584, JMB-6991
     * Status: Complete
     //*******************************************************************/
    @Test(priority = 15)
    public static void verifyForceShippingToUPSMail() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.findCustomerByEmail("qa@jmbullion.com");
        cust.setShipMethod("UPS");
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar/");
        Q_WebElm.myWait(1000);
        chk.addItemToCart(3);
        chk.selectPaymentType("cheque");
        chk.selectcheckoutBtn("top");
        chk.verifyAvailableShippingMethods("Free Shipping;"
        		+ "Expedited Shipping Our Choice UPS or FedEx;"
        		+ "Secure Storage - TDS;Local Pickup");
        chk.completeOrder();
        driver.navigate().to(adminUrl);
        cust.customerPage("qa@jmbullion.com");
        cust.removeShipMethod();
    }
    /******************************************************************
     * Description: Verify QC Status removed with MLF of at least $100 even when paid
     * Author: Paul Patterson
     * Jira Ticket: JMB-6038 Remove QC Status on invoice creation
     * Status: Complete
     //*******************************************************************/
    @Test(priority = 16)
    public static void verifyMLFInvoiceOver100RemovesQCstatus() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Boolean qcCheck;
        li.adminLogin();
        adm.adminCustomerSearch("email", "qa1jmb@gmail.com");
        adm.adminViewAllOrders();
        // Check to make sure QC is "Yes" for qa1jmb@gmail.com
        cust.checkQc("Yes");
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        ord.MLFadm(288, 295, 100f );
        ord.processCancellationFee();
        ord.changeOrderStatus("pending");
        driver.navigate().to(adminUrl);
        adm.adminCustomerSearch("email", "qa1jmb@gmail.com");
        adm.adminViewAllOrders();
        cust.checkQc("No");
        System.out.println("Current date " + Controls.currentDate());
        Assert.assertTrue(cust.checkQc("No"), ("Verify QC is removed due to MLF Invoice - " +  Controls.currentDate()));
        cust.checkQc("Yes");
    }
    /******************************************************************
    // * Description:Verify Customer Notes Timestamp
    // * Param: String
    // * Jira Ticket: JMB-6153
    // * Status: Complete
    //*********************************************************************/
    @Test(priority = 17, enabled = true)
    public static void CustomerNotesTimestamp() throws ParseException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.findCustomerByEmail("qa2jmb@gmail.com");
        cust.editCustomerAddNotes();
        cust.verifyCustomerNotesTimestamp();
        cust.editCustomerRemoveNotes();
    }
    
    /*********************************************************************
	 * // * Description:  Verify switch user is logged in customer log field
	 * // * Param: NA 
	 * // * Jira Ticket: JMB-7199
	 * // * Status: Complete  
	 *******************************************************************/

	@Test(priority = 18, enabled = true)
	public static void verifyCustomerLogSwitchUser() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		String emailAccount="qa+1jmb@jmbullion.com";
        cust.customerPage(emailAccount);
        cust.verifySwitcToBtnNavi(emailAccount);
        cust.switchBackToAdmin();
        cust.verifyCustLog(emailAccount);
	}
	
	/********************************************************************
	 // * Description  : Verify Gold Starter Pack
	 // * Author       : Sivaraj
	 // * Jira Ticket  : JMB-7345
	 // * Status       : Complete
	 //*******************************************************************/
	@Test(priority = 19, enabled = true)
	public void verifyGoldStarterPack(){
		String expectedMessage = "You have reached our 1 per person/household max, unavailable for additional purchases.";
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		cust.resetGoldStarterPack();
		Q_WebElm.myWait(2000);
		cust.orderGoldStarterPack();
		Q_WebElm.myWait(2000);
		driver.navigate().to(baseUrl+"ato/smarty.php ");
		driver.navigate().to(baseUrl+"gold-starter-pack/");	
		Assert.assertTrue(expectedMessage.equals(Q_WebElm.xpRetText(adminProps, "goldStarterPack.message.xp")), "Add the product in cart");
		cust.verifyGoldStarterpackDate(cust.getCurrentESTDateAndTime());
	}
	
	/********************************************************************
	 // * Description  : To verify reseller certification without permission 12 (Accounting)
	 // * Author       : Shriram S K
	 // * Param        : NA
	 // * Jira Ticket  : JMB-8018  
	 // * Status       : Completed
	 // *******************************************************************/
	@Test(priority = 20, enabled = true)
	public static void verifyResellerCertWithoutPermission12() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		cust.navigateToQaTestGroupManagePermission();
		adm.removePermission("Accounting");
		Q_WebElm.myWait(2000);
		adm.adminMenu("customers");
		cust.customerMenu("Add Customer");
		cust.userWithoutPermissionAccounting();
	}
	
	/********************************************************************
	 // * Description   : To verify reseller certification with permission 12 (Accounting)
	 // * Author        : Shriram S K
	 // * Param         : NA
	 // * Jira Ticket   : JMB-8018
	 // * Status        : Complete
	 //*******************************************************************/
	@Test(priority = 21, enabled = true)
	public static void verifyResellerCertWithPermission12() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		cust.navigateToQaTestGroupManagePermission();
		adm.grantPermission("Accounting");
		Q_WebElm.myWait(2000);
		adm.adminMenu("customers");
		cust.customerMenu("Add Customer");
		cust.userWithPermissionAccounting();
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
