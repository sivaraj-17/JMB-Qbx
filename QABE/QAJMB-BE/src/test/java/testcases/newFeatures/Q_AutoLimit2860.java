package testcases.newFeatures;


import org.testng.annotations.*;
import pageObjects.*;
import utils.Controls;
import utils.Init;

import java.io.FileNotFoundException;

public class Q_AutoLimit2860 extends Init {
	static Q_AdminForm adm = new Q_AdminForm();
	static Q_CustomerForm cust = new Q_CustomerForm();
	static Q_ProductForm prod = new Q_ProductForm();
	static Q_HoldsForm hold = new Q_HoldsForm();
	static Q_OrderForm ord = new Q_OrderForm();
	static Q_Buyback bb = new Q_Buyback();
	static Q_CheckoutForm chk = new Q_CheckoutForm();
	static Q_NewFeatures nfal = new Q_NewFeatures();
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
	 // * Description: Verify user can set product limit as stated in https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 1, enabled = false)
	public static void setLimit(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
//		nfal.nfAutoLimitLimitedSelect("0");
//		nfal.nfAutoLimitLimitedSelect("1");
		nfal.nfAutoLimitLimitedSelect("2");

	}
	
	/******************************************************************
	 // * Description: Verify damaged products with negative input increase safe inventory
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 2, enabled = true)
	public static void damagedProductIncrease(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.autoLimitDamagedProduct(-100);
	}
	
	/******************************************************************
	 // * Description: Verify damaged products with positive input decreases safe inventory
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 3, enabled = true)
	public static void damagedProductDecrease(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.autoLimitDamagedProduct(100);
	}

	/******************************************************************
	 // * Description: Verify adjust In Hand page  /admin/products-adjust-inhand.php increases safe inventory
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 4, enabled = true)
	public static void inHandAdjustDecrease(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.autoLimitInHandAdjust(-10);
	}

	/******************************************************************
	 // * Description: Verify adjust In Hand page  /admin/products-adjust-inhand.php increases safe inventory
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 5, enabled = true)
	public static void inHandAdjustIncrease(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.autoLimitInHandAdjust(10);
	}

	/******************************************************************
	 // * Description: Verify adjust Repo page negative value /admin/products-adjust-repo.php decreases safe inventory
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 6, enabled = true)
	public static void repoAdjustDecrease(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.autoLimitAdjustRepo(-10);
	}
	
	/******************************************************************
	 // * Description: Verify adjust Repo page positive value /admin/products-adjust-repo.php increases safe inventory
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 7, enabled = true)
	public static void repoAdjustIncrease(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.autoLimitAdjustRepo(10);
	}
	
	/******************************************************************
	 // * Description: Verify placing an order will reduce the product limit by the quantity on the order.
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 8, enabled = true)
	public static void orderProductToReduceLimit() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.orderReducingLimit(100);
	}
	
	/******************************************************************
	 // * Description: Verify cancelling an order will increase the product limit by the quantity on the order.
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 9, enabled = true)
	public static void orderCancellationIncreasesLimit() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.autoLimitCancelOrder();
	}

	/******************************************************************
	 // * Description: Verify un-cancelling an order will decrease the product limit by the quantity on the order.
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 10, enabled = true)
	public static void orderRestoreIncreasesLimit() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.autoLimitRestoreOrder(100);
	}
	
	/******************************************************************
	 // * Description: Verify edit order and reduce in line item quantity for a product will increase the product safe limit by the same amount.
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 11, enabled = true)
	public static void reduceOrderLineItemQtyProductSafeLimitIncrease() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		Q_CheckoutForm chk = new Q_CheckoutForm();
		chk.selectItem("auto limit", 10);
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.autoLimitLineItem(-5, "ord.item.editQuantityDecrease.xp");
	}
	
	/******************************************************************
	 // * Description: Verify edit order and increase in line item quantity for a product will decrease the product safe limit by the same amount.
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 // * Status: Complete
	 //*******************************************************************/
	@Test(priority = 12, enabled = true)
	public static void increasingOrderLineItemQtyProductSafeLimitDecrease() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.autoLimitLineItem(5, "ord.item.editQuantityIncrease.xp");
	}
	
	/******************************************************************
	 // * Description: Verify creating reship on an order will reduce the limit of the product associated with the reship.
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Status: Complete
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 //*******************************************************************/
	@Test(priority = 13, enabled = true)
	public static void orderReshipReduceLimit() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.orderReship(15);
	}
	
	/******************************************************************
	 // * Description: Verify when we receive buyback product individually safe limit is increased by the quantity of the product on buyback.
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Status: Complete
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 //*******************************************************************/
	@Test(priority = 14, enabled = true)
	public static void receiveIndividualBbProduct(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.multipleProductBb();
	}
	
	/******************************************************************
	 // * Description: Verify when we receive entire buyback order the safe limit is increased by the quantity of the product on buyback.
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Status: Complete
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 //*******************************************************************/
	@Test(priority = 15, enabled = true)
	public static void receiveEntireBbOrder(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.singleProductBb();
	}
	
	/******************************************************************
	 // * Description: Verify when repo hits value date limit will be reduced by the quantity for the product associated with the repo.
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Status: Complete
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 //*******************************************************************/
	@Test(priority = 16, enabled = true)
	public static void repoValueDateIncreaseLimit(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.repoValueDate("1 oz Silver Bar (Varied Condition, An", 100);
	}
	
	/******************************************************************
	 // * Description: Verify when receipt is marked arrived limit will be increased by the quantity for the product associated with the receipt.
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Status: Complete
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 //*******************************************************************/
	@Test(priority = 17, enabled = true)
	public static void arrivedReceiptsIncreaseLimit(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.arriveReceipts();
	}

	/******************************************************************
	 // * Description: Verify when receipt is marked arrived limit will be increased by the quantity for the product associated with the receipt.
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Status: Complete
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 //*******************************************************************/
	@Test(priority = 18, enabled = true)
	public static void arrivedItemReceiptsIncreaseLimit(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");

		nfal.arriveItemReceipts();
		nfal.verifyProductLimitAndSafeInventory();
	}
	
	/******************************************************************
	 // * Description: Verify when we un-receive buyback product individually safe limit will be decreased by the quantity of the product on buyback.
	 // * Param: String
	 // * Jira Ticket: JMB-2860
	 // * Status: Complete
	 // * Requirements: https://jmbdev.atlassian.net/wiki/spaces/TD/pages/1750597633/Automatic+Limits
	 //*******************************************************************/
	@Test(priority = 19, enabled = true)
	public static void unReceiveIndividualBbProduct(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/products-form.php?id=16");
		nfal.unReceiveBbProduct();
	}
	
	@AfterTest
	public void endReport(){

	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Controls.tearDown();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	@AfterClass
	public void exitClass(){

	}
}