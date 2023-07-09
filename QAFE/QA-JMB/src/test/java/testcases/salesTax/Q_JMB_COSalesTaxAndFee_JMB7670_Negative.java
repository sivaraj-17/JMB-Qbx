package testcases.salesTax;

import org.testng.annotations.*;
import pageObjects.*;
import utils.Q_JMB_Controls;
import utils.Q_JMB_Init;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

public class Q_JMB_COSalesTaxAndFee_JMB7670_Negative {
	private Q_JMB_AccountObjects acc = new Q_JMB_AccountObjects();
	private Q_JMB_CheckoutObjects chk = new Q_JMB_CheckoutObjects();
	private Q_JMB_CartPageObjects cart = new Q_JMB_CartPageObjects();
	private Q_JMB_ProductPageObjects prod = new Q_JMB_ProductPageObjects();
	private Q_JMB_AdminObjects adm = new Q_JMB_AdminObjects();
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
        Q_JMB_Init.setItUp();
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
        Q_JMB_Controls.testStarted(tcName);
        hasSalesTax = false;
        acc.loginUser(54);
        prod.productsController(tcName, 1);
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.completeOrder();
        chk.thankYouPage();
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
      Q_JMB_Controls.testStarted(tcName);
      hasShippingTax = true;
      acc.loginUser(55);
      prod.productsController(tcName, 1);
      cart.paymentType("cart.paymentType.CC.id");
      cart.selectcheckoutBtn("bottom");
      chk.selectCard("visa", "321");
      chk.changeBillingAddressButton();
      chk.clickSelectFirstBillingAddress();
      ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert));
      ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
      		hasStateFee, hasShippingTax, hasGiftCert));
      chk.completeOrder();
      chk.thankYouPage();
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
        Q_JMB_Controls.testStarted(tcName);
        prod.productsController(tcName, 1);
        hasSalesTax = false;
        cart.paymentType("cart.paymentType.PC.id");
        cart.selectcheckoutBtn("bottom");
        chk.bridgeGuest();
        chk.guestEmail("qa+COGuestTest@jmbullion.com");
        chk.shippingAddressForm(36);
        chk.saveShippingAddress();
        chk.creditCardForm(2);
        ArrayList<String> priceList = new ArrayList <String>(chk.verifyAndReturnCheckoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        ArrayList<Float> reviewPrices = new  ArrayList<Float>(chk.checkoutPriceList(hasSalesTax, 
        		hasStateFee, hasShippingTax, hasGiftCert));
        chk.completeOrder();
        chk.thankYouPage();
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
    public void coloradoSalesTaxAndFeeCOShippingAddressAndNonCOBillingAddress_Guest() throws Exception {
       String tcName = (new Object() {}.getClass().getEnclosingMethod().getName());
       Q_JMB_Controls.testStarted(tcName);
       hasShippingTax = true;
       prod.productsController(tcName, 1);
       cart.paymentType("cart.paymentType.CC.id");
       cart.selectcheckoutBtn("bottom");
       chk.bridgeGuest();
       chk.guestEmail("qa+TXGuestTest@jmbullion.com");
       chk.shippingAddressForm(6);
       chk.saveShippingAddress();
       chk.creditCardForm(2);
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
       chk.thankYouPage();
       ArrayList<Float> orderPrices = new ArrayList<>(chk.thankYouPriceList(hasSalesTax, 
       		hasStateFee, hasShippingTax, hasGiftCert));
       chk.compareCheckoutToOtherPageRev("Thank You", priceList, reviewPrices, orderPrices);
    }
    
    @AfterTest
    public void endReport(){
    }
    @AfterMethod
    public void tearDown() throws Exception {
        Q_JMB_CartPageObjects.removeItems();
        Q_JMB_Controls.tearDown();
    }
    @AfterClass
    public void exitClass(){
        System.out.println("After Class");
    }

}
