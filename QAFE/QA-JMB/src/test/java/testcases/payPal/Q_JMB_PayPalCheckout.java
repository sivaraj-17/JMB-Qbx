package testcases.payPal;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Q_JMB_PayPalCheckout extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    static Q_JMB_AdminObjects adm = new Q_JMB_AdminObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
    static Q_JMB_CategoryObjects cat = new Q_JMB_CategoryObjects();

    @BeforeClass
    public void tcSetup () throws Exception {

//        Init.setItUp();
    }
    @BeforeMethod
    public void getJMBSite () throws Exception {

        Q_JMB_Init.setItUp();
    }
    //*******************************************************************
    // * Description: Verify user can choose different option
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2)
    public static void payPal98Shipping399() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.copperWalkingLiberty("59");
        Q_JMB_WebElm.xp(jmbProps, "cart.modal.CheckoutNow.xp");
        //WebElm.xpcartProps, "jm.modalCheckoutNow.xp");
        String originalWindow = driver.getWindowHandle();
        chk.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.xp", originalWindow);
        chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
    //        Assert.assertEquals(driver.getTitle(), "PayPal Checkout");
        Q_JMB_WebElm.myWait(3000);
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.revPriceListSh());
        Q_JMB_WebElm.myWait(1000);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.orderPriceList());
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    
    //*******************************************************************
    // * Description: Verify user can choose different option and shipping tax is applied
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3)
    public static void payPalDefShippingTax() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
//        CartSteps.goAmericanGoldEagleCoin("1");
        Q_JMB_CategoryObjects.copperWalkingLiberty("50");
        Q_JMB_WebElm.xp(jmbProps, "cart.modal.CheckoutNow.xp");
        String originalWindow = driver.getWindowHandle();
        chk.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.xp", originalWindow);
        chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
//        Assert.assertEquals(driver.getTitle(), "Checkout → Review Order | JM Bullion");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.revPriceListSh());
        Q_JMB_WebElm.myWait(1000);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.orderPriceList());
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices); 
    }
    
    //*******************************************************************
    // * Description: Verify user can choose different shipping option and shipping tax apply
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 4)
    public static void payPal500PriShippingTax() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.silverCoin1994("5");
        Q_JMB_CategoryObjects.copperWalkingLiberty("100");
        Q_JMB_WebElm.xp(jmbProps, "cart.modal.CheckoutNow.xp");
        String originalWindow = driver.getWindowHandle();
        chk.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.xp", originalWindow);
        chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
//        Assert.assertEquals(driver.getTitle(), "Checkout → Review Order | JM Bullion");
        chk.regShippingUpgrade("paypal option 2");
        Q_JMB_WebElm.myWait(3000);
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.revPriceListSh());
        Q_JMB_WebElm.myWait(1000);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.orderPriceList());
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    
    //*******************************************************************
    // * Description: Verify user can choose different option
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 5)
    public static void payPal5003DayShippingTax() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.perthMintGoldBar("1");
        Q_JMB_CategoryObjects.copperWalkingLiberty("10");
        Q_JMB_WebElm.xp(jmbProps, "cart.modal.CheckoutNow.xp");
        String originalWindow = driver.getWindowHandle();
        chk.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.xp", originalWindow);
        chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
//        Assert.assertEquals(driver.getTitle(), "Checkout → Review Order | JM Bullion");
        chk.shippingOptionValue();
        Q_JMB_WebElm.myWait(3000);
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.revPriceListSh());
        Q_JMB_WebElm.myWait(1000);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.orderPriceList());
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    
    //*******************************************************************
    // * Description: Verify user can choose different option
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 6)
    public static void payPal1kPlusNoShippingNoTax() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.goldEagle("3");
        String originalWindow = driver.getWindowHandle();
        chk.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.xp", originalWindow);
        chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
        //Assert.assertEquals(driver.getTitle(), "Checkout → Review Order | JM ");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.revPriceListNoTax());
        Q_JMB_WebElm.myWait(3000);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.orderPriceListNoTax());
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    
    //*******************************************************************
    // * Description: Verify user can choose different option
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 7)
    public static void payPal1kPlusPriShippingTax() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.chinesePanda("4");
        Q_JMB_CategoryObjects.copperWalkingLiberty("10");
        Q_JMB_WebElm.xp(jmbProps, "cart.modal.CheckoutNow.xp");
        String originalWindow = driver.getWindowHandle();
        chk.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.xp", originalWindow);
        chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
