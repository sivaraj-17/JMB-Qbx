package testcases.newFeatures;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.*;
import testcases.buyback.Q_CreateBuyback;
import utils.*;

public class Q_UpdatingButtonsAndLinksToStopExtraClicks_JM5883 extends Init {
	static Q_AdminForm adm = new Q_AdminForm();
	static Q_CustomerForm cust = new Q_CustomerForm();
	static Q_ProductForm prod = new Q_ProductForm();
	static Q_HoldsForm hold = new Q_HoldsForm();
	static Q_OrderForm ord = new Q_OrderForm();
	static Q_Buyback bb = new Q_Buyback();
	static Q_CheckoutForm chk = new Q_CheckoutForm();
	static Q_NewFeatures nfal = new Q_NewFeatures();
	static Q_Tickets tic = new Q_Tickets();
	static Controls li = new Controls();

	@BeforeClass
	public void tcSetup() {
	}

	@BeforeMethod
	public void report() throws Exception {
		Init.setItUp();
	}

	@BeforeTest
	public void setTest() throws Exception {
	}

	/*********************************************************************
	 * Description: To check if the invoice submit button, add note button, admin
	 * return inhand button, email for call button, email for returned check button,
	 * and email for additional review button do not take double/extra clicks on
	 * order form. 
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-5883
	 * 
	 * @throws FileNotFoundException
	 ********************************************************************/
	@Test(priority = 1)
	public void updatingBtnsToStopExtraClicks_orderForm() throws FileNotFoundException {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		li.adminLogin();
		Q_WebElm.myWait(1000);
		chk.selectItem("perth10g", 1);
		ord.ordersMenu("list");
		ord.editTopOrder();
		nfal.fillInvoiceDetails("10.00");
		nfal.doubleClick("ord.create.invoiceCreateSubmit.xp");
		Assert.assertTrue(nfal.rowCount("ord.noOfInvoiceRows.xp") == 1);
		nfal.addNote_orderForm("test", "DM_Notes");
		nfal.doubleClick("ord.addNoteBtn.xp");
		nfal.verifyDoubleStatements("test");
		nfal.doubleClick("ord.adminReturnInhandBtn.xp");
		driver.navigate().refresh();
		Assert.assertTrue(nfal.rowCount("ord.adminReturnInhandMsg.xp") == 1);
		nfal.doubleClick("ord.emailCallBtn.xp");
		nfal.verifyDoubleStatements("Email sent after missed call.");
		nfal.doubleClick("ord.emailRetCheckBtn.xp");
		nfal.verifyDoubleStatements("Email sent after returned check.");
		nfal.doubleClick("ord.emailAddReviewbtn.xp");
		nfal.verifyDoubleStatements("Additional processing/reviewing time required due to information discrepancies.");
	}

	/*********************************************************************
	 * Description: To check if the Mark Entire Order Arrived button, email packing
	 * slip button do not take double/extra clicks while editing buyback. 
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-5883
	 ********************************************************************/
	@Test(priority = 2)
	public void updatingBtnsToStopExtraClicks_buyback() {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Q_CreateBuyback.existingUser();
		nfal.doubleClick("bb.entireArrived.xp");
		nfal.doubleClick("bb.emailPackingSlip.xp");
		nfal.verifyDoubleStatements_buyback();
	}

	/*********************************************************************
	 * Description: To check if the Mark Entire Order Arrived button, split button,
	 * and save changes button do not take double/extra clicks while editing
	 * receipt. 
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-5883
	 ********************************************************************/
	@Test(priority = 3)
	public void updatingBtnsToStopExtraClicks_receipt() {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		li.adminLogin();
		adm.adminMenu("receipts");
		adm.addReceipt();
		adm.addReceiptProduct(1, "1 oz Silver Bar (Varied Condition, An", 50, "40");
		Q_WebElm.myWait(5000);
		adm.saveReceipt();
		nfal.splitLineItem("10");
		Q_WebElm.myWait(2000);
		Controls.scrolUpPixel(100);
		nfal.doubleClick("bb.entireArrived.xp");
		Q_WebElm.myWait(5000);
		nfal.verifySplitLineItem("10");
		nfal.doubleClick("adm.receiptSave.xp");
		Controls.checkAndGetAlertText();
	}

	/*********************************************************************
	 * Description: To check if the Submit button does not take double/extra clicks
	 * on order claim form 
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-5883
	 ********************************************************************/
	@Test(priority = 4)
	public void updatingBtnsToStopExtraClicks_claim() {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		li.adminLogin();
		ord.ordersMenu("list");
		ord.editTopOrder();
		nfal.fillClaimDetails();
		nfal.doubleClick("bb.claimSubmit.xp");
		Controls.checkAndGetAlertText();
	}

	/*********************************************************************
	 * Description: To check if the Submit button does not take double/extra clicks
	 * on order return form 
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-5883
	 ********************************************************************/
	@Test(priority = 5)
	public void updatingBtnsToStopExtraClicks_return() {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		li.adminLogin();
		ord.ordersMenu("list");
		ord.editTopOrder();
		nfal.fillReturnDetails();
		nfal.doubleClick("bb.claimSubmit.xp");
		nfal.verifyDoubleStatements("New return created for this order with the following items:");
	}

	@AfterTest
	public void endReport() {

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Controls.tearDown();
	}

	@AfterClass
	public void exitClass() {
		System.out.println("After Class");
	}
}
