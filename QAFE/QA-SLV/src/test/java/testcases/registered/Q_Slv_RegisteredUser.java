package testcases.registered;

//import steps.AccountSteps;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Q_Slv_AccountSteps;
import pageObjects.Q_Slv_AdminSlvSteps;
import pageObjects.Q_Slv_CartSteps;
import pageObjects.Q_Slv_CheckoutSteps;
import pageObjects.Q_Slv_WebElm;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.util.ArrayList;

public class Q_Slv_RegisteredUser extends Q_Slv_Init {
    @BeforeClass
    public void tcSetup (){

    }
    @BeforeMethod
    public void report() throws Exception {
        Q_Slv_Init.setItUp();
    }
    @BeforeTest
    public void setTest() throws Exception {
    }
    
    Q_Slv_AdminSlvSteps admin = new Q_Slv_AdminSlvSteps();
    Q_Slv_CheckoutSteps chk = new Q_Slv_CheckoutSteps();
    
    /*******************************************************************
    // * Description: Turns 3DS off
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 1,enabled=false)
    public void turn3DSOff() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_Controls.adminLogin();
        admin.adminMenu("settings");
        Q_Slv_WebElm.xp(SLVqProp, "adm.settings.subMenu.configSettings.xp");
        admin.adjust3dsSettings("off");
        Q_Slv_WebElm.myWait(1000);
    }
    
    /*******************************************************************
    // * Description: Verifying when user checks out and have items in the cart. When the user logs back in the cart persist.
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 2, enabled = true)
    public void persistentCart() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
        Q_Slv_CartSteps.gold1("1");
        Q_Slv_AccountSteps.logout();
         Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
        Integer cartItems = Integer.valueOf(Q_Slv_WebElm.cnRetText(SLVqProp, "cart.MyCart.className").replaceAll("[^\\d.]", ""));
        Assert.assertTrue(cartItems >= 1);
        
    }
    /*******************************************************************
    // * Description: Verifying when user can login at checkout using the bridge page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 3, enabled = true)
    public void bridgeRegisteredCheckout() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_CartSteps.gold1("1");
        //CartSteps.copper1("10");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp","Cart Login | Silver.com");
        Q_Slv_AccountSteps.bridgeLogin(0);
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
//        CheckoutSteps.completeOrder("sil.finishAndPlace.id");
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        
    }
    /*******************************************************************
    // * Description: Verifying when user can login at checkout using the bridge page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 4, enabled = true)
    public void masterCard() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        Q_Slv_CartSteps.gold3("1");
        //CartSteps.copper1("10");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp","Checkout | Silver.com");
//        CheckoutSteps.newCreditCard();
//        CheckoutSteps.creditCardInput(3);
//        CheckoutSteps.cardType(3, "sil.selected.type.xp", "sil.cvv.xp");
        Q_Slv_CheckoutSteps.switchCard("visa", "331");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        
    }
    /*******************************************************************
    // * Description: Verifying when user can login at checkout using the bridge page
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 5, enabled = true)
    public void ccNoTaxMinShipping() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 22);
        Q_Slv_CartSteps.silver1("25");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.cardType(3, "chk.selected.type.xp", "chk.cvv.xp");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
//        CheckoutSteps.completeOrder("sil.guest.finishAndPlace.id");
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        
    }
    /*******************************************************************
    // * Description: Verifying when orders over $3000.00 base shipping is $0
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 6, enabled = true)
    public void ccTaxNoShipping() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        Q_Slv_CartSteps.gold2("50");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("mc", "331");
//        CheckoutSteps.cardType(3, "sil.selected.type.xp", "sil.cvv.xp");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        
    }
    /*******************************************************************
    // * Description: Verifying user can upgrade shipping of their order
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 7, enabled = true)
    public void ccTaxShippingUpgrade() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 23);
        Q_Slv_CartSteps.silver1("10");
        Q_Slv_CartSteps.copper1("10");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.cardType(3, "chk.selected.type.xp", "chk.cvv.xp");
        Q_Slv_CheckoutSteps.shippingOption("2");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListSh());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
        
    }
    /*******************************************************************
    // * Description: Verifying user can upgrade shipping of their order
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 8, enabled = true)
    public void ccNoTaxShippingUpgrade() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
        Q_Slv_CartSteps.gold2("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
//        CheckoutSteps.newCreditCard();
//        CheckoutSteps.creditCardInput(3);
        Q_Slv_CheckoutSteps.switchCard("mc", "801");

        Q_Slv_CheckoutSteps.shippingOption("3");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        
    }
    /*******************************************************************
    // * Description: Verifying current user with last name Accept orders for this user are in paid status
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 9, enabled = true)
    public void paidOrder() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
        Q_Slv_CartSteps.silver1("2");
        Q_Slv_CartSteps.copper1("10");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        //Q_Slv_CheckoutSteps.newCreditCard();
        //Q_Slv_CheckoutSteps.creditCardInput(5);
        Q_Slv_CheckoutSteps.switchCard("mc", "801");
//        CheckoutSteps.cardType(3, "sil.selected.type.xp", "sil.cvv.xp");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListSh());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 5);
        //Q_Slv_CheckoutSteps.orderStatus("sil.orderNumber.xp","sil.order.top.xp", "sil.order.top.status.xp", "Paid & Awaiting Shipment");
        
    }
    /*******************************************************************
    // * Description: Verifying current user with last name review orders for this user are in pending status
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 10, enabled = true)
    public void pendingOrder() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 27);
        Q_Slv_CartSteps.silver1("10");
        //CartSteps.copper1("10");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
//        CheckoutSteps.newCreditCard();
//        CheckoutSteps.creditCardInput(5);
        Q_Slv_CheckoutSteps.switchCard("amex", "2961");

        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        Q_Slv_CheckoutSteps.orderStatus("chk.orderNumber.xp", "acc.order.top.xp", "acc.order.top.status.xp", "Pending");
        
    }
    /*******************************************************************
    // * Description: Verifying user can edit shipping address during checkout
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 11, enabled = true)
    public void qcCCEditShipping() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
        Q_Slv_CartSteps.gold2("1");
        //CartSteps.copper1("10");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("mc", "363");
        Q_Slv_CheckoutSteps.editShipping("chk.reg.shaddress2.editBtn.xp", "chk.reg.shaddress2.xp",
                "chk.guest.shipping.firstName.id", "chk.guest.shipping.lastName.id");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        
    }
    /*******************************************************************
    // * Description: Verifying current user can switch between shipping addresses during checkout
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 12, enabled = true)
    public void qcCC3SwitchShippingAddress() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
        Q_Slv_CartSteps.silver1("10");
        //CartSteps.copper1("10");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.switchCard("mc", "963");
        Q_Slv_CheckoutSteps.switchAddress("chk.reg.shaddress.Default.name", "chk.reg.shaddress.shAddressAccept.xp", "chk.reg.shaddress.shAddressReview.xp");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        
    }
    /*******************************************************************
    // * Description: Verifying current user can switch between saved credit cards during checkout
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 13, enabled = true)
    public void switchPayment() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 0);
        Q_Slv_CartSteps.copper1("20");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_CheckoutSteps.switchCard("chk.reg.switchedTo.xp", "chk.reg.slectedPayment.name", "chk.reg.inactiveCard1.xp", "chk.reg.inactiveCard2.xp");
        Q_Slv_CheckoutSteps.switchCard("mc", "633");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListSh());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        
    }
    /*******************************************************************
    // * Description: Verifying valid gift certificate can be applied to orders at checkout
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 14, enabled = true)
    public void applyGiftCert() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 0);

        Q_Slv_CartSteps.applyGiftCertificate("100");

        Q_Slv_WebElm.idExecutor(SLVqProp, "cart.paymentType.CC.id");
        Q_Slv_WebElm.myWait(3000);
        Q_Slv_WebElm.xp(SLVqProp, "cart.proceedToChk.couponBtn.xp");

        Q_Slv_CheckoutSteps.switchCard("mc", "963");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListSh());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
        
    }
    /*******************************************************************
    // * Description: Verify user must enter credit card information when using bank wire payment method if there is no saved credit card in their profile
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 15, enabled = true)
    public void bankwireWithoutSavedCC() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 2);
        Q_Slv_CartSteps.silver2("2");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.BW.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "chk.reg.newcard.id"));
        Q_Slv_WebElm.cn(SLVqProp, "chk.guest.reviewOrder.modify.className");
        
    }
    /*******************************************************************
    // * Description: Verify user can complete checkout with bank wire payment method for order over $2k
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 16, enabled = true)
    public void bankwireCheckout() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        Q_Slv_CartSteps.silver2("5");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.BW.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListNoTax());
        Q_Slv_CheckoutSteps.completeOrder();
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListNoTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);

    }
    /*******************************************************************
    // * Description: Verify user must enter credit card information when using paper check payment method if there is no saved credit card in their profile
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 17, enabled = true)
    public void paperCheckWithoutSavedCC() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 2);
        Q_Slv_CartSteps.gold3("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Assert.assertTrue(Q_Slv_WebElm.idEnabled(SLVqProp, "chk.reg.newcard.id"));
//        WebElm.cn(SLVqProp,"sil.guest.reviewOrder.modify.className");

        
    }
    /*******************************************************************
    // * Description: Verify user can complete checkout with paper check payment method.
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 18, enabled = true)
    public void paperCheckout() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 21);
        Q_Slv_CartSteps.gold1("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_WebElm.myWait(3000);
        
    }
    /*******************************************************************
    // * Description: Verify user can complete checkout with electronic check payment method.
    // * Author:
    // * Status: Complete
    //*******************************************************************/
    @Test(priority = 19, enabled = true)
    public void paymentViaACH() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 28);
        Q_Slv_CartSteps.copper2("50");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.EC.id", "cart.proceedToChk.btn.xp", "Checkout | Silver.com");
        Q_Slv_WebElm.xp(SLVqProp, "chk.ach.select.xp");
        Q_Slv_CheckoutSteps.regEcheckForm();
        ArrayList<Float> prices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.revPriceListSh());
        Q_Slv_CheckoutSteps.completeOrder();
        Q_Slv_WebElm.myWait(3000);
        ArrayList<Float> orderPrices = new  ArrayList<Float>(Q_Slv_CheckoutSteps.orderPriceListTax());
        Q_Slv_CheckoutSteps.verifyOrderCharges(prices, orderPrices, 4);
    }
    
    /*******************************************************************
	 * Description: Verifies the correct PDP is launched when product description is
	 * clicked on Thank You page. 
	 * Author: Asfi Khaliq 
	 * Status: Complete 
	 * Ticket: JMB-3594
	 ********************************************************************/
	@Test(priority = 20)
	public void verifyProductTitleOnThankYouPage_registered() throws Exception {
		String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
		Q_Slv_Controls.testStarted(tcName);
		paperCheckout();
		chk.verifyProductDescOnThankYouPage();
	}
	
	/********************************************************************
	 * Description: Verify successful registered order with new billing address
	 * Author: Tamilselvan A
 	 * Status: Complete   
	 * Ticket: JMB-4230
	 * @throws Exception 
	 *******************************************************************/
    @Test(priority = 21,enabled=true)
    public void registerOrderBillingAddress() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 47);
        Q_Slv_WebElm.myWait(2000);
        Q_Slv_Controls.openNewTab();
        Q_Slv_Controls.switchTab(1);	    
        chk.deleteAllExistingCard();
        Q_Slv_Controls.switchTab(0);	    
	    driver.navigate().refresh();
        Q_Slv_CartSteps.gold3("1");
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp","Checkout | Silver.com");
        Q_Slv_CheckoutSteps.newCreditCard();
        Q_Slv_CheckoutSteps.creditCardInput(3);
        chk.verifyBillingAddressField();
        chk.changeBillingAddressButton();
        chk.removeBillAddress();
        Q_Slv_WebElm.myWait(2000);
        chk.clickAddNewBillAddress();
        chk.billingAddressForm(6);
        chk.saveBillingAddress();
        Q_Slv_CheckoutSteps.completeOrder();
    }
	
    @AfterMethod
    public void tearDown() throws Exception {
        Q_Slv_CartSteps.emptyCart();
        Q_Slv_AccountSteps.logout();
        Q_Slv_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }
}