//        Assert.assertEquals(driver.getTitle(), "Checkout → Review Order | JM Bullion");
        chk.shippingOptionValue();
        Q_JMB_WebElm.myWait(1000);
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.revPriceListSh());
        Q_JMB_WebElm.myWait(1000);
        chk.completeOrder();
        ArrayList<Float> orderPrices = new ArrayList<>(chk.orderPriceList());
        chk.verifyGuestOrderCharges(reviewPrices, orderPrices);
    }
    
    /******************************************************************
     // * Description: Verify PayPal charges remain accurate when user use browser back button selects a lower amount payment method.
     // * Then clicks the browser forward button.
     // * JMB-4430
     // * Status: Complete
     //*******************************************************************/
    @Test(priority = 8)
    public static void verifyPayPalPayment(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_CategoryObjects.silverCoin1994("10");
        String originalWindow = driver.getWindowHandle();
        chk.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.xp", originalWindow);
        chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /*******************************************************************
     // * Description: This test case verifies user can place order with coupon code.
     // * Author:
     // * Status: Complete
     *  Ticket : JMB-6079(Unable to place order with a coupon code)
     * @throws Exception
     */
    @Test(priority = 9)
    public static void ppOrderWithCoupon50() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_ProductPageObjects.platinumAmericanEagle("1");
        String originalWindow = driver.getWindowHandle();
        chk.paypalCheckoutWithCoupon("cart.paymentType.PP.id","HSD", "chk.paypal.checkout.xp", originalWindow);
        Q_JMB_WebElm.myWait(3000);
        chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
//		        Assert.assertEquals(driver.getTitle(), "PayPal Checkout");
        Q_JMB_WebElm.myWait(2000);
//		        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.revPriceListNoTax());
        Q_JMB_WebElm.myWait(2000);
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /*******************************************************************
     // * Description: Verifiy Order over $299 should not charge shipping with coupon applied - JMB-5894
     // * Author:
     // * Status: Complete
     *  Ticket : JMB-5894
     * @throws Exception
     */
    @Test(priority = 10)
    public static void noShippingOrderOver299WithCoupon()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        cat.silverPeaceSilverDollarCoi("15");
        cat.copperUSQuarter("12");
        String originalWindow = driver.getWindowHandle();
        chk.paypalCheckoutWithCoupon("cart.paymentType.PP.id","HSD", "chk.paypal.checkout.xp", originalWindow);
        Q_JMB_WebElm.myWait(3000);
        chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
//	        Assert.assertEquals(driver.getTitle(), "PayPal Checkout");
        Q_JMB_WebElm.myWait(3000);
        chk.completeOrder();
        chk.thankYouPage();
    }
    
    /******************************************************************************
	 * Description:Verify updates for New PayPal via BrainTree for Registered User
	 * Author: Ilakiya
	 * Status: Completed
	 * Ticket: JMB-7655
	 * ****************************************************************************/
	@Test(priority = 11, enabled=true)
	public void verifyUpdatesForNewPayPalViaBrainTreeRegisteredUser() throws Exception {
		String payPalPhoneNumber = "408-581-6878";
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(54);
		String customerNameInAccountPage=acc.getCustomerName("AccountPage");
		chk.selectItem("1994 1 oz American Silver Eagle Coin", 1);
		String originalWindow = driver.getWindowHandle();
		Q_JMB_WebElm.myWait(3000);
		chk.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.xp", originalWindow);
		chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
		Q_JMB_WebElm.myWait(3000);
		chk.completeOrder();
		Q_JMB_WebElm.myWait(2000);
		String orderId= chk.getOrderId();
		acc.logoutUser();
		adm.navigateToEditOrderInAdminPage(orderId);
		String customerNameInAdminPage=acc.getCustomerName("AdminPage");
		String billingAddress=driver.findElement(By.xpath("//div[@id='billing-address-formatted']")).getText();
		Assert.assertTrue(customerNameInAdminPage.contains(customerNameInAccountPage),"Order is assigned to different customer");
		Assert.assertTrue(billingAddress.contains(payPalPhoneNumber),"Phone number is not attached");
	}

	/**********************************************************************************
    // * Description: Verify updates for New PayPal via BrainTree for Guest User
    // * Author     : Ilakiya
    // * Status     : Completed
    // * Jira Ticket: JMB - 7655
	 **********************************************************************************/	
	@Test(priority = 12, enabled = true)
	public void verifyUpdatesForNewPayPalViaBrainTreeGuestUser() throws FileNotFoundException {	
		String payPalPhoneNumber = "408-581-6878";
		String payPalCustomerName="Frank McMorrow";
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		chk.selectItem("1994 1 oz American Silver Eagle Coin", 1);
		String originalWindow = driver.getWindowHandle();
		Q_JMB_WebElm.myWait(3000);
		chk.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.xp", originalWindow);
		chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
		Q_JMB_WebElm.myWait(3000);
		chk.completeOrder();
		Q_JMB_WebElm.myWait(2000);
		String orderId= chk.getOrderId();
		adm.navigateToEditOrderInAdminPage(orderId);
		String customerNameInAdminPage=acc.getCustomerName("AdminPage");
		String billingAddress=driver.findElement(By.xpath("//div[@id='billing-address-formatted']")).getText();
		//Assert.assertTrue(customerNameInAdminPage.contains(payPalCustomerName),"Order is assigned to different customer");
		Assert.assertTrue(billingAddress.contains(payPalPhoneNumber));
	}
	
	/*******************************************************************************
    // * Description: Verify if coupon code is applied correctly to a customer order
    // * Author: Ilakiya
    // * Status: Completed
    // * Jira Ticket: JMB - 7971 
	 *******************************************************************************/	
	@Test(priority = 13, enabled = true)
	public void verifyCouponCodeIsAppliedCorrectlyToCustomerOrder() throws FileNotFoundException {	
		boolean hasSalesTax = false;
		boolean hasStateFee = false;
		boolean hasShippingTax = false;
		boolean hasGiftCert = true;
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(54);
		chk.selectItem("1994 1 oz American Silver Eagle Coin", 10);
		cart.selectPaymentType("paypal");
		Q_JMB_CartPageObjects.applyGiftCertificate();
		Q_JMB_WebElm.myWait(3000);
		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "cart.couponCodeMessage.xp"),"Couponcode not applied");
		String originalWindow = driver.getWindowHandle();
		Q_JMB_WebElm.myWait(3000);
		chk.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.xp", originalWindow);
		chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
		Q_JMB_WebElm.myWait(3000);
		ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
				hasStateFee, hasShippingTax, hasGiftCert));
		ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
				hasStateFee, hasShippingTax, hasGiftCert));
		chk.completeOrder();
		chk.thankYouPage();
		ArrayList<Float> adminPrices = new ArrayList<>(adm.adminOrderPriceList("qa+cosalestax@jmbulllion.com", hasSalesTax, 
				hasStateFee, hasShippingTax, hasGiftCert, 1));
		chk.compareCheckoutToOtherPageRev("Admin Order", priceList, reviewPrices, adminPrices);
	}
	
	/********************************************************************
	 // * Description : To verify placed paypal orders in customer page
	 // * Author      : Sivaraj
	 // * Param       : NA
	 // * Jira Ticket : JMB-7855
	 // * Status      : Complete
	 //*******************************************************************/
	@Test(priority = 14, enabled = true)
	public void verifyPlacedPayPalOrders() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		chk.selectItem("1 oz American Gold Eagle Coin", 1);
		String originalWindow = driver.getWindowHandle();
		chk.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.xp", originalWindow);
		chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
		chk.completeOrder();
		String orderId = chk.getOrderId();
		String orderTotal = chk.getOrderTotal();
		driver.navigate().to("https://qa.jmbullion.com/ato/smarty.php");
		adm.navigateToEditOrderInAdminPage(orderId);
		Assert.assertFalse(Q_JMB_WebElm.xpSelected(jmbProps, "adm.addressVerification.xp"),"Address Verification is Checked");
		adm.verifyCustomerOrders(orderId, orderTotal);
	}	
	
	/********************************************************************
	 // * Description : To verify address verification in orders form page
	 // * Author      : Sivaraj
	 // * Param       : NA
	 // * Jira Ticket : JMB-7855
	 // * Status      : Complete
	 //*******************************************************************/
	@Test(priority = 15, enabled = true)
	public void verifyAddressVerificationCheckBox() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		chk.selectItem("1 oz American Gold Eagle Coin", 1);
		String originalWindow = driver.getWindowHandle();
		chk.payPalCheckout("cart.paymentType.PP.id", "chk.paypal.checkout.xp", originalWindow);
		chk.payPal("test1@jmbullion.com", "2014gold", originalWindow);
		chk.completeOrder();
		String orderId = chk.getOrderId();
		driver.navigate().to("https://qa.jmbullion.com/ato/smarty.php");
		adm.navigateToEditOrderInAdminPage(orderId);
		Assert.assertFalse(Q_JMB_WebElm.xpSelected(jmbProps, "adm.addressVerification.xp"),"Address Verification is Checked");
	}
	
	/*******************************************************************************
    // * Description: Verify replacement of PayPal Express with Brain Tree PayPal
    // * Author: Vignesh
    // * Status: Completed
    // * Jira Ticket: JMB - 7654
	 *******************************************************************************/	
	@Test(priority = 16, enabled = true)
	public void verifyReplacementOfPaypalExpressWithBraintreePaypal() throws FileNotFoundException  {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		Q_JMB_Controls.adminLogin();
		String payPalExpressButton="Check out with PayPal"; 
		adm.setPayPalViaBrainTree();                     
		adm.setPayPalExpress();
		chk.selectItem("1994 1 oz American Silver Eagle Coin", 10);
		cart.selectPaymentType("paypalexpress");
		Assert.assertTrue(Q_JMB_WebElm.xpRetAttr(jmbProps, "cart.payPalCheckOut.xp","alt").equals(payPalExpressButton));
		adm.resetBrainTreeAndPayPalExpress();
	}
    
    @AfterMethod
    public static void tearDown(){
        //chk.pplogout();
        driver.quit();
    }
    
    @AfterClass
    public static void kill(){
        if (driver.toString().contains("Firefox")) {
            driver.quit();
        }
    }
}
