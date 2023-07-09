package testcases.salesTax;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.*;

import pageObjects.*;
import utils.*;


public class Q_PM_CoSalesTaxAndFee_JMB7670_Negative extends Q_PM_Init {
	private Q_PM_AccountSteps acc = new Q_PM_AccountSteps();
	private Q_PM_CheckoutSteps chk = new Q_PM_CheckoutSteps();
	private Q_PM_CartSteps cart = new Q_PM_CartSteps();
	private Q_PM_AdminPmSteps adm = new Q_PM_AdminPmSteps();
	private boolean hasSalesTax = true;
    private boolean hasStateFee = false;
    private boolean hasShippingTax = false;
    private boolean hasGiftCert = false;
    private String stateFee = "0.27";
    @BeforeClass
    public void tcSetup() {
    }
    @BeforeMethod
    public void report() throws Exception {
        Q_PM_Init.setItUp();
    }
    @BeforeTest
    public void setTest() throws Exception {
    }
    
    /*******************************************************************
     * Description: Verifies CO Sales tax & fee does not appear on non-taxable items registered user
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test (priority = 1)
    public void coloradoSalesTaxNoTaxableProducts_Reg() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        hasSalesTax = false;
        acc.loginUser(51);
        cart.productsController(tcName, 1);
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
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
      Q_PM_Controls.testStarted(tcName);
      acc.loginUser(52);
      cart.productsController(tcName, 1);
      Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
      Q_PM_CheckoutSteps.selectCheckoutBtn("top");
      chk.cardSelection("visa");
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
     * Description: Verifies CO Sales tax & fee does not appear on non-taxable items Guest User
     * Author: Paul Patterson
     * Status: Complete
     * Ticket: JMB-6375
     * @throws Exception 
     * ***************************************************************/
    @Test(priority = 3)
    public void coloradoSalesTaxNoTaxableProducts_Guest() throws Exception {
        String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
        Q_PM_Controls.testStarted(tcName);
        hasSalesTax = false;
        cart.productsController(tcName, 1);
        Q_PM_CheckoutSteps.selectPaymentType("cheque");
        Q_PM_CheckoutSteps.selectCheckoutBtn("top");
        chk.startGuestCheckout();
        chk.guestEmail("qa+COGuestTest123@jmbullion.com");
        chk.shippingForm(36);
        Q_PM_CheckoutSteps.validateAddress();
        chk.creditForm(2);
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
       Q_PM_Controls.testStarted(tcName);
       cart.productsController(tcName, 1);
       Q_PM_CheckoutSteps.selectPaymentType("authorize_net_cim");
       Q_PM_CheckoutSteps.selectCheckoutBtn("top");
       chk.startGuestCheckout();
       chk.guestEmail("qa+TXGuestTest@jmbullion.com");
       chk.shippingForm(6);
       Q_PM_CheckoutSteps.validateAddress();
       chk.creditForm(2);
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
    
    @AfterTest
    public void endReport(){
    }
    @AfterMethod
    public void tearDown() throws Exception {
		Q_PM_CartSteps.deleteItems();
		Q_PM_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }


}
