package testcases.stu;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;

import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;

import java.util.ArrayList;


public class Q_JMB_SellToUs extends Q_JMB_Init {
    static Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
    Q_JMB_AutoBuyObjects autobuy = new Q_JMB_AutoBuyObjects();
    static Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
    static Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
    static Q_JMB_StuObjects stu = new Q_JMB_StuObjects();
    static Q_JMB_CategoryObjects cat = new Q_JMB_CategoryObjects();
    static Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();

    @BeforeClass
    public void tcSetup (){
    }
    @BeforeMethod
    public void report() throws Exception {
        Q_JMB_Init.setItUp();
    }
    @BeforeTest
    public void setTest() throws Exception {
    }
    /*******************************************************************
     * Description: Verify user can granted DIY permission
     * Author:
     * Jira Ticket: JMB-4617
     * Status: Complete
     *******************************************************************/
////    @Test(priority = 1)
//    public static void bbGuestCustomer(){
//       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
//        Controls.testStarted(tcName);
//        ElemSteps.xpElement(bbProps,"stu.link.xpath");
//        ElemSteps.xpElement(bbProps, "stu.noPermission.reqQuoteBtn.xpath");
//        Assert.assertTrue(ElemSteps.xpElementDisplayed(bbProps, "stu.loginModal.xpath").equals(true));
//        Controls.testPassed(tcName);
//        Log.endTestCase(tcName + "::      Finished execution" + "\t" + Controls.startTimeStriped());
//    }
    /*******************************************************************
     * Description: Verify user can granted DIY permission
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 1, enabled = true)
    public static void grantUserDIYPermission(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        String userToCheck = "379701"; // qa3jmb user 23
        stu.grantUserDIYBBPermission(userToCheck);
        acc.adminLogout();
    }
    
    /*******************************************************************
     * Description: Verify DIY permissions can be revoked for a given user
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 2, enabled = true)
    public static void revokeUserDIYPermission(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        String userToCheck = "379701"; // qa3jmb user 23
        stu.removeUserDIYBBPermission(userToCheck);
        acc.adminLogout();
    }
    
    /*******************************************************************
     * Description: Verify user my account buyback listing if he /she grated access to buyback
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 3, enabled = false)
    public static void listBBMyAccount(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(26);  //379745
        acc.myAccount("orders");
        Integer count = Q_JMB_WebElm.xpCountTableRows(jmbProps, "acc.orderCount.xp");
        System.out.println(count);
        for(int i=1; i<=count; i++){
            Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "acc.orderNumber.beg.xp", i, "acc.orderNumber.end.xp"), Q_JMB_StuObjects.getbuybackNumber(i));
        }
    }
    
    /*******************************************************************
     * Description: Verify minimum $1k is required for creating buyback
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 4, enabled = true)
    public static void minRequired(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(24); // 379743
        stu.selToUs();
        stu.addBbItem("silver", 5, "20");
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps,"stu.cart.minReqText.xp"),"Our minimum sale amount is $1,000.00");
    }
    
    /*******************************************************************
     * Description: Verify DIY maximum of $200,000.00 is allowed otherwise customer can CSR
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 5, enabled = true)
    public static void diyMaxLimit(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(26);
        stu.selToUs();
        stu.addBbItem("gold", 36, "400");
        Assert.assertEquals(Q_JMB_WebElm.xpRetText(jmbProps, "stu.cart.maxReqText.xp"), "Our maximum sale amount is $500,000.00");
    }
    
    /*******************************************************************
     * Description: Verify customer is required to have a saved credit card in their profile in order to create buyback
     * Jira Ticket: JMB-4558
     * Status: Complete
     *******************************************************************/
    @Test(priority = 6, enabled = true)
    public static void creditCardRequired(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(24);
        stu.selToUs();
        stu.addBbItem("platinum", 2, "2");
        stu.addAnotherProduct();
        stu.addBbItem("gold", 14, "4");
        stu.isReportable();
        stu.checkoutNow();
        stu.creditCardRequired();
        stu.completeSale();
        Q_JMB_Controls.checkAlert();
    }
    
