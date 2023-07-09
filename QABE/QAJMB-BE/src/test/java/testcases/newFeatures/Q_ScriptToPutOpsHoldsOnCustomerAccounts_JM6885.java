package testcases.newFeatures;

import java.awt.AWTException;
import java.io.IOException;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Q_AdminForm;
import pageObjects.Q_Buyback;
import pageObjects.Q_CheckoutForm;
import pageObjects.Q_CustomerForm;
import pageObjects.Q_HoldsForm;
import pageObjects.Q_NewFeatures;
import pageObjects.Q_OrderForm;
import pageObjects.Q_ProductForm;
import pageObjects.Q_Tickets;
import pageObjects.Q_WebElm;
import utils.Controls;
import utils.Init;

public class Q_ScriptToPutOpsHoldsOnCustomerAccounts_JM6885 extends Init {
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
	 * Description: Create csv and upoad to run to change customer's operation hold 
	 * status from No to Yes.
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-6885
	 * 
	 * @throws IOException
	 * @throws AWTException
	 ********************************************************************/
	@Test(priority = 1)
	public void scriptToPutOpsHoldsOnCustomerAccounts() throws IOException, AWTException {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		String systemDownloadFolderPath = Paths.get(System.getProperty("user.home"), "Downloads").toString();
		String csvName = "Test_Sample.csv";
		String email1 = "qa20auto@jmbullion.com";
		String id1 = "379309";
		String email2 = "qa19auto@jmbullion.com";
		String id2 = "379308";
		String email3 = "qa18auto@jmbullion.com";
		String id3 = "379307";
		li.testStarted(tcName);
		li.adminLogin();
		cust.customerPage(email1);
		hold.removeOperationsHold();
		driver.navigate().to(adminUrl + "/customers.php?show=" + id2);
		hold.removeOperationsHold();
		driver.navigate().to(adminUrl + "/customers.php?show=" + id3);
		hold.removeOperationsHold();
		driver.navigate().to(adminUrl + "/customer-ops-holds.php");
		prod.existingFileDelete(systemDownloadFolderPath, csvName);
		hold.createCSV(systemDownloadFolderPath + "//" + csvName, email1, id1, email2, id2, email3, id3);
		hold.uploadCSV(systemDownloadFolderPath,csvName);
		hold.verifyList_dryRun(3, email1, id1, email2, id2, email3, id3);
		hold.verifyList_liveRun(3, email1, id1, email2, id2, email3, id3);
		driver.navigate().to(adminUrl + "/customers.php?show=" + id1);
		Assert.assertTrue(Q_WebElm.idAttrRet(adminProps, "cust.operationsHoldReason.id", "value").isBlank());
		driver.navigate().to(adminUrl + "/customers.php?show=" + id2);
		Assert.assertTrue(Q_WebElm.idAttrRet(adminProps, "cust.operationsHoldReason.id", "value").isBlank());
		driver.navigate().to(adminUrl + "/customers.php?show=" + id3);
		Assert.assertTrue(Q_WebElm.idAttrRet(adminProps, "cust.operationsHoldReason.id", "value").isBlank());
		prod.existingFileDelete(systemDownloadFolderPath, csvName);
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
