package testcases.products;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.opencsv.exceptions.CsvException;

import pageObjects.*;
import utils.Controls;
import utils.Init;

public class Q_ProductsTestCases extends Init {
    static Q_AdminForm adm = new Q_AdminForm();
    static Q_CustomerForm cust = new Q_CustomerForm();
    static Q_ProductForm prod = new Q_ProductForm();
    static Q_HoldsForm hold = new Q_HoldsForm();
    static Q_OrderForm ord = new Q_OrderForm();
    static Q_Buyback bb = new Q_Buyback();
    static Q_CheckoutForm chk = new Q_CheckoutForm();
    static Q_NewFeatures nf = new Q_NewFeatures();
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
     // * Description: Verify user can search for product either by SKU or product ID.
     // * Jira Ticket: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority =1)
    public static void productSearch(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        adm.adminMenu("products");
        prod.ProductsSKUSearch("GRTENTHVARIED");
        prod.assertProdDescription("1/10 oz Gold Round (Varied)");
        li.closeTabsSwitchWinMain();
        prod.productsIdSearch("46");
        prod.assertProdDescription("1 oz American Gold Eagle Coin (Random Year, BU)");
        li.closeTabsSwitchWinMain();
    }
    /******************************************************************
     // * Description: Verify user can add new note in product form.
     // * Jira Ticket: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 2)
    public static void addProductNote(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("46");
        prod.addNote("Product automated test cases do not modify");

    }
    /****************?**************************************************
     // * Description: Verify when OOS is not checked and product status is out Stock, User can set in stock alert in PDP
     // * Jira Ticket: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 3)
    public static void verifyPDPinStockAlert(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("46");
        prod.uncheckOSS();
        prod.jmOutOfStock("In-Stock Alert");
        li.closeTabsSwitchWinMain();
    }
    /******************************************************************
     // * Description: Verify when OOS is not checked and product status is in Stock User can add product to cart in PDP
     // * Jira Ticket: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 4)
    public static void verifyPDPinStock(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("46");
        prod.uncheckOSS();
        prod.jmInStock();
        li.closeTabsSwitchWinMain();
    }

    /******************************************************************
     // * Description: Verify user can uncheck Limit check box in admin product page
     // * Jira Ticket: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 5)
    public static void uncheckLimit(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        adm.adminMenu("products");
        prod.productsIdSearch("2136492");
        prod.assertProdDescription("1 oz Proof American Gold Eagles (Random Year, Capsules Only)");
        prod.uncheckLimited();
        li.closeTabsSwitchWinMain();
    }

    /******************************************************************
     // * Description: Verify user set Limit in admin product page
     // * Jira Ticket: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 6)
    public static void setProductLimit(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        adm.adminMenu("products");
        prod.productsIdSearch("2136492");
        prod.assertProdDescription("1 oz Proof American Gold Eagles (Random Year, Capsules Only)");
        prod.checkLimited("133");
        li.closeTabsSwitchWinMain();
    }

    /******************************************************************
     // * Description: Verify PDP page shows related accessories section and if there is more than on accessory the Show More link is displayed
     // * Jira Ticket: JMB-4056
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 7)
    public static void pdpProductAccessories(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("790538");
        li.switchWin();
        prod.accessoriesCheck(2);
        li.switchWin();
        prod.verifyPdpAccess("/2016-8-gram-chinese-gold-panda/");
        li.closeTabsSwitchWinMain();
    }

    /******************************************************************
     // * Description: Verify user can add and remove accessories on a product in product admin page
     // * Jira Ticket: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8)
    public static void addProductAccessories(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        adm.adminMenu("products");
        prod.productsIdSearch("46");
        Controls.switchWin();
        prod.accessoriesAdd("22mm Air-Tite Coin Holder w/ Gasket");
        prod.accessoriesCheck(1);
        li.closeTabsSwitchWinMain();

    }
    /******************************************************************
     // * Description: Verify user can add and remove accessories on a product in product admin page
     // * Jira Ticket: NA
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 9)
    public static void removeProductAccessories(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        adm.adminMenu("products");
        prod.productsIdSearch("46");
        li.switchWin();
        prod.accessoriesRemove();
        prod.accessoriesCheck(0);
        li.closeTabsSwitchWinMain();

    }
    /******************************************************************
     // * Description: Verify user can add add buyback note to a product admin page
     // * Jira Ticket: JMB-5324
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 10)
    public static void addBuybackNote(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("46");
        li.switchWin();
        prod.addBuybacNote();
        li.closeTabsSwitchWinMain();
    }

    /******************************************************************
     // * Description: Verify calculation of adjusted premium for a specific product
     // * Jira Ticket: JMB-4327
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 11)
    public static void adjustedPremium(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("46");
        prod.premiumAdjusted();
        li.closeTabsSwitchWinMain();
    }
    /******************************************************************
     * Description: Verify Notes can be added in ProductStock and ProductSafeLimit links and visible in Product Forms
     * Author: Mobin
     * Status:Complete
     * Ticket: JMB-6184
     *******************************************************************/
    @Test(priority = 12)
    public void verifyNotesCanBeAddedInPrdPages() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        Q_ProductForm.verifyProductNoteInPrdSafeLimit();
        Q_ProductForm.verifyProductNoteInPrdStock();
    }

    /*********************************************************************
     * Description: Manage OOS Product visibility in PLP when checkbox is ticked
     * on/off in backend
     * Author: Asfi Khaliq
     * Status: Complete
     * Ticket : JMB-6214
     ********************************************************************/
    @Test(priority = 13)
    public void manageOOSProductVisibilityInPLP_checkboxOnInBackend() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        adm.adminMenu("products");
        prod.productsIdSearch("69");
        prod.assertProdDescription("1/2 oz American Gold Eagle Coin (Random Year, BU)");
        prod.checkOSS();
        driver.navigate().to(baseUrl + "gold/gold-coins/american-gold-eagles/uncirculated-age/");
        String status = Q_ProductForm
                .productStatusThroughList("Expected :1/2 oz American Gold Eagle Coin (Random Year, BU)");
        Assert.assertEquals(status, "The product is not displayed", "The product is displayed");
        System.out.println(status);
    }
    /*********************************************************************
     * Description: Manage OOS Product visibility in PLP when checkbox is not ticked
     * on/off in backend
     * Author: Asfi Khaliq
     * Status: Complete
     * Ticket : JMB-6214
     ********************************************************************/
    @Test(priority = 14)
    public void manageOOSProductVisibilityInPLP_checkboxOffInBackend() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("69");
        prod.assertProdDescription("1/2 oz American Gold Eagle Coin (Random Year, BU)");
        prod.uncheckOSS();
        driver.navigate().to(baseUrl + "gold/gold-coins/american-gold-eagles/uncirculated-age/");
        String status = Q_ProductForm
                .productStatusThroughList("1/2 oz American Gold Eagle Coin (Random Year, BU)");
        Assert.assertEquals(status, "Out Of Stock", status);
        System.out.println("The product is out of stock and displayed");
    }
    /*********************************************************************
     * Description: Verify that no product has Safe Inventory,
     * Hopeful Inventory, and Carry zero at once.
     * Author: Asfi.Khaliq
     * Status: Complete
     * Ticket : JMB-6717
     ********************************************************************/

    @Test(priority = 15)
    public void productStatusListChanges_invCountCheck() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        driver.navigate().to(adminUrl + "/products_status_list.php");
        Q_ProductForm.productStatusShowEntries("50");
        Assert.assertTrue(Q_ProductForm.verifySafeInv_hopefulInv_carryCount(),
                "One of the product has Safe Inventory, Hopeful Inventory, and Carry zero, which is not expected");
        System.out.println("No product has Safe Inventory, Hopeful Inventory, and Carry zero");
    }

    /*********************************************************************
     * Description: Verify that Carry column is auto-sorted in
     * descending order.
     * Author: Asfi.Khaliq
     * Status: Complete
     * Ticket : JMB-6717
     ********************************************************************/

    @Test(priority = 16)
    public void productStatusListChanges_carrySort() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        driver.navigate().to(adminUrl + "/products_status_list.php");
        Q_ProductForm.productStatusShowEntries("50");
        Assert.assertTrue(Q_ProductForm.verifyCarrySort(), "The Carry column is not sorted in descending order.");
        System.out.println("Carry column is auto-sorted in descending order.");
    }
    /******************************************************************
     * Description: Verify that there is an exchange config settings for both Regular Inventory
     * Author: Mobin
     * Status:Complete
     * Ticket: JMB-4220
     *******************************************************************/
    @Test(priority = 17)
    public void verifyProdExchangeRegInventory() throws InterruptedException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        int quantity = 2;
        int inHandBeforeEdit2541599 = Q_ProductForm.verifyInhandQtyRegularInventory("gold", "2541599");//2020 100 oz Gold Puma
        int inHandBeforeEdit2350453 = Q_ProductForm.verifyInhandQtyRegularInventory("gold", "2350453");//2019-W 1/4 oz Proof American Gold Eagle Coin NGC PF70 UCAM ER
        //Assuming that first product is for Decreasing and second product for Increasing
        prod.exchangeProdInventory("REGULAR","2020 100 oz Gold Puma", "2019-W 1/4 oz Proof American Gold Eagle Coin NGC PF70 UCAM ER", quantity);
        int inHandAfterEdit2541599 = prod.verifyInhandQtyRegularInventory("gold", "2541599");
        int inHandAfterEdit2350453 = prod.verifyInhandQtyRegularInventory("gold", "2350453");
        Assert.assertEquals(inHandBeforeEdit2541599-quantity, inHandAfterEdit2541599);
        Assert.assertEquals(inHandBeforeEdit2350453+quantity, inHandAfterEdit2350453);

    }

    /******************************************************************
     * Description: Verify that there is an exchange config settings for both Dallas Inventory
     * Author: Mobin
     * Status:Complete
     * Ticket: JMB-4220
     *******************************************************************/
    @Test(priority = 18)
    public void verifyProdExchangeDallasInventory() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        int quantity = 1;
        int inHandBeforeEdit2501212 = prod.verifyInhandQtyDallasInventory("2501212");//2020 1 Gram Chinese Gold Panda Coin (BU)
        int inHandBeforeEdit677547 = prod.verifyInhandQtyDallasInventory("677547");//2016 1/10 oz American Gold Eagle Coin (BU)
        //Assuming that first product is for Decreasing and second product for Increasing
        prod.exchangeProdInventory("DALLAS","2020 1 Gram Chinese Gold Panda Coin (BU)", "2016 1/10 oz American Gold Eagle Coin (BU)", quantity);
        int inHandAfterEdit2501212 = prod.verifyInhandQtyDallasInventory("2501212");
        int inHandAfterEdit677547 = prod.verifyInhandQtyDallasInventory("677547");
        Assert.assertEquals(inHandBeforeEdit2501212-quantity, inHandAfterEdit2501212);
        Assert.assertEquals(inHandBeforeEdit677547+quantity, inHandAfterEdit677547);

    }
    /******************************************************************
     * Description: Verify that the records can be deleted from swap
     * Author: Mobin
     * Status:Complete
     * Ticket: JMB-6738
     *******************************************************************/
    @Test(priority = 19)
    public void verifyProductsCanbeDeletedFromRepo() throws InterruptedException {
        String tcName  =  (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        nf.navProd("/repos.php");
        prod.searchPOinRepoAndEdit("09132021175928");
        prod.addProductsAndDeleteProducts(2);
    }
    
    //**************************************************************************
  	// * Description: Verify Dallas In Hand coloumn in inventory reports
  	// * Author: Tamil
  	// * Jira Ticket: JMB-6804
  	// * Status: Complete
  	// *******************************************************************/
  	@Test(priority = 20, enabled = true)
  	public static void dallasInHandReport() {
  		String tcName = (new Object() {
  		}.getClass().getEnclosingMethod().getName());
  		Controls.testStarted(tcName);
  		Controls.adminLogin();
  		Q_ProductForm.dallasInHandReport(adminUrl+"/inventory.php?type=gold");
  		Q_ProductForm.dallasInHandReport(adminUrl+"/inventory.php?type=silver");
  		Q_ProductForm.dallasInHandReport(adminUrl+"/inventory.php?type=copper");
  		Q_ProductForm.dallasInHandReport(adminUrl+"/inventory.php?type=platinum");
  		Q_ProductForm.dallasInHandReport(adminUrl+"/inventory.php?type=palladium");
  		Q_ProductForm.dallasInHandReport(adminUrl+"/inventory.php?type=accessory");
  		Q_ProductForm.dallasInHandReport(adminUrl+"/inventory.php?type=gold&inactive=1");
  		Q_ProductForm.dallasInHandReport(adminUrl+"/inventory.php?type=silver&inactive=1");
  		Q_ProductForm.dallasInHandReport(adminUrl+"/inventory.php?type=copper&inactive=1");
  		Q_ProductForm.dallasInHandReport(adminUrl+"/inventory.php?type=platinum&inactive=1");
  		Q_ProductForm.dallasInHandReport(adminUrl+"/inventory.php?type=palladium&inactive=1");
  		Q_ProductForm.dallasInHandReport(adminUrl+"/inventory.php?type=accessory&inactive=1");
  	}
  	
  	//**************************************************************************
  	// * Description: Verify Dallas In Hand coloumn in inventory reports by searching different metal type
  	// * Author: Tamil
  	// * Jira Ticket: JMB-6804
  	// * Status: Complete
  	// *******************************************************************/
  	@Test(priority = 21, enabled = true)
  	public static void searchDallasInHandReport() {
  		String tcName = (new Object() {
  		}.getClass().getEnclosingMethod().getName());
  		Controls.testStarted(tcName);
  		Controls.adminLogin();
  		Q_ProductForm.dallasInHandReportSearch("Gold");
  		Q_ProductForm.dallasInHandReportSearch("Silver");
  		Q_ProductForm.dallasInHandReportSearch("Platinum");
  		Q_ProductForm.dallasInHandReportSearch("Palladium");
  		Q_ProductForm.dallasInHandReportSearch("Copper");
  		Q_ProductForm.dallasInHandReportSearch("Accessories");
  	}

  	//******************************************************************
	// * Description:Verify Carry & Gold Carry total match with total of all values
	// * Author: Tamil
	// * Jira Ticket: JMB-4461
	// * Status: Complete
	// 
	//*******************************************************************/
	@Test(priority = 22, enabled = true)
	public static void verifyGoldCarryTotal() throws ParseException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		Q_ProductForm.verifyCarryTotal("https://qa.jmbullion.com/admin/safe-inventory-carry.php");
		Q_ProductForm.verifyCarryTotal("https://qa.jmbullion.com/admin/safe-inventory-carry.php?type=XAU");
	}
	
	/******************************************************************
	 * Description: Verify Un arrive functionality in JM Receipts
	 * Author: Mobin
	 * Status:Complete
	 * Ticket: JMB-6078
	 *******************************************************************/
	@Test(priority = 23, enabled = true)
	public void verifyUnArriveRecieptFunctionality() throws InterruptedException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		Q_NewFeatures goTo = new Q_NewFeatures();
		goTo.navProd("/products-form.php?id=16");
		Q_ProductForm.verifyUnArriveDecreaseIHQ("1 oz Silver Bar (Varied Condition, An", "16", 100);
	}
	
	//******************************************************************
    // * Description: Verify able that inventory for child 1 and child 2 item
    // * is updated when order is placed for parent
    // * Created By: Paul Patterson
    // * Jira Ticket: JMB-6861
    // * Status: Complete
    //********************************************************************/
    @Test (priority = 24, enabled = true)
    public static void verifyChild1AndChild2InventoryChangesAfterParentOrder() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        int startParentInventory = 706;
        int startChild1Inventory = 35;
        int startChild2Inventory = 1;
        int orderQuan = 220;
        Controls.testStarted(tcName);
        Controls.adminLogin();
        Q_ProductForm.reset2019AmericanSilverEagleProductsLimits(startParentInventory, startChild1Inventory, startChild2Inventory);
        // Create order for 2019 1 oz American Silver Eagle Coin (BU)
        Q_ProductForm.productCreateFrontendOrder("2098824", orderQuan);
        // Verify that the order properly adjusted the inventory of the parent/child products
        Q_ProductForm.verify2019AmericanSilverEagleProductsLimits("2098824", orderQuan, startParentInventory, startChild1Inventory, startChild2Inventory);
    }

    //******************************************************************
    // * Description: Verify able that inventory for parent and child 2 item
    // * is updated when order is placed for child 1
    // * Created By: Paul Patterson
    // * Jira Ticket: JMB-6861
    // * Status: Complete
    //********************************************************************/
    @Test (priority = 25, enabled = true)
    public static void verifyParentAndChild2InventoryChangesAfterChild1Order() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        int startParentInventory = 706;
        int startChild1Inventory = 35;
        int startChild2Inventory = 1;
        int orderQuan = 35;
        Controls.testStarted(tcName);
        Controls.adminLogin();
        Q_ProductForm.reset2019AmericanSilverEagleProductsLimits(startParentInventory, startChild1Inventory, startChild2Inventory);
        // Create order for 2019 American Silver Eagle Tube (20 Coins, BU)
        Q_ProductForm.productCreateFrontendOrder("2187069", orderQuan);
        // Verify that the order properly adjusted the inventory of the parent/child products
        Q_ProductForm.verify2019AmericanSilverEagleProductsLimits("2187069", orderQuan, startParentInventory, startChild1Inventory, startChild2Inventory);
    }

    //******************************************************************
    // * Description: Verify able that inventory for parent and child 1 item
    // * is updated when order is placed for child 2
    // * Created By: Paul Patterson
    // * Jira Ticket: JMB-6861
    // * Status: Complete
    //********************************************************************/
    @Test (priority = 26, enabled = true)
    public static void verifyParentAndChild1InventoryChangesAfterChild2Order() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        int startParentInventory = 706;
        int startChild1Inventory = 35;
        int startChild2Inventory = 1;
        int orderQuan = 1;
        Controls.testStarted(tcName);
        Controls.adminLogin();
        Q_ProductForm.reset2019AmericanSilverEagleProductsLimits(startParentInventory, startChild1Inventory, startChild2Inventory);
        // Create order for 2019 American Silver Eagle Monster Box (500 Coins, BU, Sealed)
        Q_ProductForm.productCreateFrontendOrder("2187081", orderQuan);
        // Verify that the order properly adjusted the inventory of the parent/child products
        Q_ProductForm.verify2019AmericanSilverEagleProductsLimits("2187081", orderQuan, startParentInventory, startChild1Inventory, startChild2Inventory);
    }
    
    /*********************************************************************
	 * Description: Verify Copper as only fixed pricing and other metals are normal
	 * Author: Tamil
	 * Jira Ticket: JMB-4511
	 * Status: Complete
	 *******************************************************************/

	@Test(priority = 27, enabled = true)
	public static void copperAsOnlyFixedPricing(){
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		bb.bbMenuItem("products");
		prod.productsMenu("copper");
		prod.formInputXp("prod.searchInput.xp", "171519");
        Q_WebElm.myWait(2000);
        prod.formXp("jm.prod.editProduct.xp");
        Controls.switchTab(1);	
        Q_ProductForm.verifyNormalBtnDisabledForCopper();
        Q_ProductForm.metalTypeSelection();
	}
    
	/**************************************************************************
	 * Description: Verify Adjust Inhand Improvement
	 * Author: Tamil
	 * Jira Ticket: JMB-6839
	 * Status: Complete
	 ********************************************************************/
	@Test(priority = 28, enabled = true)
	public static void adjustInhandImprovement() {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		
		//Adjust Dallas page link
		Q_ProductForm.adjustInhandIntegerValues(adminUrl+"/location-product-adjust.php?location_id=3", "1");
		Q_ProductForm.adjustInhandIntegerValues(adminUrl+"/location-product-adjust.php?location_id=3", "-1");
		Q_ProductForm.adjustInhandIntegerValues(adminUrl+"/location-product-adjust.php?location_id=3", "xx");
		Q_ProductForm.adjustInhandIntegerValues(adminUrl+"/location-product-adjust.php?location_id=3", "+");
		
		//Adjust Inhand page link		
		Q_ProductForm.adjustInhandIntegerValues(adminUrl+"/products-adjust-inhand.php", "10");
		Q_ProductForm.adjustInhandIntegerValues(adminUrl+"/products-adjust-inhand.php", "-10");
		Q_ProductForm.adjustInhandIntegerValues(adminUrl+"/products-adjust-inhand.php", "bb");
		Q_ProductForm.adjustInhandIntegerValues(adminUrl+"/products-adjust-inhand.php", "yy");
		
		//Adjust Repo page link
		Q_ProductForm.adjustInhandIntegerValues(adminUrl+"/products-adjust-repo.php", "10");
		Q_ProductForm.adjustInhandIntegerValues(adminUrl+"/products-adjust-repo.php", "-10");
		Q_ProductForm.adjustInhandIntegerValues(adminUrl+"/products-adjust-repo.php", "+");
		Q_ProductForm.adjustInhandIntegerValues(adminUrl+"/products-adjust-repo.php", "zz");
		
	}
	
	//**************************************************************************
	// * Description: Verify Exchange-products Inventory improvments
	// * Author: Tamil
	// * Jira Ticket: JMB-6804
	// * Status: Complete
	// *******************************************************************/
	@Test(priority = 29, enabled = true)
	public static void productInhandExchangeImprovement() {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		//Exchange-products Regular Inventory page link
		Q_ProductForm.productInhandExchangeInventory(adminUrl+"/exchange-products.php", "-1", "1");
		Q_ProductForm.productInhandExchangeInventory(adminUrl+"/exchange-products.php", "*", "+");
		Q_ProductForm.productInhandExchangeInventory(adminUrl+"/exchange-products.php", "XX", "YY");
		
		//Exchange-products Dallas Inventory page link
		Q_ProductForm.productInhandExchangeInventory(adminUrl+"/exchange-products.php?loc=dallas", "-1", "1");
		Q_ProductForm.productInhandExchangeInventory(adminUrl+"/exchange-products.php?loc=dallas", "*", "+");
		Q_ProductForm.productInhandExchangeInventory(adminUrl+"/exchange-products.php?loc=dallas", "yy", "zz");
		
	}
	
	/******************************************************************
	 * Description: Eliminated "Ship Weight" & Resync all Products with Amark
	 * Author: Mobin 
	 * Status: Completed 
	 * Ticket: JMB-6852
	 *******************************************************************/
	@Test(priority = 30, enabled = true)
	public void eliminateShipWeightAndSyncWithAmark() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_NewFeatures goTo = new Q_NewFeatures();
		Controls.testStarted(tcName);
		Controls.adminLogin();
		goTo.navProd("/shiphawk-weight.php");
		Q_ProductForm.verifyProductHawkDetailsBeforeAfterAMARKUpdate();

	}
	
	/*********************************************************************
	 * Description: Verify that High priority products get updated with Follow Up Date and 
	 * get sorted on clicking the tab header. Also, the row with past date gets highlighted. 
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-6721
	 * @throws ParseException 
	 ********************************************************************/
	@Test(priority = 31, enabled = true)
	public void updateFollowUpDateColumn_highPriority() throws ParseException {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		driver.navigate().to(adminUrl + "/lowInventory.php");
		Q_ProductForm.selectPriority("High Priority");
		Q_ProductForm.update_followUpDateColumn_highPriority("2098801", "2022-2-15");
		Q_ProductForm.sortFollowUpDateColumn_highPriority("descending");
		Q_ProductForm.verifyHighlight_pastDate_highPriority();
	}
	
	/*********************************************************************
	* Description: Verify that Low priority products get updated with Follow Up Date and 
	* get sorted on clicking the tab header. Also, the row with past date gets highlighted. 
	* Author: Asfi.Khaliq 
	* Status: Complete 
	* Ticket : JMB-6721
	* @throws ParseException 
	********************************************************************/
	@Test(priority = 32, enabled = true)
	public void updateFollowUpDateColumn_lowPriority() throws ParseException {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		driver.navigate().to(adminUrl + "/lowInventory.php");
		Q_ProductForm.selectPriority("Low Priority");
		Q_ProductForm.update_followUpDateColumn_lowPriority("389302", "2022-2-15");
		Q_ProductForm.selectPriority("Low Priority");
		Q_ProductForm.sortFollowUpDateColumn_lowPriority("descending");
		Q_ProductForm.verifyHighlight_pastDate_lowPriority();
	}
	
	/********************************************************************
	 * Description: Verify Product Stock Changes 
	 * Author: Tamil
	 * Jira Ticket: JMB-6718 
	 * Status: Complete 
	 *******************************************************************/
	@Test(priority = 33, enabled = true)
	public static void ProductStockChanges() {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		Controls.adminLogin();
		driver.get("https://qa.jmbullion.com/admin/productStock.php");
		prod.verifyDisplayJMPMSilverProductPage();
		String ordnumber=prod.verifyOOSProductStock();
		prod.removeOOSIgnoredProductStock(ordnumber);
		prod.verifyISProductStock(ordnumber);
	}
	
	/*********************************************************************
	 * Description: Add ability to download to CSV to this admin report - or create 
	 * quicksight report
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-6942
	 * @throws CsvException 
	 * @throws IOException 
	 ********************************************************************/

	@Test(priority = 34)
	public void abilityToCreateAndDownloadQuicksightReportToCSV() throws IOException, CsvException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		String systemDownloadFolderPath = Paths.get(System.getProperty("user.home"), "Downloads").toString();
		String csvName = "PRODUCT_LOOKUP_REPORT_";
		li.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/reports-product-lookup.php");
		prod.productSelection("1 oz American Gold Eagle Coin (Random Year, BU)");
		prod.dateSelection("2022-01-08");
		prod.searchData_ASEReport();
		prod.existingFileDelete(systemDownloadFolderPath, csvName);
		prod.downloadProductReportCSV();
		prod.verifyProductReportCSVContentMatchesAdmin(systemDownloadFolderPath, csvName);
		prod.existingFileDelete(systemDownloadFolderPath, csvName);
	}
	
	/********************************************************************
	 * Description: Verify Fix Hedge Page Palladium 
	 * Author: Tamil
	 * Jira Ticket: JMB-7042 
	 * Status: Complete 
	 * @throws FileNotFoundException 
	 *******************************************************************/
	@Test(priority = 35, enabled = true)
	public static void fixHedgePage() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		ord.frontendLogin(6);
		ord.regularOrderToCheckout("platinumEagle1oz", 10, "84092-4033");
		ord.completeOrder();
		ord.logoutUser();
		Controls.adminLogin();
		driver.get("https://qa.jmbullion.com/admin/reports-hedging.php?display=full");
		prod.verifyHedgePalladiumInvetoryWithOffset();
	}
	
	/*********************************************************************
	 * Description: Validate the error thrown when one of the products in 
	 * Sell to Us cart have been unchecked (BB) in admin while checkout 
	 * process
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-7041
	 ********************************************************************/

	@Test(priority = 36)
	public void validateBBCheckoutWhenUncheckedProductIsUsed() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		driver.navigate().to(baseUrl);
		chk.selToUs();
		chk.addDiyBbItem("stu.bbMetal.gold.xp", "2019 1/2 oz American Gold Eagle Coin (BU)", "2");
		chk.selToUs();
		chk.addDiyBbItem("stu.bbMetal.gold.xp", "2019 1 oz American Gold Eagle Coin (BU)", "1");
		Controls.newTab();
		driver.navigate().to(adminUrl);
		adm.adminMenu("products");
		prod.productsIdSearch("2098801");
		prod.removeAsBuyBack();
		Controls.switchTab(0);	
		chk.sellToUs_checkoutNow();
		Assert.assertTrue(Q_WebElm.xpRetText(adminProps,"stu.removeProductBB.errorMSg.xp").contains(
				"is not available to Sell To Us, please remove it from your cart."),"Error Not displayed");
		chk.removeCartPageContent();
		Controls.switchTab(2);	
		prod.setAsBuyBack("17.00");
	}
	
	/********************************************************************
	 * Description: Force each product to have a min and a max in order to be set into stock 
	 * Param: NA 
	 * Jira Ticket: JMB-7045 
	 * Status: Complete 
	 *******************************************************************/
	@Test(priority = 37, enabled = true)
	public static void forceEachProductToHaveMinAndMaxInOrderInstock() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		Controls.adminLogin();
		adm.adminMenu("products");
		prod.productsIdSearch("2494000");
		Controls.switchTab(1);
		int a[] = prod.twoRandomNumGenWithInRange();
		prod.verifyProductMinAndMaxInventory(0,0);
		prod.verifyProductMinAndMaxInventory(1,0);
		prod.verifyProductMinAndMaxInventory(a[0],a[1]);
	}
	
	/*********************************************************************
	 * Description: Verify the new due date column in CSV report for High priority tab
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-6896
	 * @throws CsvException 
	 * @throws ParseException 
	 ********************************************************************/
	@Test(priority = 38)
	public void verifyNewDueDateField_lowInventoryCSV_highPriority() throws CsvException, ParseException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		String systemDownloadFolderPath = Paths.get(System.getProperty("user.home"), "Downloads").toString();
		String csvName = "Low_Inventory_";
		li.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/lowInventory.php");
		System.out.println(systemDownloadFolderPath+ "/");
		prod.existingFileDelete(systemDownloadFolderPath, csvName);
		prod.selectPriority("High Priority");
		prod.downloadLowInventoryCSV();
		prod.sortFollowUpDateColumn_highPriority("ascending");
		prod.verifyLowInventoryReportCSV("high", systemDownloadFolderPath, csvName);
		prod.existingFileDelete(systemDownloadFolderPath, csvName);
		prod.update_followUpDateColumn_highPriority("2098802", "2022-4-15");
		li.xpExecutorScrollToView(adminProps, "lowInventory.multiplier.saveChangesBtn.xp");
		prod.downloadLowInventoryCSV();
		prod.verifyLowInventoryReportCSV("high", systemDownloadFolderPath, csvName);
		prod.existingFileDelete(systemDownloadFolderPath, csvName);
	}

	/*********************************************************************
	 * Description: Verify the new due date column in CSV report for Low priority tab
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-6896
	 * @throws CsvException 
	 * @throws ParseException 
	 ********************************************************************/
	@Test(priority = 39)
	public void verifyNewDueDateField_lowInventoryCSV_lowPriority() throws CsvException, ParseException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		String systemDownloadFolderPath = Paths.get(System.getProperty("user.home"), "Downloads").toString();
		String csvName = "Low_Inventory_";
		li.testStarted(tcName);
		li.adminLogin();
		driver.navigate().to(adminUrl + "/lowInventory.php");
		System.out.println(systemDownloadFolderPath+ "/");
		prod.existingFileDelete(systemDownloadFolderPath, csvName);
		prod.selectPriority("Low Priority");
		prod.downloadLowInventoryCSV();
		prod.sortFollowUpDateColumn_lowPriority("ascending");
		prod.verifyLowInventoryReportCSV("low", systemDownloadFolderPath, csvName);
		prod.existingFileDelete(systemDownloadFolderPath, csvName);
		prod.update_followUpDateColumn_lowPriority("389296", "2022-4-15");
		li.xpExecutorScrollToView(adminProps, "lowInventory.multiplier.saveChangesBtn.xp");
		prod.downloadLowInventoryCSV();
		prod.verifyLowInventoryReportCSV("low", systemDownloadFolderPath, csvName);
		prod.existingFileDelete(systemDownloadFolderPath, csvName);
	}
	
	/********************************************************************
	 * Description: Verify product error log working correctly 
	 * Param: NA 
	 * Author: Tamilselvan
	 * Jira Ticket: JMB-6460 
	 * Status: Complete 
	 *******************************************************************/
	@Test(priority = 40, enabled = true)
	public void verifyAdminProductErrorLog() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		Controls.adminLogin();
		adm.adminMenu("products");
		prod.productsIdSearch("2494000");
		Controls.switchTab(1);
		int a[] = prod.twoRandomNumGenWithInRange();
		prod.verifyProductMinAndMaxInventory(a[0],a[1]);
		prod.verifyAdminProductErrorLogByCron("2494000");
	}
	
	/*********************************************************************
	 * Description: Verify “Supplier Premium”, “Silver Premium”, “PM 
	 * Premium”, and “JM Premium” fields are displayed on Add Product page
	 * and matches the values on 'Edit Product' page.
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-6938
	 ********************************************************************/
	@Test(priority = 41)
	public void verifySupplierPrem_onAddProductPageAndEditProductPage() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Instant instant = Instant.now();
		String productName = "Automated QA Test Gold Coin" + instant;
		String sku = "GH7089I" + productName.substring(50);
		final String supplierPrem = "0.99", silverPrem = "1.99", jmPrem = "2.99", pmPrem = "3.99";
		li.testStarted(tcName);
		li.adminLogin();
		Q_WebElm.myWait(4000);
		driver.navigate().to(adminUrl + "/add-product.php");
		prod.verifyJmPrem_supplierPrem_silver_Prem_pmPrem_areDisplayed_addProdPage();
		prod.createProduct(productName, sku, "Gold", "15", "15", supplierPrem, silverPrem, jmPrem, pmPrem);
		driver.navigate().to(adminUrl);
		adm.adminMenu("products");
		prod.ProductsSKUSearch(sku);
		li.switchWin();
		Q_WebElm.myWait(1000);
		prod.verifyProductPremiums(supplierPrem, silverPrem, jmPrem, pmPrem);
	}
	
	/*********************************************************************
	 * Description: Verify that page does not refresh after save/Update 
	 * button is clicked on Low Inventory of high priority products.
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-6968
	 ********************************************************************/
	@Test(priority = 42)
	public void verifyUpdateBtn_withoutEntirePageRefresh_lowInventory_highPriority() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		li.adminLogin();
		Q_WebElm.myWait(4000);
		driver.navigate().to(adminUrl + "/lowInventory.php");
		prod.update_followUpDateColumn_highPriority("2098802", "2022-4-15");
	}
	
	/*********************************************************************
	 * Description: Verify that page does not refresh after save/Update 
	 * button is clicked on Low Inventory of low priority products.
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-6968
	 ********************************************************************/
	@Test(priority = 43)
	public void verifyUpdateBtn_withoutEntirePageRefresh_lowInventory_lowPriority() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		li.adminLogin();
		Q_WebElm.myWait(4000);
		driver.navigate().to(adminUrl + "/lowInventory.php");
		prod.selectPriority("Low Priority");
		prod.update_followUpDateColumn_lowPriority("389302", "2022-2-15");
	}
	
	/*********************************************************************
	 * Description: Verify that page does not refresh after Update 
	 * button for note is clicked on Product Status List page.
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-6968
	 ********************************************************************/
	@Test(priority = 44)
	public void verifyUpdateNoteBtn_withoutEntirePageRefresh_productStatus() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		li.adminLogin();
		Q_WebElm.myWait(4000);
		driver.navigate().to(adminUrl + "/products_status_list.php");
		prod.updateNotes_productStatusList("JMB", "1361733", "Testing");
	}
	
	/*********************************************************************
	 * Description: Verify that page does not refresh after Clear 
	 * button is clicked on Product Status List page.
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-6968
	 ********************************************************************/
	@Test(priority = 45)
	public void verifyClearBtn_withoutEntirePageRefresh_productStatus() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		li.adminLogin();
		Q_WebElm.myWait(4000);
		driver.navigate().to(adminUrl + "/products_status_list.php");
		prod.clearProduct_productStatusList("JMB", "148524");
	}
	
	/*********************************************************************
	 * Description: Verify product Premium Blender is working. There is 
	 * difference between Prior prem & Blender Prem for the product 
	 * involved in DIY Buyback.
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-7075
	 ********************************************************************/
	@Test(priority = 46)
	public void verifyProductPremiumBlender_DIYBuyback() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		li.testStarted(tcName);
		li.adminLogin();
		Q_WebElm.myWait(2000);
		driver.navigate().to(baseUrl);
		chk.selToUs();
		chk.addDiyBbItem("stu.bbMetal.gold.xp", "1/2 oz American Gold Eagle Coin (Random Year, BU)", "12");
		chk.sellToUs_checkoutNow();
		Q_WebElm.myWait(5000);
		Assert.assertTrue(Q_WebElm.xpDisplayed(adminProps, "jm.ThankYouPage.xp"), "DIY BB txn not successful");
		driver.navigate().to(adminUrl);
		adm.adminMenu("products");
		prod.ProductsSKUSearch("GCAGEF50VAR");
		li.switchWin();
		Q_WebElm.myWait(1000);
		prod.productSupplierLog();
	}
	
	/*********************************************************************
	 * Description: Verify all column headers on Inventory Age Report, and 
	 * all Spot column values have not more than 2 decimal places. 
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-7183
	 ********************************************************************/
	@Test(priority = 47)
	public void verifyAllColumnHeaders_andSpotPriceValues() {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		driver.navigate().to(baseUrl + "/ato/age.php?display");
		prod.verifyColumnNames_invAgeReport();
		prod.verifyAllSpotPrices_invAgeReport();
	}
	
	/********************************************************************
	 * Description: Create New Product and verify Default status to Out of Stock
	 * Param: NA
	 * Jira Ticket: JMB-6842
	 * Status: Complete
	 *******************************************************************/
	@Test(priority = 48, enabled = true)
	public void verifyNewProductDefaultToOutOfStock(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Instant instant = Instant.now();
		String productNameGold = "Automated QA Test Gold Coin" + instant;
		String skuGold = "GH7089I" + productNameGold;
		String productNameSilver = "Automated QA Test Silver Coin" + instant;
		String skuSilver = "GH7089I" + productNameSilver;
		String productNameCopper = "Automated QA Test Copper Coin" + instant;
		String skuCopper = "GH7089I" + productNameCopper;
		String productNamePlatinum = "Automated QA Test Platinum Coin" + instant;
		String skuPlatinum = "GH7089I" + productNamePlatinum;
		final String supplierPrem = "0.99", silverPrem = "1.99", jmPrem = "2.99", pmPrem = "3.99";
		li.testStarted(tcName);
		li.adminLogin();
		Q_WebElm.myWait(4000);
		driver.navigate().to(adminUrl + "/add-product.php");
		prod.createProduct(productNameGold, skuGold, "Gold", "15", "15", supplierPrem, silverPrem, jmPrem, pmPrem);
		prod.createProduct(productNameSilver, skuSilver, "Silver", "15", "15", supplierPrem, silverPrem, jmPrem, pmPrem);
		prod.createProduct(productNameCopper, skuCopper, "Copper", "15", "15", supplierPrem, silverPrem, jmPrem, pmPrem);
		prod.createProduct(productNamePlatinum, skuPlatinum, "Platinum", "15", "15", supplierPrem, silverPrem, jmPrem, pmPrem);

		driver.navigate().to(adminUrl);
		adm.adminMenu("products");
		prod.ProductsSKUSearch(skuGold);
		li.switchWin();
		Q_WebElm.myWait(1000);
		prod.verifyOosDefaultNewProduct();
		adm.adminMenu("products");
		prod.ProductsSKUSearch(skuSilver);
		li.switchWin();
		Q_WebElm.myWait(1000);
		prod.verifyOosDefaultNewProduct();
		adm.adminMenu("products");
		prod.ProductsSKUSearch(skuCopper);
		li.switchWin();
		Q_WebElm.myWait(1000);
		prod.verifyOosDefaultNewProduct();
		adm.adminMenu("products");
		prod.ProductsSKUSearch(skuPlatinum);
		li.switchWin();
		Q_WebElm.myWait(1000);
		prod.verifyOosDefaultNewProduct();
	}
	
	/*********************************************************************
	 * Description: Verify Product Status Page Additions
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-7214
	 ********************************************************************/

	@Test(priority = 49)
	public void verifyProductStatusPageAdditions()	{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		String systemDownloadFolderPath = Paths.get(System.getProperty("user.home"), "Downloads").toString();
		String csvName = "PRODUCT_LIST";
		Controls.testStarted(tcName);
		Controls.adminLogin();
		driver.navigate().to(adminUrl + "/products_status_list.php");
		driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);
		prod.existingFileDelete(systemDownloadFolderPath, csvName);
		prod.selectNeedsContent_productStatusList("JMB", "1361733");
		prod.downloadProductStatusListCSV();
		prod.verifyProductStatusList_csvReport("", systemDownloadFolderPath, tcName);
		prod.selectNeedsContent_productStatusList("JMB", "1361733");
		prod.existingFileDelete(systemDownloadFolderPath, csvName);
	}
	
	/********************************************************************
	/ * Description: verify No Accessory field is disabled & enabled properly for S com related products
	/ * Param: NA
	/ * Jira Ticket: JMB-6619
	/ * Status: Complete
	/ * *******************************************************************/
	@Test(priority = 50)
	public void addCheckBoxToAccessoriesForSLVRelatedProd() throws FileNotFoundException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("46");
		Controls.switchTab(1);
		prod.verifyDisplayProdAdminSilNoAccessory();
		prod.addAccessorySil("1 oz Atlantis Mint Flame Poured Silver Bars (New)");
		prod.verifyNoAccessoryDisabledForSil();
		prod.clickSilRemoveProd();
        driver.navigate().refresh();
        Q_WebElm.myWait(3000);
        prod.verifyNoAccessoryEnabledForSil();
        prod.clickSilNoAccessory();
        prod.clickSilRelatedProdAdmin();
        Controls.checkAlert();
	}
	
	/********************************************************************
	/ * Description: verify No Accessory field is disabled & enabled properly for JM related accessories 
	/ * Param: NA
	/ * Jira Ticket: JMB-6619
	/ * Status: Complete
	/ * *******************************************************************/
	@Test(priority = 51)
	public void addCheckBoxToAccessoriesForJmRelatedAcces() throws FileNotFoundException{
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.adminLogin();
        adm.adminMenu("products");
        prod.productsIdSearch("1066522");
		Controls.switchTab(1);
		prod.verifyDisplayProdAdminJmNoAccessory();
        prod.accessoriesAdd("22mm Air-Tite Coin Holder Direct Fit");
        prod.accessoriesCheck(1);
        prod.verifyNoAccessoryDisabledForJm();
        prod.accessoriesRemove();
        prod.accessoriesCheck(0);
        driver.navigate().refresh();
        Q_WebElm.myWait(3000);
        prod.verifyNoAccessoryEnabledForJm();
        prod.clickJmNoAccessory();
        prod.clickJmRelatedProdAdmin();
        Controls.checkAlert();
	}
	
	/********************************************************************
	 // * Description  : Verify the Low Inventory Quote-Builder in admin claim form page
	 // * Author       : Sivaraj
	 // * Status       : Completed
	 // * Jira Ticket  : JMB-7142 
	 //*******************************************************************/
	
	@Test(priority = 52, enabled = true)
	public void verifyPriorityQuote_JMB7142() {
		String highPriorityFileName, lowPriorityFileName, downloadPath, expectedDate=prod.getFutureDateFromCurrentDate(7);
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		highPriorityFileName = "lowInventoryReport_high";
		lowPriorityFileName = "lowInventoryReport_low";
		downloadPath = Paths.get(System.getProperty("user.home"), "Downloads").toString();
		Controls.adminLogin();
		adm.adminMenu("inventory");
		prod.inventoryMenu("low inventory");
		prod.downloadSupplierFiles("High Priority");
		prod.validateInventoryCSVReport("High Priority", downloadPath, highPriorityFileName);
		prod.downloadSupplierFiles("Low Priority");
		prod.validateInventoryCSVReport("Low Priority", downloadPath, lowPriorityFileName);
		driver.navigate().refresh();
		prod.verifyFollowUpDateinLowInventory(expectedDate,"adm.adminInventory.highPriority.inputDate.xp","adm.adminInventory.lowPriority.inputDate.xp");
	}
	
	/*****************************************************************************************
 	// * Description: Verify autobuy failed due to missing inventory
 	// * Param: NA
 	// * Jira Ticket: JMB-8106
 	// * Status:Completed
 	//****************************************************************************************/	
	@Test(priority = 53, enabled = true)	
	public void verifyAutobuyFailedDueToMissingInventorys(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();	
		li.navigateTo("https://qa.jmbullion.com/admin/reports-autobuy-failed-transactions-missing-inventory.php");
		prod.navigateToCustomerDetailsPageByClickOnEmail();		
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
