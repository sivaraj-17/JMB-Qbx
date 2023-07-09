package testcases.tickets;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Q_AdminForm;
import pageObjects.Q_OrderForm;
import pageObjects.Q_ProductForm;
import pageObjects.Q_Tickets;
import pageObjects.Q_WebElm;
import utils.Controls;
import utils.Init;

public class Q_BGASCDiscountTiersAreNotWorking_JMB8395 extends Init {

	static Q_OrderForm ord = new Q_OrderForm();
	static Q_Tickets tic = new Q_Tickets();
	static Q_AdminForm adm = new Q_AdminForm();
	static Q_ProductForm prod = new Q_ProductForm();

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

	/********************************************************************** 
    // * Description : To Verify user BGASC discount Tiers Are Working 
    // * Author      : Sivaraj 
    // * Status      : Complete 
    // * Jira Ticket : JMB-8395 
    //**********************************************************************/
	@Test(priority = 1, enabled = true)
	public void bgascAddDiscount() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		adm.adminMenu("products");
		prod.productsIdSearch("258588");
		int numberOfTires = tic.getNumberOfTires("BGASC");
		tic.removeAndAddDiscountTiers(numberOfTires, "bgasc_discounts", "prod.bgascDiscountAddDiscount.Btn.xp");
		Controls.closeTabsSwitchWinMain();
	}

	/********************************************************************** 
    // * Description : To Verify PDP for a BGASC product displays discounts as provisioned on the product page
    // * Author      : Sivaraj 
    // * Status      : Complete 
    // * Jira Ticket : JMB-8395 
    //**********************************************************************/
	@Test(priority = 2, enabled = true)
	public void verifyPdpBgascDiscounts() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		adm.adminMenu("products");
		prod.productsIdSearch("258588");
		tic.pdpDiscount("prod.bgascOnSite.xp", "prod.bgascPdp.checkPrice.beg.xp", "prod.bgascPdp.tier.end.xp");
		Controls.closeTabsSwitchWinMain();
	}

	/********************************************************************** 
    // * Description : To Verify user remove BGASC discount on the product page 
    // * Author      : Sivaraj 
    // * Status      : Complete 
    // * Jira Ticket : JMB-8395 
    //**********************************************************************/
	@Test(priority = 3, enabled = true)
	public void removeBgascProductDiscounts() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		adm.adminMenu("products");
		prod.productsIdSearch("258588");
		tic.removeDiscountTiers("prod.bgascDiscount.xp", "prod.bgascDiscount.count.xp", "bgasc_discounts");
		tic.resetDiscountTiers("bgasc_discounts", "prod.bgascDiscountAddDiscount.Btn.xp");
		Assert.assertTrue(Q_WebElm.listOfElements(ticketsProps, "prod.bgascDiscount.errorMsg.xp").size()==0, "Error message is not displayed!");
		Controls.closeTabsSwitchWinMain();
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
