package testcases.order;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
//import steps.AdminSteps;
import utils.Controls;
import utils.Init;

import java.io.FileNotFoundException;

public class Q_OrderShipping extends Init {
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
    // * Description: Verify user can edit the order shipping details and edit shipping address.
    // * Author:
    // * Jira Ticket:
    // * Status: Complete
    // ********************************************************************/
    @Test(priority = 1, enabled = true)
    public static void editShippingDetails() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);

        li.adminLogin();
        adm.adminCustomerSearch("email", "qa+2jmb@jmbullion.com");
        adm.adminViewAllOrders();
        String customerOrderBexp = Q_OrderForm.isThereCustomerInvoice();
        cust.editOrder(customerOrderBexp, 1);
        ord.shippingDetails();
        ord.validateShippingAdd();
    }
      /******************************************************************
      // * Description: Verify user can alternate between addresses on customer profile in the order form.
      // * Author:
      // * Jira Ticket:
      // * Status: Complete
      // ********************************************************************/
      @Test(priority = 2, enabled = true)
      public static void switchShippingAddress() throws FileNotFoundException {
          String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
          Controls.testStarted(tcName);
          li.adminLogin();
          adm.adminCustomerSearch("email", "qa4auto@jmbullion.com");
          adm.adminViewAllOrders();
          String customerOrderBexp = Q_OrderForm.isThereCustomerInvoice();
          cust.editOrder(customerOrderBexp, 5);
          ord.switchShipping();
      }
    /******************************************************************
     // * Description: Verify user can create new shipping address in the order form by clicking shipping details link.
     // * Author:
     // * Jira Ticket:
     // * Status: Complete
     // ********************************************************************/

    @Test(priority = 3, enabled = true)
    public static void addShippingAddress() throws FileNotFoundException {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
        adm.adminCustomerSearch("email", "qa4auto@jmbullion.com");
        adm.adminViewAllOrders();
        String customerOrderBexp = Q_OrderForm.isThereCustomerInvoice();
        cust.editOrder(customerOrderBexp, 5);
        ord.newShipping();
    }
    /******************************************************************
     // * Description: Verify able to change shipping method on admin site
     // * and is updated on order in paid status with base shipping through other options
     // * Created By: Paul Patterson
     // * Jira Ticket: JMB-6720
     // * Status: Complete
     //********************************************************************/
    @Test (priority = 4, enabled = true)
    public static void verifyPaidOrderAbleToChangeShippingOption() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        li.adminLogin();