    /*******************************************************************
     * Description: Verify buyback sell to us is set to Off and user is not DIY enabled customer can access sell to us
     * Jira Ticket: JMB-4559
     * Status: Complete
     *******************************************************************/
    @Test(priority = 7, enabled = true)
    public static void diyTurnedOff() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        Q_JMB_Controls.testStarted(tcName);
        stu.diyConfigSettings();
        stu.diyBbForAll("OFF");
        driver.get(baseUrl);
        acc.logoutUser();
    }
    
    /*******************************************************************
     * Description: Verify if the buyback for all is set to On and customer is not DIY enabled customer can access sell to us
     * Author:
     * Jira Ticket: JMB-4559
     * Status: Complete
     *******************************************************************/
    @Test(priority = 8, enabled = true)
    public static void diyTurnedOn(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        stu.diyConfigSettings();
        stu.diyBbForAll("ON");
        driver.get(baseUrl);
        acc.logoutUser();
    }
    
    /*******************************************************************
     * Description: Verify cart count changes every time an item is added to cart
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 9, enabled = true)
    public static void verifyCartCount() {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(26);
        stu.selToUs();
        stu.cartContent();
    }
    
    /*******************************************************************
     * Description: Verify user can remove items from buyback cart
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 10, enabled = false)
    public static void emptyBbCart(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(26);
        stu.selToUs();
        stu.removeCartPageContent();
    }
    
    /*******************************************************************
     * Description: Verify bb with wire payment type require user to have bank info filled out
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 11, enabled = true)
    public static void stuBBwireRequireBankInfo(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(25);
        stu.selToUs();
        stu.addBbItem("platinum", 2, "2");
        stu.addAnotherProduct();
        stu.addBbItem("gold", 35, "1");
        stu.checkoutNow();
        stu.selectBbPayment("wire");
        stu.completeSale();
        stu.verifyCheckoutErrorMessage("Please select a bank account");
    }
    
    /*******************************************************************
     * Description: Verify user can use the sell to us with ach payment
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 12, enabled = true)
    public static void stuAchPay(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(22);
        stu.selToUs();
        //stu.addBbItem("platinum", 2, "2");
        //stu.addAnotherProduct();
        stu.addBbItem("gold", 14, "25");
        stu.isReportable();
        stu.checkoutNow();
        stu.selectBbPayment("ach");
        stu.completeSale();
        stu.orderDetails();
    }

    /*******************************************************************
     * Description: Verify user can use the sell to us with wire payment with wire fee applied
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 13, enabled = true)
    public static void stuWirePayment(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(22);
        stu.selToUs();
        stu.addBbItem("platinum", 2, "2");
        stu.addAnotherProduct();
        stu.addBbItem("gold", 11, "25");
        stu.isReportable();
        stu.checkoutNow();
        stu.selectBbPayment("wire");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_StuObjects.stuRvPriceList());
        stu.completeSale();
        stu.orderDetails();
        ArrayList<Float> orderDetails = new  ArrayList<Float>(Q_JMB_StuObjects.stuBbOrderPriceList());
    }
    
    /*******************************************************************
     * Description: Verify user can use the sell to us with check payment with check fee applied
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 14, enabled = true)
    public static void stuCheckPayment(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(22);
        stu.selToUs();
        stu.addBbItem("gold", 2, "2");
        stu.addAnotherProduct();
        stu.selToUs();
        stu.addBbItem("silver", 5, "10");
        stu.addAnotherProduct();
        stu.selToUs();
        stu.addBbItem("platinum", 2, "2");
        stu.addAnotherProduct();
        stu.selToUs();
        stu.addBbItem("palladium", 1, "2");
        stu.checkoutNow();
        stu.selectBbPayment("check");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_StuObjects.stuRvPriceList());
        stu.completeSale();
        stu.orderDetails();
        ArrayList<Float> orderDetails = new  ArrayList<Float>(Q_JMB_StuObjects.stuBbOrderPriceList());
    }
    
    /*******************************************************************
     * Description: selToUs add second product by clicking the Add More Items button in cart page and verify second item added
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 15, enabled = true)
    public static void stuPopularProducts(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(22);
        stu.selToUs();
        stu.addBbItem("gold", 2, "25");
        stu.addAnotherProduct();
        stu.addBbItem("popular", 25, "10");
        stu.isReportable();
        stu.checkoutNow();
        stu.selectBbPayment("wire");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_StuObjects.stuRvPriceList());
        stu.completeSale();
        stu.orderDetails();
        ArrayList<Float> orderDetails = new  ArrayList<Float>(Q_JMB_StuObjects.stuBbOrderPriceList());
    }

    /*******************************************************************
     * Description: selToUs add multiple products from metal tabs
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 16, enabled = true)
    public static void stuMultipleMetalProducts(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(22);
        stu.selToUs();
        stu.addBbItem("popular", 2, "100");
        stu.modalAddItem();
        stu.addBbItem("gold", 2, "2");
        stu.modalAddItem();
        stu.addBbItem("silver", 5, "10");
        stu.modalAddItem();
        stu.addBbItem("platinum", 2, "2");
        stu.modalAddItem();
        stu.addBbItem("palladium", 1, "2");
        stu.checkoutNow();
        stu.selectBbPayment("ach");
        stu.completeSale();
        stu.orderDetails();
    }

    /*******************************************************************
     * Description: Verify reportable rules are addressed in the cart page prior to checkout.
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 17, enabled = true)
    public static void stuReportableItem(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(21);
        stu.selToUs();
        stu.addBbItem("gold", 12, "40");
        stu.modalAddItem();
        stu.addBbItem("platinum", 2, "2");
        stu.isReportable();
        stu.checkoutNow();
        stu.selectBbPayment("check");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_StuObjects.stuRvPriceList());
        stu.completeSale();
        ArrayList<Float> orderDetails = new  ArrayList<Float>(Q_JMB_StuObjects.stuBbOrderPriceList());
        stu.orderDetails();
    }
    
    /*******************************************************************
     * Description: Verify user can their own mailing option when creating buyback
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 18, enabled = true)
    public static void mailOptionMyOwn(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(22);
        stu.selToUs();
        stu.addBbItem("platinum", 2, "2");
        stu.checkoutNow();
        stu.selectBbPayment("check");
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(Q_JMB_StuObjects.stuRvPriceList());
        stu.mailLabel(2);
        stu.completeSale();
        ArrayList<Float> orderDetails = new  ArrayList<Float>(Q_JMB_StuObjects.stuBbOrderPriceList());
        stu.orderDetails();
    }
    
    /*******************************************************************
     * Description: Verify user can enter and save tracking number when the view buyback in MyAccount page
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 19, enabled = true)
    public static void trackingNumber(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(22);
        acc.myAccount("orders");
        stu.myAccoutbb("number", 1);
        stu.verifyTrackingNum();
    }
    
    /*******************************************************************
     * Description: Verify user can enter and save tracking number
     * Author:
     * Status: Complete
     *******************************************************************/
    @Test(priority = 20, enabled = true)
    public static void UpdateTrackingNumber(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(22);
        acc.myAccount("orders");
        stu.myAccoutbb("number", 1);
        stu.updateTrackingNum();
    }

    /*******************************************************************
     * Description: Verify QC user will have legacy echeck available for ACH checkout
     * Author: Hisham Aridi
     * Status: Complete
     *******************************************************************/
    @Test(priority = 21, enabled = true)
    public static void legacyEcheckAvialeQC(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(27);
        stu.selToUs();
        stu.addBbItem("platinum", 2, "2");
        stu.addAnotherProduct();
        stu.addBbItem("gold", 14, "5");
        stu.isReportable();
        stu.checkoutNow();
        stu.selectBbPayment("ach");
        stu.isLegacyEcheckQc();
    }
    
    /*******************************************************************
     * Description: Verify non QC user will not have legacy echeck available for ACH checkout
     * Author: Hisham Aridi
     * Status: Complete
     *******************************************************************/
    @Test(priority = 22, enabled = true)
    public static void lgacyEcheckNotAvaiNonQC(){
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(25);
        stu.selToUs();
        stu.addBbItem("platinum", 2, "2");
        stu.addAnotherProduct();
        stu.addBbItem("gold", 14, "4");
        stu.isReportable();
        stu.checkoutNow();
        stu.selectBbPayment("wire");
        stu.isLegacyEcheckQc();
    }

    /*******************************************************************
     * Description: Verifies that on selecting Mailing address with a drop off location
     * able to select Drop Off location and complete STU.
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6414(Buybacks - Drop off Option)
     ********************************************************************/
    @Test(priority = 23)
    public static void registerOrderPickUpShippingOption()throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_JMB_Controls.testStarted(tcName);
        acc.loginUser(0);
        stu.selToUs();
        stu.addBbItem("platinum", 2, "2");
        stu.addAnotherProduct();
        stu.addBbItem("gold", 14, "4");
        stu.checkoutNow();
        // Address selection xpath for STU is the same as regular orders
        Q_JMB_CheckoutObjects.selectShippingAddressByZipCode(jmbProps, "chk.reg.shippingAddressOptionByText.beg.xp" ,"75070" ,"chk.reg.shippingAddressOptionByText.end.xp");
        // Select Drop Off option
        stu.mailLabel(3);
        stu.completeSale();
    }
    
    /********************************************************************
	 // * Description : To verify PO Box address and Make Me a Label.
	 // * Author      : Sivaraj
	 // * Param       : NA
	 // * Jira Ticket : JMB-7384
	 // * Status      : Complete
	 //*******************************************************************/
	@Test(priority = 24, enabled = true)
	public void verifyPoBoxAddressMakeMeLabel() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(2);
		driver.navigate().to(baseUrl +"/my-account/buyback-products/");
		stu.searchBuyBackProduct("1 oz American Gold Eagle Coin (Random Year)");
		cart.addItemToCart(1);
		cart.selectcheckoutBtn("bottom");
		stu.isSelectNewShippingAddress();
		acc.acctShippingAddress(37);
		stu.continueWithAddress();
		stu.shippingMethod("Make Me a Label");
		chk.completeOrder();
		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "chk.stu.errorMesssage.xp"), "Error Message is not display!");
		autobuy.deleteUserAddresses();
	}

	/********************************************************************
	 // * Description : To verify Military address and Make Me a Label.
	 // * Author      : Sivaraj
	 // * Param       : NA
	 // * Jira Ticket : JMB-7384
	 // * Status      : Complete
	 //*******************************************************************/
	@Test(priority = 25, enabled = true)
	public void verifyMilitaryAddressMakeMeLabel() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(2);
		driver.navigate().to(baseUrl +"/my-account/buyback-products/");
		stu.searchBuyBackProduct("1 oz American Gold Eagle Coin (Random Year)");
		cart.addItemToCart(1);
		cart.selectcheckoutBtn("bottom");
		stu.isSelectNewShippingAddress();
		acc.acctShippingAddress(38);
		stu.continueWithAddress();
		stu.shippingMethod("Make Me a Label");
		chk.completeOrder();
		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "chk.stu.errorMesssage.xp"), "Error Message is not display!");
		autobuy.deleteUserAddresses();
	}

	/********************************************************************
	 // * Description : To Verify PO Box address and Use My Own Label.
	 // * Author      : Sivaraj
	 // * Param       : NA
	 // * Jira Ticket : JMB-7384
	 // * Status      : Complete
	 //*******************************************************************/
	@Test(priority = 26, enabled = true)
	public void verifyPoBoxAddressUseMyOwnLabel() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(2);
		driver.navigate().to(baseUrl + "/my-account/buyback-products/");
		stu.searchBuyBackProduct("1 oz American Gold Eagle Coin (Random Year)");
		cart.addItemToCart(1);
		cart.selectcheckoutBtn("bottom");
		stu.selectBbPayment("check");
		stu.isSelectNewShippingAddress();
		acc.acctShippingAddress(37);
		stu.continueWithAddress();
		stu.shippingMethod("Use My Own Label");
		chk.completeOrder();
		Q_JMB_WebElm.myWait(2000);
		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "chk.ThankYouPage.xp"), "Order number is not display!");
		autobuy.deleteUserAddresses();

	}

	/********************************************************************
	 // * Description : To Verify Military address and Use My Own Label.
	 // * Author      : Sivaraj
	 // * Param       : NA
	 // * Jira Ticket : JMB-7384
	 // * Status      : Complete
	 //*******************************************************************/
	@Test(priority = 27, enabled = true)
	public void verifyMilitaryAddressUseMyOwnLabel() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_JMB_Controls.testStarted(tcName);
		acc.loginUser(2);
		driver.navigate().to(baseUrl +"/my-account/buyback-products/");
		stu.searchBuyBackProduct("1 oz American Gold Eagle Coin (Random Year)");
		cart.addItemToCart(1);
		cart.selectcheckoutBtn("bottom");
		stu.selectBbPayment("check");
		stu.isSelectNewShippingAddress();
		acc.acctShippingAddress(38);
		stu.continueWithAddress();
		stu.shippingMethod("Use My Own Label");
		chk.completeOrder();
		Assert.assertTrue(Q_JMB_WebElm.xpDisplayed(jmbProps, "chk.ThankYouPage.xp"), "Order number is not display!");
		autobuy.deleteUserAddresses();
	}

    @AfterMethod
    public void tearDown() throws Exception {
       stu.removeCartPageContent();
        Q_JMB_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }

}
