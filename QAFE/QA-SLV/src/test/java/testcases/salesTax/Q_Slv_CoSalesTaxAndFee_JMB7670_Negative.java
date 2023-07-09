package testcases.salesTax;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

//import steps.AccountSteps;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.*;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Controls;
import utils.Q_Slv_Init;

import java.io.IOException;
import java.util.ArrayList;


public class Q_Slv_CoSalesTaxAndFee_JMB7670_Negative extends Q_Slv_Init {
	private Q_Slv_AccountSteps acc = new Q_Slv_AccountSteps();
	private Q_Slv_CheckoutSteps chk = new Q_Slv_CheckoutSteps();
	private Q_Slv_CartSteps cart = new Q_Slv_CartSteps();
	private Q_Slv_AdminSlvSteps adm = new Q_Slv_AdminSlvSteps();
	private boolean hasSalesTax = true;
    private boolean hasStateFee = false;
    private boolean hasShippingTax = false;
    private boolean hasGiftCert = false;
    private String stateFee = "0.27";
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
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee on silver artwork Product Taxable order Registered User
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test (priority = 1)
    public void coloradoSalesTaxNoTaxableProducts_Reg() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        hasSalesTax = false;
        Q_Slv_Controls.testStarted(tcName);
        Q_Slv_AccountSteps.login("acc.login.link.xp", 48);
        cart.productsController(tcName, 1);
        Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp","Cart Login | Silver.com");
        ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.completeOrder();
        chk.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
        ArrayList<Float> myAccountPrices = new ArrayList<>(acc.myAccountPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("My Account", priceList, reviewPrices, myAccountPrices);
        ArrayList<Float> adminPrices = new ArrayList<>(adm.adminOrderPriceList("qa+cosalestax@jmbulllion.com", hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order", priceList, reviewPrices, adminPrices);
        ArrayList<Float> adminInvoicePrices = new ArrayList<>(adm.adminOrderInvoicePriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order Invoice", priceList, reviewPrices, adminInvoicePrices);
        ArrayList<Float> adminClaimInvoicePrices = new ArrayList<>(adm.adminOrderClaimInvoicePriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert, 1));
        chk.compareCheckoutToOtherPageRev("Admin Order Claim Invoice", priceList, reviewPrices, adminClaimInvoicePrices);
    }
    
    
   /*******************************************************************
    * Description: Verifies CO Sales tax & fee on Taxable with CO Shipping Address 
    * and Non-CO Billing Address Registered Order
    * Author: Paul Patterson
    * Status: Complete
    * Ticket: JMB-6375
    * @throws Exception 
    * ***************************************************************/
    @Test (priority = 2)
    public void coloradoSalesTaxAndFeeNonCOShippingAddressAndCOBillingAddress_Reg() throws Exception {
      String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
      hasShippingTax = true;
      Q_Slv_Controls.testStarted(tcName);
      Q_Slv_AccountSteps.login("acc.login.link.xp", 49);
      cart.productsController(tcName, 1);
      Q_Slv_CheckoutSteps.regCheckout("cart.paymentType.CC.id", "cart.proceedToChk.btn.xp","Cart Login | Silver.com");
      Q_Slv_CheckoutSteps.switchCard("visa", "331");
      chk.changeBillingAddressButton();
      chk.clickSelectFirstBillingAddress();
      ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert));
      ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert));
      chk.completeOrder();
      chk.isOrderComplete(tcName);
      ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert));
      chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
      ArrayList<Float> myAccountPrices = new ArrayList<>(acc.myAccountPriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert));
      chk.compareCheckoutToOtherPageRev("My Account", priceList, reviewPrices, myAccountPrices);
      ArrayList<Float> adminPrices = new ArrayList<>(adm.adminOrderPriceList("qa+txsalestax@jmbulllion.com", hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert, 1));
      chk.compareCheckoutToOtherPageRev("Admin Order", priceList, reviewPrices, adminPrices);
      ArrayList<Float> adminInvoicePrices = new ArrayList<>(adm.adminOrderInvoicePriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert, 1));
      chk.compareCheckoutToOtherPageRev("Admin Order Invoice", priceList, reviewPrices, adminInvoicePrices);
      ArrayList<Float> adminClaimInvoicePrices = new ArrayList<>(adm.adminOrderClaimInvoicePriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert, 1));
      chk.compareCheckoutToOtherPageRev("Admin Order Claim Invoice", priceList, reviewPrices, adminClaimInvoicePrices);
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee on silver artwork Product Taxable order Guest User
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test(priority = 3)
    public void coloradoSalesTaxNoTaxableProducts_Guest() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        hasSalesTax = false;
        Q_Slv_Controls.testStarted(tcName);
        cart.productsController(tcName, 1);
        Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
        chk.guestEmail("chk.guest.email.name","qa+COGuestTest@jmbullion.com");
        chk.shippingAutoAddress(36);
        chk.creditCardInput(2);
        ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.completeOrder();
        chk.isOrderComplete(tcName);
        ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee on Taxable with CO Shipping Address 
     * and Non-CO Billing Address Guest Order
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test (priority = 4)
    public void coloradoSalesTaxAndFeeNonCOShippingAddressAndCOBillingAddress_Guest() throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_Slv_Controls.testStarted(tcName);
       hasShippingTax = true;
       cart.productsController(tcName, 1);
       Q_Slv_CheckoutSteps.guestCheckout("cart.paymentType.PC.id", "cart.proceedToChk.btn.xp", "chk.bridge.guest.btn.xp");
       chk.guestEmail("chk.guest.email.name","qa+TXGuestTest@jmbullion.com");
       chk.shippingAutoAddress(6);
       chk.creditCardInput(2);
       chk.verifyBillingAddressField();
       chk.changeBillingAddressButton();
       chk.clickAddNewBillAddress();
       chk.billingAddressForm(36);
       chk.saveBillingAddress();
       ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       chk.completeOrder();
       chk.isOrderComplete(tcName);
       ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
    }
   
    @AfterMethod
	public void tearDown() throws Exception {
    	Q_Slv_CartSteps.emptyCart();
		Q_Slv_Controls.tearDown();
	}
	
	@AfterClass
	public void exitClass(){
	}
}