//        chk.selectItem("silverEagle1994", 2);
        driver.navigate().to(adminUrl);
        ord.ordersMenu("list");
        ord.editTopOrder();
        ord.changeOrderStatus("paid");
        ord.changeShippingMethod("USPS Priority");
        ord.changeShippingMethod("Expedited Shipping - Our Choice UPS or FedEx");
        ord.changeShippingMethod("UPS 2-Day Air");
        ord.changeShippingMethod("UPS Legacy");
        ord.changeShippingMethod("USPS Legacy");
        ord.changeShippingMethod("USPS Registered");
        ord.changeShippingMethod("IRA");
        ord.changeShippingMethod("TDS");
        ord.changeShippingMethod("Internal Transfer");
        /* Note ticket verifies API through a published PHP which is excluded
         * as it is OOS for automation*/
    }
    
    /*********************************************************************
	 * Description: Verify that no product has Safe Inventory, Hopeful Inventory,
	 * and Carry zero at once. 
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket : JMB-6369
	 ********************************************************************/

	@Test(priority = 5)
	public void addStorageOptionBackToCheckout() {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Q_OrderForm.frontendLogin(0);
		driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar/");
		chk.addItemToCart(6);
		chk.selectPaymentType("wire");
		chk.selectcheckoutBtn("top");
		Q_CheckoutForm.selectShippingUpgrade("Secure Storage - TDS");
		chk.completeOrder();
		Q_OrderForm.logoutUser();
		Controls.adminLogin();
		adm.adminCustomerSearch("email", "qa1auto@jmbullion.com");
		adm.adminViewAllOrders();
		String customerOrderInvoice = Q_OrderForm.isThereCustomerInvoice();
		cust.editOrder(customerOrderInvoice, 1);
		Assert.assertTrue(Q_OrderForm.verifyHold("Pickup Hold"), "The hold is disabled");
		System.out.println("The pickup hold is enabled when Secure Storage shipping option is chosen");
	}
	/******************************************************************
     * Description: Verify Shipping Options displays on order edit page on admin site
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 6, enabled = false)
    public static void verifyOrderShippingOptionsDisplay() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("platinumEagle1oz", 3, "75243");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "USPS Priority - $7.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $12.99;"
        		+ "Local Pickup - FREE");
    }
    
    /******************************************************************
     * Description: Verifies that on shipping options for order less than $199
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 7, enabled = true)
    public static void verifyShippingOptionsLessThan$199Admin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("silverEagle1994", 2, "75070");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Base Shipping - $7.99;"
        		+ "USPS Priority - $11.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $12.99;"
        		+ "Local Pickup - FREE");
    }
    
    /******************************************************************
     * Description: Verifies that on shipping options for order less than $1000
	 * and weight less than 16 oz
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 8, enabled = true)
    public static void verifyShippingOptionsLessThan$1000AndLessThan16OzAdmin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("silverEagle1994", 6, "75070");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "USPS Priority - $7.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $12.99;"
        		+ "Local Pickup - FREE");
    }
    
    /******************************************************************
     * Description: Verifies that on shipping options for order less than $15000
     * and weight less than 16 oz
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 9, enabled = true)
    public static void verifyShippingOptionsLessThan$5000AndLessThan16OzAdmin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("perth10g", 6, "75070");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "USPS Priority - $7.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $12.99;"
        		+ "Local Pickup - FREE");
    }
    
    /******************************************************************
     * Description: Verifies that on shipping options for order less than $15000
     * and weight less than 16 oz
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 10, enabled = true)
    public static void verifyShippingOptionsLessThan$15000AndLessThan16OzAdmin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("perth10g", 10, "75070");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "USPS Priority - $7.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $12.99;"
        		+ "Local Pickup - FREE");
    }
    
    /******************************************************************
     * Description: Verifies that on shipping options for order less than $1000
     * and weight less than 200 oz
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 11, enabled = true)
    public static void verifyShippingOptionsLessThan$1000AndLessThan200OzAdmin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("silverEagle1994", 17, "75070");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "USPS Priority - $12.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $12.99;"
        		+ "Local Pickup - FREE");
    }
    
    /******************************************************************
     * Description: Verifies that on shipping options for order less than $15000
     * and weight less than 200 oz
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 12, enabled = true)
    public static void verifyShippingOptionsLessThan$5000AndLessThan200OzAdmin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("silverEagle1994", 100, "75070");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "USPS Priority - $12.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $12.99;"
        		+ "Store Your Metal Securely with TDS - FREE;"
        		+ "Local Pickup - FREE");
    }
    
    /******************************************************************
     * Description: Verifies that on shipping options for order less than $15000
     * and weight less than 200 oz
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 13, enabled = true)
    public static void verifyShippingOptionsLessThan$15000AndLessThan200OzAdmin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("silverEagle1994", 100, "75070");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $12.99;"
        		+ "Store Your Metal Securely with TDS - FREE;"
        		+ "Local Pickup - FREE");
    }
    
    /******************************************************************
     * Description: Verifies that on shipping options for order less than $25000
     * and weight less than 200 oz
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 14, enabled = true)
    public static void verifyShippingOptionsLessThan$25000AndLessThan200OzAdmin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("perth10g", 30, "75070");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $12.99;"
        		+ "Store Your Metal Securely with TDS - FREE;"
        		+ "Local Pickup - FREE");
    }
    

    /******************************************************************
     * Description: Verifies that on shipping options for order less than $15000
     * and weight less than 300 oz
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 15, enabled = true)
    public static void verifyShippingOptionsLessThan$5000AndLessThan300OzAdmin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("copperUSQuarter", 225, "75070");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "USPS Priority - $17.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $16.99;"
        		+ "Store Your Metal Securely with TDS - FREE;"
        		+ "Local Pickup - FREE");
    }
    
    /******************************************************************
     * Description: Verifies that on shipping options for order less than $25000
     * and weight less than 300 oz
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 16, enabled = true)
    public static void verifyShippingOptionsLessThan$25000AndLessThan300OzAdmin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("silverEagle1994 & perth10g", 250, "75070");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $16.99;"
        		+ "Store Your Metal Securely with TDS - FREE;"
        		+ "Local Pickup - FREE");
    }
    
    /******************************************************************
     * Description: Verifies that on shipping options for order less than $15000
     * and weight less than 450 oz
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 17, enabled = true)
    public static void verifyShippingOptionsLessThan$5000AndLessThan450OzAdmin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("copperUSQuarter", 350, "75070");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "USPS Priority - $21.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $24.99;"
        		+ "Local Pickup - FREE");
    }
    
    /******************************************************************
     * Description: Verifies that on shipping options for order less than $25000
     * and weight less than 450 oz
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 18, enabled = true)
    public static void verifyShippingOptionsLessThan$25000AndLessThan450OzAdmin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("silverEagle1994", 300, "75070");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $24.99;"
        		+ "Store Your Metal Securely with TDS - FREE;"
        		+ "Local Pickup - FREE");
    }
    
    /******************************************************************
     * Description: Verifies that on shipping options for order less than $5000
     * and weight less than 750 oz
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 19, enabled = true)
    public static void verifyShippingOptionsLessThan$5000AndLessThan750OzAdmin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("copperUSQuarter", 500, "75070");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "USPS Priority - $21.99;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $29.99;"
        		+ "Local Pickup - FREE");
    }
    
    /******************************************************************
     * Description: Verifies that on shipping options for order less than $15000
     * and weight less than 750 oz
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 20, enabled = true)
    public static void verifyShippingOptionsLessThan$15000AndLessThan750OzAdmin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("copperUSQuarter & perth10g", 500, "75070");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $29.99;"
        		+ "Local Pickup - FREE");
    }
    
    /******************************************************************
     * Description: Verifies that on shipping options for order less over 750 oz
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
     * Status: Complete
     *******************************************************************/
    @Test (priority = 21, enabled = true)
    public static void verifyShippingOptionsOver750OzAdmin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        driver.navigate().to(baseUrl);
        chk.emptyCart();
        Q_OrderForm.regularOrderToCheckout("copperUSQuarter", 1000, "75070");
        chk.completeOrder();
        Q_OrderForm.thankYouPage();
        driver.navigate().to(adminUrl);
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $29.99;"
        		+ "Local Pickup - FREE");
    }
    
    /******************************************************************
    * Description: Verifies that on shipping options for order less over $25000
    * Created By: Paul Patterson
    * Jira Ticket: JMB-6798, JMB-6584, JMB-6991
    * Status: Complete
    *******************************************************************/
   @Test (priority = 22, enabled = true)
   public static void verifyShippingOptionsOver$25000Admin() throws FileNotFoundException {
       String tcName = (new Object() {
       }.getClass().getEnclosingMethod().getName());
       Controls.testStarted(tcName);
       Controls.adminLogin();
       driver.navigate().to(baseUrl);
       chk.emptyCart();
       Q_OrderForm.regularOrderToCheckout("perth10g", 50, "75070");
       chk.completeOrder();
       Q_OrderForm.thankYouPage();
       driver.navigate().to(adminUrl);
       Q_OrderForm.ordersMenu("list");
       ord.editTopOrder();
       Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
       		+ "Expedited Shipping - Our Choice UPS or FedEx - $12.99;"
    		+ "Store Your Metal Securely with TDS - FREE;"
       		+ "Local Pickup - FREE");
   }
    
    /******************************************************************
     * Description: Verify Shipping Options UPS option does not disappear on admin
     * when order without UPS is open in different tab
     * Created By: Paul Patterson
     * Jira Ticket: JMB-6798
     * Status: Complete
     *******************************************************************/
    @Test (priority = 23, enabled = true)
    public static void verifyOrderShippingOptionsUPSStaysOnAdmin() throws FileNotFoundException {
        String tcName = (new Object() {
        }.getClass().getEnclosingMethod().getName());
        Controls.testStarted(tcName);
        Controls.adminLogin();
        Q_OrderForm.ordersMenu("list");
        ord.editTopOrder();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $12.99;"
        		+ "Store Your Metal Securely with TDS - FREE;"
        		+ "Local Pickup - FREE");
        Controls.newTab();
        Controls.switchTab(1);
        Q_OrderForm.regularOrderToCheckout("platinumEagle1oz", 3, "96701");
        Controls.switchTab(0);
        driver.navigate().refresh();
        Q_OrderForm.verifyAdminOrderShippingMethods("Free Shipping - FREE;"
        		+ "Expedited Shipping - Our Choice UPS or FedEx - $12.99;"
        		+ "Store Your Metal Securely with TDS - FREE;"
        		+ "Local Pickup - FREE");
        Controls.switchTab(1);
        // Reset Address back to non HI zip
        Q_OrderForm.selectShippingAddressByZipCode("75243");
        driver.navigate().to(baseUrl);
        chk.emptyCart();
    }
    
    /*********************************************************************
	 * Description: Verify user permissions for pickup hold on admin and that with permission can remove TDS
	 * Author: Paul Patterson
	 * Status: Complete 
	 * Ticket: JMB-6830
	 ********************************************************************/
	@Test(priority = 24)
	public void allowUsersToUndoStorage() {
		String tcName = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Q_OrderForm.frontendLogin(0);
		driver.navigate().to(baseUrl + "/10-gram-perth-mint-gold-bar/");
		chk.addItemToCart(6);
		chk.selectPaymentType("wire");
		chk.selectcheckoutBtn("top");
		Q_CheckoutForm.selectShippingUpgrade("Secure Storage - TDS");
		chk.completeOrder();
		Q_OrderForm.logoutUser();
		Controls.adminLogin();
		adm.selectAdminUser();
        adm.removePermission("Hold - Pickup Order");
        driver.navigate().to(adminUrl);
		adm.adminCustomerSearch("email", "qa1auto@jmbullion.com");
		adm.adminViewAllOrders();
		String customerOrderInvoice = Q_OrderForm.isThereCustomerInvoice();
		cust.editOrder(customerOrderInvoice, 1);
		ord.verifyOrderSecureStorage(false);
		adm.selectAdminUser();
		adm.grantPermission("Hold - Pickup Order");
		driver.navigate().to(adminUrl);
		adm.adminCustomerSearch("email", "qa1auto@jmbullion.com");
		adm.adminViewAllOrders();
		customerOrderInvoice = Q_OrderForm.isThereCustomerInvoice();
		cust.editOrder(customerOrderInvoice, 1);
		ord.verifyOrderSecureStorage(true);
		ord.removeSecureStorageFromOrder();
	}
	
	/*********************************************************************
	 * Description: Verify Auto-Flag Massive Orders to Ship Commercial
	 * to accommodate the following:
	 * 1. Check orders for if it's over this amount (Frank said he already had something that did this)
	 * 2. If it exceeds, put it on Shipping Issue Hold with the Error "This order needs to ship commercially".
	 * 3. Create a new shipping method on the backend called "Commercial". 
     * 4. Only allow order to batch using this method.
	 * Author: Asfi.Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-7089
	 * @throws FileNotFoundException 
	 ********************************************************************/
	@Test(priority = 25)
	public void verifyAutoFlagMassiveOrdersToShipCommercial() throws FileNotFoundException {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		String customer = "qa@jmbullion.com";
		String productQty = "1";
		String productName= "10 oz Credit Suisse Gold Bar";
		Controls.testStarted(tcName);
		Controls.adminLogin();
		adm.adminMenu("settings");
		ord.verifyChangedProductQty_isAboveThresholdValue(productQty, productName, "3");
		ord.placeNewOrderInNewTab(productName, productQty);
		ord.updateProductQtyBeyondThreshold_verifyShippingHoldOnOrderForm(customer, productQty);
        ord.clearAllOrderHolds();
        Assert.assertNotEquals(Q_WebElm.idRetText(adminProps, "ord.shippingMethodValue.id"), "Commercial",
        		"The Shipping method is Commercial");
        ord.launchTestShippingFile();
        Controls.closeTabsSwitchWinMain();
        driver.navigate().refresh();
        Q_WebElm.myWait(2000);
        Assert.assertEquals(ord.isHoldChecked_withMessage("ord.hold.shipping.id"), "This order needs to ship commercially", 
        		"Incorrect message displayed.");
        ord.changeShippingMethod("Commercial");
        ord.clearAllOrderHolds();
        ord.launchTestShippingFile();
        Assert.assertTrue(ord.strXpText("ord.shippingTestFileMessage.xp").contains("[message] => Ready to ship"), 
        		"Unexpected message displayed");
        adm.adminMenu("settings");
        ord.getThresholdValue_configSettings("300");
	}
	
	/********************************************************************
	 * Description: Shipping method update on editing payment information on Order form
	 * Param		 : NA
	 * Jira Ticket: JMB-7316 - Shipping method update on editing payment information on Order form
	 * Status	 : Complete
	 *******************************************************************/
	@Test(priority = 26, enabled = true)
	public void verifyShippigMethodUpdateinOrderForm_JMB7316(){
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName); 
		Q_OrderForm.frontendLogin(0);
		Q_WebElm.myWait(7000); 
		driver.navigate().to(baseUrl +"/10-gram-perth-mint-gold-bar/"); 
		chk.addItemToCart(6);
		chk.selectPaymentType("wire"); 
		chk.selectcheckoutBtn("top");
		Q_CheckoutForm.selectShippingUpgrade("Secure Storage - TDS");
		chk.completeOrder(); 
		Q_WebElm.myWait(2000); 
		Q_OrderForm.logoutUser();
		Controls.adminLogin();
		adm.adminCustomerSearch("email", "qa1auto@jmbullion.com");
		adm.adminViewAllOrders();
		String customerOrderInvoice = Q_OrderForm.isThereCustomerInvoice();
		cust.editOrder(customerOrderInvoice, 1);
		ord.verifyPreSelectedShippingMethod("TDS");
		Q_OrderForm.changeShippingMethod("Base Shipping");
		ord.verifyPreSelectedShippingMethod("Base Shipping");
	}
	
	/********************************************************************
	 * Description  : Verify the Present Date on Ship date Calendar in admin claim form page
	 * Param        : NA
	 * Jira Ticket  : JMB-7527 - Change of Present Date on Ship date Calendar
	 * Status       : Completed
	 *******************************************************************/
	@Test(priority = 27, enabled = true)
	public void verifyShippingCalendar_JMB7527(){
		String endDate, expectedDate;
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		Q_ShippingForm.menuElement("adm.menuShipping.xp");
		Q_ShippingForm.subMenuElement("adm.menuShippingCalendar.xp");
		endDate = ord.attReturn( "adm.adminShippingDateCalendar.endDate.xp","value");
		expectedDate = ord.getFutureDateFromCurrentDate(7);
		Assert.assertTrue(endDate.equals(expectedDate),"Miss Match in End date");
	}
	
	/********************************************************************
	 // * Description  : Verify the Require a valid date to be entered when adding a Requested Ship Date to an order 
	 // * Author       : Shriram S K
	 // * Param        : NA
	 // * Jira Ticket  : JMB-8081
	 // * Status       : Completed
	 //*******************************************************************/
	@Test(priority = 28, enabled = true)
	public void verifyRequestedShipDateAnOrder() {
		String expectedAlertValue ="You are required to enter a valid date to proceed.";
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Controls.testStarted(tcName);
		Controls.adminLogin();
		String orderId = ord.placeAnOrders("/2016-3-oz-30th-anniversary-silver-eagle-coin-bar/","credit card");
		driver.navigate().to(adminUrl);
		Q_OrderForm.ordersMenu("list");
		ord.searchOrderInAdminPage(orderId);
		String date = ord.updateRequestedShipDate(expectedAlertValue,0);
		driver.navigate().refresh();
		Assert.assertTrue(date.equals(Q_WebElm.xpRetText(adminProps,"adm.orderForm.requestShipDate.xp")),"Before and After Requested Ship Date is matching");
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


