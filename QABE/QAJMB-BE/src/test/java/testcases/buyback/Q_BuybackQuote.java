package testcases.buyback;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;


public class Q_BuybackQuote extends Init {
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
    /********************************************************
     * Description: Verify Save as Quote Functionality
     * Author: Ilakiya
     * Status: Completed
     * Jira Ticket: JMB - 7263
	 *********************************************************/
	@Test(priority = 1, enabled = true)
	public void verifySaveAsQuoteFunctionality() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		bb.bbMenuItem("new");	   
		bb.newBuybackQuote("qa+1jmb@jmbullion.com" ,2);
		bb.showAddresses();
		bb.selectAddress(2);
		bb.selectBank(1);
		bb.selectPayment("WIRE");
		bb.selectDefaultCard(1, 6); 
		bb.addBbProduct(2, "10","1 oz Canadian Palladium Maple Le");
		bb.reportable();
		bb.formXp("bb.saveAsQuote.xp");
		Assert.assertTrue(bb.strXpText("bb.quoteCreatedMessage.xp").equals("buyback quote was created successfully"), "Failed to create Buyback quote");
	}
	
	/********************************************************
    // * Description: Verify Edit Functionality in Buyback Quote page
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 7266
	 *********************************************************/
    @Test(priority = 2, enabled = true)
    public void editBuybackQuote() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		Controls.adminLogin();
		bb.bbMenuItem("list bb quote");
        bb.editOrder();
		bb.editAddress();
        bb.skipCreditCard();
        bb.saveBBQuoteAndVerifyNotes("buyback quote was updated successfully");
        bb.retAttributAssertion("bb.newAddressField2.xp", "Auto Edited");
    }

	/********************************************************
    // * Description: Verify Edit Functionality in Buyback Quote page
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 7266
	 *********************************************************/
    @Test(priority = 3, enabled = true)
    public void refreshBuybackQuote() {
    	String goldSpot,silverSpot,platinumSpot,palladiumSpot;
    	String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
    	Controls.testStarted(tcName);
    	Controls.adminLogin();
    	bb.bbMenuItem("list bb quote");
    	bb.editOrder();
    	Q_WebElm.myWait(2000);
    	goldSpot = bb.attReturn("bb.editBuybackQuote.goldSpot.xp", "value");
    	silverSpot = bb.attReturn("bb.editBuybackQuote.silverSpot.xp", "value");
    	platinumSpot = bb.attReturn("bb.editBuybackQuote.platinumSpot.xp", "value");
    	palladiumSpot = bb.attReturn("bb.editBuybackQuote.palladiumSpot.xp", "value");
    	bb.formXp("bb.editBuybackQuote.refreshQuoteBtn.xp");
    	Q_WebElm.myWait(3000);
    	Assert.assertTrue(bb.strXpText("bb.quoteCreatedMessage.xp").contains("quote refreshed successfully"), "Quote refresh Notes is not displayed");
    	Assert.assertFalse(goldSpot.equals(bb.attReturn("bb.editBuybackQuote.goldSpot.xp", "value")) || silverSpot.equals(bb.attReturn("bb.editBuybackQuote.silverSpot.xp", "value"))
    			|| platinumSpot.equals(bb.attReturn("bb.editBuybackQuote.platinumSpot.xp", "value")) || palladiumSpot.equals(bb.attReturn("bb.editBuybackQuote.palladiumSpot.xp", "value")));
    }
    
    /********************************************************
    // * Description: Verify user can search Buyback Quotes based on Order Number
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 7264
	 *********************************************************/
    @Test(priority = 4, enabled = true)
    public void orderNumberSearch() {
    	String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
    	Controls.testStarted(tcName);
    	Controls.adminLogin();
    	bb.bbMenuItem("new"); 
    	bb.newBuyBackQuote("qa+2jmb@jmbullion.com" ,2);
    	bb.showAddresses(); 
    	bb.selectAddress(2); 
    	bb.selectBank(1);
    	bb.selectPayment("WIRE"); 
    	bb.selectDefaultCard(1, 6);
    	bb.addBbProduct(2,"11","1 oz Canadian Palladium Maple Le"); 
    	bb.reportable();
    	bb.formXp("bb.saveAsQuote.xp"); 
    	Q_WebElm.myWait(3000); 
    	String orderNumber=bb.attReturn("bb.bbQuoteOrderNumber.xp", "value");
    	bb.bbMenuItem("list bb quote");
    	bb.orderSearch(orderNumber);    	
    }

    /*********************************************************
    // * Description: Verify user can search Buyback Quotes based on email
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 7264
	 *********************************************************/
    @Test(priority = 5, enabled = true)
    public void emailOrderSearch() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		Controls.adminLogin();
		bb.bbMenuItem("list bb quote");
		bb.emailSearch("qa+1jmb@jmbullion.com");
    }
    
    /******************************************************************
    // * Description: Verify user can search Buyback Quotes based on customer name
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 7264
	 ******************************************************************/
    @Test(priority = 6, enabled = true)
    public void nameOrderSearch() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		Controls.adminLogin();
		bb.bbMenuItem("list bb quote");
		bb.nameSearch("qa2jmb Automation");
    }
    
    /********************************************************
    // * Description: Verify Buybacks can be added from Admin Page
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 6357
	 *********************************************************/
    @Test(priority = 7, enabled = true)
    public void verifyBBCanBeAddedFromAdminPage() {
    	String expectedURL="https://qa.jmbullion.com/admin/api/buybacks/new";
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName); 
		String customerID = "jmbqa6@jmbullion.com";
		Controls.adminLogin();
		bb.findCustomerByEmailAndInitiateBuyback(customerID, "initiateBB");	
		String actualURL = driver.getCurrentUrl();
    	Assert.assertTrue(expectedURL.equals(actualURL), "Quote refresh Notes is not displayed");

	}
    
	/********************************************************
    // * Description: Verify Buybacks can be added from Customer Page
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 6357
	 *********************************************************/
    @Test(priority = 8, enabled = true)
    public void verifyBBCanBeAddedFromCustomerPage() {
    	String expectedURL="https://qa.jmbullion.com/admin/api/buybacks/new";
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName); 
		String customerID = "jmbqa6@jmbullion.com";
		Controls.adminLogin();
		bb.findCustomerByEmailAndInitiateBuyback(customerID, "viewOrders");	
		String actualURL = driver.getCurrentUrl();
    	Assert.assertTrue(expectedURL.equals(actualURL), "Quote refresh Notes is not displayed");
	}
    
	/********************************************************
    // * Description: Verify Buybacks can be added from PM Admin Page
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 6357
	 *********************************************************/
    @Test(priority = 9, enabled = true)
    public void verifyBBCanBeAddedFromPMPage() {
    	String expectedURL="https://qa.jmbullion.com/admin/api/buybacks/new";
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName); 
		String customerID = "jmbqa6@jmbullion.com";
		li.providentMetalsAdminLogin();
		bb.findCustomerByEmailAndInitiateBuyback(customerID, "initiateBB");	
		bb.findCustomerByEmailAndInitiateBuyback(customerID, "initiateBB");
		String actualURL = driver.getCurrentUrl();
    	Assert.assertTrue(expectedURL.equals(actualURL), "Quote refresh Notes is not displayed");
	}
    
	/********************************************************
    // * Description: Verify Buybacks can be added from PM Admin customer Page
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 6357
	 *********************************************************/
    @Test(priority = 10, enabled = true)
    public void verifyBBCanBeAddedFromPMCustomerPage() {
    	String expectedURL="https://qa.jmbullion.com/admin/api/buybacks/new";
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName); 
		String customerID = "jmbqa6@jmbullion.com";
		li.providentMetalsAdminLogin();
		bb.findCustomerByEmailAndInitiateBuyback(customerID, "viewOrders");	
    	Q_WebElm.myWait(2000);
		bb.findCustomerByEmailAndInitiateBuyback(customerID, "initiateBB");
		String actualURL = driver.getCurrentUrl();
    	Assert.assertTrue(expectedURL.equals(actualURL), "Quote refresh Notes is not displayed");
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
