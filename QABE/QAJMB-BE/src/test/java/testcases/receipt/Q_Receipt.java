package testcases.receipt;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;

import utils.Controls;
import utils.Init;

import java.io.FileNotFoundException;
import java.text.ParseException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Q_Receipt extends Init {
    static Q_AdminForm adm = new Q_AdminForm();
    static Q_CustomerForm cust = new Q_CustomerForm();
    static Q_ProductForm prod = new Q_ProductForm();
    static Q_HoldsForm hold = new Q_HoldsForm();
    static Q_OrderForm ord = new Q_OrderForm();
    static Q_Buyback bb = new Q_Buyback();
    static Q_CheckoutForm chk = new Q_CheckoutForm();
    static Q_ReceiptForm recp = new Q_ReceiptForm();
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
    
    /*********************************************************************
	 * Description: Verify Decimal Places of Product's premium and
	 * total premium in a repo
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-7319
	 ********************************************************************/
	@Test(priority = 1)
	public void verifyProductPremiumDecimalPlaces_repo() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		adm.repoMenu("add repo");
		recp.addRepoProduct("1 oz Silver Bar (Varied Condition, An", 100);
		recp.verifyPremiumDecimalPlaces();
	}
	
	/*********************************************************************
	 * Description: Verify WireTool Improvements
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-6469
	 ********************************************************************/
	@Test(priority = 2)
	public void verifyWireToolImprovements() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		String shipmentCost = "500";
		String supplier = "Amark";
		Controls.testStarted(tcName);
		Controls.adminLogin();
		adm.adminMenu("receipts");
		adm.addReceipt();
		String receiptNo = recp.addOrderNumberToReceipt();
		adm.addReceiptProduct(1, "1 oz Silver Bar (Varied Condition, An", 50, "40");
		Q_WebElm.myWait(5000);
		adm.saveReceipt();
		Q_WebElm.myWait(3000);
		driver.navigate().to(adminUrl + "/wires.php");
		recp.createNewWire(supplier, receiptNo);
		recp.addShipmentCostToReceipt(shipmentCost, receiptNo);
		driver.navigate().to(adminUrl + "/wires.php");
		float wireTotal = recp.getNewWireCost_addedShipmentCost(supplier, receiptNo);
		recp.verifyWireTotal_afterShipmentCostAddition(shipmentCost, wireTotal);
		Controls.closeTabsSwitchWinMain();
	}
	
	/********************************************************************
	 // * Description  : Verify the Ability to Mark Receipt Unpaid in admin claim form page
	 // * Author       : Sivaraj
	 // * Param        : NA
	 // * Jira Ticket  : JMB-7651 - Ability to Mark Receipt Unpaid
	 // * Status       : Completed
	 //*******************************************************************/
	@Test(priority = 3, enabled = true)
	public void verifyMarkReceiptUnpaid() {
		String arrivalDate = recp.getFutureDateFromCurrentDate(2);
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		adm.adminMenu("receipts");
		adm.formXp("adm.recpSub.addReceipts.xp");
		recp.updateReceiptInformation(arrivalDate, "CNT", "adm.addReceipt.yes.xp");
		adm.adminMenu("receipts");
		adm.formXp("adm.recpSub.listReceipts.xp");
		recp.formXp("adm.addReceipt.details.xp");
		recp.verifyPaidStatusMsg("adm.addReceipt.paidStatusYesMsg.xp");
		recp.updateReceiptInformation(arrivalDate, "CNT", "adm.addReceipt.no.xp");
		driver.close();
		Controls.switchTab(0);
		driver.navigate().refresh();
		recp.formXp("adm.addReceipt.details.xp");
		recp.verifyPaidStatusMsg("adm.addReceipt.paidStatusNoMsg.xp");
	}
	
	/********************************************************************
	/ * Description: verify Delete Receipt Button for JM unarrive order
	/ * Param: NA
	/ * Jira Ticket: JMB-7331
	/ * Status: Complete
	/ * *******************************************************************/
	@Test(priority = 4)
	public void deleteReceiptButtonJmReceipt() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.adminLogin();
		adm.adminMenu("receipts");
		adm.addReceipt(37);
		String receiptNo = recp.addOrderNumberToReceipt();
		adm.addReceiptProduct(1, "1 oz Silver Bar (Varied Condition, An", 50, "40");
		Q_WebElm.myWait(5000);
		adm.saveReceipt();
		Q_WebElm.myWait(5000);
		adm.adminMenu("receipts");
		adm.editReceipts();
		Controls.switchTab(1);
		recp.verifyDeleteReceiptButtonDisplayed();
		recp.deleteReceipt();
		recp.verifyReceiptDeleted(receiptNo);
	}
	/********************************************************************
	/ * Description: verify Delete Receipt Button for JM arrived order
	/ * Param: NA
	/ * Jira Ticket: JMB-7331
	/ * Status: Complete
	/ * *******************************************************************/
	@Test(priority = 5)
	public void deleteReceiptButtonJmReceiptArrived() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.adminLogin();
		adm.adminMenu("receipts");
		adm.addReceipt(37);
		String receiptNo = recp.addOrderNumberToReceipt();
		adm.addReceiptProduct(1, "1 oz Silver Bar (Varied Condition, An", 50, "40");
		adm.saveReceipt();
		Q_WebElm.myWait(3000);
		recp.verifyDeleteReceiptButtonDisplayed();
		Q_WebElm.myWait(5000);
		recp.receiptArrived();
		Q_WebElm.myWait(5000);
		recp.verifyDeleteReceiptButtonNotDisplayed();
	}
	/********************************************************************
	/ * Description: verify Delete Receipt Button for no line item order
	/ * Param: NA
	/ * Jira Ticket: JMB-7331
	/ * Status: Complete
	/ * *******************************************************************/
	@Test(priority = 6)
	public void deleteReceiptButtonNoLineItemReceipt() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.adminLogin();
		adm.adminMenu("receipts");
		adm.addReceipt(37);
		String receiptNo = recp.addOrderNumberToReceipt();
		adm.saveReceipt();
		Q_WebElm.myWait(3000);
		adm.adminMenu("receipts");
		adm.editReceipts();
		Controls.switchTab(1);
		recp.verifyDeleteReceiptButtonDisplayed();
		recp.deleteReceipt();
		recp.verifyReceiptDeleted(receiptNo);
	}
	/********************************************************************
	/ * Description: verify Delete Receipt Button for any order except JM
	/ * Param: NA
	/ * Jira Ticket: JMB-7331
	/ * Status: Complete
	/ * *******************************************************************/
	@Test(priority = 7)
	public void deleteReceiptButtonAnyReceipt() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.adminLogin();
		adm.adminMenu("receipts");
		adm.addReceipt(2);
		String receiptNo = recp.addOrderNumberToReceipt();
		adm.addReceiptProduct(1, "1 oz Silver Bar (Varied Condition, An", 50, "40");
		Q_WebElm.myWait(5000);
		adm.saveReceipt();
		Q_WebElm.myWait(3000);
		recp.verifyDeleteReceiptButtonNotDisplayed();
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
