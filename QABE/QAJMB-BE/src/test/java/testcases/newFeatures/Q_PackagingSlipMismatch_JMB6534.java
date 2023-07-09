package testcases.newFeatures;

import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.Controls;
import utils.Init;

import java.io.IOException;

public class Q_PackagingSlipMismatch_JMB6534 extends Init {
	static Q_AdminForm adm = new Q_AdminForm();
	static Q_CustomerForm cust = new Q_CustomerForm();
	static Q_ProductForm prod = new Q_ProductForm();
	static Q_HoldsForm hold = new Q_HoldsForm();
	static Q_OrderForm ord = new Q_OrderForm();
	static Q_Buyback bb = new Q_Buyback();
	static Q_CheckoutForm chk = new Q_CheckoutForm();
	static Q_NewFeatures nfal = new Q_NewFeatures();
	static Controls li = new Controls();
	@BeforeMethod
	public void report() throws Exception {
		Init.setItUp();
	}

	/******************************************************************
	 * Description: Verify that the updated cost is reflecting in Package Slip after editing of BuyBack
	 *  Author: Mobin 
	 *  Status: Completed 
	 *  Ticket: JMB-6534
	 *  Pre-requisite: Currently working only in Mac(with light theme),Bypass privacy settings(Screen Recording,Accessibility ) for the
	 *  IDE Which is being used.
	 *******************************************************************/
	@Test
	public void verifyPriceInPackageSlip() throws FindFailed, IOException, InterruptedException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		bb.bbMenuItem("list");
		bb.secondSearchStatus("bb.emailSearch.xp", "1632924705869Auto@jmbullion.com", 1);
		bb.commitSearch();
		bb.editOrder();
		String BBcostBeforeEdit = Q_NewFeatures.strXpText( "bb.Total.xp");
		System.out.println("Buy Back Total Before editing: " + BBcostBeforeEdit); 
		int currentQty = Q_NewFeatures.grabStringAndRetInteger(adminProps,"bbEdit.qty.beg.xp", 1, "bbEdit.qty.end.xp","value");
		nfal.modifyBBQuantity("increase", 2);
		bb.productQtyTab(2);
		bb.reportable();
		bb.productValidation();
		bb.premiumValidation();
		bb.saveBb();
		String BBcostAfterEdit = Q_NewFeatures.strXpText("bb.Total.xp");
		System.out.println("Buy Back Total After editing : " + BBcostAfterEdit);
		nfal.verifyCostInPackageSlip(BBcostBeforeEdit, BBcostAfterEdit);
		//CleanUp: Setting the Quantity back to previous state
		bb.productQty(2, String.valueOf(currentQty));
		bb.reportable();
		bb.productValidation();
		bb.premiumValidation();
		bb.saveBb();
	}

	@AfterMethod
	public void tearDown() throws Exception {
//		Controls.tearDown();
//		NewFeatures.deleteFileFromHomeDir("/Downloads/index.pdf");
	}
}
