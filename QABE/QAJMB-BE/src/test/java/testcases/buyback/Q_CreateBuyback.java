package testcases.buyback;

import java.text.ParseException;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;


public class Q_CreateBuyback extends Init {
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
     // * Description: Verify user can only access buyback if he/she has the right permission
     // * Jira Ticket:
     // * Author:
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 1, enabled = true)
    public static void verifyBuybackUserPermission() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.selectAdminUser();
        adm.removePermission("Buybacks");
        bb.noBuybackPermission();
        adm.grantPermission("Buybacks");
        bb.buybackPermitted();
    }
    
    /******************************************************************
     // * Description: Verify customer customer email does not exist and should be entered as new customer
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test (priority = 2, enabled = true)
    public static void isCsutomer(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa1jmbqa1jmbqa1jmbqa1jmbqa1jmb@gmail.com" ,2);
        bb.verifyTextAssertion("bb.customerAlert.xp","No Jmbullion customer was found with the submitted email address. Please verify customer's status and try again.");
    }

    /******************************************************************
    // * Description: Verify creating buyback for new customer
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3, enabled = true)
    public static void newBuybackCustomer(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.addCustomer(2);
        bb.addBankInfo(2, 2,"011401533");
        bb.addIraInfo();
        bb.selectPaymentType(3);
        bb.addCreditCard(1);
        bb.addBbProduct(2,"10","1 oz Valcambi Gold Bar (New w/ Assa");
        bb.addBbProduct(3, "10" ,"1 oz Canadian Palladium Maple Le");
        bb.reportable();
        bb.productValidation();
        bb.premiumValidation();
        bb.saveBb();
    }
    
    /******************************************************************
    // * Description: Verify the functionality of skip credit card info will by pass the credit card required rule
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 4, enabled = true)
    public static void newBuybackCustomerSkipCC(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.addCustomer(2);
        bb.addBankInfo(2, 2,"011401533");
        bb.addIraInfo();
        bb.selectPaymentType(3);
        bb.skipCreditCard();
        bb.addBbProduct(2,"10","1 oz Valcambi Gold Bar (New w/ Assa");
        bb.addBbProduct(3, "10" ,"1 oz Canadian Palladium Maple Le");
        bb.reportable();
        bb.productValidation();
        bb.saveBb();
    }
    
    /******************************************************************
    // * Description: Verify creating buyback with existing user
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 5, enabled = true)
    public static void existingUser(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+1jmb@jmbullion.com" ,2);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectBank(2);
        bb.selectPayment("WIRE");
        bb.selectDefaultCard(1, 6);
        bb.addBbProduct(2, "10","1 oz Canadian Palladium Maple Le");
        bb.reportable();
        bb.premiumValidation();
        bb.productValidation();
        bb.saveBb();
    }
    
    /******************************************************************
     // * Description: Creating new address for existing user
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test (priority = 6, enabled = true)
    public static void addNewAddressExistingUser(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+10jmb@jmbullion.com" ,2);
        bb.newAddress();
        bb.selectBank(2);
        bb.selectPayment("WIRE");
        bb.skipCreditCard();
        bb.addBbProduct(2, "10","1 oz Canadian Palladium Maple Le");
        bb.reportable();
        bb.premiumValidation();
        bb.productValidation();
        bb.saveBb();
    }
    
    /******************************************************************
     // * Description: Verify creating buyback with existing user
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test (priority = 7, enabled = true)
    public static void existingUserSkipCreditCard(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+6jmb@jmbullion.com" ,2);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectBank(1);
        bb.selectPayment("WIRE");
        bb.skipCreditCard();
        bb.addBbProduct(2, "10","15 Gram Chinese Gold Panda Coin PCGS MS69 (Random Year, Varied Label)");
        bb.reportable();
        bb.premiumValidation();
        bb.productValidation();
        bb.saveBb();
    }
    
    /******************************************************************
    // * Description: Verify creating Provident buyback
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 8, enabled = true)
    public static void providentBuyback(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+10jmb@jmbullion.com", 1);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectBank(1);
        bb.selectPayment("WIRE");
        bb.selectCreditCard(1);
        bb.addBbProduct(2, "100", "15 Gram Chinese Gold Panda Coin PCGS MS69 (Random Year, Varied Label)");
        bb.addBbProduct(3, "10", "10 oz Credit Suisse Gold Bar");
        bb.reportable();
        bb.premiumValidation();
        bb.productValidation();
        bb.saveBb();
    }
    
    /******************************************************************
    // * Description: Verify creating JM Bullion buyback
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 9, enabled = true)
    public static void jmBullionBuyback(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+1jmb@jmbullion.com", 2);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectBank(1);
        bb.selectPayment("WIRE");
        bb.selectDefaultCard(1, 6);
        bb.addBbProduct(2, "10","15 Gram Chinese Gold Panda Coin PCGS MS69 (Random Year, Varied Labe");
        bb.reportable();
        bb.premiumValidation();
        bb.productValidation();
//        bb.saveBb();
    }
    
    /******************************************************************
    // * Description: Verify buybacks over $600 require credit card
    // * Param: String
    // * Returns: NA// * Status: Complete
    //*******************************************************************/
    @Test (priority = 10, enabled = true)
    public static void over1000RequireCreditCard(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+6jmb@jmbullion.com", 1);
        bb.selectPaymentType(1);
        bb.addBbProduct(2,"20","1 oz Canadian Palladium Maple Lea");
        bb.reportable();
        bb.premiumValidation();
        Q_WebElm.myWait(1000);
//        bb.productValidation();
//        bb.saveVerifyNotes("Buyback created");
        bb.verifyCreditCardRequired("A credit card is required for orders of $1000 or more.");
    }
    
    /******************************************************************
     // * Description: Verify buybacks with ACH payment type require bank account
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test (priority = 11, enabled = true)
    public static void paymentTypeACHRequireBankInfo(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+3jmb@jmbullion.com", 1);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectPaymentType(1);
        bb.selectDefaultCard(1, 6);
        bb.addBbProduct(2, "10","10 oz Sunshine Silver Bar (New, MintMar");
        bb.reportable();
        bb.premiumValidation();
        bb.productValidation();
        bb.verifyBankAccountRequired();
    }
    
    /******************************************************************
     // * Description: Verify buybacks with wire require bank account
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test (priority =12, enabled = true)
    public static void paymentTypeWireRequireBankInfo(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+1jmb@jmbullion.com", 2);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectPaymentType(2);
        bb.selectDefaultCard(1, 6);
        bb.addBbProduct(2, "20","10 oz SilverTowne Poured Silver Ba");
        bb.reportable();
        bb.premiumValidation();
        bb.verifyBankAccountRequired();
    }
    
    /******************************************************************
    // * Description: Verify buybacks with wire payment type has a fee of $25.00
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 13, enabled = true)
    public static void verifyWireFee(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+3jmb@jmbullion.com", 1);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectBank(1);
        bb.selectPaymentType(2);
        bb.selectDefaultCard(1, 6);
        bb.addBbProduct(2, "10","10 oz Sunshine Silver Bar (New, MintMar");
        bb.reportable();
        bb.premiumValidation();
        bb.productValidation();
        bb.saveBb();
        bb.paymentFee("25.00");
    }

    /******************************************************************
    // * Description: Verify buybacks with check payment type has a fee of $30.00
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 14, enabled = true)
    public static void verifyCheckPaymentFee(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+2jmb@jmbullion.com", 2);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectBank(1);
        bb.selectPaymentType(3);
        bb.selectDefaultCard(1, 6);
        bb.addBbProduct(2, "10","1 oz Valcambi Gold Bar (New w/ Ass");
        bb.reportable();
        bb.premiumValidation();
        bb.productValidation();
        bb.saveBb();
        bb.paymentFee("30.00");
    }
    
    /******************************************************************
    // * Description: Verify premium validation when unit price too high
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 15, enabled = true)
    public static void verifyUnitPriceTooHigh(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+1jmb@jmbullion.com", 1);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectBank(1);
        bb.selectPayment("WIRE");
        bb.selectDefaultCard(1, 6);
        bb.addNonBbProduct(2, "10","1 oz American Platinum Eagle Coin NGC MS69 (R", "1368.01");
        bb.reportable();
        bb.saveBb();
        bb.premiumValidation();
    }
    
    /******************************************************************
    // * Description: Verify premium validation when unit price too high
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 16, enabled = true)
    public static void verifyUnitPriceTooLow(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+1jmb@jmbullion.com", 2);
        bb.addBankInfo(2,2, "011401533");
        bb.selectPayment("WIRE");
        bb.selectDefaultCard(1, 6);
        bb.addNonBbProduct(2, "10","1 oz American Platinum Eagle Coin NGC MS69 (R", "225.09");
        bb.reportable();
        bb.saveBb();
        bb.premiumValidation();
    }
    
    /******************************************************************
     // * Description: Verify when a new buyback is created the status of the buyback should be Awaiting Delivery
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test (priority = 17, enabled = true)
    public static void statusAwaitingDelivery(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+1jmb@jmbullion.com", 1);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectBank(2);
        bb.selectPaymentType(1);
        bb.selectCreditCard(1);
        bb.addBbProduct(2, "20","1 oz Silver Bar (Varied Condition, Any");
        bb.reportable();
        bb.premiumValidation();
        bb.productValidation();
        bb.verifyStatus("Awaiting Delivery");
        bb.saveBb();
    }
    
    /******************************************************************
     // * Description: Verify a reportable item will be marked as such for the buyback
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test (priority = 18, enabled = true)
    public static void reportableItem(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+1jmb@jmbullion.com", 2);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectPaymentType(3);
        bb.selectCreditCard(1);
        bb.addBbProduct(2, "26","1 oz Gold Bar (Varied Condition,");
        bb.reportable();
        bb.premiumValidation();
        bb.productValidation();
        bb.saveBb();
        bb.validateReportable();
    }
    
    /******************************************************************
     // * Description: Verify buybacks multiple products can be added utilizing the Add Another Product button
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test (priority = 19, enabled = true)
    public static void addingMultipleProducts(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+12jmb@jmbullion.com", 1);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectPaymentType(3);
        bb.selectDefaultCard(1, 6);
        bb.addMultipleItems(5,"20");
        bb.reportable();
        bb.productValidation();
        Assert.assertTrue(Q_WebElm.idEnabled(adminProps, "bb.newProduct1Reportable.id").equals(true));
    }
    
    /******************************************************************
    // * Description: Verify if two line items are duplicate alert message pops up preventing duplicate products.
    // * Param: String
    // * Jira Ticket: JMB-4571
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 20, enabled = true)
    public static void duplicateProductAlert(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+12jmb@jmbullion.com", 1);
        bb.selectPaymentType(3);
        bb.selectDefaultCard(1, 6);
        bb.addBbProduct(2, "10","10 oz Sunshine Silver Bar (New, MintMar");
        bb.addBbProduct(3, "10","1 oz Canadian Palladium Maple Le");
        bb.addBbProduct(4, "10","10 oz Sunshine Silver Bar (New, MintMar");
        bb.verifyDuplicateProduct();
    }
    
    /******************************************************************
    // * Description: Verify if two line items are duplicate alert message pops up preventing duplicate products.
    // * Param: String
    // * Jira Ticket: JMB-4569
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 21, enabled = true)
    public static void zeroPremiumProduct(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+6jmb@jmbullion.com", 1);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectPaymentType(3);
//        bb.skipCreditCard();   failing
        bb.selectDefaultCard(1, 6);
        bb.addBbProduct(2, "10","1/2 oz HM Buffalo Silver R");
        bb.reportable();
        bb.productValidation();
        bb.premiumValidation();
        bb.saveBb();
    }
    
    /******************************************************************
    // * Description: Verify customer has tax information on file
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 22, enabled = true)
    public static void w9AlertNotDisplayedTaxInfoEntered(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+12jmb@jmbullion.com", 2);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectBank(2);
        bb.selectPaymentType(3);
        bb.selectDefaultCard(1,6);
        bb.addBbProduct(2, "40","1 oz Gold Bar (Va");
        bb.reportable();
        bb.productValidation();
        bb.saveBb();
        bb.premiumValidation();
        bb.validateReportable();
        bb.verifyW9Information("");
    }
    
    /******************************************************************
     // * Description: Verify W9 alert is not displayed as the item is not reportable item
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test (priority = 23, enabled = true)
    public static void NoW9AlertNonReportableItem(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa2jmb@gmail.com", 2);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectBank(2);
        bb.selectPaymentType(3);
        bb.selectDefaultCard(1,6);
        bb.addNonBbProduct(2, "1", "2015 1 oz Sioux Buffalo Silver Coin","23.01");
        bb.reportable();
        bb.productValidation();
        bb.saveBb();
        bb.premiumValidation();
        bb.validateReportable();
        bb.verifyW9Information("");
    }
    
    /******************************************************************
    // * Description: Verify item is reportable and customer missing tax information
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 24, enabled = true)
    public static void w9AlertReportableItemAndNoTaxInfo(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+2jmb@jmbullion.com", 2);
        bb.showAddresses();
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectBank(2);
        bb.selectPaymentType(3);
        bb.selectDefaultCard(1,6);
        bb.addBbProduct(2, "40","1 oz Gold Bar (Va");
        bb.reportable();
        bb.productValidation();
        bb.saveBb();
        bb.premiumValidation();
        bb.validateReportable();
        bb.verifyW9Information("This customer is missing W9 information. Please notify them that we may be unable to pay them for their buyback until they have submitted this information.");
    }

    /******************************************************************
    // * Description: Verify user can create buyback with 20 products
    // * Param: String
    // * Returns: NA
    // * Status: Complete
    //*******************************************************************/
    @Test (priority = 25, enabled = true)
    public static void largeBuyback(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+12jmb@jmbullion.com", 2);
        bb.showAddresses();
        bb.selectAddress(2);
        bb.selectBank(2);
        bb.selectPaymentType(3);
        bb.selectDefaultCard(1,6);
        bb.addMultipleItems(20,"10");
        bb.reportable();
        bb.premiumValidation();
        bb.productValidation();
        bb.saveVerifyNotes("Buyback created");
    }

    /******************************************************************
     // * Description: Verify user can not create buyback with expired credit card
     // * Param: String
     // * Returns: NA
     // * Status: Complete
     //*******************************************************************/
    @Test (priority = 26, enabled = true)
    public static void expiredCreditCard(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa3auto@jmbullion.com", 2);
        bb.selectAddress(2);
        bb.selectBank(2);
        bb.selectPayment("ACH");
        bb.addExpiredCreditCard(1);
    }
    
    /*******************************************************************
     * Description: Verifies that on selecting Mailing address with a drop off location
     * able to select Drop Off location and complete BB.
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6414(Buybacks - Drop off Option)
     ********************************************************************/
    @Test(priority = 27)
    public static void newBuyBackverifyDropOffOption() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+1jmb@jmbullion.com",2);
        bb.showAddresses();
        bb.selectAddress(3);
        bb.selectBank(2);
        bb.selectPayment("WIRE");
        bb.deliveryMethod("local drop off");
        bb.selectDefaultCard(1,6);
        bb.addBbProduct(2,"10","1 oz Canadian Palladium Maple Le");
        bb.reportable();
        bb.premiumValidation();
        bb.productValidation();
        bb.saveBb();
    }
    
    /******************************************************************
     // * Description: Verify functionality of Jira ticket5883 JMB-6098 Supplier Premium logger
     // * Param: String
     // * Jira Ticket: JMB-6098
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 28, enabled = true)
    public void premiumLogger_JM6098(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        bb.bbMenuItem("new");
        bb.newBuyBack("qa+1jmb@jmbullion.com", 2);
        bb.selectAddress();
        bb.selectBank(2);
        bb.selectPayment("WIRE");
        bb.selectDefaultCard(1, 6);
        bb.addNonBbProduct(2, "10","1 oz American Silver Eagle Coin (", "4.21");
        bb.reportable();
        bb.saveBb();
        bb.premiumValidation();
        bb.premiumLogger();
    }
    
    /********************************************************************
	 * Description: Verify Popup on above $500000 on creating new BB
	 * Author: Tamilselvan A
 	 * Status: Complete   
	 * Ticket: JMB-6682 
	 *******************************************************************/
	@Test(priority = 29, enabled = true)
    public void newBuyBackPopupAbove$500000() {
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
        bb.addBbProduct(2,"300","1 oz American Gold Buffalo (Random Year, BU)");
        bb.reportable();
        bb.premiumValidation();
        bb.productValidation();
        bb.saveBb();
        bb.verifyPopupOnBBAbove$500000();
        bb.productQty(2, "5");
        bb.productQtyTab(2);
        bb.reportable();
        bb.productValidation();
        bb.premiumValidation();
        Q_WebElm.myWait(3000);
        bb.saveBb();
	}
	
	/*********************************************************************
	 * Description: Verify clearance of Internal Status from Cancelled Buybacks
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-7173
	 ********************************************************************/
	@Test(priority = 30)
	public void verifyClearanceOfInternalStatus_cancelledBb() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Q_CreateBuyback.existingUser();
		bb.selectInternalStatusIndex(1);
        bb.saveBb();
        bb.cancelBuyback();
        Assert.assertEquals(bb.attReturn("bb.internalStatustext.xp", "value"), "NONE", "Internal status not refreshed to None.");
	}
	
	/********************************************************************
	 * Description: Verify Warning message on edit BB with the BB total change amount is more than $5k
	 * Author: Tamilselvan A
 	 * Status: Complete   
	 * Ticket: JMB-7406
	 *******************************************************************/
	@Test(priority = 31, enabled = true)
    public void largeEditBbWarningMessage() {
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
	    bb.addBbProduct(2,"1","1 oz American Gold Buffalo (Random Year, BU)");
	    bb.reportable();
	    bb.premiumValidation();
	    bb.productValidation();
	    float totalBbValueBeforeEdit=Float.parseFloat(Q_Buyback.bbTotal());
	    bb.saveBb();
	    bb.editFirstBbProductQty();
	    float totalBbValueAfterEdit=Float.parseFloat(Q_Buyback.bbTotal());
	    bb.saveBb();
	    bb.largeEditBbWarning(totalBbValueBeforeEdit,totalBbValueAfterEdit);
	    bb.closeLargeBbWarningMsg();
	    Q_WebElm.myWait(3000);
	    bb.saveBb();
	    bb.largeEditBbWarning(totalBbValueBeforeEdit,totalBbValueAfterEdit);
	    bb.clickOklargeEditBbWarning();
	}
	
	/********************************************************
    // * Description: Check whether Move Buyback functionality fetches correct information
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 6499
	 *********************************************************/
    @Test(priority = 32, enabled = true)
    public void verifyMoveBuybackInformation() {
		String customerEmail = "qa@jmbullion.com", address="3301 S Greenfield Rd,Auto Added,Gilbert,Az,85297,(961) 300-3301", 
			   bankDetails="031202084,******4567,First Fake,ACH";
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		bb.bbMenuItem("list");
		bb.formXp("bb.createBuybackLink.xp");
		bb.checkNew();
		bb.newBuyBack("qa9jmb@jmbullion.com", 2);
		bb.newAddress();
		bb.addBankInfo(1, 1, "031202084");
		bb.selectPaymentType(2);
		bb.skipCreditCard();
		Q_WebElm.myWait(2000);
		bb.addBbProduct(2, "2", "2018 1 oz American Silver Eagle Coin (BU)");
		bb.reportable();
		Q_WebElm.myWait(2000);
		bb.saveBb();
		bb.formXp("adm.editBuyBack.moveBuybackBtn.xp");
		Q_WebElm.myWait(2000);
		bb.updateCustomerEmailInMoveBuybacks(customerEmail);
		Q_WebElm.myWait(2000);
		Assert.assertTrue(bb.attReturn("adm.editBuyBack.emailAddress.xp", "value").equals(customerEmail),"Actual email not equal with existing customer email");
		bb.verifyBBShippingAddress(address);
		bb.verifyBBBankDetails(bankDetails);
	}
    
	/********************************************************
    // * Description: Verify the Move Buyback Log activity Update
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 6499
	 ********************************************************/
    @Test(priority = 33, enabled = true)
    public void verifyMoveBuybackLogUpdate() throws ParseException {
		String customerEmail = "qa@jmbullion.com";
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		bb.bbMenuItem("list");
		bb.formXp("bb.createBuybackLink.xp");
		bb.checkNew();
		bb.newBuyBack("qa9jmb@jmbullion.com", 2);
		bb.newAddress();
		bb.addBankInfo(1, 1, "031202084");
		bb.selectPaymentType(2);
		bb.skipCreditCard();
		Q_WebElm.myWait(2000);
		bb.addBbProduct(2, "2", "2018 1 oz American Silver Eagle Coin (BU)");
		bb.reportable();
		Q_WebElm.myWait(2000);
		bb.saveBb();
		bb.verifyNotes(hold.getCurrentESTDateAndTime());
		bb.verifyNotes("Buyback created.");
		bb.formXp("adm.editBuyBack.moveBuybackBtn.xp");
		Q_WebElm.myWait(2000);
		bb.updateCustomerEmailInMoveBuybacks(customerEmail);
		bb.verifyNotes(hold.getCurrentESTDateAndTime());
		bb.verifyNotes("Buyback moved successfully from User");
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
